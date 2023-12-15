/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2020.10.15 at 03:32:18 PM CEST
//


package org.taktik.icure.be.samv2v5.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;


/**
 * <p>Java class for ParameterizedQuantityType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ParameterizedQuantityType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Quantity" type="{urn:be:fgov:ehealth:samws:v2:core}QuantityType"/>
 *         &lt;element name="Multiplier" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="DosageParameterName" type="{urn:be:fgov:ehealth:samws:v2:core}String255Type" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ParameterizedQuantityType", namespace = "urn:be:fgov:ehealth:samws:v2:virtual:common", propOrder = {
    "quantity",
    "multiplier",
    "dosageParameterName"
})
public class ParameterizedQuantityType {

    @XmlElement(name = "Quantity", namespace = "urn:be:fgov:ehealth:samws:v2:virtual:common", required = true)
    protected QuantityType quantity;
    @XmlElement(name = "Multiplier", namespace = "urn:be:fgov:ehealth:samws:v2:virtual:common")
    protected BigDecimal multiplier;
    @XmlElement(name = "DosageParameterName", namespace = "urn:be:fgov:ehealth:samws:v2:virtual:common")
    protected String dosageParameterName;

    /**
     * Gets the value of the quantity property.
     *
     * @return
     *     possible object is
     *     {@link QuantityType }
     *
     */
    public QuantityType getQuantity() {
        return quantity;
    }

    /**
     * Sets the value of the quantity property.
     *
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *
     */
    public void setQuantity(QuantityType value) {
        this.quantity = value;
    }

    /**
     * Gets the value of the multiplier property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getMultiplier() {
        return multiplier;
    }

    /**
     * Sets the value of the multiplier property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setMultiplier(BigDecimal value) {
        this.multiplier = value;
    }

    /**
     * Gets the value of the dosageParameterName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDosageParameterName() {
        return dosageParameterName;
    }

    /**
     * Sets the value of the dosageParameterName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDosageParameterName(String value) {
        this.dosageParameterName = value;
    }

}
