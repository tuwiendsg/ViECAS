
package at.ac.tuwien.dsg.scu.crowd.api.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getWorkerRelationsResponse", namespace = "http://api.crowd.scu.dsg.tuwien.ac.at/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getWorkerRelationsResponse", namespace = "http://api.crowd.scu.dsg.tuwien.ac.at/")
public class GetWorkerRelationsResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<at.ac.tuwien.dsg.scu.model.WorkerRelation> _return;

    /**
     * 
     * @return
     *     returns ArrayList<WorkerRelation>
     */
    public ArrayList<at.ac.tuwien.dsg.scu.model.WorkerRelation> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<at.ac.tuwien.dsg.scu.model.WorkerRelation> _return) {
        this._return = _return;
    }

}
