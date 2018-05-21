package org.apache.ibatis.scripting.defaults;


import java.util.ArrayList;
import java.util.HashMap;
import org.apache.ibatis.builder.StaticSqlSource;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ResultMap;
import org.apache.ibatis.mapping.ResultMapping;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.TypeHandlerRegistry;


public class AmplDefaultParameterHandlerTest {
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

