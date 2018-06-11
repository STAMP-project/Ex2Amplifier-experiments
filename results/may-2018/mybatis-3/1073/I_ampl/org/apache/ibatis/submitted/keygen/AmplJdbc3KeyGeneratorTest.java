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

    @Test(timeout = 120000)
    public void shouldErrorUndefinePropertylitString7() throws Exception {
        SqlSession sqlSession = AmplJdbc3KeyGeneratorTest.sqlSessionFactory.openSession();
        try {
            CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
            int o_shouldErrorUndefinePropertylitString7__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("dhscb", "CN"));
            Assert.assertEquals(0, ((int) (o_shouldErrorUndefinePropertylitString7__7)));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test(timeout = 120000)
    public void shouldErrorUndefinePropertylitString8() throws Exception {
        SqlSession sqlSession = AmplJdbc3KeyGeneratorTest.sqlSessionFactory.openSession();
        try {
            CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
            int o_shouldErrorUndefinePropertylitString8__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("US", "CN"));
            Assert.assertEquals(0, ((int) (o_shouldErrorUndefinePropertylitString8__7)));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test(timeout = 120000)
    public void shouldErrorUndefinePropertylitString5() throws Exception {
        SqlSession sqlSession = AmplJdbc3KeyGeneratorTest.sqlSessionFactory.openSession();
        try {
            CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
            int o_shouldErrorUndefinePropertylitString5__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country(":", "CN"));
            Assert.assertEquals(0, ((int) (o_shouldErrorUndefinePropertylitString5__7)));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test(timeout = 120000)
    public void shouldErrorUndefinePropertylitString6() throws Exception {
        SqlSession sqlSession = AmplJdbc3KeyGeneratorTest.sqlSessionFactory.openSession();
        try {
            CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
            int o_shouldErrorUndefinePropertylitString6__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("C,hina", "CN"));
            Assert.assertEquals(0, ((int) (o_shouldErrorUndefinePropertylitString6__7)));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test(timeout = 120000)
    public void shouldErrorUndefinePropertylitString3() throws Exception {
        SqlSession sqlSession = AmplJdbc3KeyGeneratorTest.sqlSessionFactory.openSession();
        try {
            CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
            int o_shouldErrorUndefinePropertylitString3__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("Cina", "CN"));
            Assert.assertEquals(0, ((int) (o_shouldErrorUndefinePropertylitString3__7)));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test(timeout = 120000)
    public void shouldErrorUndefinePropertylitString4() throws Exception {
        SqlSession sqlSession = AmplJdbc3KeyGeneratorTest.sqlSessionFactory.openSession();
        try {
            CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
            int o_shouldErrorUndefinePropertylitString4__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("\n", "CN"));
            Assert.assertEquals(0, ((int) (o_shouldErrorUndefinePropertylitString4__7)));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test(timeout = 120000)
    public void shouldErrorUndefinePropertylitString1() throws Exception {
        SqlSession sqlSession = AmplJdbc3KeyGeneratorTest.sqlSessionFactory.openSession();
        try {
            CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
            int o_shouldErrorUndefinePropertylitString1__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("", "CN"));
            Assert.assertEquals(0, ((int) (o_shouldErrorUndefinePropertylitString1__7)));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test(timeout = 120000)
    public void shouldErrorUndefinePropertylitString2() throws Exception {
        SqlSession sqlSession = AmplJdbc3KeyGeneratorTest.sqlSessionFactory.openSession();
        try {
            CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
            int o_shouldErrorUndefinePropertylitString2__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("Chkna", "CN"));
            Assert.assertEquals(0, ((int) (o_shouldErrorUndefinePropertylitString2__7)));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test(timeout = 120000)
    public void shouldErrorUndefinePropertylitString12() throws Exception {
        SqlSession sqlSession = AmplJdbc3KeyGeneratorTest.sqlSessionFactory.openSession();
        try {
            CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
            int o_shouldErrorUndefinePropertylitString12__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("China", ":"));
            Assert.assertEquals(0, ((int) (o_shouldErrorUndefinePropertylitString12__7)));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test(timeout = 120000)
    public void shouldErrorUndefinePropertylitString13() throws Exception {
        SqlSession sqlSession = AmplJdbc3KeyGeneratorTest.sqlSessionFactory.openSession();
        try {
            CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
            int o_shouldErrorUndefinePropertylitString13__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("China", "US"));
            Assert.assertEquals(0, ((int) (o_shouldErrorUndefinePropertylitString13__7)));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test(timeout = 120000)
    public void shouldErrorUndefinePropertylitString10() throws Exception {
        SqlSession sqlSession = AmplJdbc3KeyGeneratorTest.sqlSessionFactory.openSession();
        try {
            CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
            int o_shouldErrorUndefinePropertylitString10__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("China", "S"));
            Assert.assertEquals(0, ((int) (o_shouldErrorUndefinePropertylitString10__7)));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test(timeout = 120000)
    public void shouldErrorUndefinePropertylitString11() throws Exception {
        SqlSession sqlSession = AmplJdbc3KeyGeneratorTest.sqlSessionFactory.openSession();
        try {
            CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
            int o_shouldErrorUndefinePropertylitString11__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("China", "\n"));
            Assert.assertEquals(0, ((int) (o_shouldErrorUndefinePropertylitString11__7)));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test(timeout = 120000)
    public void shouldErrorUndefinePropertylitString9() throws Exception {
        SqlSession sqlSession = AmplJdbc3KeyGeneratorTest.sqlSessionFactory.openSession();
        try {
            CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
            int o_shouldErrorUndefinePropertylitString9__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("China", ""));
            Assert.assertEquals(0, ((int) (o_shouldErrorUndefinePropertylitString9__7)));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
}

