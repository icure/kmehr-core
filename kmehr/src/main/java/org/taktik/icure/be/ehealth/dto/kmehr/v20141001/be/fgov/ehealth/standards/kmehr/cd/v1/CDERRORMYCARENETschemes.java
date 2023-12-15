/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.06.14 at 03:48:32 PM CEST
//


package org.taktik.icure.be.ehealth.dto.kmehr.v20141001.be.fgov.ehealth.standards.kmehr.cd.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CD-ERROR-MYCARENETschemes.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CD-ERROR-MYCARENETschemes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CD-ERROR"/>
 *     &lt;enumeration value="CD-REFUSAL-MYCARENET"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "CD-ERROR-MYCARENETschemes")
@XmlEnum
public enum CDERRORMYCARENETschemes {

    @XmlEnumValue("CD-ERROR")
    CD_ERROR("CD-ERROR"),
    @XmlEnumValue("CD-REFUSAL-MYCARENET")
    CD_REFUSAL_MYCARENET("CD-REFUSAL-MYCARENET");
    private final String value;

    CDERRORMYCARENETschemes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CDERRORMYCARENETschemes fromValue(String v) {
        for (CDERRORMYCARENETschemes c: CDERRORMYCARENETschemes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
