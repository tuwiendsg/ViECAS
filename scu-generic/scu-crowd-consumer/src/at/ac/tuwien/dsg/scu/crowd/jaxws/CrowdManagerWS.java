
package at.ac.tuwien.dsg.scu.crowd.jaxws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import at.ac.tuwien.dsg.scu.model.Job;
import at.ac.tuwien.dsg.scu.model.JobAssignment;
import at.ac.tuwien.dsg.scu.model.Worker;
import at.ac.tuwien.dsg.scu.model.WorkerRelation;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "CrowdManagerWS", targetNamespace = "http://api.crowd.scu.dsg.tuwien.ac.at/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface CrowdManagerWS {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<at.ac.tuwien.dsg.scu.crowd.jaxws.WorkerRelation>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getWorkerRelations", targetNamespace = "http://api.crowd.scu.dsg.tuwien.ac.at/", className = "at.ac.tuwien.dsg.scu.crowd.jaxws.GetWorkerRelations")
    @ResponseWrapper(localName = "getWorkerRelationsResponse", targetNamespace = "http://api.crowd.scu.dsg.tuwien.ac.at/", className = "at.ac.tuwien.dsg.scu.crowd.jaxws.GetWorkerRelationsResponse")
    @Action(input = "http://api.crowd.scu.dsg.tuwien.ac.at/CrowdManagerWS/getWorkerRelationsRequest", output = "http://api.crowd.scu.dsg.tuwien.ac.at/CrowdManagerWS/getWorkerRelationsResponse")
    public List<WorkerRelation> getWorkerRelations(
        @WebParam(name = "arg0", targetNamespace = "")
        List<Worker> arg0);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns int
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getResponseTime", targetNamespace = "http://api.crowd.scu.dsg.tuwien.ac.at/", className = "at.ac.tuwien.dsg.scu.crowd.jaxws.GetResponseTime")
    @ResponseWrapper(localName = "getResponseTimeResponse", targetNamespace = "http://api.crowd.scu.dsg.tuwien.ac.at/", className = "at.ac.tuwien.dsg.scu.crowd.jaxws.GetResponseTimeResponse")
    @Action(input = "http://api.crowd.scu.dsg.tuwien.ac.at/CrowdManagerWS/getResponseTimeRequest", output = "http://api.crowd.scu.dsg.tuwien.ac.at/CrowdManagerWS/getResponseTimeResponse")
    public int getResponseTime(
        @WebParam(name = "arg0", targetNamespace = "")
        Worker arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        Job arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        long arg2);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<at.ac.tuwien.dsg.scu.crowd.jaxws.Worker>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getWorkers", targetNamespace = "http://api.crowd.scu.dsg.tuwien.ac.at/", className = "at.ac.tuwien.dsg.scu.crowd.jaxws.GetWorkers")
    @ResponseWrapper(localName = "getWorkersResponse", targetNamespace = "http://api.crowd.scu.dsg.tuwien.ac.at/", className = "at.ac.tuwien.dsg.scu.crowd.jaxws.GetWorkersResponse")
    @Action(input = "http://api.crowd.scu.dsg.tuwien.ac.at/CrowdManagerWS/getWorkersRequest", output = "http://api.crowd.scu.dsg.tuwien.ac.at/CrowdManagerWS/getWorkersResponse")
    public List<Worker> getWorkers(
        @WebParam(name = "arg0", targetNamespace = "")
        Job arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        long arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        long arg2);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "assignJob", targetNamespace = "http://api.crowd.scu.dsg.tuwien.ac.at/", className = "at.ac.tuwien.dsg.scu.crowd.jaxws.AssignJob")
    @ResponseWrapper(localName = "assignJobResponse", targetNamespace = "http://api.crowd.scu.dsg.tuwien.ac.at/", className = "at.ac.tuwien.dsg.scu.crowd.jaxws.AssignJobResponse")
    @Action(input = "http://api.crowd.scu.dsg.tuwien.ac.at/CrowdManagerWS/assignJobRequest", output = "http://api.crowd.scu.dsg.tuwien.ac.at/CrowdManagerWS/assignJobResponse")
    public boolean assignJob(
        @WebParam(name = "arg0", targetNamespace = "")
        JobAssignment arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns boolean
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "assignJobBatch", targetNamespace = "http://api.crowd.scu.dsg.tuwien.ac.at/", className = "at.ac.tuwien.dsg.scu.crowd.jaxws.AssignJobBatch")
    @ResponseWrapper(localName = "assignJobBatchResponse", targetNamespace = "http://api.crowd.scu.dsg.tuwien.ac.at/", className = "at.ac.tuwien.dsg.scu.crowd.jaxws.AssignJobBatchResponse")
    @Action(input = "http://api.crowd.scu.dsg.tuwien.ac.at/CrowdManagerWS/assignJobBatchRequest", output = "http://api.crowd.scu.dsg.tuwien.ac.at/CrowdManagerWS/assignJobBatchResponse")
    public boolean assignJobBatch(
        @WebParam(name = "arg0", targetNamespace = "")
        List<JobAssignment> arg0);

}
