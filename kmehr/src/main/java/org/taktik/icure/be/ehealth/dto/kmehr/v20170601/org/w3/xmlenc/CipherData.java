/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.06.14 at 03:50:09 PM CEST
//


package org.taktik.icure.be.ehealth.dto.kmehr.v20170601.org.w3.xmlenc;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CipherDataType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CipherDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="CipherValue" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *         &lt;element ref="{http://www.w3.org/2001/04/xmlenc#}CipherReference"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CipherDataType", propOrder = {
    "cipherReference",
    "cipherValue"
})
@XmlRootElement(name = "CipherData")
public class CipherData
    implements Serializable
{

    private final static long serialVersionUID = 20170601L;
    @XmlElement(name = "CipherReference")
    protected CipherReference cipherReference;
    @XmlElement(name = "CipherValue")
    protected byte[] cipherValue;

    /**
     * Gets the value of the cipherReference property.
     *
     * @return
     *     possible object is
     *     {@link CipherReference }
     *
     */
    public CipherReference getCipherReference() {
        return cipherReference;
    }

    /**
     * Sets the value of the cipherReference property.
     *
     * @param value
     *     allowed object is
     *     {@link CipherReference }
     *
     */
    public void setCipherReference(CipherReference value) {
        this.cipherReference = value;
    }

    /**
     * Gets the value of the cipherValue property.
     *
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getCipherValue() {
        return cipherValue;
    }

    /**
     * Sets the value of the cipherValue property.
     *
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setCipherValue(byte[] value) {
        this.cipherValue = value;
    }

}
