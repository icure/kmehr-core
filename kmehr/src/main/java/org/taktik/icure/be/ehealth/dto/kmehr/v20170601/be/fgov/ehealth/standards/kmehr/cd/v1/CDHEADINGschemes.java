/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.06.14 at 03:50:09 PM CEST
//


package org.taktik.icure.be.ehealth.dto.kmehr.v20170601.be.fgov.ehealth.standards.kmehr.cd.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CD-HEADINGschemes.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CD-HEADINGschemes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CD-HEADING"/>
 *     &lt;enumeration value="CD-HEADING-LAB"/>
 *     &lt;enumeration value="CD-SITE"/>
 *     &lt;enumeration value="LOCAL"/>
 *     &lt;enumeration value="CD-HEADING-REG"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "CD-HEADINGschemes")
@XmlEnum
public enum CDHEADINGschemes {

    @XmlEnumValue("CD-HEADING")
    CD_HEADING("CD-HEADING"),
    @XmlEnumValue("CD-HEADING-LAB")
    CD_HEADING_LAB("CD-HEADING-LAB"),
    @XmlEnumValue("CD-SITE")
    CD_SITE("CD-SITE"),
    LOCAL("LOCAL"),
    @XmlEnumValue("CD-HEADING-REG")
    CD_HEADING_REG("CD-HEADING-REG");
    private final String value;

    CDHEADINGschemes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CDHEADINGschemes fromValue(String v) {
        for (CDHEADINGschemes c: CDHEADINGschemes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
