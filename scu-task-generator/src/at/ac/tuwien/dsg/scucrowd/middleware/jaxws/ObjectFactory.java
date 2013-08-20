
package at.ac.tuwien.dsg.scucrowd.middleware.jaxws;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import at.ac.tuwien.dsg.scucrowd.model.FuzzyAptitude;
import at.ac.tuwien.dsg.scucrowd.model.FuzzyCompetence;
import at.ac.tuwien.dsg.scucrowd.model.Job;
import at.ac.tuwien.dsg.scucrowd.model.Objective;
import at.ac.tuwien.dsg.scucrowd.model.Task;
import at.ac.tuwien.dsg.scucrowd.model.TaskRequest;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the at.ac.tuwien.dsg.scucrowd.middleware.jaxws package. 
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

    private final static QName _SubmitRequest_QNAME = new QName("http://api.middleware.scucrowd.dsg.tuwien.ac.at/", "submitRequest");
    private final static QName _SubmitRequestResponse_QNAME = new QName("http://api.middleware.scucrowd.dsg.tuwien.ac.at/", "submitRequestResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: at.ac.tuwien.dsg.scucrowd.middleware.jaxws
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SubmitRequestResponse }
     * 
     */
    public SubmitRequestResponse createSubmitRequestResponse() {
        return new SubmitRequestResponse();
    }

    /**
     * Create an instance of {@link SubmitRequest }
     * 
     */
    public SubmitRequest createSubmitRequest() {
        return new SubmitRequest();
    }

    /**
     * Create an instance of {@link Objective }
     * 
     */
    public Objective createObjective() {
        return new Objective();
    }

    /**
     * Create an instance of {@link FuzzyAptitude }
     * 
     */
    public FuzzyAptitude createFuzzyAptitude() {
        return new FuzzyAptitude();
    }

    /**
     * Create an instance of {@link Task }
     * 
     */
    public Task createTask() {
        return new Task();
    }

    /**
     * Create an instance of {@link Job }
     * 
     */
    public Job createJob() {
        return new Job();
    }

    /**
     * Create an instance of {@link TaskRequest }
     * 
     */
    public TaskRequest createTaskRequest() {
        return new TaskRequest();
    }

    /**
     * Create an instance of {@link FuzzyCompetence }
     * 
     */
    public FuzzyCompetence createFuzzyCompetence() {
        return new FuzzyCompetence();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.middleware.scucrowd.dsg.tuwien.ac.at/", name = "submitRequest")
    public JAXBElement<SubmitRequest> createSubmitRequest(SubmitRequest value) {
        return new JAXBElement<SubmitRequest>(_SubmitRequest_QNAME, SubmitRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SubmitRequestResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.middleware.scucrowd.dsg.tuwien.ac.at/", name = "submitRequestResponse")
    public JAXBElement<SubmitRequestResponse> createSubmitRequestResponse(SubmitRequestResponse value) {
        return new JAXBElement<SubmitRequestResponse>(_SubmitRequestResponse_QNAME, SubmitRequestResponse.class, null, value);
    }

}
