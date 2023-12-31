/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.06.14 at 03:49:00 PM CEST
//


package org.taktik.icure.services.external.rest.v1.dto.be.ehealth.kmehr.v20180601.be.fgov.ehealth.standards.kmehr.cd.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CD-PATIENTWILL-HOSPvalues.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CD-PATIENTWILL-HOSPvalues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="hos1"/>
 *     &lt;enumeration value="hos2"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "CD-PATIENTWILL-HOSPvalues")
@XmlEnum
public enum CDPATIENTWILLHOSPvalues {

    @XmlEnumValue("hos1")
    HOS_1("hos1"),
    @XmlEnumValue("hos2")
    HOS_2("hos2");
    private final String value;

    CDPATIENTWILLHOSPvalues(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CDPATIENTWILLHOSPvalues fromValue(String v) {
        for (CDPATIENTWILLHOSPvalues c: CDPATIENTWILLHOSPvalues.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
