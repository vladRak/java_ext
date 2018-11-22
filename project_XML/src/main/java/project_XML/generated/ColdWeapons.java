//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.11.22 at 12:28:10 AM EET 
//


package project_XML.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


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
 *         &lt;element name="knife" maxOccurs="unbounded">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="type">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="Knife"/>
 *                         &lt;enumeration value="Dagger"/>
 *                         &lt;enumeration value="Saber"/>
 *                         &lt;enumeration value="Sword"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="handy">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="OneHanded"/>
 *                         &lt;enumeration value="TwoHanded"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="origin">
 *                     &lt;simpleType>
 *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                         &lt;enumeration value="UA"/>
 *                         &lt;enumeration value="PL"/>
 *                         &lt;enumeration value="DE"/>
 *                       &lt;/restriction>
 *                     &lt;/simpleType>
 *                   &lt;/element>
 *                   &lt;element name="visual">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="length" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="material">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;enumeration value="Wood"/>
 *                                   &lt;enumeration value="Plastic"/>
 *                                   &lt;enumeration value="Steel"/>
 *                                   &lt;enumeration value="Cast_Iron"/>
 *                                   &lt;enumeration value="Copper"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                   &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
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
    "knife"
})
@XmlRootElement(name = "coldWeapons")
public class ColdWeapons {

    @XmlElement(required = true)
    protected List<ColdWeapons.Knife> knife;

    /**
     * Gets the value of the knife property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the knife property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getKnife().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ColdWeapons.Knife }
     * 
     * 
     */
    public List<ColdWeapons.Knife> getKnife() {
        if (knife == null) {
            knife = new ArrayList<ColdWeapons.Knife>();
        }
        return this.knife;
    }


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
     *         &lt;element name="type">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="Knife"/>
     *               &lt;enumeration value="Dagger"/>
     *               &lt;enumeration value="Saber"/>
     *               &lt;enumeration value="Sword"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="handy">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="OneHanded"/>
     *               &lt;enumeration value="TwoHanded"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="origin">
     *           &lt;simpleType>
     *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *               &lt;enumeration value="UA"/>
     *               &lt;enumeration value="PL"/>
     *               &lt;enumeration value="DE"/>
     *             &lt;/restriction>
     *           &lt;/simpleType>
     *         &lt;/element>
     *         &lt;element name="visual">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="length" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="material">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;enumeration value="Wood"/>
     *                         &lt;enumeration value="Plastic"/>
     *                         &lt;enumeration value="Steel"/>
     *                         &lt;enumeration value="Cast_Iron"/>
     *                         &lt;enumeration value="Copper"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *         &lt;element name="value" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *       &lt;/sequence>
     *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}long" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "type",
        "handy",
        "origin",
        "visual",
        "value"
    })
    public static class Knife {

        @XmlElement(required = true)
        protected String type;
        @XmlElement(required = true)
        protected String handy;
        @XmlElement(required = true)
        protected String origin;
        @XmlElement(required = true)
        protected ColdWeapons.Knife.Visual visual;
        protected boolean value;
        @XmlAttribute(name = "id", required = true)
        protected long id;

        /**
         * Gets the value of the type property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getType() {
            return type;
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setType(String value) {
            this.type = value;
        }

        /**
         * Gets the value of the handy property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getHandy() {
            return handy;
        }

        /**
         * Sets the value of the handy property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setHandy(String value) {
            this.handy = value;
        }

        /**
         * Gets the value of the origin property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getOrigin() {
            return origin;
        }

        /**
         * Sets the value of the origin property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setOrigin(String value) {
            this.origin = value;
        }

        /**
         * Gets the value of the visual property.
         * 
         * @return
         *     possible object is
         *     {@link ColdWeapons.Knife.Visual }
         *     
         */
        public ColdWeapons.Knife.Visual getVisual() {
            return visual;
        }

        /**
         * Sets the value of the visual property.
         * 
         * @param value
         *     allowed object is
         *     {@link ColdWeapons.Knife.Visual }
         *     
         */
        public void setVisual(ColdWeapons.Knife.Visual value) {
            this.visual = value;
        }

        /**
         * Gets the value of the value property.
         * 
         */
        public boolean isValue() {
            return value;
        }

        /**
         * Sets the value of the value property.
         * 
         */
        public void setValue(boolean value) {
            this.value = value;
        }

        /**
         * Gets the value of the id property.
         * 
         */
        public long getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         */
        public void setId(long value) {
            this.id = value;
        }


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
         *         &lt;element name="length" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="material">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;enumeration value="Wood"/>
         *               &lt;enumeration value="Plastic"/>
         *               &lt;enumeration value="Steel"/>
         *               &lt;enumeration value="Cast_Iron"/>
         *               &lt;enumeration value="Copper"/>
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
            "length",
            "material"
        })
        public static class Visual {

            protected int length;
            @XmlElement(required = true)
            protected String material;

            /**
             * Gets the value of the length property.
             * 
             */
            public int getLength() {
                return length;
            }

            /**
             * Sets the value of the length property.
             * 
             */
            public void setLength(int value) {
                this.length = value;
            }

            /**
             * Gets the value of the material property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getMaterial() {
                return material;
            }

            /**
             * Sets the value of the material property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setMaterial(String value) {
                this.material = value;
            }

        }

    }

}
