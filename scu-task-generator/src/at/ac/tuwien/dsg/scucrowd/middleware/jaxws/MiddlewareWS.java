
package at.ac.tuwien.dsg.scucrowd.middleware.jaxws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import at.ac.tuwien.dsg.scucrowd.model.TaskRequest;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "MiddlewareWS", targetNamespace = "http://api.middleware.scucrowd.dsg.tuwien.ac.at/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface MiddlewareWS {


    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "submitRequest", targetNamespace = "http://api.middleware.scucrowd.dsg.tuwien.ac.at/", className = "at.ac.tuwien.dsg.scucrowd.middleware.jaxws.SubmitRequest")
    @ResponseWrapper(localName = "submitRequestResponse", targetNamespace = "http://api.middleware.scucrowd.dsg.tuwien.ac.at/", className = "at.ac.tuwien.dsg.scucrowd.middleware.jaxws.SubmitRequestResponse")
    @Action(input = "http://api.middleware.scucrowd.dsg.tuwien.ac.at/MiddlewareWS/submitRequestRequest", output = "http://api.middleware.scucrowd.dsg.tuwien.ac.at/MiddlewareWS/submitRequestResponse")
    public String submitRequest(
        @WebParam(name = "arg0", targetNamespace = "")
        TaskRequest arg0);

}
