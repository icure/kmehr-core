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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour CipherDataType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="CipherDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element name="CipherValue" type="{http://www.w3.org/2001/XMLSchema}base64Binary"/>
 *         &lt;element ref="{http://www.w3.org/2001/04/xmlenc#}CipherReference"/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CipherDataType", propOrder = {
    "cipherReference",
    "cipherValue"
})
@XmlRootElement(name = "CipherData")
public class CipherData
    implements Serializable
{

    private final static long serialVersionUID = 20161201L;
    @XmlElement(name = "CipherReference")
    protected CipherReference cipherReference;
    @XmlElement(name = "CipherValue")
    protected byte[] cipherValue;

    /**
     * Obtient la valeur de la propriété cipherReference.
     *
     * @return
     *     possible object is
     *     {@link CipherReference }
     *
     */
    public CipherReference getCipherReference() {
        return cipherReference;
    }

    /**
     * Définit la valeur de la propriété cipherReference.
     *
     * @param value
     *     allowed object is
     *     {@link CipherReference }
     *
     */
    public void setCipherReference(CipherReference value) {
        this.cipherReference = value;
    }

    /**
     * Obtient la valeur de la propriété cipherValue.
     *
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getCipherValue() {
        return cipherValue;
    }

    /**
     * Définit la valeur de la propriété cipherValue.
     *
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setCipherValue(byte[] value) {
        this.cipherValue = value;
    }

}
