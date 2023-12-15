/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.06.14 at 03:49:50 PM CEST
//


package org.taktik.icure.services.external.rest.v1.dto.be.ehealth.kmehr.v20100601.be.fgov.ehealth.standards.kmehr.cd.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CD-EBIRTH-PREGNANCYORIGINvalues.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CD-EBIRTH-PREGNANCYORIGINvalues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="spontaneous"/>
 *     &lt;enumeration value="hormonal"/>
 *     &lt;enumeration value="IVF"/>
 *     &lt;enumeration value="ICSI"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "CD-EBIRTH-PREGNANCYORIGINvalues")
@XmlEnum
public enum CDEBIRTHPREGNANCYORIGINvalues {

    @XmlEnumValue("spontaneous")
    SPONTANEOUS("spontaneous"),
    @XmlEnumValue("hormonal")
    HORMONAL("hormonal"),
    IVF("IVF"),
    ICSI("ICSI");
    private final String value;

    CDEBIRTHPREGNANCYORIGINvalues(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CDEBIRTHPREGNANCYORIGINvalues fromValue(String v) {
        for (CDEBIRTHPREGNANCYORIGINvalues c: CDEBIRTHPREGNANCYORIGINvalues.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
