package org.jsoup.parser;


import java.util.List;
import org.jsoup.Jsoup;
import org.junit.Assert;
import org.junit.Test;


public class AmplTokeniserTest {
    @Test(timeout = 10000)
    public void cp1252EntitiesProduceError() throws Exception {
        Parser parser = new Parser(new HtmlTreeBuilder());
        Assert.assertNull(getErrors());
        Assert.assertFalse(isTrackErrors());
        Parser o_cp1252EntitiesProduceError__4 = parser.setTrackErrors(10);
        Assert.assertNull(getErrors());
        Assert.assertTrue(isTrackErrors());
        String o_cp1252EntitiesProduceError__5 = parser.parseInput("<html><body>&#0128;</body></html>", "").text();
        Assert.assertEquals("\u20ac", o_cp1252EntitiesProduceError__5);
        int o_cp1252EntitiesProduceError__7 = parser.getErrors().size();
        Assert.assertEquals(1, ((int) (o_cp1252EntitiesProduceError__7)));
        Assert.assertEquals(1, ((int) (((List) (getErrors())).size())));
        Assert.assertTrue(isTrackErrors());
        Assert.assertFalse(((List) (getErrors())).isEmpty());
        Assert.assertFalse(((List) (getErrors())).isEmpty());
        Assert.assertEquals(1, ((int) (((List) (getErrors())).size())));
        Assert.assertTrue(isTrackErrors());
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

