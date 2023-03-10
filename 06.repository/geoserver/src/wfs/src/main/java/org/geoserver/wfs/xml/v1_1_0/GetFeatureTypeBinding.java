/* (c) 2014 Open Source Geospatial Foundation - all rights reserved
 * (c) 2001 - 2013 OpenPlans
 * This code is licensed under the GPL 2.0 license, available at the root
 * application directory.
 */
package org.geoserver.wfs.xml.v1_1_0;

import java.math.BigInteger;
import javax.xml.namespace.QName;
import net.opengis.wfs.GetFeatureType;
import net.opengis.wfs.QueryType;
import net.opengis.wfs.ResultTypeType;
import net.opengis.wfs.WfsFactory;
import org.geoserver.wfs.xml.SqlViewParamsExtractor;
import org.geotools.util.Converters;
import org.geotools.xsd.AbstractComplexBinding;
import org.geotools.xsd.ElementInstance;
import org.geotools.xsd.Node;

/**
 * Binding object for the type http://www.opengis.net/wfs:GetFeatureType.
 *
 * <p>
 *
 * <pre>
 *         <code>
 *  &lt;xsd:complexType name="GetFeatureType"&gt;
 *      &lt;xsd:annotation&gt;
 *          &lt;xsd:documentation&gt;
 *              A GetFeature element contains one or more Query elements
 *              that describe a query operation on one feature type.  In
 *              response to a GetFeature request, a Web Feature Service
 *              must be able to generate a GML3 response that validates
 *              using a schema generated by the DescribeFeatureType request.
 *              A Web Feature Service may support other possibly non-XML
 *              (and even binary) output formats as long as those formats
 *              are advertised in the capabilities document.
 *           &lt;/xsd:documentation&gt;
 *      &lt;/xsd:annotation&gt;
 *      &lt;xsd:complexContent&gt;
 *          &lt;xsd:extension base="wfs:BaseRequestType"&gt;
 *              &lt;xsd:sequence&gt;
 *                  &lt;xsd:element maxOccurs="unbounded" ref="wfs:Query"/&gt;
 *              &lt;/xsd:sequence&gt;
 *              &lt;xsd:attribute default="results" name="resultType"
 *                  type="wfs:ResultTypeType" use="optional"&gt;
 *                  &lt;xsd:annotation&gt;
 *                      &lt;xsd:documentation&gt;
 *                       The resultType attribute is used to indicate
 *                       what response a WFS should return to user once
 *                       a GetFeature request is processed.
 *                       Possible values are:
 *                          results - meaning that the full response set
 *                                    (i.e. all the feature instances)
 *                                    should be returned.
 *                          hits    - meaning that an empty response set
 *                                    should be returned (i.e. no feature
 *                                    instances should be returned) but
 *                                    the "numberOfFeatures" attribute
 *                                    should be set to the number of feature
 *                                    instances that would be returned.
 *                    &lt;/xsd:documentation&gt;
 *                  &lt;/xsd:annotation&gt;
 *              &lt;/xsd:attribute&gt;
 *              &lt;xsd:attribute default="text/xml; subtype=gml/3.1.1"
 *                  name="outputFormat" type="xsd:string" use="optional"&gt;
 *                  &lt;xsd:annotation&gt;
 *                      &lt;xsd:documentation&gt;
 *                       The outputFormat attribute is used to specify the output
 *                       format that the Web Feature Service should generate in
 *                       response to a GetFeature or GetFeatureWithLock element.
 *                       The default value of 'text/xml; subtype=gml/3.1.1'
 *                       indicates that the output is an XML document that
 *                       conforms to the Geography Markup Language (GML)
 *                       Implementation Specification V3.1.1.
 *                       For the purposes of experimentation, vendor extension,
 *                       or even extensions that serve a specific community of
 *                       interest, other acceptable output format values may be
 *                       used to specify other formats as long as those values
 *                       are advertised in the capabilities document.
 *                       For example, the value WKB may be used to indicate that a
 *                       Well Known Binary format be used to encode the output.
 *                    &lt;/xsd:documentation&gt;
 *                  &lt;/xsd:annotation&gt;
 *              &lt;/xsd:attribute&gt;
 *              &lt;xsd:attribute name="maxFeatures" type="xsd:positiveInteger" use="optional"&gt;
 *                  &lt;xsd:annotation&gt;
 *                      &lt;xsd:documentation&gt;
 *                       The maxFeatures attribute is used to specify the maximum
 *                       number of features that a GetFeature operation should
 *                       generate (regardless of the actual number of query hits).
 *                    &lt;/xsd:documentation&gt;
 *                  &lt;/xsd:annotation&gt;
 *              &lt;/xsd:attribute&gt;
 *              &lt;xsd:attribute name="traverseXlinkDepth" type="xsd:string" use="optional"&gt;
 *                  &lt;xsd:annotation&gt;
 *                      &lt;xsd:documentation&gt;
 *                       This attribute indicates the depth to which nested property
 *                       XLink linking element locator attribute (href) XLinks are
 *                       traversed and resolved if possible.  A value of "1"
 *                       indicates that one linking element locator attribute
 *                       (href) Xlink will be traversed and the referenced element
 *                       returned if possible, but nested property XLink linking
 *                       element locator attribute (href) XLinks in the returned
 *                       element are not traversed.  A value of "*" indicates that
 *                       all nested property XLink linking element locator attribute
 *                       (href) XLinks will be traversed and the referenced elements
 *                       returned if possible.  The range of valid values for this
 *                       attribute consists of positive integers plus "*".
 *                       If this attribute is not specified then no xlinks shall be
 *                       resolved and the value of traverseXlinkExpiry attribute (if
 *                       it specified) may be ignored.
 *                    &lt;/xsd:documentation&gt;
 *                  &lt;/xsd:annotation&gt;
 *              &lt;/xsd:attribute&gt;
 *              &lt;xsd:attribute name="traverseXlinkExpiry"
 *                  type="xsd:positiveInteger" use="optional"&gt;
 *                  &lt;xsd:annotation&gt;
 *                      &lt;xsd:documentation&gt;
 *                       The traverseXlinkExpiry attribute value is specified in
 *                       minutes.  It indicates how long a Web Feature Service
 *                       should wait to receive a response to a nested GetGmlObject
 *                       request.
 *                       This attribute is only relevant if a value is specified
 *                       for the traverseXlinkDepth attribute.
 *                    &lt;/xsd:documentation&gt;
 *                  &lt;/xsd:annotation&gt;
 *              &lt;/xsd:attribute&gt;
 *          &lt;/xsd:extension&gt;
 *      &lt;/xsd:complexContent&gt;
 *  &lt;/xsd:complexType&gt;
 *
 *          </code>
 *         </pre>
 *
 * @generated
 */
public class GetFeatureTypeBinding extends AbstractComplexBinding {
    WfsFactory wfsfactory;

    public GetFeatureTypeBinding(WfsFactory wfsfactory) {
        this.wfsfactory = wfsfactory;
    }

    /** @generated */
    public QName getTarget() {
        return WFS.GETFEATURETYPE;
    }

    /** Sets execution mode to be before */
    public int getExecutionMode() {
        return BEFORE;
    }

    /**
     *
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated modifiable
     */
    public Class getType() {
        return GetFeatureType.class;
    }

    /**
     *
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     *
     * @generated modifiable
     */
    public Object parse(ElementInstance instance, Node node, Object value) throws Exception {
        GetFeatureType getFeature = wfsfactory.createGetFeatureType();

        // lt;xsd:element maxOccurs="unbounded" ref="wfs:Query"/&gt;
        getFeature.getQuery().addAll(node.getChildValues(QueryType.class));

        // &lt;xsd:attribute default="results" name="resultType"
        //      type="wfs:ResultTypeType" use="optional"&gt;
        if (node.hasAttribute("resultType")) {
            getFeature.setResultType((ResultTypeType) node.getAttributeValue("resultType"));
        }

        // &lt;xsd:attribute default="text/xml; subtype=gml/3.1.1"
        //		name="outputFormat" type="xsd:string" use="optional"&gt;
        if (node.hasAttribute("outputFormat")) {
            getFeature.setOutputFormat((String) node.getAttributeValue("outputFormat"));
        }

        // &lt;xsd:attribute name="maxFeatures" type="xsd:positiveInteger" use="optional"&gt;
        if (node.hasAttribute("maxFeatures")) {
            getFeature.setMaxFeatures((BigInteger) node.getAttributeValue("maxFeatures"));
        }

        // support startIndex from wfs 2.0
        if (node.hasAttribute("startIndex")) {
            // since this is not going to be defined as a type in the schema we have to manually
            // convert it since the parser won't parse it into the correct type for us
            getFeature.setStartIndex(
                    Converters.convert(node.getAttributeValue("startIndex"), BigInteger.class));
        }

        // &lt;xsd:attribute name="traverseXlinkDepth" type="xsd:string" use="optional"&gt;
        if (node.hasAttribute("traverseXlinkDepth")) {
            getFeature.setTraverseXlinkDepth((String) node.getAttributeValue("traverseXlinkDepth"));
        }

        // &lt;xsd:attribute name="traverseXlinkExpiry"
        //		type="xsd:positiveInteger" use="optional"&gt;
        if (node.hasAttribute("traverseXlinkExpiry")) {
            getFeature.setTraverseXlinkExpiry(
                    (BigInteger) node.getAttributeValue("traverseXlinkExpiry"));
        }

        // viewParams
        SqlViewParamsExtractor.viewParams(getFeature, node);

        return getFeature;
    }
}