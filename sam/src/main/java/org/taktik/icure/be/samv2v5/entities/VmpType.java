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
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for VmpType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="VmpType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:be:fgov:ehealth:samws:v2:core}VmpKeyType">
 *       &lt;sequence>
 *         &lt;group ref="{urn:be:fgov:ehealth:samws:v2:virtual:common}VmpFields"/>
 *         &lt;group ref="{urn:be:fgov:ehealth:samws:v2:virtual:common}VmpReferences"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VmpType", namespace = "urn:be:fgov:ehealth:samws:v2:virtual:common", propOrder = {
    "name",
    "abbreviation",
    "singleAdministrationDose",
    "commentedClassificationCode",
    "vmpGroupCode",
    "vtmCode",
    "wadaCode"
})
@XmlSeeAlso({
    AddVmpType.class
})
public class VmpType
    extends VmpKeyType
{

    @XmlElement(name = "Name", namespace = "urn:be:fgov:ehealth:samws:v2:virtual:common", required = true)
    protected Text255Type name;
    @XmlElement(name = "Abbreviation", namespace = "urn:be:fgov:ehealth:samws:v2:virtual:common", required = true)
    protected Text255Type abbreviation;
    @XmlElement(name = "SingleAdministrationDose", namespace = "urn:be:fgov:ehealth:samws:v2:virtual:common")
    protected QuantityType singleAdministrationDose;
    @XmlElement(name = "CommentedClassificationCode", namespace = "urn:be:fgov:ehealth:samws:v2:virtual:common")
    protected List<String> commentedClassificationCode;
    @XmlElement(name = "VmpGroupCode", namespace = "urn:be:fgov:ehealth:samws:v2:virtual:common")
    protected int vmpGroupCode;
    @XmlElement(name = "VtmCode", namespace = "urn:be:fgov:ehealth:samws:v2:virtual:common")
    protected Integer vtmCode;
    @XmlElement(name = "WadaCode", namespace = "urn:be:fgov:ehealth:samws:v2:virtual:common")
    protected List<String> wadaCode;

    /**
     * Gets the value of the name property.
     *
     * @return
     *     possible object is
     *     {@link Text255Type }
     *
     */
    public Text255Type getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value
     *     allowed object is
     *     {@link Text255Type }
     *
     */
    public void setName(Text255Type value) {
        this.name = value;
    }

    /**
     * Gets the value of the abbreviation property.
     *
     * @return
     *     possible object is
     *     {@link Text255Type }
     *
     */
    public Text255Type getAbbreviation() {
        return abbreviation;
    }

    /**
     * Sets the value of the abbreviation property.
     *
     * @param value
     *     allowed object is
     *     {@link Text255Type }
     *
     */
    public void setAbbreviation(Text255Type value) {
        this.abbreviation = value;
    }

    /**
     * Gets the value of the singleAdministrationDose property.
     *
     * @return
     *     possible object is
     *     {@link QuantityType }
     *
     */
    public QuantityType getSingleAdministrationDose() {
        return singleAdministrationDose;
    }

    /**
     * Sets the value of the singleAdministrationDose property.
     *
     * @param value
     *     allowed object is
     *     {@link QuantityType }
     *
     */
    public void setSingleAdministrationDose(QuantityType value) {
        this.singleAdministrationDose = value;
    }

    /**
     * Gets the value of the commentedClassificationCode property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the commentedClassificationCode property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCommentedClassificationCode().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     *
     */
    public List<String> getCommentedClassificationCode() {
        if (commentedClassificationCode == null) {
            commentedClassificationCode = new ArrayList<String>();
        }
        return this.commentedClassificationCode;
    }

    /**
     * Gets the value of the vmpGroupCode property.
     *
     */
    public int getVmpGroupCode() {
        return vmpGroupCode;
    }

    /**
     * Sets the value of the vmpGroupCode property.
     *
     */
    public void setVmpGroupCode(int value) {
        this.vmpGroupCode = value;
    }

    /**
     * Gets the value of the vtmCode property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    public Integer getVtmCode() {
        return vtmCode;
    }

    /**
     * Sets the value of the vtmCode property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setVtmCode(Integer value) {
        this.vtmCode = value;
    }

    /**
     * Gets the value of the wadaCode property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wadaCode property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWadaCode().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     *
     *
     */
    public List<String> getWadaCode() {
        if (wadaCode == null) {
            wadaCode = new ArrayList<String>();
        }
        return this.wadaCode;
    }

}
