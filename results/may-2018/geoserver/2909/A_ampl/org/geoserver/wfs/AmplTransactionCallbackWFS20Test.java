package org.geoserver.wfs;


import java.util.List;
import org.geoserver.data.test.MockData;
import org.geoserver.test.GeoServerSystemTestSupport;
import org.geoserver.wfs.v2_0.WFS20TestSupport;
import org.geotools.filter.v2_0.FES;
import org.geotools.gml3.v3_2.GML;
import org.geotools.wfs.v2_0.WFS;
import org.junit.Before;


public class AmplTransactionCallbackWFS20Test extends WFS20TestSupport {
    public static final String DELETE_ROAD_102 = ((((((((((((((((("<wfs:Transaction service=\"WFS\" version=\"2.0.0\" " + ("xmlns:cite=\"http://www.opengis.net/cite\" " + "xmlns:fes='")) + (FES.NAMESPACE)) + "' ") + "xmlns:wfs='") + (WFS.NAMESPACE)) + "' ") + "xmlns:gml='") + (GML.NAMESPACE)) + "'>") + " <wfs:Delete typeName=\"cite:RoadSegments\">") + "   <fes:Filter>") + "     <fes:PropertyIsEqualTo>") + "       <fes:ValueReference>FID</fes:ValueReference>") + "       <fes:Literal>102</fes:Literal>") + "     </fes:PropertyIsEqualTo>") + "   </fes:Filter>") + " </wfs:Delete>") + "</wfs:Transaction>";

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

