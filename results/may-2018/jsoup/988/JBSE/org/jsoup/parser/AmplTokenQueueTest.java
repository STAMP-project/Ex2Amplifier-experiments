package org.jsoup.parser;


import org.junit.Assert;
import org.junit.Test;


public class AmplTokenQueueTest {
    @Test(timeout = 120000)
    public void chompBalanced() throws Exception {
        TokenQueue tq = new TokenQueue(":contains(one (two) three) four");
        Assert.assertFalse(((org.jsoup.parser.TokenQueue)tq).matchesWhitespace());
        Assert.assertFalse(((org.jsoup.parser.TokenQueue)tq).matchesWord());
        Assert.assertEquals("", ((org.jsoup.parser.TokenQueue)tq).consumeAttributeKey());
        Assert.assertFalse(((org.jsoup.parser.TokenQueue)tq).consumeWhitespace());
        Assert.assertEquals("", ((org.jsoup.parser.TokenQueue)tq).consumeElementSelector());
        Assert.assertEquals("", ((org.jsoup.parser.TokenQueue)tq).consumeWord());
        Assert.assertEquals('(', ((char) (((org.jsoup.parser.TokenQueue)tq).peek())));
        Assert.assertEquals("(one (two) three) four", ((org.jsoup.parser.TokenQueue)tq).toString());
        Assert.assertEquals("contains", ((org.jsoup.parser.TokenQueue)tq).consumeTagName());
        Assert.assertFalse(((org.jsoup.parser.TokenQueue)tq).isEmpty());
        Assert.assertEquals("(one (two) three) four", ((org.jsoup.parser.TokenQueue)tq).remainder());
        Assert.assertFalse(((org.jsoup.parser.TokenQueue)tq).matchesStartTag());
        Assert.assertEquals("", ((org.jsoup.parser.TokenQueue)tq).consumeCssIdentifier());
        Assert.assertEquals(':', ((char) (((org.jsoup.parser.TokenQueue)tq).consume())));
        String pre = tq.consumeTo("(");
        Assert.assertEquals("", pre);
        String guts = tq.chompBalanced('(', ')');
        Assert.assertEquals("", guts);
        String remainder = tq.remainder();
        Assert.assertEquals("", remainder);
        Assert.assertEquals("", guts);
        Assert.assertEquals("", pre);
        Assert.assertFalse(((org.jsoup.parser.TokenQueue)tq).matchesWhitespace());
        Assert.assertFalse(((org.jsoup.parser.TokenQueue)tq).matchesWord());
        Assert.assertFalse(((org.jsoup.parser.TokenQueue)tq).isEmpty());
        Assert.assertFalse(((org.jsoup.parser.TokenQueue)tq).matchesStartTag());
    }

    @Test(timeout = 120000)
    public void chompBalancedMatchesAsMuchAsPossible() throws Exception {
        TokenQueue tq = new TokenQueue("unbalanced(something(or another)) else");
        Assert.assertFalse(((org.jsoup.parser.TokenQueue)tq).matchesWhitespace());
        Assert.assertTrue(((org.jsoup.parser.TokenQueue)tq).matchesWord());
        Assert.assertEquals("", ((org.jsoup.parser.TokenQueue)tq).consumeAttributeKey());
        Assert.assertFalse(((org.jsoup.parser.TokenQueue)tq).consumeWhitespace());
        Assert.assertEquals("", ((org.jsoup.parser.TokenQueue)tq).consumeElementSelector());
        Assert.assertEquals("", ((org.jsoup.parser.TokenQueue)tq).consumeWord());
        Assert.assertEquals('(', ((char) (((org.jsoup.parser.TokenQueue)tq).peek())));
        Assert.assertEquals("(something(or another)) else", ((org.jsoup.parser.TokenQueue)tq).toString());
        Assert.assertEquals("nbalanced", ((org.jsoup.parser.TokenQueue)tq).consumeTagName());
        Assert.assertFalse(((org.jsoup.parser.TokenQueue)tq).isEmpty());
        Assert.assertEquals("(something(or another)) else", ((org.jsoup.parser.TokenQueue)tq).remainder());
        Assert.assertFalse(((org.jsoup.parser.TokenQueue)tq).matchesStartTag());
        Assert.assertEquals("", ((org.jsoup.parser.TokenQueue)tq).consumeCssIdentifier());
        Assert.assertEquals('u', ((char) (((org.jsoup.parser.TokenQueue)tq).consume())));
        String o_chompBalancedMatchesAsMuchAsPossible__3 = tq.consumeTo("(");
        Assert.assertEquals("", o_chompBalancedMatchesAsMuchAsPossible__3);
        String match = tq.chompBalanced('(', ')');
        Assert.assertEquals("", match);
        Assert.assertFalse(((org.jsoup.parser.TokenQueue)tq).matchesWhitespace());
        Assert.assertFalse(((org.jsoup.parser.TokenQueue)tq).matchesWord());
        Assert.assertFalse(((org.jsoup.parser.TokenQueue)tq).isEmpty());
        Assert.assertFalse(((org.jsoup.parser.TokenQueue)tq).matchesStartTag());
        Assert.assertEquals("", o_chompBalancedMatchesAsMuchAsPossible__3);
    }
}

