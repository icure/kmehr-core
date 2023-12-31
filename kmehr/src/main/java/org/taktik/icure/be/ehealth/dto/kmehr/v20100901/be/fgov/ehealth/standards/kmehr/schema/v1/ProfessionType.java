/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.06.14 at 03:48:52 PM CEST
//


package org.taktik.icure.be.ehealth.dto.kmehr.v20100901.be.fgov.ehealth.standards.kmehr.schema.v1;

import org.taktik.icure.be.ehealth.dto.kmehr.v20100901.be.fgov.ehealth.standards.kmehr.dt.v1.TextType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;


/**
 * <p>Java class for professionType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="professionType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="text" type="{http://www.ehealth.fgov.be/standards/kmehr/dt/v1}textType"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "professionType", propOrder = {
        "text"
})
public class ProfessionType
        implements Serializable {

    private final static long serialVersionUID = 20100901L;
    protected TextType text;

    /**
     * Gets the value of the text property.
     *
     * @return possible object is
     * {@link TextType }
     */
    public TextType getText() {
        return text;
    }

    /**
     * Sets the value of the text property.
     *
     * @param value allowed object is
     *              {@link TextType }
     */
    public void setText(TextType value) {
        this.text = value;
    }

}
