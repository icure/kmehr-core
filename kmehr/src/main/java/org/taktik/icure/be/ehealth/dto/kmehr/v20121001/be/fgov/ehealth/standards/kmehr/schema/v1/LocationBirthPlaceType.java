/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.06.14 at 03:48:44 PM CEST
//


package org.taktik.icure.be.ehealth.dto.kmehr.v20121001.be.fgov.ehealth.standards.kmehr.schema.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.taktik.icure.be.ehealth.dto.kmehr.v20121001.be.fgov.ehealth.standards.kmehr.cd.v1.CDEBIRTHPLACE;
import org.taktik.icure.be.ehealth.dto.kmehr.v20121001.be.fgov.ehealth.standards.kmehr.dt.v1.TextType;


/**
 * <p>Java class for locationBirthPlaceType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="locationBirthPlaceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cd" type="{http://www.ehealth.fgov.be/standards/kmehr/cd/v1}CD-EBIRTH-PLACE"/>
 *         &lt;element name="text" type="{http://www.ehealth.fgov.be/standards/kmehr/dt/v1}textType" minOccurs="0"/>
 *         &lt;element name="address" type="{http://www.ehealth.fgov.be/standards/kmehr/schema/v1}addressType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "locationBirthPlaceType", propOrder = {
    "cd",
    "text",
    "address"
})
public class LocationBirthPlaceType
    implements Serializable
{

    private final static long serialVersionUID = 20121001L;
    @XmlElement(required = true)
    protected CDEBIRTHPLACE cd;
    protected TextType text;
    @XmlElement(required = true)
    protected AddressType address;

    /**
     * Gets the value of the cd property.
     *
     * @return
     *     possible object is
     *     {@link CDEBIRTHPLACE }
     *
     */
    public CDEBIRTHPLACE getCd() {
        return cd;
    }

    /**
     * Sets the value of the cd property.
     *
     * @param value
     *     allowed object is
     *     {@link CDEBIRTHPLACE }
     *
     */
    public void setCd(CDEBIRTHPLACE value) {
        this.cd = value;
    }

    /**
     * Gets the value of the text property.
     *
     * @return
     *     possible object is
     *     {@link TextType }
     *
     */
    public TextType getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     *
     * @param value
     *     allowed object is
     *     {@link TextType }
     *
     */
    public void setText(TextType value) {
        this.text = value;
    }

    /**
     * Gets the value of the address property.
     *
     * @return
     *     possible object is
     *     {@link AddressType }
     *
     */
    public AddressType getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     *
     * @param value
     *     allowed object is
     *     {@link AddressType }
     *
     */
    public void setAddress(AddressType value) {
        this.address = value;
    }

}
