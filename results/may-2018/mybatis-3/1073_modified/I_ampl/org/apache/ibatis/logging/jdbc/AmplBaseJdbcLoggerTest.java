package org.apache.ibatis.logging.jdbc;


import java.sql.Array;
import org.apache.ibatis.logging.Log;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class AmplBaseJdbcLoggerTest {
    @Mock
    Log log;

    @Mock
    Array array;

    BaseJdbcLogger logger;

    @Before
    public void setUp() throws Exception {
        logger = new BaseJdbcLogger(log, 1) {};
    }
}

