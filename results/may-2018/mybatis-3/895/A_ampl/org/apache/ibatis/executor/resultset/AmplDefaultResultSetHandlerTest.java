package org.apache.ibatis.executor.resultset;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class AmplDefaultResultSetHandlerTest {
    @Mock
    private Statement stmt;

    @Mock
    private ResultSet rs;

    @Mock
    private ResultSetMetaData rsmd;

    @Mock
    private Connection conn;

    @Mock
    private DatabaseMetaData dbmd;

    MappedStatement getMappedStatement() {
        final Configuration config = new Configuration();
        final TypeHandlerRegistry registry = config.getTypeHandlerRegistry();
        return resultMaps(new ArrayList<ResultMap>() {
            {
                add(build());
            }
        }).build();
    }
}

