/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.06.14 at 03:49:41 PM CEST
//


package org.taktik.icure.be.ehealth.dto.kmehr.v20190301.be.fgov.ehealth.standards.kmehr.schema.v1;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.taktik.icure.be.ehealth.dto.kmehr.v20190301.be.fgov.ehealth.standards.kmehr.cd.v1.CDMESSAGE;
import org.taktik.icure.be.ehealth.dto.kmehr.v20190301.be.fgov.ehealth.standards.kmehr.cd.v1.CDSTANDARD;


/**
 * to specify the version of the kmehr specification to which this message complies
 *
 * <p>Java class for standardType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="standardType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cd" type="{http://www.ehealth.fgov.be/standards/kmehr/cd/v1}CD-STANDARD"/>
 *         &lt;element name="specialisation" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="cd" type="{http://www.ehealth.fgov.be/standards/kmehr/cd/v1}CD-MESSAGE"/>
 *                   &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "standardType", propOrder = {
    "cd",
    "specialisation"
})
public class StandardType
    implements Serializable
{

    private final static long serialVersionUID = 20190301L;
    @XmlElement(required = true)
    protected CDSTANDARD cd;
    protected StandardType.Specialisation specialisation;

    /**
     * Gets the value of the cd property.
     *
     * @return
     *     possible object is
     *     {@link CDSTANDARD }
     *
     */
    public CDSTANDARD getCd() {
        return cd;
    }

    /**
     * Sets the value of the cd property.
     *
     * @param value
     *     allowed object is
     *     {@link CDSTANDARD }
     *
     */
    public void setCd(CDSTANDARD value) {
        this.cd = value;
    }

    /**
     * Gets the value of the specialisation property.
     *
     * @return
     *     possible object is
     *     {@link StandardType.Specialisation }
     *
     */
    public StandardType.Specialisation getSpecialisation() {
        return specialisation;
    }

    /**
     * Sets the value of the specialisation property.
     *
     * @param value
     *     allowed object is
     *     {@link StandardType.Specialisation }
     *
     */
    public void setSpecialisation(StandardType.Specialisation value) {
        this.specialisation = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="cd" type="{http://www.ehealth.fgov.be/standards/kmehr/cd/v1}CD-MESSAGE"/>
     *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "cd",
        "version"
    })
    public static class Specialisation
        implements Serializable
    {

        private final static long serialVersionUID = 20190301L;
        @XmlElement(required = true)
        protected CDMESSAGE cd;
        @XmlElement(required = true)
        protected String version;

        /**
         * Gets the value of the cd property.
         *
         * @return
         *     possible object is
         *     {@link CDMESSAGE }
         *
         */
        public CDMESSAGE getCd() {
            return cd;
        }

        /**
         * Sets the value of the cd property.
         *
         * @param value
         *     allowed object is
         *     {@link CDMESSAGE }
         *
         */
        public void setCd(CDMESSAGE value) {
            this.cd = value;
        }

        /**
         * Gets the value of the version property.
         *
         * @return
         *     possible object is
         *     {@link String }
         *
         */
        public String getVersion() {
            return version;
        }

        /**
         * Sets the value of the version property.
         *
         * @param value
         *     allowed object is
         *     {@link String }
         *
         */
        public void setVersion(String value) {
            this.version = value;
        }

    }

}
