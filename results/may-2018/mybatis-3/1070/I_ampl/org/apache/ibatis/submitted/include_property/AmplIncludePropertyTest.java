package org.apache.ibatis.submitted.include_property;


import java.io.Reader;
import java.sql.Connection;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


public class AmplIncludePropertyTest {
    private static SqlSessionFactory sqlSessionFactory;

    @BeforeClass
    public static void setUp() throws Exception {
        Reader reader = Resources.getResourceAsReader("org/apache/ibatis/submitted/include_property/mybatis-config.xml");
        AmplIncludePropertyTest.sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        reader.close();
        SqlSession session = AmplIncludePropertyTest.sqlSessionFactory.openSession();
        Connection conn = session.getConnection();
        reader = Resources.getResourceAsReader("org/apache/ibatis/submitted/include_property/CreateDB.sql");
        ScriptRunner runner = new ScriptRunner(conn);
        runner.setLogWriter(null);
        runner.runScript(reader);
        conn.close();
        reader.close();
        session.close();
    }

    @Test(timeout = 120000)
    public void testEmptyStringlitNum31247litString31485litNum32620_failAssert1673() throws Exception {
        try {
            final SqlSession sqlSession = AmplIncludePropertyTest.sqlSessionFactory.openSession();
            try {
                List<String> results = sqlSession.selectList("org.apache.ibatis.submitted.include_property.Mapper.selectSimpleA");
                String o_testEmptyStringlitNum31247__7 = results.get((-1));
            } finally {
                sqlSession.close();
            }
            Assert.fail("testEmptyStringlitNum31247litString31485litNum32620 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            Assert.assertEquals("-1", expected.getMessage());
        }
    }

    @Test(timeout = 120000)
    public void testNestedIncludelitNum32litNum642litNum2445_failAssert218() throws Exception {
        try {
            final SqlSession sqlSession = AmplIncludePropertyTest.sqlSessionFactory.openSession();
            try {
                List<String> results = sqlSession.selectList("org.apache.ibatis.submitted.include_property.Mapper.selectNestedInclude");
                String o_testNestedIncludelitNum32__7 = results.get((-1));
            } finally {
                sqlSession.close();
            }
            Assert.fail("testNestedIncludelitNum32litNum642litNum2445 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 120000)
    public void testNestedIncludelitNum31_failAssert22() throws Exception {
        try {
            final SqlSession sqlSession = AmplIncludePropertyTest.sqlSessionFactory.openSession();
            try {
                List<String> results = sqlSession.selectList("org.apache.ibatis.submitted.include_property.Mapper.selectNestedInclude");
                results.get(-2147483648);
            } finally {
                sqlSession.close();
            }
            Assert.fail("testNestedIncludelitNum31 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            Assert.assertEquals("-2147483648", expected.getMessage());
        }
    }

    @Test(timeout = 120000)
    public void testNestedIncludelitNum32litString537litNum2222_failAssert246() throws Exception {
        try {
            final SqlSession sqlSession = AmplIncludePropertyTest.sqlSessionFactory.openSession();
            try {
                List<String> results = sqlSession.selectList("org.apache.ibatis.submitted.include_property.Mapper.selectSimpleA");
                String o_testNestedIncludelitNum32__7 = results.get(-2147483648);
            } finally {
                sqlSession.close();
            }
            Assert.fail("testNestedIncludelitNum32litString537litNum2222 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 120000)
    public void testEmptyStringlitNum31247litNum31503litNum32698_failAssert1684() throws Exception {
        try {
            final SqlSession sqlSession = AmplIncludePropertyTest.sqlSessionFactory.openSession();
            try {
                List<String> results = sqlSession.selectList("org.apache.ibatis.submitted.include_property.Mapper.selectEmptyProperty");
                String o_testEmptyStringlitNum31247__7 = results.get(-2147483648);
            } finally {
                sqlSession.close();
            }
            Assert.fail("testEmptyStringlitNum31247litNum31503litNum32698 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 120000)
    public void testEmptyStringlitString31235litString31613litNum32834_failAssert1701() throws Exception {
        try {
            final SqlSession sqlSession = AmplIncludePropertyTest.sqlSessionFactory.openSession();
            try {
                List<String> results = sqlSession.selectList("org.apache.ibatis.submitted.include_property.Mapper.selectSimpleA");
                String o_testEmptyStringlitString31235__7 = results.get((-1));
            } finally {
                sqlSession.close();
            }
            Assert.fail("testEmptyStringlitString31235litString31613litNum32834 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 120000)
    public void testNestedIncludelitNum32litNum642litNum2448_failAssert240() throws Exception {
        try {
            final SqlSession sqlSession = AmplIncludePropertyTest.sqlSessionFactory.openSession();
            try {
                List<String> results = sqlSession.selectList("org.apache.ibatis.submitted.include_property.Mapper.selectNestedInclude");
                String o_testNestedIncludelitNum32__7 = results.get(-2147483648);
            } finally {
                sqlSession.close();
            }
            Assert.fail("testNestedIncludelitNum32litNum642litNum2448 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 120000)
    public void testConfigVarlitNum6065_failAssert288() throws Exception {
        try {
            final SqlSession sqlSession = AmplIncludePropertyTest.sqlSessionFactory.openSession();
            try {
                List<String> results = sqlSession.selectList("org.apache.ibatis.submitted.include_property.Mapper.selectConfigVar");
                results.get((-1));
            } finally {
                sqlSession.close();
            }
            Assert.fail("testConfigVarlitNum6065 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            Assert.assertEquals("-1", expected.getMessage());
        }
    }

    @Test(timeout = 120000)
    public void testEmptyStringlitNum31247litString31485litNum32626_failAssert1685() throws Exception {
        try {
            final SqlSession sqlSession = AmplIncludePropertyTest.sqlSessionFactory.openSession();
            try {
                List<String> results = sqlSession.selectList("org.apache.ibatis.submitted.include_property.Mapper.selectSimpleA");
                String o_testEmptyStringlitNum31247__7 = results.get(-2147483648);
            } finally {
                sqlSession.close();
            }
            Assert.fail("testEmptyStringlitNum31247litString31485litNum32626 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            Assert.assertEquals("-2147483648", expected.getMessage());
        }
    }

    @Test(timeout = 120000)
    public void testEmptyStringlitNum19474_failAssert40litString19629() throws Exception {
        try {
            final SqlSession sqlSession = AmplIncludePropertyTest.sqlSessionFactory.openSession();
            try {
                List<String> results = sqlSession.selectList("org.apache.ibatis.submitted.include_property.Mapper.selectEmptyProperty");
                results.get(-1);
            } finally {
                sqlSession.close();
            }
            org.junit.Assert.fail("testEmptyStringlitNum19474 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_testEmptyStringlitNum19474_failAssert40litString19629__14 = expected.getMessage();
            Assert.assertEquals("-1", o_testEmptyStringlitNum19474_failAssert40litString19629__14);
        }
    }

    @Test(timeout = 120000)
    public void testEmptyStringlitNum19474_failAssert40litString19674() throws Exception {
        try {
            final SqlSession sqlSession = AmplIncludePropertyTest.sqlSessionFactory.openSession();
            try {
                List<String> results = sqlSession.selectList("org.apache.ibatis.submitted.include_property.Mapper.selectConfigVar");
                results.get(-1);
            } finally {
                sqlSession.close();
            }
            org.junit.Assert.fail("testEmptyStringlitNum19474 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_testEmptyStringlitNum19474_failAssert40litString19674__14 = expected.getMessage();
            Assert.assertEquals("-1", o_testEmptyStringlitNum19474_failAssert40litString19674__14);
        }
    }

    @Test(timeout = 120000)
    public void testEmptyStringlitNum19474_failAssert40litString19705() throws Exception {
        try {
            final SqlSession sqlSession = AmplIncludePropertyTest.sqlSessionFactory.openSession();
            try {
                List<String> results = sqlSession.selectList("org.apache.ibatis.submitted.include_property.Mapper.selectNestedDynamicValue");
                results.get(-1);
            } finally {
                sqlSession.close();
            }
            org.junit.Assert.fail("testEmptyStringlitNum19474 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_testEmptyStringlitNum19474_failAssert40litString19705__14 = expected.getMessage();
            Assert.assertEquals("-1", o_testEmptyStringlitNum19474_failAssert40litString19705__14);
        }
    }

    @Test(timeout = 120000)
    public void testPropertyInRefidlitNum7780_failAssert24litNum8073() throws Exception {
        try {
            final SqlSession sqlSession = AmplIncludePropertyTest.sqlSessionFactory.openSession();
            try {
                List<String> results = sqlSession.selectList("org.apache.ibatis.submitted.include_property.Mapper.selectPropertyInRefid");
                results.get(-2147483648);
            } finally {
                sqlSession.close();
            }
            org.junit.Assert.fail("testPropertyInRefidlitNum7780 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_testPropertyInRefidlitNum7780_failAssert24litNum8073__14 = expected.getMessage();
            Assert.assertEquals("-2147483648", o_testPropertyInRefidlitNum7780_failAssert24litNum8073__14);
        }
    }

    @Test(timeout = 120000)
    public void testPropertyInRefidlitNum7780_failAssert24litNum8078() throws Exception {
        try {
            final SqlSession sqlSession = AmplIncludePropertyTest.sqlSessionFactory.openSession();
            try {
                List<String> results = sqlSession.selectList("org.apache.ibatis.submitted.include_property.Mapper.selectPropertyInRefid");
                results.get(-2);
            } finally {
                sqlSession.close();
            }
            org.junit.Assert.fail("testPropertyInRefidlitNum7780 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_testPropertyInRefidlitNum7780_failAssert24litNum8078__14 = expected.getMessage();
            Assert.assertEquals("-2", o_testPropertyInRefidlitNum7780_failAssert24litNum8078__14);
        }
    }
}

