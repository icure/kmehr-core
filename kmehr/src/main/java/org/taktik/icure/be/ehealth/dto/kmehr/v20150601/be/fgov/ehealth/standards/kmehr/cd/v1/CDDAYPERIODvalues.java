/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.06.14 at 03:49:57 PM CEST
//


package org.taktik.icure.be.ehealth.dto.kmehr.v20150601.be.fgov.ehealth.standards.kmehr.cd.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CD-DAYPERIODvalues.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CD-DAYPERIODvalues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="afterbreakfast"/>
 *     &lt;enumeration value="afterdinner"/>
 *     &lt;enumeration value="afterlunch"/>
 *     &lt;enumeration value="aftermeal"/>
 *     &lt;enumeration value="afternoon"/>
 *     &lt;enumeration value="beforebreakfast"/>
 *     &lt;enumeration value="beforedinner"/>
 *     &lt;enumeration value="beforelunch"/>
 *     &lt;enumeration value="betweenbreakfastandlunch"/>
 *     &lt;enumeration value="betweendinnerandsleep"/>
 *     &lt;enumeration value="betweenlunchanddinner"/>
 *     &lt;enumeration value="betweenmeals"/>
 *     &lt;enumeration value="evening"/>
 *     &lt;enumeration value="morning"/>
 *     &lt;enumeration value="night"/>
 *     &lt;enumeration value="thehourofsleep"/>
 *     &lt;enumeration value="duringbreakfast"/>
 *     &lt;enumeration value="duringlunch"/>
 *     &lt;enumeration value="duringdinner"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "CD-DAYPERIODvalues")
@XmlEnum
public enum CDDAYPERIODvalues {

    @XmlEnumValue("afterbreakfast")
    AFTERBREAKFAST("afterbreakfast"),
    @XmlEnumValue("afterdinner")
    AFTERDINNER("afterdinner"),
    @XmlEnumValue("afterlunch")
    AFTERLUNCH("afterlunch"),
    @XmlEnumValue("aftermeal")
    AFTERMEAL("aftermeal"),
    @XmlEnumValue("afternoon")
    AFTERNOON("afternoon"),
    @XmlEnumValue("beforebreakfast")
    BEFOREBREAKFAST("beforebreakfast"),
    @XmlEnumValue("beforedinner")
    BEFOREDINNER("beforedinner"),
    @XmlEnumValue("beforelunch")
    BEFORELUNCH("beforelunch"),
    @XmlEnumValue("betweenbreakfastandlunch")
    BETWEENBREAKFASTANDLUNCH("betweenbreakfastandlunch"),
    @XmlEnumValue("betweendinnerandsleep")
    BETWEENDINNERANDSLEEP("betweendinnerandsleep"),
    @XmlEnumValue("betweenlunchanddinner")
    BETWEENLUNCHANDDINNER("betweenlunchanddinner"),
    @XmlEnumValue("betweenmeals")
    BETWEENMEALS("betweenmeals"),
    @XmlEnumValue("evening")
    EVENING("evening"),
    @XmlEnumValue("morning")
    MORNING("morning"),
    @XmlEnumValue("night")
    NIGHT("night"),
    @XmlEnumValue("thehourofsleep")
    THEHOUROFSLEEP("thehourofsleep"),
    @XmlEnumValue("duringbreakfast")
    DURINGBREAKFAST("duringbreakfast"),
    @XmlEnumValue("duringlunch")
    DURINGLUNCH("duringlunch"),
    @XmlEnumValue("duringdinner")
    DURINGDINNER("duringdinner");
    private final String value;

    CDDAYPERIODvalues(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CDDAYPERIODvalues fromValue(String v) {
        for (CDDAYPERIODvalues c: CDDAYPERIODvalues.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
