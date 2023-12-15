/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.06.14 at 03:48:48 PM CEST
//


package org.taktik.icure.be.ehealth.dto.kmehr.v20120701.be.fgov.ehealth.standards.kmehr.cd.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CD-ORTHO-APPROACHvalues.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CD-ORTHO-APPROACHvalues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="lateral"/>
 *     &lt;enumeration value="posterior"/>
 *     &lt;enumeration value="anterior"/>
 *     &lt;enumeration value="bytrochanterotomy"/>
 *     &lt;enumeration value="withfemoralosteotomy"/>
 *     &lt;enumeration value="other"/>
 *     &lt;enumeration value="subvastus"/>
 *     &lt;enumeration value="midvastus"/>
 *     &lt;enumeration value="parapatellarlateral"/>
 *     &lt;enumeration value="parapatellarmedial"/>
 *     &lt;enumeration value="tuberositasosteotomie"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "CD-ORTHO-APPROACHvalues")
@XmlEnum
public enum CDORTHOAPPROACHvalues {

    @XmlEnumValue("lateral")
    LATERAL("lateral"),
    @XmlEnumValue("posterior")
    POSTERIOR("posterior"),
    @XmlEnumValue("anterior")
    ANTERIOR("anterior"),
    @XmlEnumValue("bytrochanterotomy")
    BYTROCHANTEROTOMY("bytrochanterotomy"),
    @XmlEnumValue("withfemoralosteotomy")
    WITHFEMORALOSTEOTOMY("withfemoralosteotomy"),
    @XmlEnumValue("other")
    OTHER("other"),
    @XmlEnumValue("subvastus")
    SUBVASTUS("subvastus"),
    @XmlEnumValue("midvastus")
    MIDVASTUS("midvastus"),
    @XmlEnumValue("parapatellarlateral")
    PARAPATELLARLATERAL("parapatellarlateral"),
    @XmlEnumValue("parapatellarmedial")
    PARAPATELLARMEDIAL("parapatellarmedial"),
    @XmlEnumValue("tuberositasosteotomie")
    TUBEROSITASOSTEOTOMIE("tuberositasosteotomie");
    private final String value;

    CDORTHOAPPROACHvalues(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CDORTHOAPPROACHvalues fromValue(String v) {
        for (CDORTHOAPPROACHvalues c: CDORTHOAPPROACHvalues.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
