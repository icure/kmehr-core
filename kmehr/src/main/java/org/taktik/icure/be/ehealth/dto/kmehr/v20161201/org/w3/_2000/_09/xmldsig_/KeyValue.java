/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.2.8-b130911.1802
// Voir <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source.
// Généré le : 2017.03.08 à 06:26:06 PM CET
//


package org.taktik.icure.be.ehealth.dto.kmehr.v20161201.org.w3._2000._09.xmldsig_;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;


/**
 * <p>Classe Java pour KeyValueType complex type.
 *
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 *
 * <pre>
 * &lt;complexType name="KeyValueType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}DSAKeyValue"/>
 *         &lt;element ref="{http://www.w3.org/2000/09/xmldsig#}RSAKeyValue"/>
 *         &lt;any processContents='lax' namespace='##other'/>
 *       &lt;/choice>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "KeyValueType", propOrder = {
    "content"
})
@XmlRootElement(name = "KeyValue")
public class KeyValue implements Serializable
{

    private final static long serialVersionUID = 20161201L;
    @XmlElementRefs({
        @XmlElementRef(name = "DSAKeyValue", namespace = "http://www.w3.org/2000/09/xmldsig#", type = DSAKeyValue.class, required = false),
        @XmlElementRef(name = "RSAKeyValue", namespace = "http://www.w3.org/2000/09/xmldsig#", type = RSAKeyValue.class, required = false)
    })
    @XmlMixed
    @XmlAnyElement(lax = true)
    protected List<java.lang.Object> content;

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
     * {@link DSAKeyValue }
     * {@link RSAKeyValue }
     * {@link java.lang.Object }
     * {@link Element }
     * {@link String }
     *
     *
     */
    public List<java.lang.Object> getContent() {
        if (content == null) {
            content = new ArrayList<java.lang.Object>();
        }
        return this.content;
    }

}