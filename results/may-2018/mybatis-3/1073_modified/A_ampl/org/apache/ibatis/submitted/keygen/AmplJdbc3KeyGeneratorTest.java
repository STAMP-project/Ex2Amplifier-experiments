package org.apache.ibatis.submitted.keygen;


import com.googlecode.catchexception.apis.BDDCatchException;
import java.io.Reader;
import java.sql.Connection;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.assertj.core.api.BDDAssertions;
import org.junit.BeforeClass;
import org.junit.Ignore;
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

    @Ignore("#782 was reverted. See #902.")
    @Test
    public void shouldErrorUndefineProperty() {
        SqlSession sqlSession = AmplJdbc3KeyGeneratorTest.sqlSessionFactory.openSession();
        try {
            CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
            BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("China", "CN"));
            BDDAssertions.then(BDDCatchException.caughtException()).isInstanceOf(PersistenceException.class).hasMessageContaining("### Error updating database.  Cause: org.apache.ibatis.executor.ExecutorException: Error getting generated key or setting result to parameter object. Cause: org.apache.ibatis.executor.ExecutorException: No setter found for the keyProperty 'country_id' in org.apache.ibatis.submitted.keygen.Country.");
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
}

