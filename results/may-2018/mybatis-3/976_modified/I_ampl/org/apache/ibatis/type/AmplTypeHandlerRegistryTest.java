package org.apache.ibatis.type;


import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.Before;


public class AmplTypeHandlerRegistryTest {
    interface SomeInterface {}

    interface ExtendingSomeInterface extends AmplTypeHandlerRegistryTest.SomeInterface {}

    interface NoTypeHandlerInterface {}

    enum SomeEnum implements AmplTypeHandlerRegistryTest.SomeInterface {
        ;
    }

    enum ExtendingSomeEnum implements AmplTypeHandlerRegistryTest.ExtendingSomeInterface {
        ;
    }

    enum ImplementingMultiInterfaceSomeEnum implements AmplTypeHandlerRegistryTest.ExtendingSomeInterface , AmplTypeHandlerRegistryTest.NoTypeHandlerInterface {
        ;
    }

    enum NoTypeHandlerInterfaceEnum implements AmplTypeHandlerRegistryTest.NoTypeHandlerInterface {
        ;
    }

    class SomeClass implements AmplTypeHandlerRegistryTest.SomeInterface {}

    @MappedTypes(AmplTypeHandlerRegistryTest.SomeInterface.class)
    public static class SomeInterfaceTypeHandler<E extends Enum<E> & AmplTypeHandlerRegistryTest.SomeInterface> extends BaseTypeHandler<E> {
        @Override
        public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        }

        @Override
        public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
            return null;
        }

        @Override
        public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
            return null;
        }

        @Override
        public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
            return null;
        }
    }

    private TypeHandlerRegistry typeHandlerRegistry;

    @Before
    public void setup() {
        typeHandlerRegistry = new TypeHandlerRegistry();
    }
}

