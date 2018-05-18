package org.apache.ibatis.submitted.keygen;


import com.googlecode.catchexception.apis.BDDCatchException;
import java.io.Reader;
import java.sql.Connection;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class AmplJdbc3KeyGeneratorTest {
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void setUp() throws Exception {
        Reader reader = Resources.getResourceAsReader("org/apache/ibatis/submitted/keygen/MapperConfig.xml");
        AmplJdbc3KeyGeneratorTest.sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();
        SqlSession session = AmplJdbc3KeyGeneratorTest.sqlSessionFactory.openSession();
        Connection conn = session.getConnection();
        reader = Resources.getResourceAsReader("org/apache/ibatis/submitted/keygen/CreateDB.sql");
        ScriptRunner runner = new ScriptRunner(conn);
        runner.setLogWriter(null);
        runner.runScript(reader);
        conn.close();
        reader.close();
        session.close();
    }

    @Test(timeout = 10000)
    public void shouldErrorUndefineProperty() throws Exception {
        SqlSession sqlSession = AmplJdbc3KeyGeneratorTest.sqlSessionFactory.openSession();
        try {
            CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
            int o_shouldErrorUndefineProperty__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("China", "CN"));
            Assert.assertEquals(0, ((int) (o_shouldErrorUndefineProperty__7)));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
}

