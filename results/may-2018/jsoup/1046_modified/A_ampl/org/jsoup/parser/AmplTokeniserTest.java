package org.jsoup.parser;


import org.jsoup.Jsoup;
import org.junit.Assert;
import org.junit.Test;


public class AmplTokeniserTest {
    @Test(timeout = 10000)
    public void cp1252EntitiesProduceError() throws Exception {
        Parser parser = new Parser(new HtmlTreeBuilder());
        Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
        Assert.assertFalse(((org.jsoup.parser.Parser)parser).isTrackErrors());
        Parser o_cp1252EntitiesProduceError__4 = parser.setTrackErrors(10);
        Assert.assertNull(((org.jsoup.parser.Parser)o_cp1252EntitiesProduceError__4).getErrors());
        Assert.assertTrue(((org.jsoup.parser.Parser)o_cp1252EntitiesProduceError__4).isTrackErrors());
        String o_cp1252EntitiesProduceError__5 = parser.parseInput("<html><body>&#0128;</body></html>", "").text();
        Assert.assertEquals("\u20ac", o_cp1252EntitiesProduceError__5);
        int o_cp1252EntitiesProduceError__7 = parser.getErrors().size();
        Assert.assertEquals(1, ((int) (o_cp1252EntitiesProduceError__7)));
        Assert.assertEquals(1, ((int) (((java.util.List)((org.jsoup.parser.Parser)parser).getErrors()).size())));
        Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
        Assert.assertFalse(((java.util.List)((org.jsoup.parser.Parser)parser).getErrors()).isEmpty());
        Assert.assertFalse(((java.util.List)((org.jsoup.parser.Parser)o_cp1252EntitiesProduceError__4).getErrors()).isEmpty());
        Assert.assertEquals(1, ((int) (((java.util.List)((org.jsoup.parser.Parser)o_cp1252EntitiesProduceError__4).getErrors()).size())));
        Assert.assertTrue(((org.jsoup.parser.Parser)o_cp1252EntitiesProduceError__4).isTrackErrors());
        Assert.assertEquals("\u20ac", o_cp1252EntitiesProduceError__5);
    }

    @Test(timeout = 10000)
    public void cp1252Entities() throws Exception {
        String o_cp1252Entities__1 = Jsoup.parse("&#0128;").text();
        Assert.assertEquals("\u20ac", o_cp1252Entities__1);
        String o_cp1252Entities__3 = Jsoup.parse("&#0130;").text();
        Assert.assertEquals("\u201a", o_cp1252Entities__3);
        String o_cp1252Entities__5 = Jsoup.parse("&#x80;").text();
        Assert.assertEquals("\u20ac", o_cp1252Entities__5);
        Assert.assertEquals("\u201a", o_cp1252Entities__3);
        Assert.assertEquals("\u20ac", o_cp1252Entities__1);
    }
}

