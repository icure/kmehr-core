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
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ChangeAmpBcpiType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ChangeAmpBcpiType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:be:fgov:ehealth:samws:v2:actual:common}AmpKeyType">
 *       &lt;sequence>
 *         &lt;sequence minOccurs="0">
 *           &lt;group ref="{urn:be:fgov:ehealth:samws:v2:actual:common}AmpBcpiFields"/>
 *         &lt;/sequence>
 *         &lt;element name="AmpComponent" type="{urn:be:fgov:ehealth:samws:v2:actual:common}ChangeAmpComponentBcpiType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{urn:be:fgov:ehealth:samws:v2:core}changeNoChangeMetadata"/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChangeAmpBcpiType", namespace = "urn:be:fgov:ehealth:samws:v2:actual:common", propOrder = {
    "abbreviatedName",
    "proprietarySuffix",
    "prescriptionName",
    "ampComponent"
})
public class ChangeAmpBcpiType
    extends AmpKeyType
{

    @XmlElement(name = "AbbreviatedName")
    protected Text255Type abbreviatedName;
    @XmlElement(name = "ProprietarySuffix")
    protected Text255Type proprietarySuffix;
    @XmlElement(name = "PrescriptionName")
    protected Text255Type prescriptionName;
    @XmlElement(name = "AmpComponent")
    protected List<ChangeAmpComponentBcpiType> ampComponent;
    @XmlAttribute(name = "action", required = true)
    protected ChangeNoChangeActionType action;
    @XmlAttribute(name = "from")
    protected XMLGregorianCalendar from;
    @XmlAttribute(name = "to")
    protected XMLGregorianCalendar to;

    /**
     * Gets the value of the abbreviatedName property.
     *
     * @return
     *     possible object is
     *     {@link Text255Type }
     *
     */
    public Text255Type getAbbreviatedName() {
        return abbreviatedName;
    }

    /**
     * Sets the value of the abbreviatedName property.
     *
     * @param value
     *     allowed object is
     *     {@link Text255Type }
     *
     */
    public void setAbbreviatedName(Text255Type value) {
        this.abbreviatedName = value;
    }

    /**
     * Gets the value of the proprietarySuffix property.
     *
     * @return
     *     possible object is
     *     {@link Text255Type }
     *
     */
    public Text255Type getProprietarySuffix() {
        return proprietarySuffix;
    }

    /**
     * Sets the value of the proprietarySuffix property.
     *
     * @param value
     *     allowed object is
     *     {@link Text255Type }
     *
     */
    public void setProprietarySuffix(Text255Type value) {
        this.proprietarySuffix = value;
    }

    /**
     * Gets the value of the prescriptionName property.
     *
     * @return
     *     possible object is
     *     {@link Text255Type }
     *
     */
    public Text255Type getPrescriptionName() {
        return prescriptionName;
    }

    /**
     * Sets the value of the prescriptionName property.
     *
     * @param value
     *     allowed object is
     *     {@link Text255Type }
     *
     */
    public void setPrescriptionName(Text255Type value) {
        this.prescriptionName = value;
    }

    /**
     * Gets the value of the ampComponent property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ampComponent property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAmpComponent().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ChangeAmpComponentBcpiType }
     *
     *
     */
    public List<ChangeAmpComponentBcpiType> getAmpComponent() {
        if (ampComponent == null) {
            ampComponent = new ArrayList<ChangeAmpComponentBcpiType>();
        }
        return this.ampComponent;
    }

    /**
     * Gets the value of the action property.
     *
     * @return
     *     possible object is
     *     {@link ChangeNoChangeActionType }
     *
     */
    public ChangeNoChangeActionType getAction() {
        return action;
    }

    /**
     * Sets the value of the action property.
     *
     * @param value
     *     allowed object is
     *     {@link ChangeNoChangeActionType }
     *
     */
    public void setAction(ChangeNoChangeActionType value) {
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
