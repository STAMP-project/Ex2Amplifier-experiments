package org.apache.ibatis.executor;


import java.util.List;
import javax.sql.DataSource;
import org.apache.ibatis.BaseDataTest;
import org.apache.ibatis.domain.blog.Author;
import org.apache.ibatis.domain.blog.Section;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
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

    @Test(timeout = 120000)
    public void shouldInsertNewAuthor() throws Exception {
        Executor executor = createExecutor(new JdbcTransaction(AmplBaseExecutorTest.ds, null, false));
        Assert.assertTrue(((java.sql.Connection)((org.apache.ibatis.transaction.Transaction)((org.apache.ibatis.executor.SimpleExecutor)executor).getTransaction()).getConnection()).getClientInfo().isEmpty());
        Assert.assertFalse(((java.sql.Connection)((org.apache.ibatis.transaction.Transaction)((org.apache.ibatis.executor.SimpleExecutor)executor).getTransaction()).getConnection()).isClosed());
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
            Author author = new Author(99, "someone", "******", "someone@apache.org", null, Section.NEWS);
            Assert.assertEquals("Author : 99 : someone : someone@apache.org", ((org.apache.ibatis.domain.blog.Author)author).toString());
            Assert.assertEquals("NEWS", ((org.apache.ibatis.domain.blog.Section)((org.apache.ibatis.domain.blog.Author)author).getFavouriteSection()).name());
            Assert.assertEquals(0, ((int) (((org.apache.ibatis.domain.blog.Section)((org.apache.ibatis.domain.blog.Author)author).getFavouriteSection()).ordinal())));
            Assert.assertEquals(99, ((int) (((org.apache.ibatis.domain.blog.Author)author).getId())));
            Assert.assertEquals("someone@apache.org", ((org.apache.ibatis.domain.blog.Author)author).getEmail());
            Assert.assertNull(((org.apache.ibatis.domain.blog.Author)author).getBio());
            Assert.assertEquals(-389171841, ((int) (((org.apache.ibatis.domain.blog.Author)author).hashCode())));
            Assert.assertEquals("someone", ((org.apache.ibatis.domain.blog.Author)author).getUsername());
            Assert.assertEquals("******", ((org.apache.ibatis.domain.blog.Author)author).getPassword());
            MappedStatement insertStatement = ExecutorTestHelper.prepareInsertAuthorMappedStatement(this.config);
            MappedStatement selectStatement = ExecutorTestHelper.prepareSelectOneAuthorMappedStatement(this.config);
            int rows = executor.update(insertStatement, author);
            Assert.assertEquals(1, ((int) (rows)));
            List<Author> authors = executor.query(selectStatement, 99, RowBounds.DEFAULT, Executor.NO_RESULT_HANDLER);
            Assert.assertFalse(authors.isEmpty());
            List<BatchResult> o_shouldInsertNewAuthor__16 = executor.flushStatements();
            Assert.assertTrue(o_shouldInsertNewAuthor__16.isEmpty());
            executor.rollback(true);
            int o_shouldInsertNewAuthor__18 = authors.size();
            Assert.assertEquals(1, ((int) (o_shouldInsertNewAuthor__18)));
            String o_shouldInsertNewAuthor__19 = author.toString();
            Assert.assertEquals("Author : 99 : someone : someone@apache.org", o_shouldInsertNewAuthor__19);
            String o_shouldInsertNewAuthor__20 = authors.get(0).toString();
            Assert.assertEquals("Author : 99 : someone : someone@apache.org", o_shouldInsertNewAuthor__20);
            boolean boolean_9 = (1 == rows) || ((BatchExecutor.BATCH_UPDATE_RETURN_VALUE) == rows);
            Assert.assertEquals(1, ((int) (rows)));
            Assert.assertFalse(authors.isEmpty());
            Assert.assertEquals("Author : 99 : someone : someone@apache.org", ((org.apache.ibatis.domain.blog.Author)author).toString());
            Assert.assertEquals("NEWS", ((org.apache.ibatis.domain.blog.Section)((org.apache.ibatis.domain.blog.Author)author).getFavouriteSection()).name());
            Assert.assertEquals(0, ((int) (((org.apache.ibatis.domain.blog.Section)((org.apache.ibatis.domain.blog.Author)author).getFavouriteSection()).ordinal())));
            Assert.assertEquals(99, ((int) (((org.apache.ibatis.domain.blog.Author)author).getId())));
            Assert.assertEquals("someone@apache.org", ((org.apache.ibatis.domain.blog.Author)author).getEmail());
            Assert.assertNull(((org.apache.ibatis.domain.blog.Author)author).getBio());
            Assert.assertEquals(-389171841, ((int) (((org.apache.ibatis.domain.blog.Author)author).hashCode())));
            Assert.assertEquals("someone", ((org.apache.ibatis.domain.blog.Author)author).getUsername());
            Assert.assertEquals("******", ((org.apache.ibatis.domain.blog.Author)author).getPassword());
            Assert.assertEquals("Author : 99 : someone : someone@apache.org", o_shouldInsertNewAuthor__19);
            Assert.assertEquals(1, ((int) (o_shouldInsertNewAuthor__18)));
            Assert.assertEquals("Author : 99 : someone : someone@apache.org", o_shouldInsertNewAuthor__20);
            Assert.assertTrue(o_shouldInsertNewAuthor__16.isEmpty());
        } finally {
            executor.rollback(true);
            executor.close(false);
        }
        Assert.assertTrue(((org.apache.ibatis.executor.SimpleExecutor)executor).isClosed());
    }

    @Test(timeout = 120000)
    public void shouldInsertNewAuthorWithAutoKey() throws Exception {
        Executor executor = createExecutor(new JdbcTransaction(AmplBaseExecutorTest.ds, null, false));
        Assert.assertTrue(((java.sql.Connection)((org.apache.ibatis.transaction.Transaction)((org.apache.ibatis.executor.SimpleExecutor)executor).getTransaction()).getConnection()).getClientInfo().isEmpty());
        Assert.assertFalse(((java.sql.Connection)((org.apache.ibatis.transaction.Transaction)((org.apache.ibatis.executor.SimpleExecutor)executor).getTransaction()).getConnection()).isClosed());
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
            Author author = new Author((-1), "someone", "******", "someone@apache.org", null, Section.NEWS);
            Assert.assertEquals("Author : -1 : someone : someone@apache.org", ((org.apache.ibatis.domain.blog.Author)author).toString());
            Assert.assertEquals("NEWS", ((org.apache.ibatis.domain.blog.Section)((org.apache.ibatis.domain.blog.Author)author).getFavouriteSection()).name());
            Assert.assertEquals(0, ((int) (((org.apache.ibatis.domain.blog.Section)((org.apache.ibatis.domain.blog.Author)author).getFavouriteSection()).ordinal())));
            Assert.assertEquals(-1, ((int) (((org.apache.ibatis.domain.blog.Author)author).getId())));
            Assert.assertEquals("someone@apache.org", ((org.apache.ibatis.domain.blog.Author)author).getEmail());
            Assert.assertNull(((org.apache.ibatis.domain.blog.Author)author).getBio());
            Assert.assertEquals(1042880355, ((int) (((org.apache.ibatis.domain.blog.Author)author).hashCode())));
            Assert.assertEquals("someone", ((org.apache.ibatis.domain.blog.Author)author).getUsername());
            Assert.assertEquals("******", ((org.apache.ibatis.domain.blog.Author)author).getPassword());
            MappedStatement insertStatement = ExecutorTestHelper.prepareInsertAuthorMappedStatementWithAutoKey(this.config);
            MappedStatement selectStatement = ExecutorTestHelper.prepareSelectOneAuthorMappedStatement(this.config);
            int rows = executor.update(insertStatement, author);
            Assert.assertEquals(1, ((int) (rows)));
            boolean boolean_6 = (rows > 0) || (rows == (BatchExecutor.BATCH_UPDATE_RETURN_VALUE));
            if (rows == (BatchExecutor.BATCH_UPDATE_RETURN_VALUE)) {
                executor.flushStatements();
            }
            boolean boolean_7 = (-1) != (author.getId());
            if ((author.getId()) != (BatchExecutor.BATCH_UPDATE_RETURN_VALUE)) {
                List<Author> authors = executor.query(selectStatement, author.getId(), RowBounds.DEFAULT, Executor.NO_RESULT_HANDLER);
                Assert.assertFalse(authors.isEmpty());
                executor.rollback(true);
                int o_shouldInsertNewAuthorWithAutoKey__29 = authors.size();
                Assert.assertEquals(1, ((int) (o_shouldInsertNewAuthorWithAutoKey__29)));
                author.toString();
                authors.get(0).toString();
                boolean boolean_8 = (author.getId()) >= 10000;
                Assert.assertEquals(1, ((int) (o_shouldInsertNewAuthorWithAutoKey__29)));
                Assert.assertFalse(authors.isEmpty());
            }
            Assert.assertEquals("NEWS", ((org.apache.ibatis.domain.blog.Section)((org.apache.ibatis.domain.blog.Author)author).getFavouriteSection()).name());
            Assert.assertEquals(0, ((int) (((org.apache.ibatis.domain.blog.Section)((org.apache.ibatis.domain.blog.Author)author).getFavouriteSection()).ordinal())));
            Assert.assertEquals("someone@apache.org", ((org.apache.ibatis.domain.blog.Author)author).getEmail());
            Assert.assertNull(((org.apache.ibatis.domain.blog.Author)author).getBio());
            Assert.assertEquals("someone", ((org.apache.ibatis.domain.blog.Author)author).getUsername());
            Assert.assertEquals("******", ((org.apache.ibatis.domain.blog.Author)author).getPassword());
            Assert.assertEquals(1, ((int) (rows)));
        } finally {
            executor.rollback(true);
            executor.close(false);
        }
        Assert.assertTrue(((org.apache.ibatis.executor.SimpleExecutor)executor).isClosed());
    }

    @Test(timeout = 120000)
    public void shouldInsertNewAuthorWithBeforeAutoKey() throws Exception {
        Executor executor = createExecutor(new JdbcTransaction(AmplBaseExecutorTest.ds, null, false));
        Assert.assertTrue(((java.sql.Connection)((org.apache.ibatis.transaction.Transaction)((org.apache.ibatis.executor.SimpleExecutor)executor).getTransaction()).getConnection()).getClientInfo().isEmpty());
        Assert.assertFalse(((java.sql.Connection)((org.apache.ibatis.transaction.Transaction)((org.apache.ibatis.executor.SimpleExecutor)executor).getTransaction()).getConnection()).isClosed());
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
            Author author = new Author((-1), "someone", "******", "someone@apache.org", null, Section.NEWS);
            Assert.assertEquals("Author : -1 : someone : someone@apache.org", ((org.apache.ibatis.domain.blog.Author)author).toString());
            Assert.assertEquals("NEWS", ((org.apache.ibatis.domain.blog.Section)((org.apache.ibatis.domain.blog.Author)author).getFavouriteSection()).name());
            Assert.assertEquals(0, ((int) (((org.apache.ibatis.domain.blog.Section)((org.apache.ibatis.domain.blog.Author)author).getFavouriteSection()).ordinal())));
            Assert.assertEquals(-1, ((int) (((org.apache.ibatis.domain.blog.Author)author).getId())));
            Assert.assertEquals("someone@apache.org", ((org.apache.ibatis.domain.blog.Author)author).getEmail());
            Assert.assertNull(((org.apache.ibatis.domain.blog.Author)author).getBio());
            Assert.assertEquals(1042880355, ((int) (((org.apache.ibatis.domain.blog.Author)author).hashCode())));
            Assert.assertEquals("someone", ((org.apache.ibatis.domain.blog.Author)author).getUsername());
            Assert.assertEquals("******", ((org.apache.ibatis.domain.blog.Author)author).getPassword());
            MappedStatement insertStatement = ExecutorTestHelper.prepareInsertAuthorMappedStatementWithBeforeAutoKey(this.config);
            MappedStatement selectStatement = ExecutorTestHelper.prepareSelectOneAuthorMappedStatement(this.config);
            int rows = executor.update(insertStatement, author);
            Assert.assertEquals(1, ((int) (rows)));
            boolean boolean_2 = (rows > 0) || (rows == (BatchExecutor.BATCH_UPDATE_RETURN_VALUE));
            if (rows == (BatchExecutor.BATCH_UPDATE_RETURN_VALUE)) {
                executor.flushStatements();
            }
            int o_shouldInsertNewAuthorWithBeforeAutoKey__19 = author.getId();
            Assert.assertEquals(123456, ((int) (o_shouldInsertNewAuthorWithBeforeAutoKey__19)));
            if ((author.getId()) != (BatchExecutor.BATCH_UPDATE_RETURN_VALUE)) {
                List<Author> authors = executor.query(selectStatement, author.getId(), RowBounds.DEFAULT, Executor.NO_RESULT_HANDLER);
                Assert.assertFalse(authors.isEmpty());
                executor.rollback(true);
                int o_shouldInsertNewAuthorWithBeforeAutoKey__27 = authors.size();
                Assert.assertEquals(1, ((int) (o_shouldInsertNewAuthorWithBeforeAutoKey__27)));
                String o_shouldInsertNewAuthorWithBeforeAutoKey__28 = author.toString();
                Assert.assertEquals("Author : 123456 : someone : someone@apache.org", o_shouldInsertNewAuthorWithBeforeAutoKey__28);
                String o_shouldInsertNewAuthorWithBeforeAutoKey__29 = authors.get(0).toString();
                Assert.assertEquals("Author : 123456 : someone : someone@apache.org", o_shouldInsertNewAuthorWithBeforeAutoKey__29);
                boolean boolean_3 = (author.getId()) >= 10000;
                Assert.assertEquals("Author : 123456 : someone : someone@apache.org", o_shouldInsertNewAuthorWithBeforeAutoKey__29);
                Assert.assertFalse(authors.isEmpty());
                Assert.assertEquals(1, ((int) (o_shouldInsertNewAuthorWithBeforeAutoKey__27)));
                Assert.assertEquals("Author : 123456 : someone : someone@apache.org", o_shouldInsertNewAuthorWithBeforeAutoKey__28);
            }
            Assert.assertEquals(123456, ((int) (o_shouldInsertNewAuthorWithBeforeAutoKey__19)));
            Assert.assertEquals("Author : 123456 : someone : someone@apache.org", ((org.apache.ibatis.domain.blog.Author)author).toString());
            Assert.assertEquals("NEWS", ((org.apache.ibatis.domain.blog.Section)((org.apache.ibatis.domain.blog.Author)author).getFavouriteSection()).name());
            Assert.assertEquals(0, ((int) (((org.apache.ibatis.domain.blog.Section)((org.apache.ibatis.domain.blog.Author)author).getFavouriteSection()).ordinal())));
            Assert.assertEquals(123456, ((int) (((org.apache.ibatis.domain.blog.Author)author).getId())));
            Assert.assertEquals("someone@apache.org", ((org.apache.ibatis.domain.blog.Author)author).getEmail());
            Assert.assertNull(((org.apache.ibatis.domain.blog.Author)author).getBio());
            Assert.assertEquals(753890754, ((int) (((org.apache.ibatis.domain.blog.Author)author).hashCode())));
            Assert.assertEquals("someone", ((org.apache.ibatis.domain.blog.Author)author).getUsername());
            Assert.assertEquals("******", ((org.apache.ibatis.domain.blog.Author)author).getPassword());
            Assert.assertEquals(1, ((int) (rows)));
        } finally {
            executor.rollback(true);
            executor.close(false);
        }
        Assert.assertTrue(((org.apache.ibatis.executor.SimpleExecutor)executor).isClosed());
    }

    @Test(timeout = 120000)
    public void shouldMapConstructorResults() throws Exception {
        Executor executor = createExecutor(new JdbcTransaction(AmplBaseExecutorTest.ds, null, false));
        Assert.assertTrue(((java.sql.Connection)((org.apache.ibatis.transaction.Transaction)((org.apache.ibatis.executor.SimpleExecutor)executor).getTransaction()).getConnection()).getClientInfo().isEmpty());
        Assert.assertFalse(((java.sql.Connection)((org.apache.ibatis.transaction.Transaction)((org.apache.ibatis.executor.SimpleExecutor)executor).getTransaction()).getConnection()).isClosed());
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
            MappedStatement selectStatement = ExecutorTestHelper.prepareSelectOneAuthorMappedStatementWithConstructorResults(this.config);
            List<Author> authors = executor.query(selectStatement, 102, RowBounds.DEFAULT, Executor.NO_RESULT_HANDLER);
            Assert.assertFalse(authors.isEmpty());
            List<BatchResult> o_shouldMapConstructorResults__10 = executor.flushStatements();
            Assert.assertTrue(o_shouldMapConstructorResults__10.isEmpty());
            executor.rollback(true);
            int o_shouldMapConstructorResults__12 = authors.size();
            Assert.assertEquals(1, ((int) (o_shouldMapConstructorResults__12)));
            Author author = authors.get(0);
            Assert.assertEquals("Author : 102 : sally : sally@ibatis.apache.org", ((org.apache.ibatis.domain.blog.Author)author).toString());
            Assert.assertEquals("VIDEOS", ((org.apache.ibatis.domain.blog.Section)((org.apache.ibatis.domain.blog.Author)author).getFavouriteSection()).name());
            Assert.assertEquals(1, ((int) (((org.apache.ibatis.domain.blog.Section)((org.apache.ibatis.domain.blog.Author)author).getFavouriteSection()).ordinal())));
            Assert.assertEquals(102, ((int) (((org.apache.ibatis.domain.blog.Author)author).getId())));
            Assert.assertEquals("sally@ibatis.apache.org", ((org.apache.ibatis.domain.blog.Author)author).getEmail());
            Assert.assertNull(((org.apache.ibatis.domain.blog.Author)author).getBio());
            Assert.assertEquals(-1492233944, ((int) (((org.apache.ibatis.domain.blog.Author)author).hashCode())));
            Assert.assertEquals("sally", ((org.apache.ibatis.domain.blog.Author)author).getUsername());
            Assert.assertEquals("********", ((org.apache.ibatis.domain.blog.Author)author).getPassword());
            int o_shouldMapConstructorResults__15 = author.getId();
            Assert.assertEquals(102, ((int) (o_shouldMapConstructorResults__15)));
            Assert.assertEquals(1, ((int) (o_shouldMapConstructorResults__12)));
            Assert.assertEquals("Author : 102 : sally : sally@ibatis.apache.org", ((org.apache.ibatis.domain.blog.Author)author).toString());
            Assert.assertEquals("VIDEOS", ((org.apache.ibatis.domain.blog.Section)((org.apache.ibatis.domain.blog.Author)author).getFavouriteSection()).name());
            Assert.assertEquals(1, ((int) (((org.apache.ibatis.domain.blog.Section)((org.apache.ibatis.domain.blog.Author)author).getFavouriteSection()).ordinal())));
            Assert.assertEquals(102, ((int) (((org.apache.ibatis.domain.blog.Author)author).getId())));
            Assert.assertEquals("sally@ibatis.apache.org", ((org.apache.ibatis.domain.blog.Author)author).getEmail());
            Assert.assertNull(((org.apache.ibatis.domain.blog.Author)author).getBio());
            Assert.assertEquals(-1492233944, ((int) (((org.apache.ibatis.domain.blog.Author)author).hashCode())));
            Assert.assertEquals("sally", ((org.apache.ibatis.domain.blog.Author)author).getUsername());
            Assert.assertEquals("********", ((org.apache.ibatis.domain.blog.Author)author).getPassword());
            Assert.assertTrue(o_shouldMapConstructorResults__10.isEmpty());
            Assert.assertFalse(authors.isEmpty());
        } finally {
            executor.rollback(true);
            executor.close(false);
        }
        Assert.assertTrue(((org.apache.ibatis.executor.SimpleExecutor)executor).isClosed());
    }

    @Test(timeout = 120000)
    public void shouldSelectAllAuthorsAutoMapped() throws Exception {
        Executor executor = createExecutor(new JdbcTransaction(AmplBaseExecutorTest.ds, null, false));
        Assert.assertTrue(((java.sql.Connection)((org.apache.ibatis.transaction.Transaction)((org.apache.ibatis.executor.SimpleExecutor)executor).getTransaction()).getConnection()).getClientInfo().isEmpty());
        Assert.assertFalse(((java.sql.Connection)((org.apache.ibatis.transaction.Transaction)((org.apache.ibatis.executor.SimpleExecutor)executor).getTransaction()).getConnection()).isClosed());
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
            MappedStatement selectStatement = ExecutorTestHelper.prepareSelectAllAuthorsAutoMappedStatement(this.config);
            List<Author> authors = executor.query(selectStatement, null, RowBounds.DEFAULT, Executor.NO_RESULT_HANDLER);
            Assert.assertFalse(authors.isEmpty());
            int o_shouldSelectAllAuthorsAutoMapped__10 = authors.size();
            Assert.assertEquals(2, ((int) (o_shouldSelectAllAuthorsAutoMapped__10)));
            Author author = authors.get(0);
            Assert.assertEquals("Author : 101 : jim : jim@ibatis.apache.org", ((org.apache.ibatis.domain.blog.Author)author).toString());
            Assert.assertEquals("NEWS", ((org.apache.ibatis.domain.blog.Section)((org.apache.ibatis.domain.blog.Author)author).getFavouriteSection()).name());
            Assert.assertEquals(0, ((int) (((org.apache.ibatis.domain.blog.Section)((org.apache.ibatis.domain.blog.Author)author).getFavouriteSection()).ordinal())));
            Assert.assertEquals(101, ((int) (((org.apache.ibatis.domain.blog.Author)author).getId())));
            Assert.assertEquals("jim@ibatis.apache.org", ((org.apache.ibatis.domain.blog.Author)author).getEmail());
            Assert.assertEquals("", ((org.apache.ibatis.domain.blog.Author)author).getBio());
            Assert.assertEquals(1132101265, ((int) (((org.apache.ibatis.domain.blog.Author)author).hashCode())));
            Assert.assertEquals("jim", ((org.apache.ibatis.domain.blog.Author)author).getUsername());
            Assert.assertEquals("********", ((org.apache.ibatis.domain.blog.Author)author).getPassword());
            int o_shouldSelectAllAuthorsAutoMapped__13 = author.getId();
            Assert.assertEquals(101, ((int) (o_shouldSelectAllAuthorsAutoMapped__13)));
            String o_shouldSelectAllAuthorsAutoMapped__14 = author.getUsername();
            Assert.assertEquals("jim", o_shouldSelectAllAuthorsAutoMapped__14);
            String o_shouldSelectAllAuthorsAutoMapped__15 = author.getEmail();
            Assert.assertEquals("jim@ibatis.apache.org", o_shouldSelectAllAuthorsAutoMapped__15);
            String o_shouldSelectAllAuthorsAutoMapped__16 = author.getBio();
            Assert.assertEquals("", o_shouldSelectAllAuthorsAutoMapped__16);
            Section o_shouldSelectAllAuthorsAutoMapped__17 = author.getFavouriteSection();
            Assert.assertEquals(0, ((int) (((org.apache.ibatis.domain.blog.Section)o_shouldSelectAllAuthorsAutoMapped__17).ordinal())));
            Assert.assertEquals("NEWS", ((org.apache.ibatis.domain.blog.Section)o_shouldSelectAllAuthorsAutoMapped__17).name());
            Assert.assertEquals("jim", o_shouldSelectAllAuthorsAutoMapped__14);
            Assert.assertEquals(101, ((int) (o_shouldSelectAllAuthorsAutoMapped__13)));
            Assert.assertEquals("", o_shouldSelectAllAuthorsAutoMapped__16);
            Assert.assertEquals("jim@ibatis.apache.org", o_shouldSelectAllAuthorsAutoMapped__15);
            Assert.assertFalse(authors.isEmpty());
            Assert.assertEquals("Author : 101 : jim : jim@ibatis.apache.org", ((org.apache.ibatis.domain.blog.Author)author).toString());
            Assert.assertEquals("NEWS", ((org.apache.ibatis.domain.blog.Section)((org.apache.ibatis.domain.blog.Author)author).getFavouriteSection()).name());
            Assert.assertEquals(0, ((int) (((org.apache.ibatis.domain.blog.Section)((org.apache.ibatis.domain.blog.Author)author).getFavouriteSection()).ordinal())));
            Assert.assertEquals(101, ((int) (((org.apache.ibatis.domain.blog.Author)author).getId())));
            Assert.assertEquals("jim@ibatis.apache.org", ((org.apache.ibatis.domain.blog.Author)author).getEmail());
            Assert.assertEquals("", ((org.apache.ibatis.domain.blog.Author)author).getBio());
            Assert.assertEquals(1132101265, ((int) (((org.apache.ibatis.domain.blog.Author)author).hashCode())));
            Assert.assertEquals("jim", ((org.apache.ibatis.domain.blog.Author)author).getUsername());
            Assert.assertEquals("********", ((org.apache.ibatis.domain.blog.Author)author).getPassword());
            Assert.assertEquals(2, ((int) (o_shouldSelectAllAuthorsAutoMapped__10)));
        } finally {
            executor.rollback(true);
            executor.close(false);
        }
        Assert.assertTrue(((org.apache.ibatis.executor.SimpleExecutor)executor).isClosed());
    }

    @Test(timeout = 120000)
    public void shouldUpdateAuthor() throws Exception {
        Executor executor = createExecutor(new JdbcTransaction(AmplBaseExecutorTest.ds, null, false));
        Assert.assertTrue(((java.sql.Connection)((org.apache.ibatis.transaction.Transaction)((org.apache.ibatis.executor.SimpleExecutor)executor).getTransaction()).getConnection()).getClientInfo().isEmpty());
        Assert.assertFalse(((java.sql.Connection)((org.apache.ibatis.transaction.Transaction)((org.apache.ibatis.executor.SimpleExecutor)executor).getTransaction()).getConnection()).isClosed());
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
            Author author = new Author(101, "someone", "******", "someone@apache.org", null, Section.NEWS);
            Assert.assertEquals("Author : 101 : someone : someone@apache.org", ((org.apache.ibatis.domain.blog.Author)author).toString());
            Assert.assertEquals("NEWS", ((org.apache.ibatis.domain.blog.Section)((org.apache.ibatis.domain.blog.Author)author).getFavouriteSection()).name());
            Assert.assertEquals(0, ((int) (((org.apache.ibatis.domain.blog.Section)((org.apache.ibatis.domain.blog.Author)author).getFavouriteSection()).ordinal())));
            Assert.assertEquals(101, ((int) (((org.apache.ibatis.domain.blog.Author)author).getId())));
            Assert.assertEquals("someone@apache.org", ((org.apache.ibatis.domain.blog.Author)author).getEmail());
            Assert.assertNull(((org.apache.ibatis.domain.blog.Author)author).getBio());
            Assert.assertEquals(-331913539, ((int) (((org.apache.ibatis.domain.blog.Author)author).hashCode())));
            Assert.assertEquals("someone", ((org.apache.ibatis.domain.blog.Author)author).getUsername());
            Assert.assertEquals("******", ((org.apache.ibatis.domain.blog.Author)author).getPassword());
            MappedStatement updateStatement = ExecutorTestHelper.prepareUpdateAuthorMappedStatement(this.config);
            MappedStatement selectStatement = ExecutorTestHelper.prepareSelectOneAuthorMappedStatement(this.config);
            int rows = executor.update(updateStatement, author);
            Assert.assertEquals(1, ((int) (rows)));
            List<Author> authors = executor.query(selectStatement, 101, RowBounds.DEFAULT, Executor.NO_RESULT_HANDLER);
            Assert.assertFalse(authors.isEmpty());
            List<BatchResult> o_shouldUpdateAuthor__16 = executor.flushStatements();
            Assert.assertTrue(o_shouldUpdateAuthor__16.isEmpty());
            executor.rollback(true);
            int o_shouldUpdateAuthor__18 = authors.size();
            Assert.assertEquals(1, ((int) (o_shouldUpdateAuthor__18)));
            String o_shouldUpdateAuthor__19 = author.toString();
            Assert.assertEquals("Author : 101 : someone : someone@apache.org", o_shouldUpdateAuthor__19);
            String o_shouldUpdateAuthor__20 = authors.get(0).toString();
            Assert.assertEquals("Author : 101 : someone : someone@apache.org", o_shouldUpdateAuthor__20);
            boolean boolean_0 = (1 == rows) || ((BatchExecutor.BATCH_UPDATE_RETURN_VALUE) == rows);
            Assert.assertEquals(1, ((int) (rows)));
            Assert.assertEquals("Author : 101 : someone : someone@apache.org", o_shouldUpdateAuthor__20);
            Assert.assertEquals("Author : 101 : someone : someone@apache.org", ((org.apache.ibatis.domain.blog.Author)author).toString());
            Assert.assertEquals("NEWS", ((org.apache.ibatis.domain.blog.Section)((org.apache.ibatis.domain.blog.Author)author).getFavouriteSection()).name());
            Assert.assertEquals(0, ((int) (((org.apache.ibatis.domain.blog.Section)((org.apache.ibatis.domain.blog.Author)author).getFavouriteSection()).ordinal())));
            Assert.assertEquals(101, ((int) (((org.apache.ibatis.domain.blog.Author)author).getId())));
            Assert.assertEquals("someone@apache.org", ((org.apache.ibatis.domain.blog.Author)author).getEmail());
            Assert.assertNull(((org.apache.ibatis.domain.blog.Author)author).getBio());
            Assert.assertEquals(-331913539, ((int) (((org.apache.ibatis.domain.blog.Author)author).hashCode())));
            Assert.assertEquals("someone", ((org.apache.ibatis.domain.blog.Author)author).getUsername());
            Assert.assertEquals("******", ((org.apache.ibatis.domain.blog.Author)author).getPassword());
            Assert.assertFalse(authors.isEmpty());
            Assert.assertEquals("Author : 101 : someone : someone@apache.org", o_shouldUpdateAuthor__19);
            Assert.assertTrue(o_shouldUpdateAuthor__16.isEmpty());
            Assert.assertEquals(1, ((int) (o_shouldUpdateAuthor__18)));
        } finally {
            executor.rollback(true);
            executor.close(false);
        }
        Assert.assertTrue(((org.apache.ibatis.executor.SimpleExecutor)executor).isClosed());
    }
}

