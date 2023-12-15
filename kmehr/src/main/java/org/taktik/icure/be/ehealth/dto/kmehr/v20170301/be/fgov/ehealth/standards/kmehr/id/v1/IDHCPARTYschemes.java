/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.06.14 at 03:49:07 PM CEST
//


package org.taktik.icure.be.ehealth.dto.kmehr.v20170301.be.fgov.ehealth.standards.kmehr.id.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ID-HCPARTYschemes.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ID-HCPARTYschemes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ID-HCPARTY"/>
 *     &lt;enumeration value="INSS"/>
 *     &lt;enumeration value="LOCAL"/>
 *     &lt;enumeration value="ID-ENCRYPTION-APPLICATION"/>
 *     &lt;enumeration value="ID-ENCRYPTION-ACTOR"/>
 *     &lt;enumeration value="ID-INSURANCE"/>
 *     &lt;enumeration value="ID-CBE"/>
 *     &lt;enumeration value="ID-EHP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "ID-HCPARTYschemes")
@XmlEnum
public enum IDHCPARTYschemes {

    @XmlEnumValue("ID-HCPARTY")
    ID_HCPARTY("ID-HCPARTY"),
    INSS("INSS"),
    LOCAL("LOCAL"),
    @XmlEnumValue("ID-ENCRYPTION-APPLICATION")
    ID_ENCRYPTION_APPLICATION("ID-ENCRYPTION-APPLICATION"),
    @XmlEnumValue("ID-ENCRYPTION-ACTOR")
    ID_ENCRYPTION_ACTOR("ID-ENCRYPTION-ACTOR"),
    @XmlEnumValue("ID-INSURANCE")
    ID_INSURANCE("ID-INSURANCE"),
    @XmlEnumValue("ID-CBE")
    ID_CBE("ID-CBE"),
    @XmlEnumValue("ID-EHP")
    ID_EHP("ID-EHP");
    private final String value;

    IDHCPARTYschemes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static IDHCPARTYschemes fromValue(String v) {
        for (IDHCPARTYschemes c: IDHCPARTYschemes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
