package org.xwiki.xml.stax;


import javax.xml.stream.Location;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import org.mockito.Mockito;


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

