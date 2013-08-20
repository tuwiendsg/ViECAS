
package at.ac.tuwien.dsg.scu.crowd.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import at.ac.tuwien.dsg.scu.model.Job;
import at.ac.tuwien.dsg.scu.model.Worker;


/**
 * <p>Java class for getResponseTime complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getResponseTime">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://api.crowd.scu.dsg.tuwien.ac.at/}worker" minOccurs="0"/>
 *         &lt;element name="arg1" type="{http://api.crowd.scu.dsg.tuwien.ac.at/}job" minOccurs="0"/>
 *         &lt;element name="arg2" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getResponseTime", propOrder = {
    "arg0",
    "arg1",
    "arg2"
})
public class GetResponseTime {

    protected Worker arg0;
    protected Job arg1;
    protected long arg2;

    /**
     * Gets the value of the arg0 property.
     * 
     * @return
     *     possible object is
     *     {@link Worker }
     *     
     */
    public Worker getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Worker }
     *     
     */
    public void setArg0(Worker value) {
        this.arg0 = value;
    }

    /**
     * Gets the value of the arg1 property.
     * 
     * @return
     *     possible object is
     *     {@link Job }
     *     
     */
    public Job getArg1() {
        return arg1;
    }

    /**
     * Sets the value of the arg1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link Job }
     *     
     */
    public void setArg1(Job value) {
        this.arg1 = value;
    }

    /**
     * Gets the value of the arg2 property.
     * 
     */
    public long getArg2() {
        return arg2;
    }

    /**
     * Sets the value of the arg2 property.
     * 
     */
    public void setArg2(long value) {
        this.arg2 = value;
    }

}
