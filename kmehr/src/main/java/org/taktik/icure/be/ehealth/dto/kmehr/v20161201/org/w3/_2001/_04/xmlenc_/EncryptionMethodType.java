/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source.
// Généré le : 2017.03.08 à 06:26:06 PM CET
//


package org.taktik.icure.be.ehealth.dto.kmehr.v20161201.org.w3._2001._04.xmlenc_;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour EncryptionMethodType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="EncryptionMethodType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="KeySize" type="{http://www.w3.org/2001/04/xmlenc#}KeySizeType" minOccurs="0"/>
 *         &lt;element name="OAEPparams" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/>
 *         &lt;any namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Algorithm" use="required" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EncryptionMethodType", propOrder = {
    "content"
})
public class EncryptionMethodType
    implements Serializable
{

    private final static long serialVersionUID = 20161201L;
    @XmlElementRefs({
        @XmlElementRef(name = "KeySize", namespace = "http://www.w3.org/2001/04/xmlenc#", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "OAEPparams", namespace = "http://www.w3.org/2001/04/xmlenc#", type = JAXBElement.class, required = false)
    })
    @XmlMixed
    @XmlAnyElement(lax = true)
    protected List<Object> content;
    @XmlAttribute(name = "Algorithm", required = true)
    @XmlSchemaType(name = "anyURI")
    protected String algorithm;

    /**
     * Gets the value of the content property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the content property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContent().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * {@link Object }
     * {@link JAXBElement }{@code <}{@link byte[]}{@code >}
     * {@link String }
     *
     *
     */
    public List<Object> getContent() {
        if (content == null) {
            content = new ArrayList<Object>();
        }
        return this.content;
    }

    /**
     * Obtient la valeur de la propriété algorithm.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAlgorithm() {
        return algorithm;
    }

    /**
     * Définit la valeur de la propriété algorithm.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAlgorithm(String value) {
        this.algorithm = value;
    }

}
