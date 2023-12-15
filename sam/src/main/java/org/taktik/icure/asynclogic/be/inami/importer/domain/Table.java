//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
// Any modifications to this file will be lost upon recompilation of the source schema.
// Generated on: 2022.05.09 at 11:14:53 AM CEST
//


package org.taktik.icure.asynclogic.be.inami.importer.domain;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;


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
 *         &lt;element ref="{}NOMEN_CODE_FEE_LIM_HIST" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "nomencodefeelimhist", "nomencodefeelim", "nomencodefeebislimhist", "nomencodefeebislim", "nomenfeecodes", "nomensummaryext", "nomenfeecodescat" })
@XmlRootElement(name = "TABLE")
public class Table {
    @XmlElement(name = "NOMEN_CODE_FEE_LIM_HIST")
    protected List<NomenCodeFeeLim> nomencodefeelimhist;

    public List<NomenCodeFeeLim> getNomenCodeFeeLimHist() {
        if (nomencodefeelimhist == null) {
            nomencodefeelimhist = new ArrayList<NomenCodeFeeLim>();
        }
        return this.nomencodefeelimhist;
    }

    @XmlElement(name = "NOMEN_CODE_FEE_LIM")
    protected List<NomenCodeFeeLim> nomencodefeelim;

    public List<NomenCodeFeeLim> getNomenCodeFeeLim() {
        if (nomencodefeelim == null) {
            nomencodefeelim = new ArrayList<NomenCodeFeeLim>();
        }
        return this.nomencodefeelim;
    }

    @XmlElement(name = "NOMEN_CODE_FEE_BIS_LIM_HIST")
    protected List<NomenCodeFeeLim> nomencodefeebislimhist;

    public List<NomenCodeFeeLim> getNomenCodeFeeBisLimHist() {
        if (nomencodefeebislimhist == null) {
            nomencodefeebislimhist = new ArrayList<NomenCodeFeeLim>();
        }
        return this.nomencodefeebislimhist;
    }

    @XmlElement(name = "NOMEN_CODE_FEE_BIS_LIM")
    protected List<NomenCodeFeeLim> nomencodefeebislim;

    public List<NomenCodeFeeLim> getNomenCodeFeeBisLim() {
        if (nomencodefeebislim == null) {
            nomencodefeebislim = new ArrayList<NomenCodeFeeLim>();
        }
        return this.nomencodefeebislim;
    }

    @XmlElement(name = "NOMEN_FEECODES")
    protected List<NomenFeeCodes> nomenfeecodes;

    public List<NomenFeeCodes> getNomenFeeCodes() {
        if (nomenfeecodes == null) {
            nomenfeecodes = new ArrayList<NomenFeeCodes>();
        }
        return this.nomenfeecodes;
    }

    @XmlElement(name = "NOMEN_SUMMARY_EXT")
    protected List<NomenSummaryExt> nomensummaryext;

    public List<NomenSummaryExt> getNomenSummaryExt() {
        if (nomensummaryext == null) {
            nomensummaryext = new ArrayList<NomenSummaryExt>();
        }
        return this.nomensummaryext;
    }

	@XmlElement(name = "NOMEN_FEECODES_CAT")
	protected List<NomenFeeCodesCat> nomenfeecodescat;

	public List<NomenFeeCodesCat> getNomenFeeCodesCat() {
		if (nomenfeecodescat == null) {
			nomenfeecodescat = new ArrayList<NomenFeeCodesCat>();
		}
		return this.nomenfeecodescat;
	}

}
