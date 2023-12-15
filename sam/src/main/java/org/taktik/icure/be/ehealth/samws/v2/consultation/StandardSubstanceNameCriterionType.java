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

import org.taktik.icure.be.ehealth.samws.v2.refdata.StdSbstAllStandardsType;

import javax.xml.bind.annotation.*;
import java.io.Serializable;


/**
 * <p>Java class for StandardSubstanceNameCriterionType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="StandardSubstanceNameCriterionType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;urn:be:fgov:ehealth:samws:v2:core>SearchStringType">
 *       &lt;attribute name="standard" type="{urn:be:fgov:ehealth:samws:v2:refdata}StdSbstAllStandardsType" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StandardSubstanceNameCriterionType", propOrder = {
    "value"
})
public class StandardSubstanceNameCriterionType
    implements Serializable
{

    private final static long serialVersionUID = 2L;
    @XmlValue
    protected String value;
    @XmlAttribute(name = "standard")
    protected StdSbstAllStandardsType standard;

    /**
     * Gets the value of the value property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the standard property.
     *
     * @return
     *     possible object is
     *     {@link StdSbstAllStandardsType }
     *
     */
    public StdSbstAllStandardsType getStandard() {
        return standard;
    }

    /**
     * Sets the value of the standard property.
     *
     * @param value
     *     allowed object is
     *     {@link StdSbstAllStandardsType }
     *
     */
    public void setStandard(StdSbstAllStandardsType value) {
        this.standard = value;
    }

}