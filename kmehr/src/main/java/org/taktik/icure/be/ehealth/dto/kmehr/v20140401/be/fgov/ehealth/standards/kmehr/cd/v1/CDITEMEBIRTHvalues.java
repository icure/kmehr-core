/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.06.14 at 03:48:40 PM CEST
//


package org.taktik.icure.be.ehealth.dto.kmehr.v20140401.be.fgov.ehealth.standards.kmehr.cd.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CD-ITEM-EBIRTHvalues.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CD-ITEM-EBIRTHvalues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="multiparity"/>
 *     &lt;enumeration value="samesex"/>
 *     &lt;enumeration value="stillborn"/>
 *     &lt;enumeration value="birthplace"/>
 *     &lt;enumeration value="birthrank"/>
 *     &lt;enumeration value="partusnumber"/>
 *     &lt;enumeration value="beforepregnancyweight"/>
 *     &lt;enumeration value="atdeliveryweight"/>
 *     &lt;enumeration value="height"/>
 *     &lt;enumeration value="previouschildbirth"/>
 *     &lt;enumeration value="previousbornalive"/>
 *     &lt;enumeration value="lastbabybirthdate"/>
 *     &lt;enumeration value="intermediatestillborndelivery"/>
 *     &lt;enumeration value="previouscaesarean"/>
 *     &lt;enumeration value="parity"/>
 *     &lt;enumeration value="pregnancyorigin"/>
 *     &lt;enumeration value="hypertensiondiagnose"/>
 *     &lt;enumeration value="diabetesdiagnose"/>
 *     &lt;enumeration value="HIVdiagnose"/>
 *     &lt;enumeration value="pregnancyduration"/>
 *     &lt;enumeration value="childposition"/>
 *     &lt;enumeration value="inductiondelivery"/>
 *     &lt;enumeration value="epiduralanalgesia"/>
 *     &lt;enumeration value="rachianalagesia"/>
 *     &lt;enumeration value="foetalmonitoring"/>
 *     &lt;enumeration value="streptococcusbcolonization"/>
 *     &lt;enumeration value="intrapartalsbgprophylaxis"/>
 *     &lt;enumeration value="deliveryway"/>
 *     &lt;enumeration value="episiotomy"/>
 *     &lt;enumeration value="caesareanindication"/>
 *     &lt;enumeration value="breastfeeding"/>
 *     &lt;enumeration value="atbirthweight"/>
 *     &lt;enumeration value="apgarscore1"/>
 *     &lt;enumeration value="apgarscore5"/>
 *     &lt;enumeration value="artificialrespiration"/>
 *     &lt;enumeration value="neonataldept"/>
 *     &lt;enumeration value="congenitalmalformation"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "CD-ITEM-EBIRTHvalues")
@XmlEnum
public enum CDITEMEBIRTHvalues {

    @XmlEnumValue("multiparity")
    MULTIPARITY("multiparity"),
    @XmlEnumValue("samesex")
    SAMESEX("samesex"),
    @XmlEnumValue("stillborn")
    STILLBORN("stillborn"),
    @XmlEnumValue("birthplace")
    BIRTHPLACE("birthplace"),
    @XmlEnumValue("birthrank")
    BIRTHRANK("birthrank"),
    @XmlEnumValue("partusnumber")
    PARTUSNUMBER("partusnumber"),
    @XmlEnumValue("beforepregnancyweight")
    BEFOREPREGNANCYWEIGHT("beforepregnancyweight"),
    @XmlEnumValue("atdeliveryweight")
    ATDELIVERYWEIGHT("atdeliveryweight"),
    @XmlEnumValue("height")
    HEIGHT("height"),
    @XmlEnumValue("previouschildbirth")
    PREVIOUSCHILDBIRTH("previouschildbirth"),
    @XmlEnumValue("previousbornalive")
    PREVIOUSBORNALIVE("previousbornalive"),
    @XmlEnumValue("lastbabybirthdate")
    LASTBABYBIRTHDATE("lastbabybirthdate"),
    @XmlEnumValue("intermediatestillborndelivery")
    INTERMEDIATESTILLBORNDELIVERY("intermediatestillborndelivery"),
    @XmlEnumValue("previouscaesarean")
    PREVIOUSCAESAREAN("previouscaesarean"),
    @XmlEnumValue("parity")
    PARITY("parity"),
    @XmlEnumValue("pregnancyorigin")
    PREGNANCYORIGIN("pregnancyorigin"),
    @XmlEnumValue("hypertensiondiagnose")
    HYPERTENSIONDIAGNOSE("hypertensiondiagnose"),
    @XmlEnumValue("diabetesdiagnose")
    DIABETESDIAGNOSE("diabetesdiagnose"),
    @XmlEnumValue("HIVdiagnose")
    HI_VDIAGNOSE("HIVdiagnose"),
    @XmlEnumValue("pregnancyduration")
    PREGNANCYDURATION("pregnancyduration"),
    @XmlEnumValue("childposition")
    CHILDPOSITION("childposition"),
    @XmlEnumValue("inductiondelivery")
    INDUCTIONDELIVERY("inductiondelivery"),
    @XmlEnumValue("epiduralanalgesia")
    EPIDURALANALGESIA("epiduralanalgesia"),
    @XmlEnumValue("rachianalagesia")
    RACHIANALAGESIA("rachianalagesia"),
    @XmlEnumValue("foetalmonitoring")
    FOETALMONITORING("foetalmonitoring"),
    @XmlEnumValue("streptococcusbcolonization")
    STREPTOCOCCUSBCOLONIZATION("streptococcusbcolonization"),
    @XmlEnumValue("intrapartalsbgprophylaxis")
    INTRAPARTALSBGPROPHYLAXIS("intrapartalsbgprophylaxis"),
    @XmlEnumValue("deliveryway")
    DELIVERYWAY("deliveryway"),
    @XmlEnumValue("episiotomy")
    EPISIOTOMY("episiotomy"),
    @XmlEnumValue("caesareanindication")
    CAESAREANINDICATION("caesareanindication"),
    @XmlEnumValue("breastfeeding")
    BREASTFEEDING("breastfeeding"),
    @XmlEnumValue("atbirthweight")
    ATBIRTHWEIGHT("atbirthweight"),
    @XmlEnumValue("apgarscore1")
    APGARSCORE_1("apgarscore1"),
    @XmlEnumValue("apgarscore5")
    APGARSCORE_5("apgarscore5"),
    @XmlEnumValue("artificialrespiration")
    ARTIFICIALRESPIRATION("artificialrespiration"),
    @XmlEnumValue("neonataldept")
    NEONATALDEPT("neonataldept"),
    @XmlEnumValue("congenitalmalformation")
    CONGENITALMALFORMATION("congenitalmalformation");
    private final String value;

    CDITEMEBIRTHvalues(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CDITEMEBIRTHvalues fromValue(String v) {
        for (CDITEMEBIRTHvalues c: CDITEMEBIRTHvalues.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
