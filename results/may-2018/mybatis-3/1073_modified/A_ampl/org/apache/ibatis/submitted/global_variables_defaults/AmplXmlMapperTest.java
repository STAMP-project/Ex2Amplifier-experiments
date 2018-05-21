package org.apache.ibatis.submitted.global_variables_defaults;


public class AmplXmlMapperTest {
    public interface XmlMapper {
        public abstract String ping();

        public abstract String selectOne();

        public abstract String selectFromVariable();
    }
}

