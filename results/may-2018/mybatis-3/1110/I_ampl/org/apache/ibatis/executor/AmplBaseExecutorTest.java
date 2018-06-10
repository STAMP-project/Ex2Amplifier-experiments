package org.apache.ibatis.executor;


import Executor.NO_RESULT_HANDLER;
import RowBounds.DEFAULT;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.apache.ibatis.BaseDataTest;
import org.apache.ibatis.domain.blog.Author;
import org.apache.ibatis.domain.blog.Blog;
import org.apache.ibatis.domain.blog.Post;
import org.apache.ibatis.domain.blog.Section;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.jdbc.JdbcTransaction;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static BatchExecutor.BATCH_UPDATE_RETURN_VALUE;


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

    @Test(timeout = 120000)
    public void shouldSelectAllAuthorsAutoMappedlitBool66847litBool66920litNum67098_failAssert574() throws Exception {
        try {
            Executor executor = createExecutor(new JdbcTransaction(AmplBaseExecutorTest.ds, null, true));
            flushStatements().isEmpty();
            ((Connection) (getConnection())).getTypeMap().isEmpty();
            ((Connection) (getConnection())).getClientInfo().isEmpty();
            boolean o_shouldSelectAllAuthorsAutoMappedlitBool66847litBool66920__4 = flushStatements().isEmpty();
            boolean o_shouldSelectAllAuthorsAutoMappedlitBool66847litBool66920__5 = ((Connection) (getConnection())).getTypeMap().isEmpty();
            boolean o_shouldSelectAllAuthorsAutoMappedlitBool66847litBool66920__6 = ((Connection) (getConnection())).getClientInfo().isEmpty();
            try {
                MappedStatement selectStatement = ExecutorTestHelper.prepareSelectAllAuthorsAutoMappedStatement(this.config);
                List<Author> authors = executor.query(selectStatement, null, DEFAULT, NO_RESULT_HANDLER);
                int o_shouldSelectAllAuthorsAutoMappedlitBool66847__10 = authors.size();
                Author author = authors.get(-2147483648);
                int o_shouldSelectAllAuthorsAutoMappedlitBool66847__13 = author.getId();
                String o_shouldSelectAllAuthorsAutoMappedlitBool66847__14 = author.getUsername();
                String o_shouldSelectAllAuthorsAutoMappedlitBool66847__15 = author.getEmail();
                String o_shouldSelectAllAuthorsAutoMappedlitBool66847__16 = author.getBio();
                Section o_shouldSelectAllAuthorsAutoMappedlitBool66847__17 = author.getFavouriteSection();
            } finally {
                executor.rollback(false);
                executor.close(false);
            }
            Assert.fail("shouldSelectAllAuthorsAutoMappedlitBool66847litBool66920litNum67098 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 120000)
    public void shouldInsertNewAuthorlitNum119905_failAssert1362litNum120227() throws Exception {
        try {
            Executor executor = createExecutor(new JdbcTransaction(AmplBaseExecutorTest.ds, null, false));
            Assert.assertTrue(flushStatements().isEmpty());
            Assert.assertFalse(((Connection) (getConnection())).isClosed());
            Assert.assertNull(getTimeout());
            Assert.assertFalse(isClosed());
            Assert.assertTrue(((Connection) (getConnection())).getTypeMap().isEmpty());
            Assert.assertFalse(((Connection) (getConnection())).isReadOnly());
            Assert.assertEquals(2, ((int) (((Connection) (getConnection())).getTransactionIsolation())));
            Assert.assertFalse(((Connection) (getConnection())).getAutoCommit());
            Assert.assertEquals(1, ((int) (((Connection) (getConnection())).getHoldability())));
            Assert.assertEquals("APP", ((Connection) (getConnection())).getSchema());
            Assert.assertNull(((Connection) (getConnection())).getCatalog());
            Assert.assertTrue(((Connection) (getConnection())).getClientInfo().isEmpty());
            try {
                Author author = new Author(0, "someone", "******", "someone@apache.org", null, Section.NEWS);
                MappedStatement insertStatement = ExecutorTestHelper.prepareInsertAuthorMappedStatement(this.config);
                MappedStatement selectStatement = ExecutorTestHelper.prepareSelectOneAuthorMappedStatement(this.config);
                int rows = executor.update(insertStatement, author);
                List<Author> authors = executor.query(selectStatement, 99, DEFAULT, NO_RESULT_HANDLER);
                List<BatchResult> o_shouldInsertNewAuthorlitNum119905_failAssert1362litNum120227__18 = executor.flushStatements();
                Assert.assertTrue(o_shouldInsertNewAuthorlitNum119905_failAssert1362litNum120227__18.isEmpty());
                executor.rollback(true);
                int o_shouldInsertNewAuthorlitNum119905_failAssert1362litNum120227__20 = authors.size();
                Assert.assertEquals(1, ((int) (o_shouldInsertNewAuthorlitNum119905_failAssert1362litNum120227__20)));
                String o_shouldInsertNewAuthorlitNum119905_failAssert1362litNum120227__21 = author.toString();
                Assert.assertEquals("Author : 0 : someone : someone@apache.org", o_shouldInsertNewAuthorlitNum119905_failAssert1362litNum120227__21);
                authors.get((-1)).toString();
                boolean boolean_516 = (1 == rows) || ((BATCH_UPDATE_RETURN_VALUE) == rows);
            } finally {
                executor.rollback(true);
                executor.close(false);
            }
            Assert.fail("shouldInsertNewAuthorlitNum119905 should have thrown IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException expected) {
            expected.getMessage();
        }
    }

    @Test(timeout = 120000)
    public void shouldFetchComplexBlogslitBool71394litBool72030litNum76306_failAssert980() throws Exception {
        try {
            Executor executor = createExecutor(new JdbcTransaction(AmplBaseExecutorTest.ds, null, false));
            flushStatements().isEmpty();
            ((Connection) (getConnection())).getTypeMap().isEmpty();
            ((Connection) (getConnection())).getClientInfo().isEmpty();
            boolean o_shouldFetchComplexBlogslitBool71394litBool72030__4 = flushStatements().isEmpty();
            boolean o_shouldFetchComplexBlogslitBool71394litBool72030__5 = ((Connection) (getConnection())).getTypeMap().isEmpty();
            boolean o_shouldFetchComplexBlogslitBool71394litBool72030__6 = ((Connection) (getConnection())).getClientInfo().isEmpty();
            try {
                MappedStatement selectBlog = ExecutorTestHelper.prepareComplexSelectBlogMappedStatement(this.config);
                MappedStatement selectPosts = ExecutorTestHelper.prepareSelectPostsForBlogMappedStatement(this.config);
                this.config.addMappedStatement(selectBlog);
                this.config.addMappedStatement(selectPosts);
                List<Blog> blogs = executor.query(selectBlog, 1, DEFAULT, NO_RESULT_HANDLER);
                List<BatchResult> o_shouldFetchComplexBlogslitBool71394__14 = executor.flushStatements();
                boolean o_shouldFetchComplexBlogslitBool71394litBool72030__20 = o_shouldFetchComplexBlogslitBool71394__14.isEmpty();
                int o_shouldFetchComplexBlogslitBool71394__15 = blogs.size();
                List<Post> o_shouldFetchComplexBlogslitBool71394__16 = blogs.get(0).getPosts();
                int o_shouldFetchComplexBlogslitBool71394__18 = blogs.get(-2147483648).getPosts().size();
                int o_shouldFetchComplexBlogslitBool71394__21 = blogs.get(0).getPosts().get(1).getBlog().getPosts().get(1).getBlog().getId();
                executor.rollback(false);
                boolean o_shouldFetchComplexBlogslitBool71394litBool72030__44 = o_shouldFetchComplexBlogslitBool71394__14.isEmpty();
                boolean o_shouldFetchComplexBlogslitBool71394litBool72030__45 = o_shouldFetchComplexBlogslitBool71394__14.isEmpty();
            } finally {
                executor.rollback(true);
                executor.close(true);
            }
            Assert.fail("shouldFetchComplexBlogslitBool71394litBool72030litNum76306 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 120000)
    public void shouldClearDeferredLoads() throws Exception {
        Executor executor = createExecutor(new JdbcTransaction(AmplBaseExecutorTest.ds, null, false));
        Assert.assertFalse(((Connection) (getConnection())).isClosed());
        Assert.assertTrue(flushStatements().isEmpty());
        Assert.assertNull(getTimeout());
        Assert.assertFalse(isClosed());
        Assert.assertTrue(((Connection) (getConnection())).getTypeMap().isEmpty());
        Assert.assertFalse(((Connection) (getConnection())).isReadOnly());
        Assert.assertEquals(2, ((int) (((Connection) (getConnection())).getTransactionIsolation())));
        Assert.assertFalse(((Connection) (getConnection())).getAutoCommit());
        Assert.assertEquals(1, ((int) (((Connection) (getConnection())).getHoldability())));
        Assert.assertEquals("APP", ((Connection) (getConnection())).getSchema());
        Assert.assertNull(((Connection) (getConnection())).getCatalog());
        Assert.assertTrue(((Connection) (getConnection())).getClientInfo().isEmpty());
        try {
            MappedStatement selectBlog = ExecutorTestHelper.prepareComplexSelectBlogMappedStatement(this.config);
            MappedStatement selectPosts = ExecutorTestHelper.prepareSelectPostsForBlogMappedStatement(this.config);
            this.config.addMappedStatement(selectBlog);
            this.config.addMappedStatement(selectPosts);
            MappedStatement selectAuthor = ExecutorTestHelper.prepareSelectOneAuthorMappedStatement(this.config);
            MappedStatement insertAuthor = ExecutorTestHelper.prepareInsertAuthorMappedStatement(this.config);
            List<Object> o_shouldClearDeferredLoads__16 = executor.query(selectPosts, 1, DEFAULT, NO_RESULT_HANDLER);
            Assert.assertFalse(((ArrayList) (o_shouldClearDeferredLoads__16)).isEmpty());
            Assert.assertEquals(2, ((int) (((ArrayList) (o_shouldClearDeferredLoads__16)).size())));
            Author author = new Author((-1), "someone", "******", "someone@apache.org", null, Section.NEWS);
            int o_shouldClearDeferredLoads__21 = executor.update(insertAuthor, author);
            Assert.assertEquals(1, ((int) (o_shouldClearDeferredLoads__21)));
            List<Object> o_shouldClearDeferredLoads__22 = executor.query(selectAuthor, (-1), DEFAULT, NO_RESULT_HANDLER);
            Assert.assertEquals("[Author : -1 : someone : someone@apache.org]", ((ArrayList) (o_shouldClearDeferredLoads__22)).toString());
            Assert.assertEquals((-1603122762), ((int) (((ArrayList) (o_shouldClearDeferredLoads__22)).hashCode())));
            Assert.assertFalse(((ArrayList) (o_shouldClearDeferredLoads__22)).isEmpty());
            Assert.assertEquals(1, ((int) (((ArrayList) (o_shouldClearDeferredLoads__22)).size())));
            List<BatchResult> o_shouldClearDeferredLoads__24 = executor.flushStatements();
            Assert.assertTrue(o_shouldClearDeferredLoads__24.isEmpty());
            executor.rollback(true);
            Assert.assertEquals("[Author : -1 : someone : someone@apache.org]", ((ArrayList) (o_shouldClearDeferredLoads__22)).toString());
            Assert.assertEquals((-1603122762), ((int) (((ArrayList) (o_shouldClearDeferredLoads__22)).hashCode())));
            Assert.assertFalse(((ArrayList) (o_shouldClearDeferredLoads__22)).isEmpty());
            Assert.assertEquals(1, ((int) (((ArrayList) (o_shouldClearDeferredLoads__22)).size())));
            Assert.assertTrue(o_shouldClearDeferredLoads__24.isEmpty());
            Assert.assertEquals(1, ((int) (o_shouldClearDeferredLoads__21)));
            Assert.assertFalse(((ArrayList) (o_shouldClearDeferredLoads__16)).isEmpty());
            Assert.assertEquals("[Post: 1 : Corn nuts : I think if I never smelled another corn nut it would be too soon... : NEWS : Wed Dec 05 00:00:00 CET 2007 (null) (null), Post: 2 : Paul Hogan on Toy Dogs : That\'s not a dog.  THAT\'s a dog! : VIDEOS : Sat Jan 12 00:00:00 CET 2008 (null) (null)]", ((ArrayList) (o_shouldClearDeferredLoads__16)).toString());
            Assert.assertEquals(2, ((int) (((ArrayList) (o_shouldClearDeferredLoads__16)).size())));
        } finally {
            executor.rollback(true);
            executor.close(false);
        }
        Assert.assertTrue(isClosed());
    }

    @Test(timeout = 120000)
    public void shouldFetchComplexBlogslitBool71391litNum71966_failAssert707() throws Exception {
        try {
            Executor executor = createExecutor(new JdbcTransaction(AmplBaseExecutorTest.ds, null, true));
            flushStatements().isEmpty();
            ((Connection) (getConnection())).getTypeMap().isEmpty();
            ((Connection) (getConnection())).getClientInfo().isEmpty();
            try {
                MappedStatement selectBlog = ExecutorTestHelper.prepareComplexSelectBlogMappedStatement(this.config);
                MappedStatement selectPosts = ExecutorTestHelper.prepareSelectPostsForBlogMappedStatement(this.config);
                this.config.addMappedStatement(selectBlog);
                this.config.addMappedStatement(selectPosts);
                List<Blog> blogs = executor.query(selectBlog, 1, DEFAULT, NO_RESULT_HANDLER);
                List<BatchResult> o_shouldFetchComplexBlogslitBool71391__14 = executor.flushStatements();
                o_shouldFetchComplexBlogslitBool71391__14.isEmpty();
                int o_shouldFetchComplexBlogslitBool71391__15 = blogs.size();
                List<Post> o_shouldFetchComplexBlogslitBool71391__16 = blogs.get(0).getPosts();
                int o_shouldFetchComplexBlogslitBool71391__18 = blogs.get(0).getPosts().size();
                int o_shouldFetchComplexBlogslitBool71391__21 = blogs.get(0).getPosts().get(1).getBlog().getPosts().get(-2147483648).getBlog().getId();
                executor.rollback(true);
                o_shouldFetchComplexBlogslitBool71391__14.isEmpty();
                o_shouldFetchComplexBlogslitBool71391__14.isEmpty();
            } finally {
                executor.rollback(true);
                executor.close(false);
            }
            Assert.fail("shouldFetchComplexBlogslitBool71391litNum71966 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 120000)
    public void shouldInsertNewAuthorlitNum119905_failAssert1362litNum120237() throws Exception {
        try {
            Executor executor = createExecutor(new JdbcTransaction(AmplBaseExecutorTest.ds, null, false));
            Assert.assertTrue(flushStatements().isEmpty());
            Assert.assertFalse(((Connection) (getConnection())).isClosed());
            Assert.assertNull(getTimeout());
            Assert.assertFalse(isClosed());
            Assert.assertTrue(((Connection) (getConnection())).getTypeMap().isEmpty());
            Assert.assertFalse(((Connection) (getConnection())).isReadOnly());
            Assert.assertEquals(2, ((int) (((Connection) (getConnection())).getTransactionIsolation())));
            Assert.assertFalse(((Connection) (getConnection())).getAutoCommit());
            Assert.assertEquals(1, ((int) (((Connection) (getConnection())).getHoldability())));
            Assert.assertEquals("APP", ((Connection) (getConnection())).getSchema());
            Assert.assertNull(((Connection) (getConnection())).getCatalog());
            Assert.assertTrue(((Connection) (getConnection())).getClientInfo().isEmpty());
            try {
                Author author = new Author(0, "someone", "******", "someone@apache.org", null, Section.NEWS);
                MappedStatement insertStatement = ExecutorTestHelper.prepareInsertAuthorMappedStatement(this.config);
                MappedStatement selectStatement = ExecutorTestHelper.prepareSelectOneAuthorMappedStatement(this.config);
                int rows = executor.update(insertStatement, author);
                List<Author> authors = executor.query(selectStatement, 99, DEFAULT, NO_RESULT_HANDLER);
                List<BatchResult> o_shouldInsertNewAuthorlitNum119905_failAssert1362litNum120237__18 = executor.flushStatements();
                Assert.assertTrue(o_shouldInsertNewAuthorlitNum119905_failAssert1362litNum120237__18.isEmpty());
                executor.rollback(true);
                int o_shouldInsertNewAuthorlitNum119905_failAssert1362litNum120237__20 = authors.size();
                Assert.assertEquals(1, ((int) (o_shouldInsertNewAuthorlitNum119905_failAssert1362litNum120237__20)));
                String o_shouldInsertNewAuthorlitNum119905_failAssert1362litNum120237__21 = author.toString();
                Assert.assertEquals("Author : 0 : someone : someone@apache.org", o_shouldInsertNewAuthorlitNum119905_failAssert1362litNum120237__21);
                authors.get(1).toString();
                boolean boolean_516 = (1 == rows) || ((BATCH_UPDATE_RETURN_VALUE) == rows);
            } finally {
                executor.rollback(true);
                executor.close(false);
            }
            Assert.fail("shouldInsertNewAuthorlitNum119905 should have thrown IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException expected) {
            String o_shouldInsertNewAuthorlitNum119905_failAssert1362litNum120237__30 = expected.getMessage();
            Assert.assertEquals("Index: 1, Size: 1", o_shouldInsertNewAuthorlitNum119905_failAssert1362litNum120237__30);
        }
    }

    @Test(timeout = 120000)
    public void shouldSelectAllAuthorsAutoMappedlitBool66847litBool66922litNum67354_failAssert583() throws Exception {
        try {
            Executor executor = createExecutor(new JdbcTransaction(AmplBaseExecutorTest.ds, null, false));
            flushStatements().isEmpty();
            ((Connection) (getConnection())).getTypeMap().isEmpty();
            ((Connection) (getConnection())).getClientInfo().isEmpty();
            boolean o_shouldSelectAllAuthorsAutoMappedlitBool66847litBool66922__4 = flushStatements().isEmpty();
            boolean o_shouldSelectAllAuthorsAutoMappedlitBool66847litBool66922__5 = ((Connection) (getConnection())).getTypeMap().isEmpty();
            boolean o_shouldSelectAllAuthorsAutoMappedlitBool66847litBool66922__6 = ((Connection) (getConnection())).getClientInfo().isEmpty();
            try {
                MappedStatement selectStatement = ExecutorTestHelper.prepareSelectAllAuthorsAutoMappedStatement(this.config);
                List<Author> authors = executor.query(selectStatement, null, DEFAULT, NO_RESULT_HANDLER);
                int o_shouldSelectAllAuthorsAutoMappedlitBool66847__10 = authors.size();
                Author author = authors.get((-1));
                int o_shouldSelectAllAuthorsAutoMappedlitBool66847__13 = author.getId();
                String o_shouldSelectAllAuthorsAutoMappedlitBool66847__14 = author.getUsername();
                String o_shouldSelectAllAuthorsAutoMappedlitBool66847__15 = author.getEmail();
                String o_shouldSelectAllAuthorsAutoMappedlitBool66847__16 = author.getBio();
                Section o_shouldSelectAllAuthorsAutoMappedlitBool66847__17 = author.getFavouriteSection();
            } finally {
                executor.rollback(false);
                executor.close(true);
            }
            Assert.fail("shouldSelectAllAuthorsAutoMappedlitBool66847litBool66922litNum67354 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 120000)
    public void shouldFetchComplexBlogslitBool71392litBool72176litNum75787_failAssert889() throws Exception {
        try {
            Executor executor = createExecutor(new JdbcTransaction(AmplBaseExecutorTest.ds, null, false));
            flushStatements().isEmpty();
            ((Connection) (getConnection())).getTypeMap().isEmpty();
            ((Connection) (getConnection())).getClientInfo().isEmpty();
            boolean o_shouldFetchComplexBlogslitBool71392litBool72176__4 = flushStatements().isEmpty();
            boolean o_shouldFetchComplexBlogslitBool71392litBool72176__5 = ((Connection) (getConnection())).getTypeMap().isEmpty();
            boolean o_shouldFetchComplexBlogslitBool71392litBool72176__6 = ((Connection) (getConnection())).getClientInfo().isEmpty();
            try {
                MappedStatement selectBlog = ExecutorTestHelper.prepareComplexSelectBlogMappedStatement(this.config);
                MappedStatement selectPosts = ExecutorTestHelper.prepareSelectPostsForBlogMappedStatement(this.config);
                this.config.addMappedStatement(selectBlog);
                this.config.addMappedStatement(selectPosts);
                List<Blog> blogs = executor.query(selectBlog, 1, DEFAULT, NO_RESULT_HANDLER);
                List<BatchResult> o_shouldFetchComplexBlogslitBool71392__14 = executor.flushStatements();
                boolean o_shouldFetchComplexBlogslitBool71392litBool72176__20 = o_shouldFetchComplexBlogslitBool71392__14.isEmpty();
                int o_shouldFetchComplexBlogslitBool71392__15 = blogs.size();
                List<Post> o_shouldFetchComplexBlogslitBool71392__16 = blogs.get(0).getPosts();
                int o_shouldFetchComplexBlogslitBool71392__18 = blogs.get(0).getPosts().size();
                int o_shouldFetchComplexBlogslitBool71392__21 = blogs.get(-2147483648).getPosts().get(1).getBlog().getPosts().get(1).getBlog().getId();
                executor.rollback(false);
                boolean o_shouldFetchComplexBlogslitBool71392litBool72176__44 = o_shouldFetchComplexBlogslitBool71392__14.isEmpty();
                boolean o_shouldFetchComplexBlogslitBool71392litBool72176__45 = o_shouldFetchComplexBlogslitBool71392__14.isEmpty();
            } finally {
                executor.rollback(true);
                executor.close(true);
            }
            Assert.fail("shouldFetchComplexBlogslitBool71392litBool72176litNum75787 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 120000)
    public void shouldInsertNewAuthorByProclitNum124975litNum125220() throws Exception {
        Executor executor = createExecutor(new JdbcTransaction(AmplBaseExecutorTest.ds, null, false));
        Assert.assertTrue(flushStatements().isEmpty());
        Assert.assertFalse(((Connection) (getConnection())).isClosed());
        Assert.assertNull(getTimeout());
        Assert.assertFalse(isClosed());
        Assert.assertTrue(((Connection) (getConnection())).getTypeMap().isEmpty());
        Assert.assertFalse(((Connection) (getConnection())).isReadOnly());
        Assert.assertEquals(2, ((int) (((Connection) (getConnection())).getTransactionIsolation())));
        Assert.assertFalse(((Connection) (getConnection())).getAutoCommit());
        Assert.assertEquals(1, ((int) (((Connection) (getConnection())).getHoldability())));
        Assert.assertEquals("APP", ((Connection) (getConnection())).getSchema());
        Assert.assertTrue(((Connection) (getConnection())).getClientInfo().isEmpty());
        Assert.assertNull(((Connection) (getConnection())).getCatalog());
        boolean o_shouldInsertNewAuthorByProclitNum124975litNum125220__4 = flushStatements().isEmpty();
        Assert.assertTrue(o_shouldInsertNewAuthorByProclitNum124975litNum125220__4);
        boolean o_shouldInsertNewAuthorByProclitNum124975litNum125220__5 = ((Connection) (getConnection())).getTypeMap().isEmpty();
        Assert.assertTrue(o_shouldInsertNewAuthorByProclitNum124975litNum125220__5);
        boolean o_shouldInsertNewAuthorByProclitNum124975litNum125220__6 = ((Connection) (getConnection())).getClientInfo().isEmpty();
        Assert.assertTrue(o_shouldInsertNewAuthorByProclitNum124975litNum125220__6);
        try {
            Author author = new Author((-2147483647), "someone", "******", "someone@apache.org", null, null);
            MappedStatement insertStatement = ExecutorTestHelper.prepareInsertAuthorProc(this.config);
            MappedStatement selectStatement = ExecutorTestHelper.prepareSelectOneAuthorMappedStatement(this.config);
            int rows = executor.update(insertStatement, author);
            List<Author> authors = executor.query(selectStatement, 97, DEFAULT, NO_RESULT_HANDLER);
            List<BatchResult> o_shouldInsertNewAuthorByProclitNum124975__16 = executor.flushStatements();
            boolean o_shouldInsertNewAuthorByProclitNum124975litNum125220__22 = o_shouldInsertNewAuthorByProclitNum124975__16.isEmpty();
            Assert.assertTrue(o_shouldInsertNewAuthorByProclitNum124975litNum125220__22);
            executor.rollback(true);
            int o_shouldInsertNewAuthorByProclitNum124975__18 = authors.size();
            String o_shouldInsertNewAuthorByProclitNum124975__19 = author.toString();
            Assert.assertEquals("Author : -2147483647 : someone : someone@apache.org", o_shouldInsertNewAuthorByProclitNum124975__19);
            String o_shouldInsertNewAuthorByProclitNum124975__20 = authors.get(0).toString();
            o_shouldInsertNewAuthorByProclitNum124975__16.isEmpty();
            o_shouldInsertNewAuthorByProclitNum124975__16.isEmpty();
        } finally {
            executor.rollback(true);
            executor.close(false);
        }
    }

    @Test(timeout = 120000)
    public void shouldInsertNewAuthorByProclitNum124974litNum125234() throws Exception {
        Executor executor = createExecutor(new JdbcTransaction(AmplBaseExecutorTest.ds, null, false));
        Assert.assertTrue(flushStatements().isEmpty());
        Assert.assertFalse(((Connection) (getConnection())).isClosed());
        Assert.assertNull(getTimeout());
        Assert.assertFalse(isClosed());
        Assert.assertTrue(((Connection) (getConnection())).getTypeMap().isEmpty());
        Assert.assertFalse(((Connection) (getConnection())).isReadOnly());
        Assert.assertEquals(2, ((int) (((Connection) (getConnection())).getTransactionIsolation())));
        Assert.assertFalse(((Connection) (getConnection())).getAutoCommit());
        Assert.assertEquals(1, ((int) (((Connection) (getConnection())).getHoldability())));
        Assert.assertEquals("APP", ((Connection) (getConnection())).getSchema());
        Assert.assertTrue(((Connection) (getConnection())).getClientInfo().isEmpty());
        Assert.assertNull(((Connection) (getConnection())).getCatalog());
        boolean o_shouldInsertNewAuthorByProclitNum124974litNum125234__4 = flushStatements().isEmpty();
        Assert.assertTrue(o_shouldInsertNewAuthorByProclitNum124974litNum125234__4);
        boolean o_shouldInsertNewAuthorByProclitNum124974litNum125234__5 = ((Connection) (getConnection())).getTypeMap().isEmpty();
        Assert.assertTrue(o_shouldInsertNewAuthorByProclitNum124974litNum125234__5);
        boolean o_shouldInsertNewAuthorByProclitNum124974litNum125234__6 = ((Connection) (getConnection())).getClientInfo().isEmpty();
        Assert.assertTrue(o_shouldInsertNewAuthorByProclitNum124974litNum125234__6);
        try {
            Author author = new Author(2147483646, "someone", "******", "someone@apache.org", null, null);
            MappedStatement insertStatement = ExecutorTestHelper.prepareInsertAuthorProc(this.config);
            MappedStatement selectStatement = ExecutorTestHelper.prepareSelectOneAuthorMappedStatement(this.config);
            int rows = executor.update(insertStatement, author);
            List<Author> authors = executor.query(selectStatement, 97, DEFAULT, NO_RESULT_HANDLER);
            List<BatchResult> o_shouldInsertNewAuthorByProclitNum124974__16 = executor.flushStatements();
            boolean o_shouldInsertNewAuthorByProclitNum124974litNum125234__22 = o_shouldInsertNewAuthorByProclitNum124974__16.isEmpty();
            Assert.assertTrue(o_shouldInsertNewAuthorByProclitNum124974litNum125234__22);
            executor.rollback(true);
            int o_shouldInsertNewAuthorByProclitNum124974__18 = authors.size();
            String o_shouldInsertNewAuthorByProclitNum124974__19 = author.toString();
            Assert.assertEquals("Author : 2147483646 : someone : someone@apache.org", o_shouldInsertNewAuthorByProclitNum124974__19);
            String o_shouldInsertNewAuthorByProclitNum124974__20 = authors.get(0).toString();
            o_shouldInsertNewAuthorByProclitNum124974__16.isEmpty();
            o_shouldInsertNewAuthorByProclitNum124974__16.isEmpty();
        } finally {
            executor.rollback(true);
            executor.close(false);
        }
    }

    @Test(timeout = 120000)
    public void shouldInsertNewAuthorlitNum119907_failAssert1364litNum120640() throws Exception {
        try {
            Executor executor = createExecutor(new JdbcTransaction(AmplBaseExecutorTest.ds, null, false));
            Assert.assertTrue(flushStatements().isEmpty());
            Assert.assertFalse(((Connection) (getConnection())).isClosed());
            Assert.assertNull(getTimeout());
            Assert.assertFalse(isClosed());
            Assert.assertTrue(((Connection) (getConnection())).getTypeMap().isEmpty());
            Assert.assertFalse(((Connection) (getConnection())).isReadOnly());
            Assert.assertEquals(2, ((int) (((Connection) (getConnection())).getTransactionIsolation())));
            Assert.assertFalse(((Connection) (getConnection())).getAutoCommit());
            Assert.assertEquals(1, ((int) (((Connection) (getConnection())).getHoldability())));
            Assert.assertEquals("APP", ((Connection) (getConnection())).getSchema());
            Assert.assertNull(((Connection) (getConnection())).getCatalog());
            Assert.assertTrue(((Connection) (getConnection())).getClientInfo().isEmpty());
            try {
                Author author = new Author(100, "someone", "******", "someone@apache.org", null, Section.NEWS);
                MappedStatement insertStatement = ExecutorTestHelper.prepareInsertAuthorMappedStatement(this.config);
                MappedStatement selectStatement = ExecutorTestHelper.prepareSelectOneAuthorMappedStatement(this.config);
                int rows = executor.update(insertStatement, author);
                List<Author> authors = executor.query(selectStatement, 99, DEFAULT, NO_RESULT_HANDLER);
                List<BatchResult> o_shouldInsertNewAuthorlitNum119907_failAssert1364litNum120640__18 = executor.flushStatements();
                Assert.assertTrue(o_shouldInsertNewAuthorlitNum119907_failAssert1364litNum120640__18.isEmpty());
                executor.rollback(true);
                int o_shouldInsertNewAuthorlitNum119907_failAssert1364litNum120640__20 = authors.size();
                Assert.assertEquals(1, ((int) (o_shouldInsertNewAuthorlitNum119907_failAssert1364litNum120640__20)));
                String o_shouldInsertNewAuthorlitNum119907_failAssert1364litNum120640__21 = author.toString();
                Assert.assertEquals("Author : 100 : someone : someone@apache.org", o_shouldInsertNewAuthorlitNum119907_failAssert1364litNum120640__21);
                authors.get(1).toString();
                boolean boolean_518 = (1 == rows) || ((BATCH_UPDATE_RETURN_VALUE) == rows);
            } finally {
                executor.rollback(true);
                executor.close(false);
            }
            Assert.fail("shouldInsertNewAuthorlitNum119907 should have thrown IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException expected) {
            String o_shouldInsertNewAuthorlitNum119907_failAssert1364litNum120640__30 = expected.getMessage();
            Assert.assertEquals("Index: 1, Size: 1", o_shouldInsertNewAuthorlitNum119907_failAssert1364litNum120640__30);
        }
    }

    @Test(timeout = 120000)
    public void shouldFetchOneOrphanedPostWithNoBloglitNum67979litNum68174_failAssert611() throws Exception {
        try {
            Executor executor = createExecutor(new JdbcTransaction(AmplBaseExecutorTest.ds, null, false));
            flushStatements().isEmpty();
            ((Connection) (getConnection())).getTypeMap().isEmpty();
            ((Connection) (getConnection())).getClientInfo().isEmpty();
            try {
                MappedStatement selectBlog = ExecutorTestHelper.prepareComplexSelectBlogMappedStatement(this.config);
                MappedStatement selectPost = ExecutorTestHelper.prepareSelectPostMappedStatement(this.config);
                this.config.addMappedStatement(selectBlog);
                this.config.addMappedStatement(selectPost);
                List<Post> posts = executor.query(selectPost, 5, DEFAULT, NO_RESULT_HANDLER);
                List<BatchResult> o_shouldFetchOneOrphanedPostWithNoBloglitNum67979__14 = executor.flushStatements();
                o_shouldFetchOneOrphanedPostWithNoBloglitNum67979__14.isEmpty();
                executor.rollback(true);
                int o_shouldFetchOneOrphanedPostWithNoBloglitNum67979__16 = posts.size();
                Post post = posts.get(-2147483648);
                post.getBlog();
            } finally {
                executor.rollback(true);
                executor.close(false);
            }
            Assert.fail("shouldFetchOneOrphanedPostWithNoBloglitNum67979litNum68174 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            Assert.assertEquals("-2147483648", expected.getMessage());
        }
    }

    @Test(timeout = 120000)
    public void shouldSelectAllAuthorsAutoMappedlitBool66846litBool66917litNum67403_failAssert565() throws Exception {
        try {
            Executor executor = createExecutor(new JdbcTransaction(AmplBaseExecutorTest.ds, null, false));
            flushStatements().isEmpty();
            ((Connection) (getConnection())).getTypeMap().isEmpty();
            ((Connection) (getConnection())).getClientInfo().isEmpty();
            boolean o_shouldSelectAllAuthorsAutoMappedlitBool66846litBool66917__4 = flushStatements().isEmpty();
            boolean o_shouldSelectAllAuthorsAutoMappedlitBool66846litBool66917__5 = ((Connection) (getConnection())).getTypeMap().isEmpty();
            boolean o_shouldSelectAllAuthorsAutoMappedlitBool66846litBool66917__6 = ((Connection) (getConnection())).getClientInfo().isEmpty();
            try {
                MappedStatement selectStatement = ExecutorTestHelper.prepareSelectAllAuthorsAutoMappedStatement(this.config);
                List<Author> authors = executor.query(selectStatement, null, DEFAULT, NO_RESULT_HANDLER);
                int o_shouldSelectAllAuthorsAutoMappedlitBool66846__10 = authors.size();
                Author author = authors.get(-2147483648);
                int o_shouldSelectAllAuthorsAutoMappedlitBool66846__13 = author.getId();
                String o_shouldSelectAllAuthorsAutoMappedlitBool66846__14 = author.getUsername();
                String o_shouldSelectAllAuthorsAutoMappedlitBool66846__15 = author.getEmail();
                String o_shouldSelectAllAuthorsAutoMappedlitBool66846__16 = author.getBio();
                Section o_shouldSelectAllAuthorsAutoMappedlitBool66846__17 = author.getFavouriteSection();
            } finally {
                executor.rollback(true);
                executor.close(false);
            }
            Assert.fail("shouldSelectAllAuthorsAutoMappedlitBool66846litBool66917litNum67403 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 120000)
    public void shouldFetchComplexBlogslitBool71391litNum71904_failAssert750() throws Exception {
        try {
            Executor executor = createExecutor(new JdbcTransaction(AmplBaseExecutorTest.ds, null, true));
            flushStatements().isEmpty();
            ((Connection) (getConnection())).getTypeMap().isEmpty();
            ((Connection) (getConnection())).getClientInfo().isEmpty();
            try {
                MappedStatement selectBlog = ExecutorTestHelper.prepareComplexSelectBlogMappedStatement(this.config);
                MappedStatement selectPosts = ExecutorTestHelper.prepareSelectPostsForBlogMappedStatement(this.config);
                this.config.addMappedStatement(selectBlog);
                this.config.addMappedStatement(selectPosts);
                List<Blog> blogs = executor.query(selectBlog, 1, DEFAULT, NO_RESULT_HANDLER);
                List<BatchResult> o_shouldFetchComplexBlogslitBool71391__14 = executor.flushStatements();
                o_shouldFetchComplexBlogslitBool71391__14.isEmpty();
                int o_shouldFetchComplexBlogslitBool71391__15 = blogs.size();
                List<Post> o_shouldFetchComplexBlogslitBool71391__16 = blogs.get(0).getPosts();
                int o_shouldFetchComplexBlogslitBool71391__18 = blogs.get(0).getPosts().size();
                int o_shouldFetchComplexBlogslitBool71391__21 = blogs.get((-1)).getPosts().get(1).getBlog().getPosts().get(1).getBlog().getId();
                executor.rollback(true);
                o_shouldFetchComplexBlogslitBool71391__14.isEmpty();
                o_shouldFetchComplexBlogslitBool71391__14.isEmpty();
            } finally {
                executor.rollback(true);
                executor.close(false);
            }
            Assert.fail("shouldFetchComplexBlogslitBool71391litNum71904 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 120000)
    public void shouldSelectAllAuthorsAutoMappedlitNum66845litNum66874litNum67367_failAssert560() throws Exception {
        try {
            Executor executor = createExecutor(new JdbcTransaction(AmplBaseExecutorTest.ds, null, false));
            flushStatements().isEmpty();
            ((Connection) (getConnection())).getTypeMap().isEmpty();
            ((Connection) (getConnection())).getClientInfo().isEmpty();
            boolean o_shouldSelectAllAuthorsAutoMappedlitNum66845litNum66874__4 = flushStatements().isEmpty();
            boolean o_shouldSelectAllAuthorsAutoMappedlitNum66845litNum66874__5 = ((Connection) (getConnection())).getTypeMap().isEmpty();
            boolean o_shouldSelectAllAuthorsAutoMappedlitNum66845litNum66874__6 = ((Connection) (getConnection())).getClientInfo().isEmpty();
            try {
                MappedStatement selectStatement = ExecutorTestHelper.prepareSelectAllAuthorsAutoMappedStatement(this.config);
                List<Author> authors = executor.query(selectStatement, null, DEFAULT, NO_RESULT_HANDLER);
                int o_shouldSelectAllAuthorsAutoMappedlitNum66845__10 = authors.size();
                Author author = authors.get(-2147483648);
                int o_shouldSelectAllAuthorsAutoMappedlitNum66845__13 = author.getId();
                String o_shouldSelectAllAuthorsAutoMappedlitNum66845__14 = author.getUsername();
                String o_shouldSelectAllAuthorsAutoMappedlitNum66845__15 = author.getEmail();
                String o_shouldSelectAllAuthorsAutoMappedlitNum66845litNum66874__27 = author.getBio();
                Section o_shouldSelectAllAuthorsAutoMappedlitNum66845litNum66874__28 = author.getFavouriteSection();
            } finally {
                executor.rollback(true);
                executor.close(false);
            }
            Assert.fail("shouldSelectAllAuthorsAutoMappedlitNum66845litNum66874litNum67367 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 120000)
    public void shouldInsertNewAuthorlitNum119906_failAssert1363litNum120423() throws Exception {
        try {
            Executor executor = createExecutor(new JdbcTransaction(AmplBaseExecutorTest.ds, null, false));
            Assert.assertTrue(flushStatements().isEmpty());
            Assert.assertFalse(((Connection) (getConnection())).isClosed());
            Assert.assertNull(getTimeout());
            Assert.assertFalse(isClosed());
            Assert.assertTrue(((Connection) (getConnection())).getTypeMap().isEmpty());
            Assert.assertFalse(((Connection) (getConnection())).isReadOnly());
            Assert.assertEquals(2, ((int) (((Connection) (getConnection())).getTransactionIsolation())));
            Assert.assertFalse(((Connection) (getConnection())).getAutoCommit());
            Assert.assertEquals(1, ((int) (((Connection) (getConnection())).getHoldability())));
            Assert.assertEquals("APP", ((Connection) (getConnection())).getSchema());
            Assert.assertNull(((Connection) (getConnection())).getCatalog());
            Assert.assertTrue(((Connection) (getConnection())).getClientInfo().isEmpty());
            try {
                Author author = new Author(98, "someone", "******", "someone@apache.org", null, Section.NEWS);
                MappedStatement insertStatement = ExecutorTestHelper.prepareInsertAuthorMappedStatement(this.config);
                MappedStatement selectStatement = ExecutorTestHelper.prepareSelectOneAuthorMappedStatement(this.config);
                int rows = executor.update(insertStatement, author);
                List<Author> authors = executor.query(selectStatement, 99, DEFAULT, NO_RESULT_HANDLER);
                List<BatchResult> o_shouldInsertNewAuthorlitNum119906_failAssert1363litNum120423__18 = executor.flushStatements();
                Assert.assertTrue(o_shouldInsertNewAuthorlitNum119906_failAssert1363litNum120423__18.isEmpty());
                executor.rollback(true);
                int o_shouldInsertNewAuthorlitNum119906_failAssert1363litNum120423__20 = authors.size();
                Assert.assertEquals(1, ((int) (o_shouldInsertNewAuthorlitNum119906_failAssert1363litNum120423__20)));
                String o_shouldInsertNewAuthorlitNum119906_failAssert1363litNum120423__21 = author.toString();
                Assert.assertEquals("Author : 98 : someone : someone@apache.org", o_shouldInsertNewAuthorlitNum119906_failAssert1363litNum120423__21);
                authors.get((-1)).toString();
                boolean boolean_517 = (1 == rows) || ((BATCH_UPDATE_RETURN_VALUE) == rows);
            } finally {
                executor.rollback(true);
                executor.close(false);
            }
            Assert.fail("shouldInsertNewAuthorlitNum119906 should have thrown IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException expected) {
            expected.getMessage();
        }
    }

    @Test(timeout = 120000)
    public void shouldFetchComplexBlogslitNum71371litNum72355_failAssert801() throws Exception {
        try {
            Executor executor = createExecutor(new JdbcTransaction(AmplBaseExecutorTest.ds, null, false));
            flushStatements().isEmpty();
            ((Connection) (getConnection())).getTypeMap().isEmpty();
            ((Connection) (getConnection())).getClientInfo().isEmpty();
            try {
                MappedStatement selectBlog = ExecutorTestHelper.prepareComplexSelectBlogMappedStatement(this.config);
                MappedStatement selectPosts = ExecutorTestHelper.prepareSelectPostsForBlogMappedStatement(this.config);
                this.config.addMappedStatement(selectBlog);
                this.config.addMappedStatement(selectPosts);
                List<Blog> blogs = executor.query(selectBlog, 1, DEFAULT, NO_RESULT_HANDLER);
                List<BatchResult> o_shouldFetchComplexBlogslitNum71371__14 = executor.flushStatements();
                o_shouldFetchComplexBlogslitNum71371__14.isEmpty();
                int o_shouldFetchComplexBlogslitNum71371__15 = blogs.size();
                List<Post> o_shouldFetchComplexBlogslitNum71371__16 = blogs.get(0).getPosts();
                int o_shouldFetchComplexBlogslitNum71371__18 = blogs.get(0).getPosts().size();
                int o_shouldFetchComplexBlogslitNum71371__21 = blogs.get(0).getPosts().get(-2147483648).getBlog().getPosts().get(1).getBlog().getId();
                executor.rollback(true);
                o_shouldFetchComplexBlogslitNum71371__14.isEmpty();
                o_shouldFetchComplexBlogslitNum71371__14.isEmpty();
            } finally {
                executor.rollback(true);
                executor.close(false);
            }
            Assert.fail("shouldFetchComplexBlogslitNum71371litNum72355 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            Assert.assertEquals(null, expected.getMessage());
        }
    }

    @Test(timeout = 120000)
    public void shouldInsertNewAuthorWithAutoKeylitNum24007_failAssert25litNum24139litString24669() throws Exception {
        try {
            Executor executor = createExecutor(new JdbcTransaction(AmplBaseExecutorTest.ds, null, false));
            Assert.assertFalse(((java.sql.Connection)((org.apache.ibatis.transaction.Transaction)((org.apache.ibatis.executor.SimpleExecutor)executor).getTransaction()).getConnection()).isClosed());
            Assert.assertTrue(((java.sql.Connection)((org.apache.ibatis.transaction.Transaction)((org.apache.ibatis.executor.SimpleExecutor)executor).getTransaction()).getConnection()).getClientInfo().isEmpty());
            Assert.assertTrue(((java.sql.Connection)((org.apache.ibatis.transaction.Transaction)((org.apache.ibatis.executor.SimpleExecutor)executor).getTransaction()).getConnection()).getTypeMap().isEmpty());
            Assert.assertNull(((org.apache.ibatis.transaction.Transaction)((org.apache.ibatis.executor.SimpleExecutor)executor).getTransaction()).getTimeout());
            Assert.assertFalse(((org.apache.ibatis.executor.SimpleExecutor)executor).isClosed());
            Assert.assertTrue(((org.apache.ibatis.executor.SimpleExecutor)executor).flushStatements().isEmpty());
            Assert.assertFalse(((java.sql.Connection)((org.apache.ibatis.transaction.Transaction)((org.apache.ibatis.executor.SimpleExecutor)executor).getTransaction()).getConnection()).isReadOnly());
            Assert.assertEquals(2, ((int) (((java.sql.Connection)((org.apache.ibatis.transaction.Transaction)((org.apache.ibatis.executor.SimpleExecutor)executor).getTransaction()).getConnection()).getTransactionIsolation())));
            Assert.assertFalse(((java.sql.Connection)((org.apache.ibatis.transaction.Transaction)((org.apache.ibatis.executor.SimpleExecutor)executor).getTransaction()).getConnection()).getAutoCommit());
            Assert.assertEquals(1, ((int) (((java.sql.Connection)((org.apache.ibatis.transaction.Transaction)((org.apache.ibatis.executor.SimpleExecutor)executor).getTransaction()).getConnection()).getHoldability())));
            Assert.assertEquals("APP", ((java.sql.Connection)((org.apache.ibatis.transaction.Transaction)((org.apache.ibatis.executor.SimpleExecutor)executor).getTransaction()).getConnection()).getSchema());
            Assert.assertNull(((java.sql.Connection)((org.apache.ibatis.transaction.Transaction)((org.apache.ibatis.executor.SimpleExecutor)executor).getTransaction()).getConnection()).getCatalog());
            try {
                Author author = new Author((-1), "subject", "******", "someone@apache.org", null, Section.NEWS);
                MappedStatement insertStatement = ExecutorTestHelper.prepareInsertAuthorMappedStatementWithAutoKey(this.config);
                MappedStatement selectStatement = ExecutorTestHelper.prepareSelectOneAuthorMappedStatement(this.config);
                int rows = executor.update(insertStatement, author);
                boolean boolean_224 = (rows > 0) || (rows == (BatchExecutor.BATCH_UPDATE_RETURN_VALUE));
                if (rows == (BatchExecutor.BATCH_UPDATE_RETURN_VALUE)) {
                    executor.flushStatements();
                }
                boolean boolean_225 = (-1) != (author.getId());
                if ((author.getId()) != (BatchExecutor.BATCH_UPDATE_RETURN_VALUE)) {
                    List<Author> authors = executor.query(selectStatement, author.getId(), RowBounds.DEFAULT, Executor.NO_RESULT_HANDLER);
                    executor.rollback(true);
                    int o_shouldInsertNewAuthorWithAutoKeylitNum24007_failAssert25litNum24139__36 = authors.size();
                    author.toString();
                    authors.get(-1).toString();
                    boolean boolean_226 = (author.getId()) >= 10001;
                }
            } finally {
                executor.rollback(true);
                executor.close(false);
            }
            org.junit.Assert.fail("shouldInsertNewAuthorWithAutoKeylitNum24007 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_shouldInsertNewAuthorWithAutoKeylitNum24007_failAssert25litNum24139litString24669__51 = expected.getMessage();
            Assert.assertEquals("-1", o_shouldInsertNewAuthorWithAutoKeylitNum24007_failAssert25litNum24139litString24669__51);
        }
    }
}

