package org.apache.ibatis.parsing;


import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;


public class AmplGenericTokenParserTest {
    public static class VariableTokenHandler implements TokenHandler {
        private Map<String, String> variables = new HashMap<String, String>();

        public VariableTokenHandler(Map<String, String> variables) {
            this.variables = variables;
        }

        @Override
        public String handleToken(String content) {
            return variables.get(content);
        }
    }

    @Ignore("Because it randomly fails on Travis CI. It could be useful during development.")
    @Test(timeout = 1000)
    public void shouldParseFastOnJdk7u6() {
        GenericTokenParser parser = new GenericTokenParser("${", "}", new AmplGenericTokenParserTest.VariableTokenHandler(new HashMap<String, String>() {
            {
                put("first_name", "James");
                put("initial", "T");
                put("last_name", "Kirk");
                put("", "");
            }
        }));
        StringBuilder input = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            input.append("${first_name} ${initial} ${last_name} reporting. ");
        }
        StringBuilder expected = new StringBuilder();
        for (int i = 0; i < 10000; i++) {
            expected.append("James T Kirk reporting. ");
        }
        Assert.assertEquals(expected.toString(), parser.parse(input.toString()));
    }
}

