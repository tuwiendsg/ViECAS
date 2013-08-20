
package at.ac.tuwien.dsg.scu.crowd.api.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "assignJob", namespace = "http://api.metacrowd.scucrowd.dsg.tuwien.ac.at/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "assignJob", namespace = "http://api.metacrowd.scucrowd.dsg.tuwien.ac.at/")
public class AssignJob {

    @XmlElement(name = "arg0", namespace = "")
    private at.ac.tuwien.dsg.scu.model.JobAssignment arg0;

    /**
     * 
     * @return
     *     returns JobAssignment
     */
    public at.ac.tuwien.dsg.scu.model.JobAssignment getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(at.ac.tuwien.dsg.scu.model.JobAssignment arg0) {
        this.arg0 = arg0;
    }

}
