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
package org.xwiki.xml.stax;


import javax.xml.stream.Location;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import org.mockito.Mockito;


/**
 * Unit tests for {@link org.xwiki.xml.stax.StAXUtils}.
 *
 * @version $Id$
 * @since 5.2M1
 */
public class AmplStAXUtilsTest {
    private XMLStreamReader mockXMLStreamReader() {
        XMLStreamReader xmlStreamReader = Mockito.mock(XMLStreamReader.class);
        Mockito.when(xmlStreamReader.getEventType()).thenReturn(XMLStreamConstants.START_DOCUMENT);
        Location location = Mockito.mock(Location.class);
        Mockito.when(xmlStreamReader.getLocation()).thenReturn(location);
        return xmlStreamReader;
    }

    private XMLEventReader mockXMLEventReader() throws XMLStreamException {
        XMLEventReader xmlEventReader = Mockito.mock(XMLEventReader.class);
        XMLEvent event = Mockito.mock(XMLEvent.class);
        Mockito.when(event.getEventType()).thenReturn(XMLStreamConstants.START_DOCUMENT);
        Mockito.when(xmlEventReader.peek()).thenReturn(event);
        Location location = Mockito.mock(Location.class);
        Mockito.when(event.getLocation()).thenReturn(location);
        return xmlEventReader;
    }
}

