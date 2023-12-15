/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.06.14 at 03:48:36 PM CEST
//


package org.taktik.icure.be.ehealth.dto.kmehr.v20131001.be.fgov.ehealth.standards.kmehr.schema.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.taktik.icure.be.ehealth.dto.kmehr.v20131001.be.fgov.ehealth.standards.kmehr.id.v1.IDINSURANCE;


/**
 * <p>Java class for memberinsuranceType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="memberinsuranceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.ehealth.fgov.be/standards/kmehr/id/v1}ID-INSURANCE"/>
 *         &lt;element name="membership" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "memberinsuranceType", propOrder = {
    "id",
    "membership"
})
public class MemberinsuranceType
    implements Serializable
{

    private final static long serialVersionUID = 20131001L;
    @XmlElement(required = true)
    protected IDINSURANCE id;
    @XmlElement(required = true)
    protected Object membership;

    /**
     * Gets the value of the id property.
     *
     * @return
     *     possible object is
     *     {@link IDINSURANCE }
     *
     */
    public IDINSURANCE getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     *
     * @param value
     *     allowed object is
     *     {@link IDINSURANCE }
     *
     */
    public void setId(IDINSURANCE value) {
        this.id = value;
    }

    /**
     * Gets the value of the membership property.
     *
     * @return
     *     possible object is
     *     {@link Object }
     *
     */
    public Object getMembership() {
        return membership;
    }

    /**
     * Sets the value of the membership property.
     *
     * @param value
     *     allowed object is
     *     {@link Object }
     *
     */
    public void setMembership(Object value) {
        this.membership = value;
    }

}
