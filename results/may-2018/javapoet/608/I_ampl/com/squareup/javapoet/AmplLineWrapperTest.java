package com.squareup.javapoet;


import com.google.common.truth.Truth;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public final class AmplLineWrapperTest {
    @Ignore
    @Test
    public void overlyLongLinesWithLeadingZeroWidth() throws Exception {
        StringBuffer out = new StringBuffer();
        LineWrapper lineWrapper = new LineWrapper(out, "  ", 10);
        lineWrapper.zeroWidthSpace(2);
        lineWrapper.append("abcdefghijkl");
        lineWrapper.close();
        Truth.assertThat(out.toString()).isEqualTo("abcdefghijkl");
    }

    @Test(timeout = 120000)
    public void nospaceWrapMax_add13364_add13442_remove13715() throws Exception {
        StringBuffer out = new StringBuffer();
        LineWrapper lineWrapper = new LineWrapper(out, "  ", 10);
        lineWrapper.zeroWidthSpace(2);
        lineWrapper.append("fghijk");
        lineWrapper.append("fghijk");
        lineWrapper.close();
        String o_nospaceWrapMax_add13364__9 = out.toString();
        Assert.assertEquals("\n    fghijkfghijk", o_nospaceWrapMax_add13364__9);
    }

    @Test(timeout = 120000)
    public void nospaceWrapMax_add13364_remove13439_add13761() throws Exception {
        StringBuffer out = new StringBuffer();
        LineWrapper lineWrapper = new LineWrapper(out, "  ", 10);
        lineWrapper.zeroWidthSpace(2);
        lineWrapper.append("fghijk");
        lineWrapper.append("fghijk");
        lineWrapper.close();
        String o_nospaceWrapMax_add13364__9 = out.toString();
        Assert.assertEquals("\n    fghijkfghijk", o_nospaceWrapMax_add13364__9);
    }

    @Test(timeout = 120000)
    public void zeroWidthNoWrap_add14996_remove15079_remove15396() throws Exception {
        StringBuffer out = new StringBuffer();
        LineWrapper lineWrapper = new LineWrapper(out, "  ", 10);
        lineWrapper.zeroWidthSpace(2);
        lineWrapper.append("fghij");
        String o_zeroWidthNoWrap_add14996__9 = out.toString();
        Assert.assertEquals("", o_zeroWidthNoWrap_add14996__9);
    }

    @Test(timeout = 120000)
    public void wrapEmbeddedNewlines_ZeroWidth_add10_remove149_remove501() throws Exception {
        StringBuffer out = new StringBuffer();
        LineWrapper lineWrapper = new LineWrapper(out, "  ", 10);
        lineWrapper.zeroWidthSpace(2);
        lineWrapper.append("opqrstuvwxy");
        lineWrapper.close();
        String o_wrapEmbeddedNewlines_ZeroWidth_add10__10 = out.toString();
        Assert.assertEquals("\n    opqrstuvwxy", o_wrapEmbeddedNewlines_ZeroWidth_add10__10);
    }

    @Test(timeout = 120000)
    public void nospaceWrapMax_add13364_remove13451_remove13730() throws Exception {
        StringBuffer out = new StringBuffer();
        LineWrapper lineWrapper = new LineWrapper(out, "  ", 10);
        lineWrapper.zeroWidthSpace(2);
        lineWrapper.append("fghijk");
        String o_nospaceWrapMax_add13364__9 = out.toString();
        Assert.assertEquals("", o_nospaceWrapMax_add13364__9);
    }

    @Test(timeout = 120000)
    public void noWrapEmbeddedNewlines_ZeroWidth_add14022_remove14129_remove14534() throws Exception {
        StringBuffer out = new StringBuffer();
        LineWrapper lineWrapper = new LineWrapper(out, "  ", 10);
        lineWrapper.zeroWidthSpace(2);
        lineWrapper.append("opqrstuvwxyz");
        lineWrapper.close();
        String o_noWrapEmbeddedNewlines_ZeroWidth_add14022__10 = out.toString();
        Assert.assertEquals("\n    opqrstuvwxyz", o_noWrapEmbeddedNewlines_ZeroWidth_add14022__10);
    }

    @Test(timeout = 120000)
    public void nospaceWrapMax_add13364_remove13439_remove13765() throws Exception {
        StringBuffer out = new StringBuffer();
        LineWrapper lineWrapper = new LineWrapper(out, "  ", 10);
        lineWrapper.zeroWidthSpace(2);
        lineWrapper.append("fghijk");
        String o_nospaceWrapMax_add13364__9 = out.toString();
        Assert.assertEquals("", o_nospaceWrapMax_add13364__9);
    }

    @Test(timeout = 120000)
    public void noWrapEmbeddedNewlines_ZeroWidth_add14022_remove14121_remove14617() throws Exception {
        StringBuffer out = new StringBuffer();
        LineWrapper lineWrapper = new LineWrapper(out, "  ", 10);
        lineWrapper.zeroWidthSpace(2);
        lineWrapper.append("opqrstuvwxyz");
        lineWrapper.close();
        String o_noWrapEmbeddedNewlines_ZeroWidth_add14022__10 = out.toString();
        Assert.assertEquals("\n    opqrstuvwxyz", o_noWrapEmbeddedNewlines_ZeroWidth_add14022__10);
    }

    @Test(timeout = 120000)
    public void zeroWidthNoWrap_add14996_remove15089_remove15393() throws Exception {
        StringBuffer out = new StringBuffer();
        LineWrapper lineWrapper = new LineWrapper(out, "  ", 10);
        lineWrapper.zeroWidthSpace(2);
        lineWrapper.append("fghij");
        String o_zeroWidthNoWrap_add14996__9 = out.toString();
        Assert.assertEquals("", o_zeroWidthNoWrap_add14996__9);
    }

    @Test(timeout = 120000)
    public void wrapEmbeddedNewlines_ZeroWidth_add10_remove146_remove607() throws Exception {
        StringBuffer out = new StringBuffer();
        LineWrapper lineWrapper = new LineWrapper(out, "  ", 10);
        lineWrapper.zeroWidthSpace(2);
        lineWrapper.append("opqrstuvwxy");
        lineWrapper.close();
        String o_wrapEmbeddedNewlines_ZeroWidth_add10__10 = out.toString();
        Assert.assertEquals("\n    opqrstuvwxy", o_wrapEmbeddedNewlines_ZeroWidth_add10__10);
    }

    @Test(timeout = 120000)
    public void wrapEmbeddedNewlines_ZeroWidth_add10_remove147_remove598() throws Exception {
        StringBuffer out = new StringBuffer();
        LineWrapper lineWrapper = new LineWrapper(out, "  ", 10);
        lineWrapper.zeroWidthSpace(2);
        lineWrapper.append("opqrstuvwxy");
        lineWrapper.close();
        String o_wrapEmbeddedNewlines_ZeroWidth_add10__10 = out.toString();
        Assert.assertEquals("\n    opqrstuvwxy", o_wrapEmbeddedNewlines_ZeroWidth_add10__10);
    }

    @Test(timeout = 120000)
    public void wrapEmbeddedNewlines_ZeroWidth_add10_remove151_remove505() throws Exception {
        StringBuffer out = new StringBuffer();
        LineWrapper lineWrapper = new LineWrapper(out, "  ", 10);
        lineWrapper.zeroWidthSpace(2);
        lineWrapper.append("opqrstuvwxy");
        lineWrapper.close();
        String o_wrapEmbeddedNewlines_ZeroWidth_add10__10 = out.toString();
        Assert.assertEquals("\n    opqrstuvwxy", o_wrapEmbeddedNewlines_ZeroWidth_add10__10);
    }

    @Test(timeout = 120000)
    public void wrapEmbeddedNewlines_ZeroWidth_add11_remove80_remove525() throws Exception {
        StringBuffer out = new StringBuffer();
        LineWrapper lineWrapper = new LineWrapper(out, "  ", 10);
        lineWrapper.zeroWidthSpace(2);
        lineWrapper.append("opqrstuvwxy");
        lineWrapper.close();
        String o_wrapEmbeddedNewlines_ZeroWidth_add11__10 = out.toString();
        Assert.assertEquals("\n    opqrstuvwxy", o_wrapEmbeddedNewlines_ZeroWidth_add11__10);
    }

    @Test(timeout = 120000)
    public void wrapEmbeddedNewlines_ZeroWidth_add11_remove92_remove498() throws Exception {
        StringBuffer out = new StringBuffer();
        LineWrapper lineWrapper = new LineWrapper(out, "  ", 10);
        lineWrapper.zeroWidthSpace(2);
        lineWrapper.append("opqrstuvwxy");
        lineWrapper.close();
        String o_wrapEmbeddedNewlines_ZeroWidth_add11__10 = out.toString();
        Assert.assertEquals("\n    opqrstuvwxy", o_wrapEmbeddedNewlines_ZeroWidth_add11__10);
    }

    @Test(timeout = 120000)
    public void wrapEmbeddedNewlines_ZeroWidth_add11_remove116_remove525() throws Exception {
        StringBuffer out = new StringBuffer();
        LineWrapper lineWrapper = new LineWrapper(out, "  ", 10);
        lineWrapper.zeroWidthSpace(2);
        lineWrapper.append("opqrstuvwxy");
        lineWrapper.close();
        String o_wrapEmbeddedNewlines_ZeroWidth_add11__10 = out.toString();
        Assert.assertEquals("\n    opqrstuvwxy", o_wrapEmbeddedNewlines_ZeroWidth_add11__10);
    }

    @Test(timeout = 120000)
    public void wrapEmbeddedNewlines_ZeroWidth_add11_remove122_remove519() throws Exception {
        StringBuffer out = new StringBuffer();
        LineWrapper lineWrapper = new LineWrapper(out, "  ", 10);
        lineWrapper.zeroWidthSpace(2);
        lineWrapper.append("opqrstuvwxy");
        lineWrapper.close();
        String o_wrapEmbeddedNewlines_ZeroWidth_add11__10 = out.toString();
        Assert.assertEquals("\n    opqrstuvwxy", o_wrapEmbeddedNewlines_ZeroWidth_add11__10);
    }

    @Test(timeout = 120000)
    public void noWrapEmbeddedNewlines_ZeroWidth_add14018_remove14123_remove14555() throws Exception {
        StringBuffer out = new StringBuffer();
        LineWrapper lineWrapper = new LineWrapper(out, "  ", 10);
        lineWrapper.zeroWidthSpace(2);
        lineWrapper.append("opqrstuvwxyz");
        lineWrapper.close();
        String o_noWrapEmbeddedNewlines_ZeroWidth_add14018__10 = out.toString();
        Assert.assertEquals("\n    opqrstuvwxyz", o_noWrapEmbeddedNewlines_ZeroWidth_add14018__10);
    }

    @Test(timeout = 120000)
    public void noWrapEmbeddedNewlines_ZeroWidth_add14018_remove14129_remove14517() throws Exception {
        StringBuffer out = new StringBuffer();
        LineWrapper lineWrapper = new LineWrapper(out, "  ", 10);
        lineWrapper.zeroWidthSpace(2);
        lineWrapper.append("opqrstuvwxyz");
        lineWrapper.close();
        String o_noWrapEmbeddedNewlines_ZeroWidth_add14018__10 = out.toString();
        Assert.assertEquals("\n    opqrstuvwxyz", o_noWrapEmbeddedNewlines_ZeroWidth_add14018__10);
    }

    @Test(timeout = 120000)
    public void nospaceWrapMax_add13361_add13425_remove13753() throws Exception {
        StringBuffer out = new StringBuffer();
        LineWrapper lineWrapper = new LineWrapper(out, "  ", 10);
        lineWrapper.zeroWidthSpace(2);
        lineWrapper.append("fghijk");
        lineWrapper.append("fghijk");
        lineWrapper.close();
        String o_nospaceWrapMax_add13361__9 = out.toString();
        Assert.assertEquals("\n    fghijkfghijk", o_nospaceWrapMax_add13361__9);
    }

    @Test(timeout = 120000)
    public void nospaceWrapMax_add13361_remove13437_add13752() throws Exception {
        StringBuffer out = new StringBuffer();
        LineWrapper lineWrapper = new LineWrapper(out, "  ", 10);
        lineWrapper.zeroWidthSpace(2);
        lineWrapper.append("fghijk");
        lineWrapper.append("fghijk");
        lineWrapper.close();
        String o_nospaceWrapMax_add13361__9 = out.toString();
        Assert.assertEquals("\n    fghijkfghijk", o_nospaceWrapMax_add13361__9);
    }

    @Test(timeout = 120000)
    public void nospaceWrapMax_add13361_remove13437_remove13758() throws Exception {
        StringBuffer out = new StringBuffer();
        LineWrapper lineWrapper = new LineWrapper(out, "  ", 10);
        lineWrapper.zeroWidthSpace(2);
        lineWrapper.append("fghijk");
        String o_nospaceWrapMax_add13361__9 = out.toString();
        Assert.assertEquals("", o_nospaceWrapMax_add13361__9);
    }

    @Test(timeout = 120000)
    public void nospaceWrapMax_add13361_remove13447_remove13726() throws Exception {
        StringBuffer out = new StringBuffer();
        LineWrapper lineWrapper = new LineWrapper(out, "  ", 10);
        lineWrapper.zeroWidthSpace(2);
        lineWrapper.append("fghijk");
        String o_nospaceWrapMax_add13361__9 = out.toString();
        Assert.assertEquals("", o_nospaceWrapMax_add13361__9);
    }

    @Test(timeout = 120000)
    public void wrapEmbeddedNewlines_ZeroWidth_add10_remove115_remove584() throws Exception {
        StringBuffer out = new StringBuffer();
        LineWrapper lineWrapper = new LineWrapper(out, "  ", 10);
        lineWrapper.zeroWidthSpace(2);
        lineWrapper.append("opqrstuvwxy");
        lineWrapper.close();
        String o_wrapEmbeddedNewlines_ZeroWidth_add10__10 = out.toString();
        Assert.assertEquals("\n    opqrstuvwxy", o_wrapEmbeddedNewlines_ZeroWidth_add10__10);
    }

    @Test(timeout = 120000)
    public void wrapEmbeddedNewlines_ZeroWidth_add10_remove121_remove500() throws Exception {
        StringBuffer out = new StringBuffer();
        LineWrapper lineWrapper = new LineWrapper(out, "  ", 10);
        lineWrapper.zeroWidthSpace(2);
        lineWrapper.append("opqrstuvwxy");
        lineWrapper.close();
        String o_wrapEmbeddedNewlines_ZeroWidth_add10__10 = out.toString();
        Assert.assertEquals("\n    opqrstuvwxy", o_wrapEmbeddedNewlines_ZeroWidth_add10__10);
    }

    @Test(timeout = 120000)
    public void zeroWidthNoWrap_add14991_remove15062_remove15383() throws Exception {
        StringBuffer out = new StringBuffer();
        LineWrapper lineWrapper = new LineWrapper(out, "  ", 10);
        lineWrapper.zeroWidthSpace(2);
        lineWrapper.append("fghij");
        String o_zeroWidthNoWrap_add14991__9 = out.toString();
        Assert.assertEquals("", o_zeroWidthNoWrap_add14991__9);
    }

    @Test(timeout = 120000)
    public void zeroWidthNoWrap_add14991_remove15069_remove15374() throws Exception {
        StringBuffer out = new StringBuffer();
        LineWrapper lineWrapper = new LineWrapper(out, "  ", 10);
        lineWrapper.zeroWidthSpace(2);
        lineWrapper.append("fghij");
        String o_zeroWidthNoWrap_add14991__9 = out.toString();
        Assert.assertEquals("", o_zeroWidthNoWrap_add14991__9);
    }
}

