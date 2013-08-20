
package at.ac.tuwien.dsg.scu.crowd.api.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getWorkersResponse", namespace = "http://api.metacrowd.scucrowd.dsg.tuwien.ac.at/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getWorkersResponse", namespace = "http://api.metacrowd.scucrowd.dsg.tuwien.ac.at/")
public class GetWorkersResponse {

    @XmlElement(name = "return", namespace = "")
    private ArrayList<at.ac.tuwien.dsg.scu.model.Worker> _return;

    /**
     * 
     * @return
     *     returns ArrayList<Worker>
     */
    public ArrayList<at.ac.tuwien.dsg.scu.model.Worker> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(ArrayList<at.ac.tuwien.dsg.scu.model.Worker> _return) {
        this._return = _return;
    }

}
