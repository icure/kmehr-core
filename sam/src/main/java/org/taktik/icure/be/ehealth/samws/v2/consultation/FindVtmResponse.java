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

import org.taktik.icure.be.ehealth.samws.v2.core.AnomalyType;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for FindVtmResponseType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="FindVtmResponseType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="Vtm" type="{urn:be:fgov:ehealth:samws:v2:consultation}ConsultVtmType" maxOccurs="unbounded"/>
 *         &lt;element name="Anomaly" type="{urn:be:fgov:ehealth:samws:v2:core}AnomalyType" maxOccurs="unbounded"/>
 *       &lt;/choice>
 *       &lt;attribute name="searchDate" use="required" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FindVtmResponseType", propOrder = {
    "anomalies",
    "vtms"
})
@XmlRootElement(name = "FindVtmResponse")
public class FindVtmResponse
    implements Serializable
{

    private final static long serialVersionUID = 2L;
    @XmlElement(name = "Anomaly")
    protected List<AnomalyType> anomalies;
    @XmlElement(name = "Vtm")
    protected List<ConsultVtmType> vtms;
    @XmlAttribute(name = "searchDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar searchDate;

    /**
     * Gets the value of the anomalies property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the anomalies property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnomalies().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AnomalyType }
     *
     *
     */
    public List<AnomalyType> getAnomalies() {
        if (anomalies == null) {
            anomalies = new ArrayList<AnomalyType>();
        }
        return this.anomalies;
    }

    /**
     * Gets the value of the vtms property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the vtms property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVtms().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConsultVtmType }
     *
     *
     */
    public List<ConsultVtmType> getVtms() {
        if (vtms == null) {
            vtms = new ArrayList<ConsultVtmType>();
        }
        return this.vtms;
    }

    /**
     * Gets the value of the searchDate property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getSearchDate() {
        return searchDate;
    }

    /**
     * Sets the value of the searchDate property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setSearchDate(XMLGregorianCalendar value) {
        this.searchDate = value;
    }

}
