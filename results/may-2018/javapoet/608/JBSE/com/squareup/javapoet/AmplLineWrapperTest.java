package com.squareup.javapoet;


import com.google.common.truth.Truth;
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
}

