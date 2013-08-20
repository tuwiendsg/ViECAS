
package at.ac.tuwien.dsg.scu.crowd.api.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "assignJobBatch", namespace = "http://api.metacrowd.scucrowd.dsg.tuwien.ac.at/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "assignJobBatch", namespace = "http://api.metacrowd.scucrowd.dsg.tuwien.ac.at/")
public class AssignJobBatch {

    @XmlElement(name = "arg0", namespace = "")
    private List<at.ac.tuwien.dsg.scu.model.JobAssignment> arg0;

    /**
     * 
     * @return
     *     returns List<JobAssignment>
     */
    public List<at.ac.tuwien.dsg.scu.model.JobAssignment> getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(List<at.ac.tuwien.dsg.scu.model.JobAssignment> arg0) {
        this.arg0 = arg0;
    }

}
