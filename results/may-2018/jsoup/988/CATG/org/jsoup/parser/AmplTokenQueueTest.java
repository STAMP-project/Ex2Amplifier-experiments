package org.jsoup.parser;


import org.junit.Assert;
import org.junit.Test;


public class AmplTokenQueueTest {
    @Test(timeout = 10000)
    public void chompBalanced() throws Exception {
        TokenQueue tq = new TokenQueue(":contains(one (two) three) four");
        Assert.assertFalse(matchesWord());
        Assert.assertFalse(matchesWhitespace());
        Assert.assertEquals("", consumeAttributeKey());
        Assert.assertFalse(consumeWhitespace());
        Assert.assertEquals("", consumeElementSelector());
        Assert.assertEquals("", consumeWord());
        Assert.assertEquals('(', ((char) (peek())));
        Assert.assertEquals("(one (two) three) four", ((org.jsoup.parser.TokenQueue) (tq)).toString());
        Assert.assertEquals("contains", consumeTagName());
        Assert.assertFalse(isEmpty());
        Assert.assertEquals("(one (two) three) four", remainder());
        Assert.assertFalse(matchesStartTag());
        Assert.assertEquals("", consumeCssIdentifier());
        Assert.assertEquals(':', ((char) (consume())));
        String pre = tq.consumeTo("(");
        Assert.assertEquals("", pre);
        String guts = tq.chompBalanced('(', ')');
        Assert.assertEquals("", guts);
        String remainder = tq.remainder();
        Assert.assertEquals("", remainder);
        Assert.assertEquals("", guts);
        Assert.assertEquals("", pre);
        Assert.assertFalse(matchesWord());
        Assert.assertFalse(matchesWhitespace());
        Assert.assertFalse(isEmpty());
        Assert.assertFalse(matchesStartTag());
    }

    @Test(timeout = 10000)
    public void chompBalancedMatchesAsMuchAsPossible() throws Exception {
        TokenQueue tq = new TokenQueue("unbalanced(something(or another)) else");
        Assert.assertTrue(matchesWord());
        Assert.assertFalse(matchesWhitespace());
        Assert.assertEquals("", consumeAttributeKey());
        Assert.assertFalse(consumeWhitespace());
        Assert.assertEquals("", consumeElementSelector());
        Assert.assertEquals("", consumeWord());
        Assert.assertEquals('(', ((char) (peek())));
        Assert.assertEquals("(something(or another)) else", ((org.jsoup.parser.TokenQueue) (tq)).toString());
        Assert.assertEquals("nbalanced", consumeTagName());
        Assert.assertFalse(isEmpty());
        Assert.assertEquals("(something(or another)) else", remainder());
        Assert.assertFalse(matchesStartTag());
        Assert.assertEquals("", consumeCssIdentifier());
        Assert.assertEquals('u', ((char) (consume())));
        String o_chompBalancedMatchesAsMuchAsPossible__3 = tq.consumeTo("(");
        Assert.assertEquals("", o_chompBalancedMatchesAsMuchAsPossible__3);
        String match = tq.chompBalanced('(', ')');
        Assert.assertEquals("", match);
        Assert.assertFalse(matchesWord());
        Assert.assertFalse(matchesWhitespace());
        Assert.assertFalse(isEmpty());
        Assert.assertFalse(matchesStartTag());
        Assert.assertEquals("", o_chompBalancedMatchesAsMuchAsPossible__3);
    }
}

