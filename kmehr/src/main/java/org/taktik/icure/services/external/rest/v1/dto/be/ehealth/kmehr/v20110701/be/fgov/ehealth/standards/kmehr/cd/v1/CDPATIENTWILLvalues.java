/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.06.14 at 03:48:57 PM CEST
//


package org.taktik.icure.services.external.rest.v1.dto.be.ehealth.kmehr.v20110701.be.fgov.ehealth.standards.kmehr.cd.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CD-PATIENTWILLvalues.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CD-PATIENTWILLvalues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ntbr"/>
 *     &lt;enumeration value="bloodtransfusionrefusal"/>
 *     &lt;enumeration value="intubationrefusal"/>
 *     &lt;enumeration value="euthanasiarequest"/>
 *     &lt;enumeration value="vaccinationrefusal"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "CD-PATIENTWILLvalues")
@XmlEnum
public enum CDPATIENTWILLvalues {

    @XmlEnumValue("ntbr")
    NTBR("ntbr"),
    @XmlEnumValue("bloodtransfusionrefusal")
    BLOODTRANSFUSIONREFUSAL("bloodtransfusionrefusal"),
    @XmlEnumValue("intubationrefusal")
    INTUBATIONREFUSAL("intubationrefusal"),
    @XmlEnumValue("euthanasiarequest")
    EUTHANASIAREQUEST("euthanasiarequest"),
    @XmlEnumValue("vaccinationrefusal")
    VACCINATIONREFUSAL("vaccinationrefusal");
    private final String value;

    CDPATIENTWILLvalues(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CDPATIENTWILLvalues fromValue(String v) {
        for (CDPATIENTWILLvalues c: CDPATIENTWILLvalues.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
