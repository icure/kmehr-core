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

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for SetBcpiReferencesRequestType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SetBcpiReferencesRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;group ref="{urn:be:fgov:ehealth:samws:v2:refdata}SetBcpiMainEntities"/>
 *         &lt;group ref="{urn:be:fgov:ehealth:samws:v2:refdata}SetBcpiAdditionalEntities"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SetBcpiReferencesRequestType", propOrder = {
    "noSwitchReasons",
    "virtualForms",
    "wadas",
    "noGenericPrescriptionReasons",
    "standardForms",
    "standardRoutes",
    "standardSubstances"
})
@XmlRootElement(name = "SetBcpiReferencesRequest")
public class SetBcpiReferencesRequest
    implements Serializable
{

    private final static long serialVersionUID = 2L;
    @XmlElement(name = "NoSwitchReason")
    protected List<NoSwitchReasonType> noSwitchReasons;
    @XmlElement(name = "VirtualForm")
    protected List<VirtualFormType> virtualForms;
    @XmlElement(name = "Wada")
    protected List<WadaType> wadas;
    @XmlElement(name = "NoGenericPrescriptionReason")
    protected List<NoGenericPrescriptionReasonType> noGenericPrescriptionReasons;
    @XmlElement(name = "StandardForm")
    protected List<StandardFormBcpiType> standardForms;
    @XmlElement(name = "StandardRoute")
    protected List<StandardRouteBcpiType> standardRoutes;
    @XmlElement(name = "StandardSubstance")
    protected List<StandardSubstanceBcpiType> standardSubstances;

    /**
     * Gets the value of the noSwitchReasons property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the noSwitchReasons property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNoSwitchReasons().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NoSwitchReasonType }
     *
     *
     */
    public List<NoSwitchReasonType> getNoSwitchReasons() {
        if (noSwitchReasons == null) {
            noSwitchReasons = new ArrayList<NoSwitchReasonType>();
        }
        return this.noSwitchReasons;
    }

    /**
     * Gets the value of the virtualForms property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the virtualForms property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVirtualForms().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualFormType }
     *
     *
     */
    public List<VirtualFormType> getVirtualForms() {
        if (virtualForms == null) {
            virtualForms = new ArrayList<VirtualFormType>();
        }
        return this.virtualForms;
    }

    /**
     * Gets the value of the wadas property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wadas property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWadas().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WadaType }
     *
     *
     */
    public List<WadaType> getWadas() {
        if (wadas == null) {
            wadas = new ArrayList<WadaType>();
        }
        return this.wadas;
    }

    /**
     * Gets the value of the noGenericPrescriptionReasons property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the noGenericPrescriptionReasons property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNoGenericPrescriptionReasons().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NoGenericPrescriptionReasonType }
     *
     *
     */
    public List<NoGenericPrescriptionReasonType> getNoGenericPrescriptionReasons() {
        if (noGenericPrescriptionReasons == null) {
            noGenericPrescriptionReasons = new ArrayList<NoGenericPrescriptionReasonType>();
        }
        return this.noGenericPrescriptionReasons;
    }

    /**
     * Gets the value of the standardForms property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the standardForms property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStandardForms().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StandardFormBcpiType }
     *
     *
     */
    public List<StandardFormBcpiType> getStandardForms() {
        if (standardForms == null) {
            standardForms = new ArrayList<StandardFormBcpiType>();
        }
        return this.standardForms;
    }

    /**
     * Gets the value of the standardRoutes property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the standardRoutes property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStandardRoutes().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StandardRouteBcpiType }
     *
     *
     */
    public List<StandardRouteBcpiType> getStandardRoutes() {
        if (standardRoutes == null) {
            standardRoutes = new ArrayList<StandardRouteBcpiType>();
        }
        return this.standardRoutes;
    }

    /**
     * Gets the value of the standardSubstances property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the standardSubstances property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStandardSubstances().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StandardSubstanceBcpiType }
     *
     *
     */
    public List<StandardSubstanceBcpiType> getStandardSubstances() {
        if (standardSubstances == null) {
            standardSubstances = new ArrayList<StandardSubstanceBcpiType>();
        }
        return this.standardSubstances;
    }

}