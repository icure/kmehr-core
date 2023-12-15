/*
 * Copyright (c) 2020. Taktik SA, All rights reserved.
 */

//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2020.10.15 at 03:32:18 PM CEST
//


package org.taktik.icure.be.samv2v5.entities;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
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
@XmlType(name = "SetBcpiReferencesRequestType", namespace = "urn:be:fgov:ehealth:samws:v2:refdata", propOrder = {
    "noSwitchReason",
    "virtualForm",
    "wada",
    "noGenericPrescriptionReason",
    "indication",
    "dosageParameter",
    "standardForm",
    "standardRoute",
    "standardSubstance"
})
public class SetBcpiReferencesRequestType {

    @XmlElement(name = "NoSwitchReason", namespace = "urn:be:fgov:ehealth:samws:v2:refdata")
    protected List<NoSwitchReasonType> noSwitchReason;
    @XmlElement(name = "VirtualForm", namespace = "urn:be:fgov:ehealth:samws:v2:refdata")
    protected List<VirtualFormType> virtualForm;
    @XmlElement(name = "Wada", namespace = "urn:be:fgov:ehealth:samws:v2:refdata")
    protected List<WadaType> wada;
    @XmlElement(name = "NoGenericPrescriptionReason", namespace = "urn:be:fgov:ehealth:samws:v2:refdata")
    protected List<NoGenericPrescriptionReasonType> noGenericPrescriptionReason;
    @XmlElement(name = "Indication", namespace = "urn:be:fgov:ehealth:samws:v2:refdata")
    protected List<IndicationType> indication;
    @XmlElement(name = "DosageParameter", namespace = "urn:be:fgov:ehealth:samws:v2:refdata")
    protected List<DosageParameterType> dosageParameter;
    @XmlElement(name = "StandardForm", namespace = "urn:be:fgov:ehealth:samws:v2:refdata")
    protected List<StandardFormBcpiType> standardForm;
    @XmlElement(name = "StandardRoute", namespace = "urn:be:fgov:ehealth:samws:v2:refdata")
    protected List<StandardRouteBcpiType> standardRoute;
    @XmlElement(name = "StandardSubstance", namespace = "urn:be:fgov:ehealth:samws:v2:refdata")
    protected List<StandardSubstanceBcpiType> standardSubstance;

    /**
     * Gets the value of the noSwitchReason property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the noSwitchReason property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNoSwitchReason().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NoSwitchReasonType }
     *
     *
     */
    public List<NoSwitchReasonType> getNoSwitchReason() {
        if (noSwitchReason == null) {
            noSwitchReason = new ArrayList<NoSwitchReasonType>();
        }
        return this.noSwitchReason;
    }

    /**
     * Gets the value of the virtualForm property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the virtualForm property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getVirtualForm().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link VirtualFormType }
     *
     *
     */
    public List<VirtualFormType> getVirtualForm() {
        if (virtualForm == null) {
            virtualForm = new ArrayList<VirtualFormType>();
        }
        return this.virtualForm;
    }

    /**
     * Gets the value of the wada property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wada property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWada().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WadaType }
     *
     *
     */
    public List<WadaType> getWada() {
        if (wada == null) {
            wada = new ArrayList<WadaType>();
        }
        return this.wada;
    }

    /**
     * Gets the value of the noGenericPrescriptionReason property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the noGenericPrescriptionReason property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNoGenericPrescriptionReason().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NoGenericPrescriptionReasonType }
     *
     *
     */
    public List<NoGenericPrescriptionReasonType> getNoGenericPrescriptionReason() {
        if (noGenericPrescriptionReason == null) {
            noGenericPrescriptionReason = new ArrayList<NoGenericPrescriptionReasonType>();
        }
        return this.noGenericPrescriptionReason;
    }

    /**
     * Gets the value of the indication property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the indication property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIndication().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IndicationType }
     *
     *
     */
    public List<IndicationType> getIndication() {
        if (indication == null) {
            indication = new ArrayList<IndicationType>();
        }
        return this.indication;
    }

    /**
     * Gets the value of the dosageParameter property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dosageParameter property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDosageParameter().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DosageParameterType }
     *
     *
     */
    public List<DosageParameterType> getDosageParameter() {
        if (dosageParameter == null) {
            dosageParameter = new ArrayList<DosageParameterType>();
        }
        return this.dosageParameter;
    }

    /**
     * Gets the value of the standardForm property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the standardForm property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStandardForm().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StandardFormBcpiType }
     *
     *
     */
    public List<StandardFormBcpiType> getStandardForm() {
        if (standardForm == null) {
            standardForm = new ArrayList<StandardFormBcpiType>();
        }
        return this.standardForm;
    }

    /**
     * Gets the value of the standardRoute property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the standardRoute property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStandardRoute().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StandardRouteBcpiType }
     *
     *
     */
    public List<StandardRouteBcpiType> getStandardRoute() {
        if (standardRoute == null) {
            standardRoute = new ArrayList<StandardRouteBcpiType>();
        }
        return this.standardRoute;
    }

    /**
     * Gets the value of the standardSubstance property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the standardSubstance property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStandardSubstance().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StandardSubstanceBcpiType }
     *
     *
     */
    public List<StandardSubstanceBcpiType> getStandardSubstance() {
        if (standardSubstance == null) {
            standardSubstance = new ArrayList<StandardSubstanceBcpiType>();
        }
        return this.standardSubstance;
    }

}
