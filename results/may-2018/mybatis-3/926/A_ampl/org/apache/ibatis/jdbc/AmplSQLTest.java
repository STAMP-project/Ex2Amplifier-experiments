package org.apache.ibatis.jdbc;


import org.junit.Assert;
import org.junit.Test;


public class AmplSQLTest {
    private static String example1() {
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
        }.toString();
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
                Assert.assertEquals("HAVING (a = #{a} AND b = #{b}) \nAND () \nOR () \nAND () \nOR ()", o_variableLengthArgumentOnHaving__6.getSelf().getSelf().toString());
                Assert.assertEquals("HAVING (a = #{a} AND b = #{b}) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR ()", o_variableLengthArgumentOnHaving__6.getSelf().toString());
                Assert.assertEquals("HAVING (a = #{a} AND b = #{b}) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR ()", o_variableLengthArgumentOnHaving__6.toString());
            }
        }.toString();
        Assert.assertEquals("HAVING (a = #{a} AND b = #{b}) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR ()", sql);
    }

    @Test(timeout = 120000)
    public void shouldDemonstrateMixedStyle() throws Exception {
        final String sql = new SQL() {
            {
                SQL o_shouldDemonstrateMixedStyle__6 = SELECT("id, name");
                Assert.assertEquals("SELECT id, name", o_shouldDemonstrateMixedStyle__6.getSelf().toString());
                Assert.assertEquals("SELECT id, name", o_shouldDemonstrateMixedStyle__6.toString());
                Assert.assertEquals("SELECT id, name", o_shouldDemonstrateMixedStyle__6.getSelf().getSelf().toString());
                SQL o_shouldDemonstrateMixedStyle__7 = FROM("PERSON A");
                Assert.assertEquals("SELECT id, name\nFROM PERSON A", o_shouldDemonstrateMixedStyle__7.getSelf().getSelf().toString());
                Assert.assertEquals("SELECT id, name\nFROM PERSON A", o_shouldDemonstrateMixedStyle__7.getSelf().toString());
                Assert.assertEquals("SELECT id, name\nFROM PERSON A", o_shouldDemonstrateMixedStyle__7.toString());
                SQL o_shouldDemonstrateMixedStyle__8 = WHERE("name like ?").WHERE("id = ?");
                Assert.assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR ()", o_shouldDemonstrateMixedStyle__8.getSelf().toString());
                Assert.assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?) \nAND () \nOR () \nAND () \nOR ()", o_shouldDemonstrateMixedStyle__8.getSelf().getSelf().toString());
                Assert.assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR ()", o_shouldDemonstrateMixedStyle__8.toString());
                Assert.assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR ()", o_shouldDemonstrateMixedStyle__7.getSelf().getSelf().toString());
                Assert.assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR ()", o_shouldDemonstrateMixedStyle__7.getSelf().toString());
                Assert.assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR ()", o_shouldDemonstrateMixedStyle__7.toString());
                Assert.assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR ()", o_shouldDemonstrateMixedStyle__6.getSelf().toString());
                Assert.assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR ()", o_shouldDemonstrateMixedStyle__6.toString());
                Assert.assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR ()", o_shouldDemonstrateMixedStyle__6.getSelf().getSelf().toString());
            }
        }.toString();
        Assert.assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR ()", sql);
        String String_0 = "" + (("SELECT id, name\n" + "FROM PERSON A\n") + "WHERE (name like ? AND id = ?)");
        Assert.assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?)", String_0);
        Assert.assertEquals("SELECT id, name\nFROM PERSON A\nWHERE (name like ? AND id = ?) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR ()", sql);
    }

    @Test(timeout = 120000)
    public void shouldDemonstrateProvidedStringBuilder() throws Exception {
        final StringBuilder sb = new StringBuilder();
        final String sql = usingAppender(sb).toString();
        Assert.assertEquals("SELECT P.ID, P.USERNAME, P.PASSWORD, P.FULL_NAME, P.LAST_NAME, P.CREATED_ON, P.UPDATED_ON\nFROM PERSON P, ACCOUNT A\nINNER JOIN DEPARTMENT D on D.ID = P.DEPARTMENT_ID\nINNER JOIN COMPANY C on D.COMPANY_ID = C.ID\nWHERE (P.ID = A.ID) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR (P.FIRST_NAME like ?) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR (P.LAST_NAME like ?) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR ()\nGROUP BY P.ID\nHAVING (P.LAST_NAME like ?) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR (P.FIRST_NAME like ?) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR ()\nORDER BY P.ID, P.FULL_NAME", sql);
        String String_6 = "SELECT P.ID, P.USERNAME, P.PASSWORD, P.FULL_NAME, P.LAST_NAME, P.CREATED_ON, P.UPDATED_ON\n" + (((((((("FROM PERSON P, ACCOUNT A\n" + "INNER JOIN DEPARTMENT D on D.ID = P.DEPARTMENT_ID\n") + "INNER JOIN COMPANY C on D.COMPANY_ID = C.ID\n") + "WHERE (P.ID = A.ID AND P.FIRST_NAME like ?) \n") + "OR (P.LAST_NAME like ?)\n") + "GROUP BY P.ID\n") + "HAVING (P.LAST_NAME like ?) \n") + "OR (P.FIRST_NAME like ?)\n") + "ORDER BY P.ID, P.FULL_NAME");
        Assert.assertEquals("SELECT P.ID, P.USERNAME, P.PASSWORD, P.FULL_NAME, P.LAST_NAME, P.CREATED_ON, P.UPDATED_ON\nFROM PERSON P, ACCOUNT A\nINNER JOIN DEPARTMENT D on D.ID = P.DEPARTMENT_ID\nINNER JOIN COMPANY C on D.COMPANY_ID = C.ID\nWHERE (P.ID = A.ID AND P.FIRST_NAME like ?) \nOR (P.LAST_NAME like ?)\nGROUP BY P.ID\nHAVING (P.LAST_NAME like ?) \nOR (P.FIRST_NAME like ?)\nORDER BY P.ID, P.FULL_NAME", String_6);
        Assert.assertEquals("SELECT P.ID, P.USERNAME, P.PASSWORD, P.FULL_NAME, P.LAST_NAME, P.CREATED_ON, P.UPDATED_ON\nFROM PERSON P, ACCOUNT A\nINNER JOIN DEPARTMENT D on D.ID = P.DEPARTMENT_ID\nINNER JOIN COMPANY C on D.COMPANY_ID = C.ID\nWHERE (P.ID = A.ID) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR (P.FIRST_NAME like ?) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR (P.LAST_NAME like ?) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR ()\nGROUP BY P.ID\nHAVING (P.LAST_NAME like ?) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR (P.FIRST_NAME like ?) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR ()\nORDER BY P.ID, P.FULL_NAME", sql);
    }

    @Test(timeout = 120000)
    public void variableLengthArgumentOnWhere() throws Exception {
        final String sql = new SQL() {
            {
                SQL o_variableLengthArgumentOnWhere__6 = SELECT().WHERE("a = #{a}", "b = #{b}");
                Assert.assertEquals("WHERE (a = #{a} AND b = #{b}) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR ()", o_variableLengthArgumentOnWhere__6.toString());
                Assert.assertEquals("WHERE (a = #{a} AND b = #{b}) \nAND () \nOR () \nAND () \nOR ()", o_variableLengthArgumentOnWhere__6.getSelf().getSelf().toString());
                Assert.assertEquals("WHERE (a = #{a} AND b = #{b}) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR ()", o_variableLengthArgumentOnWhere__6.getSelf().toString());
            }
        }.toString();
        Assert.assertEquals("WHERE (a = #{a} AND b = #{b}) \nAND () \nOR () \nAND () \nOR () \nAND () \nOR () \nAND () \nOR ()", sql);
    }
}

