/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.05.22 at 08:11:32 PM CEST
//


package org.taktik.icure.be.ehealth.samws.v2.refdata;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UnitTypeType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UnitTypeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="QUANTITY"/>
 *     &lt;enumeration value="STRENGTH"/>
 *     &lt;enumeration value="CODE"/>
 *     &lt;enumeration value="BOOLEAN"/>
 *     &lt;enumeration value="AMP_CODE"/>
 *     &lt;enumeration value="CTI_EXTENDED"/>
 *     &lt;enumeration value="ATC_CODE"/>
 *     &lt;enumeration value="LEGAL_REFERENCE_PATH"/>
 *     &lt;enumeration value="LEGAL_TEXT_PATH"/>
 *     &lt;enumeration value="REIMBURSEMENT_CRITERION_KEY"/>
 *     &lt;enumeration value="VMP_CODE"/>
 *     &lt;enumeration value="SUBSTANCE_CODE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "UnitTypeType")
@XmlEnum
public enum UnitTypeType {

    QUANTITY,
    STRENGTH,
    CODE,
    BOOLEAN,
    AMP_CODE,
    CTI_EXTENDED,
    ATC_CODE,
    LEGAL_REFERENCE_PATH,
    LEGAL_TEXT_PATH,
    REIMBURSEMENT_CRITERION_KEY,
    VMP_CODE,
    SUBSTANCE_CODE;

    public String value() {
        return name();
    }

    public static UnitTypeType fromValue(String v) {
        return valueOf(v);
    }

}
