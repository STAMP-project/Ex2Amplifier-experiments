package org.apache.ibatis.submitted.global_variables_defaults;


import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Property;
import org.apache.ibatis.annotations.Select;


public class AmplCustomizationTest {
    @CacheNamespace(implementation = SupportClasses.CustomCache.class, properties = { @Property(name = "name", value = "${cache:name?:default}") })
    private interface CustomDefaultValueSeparatorMapper {
        @Select("SELECT '${val != null ? val : 'default'}' FROM INFORMATION_SCHEMA.SYSTEM_USERS")
        public abstract String selectValue(@Param("val")
        String val);
    }
}

