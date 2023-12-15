/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.05.22 at 08:11:32 PM CEST
//


package org.taktik.icure.be.ehealth.samws.v2.virtual.common;

import org.taktik.icure.be.ehealth.samws.v2.consultation.ConsultVirtualIngredientType;
import org.taktik.icure.be.samv2v5.entities.VirtualIngredientFullDataType;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


/**
 * <p>Java class for VirtualIngredientKeyType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="VirtualIngredientKeyType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="rank" use="required" type="{urn:be:fgov:ehealth:samws:v2:core}PositiveShortType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "VirtualIngredientKeyType")
@XmlSeeAlso({
    VirtualIngredientFullDataType.class,
    ChangeVirtualIngredientType.class,
    VirtualIngredientType.class,
    ConsultVirtualIngredientType.class
})
public class VirtualIngredientKeyType
    implements Serializable
{

    private final static long serialVersionUID = 2L;
    @XmlAttribute(name = "rank", required = true)
    protected short rank;

    /**
     * Gets the value of the rank property.
     *
     */
    public short getRank() {
        return rank;
    }

    /**
     * Sets the value of the rank property.
     *
     */
    public void setRank(short value) {
        this.rank = value;
    }

}