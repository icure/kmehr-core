/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.06.14 at 03:50:06 PM CEST
//


package org.taktik.icure.services.external.rest.v1.dto.be.ehealth.kmehr.v20160601.be.fgov.ehealth.standards.kmehr.cd.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CD-INCAPACITYvalues.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CD-INCAPACITYvalues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="work"/>
 *     &lt;enumeration value="swim"/>
 *     &lt;enumeration value="sport"/>
 *     &lt;enumeration value="school"/>
 *     &lt;enumeration value="schoolsports"/>
 *     &lt;enumeration value="travel"/>
 *     &lt;enumeration value="vote"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "CD-INCAPACITYvalues")
@XmlEnum
public enum CDINCAPACITYvalues {

    @XmlEnumValue("work")
    WORK("work"),
    @XmlEnumValue("swim")
    SWIM("swim"),
    @XmlEnumValue("sport")
    SPORT("sport"),
    @XmlEnumValue("school")
    SCHOOL("school"),
    @XmlEnumValue("schoolsports")
    SCHOOLSPORTS("schoolsports"),
    @XmlEnumValue("travel")
    TRAVEL("travel"),
    @XmlEnumValue("vote")
    VOTE("vote");
    private final String value;

    CDINCAPACITYvalues(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CDINCAPACITYvalues fromValue(String v) {
        for (CDINCAPACITYvalues c: CDINCAPACITYvalues.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
