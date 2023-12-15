/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.06.14 at 03:49:25 PM CEST
//


package org.taktik.icure.be.ehealth.dto.kmehr.v20150901.be.fgov.ehealth.standards.kmehr.cd.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CD-EBIRTH-ARTIFICIALRESPIRATIONTYPEvalues.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CD-EBIRTH-ARTIFICIALRESPIRATIONTYPEvalues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="intubation"/>
 *     &lt;enumeration value="balloon-mask"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "CD-EBIRTH-ARTIFICIALRESPIRATIONTYPEvalues")
@XmlEnum
public enum CDEBIRTHARTIFICIALRESPIRATIONTYPEvalues {

    @XmlEnumValue("intubation")
    INTUBATION("intubation"),
    @XmlEnumValue("balloon-mask")
    BALLOON_MASK("balloon-mask");
    private final String value;

    CDEBIRTHARTIFICIALRESPIRATIONTYPEvalues(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CDEBIRTHARTIFICIALRESPIRATIONTYPEvalues fromValue(String v) {
        for (CDEBIRTHARTIFICIALRESPIRATIONTYPEvalues c: CDEBIRTHARTIFICIALRESPIRATIONTYPEvalues.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
