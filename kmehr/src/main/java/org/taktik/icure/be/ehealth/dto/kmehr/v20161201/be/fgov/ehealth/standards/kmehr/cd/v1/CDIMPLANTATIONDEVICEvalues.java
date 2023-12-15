/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.06.14 at 03:49:53 PM CEST
//


package org.taktik.icure.be.ehealth.dto.kmehr.v20161201.be.fgov.ehealth.standards.kmehr.cd.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CD-IMPLANTATION-DEVICEvalues.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CD-IMPLANTATION-DEVICEvalues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="spacer"/>
 *     &lt;enumeration value="hipprosthesis"/>
 *     &lt;enumeration value="kneeprosthesis"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "CD-IMPLANTATION-DEVICEvalues")
@XmlEnum
public enum CDIMPLANTATIONDEVICEvalues {

    @XmlEnumValue("spacer")
    SPACER("spacer"),
    @XmlEnumValue("hipprosthesis")
    HIPPROSTHESIS("hipprosthesis"),
    @XmlEnumValue("kneeprosthesis")
    KNEEPROSTHESIS("kneeprosthesis");
    private final String value;

    CDIMPLANTATIONDEVICEvalues(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CDIMPLANTATIONDEVICEvalues fromValue(String v) {
        for (CDIMPLANTATIONDEVICEvalues c: CDIMPLANTATIONDEVICEvalues.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
