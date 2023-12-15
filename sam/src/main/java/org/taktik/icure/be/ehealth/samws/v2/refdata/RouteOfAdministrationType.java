/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.05.22 at 08:11:32 PM CEST
//


package org.taktik.icure.be.ehealth.samws.v2.refdata;

import org.taktik.icure.be.ehealth.samws.v2.core.Text255Type;
import org.taktik.icure.be.samv2v5.entities.RouteOfAdministrationWithStandardsType;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


/**
 * <p>Java class for RouteOfAdministrationType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="RouteOfAdministrationType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:be:fgov:ehealth:samws:v2:refdata}RouteOfAdministrationKeyType">
 *       &lt;sequence>
 *         &lt;element name="Name" type="{urn:be:fgov:ehealth:samws:v2:core}Text255Type"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RouteOfAdministrationType", propOrder = {
    "name"
})
@XmlSeeAlso({
    RouteOfAdministrationWithStandardsType.class
})
public class RouteOfAdministrationType
    extends RouteOfAdministrationKeyType
    implements Serializable
{

    private final static long serialVersionUID = 2L;
    @XmlElement(name = "Name", required = true)
    protected Text255Type name;

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

}
