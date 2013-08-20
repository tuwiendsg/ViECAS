
package at.ac.tuwien.dsg.scu.crowd.jaxws;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

import at.ac.tuwien.dsg.scu.model.JobAssignment;


/**
 * <p>Java class for assignJobBatch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="assignJobBatch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="arg0" type="{http://api.crowd.scu.dsg.tuwien.ac.at/}jobAssignment" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "assignJobBatch", propOrder = {
    "arg0"
})
public class AssignJobBatch {

    protected List<JobAssignment> arg0;

    /**
     * Gets the value of the arg0 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the arg0 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getArg0().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JobAssignment }
     * 
     * 
     */
    public List<JobAssignment> getArg0() {
        if (arg0 == null) {
            arg0 = new ArrayList<JobAssignment>();
        }
        return this.arg0;
    }

}
