package org.geoserver.wfs.v2_0;


import org.geoserver.data.test.MockData;
import org.geoserver.wfs.StoredQueryProvider;
import org.junit.Before;


public class AmplStoredQueryTest extends WFS20TestSupport {
    @Before
    public void clearQueries() {
        new StoredQueryProvider(getCatalog()).removeAll();
    }

    public String getCreatePrimitiveWithinQuery() {
        return ((((((((((((((((((("<wfs:CreateStoredQuery service='WFS' version='2.0.0' " + (((("   xmlns:wfs='http://www.opengis.net/wfs/2.0' " + "   xmlns:fes='http://www.opengis.org/fes/2.0' ") + "   xmlns:gml='http://www.opengis.net/gml/3.2' ") + "   xmlns:myns='http://www.someserver.com/myns' ") + "   xmlns:sf='")) + (MockData.SF_URI)) + "'>") + "   <wfs:StoredQueryDefinition id='myStoredQuery'> ") + "      <wfs:Parameter name='AreaOfInterest' type='gml:Polygon'/> ") + "      <wfs:QueryExpressionText ") + "           returnFeatureTypes='sf:PrimitiveGeoFeature' ") + "           language='urn:ogc:def:queryLanguage:OGC-WFS::WFS_QueryExpression' ") + "           isPrivate='false'> ") + "         <wfs:Query typeNames='sf:PrimitiveGeoFeature'> ") + "            <fes:Filter> ") + "               <fes:Within> ") + "                  <fes:ValueReference>pointProperty</fes:ValueReference> ") + "                  ${AreaOfInterest} ") + "               </fes:Within> ") + "            </fes:Filter> ") + "         </wfs:Query> ") + "      </wfs:QueryExpressionText> ") + "   </wfs:StoredQueryDefinition> ") + "</wfs:CreateStoredQuery>";
    }
}

