//
// This file was szi.model.xml.generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.06.07 at 06:50:26 PM MSK 
//


package szi.model.xml.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ThreatType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ThreatType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Possibility" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="Hazard" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="IsActual" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ThreatType", propOrder = {
    "id",
    "name",
    "possibility",
    "hazard",
    "isActual"
})
public class ThreatType {

    @XmlElement(name = "Id")
    protected int id;
    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Possibility")
    protected double possibility;
    @XmlElement(name = "Hazard")
    protected int hazard;
    @XmlElement(name = "IsActual")
    protected boolean isActual;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the possibility property.
     * 
     */
    public double getPossibility() {
        return possibility;
    }

    /**
     * Sets the value of the possibility property.
     * 
     */
    public void setPossibility(double value) {
        this.possibility = value;
    }

    /**
     * Gets the value of the hazard property.
     * 
     */
    public int getHazard() {
        return hazard;
    }

    /**
     * Sets the value of the hazard property.
     * 
     */
    public void setHazard(int value) {
        this.hazard = value;
    }

    /**
     * Gets the value of the isActual property.
     * 
     */
    public boolean isIsActual() {
        return isActual;
    }

    /**
     * Sets the value of the isActual property.
     * 
     */
    public void setIsActual(boolean value) {
        this.isActual = value;
    }

}