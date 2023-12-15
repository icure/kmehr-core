/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.06.14 at 03:49:37 PM CEST
//


package org.taktik.icure.be.ehealth.dto.kmehr.v20180301.be.fgov.ehealth.standards.kmehr.cd.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CD-SUBSTANCEschemes.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CD-SUBSTANCEschemes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CD-INNCLUSTER"/>
 *     &lt;enumeration value="CD-ATC"/>
 *     &lt;enumeration value="CD-EAN"/>
 *     &lt;enumeration value="CD-SUBSTANCE-CNK"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "CD-SUBSTANCEschemes")
@XmlEnum
public enum CDSUBSTANCEschemes {

    @XmlEnumValue("CD-INNCLUSTER")
    CD_INNCLUSTER("CD-INNCLUSTER"),
    @XmlEnumValue("CD-ATC")
    CD_ATC("CD-ATC"),
    @XmlEnumValue("CD-EAN")
    CD_EAN("CD-EAN"),
    @XmlEnumValue("CD-SUBSTANCE-CNK")
    CD_SUBSTANCE_CNK("CD-SUBSTANCE-CNK");
    private final String value;

    CDSUBSTANCEschemes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CDSUBSTANCEschemes fromValue(String v) {
        for (CDSUBSTANCEschemes c: CDSUBSTANCEschemes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
