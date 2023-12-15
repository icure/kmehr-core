//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2022.09.23 at 05:24:00 PM CEST
//


package org.taktik.icure.asynclogic.be.inami.importer.domain;

import javax.xml.bind.annotation.*;


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
 *         &lt;element name="fee_code_cat" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="2"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="fee_code_cat_desc_nl" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="65"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="fee_code_cat_desc_fr" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="65"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
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
@XmlType(name = "", propOrder = {
    "feeCodeCat",
    "feeCodeCatDescNl",
    "feeCodeCatDescFr"
})
@XmlRootElement(name = "NOMEN_FEECODES_CAT")
public class NomenFeeCodesCat {

    @XmlElement(name = "fee_code_cat")
    protected String feeCodeCat;
    @XmlElement(name = "fee_code_cat_desc_nl")
    protected String feeCodeCatDescNl;
    @XmlElement(name = "fee_code_cat_desc_fr")
    protected String feeCodeCatDescFr;

    /**
     * Gets the value of the feeCodeCat property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFeeCodeCat() {
        return feeCodeCat;
    }

    /**
     * Sets the value of the feeCodeCat property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFeeCodeCat(String value) {
        this.feeCodeCat = value;
    }

    /**
     * Gets the value of the feeCodeCatDescNl property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFeeCodeCatDescNl() {
        return feeCodeCatDescNl;
    }

    /**
     * Sets the value of the feeCodeCatDescNl property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFeeCodeCatDescNl(String value) {
        this.feeCodeCatDescNl = value;
    }

    /**
     * Gets the value of the feeCodeCatDescFr property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFeeCodeCatDescFr() {
        return feeCodeCatDescFr;
    }

    /**
     * Sets the value of the feeCodeCatDescFr property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFeeCodeCatDescFr(String value) {
        this.feeCodeCatDescFr = value;
    }

}