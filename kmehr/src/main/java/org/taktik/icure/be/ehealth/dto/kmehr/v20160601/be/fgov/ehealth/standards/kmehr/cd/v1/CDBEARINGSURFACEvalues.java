/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.06.14 at 03:50:05 PM CEST
//


package org.taktik.icure.be.ehealth.dto.kmehr.v20160601.be.fgov.ehealth.standards.kmehr.cd.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CD-BEARING-SURFACEvalues.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CD-BEARING-SURFACEvalues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="metalpoly"/>
 *     &lt;enumeration value="cerampoly"/>
 *     &lt;enumeration value="metalmetal"/>
 *     &lt;enumeration value="ceramceram"/>
 *     &lt;enumeration value="other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "CD-BEARING-SURFACEvalues")
@XmlEnum
public enum CDBEARINGSURFACEvalues {

    @XmlEnumValue("metalpoly")
    METALPOLY("metalpoly"),
    @XmlEnumValue("cerampoly")
    CERAMPOLY("cerampoly"),
    @XmlEnumValue("metalmetal")
    METALMETAL("metalmetal"),
    @XmlEnumValue("ceramceram")
    CERAMCERAM("ceramceram"),
    @XmlEnumValue("other")
    OTHER("other");
    private final String value;

    CDBEARINGSURFACEvalues(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CDBEARINGSURFACEvalues fromValue(String v) {
        for (CDBEARINGSURFACEvalues c: CDBEARINGSURFACEvalues.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}