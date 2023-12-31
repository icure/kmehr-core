/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.06.14 at 03:48:44 PM CEST
//


package org.taktik.icure.be.ehealth.dto.kmehr.v20121001.be.fgov.ehealth.standards.kmehr.cd.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CD-PROOFvalues.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CD-PROOFvalues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="eidreading"/>
 *     &lt;enumeration value="sisreading"/>
 *     &lt;enumeration value="eidsigning"/>
 *     &lt;enumeration value="authenticsource"/>
 *     &lt;enumeration value="patientmanagement"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "CD-PROOFvalues")
@XmlEnum
public enum CDPROOFvalues {

    @XmlEnumValue("eidreading")
    EIDREADING("eidreading"),
    @XmlEnumValue("sisreading")
    SISREADING("sisreading"),
    @XmlEnumValue("eidsigning")
    EIDSIGNING("eidsigning"),
    @XmlEnumValue("authenticsource")
    AUTHENTICSOURCE("authenticsource"),
    @XmlEnumValue("patientmanagement")
    PATIENTMANAGEMENT("patientmanagement");
    private final String value;

    CDPROOFvalues(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CDPROOFvalues fromValue(String v) {
        for (CDPROOFvalues c: CDPROOFvalues.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
