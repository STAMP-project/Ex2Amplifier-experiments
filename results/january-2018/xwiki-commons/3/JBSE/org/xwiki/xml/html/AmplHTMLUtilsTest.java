package org.xwiki.xml.html;


import org.junit.Before;
import org.junit.Rule;
import org.xwiki.context.internal.DefaultExecution;
import org.xwiki.test.ComponentManagerRule;
import org.xwiki.test.annotation.ComponentList;
import org.xwiki.xml.internal.html.DefaultHTMLCleaner;
import org.xwiki.xml.internal.html.filter.AttributeFilter;
import org.xwiki.xml.internal.html.filter.BodyFilter;
import org.xwiki.xml.internal.html.filter.FontFilter;
import org.xwiki.xml.internal.html.filter.LinkFilter;
import org.xwiki.xml.internal.html.filter.ListFilter;
import org.xwiki.xml.internal.html.filter.ListItemFilter;


@ComponentList({ LinkFilter.class, ListFilter.class, ListItemFilter.class, FontFilter.class, BodyFilter.class, AttributeFilter.class, DefaultHTMLCleaner.class, DefaultExecution.class })
public class AmplHTMLUtilsTest {
    private HTMLCleaner cleaner;

    @Rule
    public final ComponentManagerRule componentManager = new ComponentManagerRule();

    @Before
    public void setUp() throws Exception {
        this.cleaner = this.componentManager.getInstance(HTMLCleaner.class);
    }
}

