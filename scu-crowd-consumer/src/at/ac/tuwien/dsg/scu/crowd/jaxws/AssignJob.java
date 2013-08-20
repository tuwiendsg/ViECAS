
package at.ac.tuwien.dsg.scu.crowd.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import at.ac.tuwien.dsg.scu.model.JobAssignment;


/**
 * <p>Java class for assignJob complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="assignJob">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://api.crowd.scu.dsg.tuwien.ac.at/}jobAssignment" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "assignJob", propOrder = {
    "arg0"
})
public class AssignJob {

    protected JobAssignment arg0;

    /**
     * Gets the value of the arg0 property.
     * 
     * @return
     *     possible object is
     *     {@link JobAssignment }
     *     
     */
    public JobAssignment getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     * 
     * @param value
     *     allowed object is
     *     {@link JobAssignment }
     *     
     */
    public void setArg0(JobAssignment value) {
        this.arg0 = value;
    }

}
