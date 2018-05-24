package org.apache.ibatis.executor.resultset;


import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.ibatis.builder.StaticSqlSource;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.mapping.ResultMapping;
import org.apache.ibatis.mapping.SqlCommandType;
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
        return new MappedStatement.Builder(config, "testSelect", new StaticSqlSource(config, "some select statement"), SqlCommandType.SELECT).resultMaps(new ArrayList<ResultMap>() {
            {
                add(new ResultMap.Builder(config, "testMap", HashMap.class, new ArrayList<ResultMapping>() {
                    {
                        add(new ResultMapping.Builder(config, "cOlUmN1", "CoLuMn1", registry.getTypeHandler(Integer.class)).build());
                    }
                }).build());
            }
        }).build();
    }
}

