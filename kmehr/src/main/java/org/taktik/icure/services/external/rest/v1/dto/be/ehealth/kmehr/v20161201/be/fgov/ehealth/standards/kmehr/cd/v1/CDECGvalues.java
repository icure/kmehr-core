/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.06.14 at 03:49:54 PM CEST
//


package org.taktik.icure.services.external.rest.v1.dto.be.ehealth.kmehr.v20161201.be.fgov.ehealth.standards.kmehr.cd.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CD-ECGvalues.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CD-ECGvalues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="VR"/>
 *     &lt;enumeration value="AR"/>
 *     &lt;enumeration value="PR"/>
 *     &lt;enumeration value="QRS"/>
 *     &lt;enumeration value="QT"/>
 *     &lt;enumeration value="QTc"/>
 *     &lt;enumeration value="P"/>
 *     &lt;enumeration value="R"/>
 *     &lt;enumeration value="T"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "CD-ECGvalues")
@XmlEnum
public enum CDECGvalues {

    VR("VR"),
    AR("AR"),
    PR("PR"),
    QRS("QRS"),
    QT("QT"),
    @XmlEnumValue("QTc")
    Q_TC("QTc"),
    P("P"),
    R("R"),
    T("T");
    private final String value;

    CDECGvalues(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CDECGvalues fromValue(String v) {
        for (CDECGvalues c: CDECGvalues.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
