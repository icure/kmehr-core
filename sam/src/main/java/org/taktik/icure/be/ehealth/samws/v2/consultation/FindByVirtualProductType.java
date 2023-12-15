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
import java.io.Serializable;
import java.math.BigInteger;


/**
 * <p>Java class for FindByVirtualProductType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="FindByVirtualProductType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="VmpCode" type="{http://www.w3.org/2001/XMLSchema}positiveInteger"/>
 *         &lt;element name="AnyNamePart" type="{urn:be:fgov:ehealth:samws:v2:core}SearchStringType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FindByVirtualProductType", propOrder = {
    "anyNamePart",
    "vmpCode"
})
public class FindByVirtualProductType
    implements Serializable
{

    private final static long serialVersionUID = 2L;
    @XmlElement(name = "AnyNamePart")
    protected String anyNamePart;
    @XmlElement(name = "VmpCode")
    @XmlSchemaType(name = "positiveInteger")
    protected BigInteger vmpCode;

    /**
     * Gets the value of the anyNamePart property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAnyNamePart() {
        return anyNamePart;
    }

    /**
     * Sets the value of the anyNamePart property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAnyNamePart(String value) {
        this.anyNamePart = value;
    }

    /**
     * Gets the value of the vmpCode property.
     *
     * @return
     *     possible object is
     *     {@link BigInteger }
     *
     */
    public BigInteger getVmpCode() {
        return vmpCode;
    }

    /**
     * Sets the value of the vmpCode property.
     *
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *
     */
    public void setVmpCode(BigInteger value) {
        this.vmpCode = value;
    }

}