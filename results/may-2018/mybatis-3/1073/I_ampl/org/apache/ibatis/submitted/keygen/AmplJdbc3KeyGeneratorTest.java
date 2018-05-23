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
    public void shouldErrorUndefinePropertylitString16() throws Exception {
        SqlSession sqlSession = AmplJdbc3KeyGeneratorTest.sqlSessionFactory.openSession();
        try {
            CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
            int o_shouldErrorUndefinePropertylitString16__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("United Kiongdom", "CN"));
            Assert.assertEquals(0, ((int) (o_shouldErrorUndefinePropertylitString16__7)));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test(timeout = 120000)
    public void shouldErrorUndefinePropertylitString17() throws Exception {
        SqlSession sqlSession = AmplJdbc3KeyGeneratorTest.sqlSessionFactory.openSession();
        try {
            CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
            int o_shouldErrorUndefinePropertylitString17__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("China", ""));
            Assert.assertEquals(0, ((int) (o_shouldErrorUndefinePropertylitString17__7)));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test(timeout = 120000)
    public void shouldErrorUndefinePropertylitString18() throws Exception {
        SqlSession sqlSession = AmplJdbc3KeyGeneratorTest.sqlSessionFactory.openSession();
        try {
            CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
            int o_shouldErrorUndefinePropertylitString18__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("China", "\u0000"));
            Assert.assertEquals(0, ((int) (o_shouldErrorUndefinePropertylitString18__7)));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test(timeout = 120000)
    public void shouldErrorUndefinePropertylitString19() throws Exception {
        SqlSession sqlSession = AmplJdbc3KeyGeneratorTest.sqlSessionFactory.openSession();
        try {
            CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
            int o_shouldErrorUndefinePropertylitString19__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("China", "QV5:Wz2[|+"));
            Assert.assertEquals(0, ((int) (o_shouldErrorUndefinePropertylitString19__7)));
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
            int o_shouldErrorUndefinePropertylitString12__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("Chna", "CN"));
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
            int o_shouldErrorUndefinePropertylitString13__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country(":", "CN"));
            Assert.assertEquals(0, ((int) (o_shouldErrorUndefinePropertylitString13__7)));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test(timeout = 120000)
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

    @Test(timeout = 120000)
    public void shouldErrorUndefinePropertylitString14() throws Exception {
        SqlSession sqlSession = AmplJdbc3KeyGeneratorTest.sqlSessionFactory.openSession();
        try {
            CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
            int o_shouldErrorUndefinePropertylitString14__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("GB", "CN"));
            Assert.assertEquals(0, ((int) (o_shouldErrorUndefinePropertylitString14__7)));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test(timeout = 120000)
    public void shouldErrorUndefinePropertylitString15() throws Exception {
        SqlSession sqlSession = AmplJdbc3KeyGeneratorTest.sqlSessionFactory.openSession();
        try {
            CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
            int o_shouldErrorUndefinePropertylitString15__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("US", "CN"));
            Assert.assertEquals(0, ((int) (o_shouldErrorUndefinePropertylitString15__7)));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test(timeout = 120000)
    public void shouldErrorUndefinePropertylitString30() throws Exception {
        SqlSession sqlSession = AmplJdbc3KeyGeneratorTest.sqlSessionFactory.openSession();
        try {
            CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
            int o_shouldErrorUndefinePropertylitString30__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("China", "US"));
            Assert.assertEquals(0, ((int) (o_shouldErrorUndefinePropertylitString30__7)));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test(timeout = 120000)
    public void shouldErrorUndefinePropertylitString31() throws Exception {
        SqlSession sqlSession = AmplJdbc3KeyGeneratorTest.sqlSessionFactory.openSession();
        try {
            CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
            int o_shouldErrorUndefinePropertylitString31__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("China", "United Kiongdom"));
            Assert.assertEquals(0, ((int) (o_shouldErrorUndefinePropertylitString31__7)));
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
            int o_shouldErrorUndefinePropertylitString10__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("China", "CN"));
            Assert.assertEquals(0, ((int) (o_shouldErrorUndefinePropertylitString10__7)));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test(timeout = 120000)
    public void shouldErrorUndefinePropertylitString7() throws Exception {
        SqlSession sqlSession = AmplJdbc3KeyGeneratorTest.sqlSessionFactory.openSession();
        try {
            CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
            int o_shouldErrorUndefinePropertylitString7__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("\n", "CN"));
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
            int o_shouldErrorUndefinePropertylitString8__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("CN", "CN"));
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
            int o_shouldErrorUndefinePropertylitString5__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("org/apache/ibatis/submitted/keygen/CreateDB.sql", "CN"));
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
            int o_shouldErrorUndefinePropertylitString6__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("x*zH_,y(q2", "CN"));
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
            int o_shouldErrorUndefinePropertylitString3__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("org/apache/ibatis/submitted/keygen/MapperConfig.xml", "CN"));
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
            int o_shouldErrorUndefinePropertylitString4__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("United States of America", "CN"));
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
            int o_shouldErrorUndefinePropertylitString2__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("\u0000", "CN"));
            Assert.assertEquals(0, ((int) (o_shouldErrorUndefinePropertylitString2__7)));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test(timeout = 120000)
    public void shouldErrorUndefinePropertylitString27() throws Exception {
        SqlSession sqlSession = AmplJdbc3KeyGeneratorTest.sqlSessionFactory.openSession();
        try {
            CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
            int o_shouldErrorUndefinePropertylitString27__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("China", "China"));
            Assert.assertEquals(0, ((int) (o_shouldErrorUndefinePropertylitString27__7)));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test(timeout = 120000)
    public void shouldErrorUndefinePropertylitString28() throws Exception {
        SqlSession sqlSession = AmplJdbc3KeyGeneratorTest.sqlSessionFactory.openSession();
        try {
            CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
            int o_shouldErrorUndefinePropertylitString28__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("China", ":"));
            Assert.assertEquals(0, ((int) (o_shouldErrorUndefinePropertylitString28__7)));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test(timeout = 120000)
    public void shouldErrorUndefinePropertylitString29() throws Exception {
        SqlSession sqlSession = AmplJdbc3KeyGeneratorTest.sqlSessionFactory.openSession();
        try {
            CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
            int o_shouldErrorUndefinePropertylitString29__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("China", "GB"));
            Assert.assertEquals(0, ((int) (o_shouldErrorUndefinePropertylitString29__7)));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test(timeout = 120000)
    public void shouldErrorUndefinePropertylitString23() throws Exception {
        SqlSession sqlSession = AmplJdbc3KeyGeneratorTest.sqlSessionFactory.openSession();
        try {
            CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
            int o_shouldErrorUndefinePropertylitString23__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("China", "org/apache/ibatis/submitted/keygen/CreateDB.sql"));
            Assert.assertEquals(0, ((int) (o_shouldErrorUndefinePropertylitString23__7)));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test(timeout = 120000)
    public void shouldErrorUndefinePropertylitString24() throws Exception {
        SqlSession sqlSession = AmplJdbc3KeyGeneratorTest.sqlSessionFactory.openSession();
        try {
            CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
            int o_shouldErrorUndefinePropertylitString24__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("China", "\n"));
            Assert.assertEquals(0, ((int) (o_shouldErrorUndefinePropertylitString24__7)));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test(timeout = 120000)
    public void shouldErrorUndefinePropertylitString25() throws Exception {
        SqlSession sqlSession = AmplJdbc3KeyGeneratorTest.sqlSessionFactory.openSession();
        try {
            CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
            int o_shouldErrorUndefinePropertylitString25__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("China", "CN"));
            Assert.assertEquals(0, ((int) (o_shouldErrorUndefinePropertylitString25__7)));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test(timeout = 120000)
    public void shouldErrorUndefinePropertylitString20() throws Exception {
        SqlSession sqlSession = AmplJdbc3KeyGeneratorTest.sqlSessionFactory.openSession();
        try {
            CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
            int o_shouldErrorUndefinePropertylitString20__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("China", "org/apache/ibatis/submitted/keygen/MapperConfig.xml"));
            Assert.assertEquals(0, ((int) (o_shouldErrorUndefinePropertylitString20__7)));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test(timeout = 120000)
    public void shouldErrorUndefinePropertylitString21() throws Exception {
        SqlSession sqlSession = AmplJdbc3KeyGeneratorTest.sqlSessionFactory.openSession();
        try {
            CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
            int o_shouldErrorUndefinePropertylitString21__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("China", "$"));
            Assert.assertEquals(0, ((int) (o_shouldErrorUndefinePropertylitString21__7)));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test(timeout = 120000)
    public void shouldErrorUndefinePropertylitString22() throws Exception {
        SqlSession sqlSession = AmplJdbc3KeyGeneratorTest.sqlSessionFactory.openSession();
        try {
            CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
            int o_shouldErrorUndefinePropertylitString22__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("China", "United States of America"));
            Assert.assertEquals(0, ((int) (o_shouldErrorUndefinePropertylitString22__7)));
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
            int o_shouldErrorUndefinePropertylitString9__7 = BDDCatchException.when(mapper).insertUndefineKeyProperty(new Country("Chi@na", "CN"));
            Assert.assertEquals(0, ((int) (o_shouldErrorUndefinePropertylitString9__7)));
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }
}

