/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.06.14 at 03:49:29 PM CEST
//


package org.taktik.icure.be.ehealth.dto.kmehr.v20141201.be.fgov.ehealth.standards.kmehr.schema.v1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.taktik.icure.be.ehealth.dto.kmehr.v20141201.be.fgov.ehealth.standards.kmehr.cd.v1.CDERRORMYCARENET;
import org.taktik.icure.be.ehealth.dto.kmehr.v20141201.be.fgov.ehealth.standards.kmehr.dt.v1.TextType;


/**
 * to specify possible errors
 *
 * <p>Java class for errorMyCarenetType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="errorMyCarenetType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cd" type="{http://www.ehealth.fgov.be/standards/kmehr/cd/v1}CD-ERROR-MYCARENET" maxOccurs="unbounded"/>
 *         &lt;element name="description" type="{http://www.ehealth.fgov.be/standards/kmehr/dt/v1}textType"/>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "errorMyCarenetType", propOrder = {
    "cds",
    "description",
    "url"
})
public class ErrorMyCarenetType
    implements Serializable
{

    private final static long serialVersionUID = 20141201L;
    @XmlElement(name = "cd", required = true)
    protected List<CDERRORMYCARENET> cds;
    @XmlElement(required = true)
    protected TextType description;
    protected String url;

    /**
     * Gets the value of the cds property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cds property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCds().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link CDERRORMYCARENET }
     *
     *
     */
    public List<CDERRORMYCARENET> getCds() {
        if (cds == null) {
            cds = new ArrayList<CDERRORMYCARENET>();
        }
        return this.cds;
    }

    /**
     * Gets the value of the description property.
     *
     * @return
     *     possible object is
     *     {@link TextType }
     *
     */
    public TextType getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value
     *     allowed object is
     *     {@link TextType }
     *
     */
    public void setDescription(TextType value) {
        this.description = value;
    }

    /**
     * Gets the value of the url property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUrl(String value) {
        this.url = value;
    }

}
