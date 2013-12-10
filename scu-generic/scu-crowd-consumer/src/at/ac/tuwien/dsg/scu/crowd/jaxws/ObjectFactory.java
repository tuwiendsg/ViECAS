
package at.ac.tuwien.dsg.scu.crowd.jaxws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import at.ac.tuwien.dsg.scu.model.Aptitude;
import at.ac.tuwien.dsg.scu.model.Competence;
import at.ac.tuwien.dsg.scu.model.FuzzyAptitude;
import at.ac.tuwien.dsg.scu.model.FuzzyCompetence;
import at.ac.tuwien.dsg.scu.model.Job;
import at.ac.tuwien.dsg.scu.model.JobAssignment;
import at.ac.tuwien.dsg.scu.model.Queue;
import at.ac.tuwien.dsg.scu.model.Worker;
import at.ac.tuwien.dsg.scu.model.WorkerRelation;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the at.ac.tuwien.dsg.scu.crowd.jaxws package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetWorkers_QNAME = new QName("http://api.crowd.scu.dsg.tuwien.ac.at/", "getWorkers");
    private final static QName _AssignJobBatch_QNAME = new QName("http://api.crowd.scu.dsg.tuwien.ac.at/", "assignJobBatch");
    private final static QName _AssignJobBatchResponse_QNAME = new QName("http://api.crowd.scu.dsg.tuwien.ac.at/", "assignJobBatchResponse");
    private final static QName _GetResponseTime_QNAME = new QName("http://api.crowd.scu.dsg.tuwien.ac.at/", "getResponseTime");
    private final static QName _GetWorkersResponse_QNAME = new QName("http://api.crowd.scu.dsg.tuwien.ac.at/", "getWorkersResponse");
    private final static QName _GetWorkerRelationsResponse_QNAME = new QName("http://api.crowd.scu.dsg.tuwien.ac.at/", "getWorkerRelationsResponse");
    private final static QName _GetWorkerRelations_QNAME = new QName("http://api.crowd.scu.dsg.tuwien.ac.at/", "getWorkerRelations");
    private final static QName _AssignJob_QNAME = new QName("http://api.crowd.scu.dsg.tuwien.ac.at/", "assignJob");
    private final static QName _AssignJobResponse_QNAME = new QName("http://api.crowd.scu.dsg.tuwien.ac.at/", "assignJobResponse");
    private final static QName _GetResponseTimeResponse_QNAME = new QName("http://api.crowd.scu.dsg.tuwien.ac.at/", "getResponseTimeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: at.ac.tuwien.dsg.scu.crowd.jaxws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AssignJob }
     * 
     */
    public AssignJob createAssignJob() {
        return new AssignJob();
    }

    /**
     * Create an instance of {@link GetResponseTimeResponse }
     * 
     */
    public GetResponseTimeResponse createGetResponseTimeResponse() {
        return new GetResponseTimeResponse();
    }

    /**
     * Create an instance of {@link AssignJobResponse }
     * 
     */
    public AssignJobResponse createAssignJobResponse() {
        return new AssignJobResponse();
    }

    /**
     * Create an instance of {@link GetWorkerRelationsResponse }
     * 
     */
    public GetWorkerRelationsResponse createGetWorkerRelationsResponse() {
        return new GetWorkerRelationsResponse();
    }

    /**
     * Create an instance of {@link GetWorkerRelations }
     * 
     */
    public GetWorkerRelations createGetWorkerRelations() {
        return new GetWorkerRelations();
    }

    /**
     * Create an instance of {@link GetWorkersResponse }
     * 
     */
    public GetWorkersResponse createGetWorkersResponse() {
        return new GetWorkersResponse();
    }

    /**
     * Create an instance of {@link GetResponseTime }
     * 
     */
    public GetResponseTime createGetResponseTime() {
        return new GetResponseTime();
    }

    /**
     * Create an instance of {@link AssignJobBatchResponse }
     * 
     */
    public AssignJobBatchResponse createAssignJobBatchResponse() {
        return new AssignJobBatchResponse();
    }

    /**
     * Create an instance of {@link AssignJobBatch }
     * 
     */
    public AssignJobBatch createAssignJobBatch() {
        return new AssignJobBatch();
    }

    /**
     * Create an instance of {@link GetWorkers }
     * 
     */
    public GetWorkers createGetWorkers() {
        return new GetWorkers();
    }

    /**
     * Create an instance of {@link Queue }
     * 
     */
    public Queue createQueue() {
        return new Queue();
    }

    /**
     * Create an instance of {@link Job }
     * 
     */
    public Job createJob() {
        return new Job();
    }

    /**
     * Create an instance of {@link WorkerRelation }
     * 
     */
    public WorkerRelation createWorkerRelation() {
        return new WorkerRelation();
    }

    /**
     * Create an instance of {@link FuzzyCompetence }
     * 
     */
    public FuzzyCompetence createFuzzyCompetence() {
        return new FuzzyCompetence();
    }

    /**
     * Create an instance of {@link FuzzyAptitude }
     * 
     */
    public FuzzyAptitude createFuzzyAptitude() {
        return new FuzzyAptitude();
    }

    /**
     * Create an instance of {@link JobAssignment }
     * 
     */
    public JobAssignment createJobAssignment() {
        return new JobAssignment();
    }

    /**
     * Create an instance of {@link Worker }
     * 
     */
    public Worker createWorker() {
        return new Worker();
    }

    /**
     * Create an instance of {@link Aptitude }
     * 
     */
    public Aptitude createAptitude() {
        return new Aptitude();
    }

    /**
     * Create an instance of {@link Competence }
     * 
     */
    public Competence createCompetence() {
        return new Competence();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWorkers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.crowd.scu.dsg.tuwien.ac.at/", name = "getWorkers")
    public JAXBElement<GetWorkers> createGetWorkers(GetWorkers value) {
        return new JAXBElement<GetWorkers>(_GetWorkers_QNAME, GetWorkers.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssignJobBatch }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.crowd.scu.dsg.tuwien.ac.at/", name = "assignJobBatch")
    public JAXBElement<AssignJobBatch> createAssignJobBatch(AssignJobBatch value) {
        return new JAXBElement<AssignJobBatch>(_AssignJobBatch_QNAME, AssignJobBatch.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssignJobBatchResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.crowd.scu.dsg.tuwien.ac.at/", name = "assignJobBatchResponse")
    public JAXBElement<AssignJobBatchResponse> createAssignJobBatchResponse(AssignJobBatchResponse value) {
        return new JAXBElement<AssignJobBatchResponse>(_AssignJobBatchResponse_QNAME, AssignJobBatchResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetResponseTime }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.crowd.scu.dsg.tuwien.ac.at/", name = "getResponseTime")
    public JAXBElement<GetResponseTime> createGetResponseTime(GetResponseTime value) {
        return new JAXBElement<GetResponseTime>(_GetResponseTime_QNAME, GetResponseTime.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWorkersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.crowd.scu.dsg.tuwien.ac.at/", name = "getWorkersResponse")
    public JAXBElement<GetWorkersResponse> createGetWorkersResponse(GetWorkersResponse value) {
        return new JAXBElement<GetWorkersResponse>(_GetWorkersResponse_QNAME, GetWorkersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWorkerRelationsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.crowd.scu.dsg.tuwien.ac.at/", name = "getWorkerRelationsResponse")
    public JAXBElement<GetWorkerRelationsResponse> createGetWorkerRelationsResponse(GetWorkerRelationsResponse value) {
        return new JAXBElement<GetWorkerRelationsResponse>(_GetWorkerRelationsResponse_QNAME, GetWorkerRelationsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetWorkerRelations }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.crowd.scu.dsg.tuwien.ac.at/", name = "getWorkerRelations")
    public JAXBElement<GetWorkerRelations> createGetWorkerRelations(GetWorkerRelations value) {
        return new JAXBElement<GetWorkerRelations>(_GetWorkerRelations_QNAME, GetWorkerRelations.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssignJob }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.crowd.scu.dsg.tuwien.ac.at/", name = "assignJob")
    public JAXBElement<AssignJob> createAssignJob(AssignJob value) {
        return new JAXBElement<AssignJob>(_AssignJob_QNAME, AssignJob.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AssignJobResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.crowd.scu.dsg.tuwien.ac.at/", name = "assignJobResponse")
    public JAXBElement<AssignJobResponse> createAssignJobResponse(AssignJobResponse value) {
        return new JAXBElement<AssignJobResponse>(_AssignJobResponse_QNAME, AssignJobResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetResponseTimeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.crowd.scu.dsg.tuwien.ac.at/", name = "getResponseTimeResponse")
    public JAXBElement<GetResponseTimeResponse> createGetResponseTimeResponse(GetResponseTimeResponse value) {
        return new JAXBElement<GetResponseTimeResponse>(_GetResponseTimeResponse_QNAME, GetResponseTimeResponse.class, null, value);
    }

}
