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

import org.taktik.icure.be.ehealth.samws.v2.reimbursementlaw.submit.FormalInterpretationKeyType;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ConsultFormalInterpretationType complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="ConsultFormalInterpretationType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:be:fgov:ehealth:samws:v2:reimbursementlaw:submit}FormalInterpretationKeyType">
 *       &lt;sequence>
 *         &lt;element name="Rule" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ReimbursementCondition" type="{urn:be:fgov:ehealth:samws:v2:consultation}ConsultReimbursementConditionType" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="ReimbursementTerm" type="{urn:be:fgov:ehealth:samws:v2:consultation}ConsultReimbursementTermType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{urn:be:fgov:ehealth:samws:v2:consultation}validityPeriod"/>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConsultFormalInterpretationType", propOrder = {
    "rule",
    "reimbursementConditions",
    "reimbursementTerms"
})
public class ConsultFormalInterpretationType
    extends FormalInterpretationKeyType
    implements Serializable
{

    private final static long serialVersionUID = 2L;
    @XmlElement(name = "Rule", required = true)
    protected String rule;
    @XmlElement(name = "ReimbursementCondition")
    protected List<ConsultReimbursementConditionType> reimbursementConditions;
    @XmlElement(name = "ReimbursementTerm")
    protected List<ConsultReimbursementTermType> reimbursementTerms;
    @XmlAttribute(name = "StartDate", required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar startDate;
    @XmlAttribute(name = "EndDate")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar endDate;

    /**
     * Gets the value of the rule property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getRule() {
        return rule;
    }

    /**
     * Sets the value of the rule property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setRule(String value) {
        this.rule = value;
    }

    /**
     * Gets the value of the reimbursementConditions property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reimbursementConditions property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReimbursementConditions().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConsultReimbursementConditionType }
     *
     *
     */
    public List<ConsultReimbursementConditionType> getReimbursementConditions() {
        if (reimbursementConditions == null) {
            reimbursementConditions = new ArrayList<ConsultReimbursementConditionType>();
        }
        return this.reimbursementConditions;
    }

    /**
     * Gets the value of the reimbursementTerms property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reimbursementTerms property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReimbursementTerms().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ConsultReimbursementTermType }
     *
     *
     */
    public List<ConsultReimbursementTermType> getReimbursementTerms() {
        if (reimbursementTerms == null) {
            reimbursementTerms = new ArrayList<ConsultReimbursementTermType>();
        }
        return this.reimbursementTerms;
    }

    /**
     * Gets the value of the startDate property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setStartDate(XMLGregorianCalendar value) {
        this.startDate = value;
    }

    /**
     * Gets the value of the endDate property.
     *
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public XMLGregorianCalendar getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     *
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *
     */
    public void setEndDate(XMLGregorianCalendar value) {
        this.endDate = value;
    }

}
