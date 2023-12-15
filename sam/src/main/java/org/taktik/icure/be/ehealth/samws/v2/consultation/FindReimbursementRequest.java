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

import org.taktik.icure.be.ehealth.samws.v2.actual.common.DmppKeyType;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;


/**
 * <p>Java class for FindReimbursementRequestType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="FindReimbursementRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="FindByPackage" type="{urn:be:fgov:ehealth:samws:v2:consultation}FindByPackageType"/>
 *         &lt;element name="FindByDmpp" type="{urn:be:fgov:ehealth:samws:v2:actual:common}DmppKeyType"/>
 *         &lt;element name="FindByLegalReferencePath" type="{urn:be:fgov:ehealth:samws:v2:core}LegalReferencePathType"/>
 *         &lt;element name="FindByGenericPrescriptionGroup" type="{urn:be:fgov:ehealth:samws:v2:consultation}FindByGenericPrescriptionGroupType"/>
 *       &lt;/choice>
 *       &lt;attribute ref="{http://www.w3.org/XML/1998/namespace}lang use="required""/>
 *       &lt;attribute name="searchDate" type="{http://www.w3.org/2001/XMLSchema}date" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FindReimbursementRequestType", propOrder = {
    "findByGenericPrescriptionGroup",
    "findByLegalReferencePath",
    "findByDmpp",
    "findByPackage"
})
@XmlRootElement(name = "FindReimbursementRequest")
public class FindReimbursementRequest
    implements Serializable
{

    private final static long serialVersionUID = 2L;
    @XmlElement(name = "FindByGenericPrescriptionGroup")
    protected FindByGenericPrescriptionGroupType findByGenericPrescriptionGroup;
    @XmlElement(name = "FindByLegalReferencePath")
    protected String findByLegalReferencePath;
    @XmlElement(name = "FindByDmpp")
    protected DmppKeyType findByDmpp;
    @XmlElement(name = "FindByPackage")
    protected FindByPackageType findByPackage;
    @XmlAttribute(name = "lang", namespace = "http://www.w3.org/XML/1998/namespace", required = true)
    protected String lang;
    @XmlAttribute(name = "searchDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar searchDate;

    /**
     * Gets the value of the findByGenericPrescriptionGroup property.
     *
     * @return
     *     possible object is
     *     {@link FindByGenericPrescriptionGroupType }
     *
     */
    public FindByGenericPrescriptionGroupType getFindByGenericPrescriptionGroup() {
        return findByGenericPrescriptionGroup;
    }

    /**
     * Sets the value of the findByGenericPrescriptionGroup property.
     *
     * @param value
     *     allowed object is
     *     {@link FindByGenericPrescriptionGroupType }
     *
     */
    public void setFindByGenericPrescriptionGroup(FindByGenericPrescriptionGroupType value) {
        this.findByGenericPrescriptionGroup = value;
    }

    /**
     * Gets the value of the findByLegalReferencePath property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFindByLegalReferencePath() {
        return findByLegalReferencePath;
    }

    /**
     * Sets the value of the findByLegalReferencePath property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFindByLegalReferencePath(String value) {
        this.findByLegalReferencePath = value;
    }

    /**
     * Gets the value of the findByDmpp property.
     *
     * @return
     *     possible object is
     *     {@link DmppKeyType }
     *
     */
    public DmppKeyType getFindByDmpp() {
        return findByDmpp;
    }

    /**
     * Sets the value of the findByDmpp property.
     *
     * @param value
     *     allowed object is
     *     {@link DmppKeyType }
     *
     */
    public void setFindByDmpp(DmppKeyType value) {
        this.findByDmpp = value;
    }

    /**
     * Gets the value of the findByPackage property.
     *
     * @return
     *     possible object is
     *     {@link FindByPackageType }
     *
     */
    public FindByPackageType getFindByPackage() {
        return findByPackage;
    }

    /**
     * Sets the value of the findByPackage property.
     *
     * @param value
     *     allowed object is
     *     {@link FindByPackageType }
     *
     */
    public void setFindByPackage(FindByPackageType value) {
        this.findByPackage = value;
    }

    /**
     * Gets the value of the lang property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLang() {
        return lang;
    }

    /**
     * Sets the value of the lang property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLang(String value) {
        this.lang = value;
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
