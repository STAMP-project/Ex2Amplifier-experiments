package org.xwiki.extension;


import org.junit.Assert;
import org.junit.Before;
import org.mockito.Mockito;
import org.xwiki.extension.repository.ExtensionRepository;


public class AmplAbstractExtensionTest {
    private static class TestExtension extends AbstractExtension {
        public TestExtension(ExtensionId id, String type, ExtensionId... features) {
            super(null, id, type);
            for (ExtensionId feature : features) {
                addExtensionFeature(feature);
            }
        }
    }

    private AbstractExtension extension;

    private ExtensionRepository repository;

    private ExtensionId id;

    private String type;

    private AbstractExtension toExtension(String id, String version, ExtensionId... features) {
        return new AmplAbstractExtensionTest.TestExtension(new ExtensionId(id, version), "test", features);
    }

    private void assertCompareTo(int comparizon, Extension e1, Extension e2) {
        Assert.assertEquals(comparizon, e1.compareTo(e2));
    }

    @Before
    public void before() {
        this.repository = Mockito.mock(ExtensionRepository.class);
        this.id = new ExtensionId("extesionid", "extensionversion");
        this.type = "extensiontype";
        this.extension = new AbstractExtension(this.repository, this.id, this.type) {};
    }
}

