/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.06.14 at 03:48:48 PM CEST
//


package org.taktik.icure.be.ehealth.dto.kmehr.v20120701.be.fgov.ehealth.standards.kmehr.cd.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CD-EBIRTH-CONGENITALMALFORMATIONvalues.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CD-EBIRTH-CONGENITALMALFORMATIONvalues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="anencephalia"/>
 *     &lt;enumeration value="spinabifida"/>
 *     &lt;enumeration value="hydrocephalia"/>
 *     &lt;enumeration value="splitlippalate"/>
 *     &lt;enumeration value="analatresia"/>
 *     &lt;enumeration value="membersreduction"/>
 *     &lt;enumeration value="diaphragmatichernia"/>
 *     &lt;enumeration value="omphalocele"/>
 *     &lt;enumeration value="gastroschisis"/>
 *     &lt;enumeration value="transpositiegrotevaten"/>
 *     &lt;enumeration value="afwijkinglong"/>
 *     &lt;enumeration value="atresiedundarm"/>
 *     &lt;enumeration value="nieragenese"/>
 *     &lt;enumeration value="craniosynostosis"/>
 *     &lt;enumeration value="turnersyndrom"/>
 *     &lt;enumeration value="obstructievedefecten"/>
 *     &lt;enumeration value="tetralogiefallot"/>
 *     &lt;enumeration value="oesofagaleatresie"/>
 *     &lt;enumeration value="atresieanus"/>
 *     &lt;enumeration value="twintotwintransfusionsyndrome"/>
 *     &lt;enumeration value="skeletdysplasie"/>
 *     &lt;enumeration value="hydropsfoetalis"/>
 *     &lt;enumeration value="polymultikystischenierdysplasie"/>
 *     &lt;enumeration value="VSD"/>
 *     &lt;enumeration value="atresiegalwegen"/>
 *     &lt;enumeration value="hypospadias"/>
 *     &lt;enumeration value="cystischhygroma"/>
 *     &lt;enumeration value="trisomie21"/>
 *     &lt;enumeration value="trisomie18"/>
 *     &lt;enumeration value="trisomie13"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "CD-EBIRTH-CONGENITALMALFORMATIONvalues")
@XmlEnum
public enum CDEBIRTHCONGENITALMALFORMATIONvalues {

    @XmlEnumValue("anencephalia")
    ANENCEPHALIA("anencephalia"),
    @XmlEnumValue("spinabifida")
    SPINABIFIDA("spinabifida"),
    @XmlEnumValue("hydrocephalia")
    HYDROCEPHALIA("hydrocephalia"),
    @XmlEnumValue("splitlippalate")
    SPLITLIPPALATE("splitlippalate"),
    @XmlEnumValue("analatresia")
    ANALATRESIA("analatresia"),
    @XmlEnumValue("membersreduction")
    MEMBERSREDUCTION("membersreduction"),
    @XmlEnumValue("diaphragmatichernia")
    DIAPHRAGMATICHERNIA("diaphragmatichernia"),
    @XmlEnumValue("omphalocele")
    OMPHALOCELE("omphalocele"),
    @XmlEnumValue("gastroschisis")
    GASTROSCHISIS("gastroschisis"),
    @XmlEnumValue("transpositiegrotevaten")
    TRANSPOSITIEGROTEVATEN("transpositiegrotevaten"),
    @XmlEnumValue("afwijkinglong")
    AFWIJKINGLONG("afwijkinglong"),
    @XmlEnumValue("atresiedundarm")
    ATRESIEDUNDARM("atresiedundarm"),
    @XmlEnumValue("nieragenese")
    NIERAGENESE("nieragenese"),
    @XmlEnumValue("craniosynostosis")
    CRANIOSYNOSTOSIS("craniosynostosis"),
    @XmlEnumValue("turnersyndrom")
    TURNERSYNDROM("turnersyndrom"),
    @XmlEnumValue("obstructievedefecten")
    OBSTRUCTIEVEDEFECTEN("obstructievedefecten"),
    @XmlEnumValue("tetralogiefallot")
    TETRALOGIEFALLOT("tetralogiefallot"),
    @XmlEnumValue("oesofagaleatresie")
    OESOFAGALEATRESIE("oesofagaleatresie"),
    @XmlEnumValue("atresieanus")
    ATRESIEANUS("atresieanus"),
    @XmlEnumValue("twintotwintransfusionsyndrome")
    TWINTOTWINTRANSFUSIONSYNDROME("twintotwintransfusionsyndrome"),
    @XmlEnumValue("skeletdysplasie")
    SKELETDYSPLASIE("skeletdysplasie"),
    @XmlEnumValue("hydropsfoetalis")
    HYDROPSFOETALIS("hydropsfoetalis"),
    @XmlEnumValue("polymultikystischenierdysplasie")
    POLYMULTIKYSTISCHENIERDYSPLASIE("polymultikystischenierdysplasie"),
    VSD("VSD"),
    @XmlEnumValue("atresiegalwegen")
    ATRESIEGALWEGEN("atresiegalwegen"),
    @XmlEnumValue("hypospadias")
    HYPOSPADIAS("hypospadias"),
    @XmlEnumValue("cystischhygroma")
    CYSTISCHHYGROMA("cystischhygroma"),
    @XmlEnumValue("trisomie21")
    TRISOMIE_21("trisomie21"),
    @XmlEnumValue("trisomie18")
    TRISOMIE_18("trisomie18"),
    @XmlEnumValue("trisomie13")
    TRISOMIE_13("trisomie13");
    private final String value;

    CDEBIRTHCONGENITALMALFORMATIONvalues(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CDEBIRTHCONGENITALMALFORMATIONvalues fromValue(String v) {
        for (CDEBIRTHCONGENITALMALFORMATIONvalues c: CDEBIRTHCONGENITALMALFORMATIONvalues.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
