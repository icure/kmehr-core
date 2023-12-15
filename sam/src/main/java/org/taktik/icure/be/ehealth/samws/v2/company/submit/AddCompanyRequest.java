/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.05.22 at 08:11:32 PM CEST
//


package org.taktik.icure.be.ehealth.samws.v2.company.submit;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


/**
 * <p>Java class for AddCompanyRequestType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AddCompanyRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Company" type="{urn:be:fgov:ehealth:samws:v2:company:submit}AddCompanyType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AddCompanyRequestType", propOrder = {
    "company"
})
@XmlRootElement(name = "AddCompanyRequest")
public class AddCompanyRequest
    implements Serializable
{

    private final static long serialVersionUID = 2L;
    @XmlElement(name = "Company", required = true)
    protected AddCompanyType company;

    /**
     * Gets the value of the company property.
     *
     * @return
     *     possible object is
     *     {@link AddCompanyType }
     *
     */
    public AddCompanyType getCompany() {
        return company;
    }

    /**
     * Sets the value of the company property.
     *
     * @param value
     *     allowed object is
     *     {@link AddCompanyType }
     *
     */
    public void setCompany(AddCompanyType value) {
        this.company = value;
    }

}
