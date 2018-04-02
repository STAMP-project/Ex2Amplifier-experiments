package org.xwiki.diff.internal;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.xwiki.diff.DiffManager;
import org.xwiki.diff.MergeResult;
import org.xwiki.logging.LogLevel;
import org.xwiki.test.mockito.MockitoComponentMockingRule;


public class AmplDefaultDiffManagerTest {
    @Rule
    public final MockitoComponentMockingRule<DiffManager> mocker = new MockitoComponentMockingRule<DiffManager>(DefaultDiffManager.class);

    private static List<Character> toCharacters(String str) {
        List<Character> characters;
        if (str != null) {
            characters = new ArrayList<Character>(str.length());
            for (char c : str.toCharArray()) {
                characters.add(c);
            }
        }else {
            characters = Collections.emptyList();
        }
        return characters;
    }

    private static String toString(List<Character> characters) {
        return StringUtils.join(characters, null);
    }

    @Test(timeout = 10000)
    public void testMergeCharList() throws Exception {
        MergeResult<Character> result;
        result = this.mocker.getComponentUnderTest().merge(AmplDefaultDiffManagerTest.toCharacters("a"), AmplDefaultDiffManagerTest.toCharacters(""), AmplDefaultDiffManagerTest.toCharacters("b"), null);
        int o_testMergeCharList__9 = result.getLog().getLogs(LogLevel.ERROR).size();
        List<Character> o_testMergeCharList__12 = AmplDefaultDiffManagerTest.toCharacters("b");
        List<Character> o_testMergeCharList__13 = result.getMerged();
        result = this.mocker.getComponentUnderTest().merge(AmplDefaultDiffManagerTest.toCharacters("bc"), AmplDefaultDiffManagerTest.toCharacters("abc"), AmplDefaultDiffManagerTest.toCharacters("bc"), null);
        int o_testMergeCharList__21 = result.getLog().getLogs(LogLevel.ERROR).size();
        List<Character> o_testMergeCharList__24 = AmplDefaultDiffManagerTest.toCharacters("abc");
        List<Character> o_testMergeCharList__25 = result.getMerged();
        result = this.mocker.getComponentUnderTest().merge(AmplDefaultDiffManagerTest.toCharacters("ab"), AmplDefaultDiffManagerTest.toCharacters("abc"), AmplDefaultDiffManagerTest.toCharacters("ab"), null);
        int o_testMergeCharList__33 = result.getLog().getLogs(LogLevel.ERROR).size();
        List<Character> o_testMergeCharList__36 = AmplDefaultDiffManagerTest.toCharacters("abc");
        List<Character> o_testMergeCharList__37 = result.getMerged();
        result = this.mocker.getComponentUnderTest().merge(AmplDefaultDiffManagerTest.toCharacters("ac"), AmplDefaultDiffManagerTest.toCharacters("abc"), AmplDefaultDiffManagerTest.toCharacters("ac"), null);
        int o_testMergeCharList__45 = result.getLog().getLogs(LogLevel.ERROR).size();
        List<Character> o_testMergeCharList__48 = AmplDefaultDiffManagerTest.toCharacters("abc");
        List<Character> o_testMergeCharList__49 = result.getMerged();
        result = this.mocker.getComponentUnderTest().merge(AmplDefaultDiffManagerTest.toCharacters("b"), AmplDefaultDiffManagerTest.toCharacters("ab"), AmplDefaultDiffManagerTest.toCharacters("bc"), null);
        int o_testMergeCharList__57 = result.getLog().getLogs(LogLevel.ERROR).size();
        List<Character> o_testMergeCharList__60 = AmplDefaultDiffManagerTest.toCharacters("abc");
        List<Character> o_testMergeCharList__61 = result.getMerged();
        result = this.mocker.getComponentUnderTest().merge(AmplDefaultDiffManagerTest.toCharacters("b"), AmplDefaultDiffManagerTest.toCharacters("bc"), AmplDefaultDiffManagerTest.toCharacters("ab"), null);
        int o_testMergeCharList__69 = result.getLog().getLogs(LogLevel.ERROR).size();
        List<Character> o_testMergeCharList__72 = AmplDefaultDiffManagerTest.toCharacters("abc");
        List<Character> o_testMergeCharList__73 = result.getMerged();
        result = this.mocker.getComponentUnderTest().merge(AmplDefaultDiffManagerTest.toCharacters("abc"), AmplDefaultDiffManagerTest.toCharacters("aibc"), AmplDefaultDiffManagerTest.toCharacters("abcj"), null);
        int o_testMergeCharList__81 = result.getLog().getLogs(LogLevel.ERROR).size();
        List<Character> o_testMergeCharList__84 = AmplDefaultDiffManagerTest.toCharacters("aibcj");
        List<Character> o_testMergeCharList__85 = result.getMerged();
        result = this.mocker.getComponentUnderTest().merge(AmplDefaultDiffManagerTest.toCharacters("abc"), AmplDefaultDiffManagerTest.toCharacters("abcj"), AmplDefaultDiffManagerTest.toCharacters("aibc"), null);
        int o_testMergeCharList__92 = result.getLog().getLogs(LogLevel.ERROR).size();
        List<Character> o_testMergeCharList__95 = AmplDefaultDiffManagerTest.toCharacters("aibcj");
        List<Character> o_testMergeCharList__96 = result.getMerged();
        result = this.mocker.getComponentUnderTest().merge(AmplDefaultDiffManagerTest.toCharacters("abc"), AmplDefaultDiffManagerTest.toCharacters("ajbc"), AmplDefaultDiffManagerTest.toCharacters("aibc"), null);
        int o_testMergeCharList__103 = result.getLog().getLogs(LogLevel.ERROR).size();
        List<Character> o_testMergeCharList__106 = AmplDefaultDiffManagerTest.toCharacters("ajibc");
        List<Character> o_testMergeCharList__107 = result.getMerged();
        result = this.mocker.getComponentUnderTest().merge(AmplDefaultDiffManagerTest.toCharacters("ab"), AmplDefaultDiffManagerTest.toCharacters("aijb"), AmplDefaultDiffManagerTest.toCharacters("aib"), null);
        int o_testMergeCharList__114 = result.getLog().getLogs(LogLevel.ERROR).size();
        List<Character> o_testMergeCharList__117 = AmplDefaultDiffManagerTest.toCharacters("aijb");
        List<Character> o_testMergeCharList__118 = result.getMerged();
        result = this.mocker.getComponentUnderTest().merge(AmplDefaultDiffManagerTest.toCharacters("ab"), AmplDefaultDiffManagerTest.toCharacters("ajb"), AmplDefaultDiffManagerTest.toCharacters("aijb"), null);
        int o_testMergeCharList__125 = result.getLog().getLogs(LogLevel.ERROR).size();
        List<Character> o_testMergeCharList__128 = AmplDefaultDiffManagerTest.toCharacters("aijb");
        List<Character> o_testMergeCharList__129 = result.getMerged();
        result = this.mocker.getComponentUnderTest().merge(AmplDefaultDiffManagerTest.toCharacters(""), AmplDefaultDiffManagerTest.toCharacters("ab"), AmplDefaultDiffManagerTest.toCharacters("abc"), null);
        int o_testMergeCharList__136 = result.getLog().getLogs(LogLevel.ERROR).size();
        List<Character> o_testMergeCharList__139 = AmplDefaultDiffManagerTest.toCharacters("abc");
        List<Character> o_testMergeCharList__140 = result.getMerged();
        result = this.mocker.getComponentUnderTest().merge(AmplDefaultDiffManagerTest.toCharacters(""), AmplDefaultDiffManagerTest.toCharacters("abc"), AmplDefaultDiffManagerTest.toCharacters("ab"), null);
        int o_testMergeCharList__147 = result.getLog().getLogs(LogLevel.ERROR).size();
        Assert.assertEquals(0, ((int) (o_testMergeCharList__147)));
        List<Character> o_testMergeCharList__150 = AmplDefaultDiffManagerTest.toCharacters("abc");
        List<Character> o_testMergeCharList__151 = result.getMerged();
        result = this.mocker.getComponentUnderTest().merge(AmplDefaultDiffManagerTest.toCharacters(""), AmplDefaultDiffManagerTest.toCharacters("bc"), AmplDefaultDiffManagerTest.toCharacters("abc"), null);
        int o_testMergeCharList__158 = result.getLog().getLogs(LogLevel.ERROR).size();
        List<Character> o_testMergeCharList__161 = AmplDefaultDiffManagerTest.toCharacters("abc");
        List<Character> o_testMergeCharList__162 = result.getMerged();
        result = this.mocker.getComponentUnderTest().merge(AmplDefaultDiffManagerTest.toCharacters(""), AmplDefaultDiffManagerTest.toCharacters("abc"), AmplDefaultDiffManagerTest.toCharacters("bc"), null);
        int o_testMergeCharList__169 = result.getLog().getLogs(LogLevel.ERROR).size();
        List<Character> o_testMergeCharList__172 = AmplDefaultDiffManagerTest.toCharacters("abc");
        List<Character> o_testMergeCharList__173 = result.getMerged();
        result = this.mocker.getComponentUnderTest().merge(AmplDefaultDiffManagerTest.toCharacters("Alice Macro"), AmplDefaultDiffManagerTest.toCharacters("Alice Wiki Macro (upgraded)"), AmplDefaultDiffManagerTest.toCharacters("Alice Extension"), null);
        int o_testMergeCharList__181 = result.getLog().getLogs(LogLevel.ERROR).size();
        List<Character> o_testMergeCharList__184 = AmplDefaultDiffManagerTest.toCharacters("Alice Wiki Extension (upgraded)");
        List<Character> o_testMergeCharList__185 = result.getMerged();
        result = this.mocker.getComponentUnderTest().merge(AmplDefaultDiffManagerTest.toCharacters("$a(b)"), AmplDefaultDiffManagerTest.toCharacters("$c(d)e"), AmplDefaultDiffManagerTest.toCharacters("$c(d)e"), null);
        int o_testMergeCharList__192 = result.getLog().getLogs(LogLevel.ERROR).size();
    }
}

