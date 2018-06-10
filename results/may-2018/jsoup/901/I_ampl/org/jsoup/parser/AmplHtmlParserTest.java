package org.jsoup.parser;


import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.helper.StringUtil;
import org.jsoup.nodes.Comment;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.junit.Assert;
import org.junit.Test;


public class AmplHtmlParserTest {
    @Test(timeout = 120000)
    public void parsesSimpleDocumentlitNum16560_failAssert74litString16615litString16748() throws Exception {
        try {
            String html = "<r><X>A</X><y>B</y></r>";
            Assert.assertEquals("<r><X>A</X><y>B</y></r>", html);
            Document doc = Jsoup.parse(html);
            Element p = doc.body().child(-1);
            p.tagName();
            Element img = p.child(0);
            img.attr("sdrc");
            img.tagName();
            org.junit.Assert.fail("parsesSimpleDocumentlitNum16560 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_parsesSimpleDocumentlitNum16560_failAssert74litString16615__20 = expected.getMessage();
            Assert.assertEquals("-1", o_parsesSimpleDocumentlitNum16560_failAssert74litString16615__20);
        }
    }

    @Test(timeout = 120000)
    public void parsesUnterminatedCommentslitNum67856_failAssert155litString67918litNum68355() throws Exception {
        try {
            String html = "<p>Hello<-- <tr><td>";
            Assert.assertEquals("<p>Hello<-- <tr><td>", html);
            Document doc = Jsoup.parse(html);
            Element p = doc.getElementsByTag("p").get(-1);
            p.text();
            TextNode text = ((TextNode) (p.childNode(-1)));
            text.getWholeText();
            Comment comment = ((Comment) (p.childNode(1)));
            comment.getData();
            org.junit.Assert.fail("parsesUnterminatedCommentslitNum67856 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_parsesUnterminatedCommentslitNum67856_failAssert155litString67918__21 = expected.getMessage();
            Assert.assertEquals("-1", o_parsesUnterminatedCommentslitNum67856_failAssert155litString67918__21);
        }
    }

    @Test(timeout = 120000)
    public void parsesUnterminatedCommentslitNum67856_failAssert155litString67918litNum68358() throws Exception {
        try {
            String html = "<p>Hello<-- <tr><td>";
            Assert.assertEquals("<p>Hello<-- <tr><td>", html);
            Document doc = Jsoup.parse(html);
            Element p = doc.getElementsByTag("p").get(-1);
            p.text();
            TextNode text = ((TextNode) (p.childNode(0)));
            text.getWholeText();
            Comment comment = ((Comment) (p.childNode(1)));
            comment.getData();
            org.junit.Assert.fail("parsesUnterminatedCommentslitNum67856 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_parsesUnterminatedCommentslitNum67856_failAssert155litString67918__21 = expected.getMessage();
            Assert.assertEquals("-1", o_parsesUnterminatedCommentslitNum67856_failAssert155litString67918__21);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605litNum54948() throws Exception {
        try {
            String html = "Data</-sc";
            Assert.assertEquals("Data</-sc", html);
            Parser parser = Parser.htmlParser().setTrackErrors(0);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertFalse(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__14 = errors.size();
            errors.get(-1).toString();
            errors.get(1).toString();
            errors.get(2).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__24 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__24);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605litNum54947() throws Exception {
        try {
            String html = "Data</-sc";
            Assert.assertEquals("Data</-sc", html);
            Parser parser = Parser.htmlParser().setTrackErrors(-2147483648);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertFalse(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__14 = errors.size();
            errors.get(-1).toString();
            errors.get(1).toString();
            errors.get(2).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__24 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__24);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605litNum54949() throws Exception {
        try {
            String html = "Data</-sc";
            Assert.assertEquals("Data</-sc", html);
            Parser parser = Parser.htmlParser().setTrackErrors(2);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__14 = errors.size();
            errors.get(-1).toString();
            errors.get(1).toString();
            errors.get(2).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__24 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__24);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52624litNum54597() throws Exception {
        try {
            String html = "<p>One</p href='no'><!DOCTYPE html>&arrgh;<font /><br /><foo";
            Assert.assertEquals("<p>One</p href=\'no\'><!DOCTYPE html>&arrgh;<font /><br /><foo", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52624__14 = errors.size();
            errors.get(-1).toString();
            errors.get(-2147483648).toString();
            errors.get(2147483647).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52624litNum54597__28 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52624litNum54597__28);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605litNum54955() throws Exception {
        try {
            String html = "Data</-sc";
            Assert.assertEquals("Data</-sc", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__14 = errors.size();
            errors.get(-1).toString();
            errors.get(1).toString();
            errors.get(2147483647).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__24 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__24);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605litNum54954() throws Exception {
        try {
            String html = "Data</-sc";
            Assert.assertEquals("Data</-sc", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__14 = errors.size();
            errors.get(-1).toString();
            errors.get(2).toString();
            errors.get(2).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__24 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__24);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605litNum54957() throws Exception {
        try {
            String html = "Data</-sc";
            Assert.assertEquals("Data</-sc", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__14 = errors.size();
            errors.get(-1).toString();
            errors.get(1).toString();
            errors.get(0).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__24 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__24);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605litNum54956() throws Exception {
        try {
            String html = "Data</-sc";
            Assert.assertEquals("Data</-sc", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__14 = errors.size();
            errors.get(-1).toString();
            errors.get(1).toString();
            errors.get(-2147483648).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__24 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__24);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52629litNum54675() throws Exception {
        try {
            String html = "<p>One</p href='no'><!DOCTYPE html>&arrgh;<font /><br /><foo";
            Assert.assertEquals("<p>One</p href=\'no\'><!DOCTYPE html>&arrgh;<font /><br /><foo", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52629__14 = errors.size();
            errors.get(-1).toString();
            errors.get(2).toString();
            errors.get(-2147483648).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52629__26 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52629__26);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605litNum54951() throws Exception {
        try {
            String html = "Data</-sc";
            Assert.assertEquals("Data</-sc", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__14 = errors.size();
            errors.get(-1).toString();
            errors.get(0).toString();
            errors.get(2).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__24 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__24);
        }
    }

    @Test(timeout = 120000)
    public void parsesUnterminatedCommentslitNum67856_failAssert155litString67927litNum68322() throws Exception {
        try {
            String html = "<p>Hello<!-- <tre><td>";
            Assert.assertEquals("<p>Hello<!-- <tre><td>", html);
            Document doc = Jsoup.parse(html);
            Element p = doc.getElementsByTag("p").get(-1);
            p.text();
            TextNode text = ((TextNode) (p.childNode(0)));
            text.getWholeText();
            Comment comment = ((Comment) (p.childNode(0)));
            comment.getData();
            org.junit.Assert.fail("parsesUnterminatedCommentslitNum67856 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_parsesUnterminatedCommentslitNum67856_failAssert155litString67927__21 = expected.getMessage();
            Assert.assertEquals("-1", o_parsesUnterminatedCommentslitNum67856_failAssert155litString67927__21);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605litNum54950() throws Exception {
        try {
            String html = "Data</-sc";
            Assert.assertEquals("Data</-sc", html);
            Parser parser = Parser.htmlParser().setTrackErrors(4);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__14 = errors.size();
            errors.get(-1).toString();
            errors.get(1).toString();
            errors.get(2).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__24 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__24);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52624litNum54599() throws Exception {
        try {
            String html = "<p>One</p href='no'><!DOCTYPE html>&arrgh;<font /><br /><foo";
            Assert.assertEquals("<p>One</p href=\'no\'><!DOCTYPE html>&arrgh;<font /><br /><foo", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52624__14 = errors.size();
            errors.get(-1).toString();
            errors.get(-2147483648).toString();
            errors.get(0).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52624litNum54599__28 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52624litNum54599__28);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605litNum54953() throws Exception {
        try {
            String html = "Data</-sc";
            Assert.assertEquals("Data</-sc", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__14 = errors.size();
            errors.get(-1).toString();
            errors.get(-2147483648).toString();
            errors.get(2).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__24 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__24);
        }
    }

    @Test(timeout = 120000)
    public void parsesUnterminatedCommentslitNum67856_failAssert155litString67924litNum68287() throws Exception {
        try {
            String html = "<p>Hello<!-- <lr><td>";
            Assert.assertEquals("<p>Hello<!-- <lr><td>", html);
            Document doc = Jsoup.parse(html);
            Element p = doc.getElementsByTag("p").get(-1);
            p.text();
            TextNode text = ((TextNode) (p.childNode(0)));
            text.getWholeText();
            Comment comment = ((Comment) (p.childNode(0)));
            comment.getData();
            org.junit.Assert.fail("parsesUnterminatedCommentslitNum67856 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_parsesUnterminatedCommentslitNum67856_failAssert155litString67924__21 = expected.getMessage();
            Assert.assertEquals("-1", o_parsesUnterminatedCommentslitNum67856_failAssert155litString67924__21);
        }
    }

    @Test(timeout = 120000)
    public void parsesUnterminatedCommentslitNum67856_failAssert155litNum67941litNum68246() throws Exception {
        try {
            String html = "<p>Hello<!-- <tr><td>";
            Assert.assertEquals("<p>Hello<!-- <tr><td>", html);
            Document doc = Jsoup.parse(html);
            Element p = doc.getElementsByTag("p").get(-1);
            p.text();
            TextNode text = ((TextNode) (p.childNode(0)));
            text.getWholeText();
            Comment comment = ((Comment) (p.childNode(2)));
            comment.getData();
            org.junit.Assert.fail("parsesUnterminatedCommentslitNum67856 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_parsesUnterminatedCommentslitNum67856_failAssert155litNum67941__22 = expected.getMessage();
            Assert.assertEquals("-1", o_parsesUnterminatedCommentslitNum67856_failAssert155litNum67941__22);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52624litNum54598() throws Exception {
        try {
            String html = "<p>One</p href='no'><!DOCTYPE html>&arrgh;<font /><br /><foo";
            Assert.assertEquals("<p>One</p href=\'no\'><!DOCTYPE html>&arrgh;<font /><br /><foo", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52624__14 = errors.size();
            errors.get(-1).toString();
            errors.get(-2147483648).toString();
            errors.get(-2147483648).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52624litNum54598__28 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52624litNum54598__28);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605litNum54952() throws Exception {
        try {
            String html = "Data</-sc";
            Assert.assertEquals("Data</-sc", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__14 = errors.size();
            errors.get(-1).toString();
            errors.get(2147483647).toString();
            errors.get(2).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__24 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__24);
        }
    }

    @Test(timeout = 120000)
    public void parsesUnterminatedCommentslitNum67856_failAssert155litNum67942litString68083() throws Exception {
        try {
            String html = "<p>Hello<!-- <tr><td>";
            Assert.assertEquals("<p>Hello<!-- <tr><td>", html);
            Document doc = Jsoup.parse(html);
            Element p = doc.getElementsByTag("R").get(-1);
            p.text();
            TextNode text = ((TextNode) (p.childNode(1)));
            text.getWholeText();
            Comment comment = ((Comment) (p.childNode(1)));
            comment.getData();
            org.junit.Assert.fail("parsesUnterminatedCommentslitNum67856 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_parsesUnterminatedCommentslitNum67856_failAssert155litNum67942__22 = expected.getMessage();
            Assert.assertEquals("-1", o_parsesUnterminatedCommentslitNum67856_failAssert155litNum67942__22);
        }
    }

    @Test(timeout = 120000)
    public void parsesSimpleDocumentlitNum16560_failAssert74litNum16633litString16816() throws Exception {
        try {
            String html = "<h<tml><head><title>First!</title></head><body><p>First post! <img src=\"foo.png\" /></p></body></html>";
            Assert.assertEquals("<h<tml><head><title>First!</title></head><body><p>First post! <img src=\"foo.png\" /></p></body></html>", html);
            Document doc = Jsoup.parse(html);
            Element p = doc.body().child(-1);
            p.tagName();
            Element img = p.child(0);
            img.attr("src");
            img.tagName();
            org.junit.Assert.fail("parsesSimpleDocumentlitNum16560 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_parsesSimpleDocumentlitNum16560_failAssert74litNum16633__21 = expected.getMessage();
            Assert.assertEquals("-1", o_parsesSimpleDocumentlitNum16560_failAssert74litNum16633__21);
        }
    }

    @Test(timeout = 120000)
    public void parsesSimpleDocumentlitString16550_failAssert73litNum16632litNum16843() throws Exception {
        try {
            String html = "x3<k9aWMs1s[;6{!LZU7.[H(Q`3:PGB8UrDgToVVuk26F=7X?MUW!]J8N.3DN 3-DI5a6_J_ `y`c2Z:fT3HpK-ISf8[i:I+qV!n";
            Assert.assertEquals("x3<k9aWMs1s[;6{!LZU7.[H(Q`3:PGB8UrDgToVVuk26F=7X?MUW!]J8N.3DN 3-DI5a6_J_ `y`c2Z:fT3HpK-ISf8[i:I+qV!n", html);
            Document doc = Jsoup.parse(html);
            Element p = doc.body().child(-2147483648);
            p.tagName();
            Element img = p.child(0);
            img.attr("src");
            img.tagName();
            org.junit.Assert.fail("parsesSimpleDocumentlitString16550 should have thrown IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException expected) {
            String o_parsesSimpleDocumentlitString16550_failAssert73litNum16632__20 = expected.getMessage();
            Assert.assertEquals("-2147483648", o_parsesSimpleDocumentlitString16550_failAssert73litNum16632__20);
        }
    }

    @Test(timeout = 120000)
    public void parsesSimpleDocumentlitString16550_failAssert73litNum16632litNum16844() throws Exception {
        try {
            String html = "x3<k9aWMs1s[;6{!LZU7.[H(Q`3:PGB8UrDgToVVuk26F=7X?MUW!]J8N.3DN 3-DI5a6_J_ `y`c2Z:fT3HpK-ISf8[i:I+qV!n";
            Assert.assertEquals("x3<k9aWMs1s[;6{!LZU7.[H(Q`3:PGB8UrDgToVVuk26F=7X?MUW!]J8N.3DN 3-DI5a6_J_ `y`c2Z:fT3HpK-ISf8[i:I+qV!n", html);
            Document doc = Jsoup.parse(html);
            Element p = doc.body().child(-2147483648);
            p.tagName();
            Element img = p.child(1);
            img.attr("src");
            img.tagName();
            org.junit.Assert.fail("parsesSimpleDocumentlitString16550 should have thrown IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException expected) {
            String o_parsesSimpleDocumentlitString16550_failAssert73litNum16632__20 = expected.getMessage();
            Assert.assertEquals("-2147483648", o_parsesSimpleDocumentlitString16550_failAssert73litNum16632__20);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605litString54932() throws Exception {
        try {
            String html = "Data</-sc";
            Assert.assertEquals("Data</-sc", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "NVWk!Y^^v^3Ckoz6f?");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__14 = errors.size();
            errors.get(-1).toString();
            errors.get(1).toString();
            errors.get(2).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__24 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__24);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605litString54933() throws Exception {
        try {
            String html = "Data</-sc";
            Assert.assertEquals("Data</-sc", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://exaple.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__14 = errors.size();
            errors.get(-1).toString();
            errors.get(1).toString();
            errors.get(2).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__24 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__24);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605litString54934() throws Exception {
        try {
            String html = "Data</-sc";
            Assert.assertEquals("Data</-sc", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "htkp://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__14 = errors.size();
            errors.get(-1).toString();
            errors.get(1).toString();
            errors.get(2).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__24 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__24);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632litString55298() throws Exception {
        try {
            String html = "<p>One</p href='no'><!DOCTYPE html>&arrgh;<font /><br /><foo";
            Assert.assertEquals("<p>One</p href=\'no\'><!DOCTYPE html>&arrgh;<font /><br /><foo", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "jsoup");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632__14 = errors.size();
            errors.get(-1).toString();
            errors.get(1).toString();
            errors.get(1).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632__26 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632__26);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632litString55299() throws Exception {
        try {
            String html = "<p>One</p href='no'><!DOCTYPE html>&arrgh;<font /><br /><foo";
            Assert.assertEquals("<p>One</p href=\'no\'><!DOCTYPE html>&arrgh;<font /><br /><foo", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "htto://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632__14 = errors.size();
            errors.get(-1).toString();
            errors.get(1).toString();
            errors.get(1).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632__26 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632__26);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632litString55296() throws Exception {
        try {
            String html = "<p>One</p href='no'><!DOCTYPE html>&arrgh;<font /><br /><foo";
            Assert.assertEquals("<p>One</p href=\'no\'><!DOCTYPE html>&arrgh;<font /><br /><foo", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://exampl.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632__14 = errors.size();
            errors.get(-1).toString();
            errors.get(1).toString();
            errors.get(1).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632__26 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632__26);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632litString55297() throws Exception {
        try {
            String html = "<p>One</p href='no'><!DOCTYPE html>&arrgh;<font /><br /><foo";
            Assert.assertEquals("<p>One</p href=\'no\'><!DOCTYPE html>&arrgh;<font /><br /><foo", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.cCom");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632__14 = errors.size();
            errors.get(-1).toString();
            errors.get(1).toString();
            errors.get(1).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632__26 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632__26);
        }
    }

    @Test(timeout = 120000)
    public void parsesSimpleDocumentlitNum16560_failAssert74litNum16633litString16812() throws Exception {
        try {
            String html = "<script>Data";
            Assert.assertEquals("<script>Data", html);
            Document doc = Jsoup.parse(html);
            Element p = doc.body().child(-1);
            p.tagName();
            Element img = p.child(0);
            img.attr("src");
            img.tagName();
            org.junit.Assert.fail("parsesSimpleDocumentlitNum16560 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_parsesSimpleDocumentlitNum16560_failAssert74litNum16633__21 = expected.getMessage();
            Assert.assertEquals("-1", o_parsesSimpleDocumentlitNum16560_failAssert74litNum16633__21);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632litString55290() throws Exception {
        try {
            String html = "<p>One</p href=\'no\'><!DOCTYPEhtml>&arrgh;<font /><br /><foo";
            Assert.assertEquals("<p>One</p href=\'no\'><!DOCTYPEhtml>&arrgh;<font /><br /><foo", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632__14 = errors.size();
            errors.get(-1).toString();
            errors.get(1).toString();
            errors.get(1).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632__26 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632__26);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632litString55291() throws Exception {
        try {
            String html = "iJMj@*Vq^]SNnF]/TQg@MO@c3R^az|2!S#1Q6V3#Z%`N(VPaFca!>S{bW5$J";
            Assert.assertEquals("iJMj@*Vq^]SNnF]/TQg@MO@c3R^az|2!S#1Q6V3#Z%`N(VPaFca!>S{bW5$J", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632__14 = errors.size();
            errors.get(-1).toString();
            errors.get(1).toString();
            errors.get(1).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632__26 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632__26);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632litString55294() throws Exception {
        try {
            String html = "<p>One</p href='no'><!DOCTYPE html>&arrgh;<foRt /><br /><foo";
            Assert.assertEquals("<p>One</p href=\'no\'><!DOCTYPE html>&arrgh;<foRt /><br /><foo", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632__14 = errors.size();
            errors.get(-1).toString();
            errors.get(1).toString();
            errors.get(1).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632__26 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632__26);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632litString55295() throws Exception {
        try {
            String html = "<p>One</p href='no'><!DOCTYPE html>&arrgh;<font /><br /><foo";
            Assert.assertEquals("<p>One</p href=\'no\'><!DOCTYPE html>&arrgh;<font /><br /><foo", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "D>^+}c5z]K3#lEW1Bj");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632__14 = errors.size();
            errors.get(-1).toString();
            errors.get(1).toString();
            errors.get(1).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632__26 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632__26);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632litString55292() throws Exception {
        try {
            String html = "<p>One</p href=\'no\'><!DOCTYPE html>&arrgh;<font /><b.r /><foo";
            Assert.assertEquals("<p>One</p href=\'no\'><!DOCTYPE html>&arrgh;<font /><b.r /><foo", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632__14 = errors.size();
            errors.get(-1).toString();
            errors.get(1).toString();
            errors.get(1).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632__26 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632__26);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632litString55293() throws Exception {
        try {
            String html = "jsoup";
            Assert.assertEquals("jsoup", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632__14 = errors.size();
            errors.get(-1).toString();
            errors.get(1).toString();
            errors.get(1).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632__26 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52632__26);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52629litNum54669() throws Exception {
        try {
            String html = "<p>One</p href='no'><!DOCTYPE html>&arrgh;<font /><br /><foo";
            Assert.assertEquals("<p>One</p href=\'no\'><!DOCTYPE html>&arrgh;<font /><br /><foo", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52629__14 = errors.size();
            errors.get(-1).toString();
            errors.get(0).toString();
            errors.get(-2147483648).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52629__26 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52629__26);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605litNum54944() throws Exception {
        try {
            String html = "Data</-sc";
            Assert.assertEquals("Data</-sc", html);
            Parser parser = Parser.htmlParser().setTrackErrors(2147483647);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__14 = errors.size();
            errors.get(-1).toString();
            errors.get(1).toString();
            errors.get(2).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__24 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__24);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52624litNum54601() throws Exception {
        try {
            String html = "<p>One</p href='no'><!DOCTYPE html>&arrgh;<font /><br /><foo";
            Assert.assertEquals("<p>One</p href=\'no\'><!DOCTYPE html>&arrgh;<font /><br /><foo", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52624__14 = errors.size();
            errors.get(-1).toString();
            errors.get(-2147483648).toString();
            errors.get(1).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52624litNum54601__28 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52624litNum54601__28);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52624litNum54603() throws Exception {
        try {
            String html = "<p>One</p href='no'><!DOCTYPE html>&arrgh;<font /><br /><foo";
            Assert.assertEquals("<p>One</p href=\'no\'><!DOCTYPE html>&arrgh;<font /><br /><foo", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52624__14 = errors.size();
            errors.get(-1).toString();
            errors.get(-2147483648).toString();
            errors.get(3).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52624litNum54603__28 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52624litNum54603__28);
        }
    }

    @Test(timeout = 120000)
    public void parsesUnterminatedCommentslitNum67856_failAssert155litString67927litNum68318() throws Exception {
        try {
            String html = "<p>Hello<!-- <tre><td>";
            Assert.assertEquals("<p>Hello<!-- <tre><td>", html);
            Document doc = Jsoup.parse(html);
            Element p = doc.getElementsByTag("p").get(-1);
            p.text();
            TextNode text = ((TextNode) (p.childNode(1)));
            text.getWholeText();
            Comment comment = ((Comment) (p.childNode(1)));
            comment.getData();
            org.junit.Assert.fail("parsesUnterminatedCommentslitNum67856 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_parsesUnterminatedCommentslitNum67856_failAssert155litString67927__21 = expected.getMessage();
            Assert.assertEquals("-1", o_parsesUnterminatedCommentslitNum67856_failAssert155litString67927__21);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52627litNum54529() throws Exception {
        try {
            String html = "<p>One</p href='no'><!DOCTYPE html>&arrgh;<font /><br /><foo";
            Assert.assertEquals("<p>One</p href=\'no\'><!DOCTYPE html>&arrgh;<font /><br /><foo", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52627__14 = errors.size();
            errors.get(-1).toString();
            errors.get(-2147483648).toString();
            errors.get(2147483647).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52627litNum54529__28 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52627litNum54529__28);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52626litNum54980() throws Exception {
        try {
            String html = "<p>One</p href='no'><!DOCTYPE html>&arrgh;<font /><br /><foo";
            Assert.assertEquals("<p>One</p href=\'no\'><!DOCTYPE html>&arrgh;<font /><br /><foo", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52626__14 = errors.size();
            errors.get(-1).toString();
            errors.get(2).toString();
            errors.get(2147483647).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52626litNum54980__28 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52626litNum54980__28);
        }
    }

    @Test(timeout = 120000)
    public void handleNullContextInParseFragmentlitNum69029_failAssert161litNum69107litString70390() throws Exception {
        try {
            String html = "<ol><li>One</li></ol><p>Two</p>";
            Assert.assertEquals("<ol><li>One</li></ol><p>Two</p>", html);
            List<Node> nodes = Parser.parseFragment(html, null, "http://example.clom/");
            int o_handleNullContextInParseFragmentlitNum69029_failAssert161litNum69107__8 = nodes.size();
            nodes.get(-1).nodeName();
            StringUtil.normaliseWhitespace(nodes.get(2147483647).outerHtml());
            org.junit.Assert.fail("handleNullContextInParseFragmentlitNum69029 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_handleNullContextInParseFragmentlitNum69029_failAssert161litNum69107litString70390__20 = expected.getMessage();
            Assert.assertEquals("-1", o_handleNullContextInParseFragmentlitNum69029_failAssert161litNum69107litString70390__20);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52627litNum54526() throws Exception {
        try {
            String html = "<p>One</p href='no'><!DOCTYPE html>&arrgh;<font /><br /><foo";
            Assert.assertEquals("<p>One</p href=\'no\'><!DOCTYPE html>&arrgh;<font /><br /><foo", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52627__14 = errors.size();
            errors.get(-1).toString();
            errors.get(0).toString();
            errors.get(2147483647).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52627litNum54526__28 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52627litNum54526__28);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52627litNum54527() throws Exception {
        try {
            String html = "<p>One</p href='no'><!DOCTYPE html>&arrgh;<font /><br /><foo";
            Assert.assertEquals("<p>One</p href=\'no\'><!DOCTYPE html>&arrgh;<font /><br /><foo", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52627__14 = errors.size();
            errors.get(-1).toString();
            errors.get(2147483647).toString();
            errors.get(2147483647).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52627litNum54527__28 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52627litNum54527__28);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52626litNum54983() throws Exception {
        try {
            String html = "<p>One</p href='no'><!DOCTYPE html>&arrgh;<font /><br /><foo";
            Assert.assertEquals("<p>One</p href=\'no\'><!DOCTYPE html>&arrgh;<font /><br /><foo", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52626__14 = errors.size();
            errors.get(-1).toString();
            errors.get(2).toString();
            errors.get(1).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52626litNum54983__28 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52626litNum54983__28);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52626litNum54984() throws Exception {
        try {
            String html = "<p>One</p href='no'><!DOCTYPE html>&arrgh;<font /><br /><foo";
            Assert.assertEquals("<p>One</p href=\'no\'><!DOCTYPE html>&arrgh;<font /><br /><foo", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52626__14 = errors.size();
            errors.get(-1).toString();
            errors.get(2).toString();
            errors.get(3).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52626litNum54984__28 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52626litNum54984__28);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52626litNum54981() throws Exception {
        try {
            String html = "<p>One</p href='no'><!DOCTYPE html>&arrgh;<font /><br /><foo";
            Assert.assertEquals("<p>One</p href=\'no\'><!DOCTYPE html>&arrgh;<font /><br /><foo", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52626__14 = errors.size();
            errors.get(-1).toString();
            errors.get(2).toString();
            errors.get(-2147483648).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52626litNum54981__28 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52626litNum54981__28);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52626litNum54982() throws Exception {
        try {
            String html = "<p>One</p href='no'><!DOCTYPE html>&arrgh;<font /><br /><foo";
            Assert.assertEquals("<p>One</p href=\'no\'><!DOCTYPE html>&arrgh;<font /><br /><foo", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52626__14 = errors.size();
            errors.get(-1).toString();
            errors.get(2).toString();
            errors.get(0).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52626litNum54982__28 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52626litNum54982__28);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52458_failAssert130litString52670litNum55038() throws Exception {
        try {
            String html = "<select><option>Option 1</option></select>";
            Assert.assertEquals("<select><option>Option 1</option></select>", html);
            Parser parser = Parser.htmlParser().setTrackErrors(-2147483648);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertFalse(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52458_failAssert130litString52670__14 = errors.size();
            errors.get(-1).toString();
            errors.get(1).toString();
            errors.get(2).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52458 should have thrown IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52458_failAssert130litString52670__23 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52458_failAssert130litString52670__23);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605litString54930() throws Exception {
        try {
            String html = "Data</-sc";
            Assert.assertEquals("Data</-sc", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://exa^mple.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__14 = errors.size();
            errors.get(-1).toString();
            errors.get(1).toString();
            errors.get(2).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__24 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__24);
        }
    }

    @Test(timeout = 120000)
    public void handleNullContextInParseFragmentlitNum69029_failAssert161litNum69107litString70389() throws Exception {
        try {
            String html = "<ol><li>One</li></ol><p>Two</p>";
            Assert.assertEquals("<ol><li>One</li></ol><p>Two</p>", html);
            List<Node> nodes = Parser.parseFragment(html, null, "http://exampe.com/");
            int o_handleNullContextInParseFragmentlitNum69029_failAssert161litNum69107__8 = nodes.size();
            nodes.get(-1).nodeName();
            StringUtil.normaliseWhitespace(nodes.get(2147483647).outerHtml());
            org.junit.Assert.fail("handleNullContextInParseFragmentlitNum69029 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_handleNullContextInParseFragmentlitNum69029_failAssert161litNum69107litString70389__20 = expected.getMessage();
            Assert.assertEquals("-1", o_handleNullContextInParseFragmentlitNum69029_failAssert161litNum69107litString70389__20);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52627litNum54531() throws Exception {
        try {
            String html = "<p>One</p href='no'><!DOCTYPE html>&arrgh;<font /><br /><foo";
            Assert.assertEquals("<p>One</p href=\'no\'><!DOCTYPE html>&arrgh;<font /><br /><foo", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52627__14 = errors.size();
            errors.get(-1).toString();
            errors.get(2).toString();
            errors.get(2147483647).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52627litNum54531__28 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litNum52627litNum54531__28);
        }
    }

    @Test(timeout = 120000)
    public void parsesSimpleDocumentlitNum16560_failAssert74litString16615litString16751() throws Exception {
        try {
            String html = "<r><X>A</X><y>B</y></r>";
            Assert.assertEquals("<r><X>A</X><y>B</y></r>", html);
            Document doc = Jsoup.parse(html);
            Element p = doc.body().child(-1);
            p.tagName();
            Element img = p.child(0);
            img.attr("JBU");
            img.tagName();
            org.junit.Assert.fail("parsesSimpleDocumentlitNum16560 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_parsesSimpleDocumentlitNum16560_failAssert74litString16615__20 = expected.getMessage();
            Assert.assertEquals("-1", o_parsesSimpleDocumentlitNum16560_failAssert74litString16615__20);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605litNum54959() throws Exception {
        try {
            String html = "Data</-sc";
            Assert.assertEquals("Data</-sc", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__14 = errors.size();
            errors.get(-1).toString();
            errors.get(1).toString();
            errors.get(3).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__24 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__24);
        }
    }

    @Test(timeout = 120000)
    public void tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605litNum54958() throws Exception {
        try {
            String html = "Data</-sc";
            Assert.assertEquals("Data</-sc", html);
            Parser parser = Parser.htmlParser().setTrackErrors(3);
            Assert.assertNull(((org.jsoup.parser.Parser)parser).getErrors());
            Assert.assertTrue(((org.jsoup.parser.Parser)parser).isTrackErrors());
            Document doc = parser.parseInput(html, "http://example.com");
            List<ParseError> errors = parser.getErrors();
            int o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__14 = errors.size();
            errors.get(-1).toString();
            errors.get(1).toString();
            errors.get(1).toString();
            org.junit.Assert.fail("tracksLimitedErrorsWhenRequestedlitNum52462 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__24 = expected.getMessage();
            Assert.assertEquals("-1", o_tracksLimitedErrorsWhenRequestedlitNum52462_failAssert131litString52605__24);
        }
    }

    @Test(timeout = 120000)
    public void handleNullContextInParseFragmentlitString69019litString69201litNum70311_failAssert166() throws Exception {
        try {
            String html = "<body><p>Hello</body><p>there</p></body></body></html><p>now";
            List<Node> nodes = Parser.parseFragment(html, null, "http://eample.com/");
            int o_handleNullContextInParseFragmentlitString69019__5 = nodes.size();
            String o_handleNullContextInParseFragmentlitString69019__6 = nodes.get(-1).nodeName();
            String o_handleNullContextInParseFragmentlitString69019__8 = StringUtil.normaliseWhitespace(nodes.get(0).outerHtml());
            org.junit.Assert.fail("handleNullContextInParseFragmentlitString69019litString69201litNum70311 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            Assert.assertEquals("-1", expected.getMessage());
        }
    }

    @Test(timeout = 120000)
    public void parsesSimpleDocumentlitString16550_failAssert73litNum16632litNum16839() throws Exception {
        try {
            String html = "x3<k9aWMs1s[;6{!LZU7.[H(Q`3:PGB8UrDgToVVuk26F=7X?MUW!]J8N.3DN 3-DI5a6_J_ `y`c2Z:fT3HpK-ISf8[i:I+qV!n";
            Assert.assertEquals("x3<k9aWMs1s[;6{!LZU7.[H(Q`3:PGB8UrDgToVVuk26F=7X?MUW!]J8N.3DN 3-DI5a6_J_ `y`c2Z:fT3HpK-ISf8[i:I+qV!n", html);
            Document doc = Jsoup.parse(html);
            Element p = doc.body().child(-2147483648);
            p.tagName();
            Element img = p.child(2147483647);
            img.attr("src");
            img.tagName();
            org.junit.Assert.fail("parsesSimpleDocumentlitString16550 should have thrown IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException expected) {
            String o_parsesSimpleDocumentlitString16550_failAssert73litNum16632__20 = expected.getMessage();
            Assert.assertEquals("-2147483648", o_parsesSimpleDocumentlitString16550_failAssert73litNum16632__20);
        }
    }

    @Test(timeout = 120000)
    public void handlesEscapedDatalitNum7779_failAssert32litString7845litString7951() throws Exception {
        try {
            String html = "<div@ title=\'Surf &amp; Turf\'>Reef &amp; Beef</div>";
            Assert.assertEquals("<div@ title=\'Surf &amp; Turf\'>Reef &amp; Beef</div>", html);
            Document doc = Jsoup.parse(html);
            Element div = doc.getElementsByTag("div").get(-1);
            div.attr("tile");
            div.text();
            org.junit.Assert.fail("handlesEscapedDatalitNum7779 should have thrown ArrayIndexOutOfBoundsException");
        } catch (ArrayIndexOutOfBoundsException expected) {
            String o_handlesEscapedDatalitNum7779_failAssert32litString7845__17 = expected.getMessage();
            Assert.assertEquals("-1", o_handlesEscapedDatalitNum7779_failAssert32litString7845__17);
        }
    }

    @Test(timeout = 120000)
    public void parsesSimpleDocumentlitString16550_failAssert73litNum16632litNum16837() throws Exception {
        try {
            String html = "x3<k9aWMs1s[;6{!LZU7.[H(Q`3:PGB8UrDgToVVuk26F=7X?MUW!]J8N.3DN 3-DI5a6_J_ `y`c2Z:fT3HpK-ISf8[i:I+qV!n";
            Assert.assertEquals("x3<k9aWMs1s[;6{!LZU7.[H(Q`3:PGB8UrDgToVVuk26F=7X?MUW!]J8N.3DN 3-DI5a6_J_ `y`c2Z:fT3HpK-ISf8[i:I+qV!n", html);
            Document doc = Jsoup.parse(html);
            Element p = doc.body().child(-2147483648);
            p.tagName();
            Element img = p.child(-1);
            img.attr("src");
            img.tagName();
            org.junit.Assert.fail("parsesSimpleDocumentlitString16550 should have thrown IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException expected) {
            String o_parsesSimpleDocumentlitString16550_failAssert73litNum16632__20 = expected.getMessage();
            Assert.assertEquals("-2147483648", o_parsesSimpleDocumentlitString16550_failAssert73litNum16632__20);
        }
    }
}

