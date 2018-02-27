/**
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
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


/**
 * Unit tests for {@link org.xwiki.xml.html.HTMLUtils}.
 *
 * @version $Id$
 * @since 1.8.3
 */
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

