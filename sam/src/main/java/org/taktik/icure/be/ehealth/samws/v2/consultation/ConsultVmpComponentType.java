/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.05.22 at 08:11:32 PM CEST
//


package org.taktik.icure.be.ehealth.samws.v2.consultation;

import org.taktik.icure.be.ehealth.samws.v2.core.VmpComponentKeyType;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ConsultVmpComponentType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ConsultVmpComponentType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:be:fgov:ehealth:samws:v2:core}VmpComponentKeyType">
 *       &lt;sequence>
 *         &lt;element name="PhaseNumber" type="{http://www.w3.org/2001/XMLSchema}positiveInteger" minOccurs="0"/>
 *         &lt;element name="Name" type="{urn:be:fgov:ehealth:samws:v2:consultation}ConsultTextType"/>
 *         &lt;element name="VirtualForm" type="{urn:be:fgov:ehealth:samws:v2:consultation}VirtualFormWithStandardsType"/>
 *         &lt;element name="RouteOfAdministration" type="{urn:be:fgov:ehealth:samws:v2:consultation}RouteOfAdministrationWithStandardsType" maxOccurs="unbounded"/>
 *         &lt;element name="VirtualIngredient" type="{urn:be:fgov:ehealth:samws:v2:consultation}ConsultVirtualIngredientType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{urn:be:fgov:ehealth:samws:v2:consultation}validityPeriod"/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultVmpComponentType", propOrder = {
    "phaseNumber",
    "name",
    "virtualForm",
    "routeOfAdministrations",
    "virtualIngredients"
})
public class ConsultVmpComponentType
    extends VmpComponentKeyType
    implements Serializable
{

    private final static long serialVersionUID = 2L;
    @XmlElement(name = "PhaseNumber")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger phaseNumber;
    @XmlElement(name = "Name", required = true)
    protected ConsultTextType name;
    @XmlElement(name = "VirtualForm", required = true)
    protected VirtualFormWithStandardsType virtualForm;
    @XmlElement(name = "RouteOfAdministration", required = true)
    protected List<RouteOfAdministrationWithStandardsType> routeOfAdministrations;
    @XmlElement(name = "VirtualIngredient", required = true)
    protected List<ConsultVirtualIngredientType> virtualIngredients;
    @XmlAttribute(name = "StartDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar startDate;
    @XmlAttribute(name = "EndDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar endDate;

    /**
     * Gets the value of the phaseNumber property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getPhaseNumber() {
        return phaseNumber;
    }

    /**
     * Sets the value of the phaseNumber property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setPhaseNumber(BigInteger value) {
        this.phaseNumber = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return
     *     possible object is
     *     {@link ConsultTextType }
     *
     */
    public ConsultTextType getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value
     *     allowed object is
     *     {@link ConsultTextType }
     *
     */
    public void setName(ConsultTextType value) {
        this.name = value;
    }

    /**
     * Gets the value of the virtualForm property.
     *
     * @return
     *     possible object is
     *     {@link VirtualFormWithStandardsType }
     *
     */
    public VirtualFormWithStandardsType getVirtualForm() {
        return virtualForm;
    }

    /**
     * Sets the value of the virtualForm property.
     *
     * @param value
     *     allowed object is
     *     {@link VirtualFormWithStandardsType }
     *
     */
    public void setVirtualForm(VirtualFormWithStandardsType value) {
        this.virtualForm = value;
    }

    /**
     * Gets the value of the routeOfAdministrations property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the routeOfAdministrations property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRouteOfAdministrations().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RouteOfAdministrationWithStandardsType }
     *
     *
     */
    public List<RouteOfAdministrationWithStandardsType> getRouteOfAdministrations() {
        if (routeOfAdministrations == null) {
            routeOfAdministrations = new ArrayList<RouteOfAdministrationWithStandardsType>();
        }
        return this.routeOfAdministrations;
    }

    /**
     * Gets the value of the virtualIngredients property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the virtualIngredients property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVirtualIngredients().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConsultVirtualIngredientType }
     *
     *
     */
    public List<ConsultVirtualIngredientType> getVirtualIngredients() {
        if (virtualIngredients == null) {
            virtualIngredients = new ArrayList<ConsultVirtualIngredientType>();
        }
        return this.virtualIngredients;
    }

    /**
     * Gets the value of the startDate property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

}
