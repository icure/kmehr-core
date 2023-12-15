/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.06.14 at 03:48:36 PM CEST
//


package org.taktik.icure.be.ehealth.dto.kmehr.v20131001.be.fgov.ehealth.standards.kmehr.cd.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CD-TUCO-PATHOLOGYTYPEvalues.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CD-TUCO-PATHOLOGYTYPEvalues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="diabetedietarycontrol"/>
 *     &lt;enumeration value="diabeteoralmedication"/>
 *     &lt;enumeration value="diabeteinsulin"/>
 *     &lt;enumeration value="diabetenewlydiagnosed"/>
 *     &lt;enumeration value="diabete"/>
 *     &lt;enumeration value="renalfailurelessthan30ml"/>
 *     &lt;enumeration value="instentrestenosis"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "CD-TUCO-PATHOLOGYTYPEvalues")
@XmlEnum
public enum CDTUCOPATHOLOGYTYPEvalues {

    @XmlEnumValue("diabetedietarycontrol")
    DIABETEDIETARYCONTROL("diabetedietarycontrol"),
    @XmlEnumValue("diabeteoralmedication")
    DIABETEORALMEDICATION("diabeteoralmedication"),
    @XmlEnumValue("diabeteinsulin")
    DIABETEINSULIN("diabeteinsulin"),
    @XmlEnumValue("diabetenewlydiagnosed")
    DIABETENEWLYDIAGNOSED("diabetenewlydiagnosed"),
    @XmlEnumValue("diabete")
    DIABETE("diabete"),
    @XmlEnumValue("renalfailurelessthan30ml")
    RENALFAILURELESSTHAN_30_ML("renalfailurelessthan30ml"),
    @XmlEnumValue("instentrestenosis")
    INSTENTRESTENOSIS("instentrestenosis");
    private final String value;

    CDTUCOPATHOLOGYTYPEvalues(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CDTUCOPATHOLOGYTYPEvalues fromValue(String v) {
        for (CDTUCOPATHOLOGYTYPEvalues c: CDTUCOPATHOLOGYTYPEvalues.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
