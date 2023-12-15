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

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;


/**
 * <p>Java class for FindCompoundingFormulaRequestType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="FindCompoundingFormulaRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="FindByCNK" type="{urn:be:fgov:ehealth:samws:v2:core}DmppCodeType"/>
 *         &lt;element name="FindByOfficialName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FindByAnyName" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "FindCompoundingFormulaRequestType", propOrder = {
    "findByAnyName",
    "findByOfficialName",
    "findByCNK"
})
@XmlRootElement(name = "FindCompoundingFormulaRequest")
public class FindCompoundingFormulaRequest
    implements Serializable
{

    private final static long serialVersionUID = 2L;
    @XmlElement(name = "FindByAnyName")
    protected String findByAnyName;
    @XmlElement(name = "FindByOfficialName")
    protected String findByOfficialName;
    @XmlElement(name = "FindByCNK")
    protected String findByCNK;
    @XmlAttribute(name = "lang", namespace = "http://www.w3.org/XML/1998/namespace", required = true)
    protected String lang;
    @XmlAttribute(name = "searchDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar searchDate;

    /**
     * Gets the value of the findByAnyName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFindByAnyName() {
        return findByAnyName;
    }

    /**
     * Sets the value of the findByAnyName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFindByAnyName(String value) {
        this.findByAnyName = value;
    }

    /**
     * Gets the value of the findByOfficialName property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFindByOfficialName() {
        return findByOfficialName;
    }

    /**
     * Sets the value of the findByOfficialName property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFindByOfficialName(String value) {
        this.findByOfficialName = value;
    }

    /**
     * Gets the value of the findByCNK property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFindByCNK() {
        return findByCNK;
    }

    /**
     * Sets the value of the findByCNK property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFindByCNK(String value) {
        this.findByCNK = value;
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
