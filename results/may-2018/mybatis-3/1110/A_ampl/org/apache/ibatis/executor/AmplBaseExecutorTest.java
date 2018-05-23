package org.apache.ibatis.executor;


import javax.sql.DataSource;
import org.apache.ibatis.BaseDataTest;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.transaction.Transaction;
import org.junit.BeforeClass;


public class AmplBaseExecutorTest extends BaseDataTest {
    protected final Configuration config;

    protected static DataSource ds;

    @BeforeClass
    public static void setup() throws Exception {
        AmplBaseExecutorTest.ds = BaseDataTest.createBlogDataSource();
    }

    public AmplBaseExecutorTest() {
        config = new Configuration();
        config.setLazyLoadingEnabled(true);
        config.setUseGeneratedKeys(false);
        config.setMultipleResultSetsEnabled(true);
        config.setUseColumnLabel(true);
        config.setDefaultStatementTimeout(5000);
        config.setDefaultFetchSize(100);
    }

    protected Executor createExecutor(Transaction transaction) {
        return new SimpleExecutor(config, transaction);
    }
}

