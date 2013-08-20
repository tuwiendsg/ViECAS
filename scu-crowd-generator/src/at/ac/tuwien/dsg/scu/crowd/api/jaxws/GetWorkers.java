
package at.ac.tuwien.dsg.scu.crowd.api.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getWorkers", namespace = "http://api.crowd.scu.dsg.tuwien.ac.at/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getWorkers", namespace = "http://api.crowd.scu.dsg.tuwien.ac.at/", propOrder = {
    "arg0",
    "arg1",
    "arg2"
})
public class GetWorkers {

    @XmlElement(name = "arg0", namespace = "")
    private at.ac.tuwien.dsg.scu.model.Job arg0;
    @XmlElement(name = "arg1", namespace = "")
    private long arg1;
    @XmlElement(name = "arg2", namespace = "")
    private long arg2;

    /**
     * 
     * @return
     *     returns Job
     */
    public at.ac.tuwien.dsg.scu.model.Job getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(at.ac.tuwien.dsg.scu.model.Job arg0) {
        this.arg0 = arg0;
    }

    /**
     * 
     * @return
     *     returns long
     */
    public long getArg1() {
        return this.arg1;
    }

    /**
     * 
     * @param arg1
     *     the value for the arg1 property
     */
    public void setArg1(long arg1) {
        this.arg1 = arg1;
    }

    /**
     * 
     * @return
     *     returns long
     */
    public long getArg2() {
        return this.arg2;
    }

    /**
     * 
     * @param arg2
     *     the value for the arg2 property
     */
    public void setArg2(long arg2) {
        this.arg2 = arg2;
    }

}
