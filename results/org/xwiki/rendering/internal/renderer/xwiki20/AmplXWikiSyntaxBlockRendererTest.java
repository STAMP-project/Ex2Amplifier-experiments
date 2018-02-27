package org.xwiki.rendering.internal.renderer.xwiki20;


import Syntax.XWIKI_2_0;
import org.junit.Before;
import org.junit.Rule;
import org.xwiki.component.manager.ComponentLookupException;
import org.xwiki.rendering.block.Block;
import org.xwiki.rendering.renderer.BlockRenderer;
import org.xwiki.rendering.renderer.printer.DefaultWikiPrinter;
import org.xwiki.test.annotation.AllComponents;
import org.xwiki.test.mockito.MockitoComponentManagerRule;


@AllComponents
public class AmplXWikiSyntaxBlockRendererTest {
    @Rule
    public MockitoComponentManagerRule componentManager = new MockitoComponentManagerRule();

    private BlockRenderer renderer;

    @Before
    public void before() throws ComponentLookupException {
        this.renderer = this.componentManager.getInstance(BlockRenderer.class, XWIKI_2_0.toIdString());
    }

    private String render(Block block) {
        DefaultWikiPrinter wikiPrinter = new DefaultWikiPrinter();
        this.renderer.render(block, wikiPrinter);
        return wikiPrinter.toString();
    }
}

