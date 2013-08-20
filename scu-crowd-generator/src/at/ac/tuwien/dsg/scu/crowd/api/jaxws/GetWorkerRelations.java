
package at.ac.tuwien.dsg.scu.crowd.api.jaxws;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getWorkerRelations", namespace = "http://api.metacrowd.scucrowd.dsg.tuwien.ac.at/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getWorkerRelations", namespace = "http://api.metacrowd.scucrowd.dsg.tuwien.ac.at/")
public class GetWorkerRelations {

    @XmlElement(name = "arg0", namespace = "")
    private ArrayList<at.ac.tuwien.dsg.scu.model.Worker> arg0;

    /**
     * 
     * @return
     *     returns ArrayList<Worker>
     */
    public ArrayList<at.ac.tuwien.dsg.scu.model.Worker> getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(ArrayList<at.ac.tuwien.dsg.scu.model.Worker> arg0) {
        this.arg0 = arg0;
    }

}
