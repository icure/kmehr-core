/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2019.06.14 at 03:49:49 PM CEST
//


package org.taktik.icure.be.ehealth.dto.kmehr.v20100601.be.fgov.ehealth.standards.kmehr.schema.v1;

import org.taktik.icure.be.ehealth.dto.kmehr.v20100601.be.fgov.ehealth.standards.kmehr.cd.v1.LOCAL;
import org.taktik.icure.be.ehealth.dto.kmehr.v20100601.be.fgov.ehealth.standards.kmehr.id.v1.IDKMEHR;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for localitemattributeType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="localitemattributeType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.ehealth.fgov.be/standards/kmehr/id/v1}ID-KMEHR" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="cd" type="{http://www.ehealth.fgov.be/standards/kmehr/cd/v1}LOCAL"/>
 *         &lt;element name="content" type="{http://www.ehealth.fgov.be/standards/kmehr/schema/v1}contentlocalitemattributeType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "localitemattributeType", propOrder = {
        "ids",
        "cd",
        "content"
})
public class LocalitemattributeType
        implements Serializable {

    private final static long serialVersionUID = 20100601L;
    @XmlElement(name = "id", nillable = true)
    protected List<IDKMEHR> ids;
    @XmlElement(required = true, nillable = true)
    protected LOCAL cd;
    @XmlElement(required = true)
    protected ContentlocalitemattributeType content;

    /**
     * Gets the value of the ids property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ids property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIds().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IDKMEHR }
     */
    public List<IDKMEHR> getIds() {
        if (ids == null) {
            ids = new ArrayList<IDKMEHR>();
        }
        return this.ids;
    }

    /**
     * Gets the value of the cd property.
     *
     * @return possible object is
     * {@link LOCAL }
     */
    public LOCAL getCd() {
        return cd;
    }

    /**
     * Sets the value of the cd property.
     *
     * @param value allowed object is
     *              {@link LOCAL }
     */
    public void setCd(LOCAL value) {
        this.cd = value;
    }

    /**
     * Gets the value of the content property.
     *
     * @return possible object is
     * {@link ContentlocalitemattributeType }
     */
    public ContentlocalitemattributeType getContent() {
        return content;
    }

    /**
     * Sets the value of the content property.
     *
     * @param value allowed object is
     *              {@link ContentlocalitemattributeType }
     */
    public void setContent(ContentlocalitemattributeType value) {
        this.content = value;
    }

}
