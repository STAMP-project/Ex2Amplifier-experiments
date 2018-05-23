package org.apache.ibatis.jdbc;


import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;


public class AmplSQLTest {
    private static SQL example1() {
        return new SQL() {
            {
                SELECT("P.ID, P.USERNAME, P.PASSWORD, P.FULL_NAME");
                SELECT("P.LAST_NAME, P.CREATED_ON, P.UPDATED_ON");
                FROM("PERSON P");
                FROM("ACCOUNT A");
                INNER_JOIN("DEPARTMENT D on D.ID = P.DEPARTMENT_ID");
                INNER_JOIN("COMPANY C on D.COMPANY_ID = C.ID");
                WHERE("P.ID = A.ID");
                WHERE("P.FIRST_NAME like ?");
                OR();
                WHERE("P.LAST_NAME like ?");
                GROUP_BY("P.ID");
                HAVING("P.LAST_NAME like ?");
                OR();
                HAVING("P.FIRST_NAME like ?");
                ORDER_BY("P.ID");
                ORDER_BY("P.FULL_NAME");
            }
        };
    }

    private static String example2(final String id, final String firstName, final String lastName) {
        return new SQL() {
            {
                SELECT("P.ID, P.USERNAME, P.PASSWORD, P.FIRST_NAME, P.LAST_NAME");
                FROM("PERSON P");
                if (id != null) {
                    WHERE("P.ID like #id#");
                }
                if (firstName != null) {
                    WHERE("P.FIRST_NAME like #firstName#");
                }
                if (lastName != null) {
                    WHERE("P.LAST_NAME like #lastName#");
                }
                ORDER_BY("P.LAST_NAME");
            }
        }.toString();
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274009litString275758() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("\u0000");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274009__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", o_fixFor903UpdateJoinslitString274009__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274009__7 = CoreMatchers.equalTo(":");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", o_fixFor903UpdateJoinslitString274009__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274726() throws Exception {
        final SQL sql = new SQL().UPDATE("").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283404() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274845() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("x3F[Mi)(@s");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET x3F[Mi)(@s", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET x3F[Mi)(@s", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET x3F[Mi)(@s", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET x3F[Mi)(@s", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET x3F[Mi)(@s", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET x3F[Mi)(@s", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET x3F[Mi)(@s", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET x3F[Mi)(@s", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283408() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.iF = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.iF = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.iF = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.iF = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.iF = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.iF = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.iF = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.iF = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.iF = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274015litString274535() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("b");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274015__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", o_fixFor903UpdateJoinslitString274015__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274015__7 = CoreMatchers.equalTo("{P;fqDx[My");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", o_fixFor903UpdateJoinslitString274015__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274842() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283400() throws Exception {
        final SQL sql = new SQL().UPDATE("b").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274009litString275755() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("\u0000");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274009__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", o_fixFor903UpdateJoinslitString274009__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274009__7 = CoreMatchers.equalTo("\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", o_fixFor903UpdateJoinslitString274009__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274758() throws Exception {
        final SQL sql = new SQL().UPDATE("=S]YjTX8N7").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE =S]YjTX8N7\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE =S]YjTX8N7\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE =S]YjTX8N7\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE =S]YjTX8N7\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE =S]YjTX8N7\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE =S]YjTX8N7\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE =S]YjTX8N7\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE =S]YjTX8N7\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276010() throws Exception {
        final SQL sql = new SQL().UPDATE("tabe1 a").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE tabe1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE tabe1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE tabe1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE tabe1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE tabe1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE tabe1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE tabe1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE tabe1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274878() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo(":");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276011() throws Exception {
        final SQL sql = new SQL().UPDATE("tTble1 a").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE tTble1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE tTble1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE tTble1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE tTble1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE tTble1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE tTble1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE tTble1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE tTble1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276012() throws Exception {
        final SQL sql = new SQL().UPDATE("tabl.e1 a").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE tabl.e1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE tabl.e1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE tabl.e1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE tabl.e1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE tabl.e1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE tabl.e1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE tabl.e1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE tabl.e1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274755() throws Exception {
        final SQL sql = new SQL().UPDATE("\n").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274876() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276013() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276014() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("\u0000").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \u0000\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \u0000\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \u0000\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \u0000\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \u0000\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \u0000\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \u0000\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \u0000\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274874() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("\u0000");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276015() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274871() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276016() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN(":").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274012litString275467() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET(":");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274012__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", o_fixFor903UpdateJoinslitString274012__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274012__7 = CoreMatchers.equalTo("a))Zz{H63[");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", o_fixFor903UpdateJoinslitString274012__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274751() throws Exception {
        final SQL sql = new SQL().UPDATE("\u0000").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276017() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("a").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276018() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("b").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276019() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274012litString275463() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET(":");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274012__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", o_fixFor903UpdateJoinslitString274012__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274012__7 = CoreMatchers.equalTo("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", o_fixFor903UpdateJoinslitString274012__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274800litString280700() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274015litString274523() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("b");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274015__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", o_fixFor903UpdateJoinslitString274015__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274015__7 = CoreMatchers.equalTo("a");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", o_fixFor903UpdateJoinslitString274015__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283416() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274736() throws Exception {
        final SQL sql = new SQL().UPDATE("rable1 a").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE rable1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE rable1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE rable1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE rable1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE rable1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE rable1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE rable1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE rable1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274015litString274527() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("b");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274015__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", o_fixFor903UpdateJoinslitString274015__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274015__7 = CoreMatchers.equalTo("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", o_fixFor903UpdateJoinslitString274015__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274733() throws Exception {
        final SQL sql = new SQL().UPDATE(":").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274015litString274525() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("b");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274015__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", o_fixFor903UpdateJoinslitString274015__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274015__7 = CoreMatchers.equalTo("b");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", o_fixFor903UpdateJoinslitString274015__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274731() throws Exception {
        final SQL sql = new SQL().UPDATE("\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283412() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TALE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TALE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TALE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TALE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TALE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TALE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TALE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TALE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TALE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274009litString275764() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("\u0000");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274009__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", o_fixFor903UpdateJoinslitString274009__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274009__7 = CoreMatchers.equalTo("a");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", o_fixFor903UpdateJoinslitString274009__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274009litString275767() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("\u0000");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274009__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", o_fixFor903UpdateJoinslitString274009__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274009__7 = CoreMatchers.equalTo("b");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", o_fixFor903UpdateJoinslitString274009__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274747() throws Exception {
        final SQL sql = new SQL().UPDATE("").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276020() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("#g)Dw8!Tbp").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN #g)Dw8!Tbp\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN #g)Dw8!Tbp\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN #g)Dw8!Tbp\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN #g)Dw8!Tbp\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN #g)Dw8!Tbp\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN #g)Dw8!Tbp\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN #g)Dw8!Tbp\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN #g)Dw8!Tbp\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276021() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("JOIN TABLE_A b ON b.id C a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id C a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id C a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id C a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id C a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id C a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id C a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id C a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id C a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276022() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("JOIN TABLE_A b ON b.i = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.i = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.i = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.i = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.i = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.i = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.i = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.i = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.i = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274864() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("a$value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a$value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a$value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a$value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a$value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a$value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a$value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a$value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a$value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276023() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("JOIN {TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN {TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN {TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN {TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN {TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN {TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN {TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN {TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN {TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276024() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET ", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET ", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET ", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET ", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276025() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("\u0000");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \u0000", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \u0000", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276026() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \n", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \n", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276027() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = bb.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = bb.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = bb.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = bb.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = bb.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = bb.value", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = bb.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = bb.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = bb.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274861() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("b");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET b", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET b", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276028() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET(":");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET :", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET :", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET :", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET :", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276029() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("-v< aiD(]5");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET -v< aiD(]5", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET -v< aiD(]5", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET -v< aiD(]5", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET -v< aiD(]5", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET -v< aiD(]5", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET -v< aiD(]5", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET -v< aiD(]5", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET -v< aiD(]5", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274015litString274517() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("b");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274015__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", o_fixFor903UpdateJoinslitString274015__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274015__7 = CoreMatchers.equalTo(":");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", o_fixFor903UpdateJoinslitString274015__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274728() throws Exception {
        final SQL sql = new SQL().UPDATE("\u0000").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274849() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("JOIN TALE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TALE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TALE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TALE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TALE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TALE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TALE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TALE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TALE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274015litString274512() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("b");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274015__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", o_fixFor903UpdateJoinslitString274015__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274015__7 = CoreMatchers.equalTo("\u0000");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", o_fixFor903UpdateJoinslitString274015__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274015litString274515() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("b");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274015__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", o_fixFor903UpdateJoinslitString274015__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274015__7 = CoreMatchers.equalTo("\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", o_fixFor903UpdateJoinslitString274015__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274745() throws Exception {
        final SQL sql = new SQL().UPDATE("> 8cV([z^b").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE > 8cV([z^b\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE > 8cV([z^b\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE > 8cV([z^b\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE > 8cV([z^b\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE > 8cV([z^b\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE > 8cV([z^b\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE > 8cV([z^b\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE > 8cV([z^b\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274742() throws Exception {
        final SQL sql = new SQL().UPDATE("b").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274860() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDAT table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274010litString275170() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274010__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", o_fixFor903UpdateJoinslitString274010__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274010__7 = CoreMatchers.equalTo("\u0000");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", o_fixFor903UpdateJoinslitString274010__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274010litString275173() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274010__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", o_fixFor903UpdateJoinslitString274010__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274010__7 = CoreMatchers.equalTo("\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", o_fixFor903UpdateJoinslitString274010__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274777() throws Exception {
        final SQL sql = new SQL().UPDATE("a").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274015litString274509() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("b");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274015__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", o_fixFor903UpdateJoinslitString274015__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274015__7 = CoreMatchers.equalTo("");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", o_fixFor903UpdateJoinslitString274015__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274773() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TAB+E_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TAB+E_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TAB+E_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TAB+E_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TAB+E_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TAB+E_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TAB+E_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TAB+E_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TAB+E_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274010litString275176() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274010__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", o_fixFor903UpdateJoinslitString274010__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274010__7 = CoreMatchers.equalTo("MtZ%(0u>&:");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", o_fixFor903UpdateJoinslitString274010__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274010litString275179() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274010__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", o_fixFor903UpdateJoinslitString274010__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274010__7 = CoreMatchers.equalTo(":");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", o_fixFor903UpdateJoinslitString274010__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274739() throws Exception {
        final SQL sql = new SQL().UPDATE("a").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274757() throws Exception {
        final SQL sql = new SQL().UPDATE("table a").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE table a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE table a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE table a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274879() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATEftable1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274877() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274753() throws Exception {
        final SQL sql = new SQL().UPDATE("tableX1 a").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE tableX1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE tableX1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE tableX1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE tableX1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE tableX1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE tableX1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE tableX1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE tableX1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274875() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE# table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274769() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b N b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b N b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b N b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b N b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b N b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b N b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b N b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b N b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b N b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274012litString275450() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET(":");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274012__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", o_fixFor903UpdateJoinslitString274012__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274012__7 = CoreMatchers.equalTo("");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", o_fixFor903UpdateJoinslitString274012__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274765() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TAXBLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274886() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USIG (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276002() throws Exception {
        final SQL sql = new SQL().UPDATE("").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE \nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE \nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE \nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274884() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER0 JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276003() throws Exception {
        final SQL sql = new SQL().UPDATE("\u0000").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274885() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276004() throws Exception {
        final SQL sql = new SQL().UPDATE("\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE \n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE \n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE \n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274761() throws Exception {
        final SQL sql = new SQL().UPDATE(":").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274882() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("b");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276005() throws Exception {
        final SQL sql = new SQL().UPDATE(":").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE :\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE :\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE :\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274012litString275456() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET(":");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274012__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", o_fixFor903UpdateJoinslitString274012__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274012__7 = CoreMatchers.equalTo(":");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", o_fixFor903UpdateJoinslitString274012__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274010litString275167() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274010__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", o_fixFor903UpdateJoinslitString274010__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274010__7 = CoreMatchers.equalTo("");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", o_fixFor903UpdateJoinslitString274010__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274883() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN tabl[2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276006() throws Exception {
        final SQL sql = new SQL().UPDATE("a").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274012litString275459() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET(":");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274012__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", o_fixFor903UpdateJoinslitString274012__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274012__7 = CoreMatchers.equalTo("b");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", o_fixFor903UpdateJoinslitString274012__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274880() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("Sf-C{uOG0{");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276007() throws Exception {
        final SQL sql = new SQL().UPDATE("b").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE b\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE b\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE b\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE b\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE b\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE b\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE b\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE b\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274012litString275458() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET(":");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274012__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", o_fixFor903UpdateJoinslitString274012__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274012__7 = CoreMatchers.equalTo("a");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", o_fixFor903UpdateJoinslitString274012__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274881() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("a");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276008() throws Exception {
        final SQL sql = new SQL().UPDATE("1pK}Tqm7RM").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE 1pK}Tqm7RM\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE 1pK}Tqm7RM\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE 1pK}Tqm7RM\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE 1pK}Tqm7RM\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE 1pK}Tqm7RM\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE 1pK}Tqm7RM\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE 1pK}Tqm7RM\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE 1pK}Tqm7RM\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274012litString275452() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET(":");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274012__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", o_fixFor903UpdateJoinslitString274012__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274012__7 = CoreMatchers.equalTo("\u0000");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", o_fixFor903UpdateJoinslitString274012__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274012litString275454() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET(":");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274012__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", o_fixFor903UpdateJoinslitString274012__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274012__7 = CoreMatchers.equalTo("\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", o_fixFor903UpdateJoinslitString274012__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274800() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274827() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("tUable2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274836() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("\u0000");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \u0000", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \u0000", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273997litString274841() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273997__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", o_fixFor903UpdateJoinslitString273997__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273997__7 = CoreMatchers.equalTo("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", o_fixFor903UpdateJoinslitString273997__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274832() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET ", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET ", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString284010() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoins() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoins__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoins__6);
        Matcher<String> o_fixFor903UpdateJoins__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b USING (ID)\\nSET a.value = b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoins__7).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoins__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString284014() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("a").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString284018() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("b").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274813() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("\u0000");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274810() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274819() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("b").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274815() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("a").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274008() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274008__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", o_fixFor903UpdateJoinslitString274008__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274008__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b USING (ID)\\nSET a.value = b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString274008__7).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", o_fixFor903UpdateJoinslitString274008__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274009() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("\u0000");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274009__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", o_fixFor903UpdateJoinslitString274009__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274009__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b USING (ID)\\nSET a.value = b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString274009__7).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", o_fixFor903UpdateJoinslitString274009__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274006() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("tableF b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN tableF b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN tableF b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN tableF b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274006__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN tableF b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274006__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274006__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b USING (ID)\\nSET a.value = b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString274006__7).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN tableF b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274006__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN tableF b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN tableF b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN tableF b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274007() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN(" KvvIKnE@G").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN  KvvIKnE@G\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN  KvvIKnE@G\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN  KvvIKnE@G\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274007__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN  KvvIKnE@G\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274007__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274007__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b USING (ID)\\nSET a.value = b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString274007__7).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN  KvvIKnE@G\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274007__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN  KvvIKnE@G\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN  KvvIKnE@G\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN  KvvIKnE@G\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274000() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING(ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING(ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING(ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING(ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274000__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING(ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274000__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274000__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b USING (ID)\\nSET a.value = b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString274000__7).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING(ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING(ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING(ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING(ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274000__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274001() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN(":").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274001__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274001__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274001__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b USING (ID)\\nSET a.value = b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString274001__7).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274001__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273997litString274837() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273997__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", o_fixFor903UpdateJoinslitString273997__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273997__7 = CoreMatchers.equalTo("b");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", o_fixFor903UpdateJoinslitString273997__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString284002() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN(":").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b USING (ID)\\nSET a.value = b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString274004__7).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274005() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("tabFle2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN tabFle2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN tabFle2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN tabFle2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274005__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN tabFle2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274005__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274005__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b USING (ID)\\nSET a.value = b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString274005__7).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN tabFle2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274005__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN tabFle2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN tabFle2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN tabFle2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273997litString274833() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273997__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", o_fixFor903UpdateJoinslitString273997__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273997__7 = CoreMatchers.equalTo("a");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", o_fixFor903UpdateJoinslitString273997__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274002() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("a").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274002__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274002__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274002__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b USING (ID)\\nSET a.value = b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString274002__7).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274002__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274805() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b U1SING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b U1SING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b U1SING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b U1SING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b U1SING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b U1SING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b U1SING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b U1SING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b U1SING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString284006() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (YD)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (YD)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (YD)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (YD)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (YD)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (YD)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (YD)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (YD)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (YD)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274003() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("b").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274003__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274003__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274003__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b USING (ID)\\nSET a.value = b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString274003__7).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274003__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274825() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET(":");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283192() throws Exception {
        final SQL sql = new SQL().UPDATE("\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE \n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE \n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE \n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE \n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274821() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b {N b.id = a.id\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b {N b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b {N b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b {N b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b {N b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b {N b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b {N b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b {N b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b {N b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void variableLengthArgumentOnHaving() throws Exception {
        final String sql = new SQL() {
            {
                SQL o_variableLengthArgumentOnHaving__6 = SELECT().HAVING("a = #{a}", "b = #{b}");
                Assert.assertEquals("HAVING (a = #{a} AND b = #{b}) \nAND () \nOR () \nAND () \nOR ()", (((o_variableLengthArgumentOnHaving__6).getSelf()).getSelf()).toString());
                Assert.assertEquals("HAVING (a = #{a} AND b = #{b}) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR ()", ((o_variableLengthArgumentOnHaving__6).getSelf()).toString());
                Assert.assertEquals("HAVING (a = #{a} AND b = #{b}) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR ()", (o_variableLengthArgumentOnHaving__6).toString());
            }
        }.toString();
        Assert.assertEquals("HAVING (a = #{a} AND b = #{b}) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR ()", sql);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283195() throws Exception {
        final SQL sql = new SQL().UPDATE(":").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE :\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE :\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE :\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274848() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET(":");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET :", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET :", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274019() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274019__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274019__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274019__7 = CoreMatchers.equalTo("");
        Assert.assertEquals("\"\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString274019__7).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274019__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276030() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274858() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("a");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276031() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("b");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET b", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET b", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET b", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET b", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b USING (ID)\\nSET a.value = b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString274017__7).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274855() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("a.Bvalue = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.Bvalue = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.Bvalue = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.Bvalue = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.Bvalue = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.Bvalue = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.Bvalue = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.Bvalue = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.Bvalue = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276032() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value =b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value =b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value =b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value =b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value =b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value =b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value =b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value =b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value =b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274018() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("|q4s(z+R0D");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET |q4s(z+R0D", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET |q4s(z+R0D", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET |q4s(z+R0D", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274018__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET |q4s(z+R0D", o_fixFor903UpdateJoinslitString274018__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274018__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b USING (ID)\\nSET a.value = b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString274018__7).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET |q4s(z+R0D", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET |q4s(z+R0D", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET |q4s(z+R0D", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET |q4s(z+R0D", o_fixFor903UpdateJoinslitString274018__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276033() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value =jb.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value =jb.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value =jb.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value =jb.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value =jb.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value =jb.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value =jb.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value =jb.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value =jb.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276034() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274851() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("@  (wyqc:h");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET @  (wyqc:h", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET @  (wyqc:h", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET @  (wyqc:h", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET @  (wyqc:h", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET @  (wyqc:h", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET @  (wyqc:h", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET @  (wyqc:h", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET @  (wyqc:h", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276037() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDAT table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274011() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("a.vaplue = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.vaplue = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.vaplue = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.vaplue = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274011__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.vaplue = b.value", o_fixFor903UpdateJoinslitString274011__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274011__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b USING (ID)\\nSET a.value = b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString274011__7).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.vaplue = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.vaplue = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.vaplue = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.vaplue = b.value", o_fixFor903UpdateJoinslitString274011__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273997litString274825() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273997__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", o_fixFor903UpdateJoinslitString273997__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273997__7 = CoreMatchers.equalTo(":");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", o_fixFor903UpdateJoinslitString273997__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274012() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET(":");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274012__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", o_fixFor903UpdateJoinslitString274012__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274012__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b USING (ID)\\nSET a.value = b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString274012__7).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET :", o_fixFor903UpdateJoinslitString274012__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276039() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSE0T a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274010() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274010__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", o_fixFor903UpdateJoinslitString274010__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274010__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b USING (ID)\\nSET a.value = b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString274010__7).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", o_fixFor903UpdateJoinslitString274010__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274015() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("b");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274015__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", o_fixFor903UpdateJoinslitString274015__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274015__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b USING (ID)\\nSET a.value = b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString274015__7).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", o_fixFor903UpdateJoinslitString274015__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273997litString274821() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273997__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", o_fixFor903UpdateJoinslitString273997__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273997__7 = CoreMatchers.equalTo("\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", o_fixFor903UpdateJoinslitString273997__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274818() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274016() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("a.vVlue = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.vVlue = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.vVlue = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.vVlue = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274016__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.vVlue = b.value", o_fixFor903UpdateJoinslitString274016__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274016__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b USING (ID)\\nSET a.value = b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString274016__7).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.vVlue = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.vVlue = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.vVlue = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.vVlue = b.value", o_fixFor903UpdateJoinslitString274016__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274013() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.vaue");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.vaue", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.vaue", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.vaue", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274013__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.vaue", o_fixFor903UpdateJoinslitString274013__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274013__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b USING (ID)\\nSET a.value = b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString274013__7).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.vaue", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.vaue", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.vaue", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.vaue", o_fixFor903UpdateJoinslitString274013__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274014() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("a");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274014__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", o_fixFor903UpdateJoinslitString274014__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274014__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b USING (ID)\\nSET a.value = b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString274014__7).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", o_fixFor903UpdateJoinslitString274014__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274837() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("JOINq TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOINq TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOINq TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOINq TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOINq TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOINq TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOINq TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOINq TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET JOINq TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283182() throws Exception {
        final SQL sql = new SQL().UPDATE("").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE \nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE \nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE \nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274833() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("b");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET b", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274839() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \n", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274028() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274028__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274028__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274028__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b UING (ID)\nSET a.value = b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b UING (ID)\\nSET a.value = b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString274028__7).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274028__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274844() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("a.vaue = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.vaue = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.vaue = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.vaue = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.vaue = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.vaue = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.vaue = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.vaue = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.vaue = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276043() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNE; JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274029() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274029__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274029__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274029__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value > b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b USING (ID)\\nSET a.value > b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString274029__7).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274029__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276044() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276045() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("/s<>L.pGyB");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274022() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274022__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274022__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274022__7 = CoreMatchers.equalTo("[^k?wk#d)k");
        Assert.assertEquals("\"[^k?wk#d)k\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString274022__7).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274022__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274023() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274023__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274023__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274023__7 = CoreMatchers.equalTo(":");
        Assert.assertEquals("\":\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString274023__7).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274023__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274020() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274020__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274020__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274020__7 = CoreMatchers.equalTo("\u0000");
        Assert.assertEquals("\"\u0000\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString274020__7).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274020__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283187() throws Exception {
        final SQL sql = new SQL().UPDATE("\u0000").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274021() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274021__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274021__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274021__7 = CoreMatchers.equalTo("\n");
        Assert.assertEquals("\"\\n\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString274021__7).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274021__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273997litString274817() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273997__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", o_fixFor903UpdateJoinslitString273997__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273997__7 = CoreMatchers.equalTo("\u0000");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", o_fixFor903UpdateJoinslitString273997__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274026() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274026__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274026__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274026__7 = CoreMatchers.equalTo("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("\"JOIN TABLE_A b ON b.id = a.id\\n\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString274026__7).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274026__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274829() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("a");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274027() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274027__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274027__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274027__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b4 USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b4 USING (ID)\\nSET a.value = b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString274027__7).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274027__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274024() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274024__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274024__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274024__7 = CoreMatchers.equalTo("a");
        Assert.assertEquals("\"a\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString274024__7).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274024__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274025() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274025__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274025__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274025__7 = CoreMatchers.equalTo("b");
        Assert.assertEquals("\"b\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString274025__7).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274025__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273997litString274813() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273997__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", o_fixFor903UpdateJoinslitString273997__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273997__7 = CoreMatchers.equalTo("");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", o_fixFor903UpdateJoinslitString273997__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString283998() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("G|6&|pddC3").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN G|6&|pddC3\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN G|6&|pddC3\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN G|6&|pddC3\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN G|6&|pddC3\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN G|6&|pddC3\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN G|6&|pddC3\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN G|6&|pddC3\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN G|6&|pddC3\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273999litString274277() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273999__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273999__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273999__7 = CoreMatchers.equalTo("");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273999__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273999litString274278() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273999__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273999__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273999__7 = CoreMatchers.equalTo("\u0000");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273999__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273999litString274280() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273999__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273999__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273999__7 = CoreMatchers.equalTo("\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273999__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273999litString274282() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273999__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273999__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273999__7 = CoreMatchers.equalTo(":");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273999__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273999litString274283() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273999__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273999__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273999__7 = CoreMatchers.equalTo("a");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273999__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273999litString274284() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273999__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273999__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273999__7 = CoreMatchers.equalTo("b");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273999__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273999litString274285() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273999__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273999__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273999__7 = CoreMatchers.equalTo("jHZ!_m@2]J");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273999__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274855litString283935() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.Bvalue = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.Bvalue = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.Bvalue = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.Bvalue = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.Bvalue = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.Bvalue = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.Bvalue = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.Bvalue = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.Bvalue = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString283990() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("\u0000").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString283994() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("\n").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString283977() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274807() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USIkG (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USIkG (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USIkG (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USIkG (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USIkG (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USIkG (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USIkG (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USIkG (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USIkG (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274811() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("Kb.J#eHU^P").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN Kb.J#eHU^P\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN Kb.J#eHU^P\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN Kb.J#eHU^P\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN Kb.J#eHU^P\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN Kb.J#eHU^P\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN Kb.J#eHU^P\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN Kb.J#eHU^P\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN Kb.J#eHU^P\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString283981() throws Exception {
        final SQL sql = new SQL().UPDATE("9,$AK=Mc&M").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE 9,$AK=Mc&M\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE 9,$AK=Mc&M\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE 9,$AK=Mc&M\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE 9,$AK=Mc&M\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE 9,$AK=Mc&M\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE 9,$AK=Mc&M\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE 9,$AK=Mc&M\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE 9,$AK=Mc&M\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString283986() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274765litString283605() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TAXBLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b (USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b (USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b (USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b (USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b (USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b (USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b (USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b (USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b (USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282804() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282803() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("\u0000");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString283965() throws Exception {
        final SQL sql = new SQL().UPDATE("b").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282801() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString283969() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.ivd\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.ivd\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.ivd\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.ivd\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.ivd\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.ivd\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.ivd\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.ivd\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.ivd\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274803() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN(":").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273997litString274853() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273997__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", o_fixFor903UpdateJoinslitString273997__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273997__7 = CoreMatchers.equalTo("l7Bv<?&*+t");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", o_fixFor903UpdateJoinslitString273997__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274014litString274371() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("a");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274014__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", o_fixFor903UpdateJoinslitString274014__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274014__7 = CoreMatchers.equalTo("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", o_fixFor903UpdateJoinslitString274014__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString283973() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b O b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b O b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b O b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b O b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b O b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b O b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b O b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b O b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b O b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274014litString274374() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("a");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274014__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", o_fixFor903UpdateJoinslitString274014__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274014__7 = CoreMatchers.equalTo("zXmd[UJ?0K");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", o_fixFor903UpdateJoinslitString274014__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274765litString283620() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TAXBLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("a.vGalue = b.value");
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.vGalue = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.vGalue = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.vGalue = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.vGalue = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.vGalue = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.vGalue = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.vGalue = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.vGalue = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274014litString274362() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("a");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274014__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", o_fixFor903UpdateJoinslitString274014__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274014__7 = CoreMatchers.equalTo("b");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", o_fixFor903UpdateJoinslitString274014__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274765litString283626() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TAXBLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274765litString283607() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TAXBLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274008litString275599() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274008__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", o_fixFor903UpdateJoinslitString274008__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274008__7 = CoreMatchers.equalTo("\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", o_fixFor903UpdateJoinslitString274008__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274014litString274356() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("a");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274014__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", o_fixFor903UpdateJoinslitString274014__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274014__7 = CoreMatchers.equalTo(":");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", o_fixFor903UpdateJoinslitString274014__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274014litString274359() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("a");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274014__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", o_fixFor903UpdateJoinslitString274014__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274014__7 = CoreMatchers.equalTo("a");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", o_fixFor903UpdateJoinslitString274014__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274008litString275597() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274008__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", o_fixFor903UpdateJoinslitString274008__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274008__7 = CoreMatchers.equalTo("\u0000");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", o_fixFor903UpdateJoinslitString274008__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274008litString275595() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274008__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", o_fixFor903UpdateJoinslitString274008__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274008__7 = CoreMatchers.equalTo("");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", o_fixFor903UpdateJoinslitString274008__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274010litString275183() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274010__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", o_fixFor903UpdateJoinslitString274010__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274010__7 = CoreMatchers.equalTo("a");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", o_fixFor903UpdateJoinslitString274010__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274010litString275186() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274010__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", o_fixFor903UpdateJoinslitString274010__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274010__7 = CoreMatchers.equalTo("b");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", o_fixFor903UpdateJoinslitString274010__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274014litString274350() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("a");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274014__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", o_fixFor903UpdateJoinslitString274014__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274014__7 = CoreMatchers.equalTo("\u0000");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", o_fixFor903UpdateJoinslitString274014__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274014litString274353() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("a");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274014__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", o_fixFor903UpdateJoinslitString274014__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274014__7 = CoreMatchers.equalTo("\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", o_fixFor903UpdateJoinslitString274014__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274855litString283972() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void shouldDemonstrateMixedStyle() throws Exception {
        final String sql = new SQL() {
            {
                SQL o_shouldDemonstrateMixedStyle__6 = SELECT("id, name");
                Assert.assertEquals("SELECT id, name", ((o_shouldDemonstrateMixedStyle__6).getSelf()).toString());
                Assert.assertEquals("SELECT id, name", (o_shouldDemonstrateMixedStyle__6).toString());
                Assert.assertEquals("SELECT id, name", (((o_shouldDemonstrateMixedStyle__6).getSelf()).getSelf()).toString());
                SQL o_shouldDemonstrateMixedStyle__7 = FROM("PERSON A");
                Assert.assertEquals("SELECT id, name\nFROM PERSON A", (((o_shouldDemonstrateMixedStyle__7).getSelf()).getSelf()).toString());
                Assert.assertEquals("SELECT id, name\nFROM PERSON A", ((o_shouldDemonstrateMixedStyle__7).getSelf()).toString());
                Assert.assertEquals("SELECT id, name\nFROM PERSON A", (o_shouldDemonstrateMixedStyle__7).toString());
                SQL o_shouldDemonstrateMixedStyle__8 = WHERE("name like ?").WHERE("id = ?");
                Assert.assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR ()", ((o_shouldDemonstrateMixedStyle__8).getSelf()).toString());
                Assert.assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?) \nAND () \nOR () \nAND () \nOR ()", (((o_shouldDemonstrateMixedStyle__8).getSelf()).getSelf()).toString());
                Assert.assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR ()", (o_shouldDemonstrateMixedStyle__8).toString());
                Assert.assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR ()", (((o_shouldDemonstrateMixedStyle__7).getSelf()).getSelf()).toString());
                Assert.assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR ()", ((o_shouldDemonstrateMixedStyle__7).getSelf()).toString());
                Assert.assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR ()", (o_shouldDemonstrateMixedStyle__7).toString());
                Assert.assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR ()", ((o_shouldDemonstrateMixedStyle__6).getSelf()).toString());
                Assert.assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR ()", (o_shouldDemonstrateMixedStyle__6).toString());
                Assert.assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR ()", (((o_shouldDemonstrateMixedStyle__6).getSelf()).getSelf()).toString());
            }
        }.toString();
        Assert.assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR ()", sql);
        String String_0 = "" + (("SELECT id, name\n" + "FROM PERSON A\n") + "WHERE (name like ? AND id = ?)");
        Assert.assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?)", String_0);
        Assert.assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR ()", sql);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274014litString274347() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("a");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274014__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", o_fixFor903UpdateJoinslitString274014__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274014__7 = CoreMatchers.equalTo("");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", o_fixFor903UpdateJoinslitString274014__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274765litString283647() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TAXBLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\n;INNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276034litString283818() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282739() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("a").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282735() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN(":").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282731() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283219() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.i = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.i = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.i = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.i = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.i = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.i = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.i = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.i = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.i = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283211() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283215() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.aid\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.aid\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.aid\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.aid\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.aid\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.aid\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.aid\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.aid\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.aid\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282749() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b MON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b MON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b MON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b MON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b MON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b MON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b MON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b MON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b MON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282747() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("Bw9}QLk*>-").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN Bw9}QLk*>-\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN Bw9}QLk*>-\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN Bw9}QLk*>-\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN Bw9}QLk*>-\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN Bw9}QLk*>-\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN Bw9}QLk*>-\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN Bw9}QLk*>-\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN Bw9}QLk*>-\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282743() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("b").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283207() throws Exception {
        final SQL sql = new SQL().UPDATE("b").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE b\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE b\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE b\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE b\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE b\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE b\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE b\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE b\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283200() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.Cd\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.Cd\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.Cd\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.Cd\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.Cd\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.Cd\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.Cd\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.Cd\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.Cd\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274765litString283656() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TAXBLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING UID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283204() throws Exception {
        final SQL sql = new SQL().UPDATE("a").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282756() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN ABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN ABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN ABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN ABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN ABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN ABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN ABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN ABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN ABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282752() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283310() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283312() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("s,[FFO]<_{");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282768() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET ", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET ", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET ", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET ", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274827litString283844() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("tUable2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2a b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282764() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("^#&$|nG?Vp");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET ^#&$|nG?Vp", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET ^#&$|nG?Vp", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET ^#&$|nG?Vp", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET ^#&$|nG?Vp", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET ^#&$|nG?Vp", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET ^#&$|nG?Vp", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET ^#&$|nG?Vp", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET ^#&$|nG?Vp", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282760() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON j.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON j.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON j.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON j.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON j.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON j.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON j.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON j.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON j.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283307() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("b");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283308() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274003litString275997() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("b").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274003__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274003__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274003__7 = CoreMatchers.equalTo("a");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274003__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283305() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("a");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274003litString275998() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("b").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274003__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274003__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274003__7 = CoreMatchers.equalTo("b");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274003__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274003litString275995() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("b").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274003__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274003__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274003__7 = CoreMatchers.equalTo(":");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274003__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274003litString275996() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("b").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274003__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274003__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274003__7 = CoreMatchers.equalTo("P?SmT#E|EF");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274003__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274003litString275993() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("b").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274003__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274003__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274003__7 = CoreMatchers.equalTo("\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274003__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283309() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.Fvalue");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274003litString275991() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("b").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274003__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274003__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274003__7 = CoreMatchers.equalTo("");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274003__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274003litString275992() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("b").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274003__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274003__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274003__7 = CoreMatchers.equalTo("\u0000");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274003__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283300() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATe table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283303() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo(":");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274807litString284280() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USIkG (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USIkG (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USIkG (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USIkG (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USIkG (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USIkG (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USIkG (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USIkG (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USIkG (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString283957() throws Exception {
        final SQL sql = new SQL().UPDATE(":").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282813() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JON table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274827litString283757() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.iud = a.id\n").INNER_JOIN("tUable2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.iud = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.iud = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.iud = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.iud = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.iud = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.iud = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.iud = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.iud = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282812() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282811() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value =Ab.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282810() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 bc USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274001litString274665() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN(":").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274001__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274001__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274001__7 = CoreMatchers.equalTo("");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274001__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274001litString274667() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN(":").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274001__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274001__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274001__7 = CoreMatchers.equalTo("\u0000");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274001__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274765litString283584() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TcXBLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TcXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TcXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TcXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TcXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TcXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TcXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TcXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TcXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282809() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("b");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282808() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("a");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282807() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo(":");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString283961() throws Exception {
        final SQL sql = new SQL().UPDATE("a").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282806() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("M6b!V<)<[R");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString283946() throws Exception {
        final SQL sql = new SQL().UPDATE("\u0000").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282705() throws Exception {
        final SQL sql = new SQL().UPDATE("a").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString283949() throws Exception {
        final SQL sql = new SQL().UPDATE("\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282701() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = Da.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = Da.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = Da.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = Da.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = Da.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = Da.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = Da.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = Da.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = Da.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274807litString284265() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274001litString274675() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN(":").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274001__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274001__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274001__7 = CoreMatchers.equalTo(":");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274001__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274001litString274678() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN(":").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274001__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274001__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274001__7 = CoreMatchers.equalTo("a");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274001__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274765litString283574() throws Exception {
        final SQL sql = new SQL().UPDATE("JMOIN TAXBLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JMOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JMOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JMOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JMOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JMOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JMOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JMOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JMOIN TAXBLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString283953() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b)id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b)id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b)id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b)id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b)id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b)id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b)id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b)id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b)id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274001litString274670() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN(":").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274001__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274001__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274001__7 = CoreMatchers.equalTo("\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274001__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282717() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274827litString283777() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274827litString283779() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("tUable2 b USING (I+D)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (I+D)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (I+D)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (I+D)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (I+D)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (I+D)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (I+D)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (I+D)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (I+D)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282713() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_v b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_v b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_v b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_v b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_v b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_v b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_v b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_v b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_v b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283388() throws Exception {
        final SQL sql = new SQL().UPDATE("om!`!:Y_^g").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE om!`!:Y_^g\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE om!`!:Y_^g\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE om!`!:Y_^g\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE om!`!:Y_^g\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE om!`!:Y_^g\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE om!`!:Y_^g\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE om!`!:Y_^g\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE om!`!:Y_^g\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void variableLengthArgumentOnWhere() throws Exception {
        final String sql = new SQL() {
            {
                SQL o_variableLengthArgumentOnWhere__6 = SELECT().WHERE("a = #{a}", "b = #{b}");
                Assert.assertEquals("WHERE (a = #{a} AND b = #{b}) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR ()", (o_variableLengthArgumentOnWhere__6).toString());
                Assert.assertEquals("WHERE (a = #{a} AND b = #{b}) \nAND () \nOR () \nAND () \nOR ()", (((o_variableLengthArgumentOnWhere__6).getSelf()).getSelf()).toString());
                Assert.assertEquals("WHERE (a = #{a} AND b = #{b}) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR ()", ((o_variableLengthArgumentOnWhere__6).getSelf()).toString());
            }
        }.toString();
        Assert.assertEquals("WHERE (a = #{a} AND b = #{b}) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR ()", sql);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274001litString274683() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN(":").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274001__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274001__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274001__7 = CoreMatchers.equalTo("m7^RE 2.sC");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274001__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283380() throws Exception {
        final SQL sql = new SQL().UPDATE("\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274001litString274686() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN(":").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274001__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274001__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274001__7 = CoreMatchers.equalTo("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274001__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283384() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b5.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b5.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b5.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b5.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b5.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b5.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b5.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b5.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b5.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString283941() throws Exception {
        final SQL sql = new SQL().UPDATE("").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282709() throws Exception {
        final SQL sql = new SQL().UPDATE("b").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE b\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE b\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE b\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE b\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE b\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE b\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE b\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE b\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274001litString274681() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN(":").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274001__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274001__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274001__7 = CoreMatchers.equalTo("b");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274001__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282727() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("\u0000").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274827litString283765() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("tzable2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tzable2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tzable2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tzable2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tzable2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tzable2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tzable2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tzable2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tzable2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282725() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283396() throws Exception {
        final SQL sql = new SQL().UPDATE("a").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283392() throws Exception {
        final SQL sql = new SQL().UPDATE(":").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282719() throws Exception {
        final SQL sql = new SQL().UPDATE("(vY`yX_)Pd").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE (vY`yX_)Pd\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE (vY`yX_)Pd\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE (vY`yX_)Pd\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE (vY`yX_)Pd\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE (vY`yX_)Pd\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE (vY`yX_)Pd\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE (vY`yX_)Pd\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE (vY`yX_)Pd\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283290() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = .value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = .value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = .value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = .value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = .value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = .value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = .value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = .value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = .value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283296() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("\u0000");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283293() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283294() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282697() throws Exception {
        final SQL sql = new SQL().UPDATE(":").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE :\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE :\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE :\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE :\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283487() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("V-Ce#v!|pH");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282693() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_Ab ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_Ab ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_Ab ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_Ab ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_Ab ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_Ab ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_Ab ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_Ab ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_Ab ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274785litString284412() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273986() throws Exception {
        final SQL sql = new SQL().UPDATE("").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273986__6 = sql.toString();
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273986__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273986__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b USING (ID)\\nSET a.value = b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString273986__7).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273986__6);
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString284051() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON@b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON@b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON@b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON@b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON@b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON@b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON@b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON@b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON@b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273987() throws Exception {
        final SQL sql = new SQL().UPDATE("\u0000").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273987__6 = sql.toString();
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273987__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273987__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b USING (ID)\\nSET a.value = b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString273987__7).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273987__6);
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString284054() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("H/;]ITB[JZ");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET H/;]ITB[JZ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET H/;]ITB[JZ", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET H/;]ITB[JZ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET H/;]ITB[JZ", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET H/;]ITB[JZ", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET H/;]ITB[JZ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET H/;]ITB[JZ", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET H/;]ITB[JZ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273988() throws Exception {
        final SQL sql = new SQL().UPDATE("\n").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273988__6 = sql.toString();
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273988__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273988__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b USING (ID)\\nSET a.value = b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString273988__7).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273988__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283483() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273989() throws Exception {
        final SQL sql = new SQL().UPDATE("tabble1 a").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE tabble1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE tabble1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE tabble1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273989__6 = sql.toString();
        Assert.assertEquals("UPDATE tabble1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273989__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273989__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b USING (ID)\\nSET a.value = b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString273989__7).toString());
        Assert.assertEquals("UPDATE tabble1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE tabble1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE tabble1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE tabble1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273989__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString284057() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283298() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274002litString275930() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("a").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274002__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274002__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274002__7 = CoreMatchers.equalTo("\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274002__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283280() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.vawlue");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.vawlue", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.vawlue", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.vawlue", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.vawlue", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.vawlue", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.vawlue", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.vawlue", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.vawlue", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274884litString284101() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER0 JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274002litString275932() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("a").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274002__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274002__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274002__7 = CoreMatchers.equalTo(":");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274002__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274002litString275933() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("a").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274002__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274002__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274002__7 = CoreMatchers.equalTo("a");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274002__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283284() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("(tlKM6)n$+");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET (tlKM6)n$+", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET (tlKM6)n$+", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET (tlKM6)n$+", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET (tlKM6)n$+", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET (tlKM6)n$+", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET (tlKM6)n$+", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET (tlKM6)n$+", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET (tlKM6)n$+", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283282() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET(":");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET :", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET :", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET :", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET :", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283376() throws Exception {
        final SQL sql = new SQL().UPDATE("\u0000").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273997() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273997__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", o_fixFor903UpdateJoinslitString273997__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273997__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b USING (ID)\\nSET a.value = b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString273997__7).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", o_fixFor903UpdateJoinslitString273997__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString284040() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("b");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET b", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET b", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273998() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("\u0000").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \u0000\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \u0000\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \u0000\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273998__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \u0000\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273998__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273998__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b USING (ID)\\nSET a.value = b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString273998__7).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \u0000\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \u0000\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \u0000\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \u0000\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273998__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273995() throws Exception {
        final SQL sql = new SQL().UPDATE("*5^-z.5X+)").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE *5^-z.5X+)\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE *5^-z.5X+)\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE *5^-z.5X+)\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273995__6 = sql.toString();
        Assert.assertEquals("UPDATE *5^-z.5X+)\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273995__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273995__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b USING (ID)\\nSET a.value = b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString273995__7).toString());
        Assert.assertEquals("UPDATE *5^-z.5X+)\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE *5^-z.5X+)\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE *5^-z.5X+)\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE *5^-z.5X+)\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273995__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273996() throws Exception {
        final SQL sql = new SQL().UPDATE("t%ble1 a").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE t%ble1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE t%ble1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE t%ble1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273996__6 = sql.toString();
        Assert.assertEquals("UPDATE t%ble1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273996__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273996__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b USING (ID)\\nSET a.value = b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString273996__7).toString());
        Assert.assertEquals("UPDATE t%ble1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273996__6);
        Assert.assertEquals("UPDATE t%ble1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE t%ble1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE t%ble1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283371() throws Exception {
        final SQL sql = new SQL().UPDATE("").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283491() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2  USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273999() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273999__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273999__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273999__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b USING (ID)\\nSET a.value = b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString273999__7).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273999__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString284042() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283288() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("b");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET b", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET b", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET b", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET b", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273990() throws Exception {
        final SQL sql = new SQL().UPDATE("tabl1 a").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE tabl1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE tabl1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE tabl1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273990__6 = sql.toString();
        Assert.assertEquals("UPDATE tabl1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273990__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273990__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b USING (ID)\\nSET a.value = b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString273990__7).toString());
        Assert.assertEquals("UPDATE tabl1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273990__6);
        Assert.assertEquals("UPDATE tabl1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE tabl1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE tabl1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274002litString275928() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("a").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274002__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274002__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274002__7 = CoreMatchers.equalTo("\u0000");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274002__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283286() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString284045() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id =a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id =a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id =a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id =a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id =a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id =a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id =a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id =a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id =a.id\n", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273993() throws Exception {
        final SQL sql = new SQL().UPDATE("b").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273993__6 = sql.toString();
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273993__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273993__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b USING (ID)\\nSET a.value = b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString273993__7).toString());
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273993__6);
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b USING (ID)\\nSET a.value = b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString273994__7).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273991() throws Exception {
        final SQL sql = new SQL().UPDATE(":").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273991__6 = sql.toString();
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273991__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273991__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b USING (ID)\\nSET a.value = b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString273991__7).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE :\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273991__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273992() throws Exception {
        final SQL sql = new SQL().UPDATE("a").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273992__6 = sql.toString();
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273992__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273992__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("\"UPDATE table1 a\\nINNER JOIN table2 b USING (ID)\\nSET a.value = b.value\"", ((org.hamcrest.core.IsEqual)o_fixFor903UpdateJoinslitString273992__7).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273992__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274002litString275926() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("a").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274002__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274002__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274002__7 = CoreMatchers.equalTo("");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274002__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString284049() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON Ab.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON Ab.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON Ab.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON Ab.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON Ab.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON Ab.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON Ab.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON Ab.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON Ab.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283273() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET ", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET ", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET ", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET ", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283274() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("\u0000");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \u0000", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \u0000", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283463() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283466() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("\u0000");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283468() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274008litString275601() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274008__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", o_fixFor903UpdateJoinslitString274008__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274008__7 = CoreMatchers.equalTo("`n2e_O$(6M");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", o_fixFor903UpdateJoinslitString274008__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString284032() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283461() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TA>BLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TA>BLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TA>BLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TA>BLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TA>BLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TA>BLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TA>BLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TA>BLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TA>BLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283460() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE(A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE(A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE(A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE(A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE(A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE(A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE(A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE(A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE(A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283277() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("aRvalue = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET aRvalue = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET aRvalue = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET aRvalue = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET aRvalue = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET aRvalue = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET aRvalue = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET aRvalue = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET aRvalue = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283278() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \n", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274008litString275607() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274008__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", o_fixFor903UpdateJoinslitString274008__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274008__7 = CoreMatchers.equalTo("b");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", o_fixFor903UpdateJoinslitString274008__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString284035() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET(":");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET :", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET :", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274008litString275605() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274008__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", o_fixFor903UpdateJoinslitString274008__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274008__7 = CoreMatchers.equalTo("a");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", o_fixFor903UpdateJoinslitString274008__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274002litString275935() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("a").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274002__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274002__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274002__7 = CoreMatchers.equalTo("b");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274002__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274008litString275603() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274008__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", o_fixFor903UpdateJoinslitString274008__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274008__7 = CoreMatchers.equalTo(":");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", o_fixFor903UpdateJoinslitString274008__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString284038() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("a");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283262() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TBLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TBLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TBLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TBLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TBLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TBLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TBLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TBLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TBLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283474() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("b");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283477() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE tab&e1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283479() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE tYable1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString284022() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283470() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo(":");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283472() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("a");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString284026() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET ", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET ", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283266() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString284024() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USINOG (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USINOG (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USINOG (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USINOG (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USINOG (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USINOG (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USINOG (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USINOG (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USINOG (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274002litString275945() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("a").SET("a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274002__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274002__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274002__7 = CoreMatchers.equalTo("jd11hbkEF6");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274002__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString284029() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("\u0000");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \u0000", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \u0000", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274008litString275613() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274008__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", o_fixFor903UpdateJoinslitString274008__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274008__7 = CoreMatchers.equalTo("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", o_fixFor903UpdateJoinslitString274008__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283448() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("K?UU8#fl!r");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET K?UU8#fl!r", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET K?UU8#fl!r", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET K?UU8#fl!r", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET K?UU8#fl!r", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET K?UU8#fl!r", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET K?UU8#fl!r", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET K?UU8#fl!r", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET K?UU8#fl!r", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274766() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("\u0000").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \u0000\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \u0000\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \u0000\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \u0000\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \u0000\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \u0000\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \u0000\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \u0000\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283251() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("W]>r7E:3Yg").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN W]>r7E:3Yg\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN W]>r7E:3Yg\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN W]>r7E:3Yg\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN W]>r7E:3Yg\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN W]>r7E:3Yg\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN W]>r7E:3Yg\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN W]>r7E:3Yg\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN W]>r7E:3Yg\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282776() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.ialue = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.ialue = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.ialue = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.ialue = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.ialue = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.ialue = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.ialue = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.ialue = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.ialue = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283441() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET ", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET ", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET ", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274763() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282772() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("\u0000");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \u0000", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \u0000", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283444() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("\u0000");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \u0000", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \u0000", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283446() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \n", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274799() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274796() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b UING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b UING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b UING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b UING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b UING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b UING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b UING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b UING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b UING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283255() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("a").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274793() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("\u0000").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274883litString284588() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN tabl[2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283259() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("b").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274779() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN(":").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN :\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283452() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("a");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282786() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274774() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("\n").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN \n\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283454() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("b");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET b", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET b", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString284080() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.val/e = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283456() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282782() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET(":");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET :", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET :", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET :", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET :", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274770() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("ta`le2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN ta`le2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN ta`le2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN ta`le2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN ta`le2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN ta`le2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN ta`le2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN ta`le2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN ta`le2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283458() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON bid = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON bid = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON bid = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON bid = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON bid = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON bid = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON bid = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON bid = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON bid = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282780() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \n", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \n", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET \n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274789() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274785() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283450() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET(":");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET :", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET :", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET :", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274781() throws Exception {
        final SQL sql = new SQL().UPDATE("b").INNER_JOIN("table2 b USING (ID)").SET("a.value = b.value");
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE b\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283243() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN(":").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283247() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b O;N b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b O;N b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b O;N b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b O;N b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b O;N b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b O;N b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b O;N b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b O;N b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b O;N b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283427() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("nyvh&zrQ)9").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN nyvh&zrQ)9\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN nyvh&zrQ)9\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN nyvh&zrQ)9\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN nyvh&zrQ)9\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN nyvh&zrQ)9\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN nyvh&zrQ)9\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN nyvh&zrQ)9\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN nyvh&zrQ)9\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283429() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("a").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN a\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274827litString283812() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("tUable2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282799() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.alue");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.alue", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.alue", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.alue", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.alue", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.alue", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.alue", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.alue", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.alue", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274787() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("b").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN b\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274827litString283816() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("tUable2 b USING (ID)").SET("a.val5ue = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET a.val5ue = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET a.val5ue = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET a.val5ue = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET a.val5ue = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET a.val5ue = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET a.val5ue = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET a.val5ue = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tUable2 b USING (ID)\nSET a.val5ue = b.value", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282796() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274783() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("a").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN a\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283420() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("\u0000").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282794() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value- = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value- = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value- = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value- = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value- = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value- = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value- = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value- = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value- = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283423() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("\n").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283425() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN(":").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN :\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282790() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("b");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET b", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET b", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET b", o_fixFor903UpdateJoinslitString274004__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET b", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET b", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString284073() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN tble2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283239() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id =$a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id =$a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id =$a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id =$a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id =$a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id =$a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id =$a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id =$a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id =$a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString284070() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("b");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString284077() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value v= b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString284075() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("h&t]:H9:Il");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283233() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("\u0000").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \u0000\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString284078() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283236() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283437() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("tab=le2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tab=le2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tab=le2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tab=le2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tab=le2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tab=le2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tab=le2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tab=le2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN tab=le2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274009litString275749() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("table2 b USING (ID)").SET("\u0000");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274009__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", o_fixFor903UpdateJoinslitString274009__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274009__7 = CoreMatchers.equalTo("");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET \u0000", o_fixFor903UpdateJoinslitString274009__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283439() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (>D)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (>D)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (>D)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (>D)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (>D)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (>D)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (>D)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (>D)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (>D)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282689() throws Exception {
        final SQL sql = new SQL().UPDATE("\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE \n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE \n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE \n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE \n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274795() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("tabe2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN tabe2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN tabe2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN tabe2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN tabe2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN tabe2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN tabe2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN tabe2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN tabe2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283431() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("b").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN b\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282685() throws Exception {
        final SQL sql = new SQL().UPDATE("\u0000").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE \u0000\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274791() throws Exception {
        final SQL sql = new SQL().UPDATE("table1 a").INNER_JOIN("q:G,g0U80M").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN q:G,g0U80M\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN q:G,g0U80M\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN q:G,g0U80M\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN q:G,g0U80M\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN q:G,g0U80M\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN q:G,g0U80M\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN q:G,g0U80M\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE table1 a\nINNER JOIN q:G,g0U80M\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283433() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b SING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b SING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b SING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b SING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b SING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b SING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b SING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b SING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b SING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274867litString283436() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString273994__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274004litString276009litString282681() throws Exception {
        final SQL sql = new SQL().UPDATE("").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE \nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274004__6 = sql.toString();
        Assert.assertEquals("UPDATE \nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274004__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE \nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        Assert.assertEquals("UPDATE \nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString274004__6);
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString284062() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString284060() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("\u0000");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283229() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("").SET("a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN \nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString284064() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo(":");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString274017litString274750litString284067() throws Exception {
        final SQL sql = new SQL().UPDATE("JOIN TABLE_A b ON b.id = a.id\n").INNER_JOIN("table2 b USING (ID)").SET("JOIN TABLE_A b ON b.id = a.id\n");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString274017__6 = sql.toString();
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Matcher<String> o_fixFor903UpdateJoinslitString274017__7 = CoreMatchers.equalTo("a");
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", o_fixFor903UpdateJoinslitString274017__6);
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE JOIN TABLE_A b ON b.id = a.id\n\nINNER JOIN table2 b USING (ID)\nSET JOIN TABLE_A b ON b.id = a.id\n", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }

    @Test(timeout = 120000)
    public void fixFor903UpdateJoinslitString273994litString274823litString283224() throws Exception {
        final SQL sql = new SQL().UPDATE("`GyTRW>DVi").INNER_JOIN("JOIN TABLE_A b ON b.id = a.id\n").SET("a.value = b.value");
        Assert.assertEquals("UPDATE `GyTRW>DVi\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE `GyTRW>DVi\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE `GyTRW>DVi\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
        String o_fixFor903UpdateJoinslitString273994__6 = sql.toString();
        Assert.assertEquals("UPDATE `GyTRW>DVi\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Matcher<String> o_fixFor903UpdateJoinslitString273994__7 = CoreMatchers.equalTo("UPDATE table1 a\nINNER JOIN table2 b USING (ID)\nSET a.value = b.value");
        Assert.assertEquals("UPDATE `GyTRW>DVi\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", o_fixFor903UpdateJoinslitString273994__6);
        Assert.assertEquals("UPDATE `GyTRW>DVi\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).getSelf()).toString());
        Assert.assertEquals("UPDATE `GyTRW>DVi\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)sql).toString());
        Assert.assertEquals("UPDATE `GyTRW>DVi\nINNER JOIN JOIN TABLE_A b ON b.id = a.id\n\nSET a.value = b.value", ((org.apache.ibatis.jdbc.SQL)((org.apache.ibatis.jdbc.SQL)sql).getSelf()).toString());
    }
}

