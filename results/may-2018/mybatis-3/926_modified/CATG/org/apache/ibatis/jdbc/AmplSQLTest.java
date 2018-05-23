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
    public void variableLengthArgumentOnHaving() throws Exception {
        final String sql = new SQL() {
            {
                SQL o_variableLengthArgumentOnHaving__6 = SELECT().HAVING("a = #{a}", "b = #{b}");
                Assert.assertEquals("HAVING (a = #{a} AND b = #{b}) \nOR () \nAND () \nOR () \nAND ()", (((o_variableLengthArgumentOnHaving__6).getSelf()).getSelf()).toString());
                Assert.assertEquals("HAVING (a = #{a} AND b = #{b}) \nOR () \nAND () \nOR () \nAND () \nOR () \nAND ()", ((o_variableLengthArgumentOnHaving__6).getSelf()).toString());
                Assert.assertEquals("HAVING (a = #{a} AND b = #{b}) \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND ()", (o_variableLengthArgumentOnHaving__6).toString());
            }
        }.toString();
        Assert.assertEquals("HAVING (a = #{a} AND b = #{b}) \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND ()", sql);
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
                Assert.assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?) \nOR () \nAND () \nOR () \nAND () \nOR () \nAND ()", ((o_shouldDemonstrateMixedStyle__8).getSelf()).toString());
                Assert.assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?) \nOR () \nAND () \nOR () \nAND ()", (((o_shouldDemonstrateMixedStyle__8).getSelf()).getSelf()).toString());
                Assert.assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?) \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND ()", (o_shouldDemonstrateMixedStyle__8).toString());
                Assert.assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?) \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND ()", (((o_shouldDemonstrateMixedStyle__7).getSelf()).getSelf()).toString());
                Assert.assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?) \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND ()", ((o_shouldDemonstrateMixedStyle__7).getSelf()).toString());
                Assert.assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?) \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND ()", (o_shouldDemonstrateMixedStyle__7).toString());
                Assert.assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?) \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND ()", ((o_shouldDemonstrateMixedStyle__6).getSelf()).toString());
                Assert.assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?) \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND ()", (o_shouldDemonstrateMixedStyle__6).toString());
                Assert.assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?) \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND ()", (((o_shouldDemonstrateMixedStyle__6).getSelf()).getSelf()).toString());
            }
        }.toString();
        Assert.assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?) \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND ()", sql);
        String String_0 = "" + (("SELECT id, name\n" + "FROM PERSON A\n") + "WHERE (name like ? AND id = ?)");
        Assert.assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?)", String_0);
        Assert.assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?) \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND ()", sql);
    }

    @Test(timeout = 120000)
    public void variableLengthArgumentOnWhere() throws Exception {
        final String sql = new SQL() {
            {
                SQL o_variableLengthArgumentOnWhere__6 = SELECT().WHERE("a = #{a}", "b = #{b}");
                Assert.assertEquals("WHERE (a = #{a} AND b = #{b}) \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND ()", (o_variableLengthArgumentOnWhere__6).toString());
                Assert.assertEquals("WHERE (a = #{a} AND b = #{b}) \nOR () \nAND () \nOR () \nAND ()", (((o_variableLengthArgumentOnWhere__6).getSelf()).getSelf()).toString());
                Assert.assertEquals("WHERE (a = #{a} AND b = #{b}) \nOR () \nAND () \nOR () \nAND () \nOR () \nAND ()", ((o_variableLengthArgumentOnWhere__6).getSelf()).toString());
            }
        }.toString();
        Assert.assertEquals("WHERE (a = #{a} AND b = #{b}) \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND ()", sql);
    }
}

