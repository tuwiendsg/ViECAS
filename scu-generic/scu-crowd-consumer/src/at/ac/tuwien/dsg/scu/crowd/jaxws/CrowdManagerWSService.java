
package at.ac.tuwien.dsg.scu.crowd.jaxws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "CrowdManagerWSService", targetNamespace = "http://api.crowd.scu.dsg.tuwien.ac.at/", wsdlLocation = "http://localhost:8081/CrowdManager?wsdl")
public class CrowdManagerWSService
    extends Service
{

    private final static URL CROWDMANAGERWSSERVICE_WSDL_LOCATION;
    private final static WebServiceException CROWDMANAGERWSSERVICE_EXCEPTION;
    private final static QName CROWDMANAGERWSSERVICE_QNAME = new QName("http://api.crowd.scu.dsg.tuwien.ac.at/", "CrowdManagerWSService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8081/CrowdManager?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        CROWDMANAGERWSSERVICE_WSDL_LOCATION = url;
        CROWDMANAGERWSSERVICE_EXCEPTION = e;
    }

    public CrowdManagerWSService() {
        super(__getWsdlLocation(), CROWDMANAGERWSSERVICE_QNAME);
    }

    public CrowdManagerWSService(WebServiceFeature... features) {
        super(__getWsdlLocation(), CROWDMANAGERWSSERVICE_QNAME, features);
    }

    public CrowdManagerWSService(URL wsdlLocation) {
        super(wsdlLocation, CROWDMANAGERWSSERVICE_QNAME);
    }

    public CrowdManagerWSService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, CROWDMANAGERWSSERVICE_QNAME, features);
    }

    public CrowdManagerWSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public CrowdManagerWSService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns CrowdManagerWS
     */
    @WebEndpoint(name = "CrowdManagerWSPort")
    public CrowdManagerWS getCrowdManagerWSPort() {
        return super.getPort(new QName("http://api.crowd.scu.dsg.tuwien.ac.at/", "CrowdManagerWSPort"), CrowdManagerWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns CrowdManagerWS
     */
    @WebEndpoint(name = "CrowdManagerWSPort")
    public CrowdManagerWS getCrowdManagerWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://api.crowd.scu.dsg.tuwien.ac.at/", "CrowdManagerWSPort"), CrowdManagerWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (CROWDMANAGERWSSERVICE_EXCEPTION!= null) {
            throw CROWDMANAGERWSSERVICE_EXCEPTION;
        }
        return CROWDMANAGERWSSERVICE_WSDL_LOCATION;
    }

}
