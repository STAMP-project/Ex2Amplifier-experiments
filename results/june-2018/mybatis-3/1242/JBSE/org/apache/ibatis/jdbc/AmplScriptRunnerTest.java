package org.apache.ibatis.jdbc;


import BaseDataTest.JPETSTORE_DATA;
import BaseDataTest.JPETSTORE_DDL;
import BaseDataTest.JPETSTORE_PROPERTIES;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.apache.ibatis.BaseDataTest;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;


public class AmplScriptRunnerTest extends BaseDataTest {
    private static final String LINE_SEPARATOR = System.getProperty("line.separator", "\n");

    @Test
    @Ignore("This fails with HSQLDB 2.0 due to the create index statements in the schema script")
    public void shouldRunScriptsBySendingFullScriptAtOnce() throws Exception {
        DataSource ds = BaseDataTest.createUnpooledDataSource(JPETSTORE_PROPERTIES);
        Connection conn = ds.getConnection();
        ScriptRunner runner = new ScriptRunner(conn);
        runner.setSendFullScript(true);
        runner.setAutoCommit(true);
        runner.setStopOnError(false);
        runner.setErrorLogWriter(null);
        runner.setLogWriter(null);
        conn.close();
        runJPetStoreScripts(runner);
        assertProductsTableExistsAndLoaded();
    }

    private void runJPetStoreScripts(ScriptRunner runner) throws IOException, SQLException {
        BaseDataTest.runScript(runner, JPETSTORE_DDL);
        BaseDataTest.runScript(runner, JPETSTORE_DATA);
    }

    private void assertProductsTableExistsAndLoaded() throws IOException, SQLException {
        PooledDataSource ds = BaseDataTest.createPooledDataSource(JPETSTORE_PROPERTIES);
        try {
            Connection conn = ds.getConnection();
            SqlRunner executor = new SqlRunner(conn);
            List<Map<String, Object>> products = executor.selectAll("SELECT * FROM PRODUCT");
            Assert.assertEquals(16, products.size());
            conn.close();
        } finally {
            ds.forceCloseAll();
        }
    }

    private StringBuilder y(StringBuilder sb) {
        sb.append("ABC");
        return sb;
    }
}

