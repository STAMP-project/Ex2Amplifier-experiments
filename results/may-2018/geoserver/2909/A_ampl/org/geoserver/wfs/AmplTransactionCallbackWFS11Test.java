package org.geoserver.wfs;


import java.util.List;
import org.geoserver.data.test.MockData;
import org.geoserver.test.GeoServerSystemTestSupport;
import org.junit.Before;


public class AmplTransactionCallbackWFS11Test extends WFSTestSupport {
    public static final String DELETE_ROAD_102 = "<wfs:Transaction service=\"WFS\" version=\"1.1.0\"" + ((((((((((((" xmlns:cite=\"http://www.opengis.net/cite\"" + " xmlns:ogc=\"http://www.opengis.net/ogc\"") + " xmlns:gml=\"http://www.opengis.net/gml\"") + " xmlns:wfs=\"http://www.opengis.net/wfs\">") + " <wfs:Delete typeName=\"cite:RoadSegments\">") + "   <ogc:Filter>") + "     <ogc:PropertyIsEqualTo>") + "       <ogc:PropertyName>FID</ogc:PropertyName>") + "       <ogc:Literal>102</ogc:Literal>") + "     </ogc:PropertyIsEqualTo>") + "   </ogc:Filter>") + " </wfs:Delete>") + "</wfs:Transaction>");

    private TransactionCallbackTester plugin;

    @Override
    protected void setUpSpring(List<String> springContextLocations) {
        super.setUpSpring(springContextLocations);
        springContextLocations.add("classpath:/org/geoserver/wfs/TransactionCallbackTestContext.xml");
    }

    @Before
    public void clearState() throws Exception {
        revertLayer(MockData.ROAD_SEGMENTS);
        plugin = ((TransactionCallbackTester) (GeoServerSystemTestSupport.applicationContext.getBean("transactionCallbackTester")));
        plugin.clear();
    }
}

