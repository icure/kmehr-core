/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.06.14 at 03:48:53 PM CEST
//


package org.taktik.icure.services.external.rest.v1.dto.be.ehealth.kmehr.v20100901.be.fgov.ehealth.standards.kmehr.cd.v1;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CD-TRANSACTIONvalues.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CD-TRANSACTIONvalues">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="admission"/>
 *     &lt;enumeration value="alert"/>
 *     &lt;enumeration value="contactreport"/>
 *     &lt;enumeration value="death"/>
 *     &lt;enumeration value="discharge"/>
 *     &lt;enumeration value="dischargereport"/>
 *     &lt;enumeration value="epidemiology"/>
 *     &lt;enumeration value="labrequest"/>
 *     &lt;enumeration value="labresult"/>
 *     &lt;enumeration value="note"/>
 *     &lt;enumeration value="hospitalpharmaceuticalprescription"/>
 *     &lt;enumeration value="pharmaceuticalprescription"/>
 *     &lt;enumeration value="productdelivery"/>
 *     &lt;enumeration value="quickdischargereport"/>
 *     &lt;enumeration value="referral"/>
 *     &lt;enumeration value="request"/>
 *     &lt;enumeration value="result"/>
 *     &lt;enumeration value="vaccination"/>
 *     &lt;enumeration value="sumehr"/>
 *     &lt;enumeration value="ecare-safe-consultation"/>
 *     &lt;enumeration value="ebirth-mother-notification"/>
 *     &lt;enumeration value="ebirth-baby-notification"/>
 *     &lt;enumeration value="ebirth-baby-medicalform"/>
 *     &lt;enumeration value="ebirth-mother-medicalform"/>
 *     &lt;enumeration value="clinicalsummary"/>
 *     &lt;enumeration value="preventionplan"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "CD-TRANSACTIONvalues")
@XmlEnum
public enum CDTRANSACTIONvalues {

    @XmlEnumValue("admission")
    ADMISSION("admission"),
    @XmlEnumValue("alert")
    ALERT("alert"),
    @XmlEnumValue("contactreport")
    CONTACTREPORT("contactreport"),
    @XmlEnumValue("death")
    DEATH("death"),
    @XmlEnumValue("discharge")
    DISCHARGE("discharge"),
    @XmlEnumValue("dischargereport")
    DISCHARGEREPORT("dischargereport"),
    @XmlEnumValue("epidemiology")
    EPIDEMIOLOGY("epidemiology"),
    @XmlEnumValue("labrequest")
    LABREQUEST("labrequest"),
    @XmlEnumValue("labresult")
    LABRESULT("labresult"),
    @XmlEnumValue("note")
    NOTE("note"),
    @XmlEnumValue("hospitalpharmaceuticalprescription")
    HOSPITALPHARMACEUTICALPRESCRIPTION("hospitalpharmaceuticalprescription"),
    @XmlEnumValue("pharmaceuticalprescription")
    PHARMACEUTICALPRESCRIPTION("pharmaceuticalprescription"),
    @XmlEnumValue("productdelivery")
    PRODUCTDELIVERY("productdelivery"),
    @XmlEnumValue("quickdischargereport")
    QUICKDISCHARGEREPORT("quickdischargereport"),
    @XmlEnumValue("referral")
    REFERRAL("referral"),
    @XmlEnumValue("request")
    REQUEST("request"),
    @XmlEnumValue("result")
    RESULT("result"),
    @XmlEnumValue("vaccination")
    VACCINATION("vaccination"),
    @XmlEnumValue("sumehr")
    SUMEHR("sumehr"),
    @XmlEnumValue("ecare-safe-consultation")
    ECARE_SAFE_CONSULTATION("ecare-safe-consultation"),
    @XmlEnumValue("ebirth-mother-notification")
    EBIRTH_MOTHER_NOTIFICATION("ebirth-mother-notification"),
    @XmlEnumValue("ebirth-baby-notification")
    EBIRTH_BABY_NOTIFICATION("ebirth-baby-notification"),
    @XmlEnumValue("ebirth-baby-medicalform")
    EBIRTH_BABY_MEDICALFORM("ebirth-baby-medicalform"),
    @XmlEnumValue("ebirth-mother-medicalform")
    EBIRTH_MOTHER_MEDICALFORM("ebirth-mother-medicalform"),
    @XmlEnumValue("clinicalsummary")
    CLINICALSUMMARY("clinicalsummary"),
    @XmlEnumValue("preventionplan")
    PREVENTIONPLAN("preventionplan");
    private final String value;

    CDTRANSACTIONvalues(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CDTRANSACTIONvalues fromValue(String v) {
        for (CDTRANSACTIONvalues c: CDTRANSACTIONvalues.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
