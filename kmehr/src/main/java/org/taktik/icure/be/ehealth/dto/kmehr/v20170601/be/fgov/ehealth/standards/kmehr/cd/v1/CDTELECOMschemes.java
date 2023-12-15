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
 * <p>Java class for CD-TELECOMschemes.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CD-TELECOMschemes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CD-ADDRESS"/>
 *     &lt;enumeration value="CD-TELECOM"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "CD-TELECOMschemes")
@XmlEnum
public enum CDTELECOMschemes {

    @XmlEnumValue("CD-ADDRESS")
    CD_ADDRESS("CD-ADDRESS", "1.0"),
    @XmlEnumValue("CD-TELECOM")
    CD_TELECOM("CD-TELECOM", "1.0");
    private final String value; //
    private final String version;
    CDTELECOMschemes(String v, String vs) {
        value = v;
        version = vs;
    }

    public String value() {
        return value;
    } //

    public String version() {
        return version;
    }

    public static CDTELECOMschemes fromValue(String v) {
        for (CDTELECOMschemes c: CDTELECOMschemes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
