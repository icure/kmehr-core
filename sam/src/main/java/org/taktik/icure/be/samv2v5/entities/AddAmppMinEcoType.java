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

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;


/**
 * <p>Java class for AddAmppMinEcoType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AddAmppMinEcoType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:be:fgov:ehealth:samws:v2:actual:common}AmppKeyType">
 *       &lt;sequence>
 *         &lt;element name="ExFactoryPrice" type="{urn:be:fgov:ehealth:samws:v2:core}Decimal10d4Type"/>
 *         &lt;element name="RealExFactoryPrice" type="{urn:be:fgov:ehealth:samws:v2:core}Decimal10d4Type" minOccurs="0"/>
 *         &lt;element name="DecisionDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="Index" type="{urn:be:fgov:ehealth:samws:v2:core}Decimal10d4Type" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{urn:be:fgov:ehealth:samws:v2:core}addMetadata"/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddAmppMinEcoType", namespace = "urn:be:fgov:ehealth:samws:v2:actual:common", propOrder = {
    "exFactoryPrice",
    "realExFactoryPrice",
    "decisionDate",
    "index"
})
public class AddAmppMinEcoType
    extends AmppKeyType
{

    @XmlElement(name = "ExFactoryPrice", required = true)
    protected BigDecimal exFactoryPrice;
    @XmlElement(name = "RealExFactoryPrice")
    protected BigDecimal realExFactoryPrice;
    @XmlElement(name = "DecisionDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar decisionDate;
    @XmlElement(name = "Index")
    protected BigDecimal index;
    @XmlAttribute(name = "action", required = true)
    protected AddActionType action;
    @XmlAttribute(name = "from", required = true)
    protected XMLGregorianCalendar from;
    @XmlAttribute(name = "to")
    protected XMLGregorianCalendar to;

    /**
     * Gets the value of the exFactoryPrice property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getExFactoryPrice() {
        return exFactoryPrice;
    }

    /**
     * Sets the value of the exFactoryPrice property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setExFactoryPrice(BigDecimal value) {
        this.exFactoryPrice = value;
    }

    /**
     * Gets the value of the realExFactoryPrice property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getRealExFactoryPrice() {
        return realExFactoryPrice;
    }

    /**
     * Sets the value of the realExFactoryPrice property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setRealExFactoryPrice(BigDecimal value) {
        this.realExFactoryPrice = value;
    }

    /**
     * Gets the value of the decisionDate property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getDecisionDate() {
        return decisionDate;
    }

    /**
     * Sets the value of the decisionDate property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setDecisionDate(XMLGregorianCalendar value) {
        this.decisionDate = value;
    }

    /**
     * Gets the value of the index property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getIndex() {
        return index;
    }

    /**
     * Sets the value of the index property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setIndex(BigDecimal value) {
        this.index = value;
    }

    /**
     * Gets the value of the action property.
     *
     * @return
     *     possible object is
     *     {@link AddActionType }
     *
     */
    public AddActionType getAction() {
        return action;
    }

    /**
     * Sets the value of the action property.
     *
     * @param value
     *     allowed object is
     *     {@link AddActionType }
     *
     */
    public void setAction(AddActionType value) {
        this.action = value;
    }

    /**
     * Gets the value of the from property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getFrom() {
        return from;
    }

    /**
     * Sets the value of the from property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setFrom(XMLGregorianCalendar value) {
        this.from = value;
    }

    /**
     * Gets the value of the to property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getTo() {
        return to;
    }

    /**
     * Sets the value of the to property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setTo(XMLGregorianCalendar value) {
        this.to = value;
    }

}
