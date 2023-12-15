/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.06.14 at 03:49:26 PM CEST
//


package org.taktik.icure.services.external.rest.v1.dto.be.ehealth.kmehr.v20150901.be.fgov.ehealth.standards.kmehr.cd.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CD-ENCOUNTERvalues.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CD-ENCOUNTERvalues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="homevisit"/>
 *     &lt;enumeration value="consultation"/>
 *     &lt;enumeration value="telephonicconsultation"/>
 *     &lt;enumeration value="emergency"/>
 *     &lt;enumeration value="hospital"/>
 *     &lt;enumeration value="oneday"/>
 *     &lt;enumeration value="technical"/>
 *     &lt;enumeration value="resthomevisit"/>
 *     &lt;enumeration value="consult"/>
 *     &lt;enumeration value="multidisciplinaryconsult"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "CD-ENCOUNTERvalues")
@XmlEnum
public enum CDENCOUNTERvalues {

    @XmlEnumValue("homevisit")
    HOMEVISIT("homevisit"),
    @XmlEnumValue("consultation")
    CONSULTATION("consultation"),
    @XmlEnumValue("telephonicconsultation")
    TELEPHONICCONSULTATION("telephonicconsultation"),
    @XmlEnumValue("emergency")
    EMERGENCY("emergency"),
    @XmlEnumValue("hospital")
    HOSPITAL("hospital"),
    @XmlEnumValue("oneday")
    ONEDAY("oneday"),
    @XmlEnumValue("technical")
    TECHNICAL("technical"),
    @XmlEnumValue("resthomevisit")
    RESTHOMEVISIT("resthomevisit"),
    @XmlEnumValue("consult")
    CONSULT("consult"),
    @XmlEnumValue("multidisciplinaryconsult")
    MULTIDISCIPLINARYCONSULT("multidisciplinaryconsult");
    private final String value;

    CDENCOUNTERvalues(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CDENCOUNTERvalues fromValue(String v) {
        for (CDENCOUNTERvalues c: CDENCOUNTERvalues.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
