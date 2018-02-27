package org.xwiki.rendering.internal.parser.xwiki20;


import javax.inject.Provider;
import org.junit.Before;
import org.junit.Rule;
import org.mockito.Mockito;
import org.xwiki.component.manager.ComponentManager;
import org.xwiki.component.util.DefaultParameterizedType;
import org.xwiki.rendering.internal.parser.reference.type.AttachmentResourceReferenceTypeParser;
import org.xwiki.rendering.internal.parser.reference.type.URLResourceReferenceTypeParser;
import org.xwiki.rendering.parser.ResourceReferenceParser;
import org.xwiki.rendering.wiki.WikiModel;
import org.xwiki.test.annotation.BeforeComponent;
import org.xwiki.test.annotation.ComponentList;
import org.xwiki.test.mockito.MockitoComponentManagerRule;


@ComponentList({ XWiki20ImageReferenceParser.class, URLResourceReferenceTypeParser.class, AttachmentResourceReferenceTypeParser.class })
public class AmplXWiki20ImageReferenceParserTest {
    @Rule
    public MockitoComponentManagerRule componentManager = new MockitoComponentManagerRule();

    private ResourceReferenceParser parser;

    @BeforeComponent
    public void setUpComponents() throws Exception {
        this.componentManager.registerMockComponent(WikiModel.class);
        Provider<ComponentManager> contextComponentManagerProvider = this.componentManager.registerMockComponent(new DefaultParameterizedType(null, Provider.class, ComponentManager.class), "context");
        Mockito.when(contextComponentManagerProvider.get()).thenReturn(this.componentManager);
    }

    @Before
    public void setUp() throws Exception {
        this.parser = this.componentManager.getInstance(ResourceReferenceParser.class, "xwiki/2.0/image");
    }
}

