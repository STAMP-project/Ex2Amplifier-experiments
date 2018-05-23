package org.jsoup.parser;


import java.io.File;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.integration.ParseTest;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Assert;
import org.junit.Test;


public class AmplHtmlParserTest {
    @Test(timeout = 120000)
    public void testTemplateInsideTable() throws IOException, Exception {
        File in = ParseTest.getFile("/htmltests/table-polymer-template.html");
        Document doc = Jsoup.parse(in, "UTF-8");
        Document.OutputSettings o_testTemplateInsideTable__5 = doc.outputSettings().prettyPrint(true);
        Assert.assertEquals(0, ((int) (((org.jsoup.nodes.Document.OutputSettings.Syntax)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).syntax()).ordinal())));
        Assert.assertFalse(((java.nio.charset.CharsetDecoder)((java.nio.charset.Charset)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).charset()).newDecoder()).isAutoDetecting());
        Assert.assertEquals(3.0F, ((float) (((java.nio.charset.CharsetEncoder)((java.nio.charset.Charset)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).charset()).newEncoder()).maxBytesPerChar())), 0.1);
        Assert.assertTrue(((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).prettyPrint());
        Assert.assertEquals("UTF-8", ((java.nio.charset.Charset)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).charset()).toString());
        Assert.assertEquals(1.0F, ((float) (((java.nio.charset.CharsetDecoder)((java.nio.charset.Charset)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).charset()).newDecoder()).maxCharsPerByte())), 0.1);
        Assert.assertFalse(((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).outline());
        Assert.assertEquals("html", ((org.jsoup.nodes.Document.OutputSettings.Syntax)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).syntax()).name());
        Assert.assertEquals("UTF-8", ((java.nio.charset.Charset)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).charset()).displayName());
        byte[] array_1150482841 = new byte[]{63};
        	byte[] array_1434614297 = (byte[])((java.nio.charset.CharsetEncoder)((java.nio.charset.Charset)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).charset()).newEncoder()).replacement();
        	for(int ii = 0; ii <array_1150482841.length; ii++) {
        		org.junit.Assert.assertEquals(array_1150482841[ii], array_1434614297[ii]);
        	};
        Assert.assertEquals("\ufffd", ((java.nio.charset.CharsetDecoder)((java.nio.charset.Charset)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).charset()).newDecoder()).replacement());
        Assert.assertEquals(1, ((int) (((org.jsoup.nodes.Entities.EscapeMode)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).escapeMode()).ordinal())));
        Assert.assertEquals(1.1F, ((float) (((java.nio.charset.CharsetEncoder)((java.nio.charset.Charset)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).charset()).newEncoder()).averageBytesPerChar())), 0.1);
        Assert.assertEquals("UTF-8", ((java.nio.charset.Charset)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).charset()).name());
        Assert.assertTrue(((java.nio.charset.Charset)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).charset()).isRegistered());
        Assert.assertTrue(((java.nio.charset.Charset)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).charset()).canEncode());
        Assert.assertEquals(1.0F, ((float) (((java.nio.charset.CharsetDecoder)((java.nio.charset.Charset)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).charset()).newDecoder()).averageCharsPerByte())), 0.1);
        Assert.assertTrue(((java.nio.charset.Charset)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).charset()).aliases().contains("unicode-1-1-utf-8"));
        Assert.assertTrue(((java.nio.charset.Charset)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).charset()).aliases().contains("UTF8"));
        Assert.assertEquals("base", ((org.jsoup.nodes.Entities.EscapeMode)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).escapeMode()).name());
        Assert.assertEquals(81070450, ((int) (((java.nio.charset.Charset)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).charset()).hashCode())));
        Assert.assertEquals(1, ((int) (((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).indentAmount())));
        Elements templates = doc.body().getElementsByTag("template");
        for (Element template : templates) {
            boolean boolean_6 = (template.childNodes().size()) > 1;
        }
        Assert.assertEquals(0, ((int) (((org.jsoup.nodes.Document.OutputSettings.Syntax)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).syntax()).ordinal())));
        Assert.assertFalse(((java.nio.charset.CharsetDecoder)((java.nio.charset.Charset)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).charset()).newDecoder()).isAutoDetecting());
        Assert.assertEquals(3.0F, ((float) (((java.nio.charset.CharsetEncoder)((java.nio.charset.Charset)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).charset()).newEncoder()).maxBytesPerChar())), 0.1);
        Assert.assertTrue(((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).prettyPrint());
        Assert.assertEquals("UTF-8", ((java.nio.charset.Charset)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).charset()).toString());
        Assert.assertEquals(1.0F, ((float) (((java.nio.charset.CharsetDecoder)((java.nio.charset.Charset)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).charset()).newDecoder()).maxCharsPerByte())), 0.1);
        Assert.assertFalse(((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).outline());
        Assert.assertEquals("html", ((org.jsoup.nodes.Document.OutputSettings.Syntax)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).syntax()).name());
        Assert.assertEquals("UTF-8", ((java.nio.charset.Charset)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).charset()).displayName());
        byte[] array_156591366 = new byte[]{63};
        	byte[] array_825130495 = (byte[])((java.nio.charset.CharsetEncoder)((java.nio.charset.Charset)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).charset()).newEncoder()).replacement();
        	for(int ii = 0; ii <array_156591366.length; ii++) {
        		org.junit.Assert.assertEquals(array_156591366[ii], array_825130495[ii]);
        	};
        Assert.assertEquals("\ufffd", ((java.nio.charset.CharsetDecoder)((java.nio.charset.Charset)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).charset()).newDecoder()).replacement());
        Assert.assertEquals(1, ((int) (((org.jsoup.nodes.Entities.EscapeMode)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).escapeMode()).ordinal())));
        Assert.assertEquals(1.1F, ((float) (((java.nio.charset.CharsetEncoder)((java.nio.charset.Charset)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).charset()).newEncoder()).averageBytesPerChar())), 0.1);
        Assert.assertEquals("UTF-8", ((java.nio.charset.Charset)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).charset()).name());
        Assert.assertTrue(((java.nio.charset.Charset)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).charset()).isRegistered());
        Assert.assertTrue(((java.nio.charset.Charset)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).charset()).canEncode());
        Assert.assertEquals(1.0F, ((float) (((java.nio.charset.CharsetDecoder)((java.nio.charset.Charset)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).charset()).newDecoder()).averageCharsPerByte())), 0.1);
        Assert.assertTrue(((java.nio.charset.Charset)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).charset()).aliases().contains("unicode-1-1-utf-8"));
        Assert.assertTrue(((java.nio.charset.Charset)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).charset()).aliases().contains("UTF8"));
        Assert.assertEquals("base", ((org.jsoup.nodes.Entities.EscapeMode)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).escapeMode()).name());
        Assert.assertEquals(81070450, ((int) (((java.nio.charset.Charset)((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).charset()).hashCode())));
        Assert.assertEquals(1, ((int) (((org.jsoup.nodes.Document.OutputSettings)o_testTemplateInsideTable__5).indentAmount())));
    }
}

