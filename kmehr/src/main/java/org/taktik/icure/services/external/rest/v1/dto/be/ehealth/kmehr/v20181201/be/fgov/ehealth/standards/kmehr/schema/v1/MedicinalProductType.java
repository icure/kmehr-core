/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.06.14 at 03:49:17 PM CEST
//


package org.taktik.icure.services.external.rest.v1.dto.be.ehealth.kmehr.v20181201.be.fgov.ehealth.standards.kmehr.schema.v1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.taktik.icure.services.external.rest.v1.dto.be.ehealth.kmehr.v20181201.be.fgov.ehealth.standards.kmehr.cd.v1.CDDRUGCNK;


/**
 *
 *         a medicinal product can be identified
 *         unambiguously by a CNK code identifying
 *         a package. The descriptive
 *         identification is only mandatory in case
 *         of absence of a package ID.
 *
 *
 * <p>Java class for medicinalProductType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="medicinalProductType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="intendedcd" type="{http://www.ehealth.fgov.be/standards/kmehr/cd/v1}CD-DRUG-CNK" maxOccurs="unbounded"/>
 *         &lt;element name="deliveredcd" type="{http://www.ehealth.fgov.be/standards/kmehr/cd/v1}CD-DRUG-CNK" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="intendedname" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="deliveredname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "medicinalProductType", propOrder = {
    "intendedcds",
    "deliveredcds",
    "intendedname",
    "deliveredname"
})
public class MedicinalProductType
    implements Serializable
{

    private final static long serialVersionUID = 20181201L;
    @XmlElement(name = "intendedcd", required = true)
    protected List<CDDRUGCNK> intendedcds;
    @XmlElement(name = "deliveredcd")
    protected List<CDDRUGCNK> deliveredcds;
    @XmlElement(required = true)
    protected String intendedname;
    protected String deliveredname;

    /**
     * Gets the value of the intendedcds property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the intendedcds property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIntendedcds().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CDDRUGCNK }
     *
     *
     */
    public List<CDDRUGCNK> getIntendedcds() {
        if (intendedcds == null) {
            intendedcds = new ArrayList<CDDRUGCNK>();
        }
        return this.intendedcds;
    }

    /**
     * Gets the value of the deliveredcds property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the deliveredcds property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDeliveredcds().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CDDRUGCNK }
     *
     *
     */
    public List<CDDRUGCNK> getDeliveredcds() {
        if (deliveredcds == null) {
            deliveredcds = new ArrayList<CDDRUGCNK>();
        }
        return this.deliveredcds;
    }

    /**
     * Gets the value of the intendedname property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getIntendedname() {
        return intendedname;
    }

    /**
     * Sets the value of the intendedname property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setIntendedname(String value) {
        this.intendedname = value;
    }

    /**
     * Gets the value of the deliveredname property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDeliveredname() {
        return deliveredname;
    }

    /**
     * Sets the value of the deliveredname property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDeliveredname(String value) {
        this.deliveredname = value;
    }

}
