package org.jsoup.parser;


import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.jsoup.Jsoup;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(JUnitParamsRunner.class)
public class AmplTokenQueueTest {
    @Test
    @Parameters(method = "singleQuotesInsideDouble, doubleQuotesInsideSingle")
    public void testNestedQuotes(String html, String selector) {
        Assert.assertEquals("#identifier", Jsoup.parse(html).select(selector).first().cssSelector());
    }

    public Object[] singleQuotesInsideDouble() {
        return new Object[]{ new String[]{ "<html><body><a id=\"identifier\" onclick=\"func(\'arg\')\" /></body></html>", "a[onclick*=\"(\'arg\"]" }, new String[]{ "<html><body><a id=\"identifier\" onclick=func(\'arg\') /></body></html>", "a[onclick*=\"(\'arg\"]" } };
    }

    public Object[] doubleQuotesInsideSingle() {
        return new Object[]{ new String[]{ "<html><body><a id=\"identifier\" onclick=\'func(\"arg\")\' /></body></html>", "a[onclick*=\'(\"arg\']" }, new String[]{ "<html><body><a id=\"identifier\" onclick=func(\"arg\") /></body></html>", "a[onclick*=\'(\"arg\']" } };
    }
}

