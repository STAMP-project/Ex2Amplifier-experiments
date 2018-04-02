package org.xwiki.diff.internal;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.junit.Rule;
import org.xwiki.diff.DiffManager;
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
}

