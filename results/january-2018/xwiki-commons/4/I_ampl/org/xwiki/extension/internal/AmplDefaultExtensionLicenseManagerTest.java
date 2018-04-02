package org.xwiki.extension.internal;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.xwiki.extension.ExtensionLicense;
import org.xwiki.extension.ExtensionLicenseManager;
import org.xwiki.test.ComponentManagerRule;
import org.xwiki.test.annotation.ComponentList;


@ComponentList({ DefaultExtensionLicenseManager.class })
public class AmplDefaultExtensionLicenseManagerTest {
    @Rule
    public final ComponentManagerRule componentManager = new ComponentManagerRule();

    private ExtensionLicenseManager licenseManager;

    @Before
    public void setUp() throws Exception {
        this.licenseManager = this.componentManager.getInstance(ExtensionLicenseManager.class);
    }

    @Test(timeout = 10000)
    public void testGetLicenselitString19_failAssert14() throws IOException, Exception {
        try {
            ExtensionLicense license = this.licenseManager.getLicense("Apache License 2.0");
            List<String> content = IOUtils.readLines(getClass().getResourceAsStream(""), StandardCharsets.UTF_8);
            content = content.subList(8, content.size());
            license.getName();
            license.getContent();
            license = this.licenseManager.getLicense("ASL");
            license.getName();
            license.getContent();
            org.junit.Assert.fail("testGetLicenselitString19 should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException eee) {
        }
    }
}

