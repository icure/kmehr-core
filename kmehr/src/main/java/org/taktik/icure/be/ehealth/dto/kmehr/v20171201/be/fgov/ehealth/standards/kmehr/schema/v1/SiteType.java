/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.06.14 at 03:49:45 PM CEST
//


package org.taktik.icure.be.ehealth.dto.kmehr.v20171201.be.fgov.ehealth.standards.kmehr.schema.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import org.taktik.icure.be.ehealth.dto.kmehr.v20171201.be.fgov.ehealth.standards.kmehr.cd.v1.CDSITE;
import org.taktik.icure.be.ehealth.dto.kmehr.v20171201.be.fgov.ehealth.standards.kmehr.dt.v1.TextType;


/**
 * <p>Java class for siteType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="siteType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="cd" type="{http://www.ehealth.fgov.be/standards/kmehr/cd/v1}CD-SITE"/>
 *         &lt;element name="text" type="{http://www.ehealth.fgov.be/standards/kmehr/dt/v1}textType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "siteType", propOrder = {
    "text",
    "cd"
})
public class SiteType
    implements Serializable
{

    private final static long serialVersionUID = 20171201L;
    protected TextType text;
    protected CDSITE cd;

    /**
     * Gets the value of the text property.
     *
     * @return
     *     possible object is
     *     {@link TextType }
     *
     */
    public TextType getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     *
     * @param value
     *     allowed object is
     *     {@link TextType }
     *
     */
    public void setText(TextType value) {
        this.text = value;
    }

    /**
     * Gets the value of the cd property.
     *
     * @return
     *     possible object is
     *     {@link CDSITE }
     *
     */
    public CDSITE getCd() {
        return cd;
    }

    /**
     * Sets the value of the cd property.
     *
     * @param value
     *     allowed object is
     *     {@link CDSITE }
     *
     */
    public void setCd(CDSITE value) {
        this.cd = value;
    }

}
