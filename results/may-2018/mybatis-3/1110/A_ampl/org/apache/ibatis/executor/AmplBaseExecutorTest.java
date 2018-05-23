package org.apache.ibatis.executor;


import Executor.NO_RESULT_HANDLER;
import RowBounds.DEFAULT;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.apache.ibatis.BaseDataTest;
import org.apache.ibatis.domain.blog.Author;
import org.apache.ibatis.domain.blog.Section;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.transaction.Transaction;
import org.apache.ibatis.transaction.jdbc.JdbcTransaction;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;


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

    @Test(timeout = 10000)
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
            Assert.assertEquals(1440539734, ((int) (((ArrayList) (o_shouldClearDeferredLoads__22)).hashCode())));
            Assert.assertFalse(((ArrayList) (o_shouldClearDeferredLoads__22)).isEmpty());
            Assert.assertEquals(1, ((int) (((ArrayList) (o_shouldClearDeferredLoads__22)).size())));
            List<BatchResult> o_shouldClearDeferredLoads__24 = executor.flushStatements();
            Assert.assertTrue(o_shouldClearDeferredLoads__24.isEmpty());
            executor.rollback(true);
            Assert.assertEquals("[Author : -1 : someone : someone@apache.org]", ((ArrayList) (o_shouldClearDeferredLoads__22)).toString());
            Assert.assertEquals(1440539734, ((int) (((ArrayList) (o_shouldClearDeferredLoads__22)).hashCode())));
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
}

