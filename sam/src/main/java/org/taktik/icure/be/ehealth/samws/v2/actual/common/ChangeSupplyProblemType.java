/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.05.22 at 08:11:32 PM CEST
//


package org.taktik.icure.be.ehealth.samws.v2.actual.common;

import org.taktik.icure.be.ehealth.samws.v2.core.ChangeActionType;
import org.taktik.icure.be.ehealth.samws.v2.core.TextType;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;


/**
 * <p>Java class for ChangeSupplyProblemType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ChangeSupplyProblemType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;sequence minOccurs="0">
 *           &lt;group ref="{urn:be:fgov:ehealth:samws:v2:actual:common}SupplyProblemFields"/>
 *         &lt;/sequence>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{urn:be:fgov:ehealth:samws:v2:core}changeMetadata"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ChangeSupplyProblemType", propOrder = {
    "expectedEndOn",
    "reportedBy",
    "reportedOn",
    "contactName",
    "contactMail",
    "contactCompany",
    "phone",
    "reason",
    "additionalInformation"
})
public class ChangeSupplyProblemType
    implements Serializable
{

    private final static long serialVersionUID = 2L;
    @XmlElement(name = "ExpectedEndOn")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar expectedEndOn;
    @XmlElement(name = "ReportedBy")
    protected String reportedBy;
    @XmlElement(name = "ReportedOn")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar reportedOn;
    @XmlElement(name = "ContactName")
    protected String contactName;
    @XmlElement(name = "ContactMail")
    protected String contactMail;
    @XmlElement(name = "ContactCompany")
    protected String contactCompany;
    @XmlElement(name = "Phone")
    protected String phone;
    @XmlElement(name = "Reason")
    protected TextType reason;
    @XmlElement(name = "AdditionalInformation")
    protected TextType additionalInformation;
    @XmlAttribute(name = "action", required = true)
    protected ChangeActionType action;
    @XmlAttribute(name = "from", required = true)
    protected XMLGregorianCalendar from;
    @XmlAttribute(name = "to")
    protected XMLGregorianCalendar to;

    /**
     * Gets the value of the expectedEndOn property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getExpectedEndOn() {
        return expectedEndOn;
    }

    /**
     * Sets the value of the expectedEndOn property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setExpectedEndOn(XMLGregorianCalendar value) {
        this.expectedEndOn = value;
    }

    /**
     * Gets the value of the reportedBy property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getReportedBy() {
        return reportedBy;
    }

    /**
     * Sets the value of the reportedBy property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setReportedBy(String value) {
        this.reportedBy = value;
    }

    /**
     * Gets the value of the reportedOn property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getReportedOn() {
        return reportedOn;
    }

    /**
     * Sets the value of the reportedOn property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setReportedOn(XMLGregorianCalendar value) {
        this.reportedOn = value;
    }

    /**
     * Gets the value of the contactName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * Sets the value of the contactName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setContactName(String value) {
        this.contactName = value;
    }

    /**
     * Gets the value of the contactMail property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getContactMail() {
        return contactMail;
    }

    /**
     * Sets the value of the contactMail property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setContactMail(String value) {
        this.contactMail = value;
    }

    /**
     * Gets the value of the contactCompany property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getContactCompany() {
        return contactCompany;
    }

    /**
     * Sets the value of the contactCompany property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setContactCompany(String value) {
        this.contactCompany = value;
    }

    /**
     * Gets the value of the phone property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the value of the phone property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPhone(String value) {
        this.phone = value;
    }

    /**
     * Gets the value of the reason property.
     *
     * @return
     *     possible object is
     *     {@link TextType }
     *
     */
    public TextType getReason() {
        return reason;
    }

    /**
     * Sets the value of the reason property.
     *
     * @param value
     *     allowed object is
     *     {@link TextType }
     *
     */
    public void setReason(TextType value) {
        this.reason = value;
    }

    /**
     * Gets the value of the additionalInformation property.
     *
     * @return
     *     possible object is
     *     {@link TextType }
     *
     */
    public TextType getAdditionalInformation() {
        return additionalInformation;
    }

    /**
     * Sets the value of the additionalInformation property.
     *
     * @param value
     *     allowed object is
     *     {@link TextType }
     *
     */
    public void setAdditionalInformation(TextType value) {
        this.additionalInformation = value;
    }

    /**
     * Gets the value of the action property.
     *
     * @return
     *     possible object is
     *     {@link ChangeActionType }
     *
     */
    public ChangeActionType getAction() {
        return action;
    }

    /**
     * Sets the value of the action property.
     *
     * @param value
     *     allowed object is
     *     {@link ChangeActionType }
     *
     */
    public void setAction(ChangeActionType value) {
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
