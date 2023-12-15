/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.06.14 at 03:48:28 PM CEST
//


package org.taktik.icure.be.ehealth.dto.kmehr.v20120401.be.fgov.ehealth.standards.kmehr.cd.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CD-ORTHO-TECHREVISIONvalues.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CD-ORTHO-TECHREVISIONvalues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="femoralheadneck"/>
 *     &lt;enumeration value="femoralcomplete"/>
 *     &lt;enumeration value="acetabularinsert"/>
 *     &lt;enumeration value="acetabularcomplete"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 */
@XmlType(name = "CD-ORTHO-TECHREVISIONvalues")
@XmlEnum
public enum CDORTHOTECHREVISIONvalues {

    @XmlEnumValue("femoralheadneck")
    FEMORALHEADNECK("femoralheadneck"),
    @XmlEnumValue("femoralcomplete")
    FEMORALCOMPLETE("femoralcomplete"),
    @XmlEnumValue("acetabularinsert")
    ACETABULARINSERT("acetabularinsert"),
    @XmlEnumValue("acetabularcomplete")
    ACETABULARCOMPLETE("acetabularcomplete");
    private final String value;

    CDORTHOTECHREVISIONvalues(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CDORTHOTECHREVISIONvalues fromValue(String v) {
        for (CDORTHOTECHREVISIONvalues c : CDORTHOTECHREVISIONvalues.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
