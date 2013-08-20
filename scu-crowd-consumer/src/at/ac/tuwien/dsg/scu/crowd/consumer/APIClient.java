package at.ac.tuwien.dsg.scu.crowd.consumer;

import javax.xml.ws.BindingProvider;

import at.ac.tuwien.dsg.scu.common.Util;
import at.ac.tuwien.dsg.scu.crowd.jaxws.CrowdManagerWS;
import at.ac.tuwien.dsg.scu.crowd.jaxws.CrowdManagerWSService;

public class APIClient {

  private static CrowdManagerWS crowdManager;
  
  public static CrowdManagerWS crowdManager() {
    if (crowdManager==null) {
      String crowdManagerEndpointURL = Util.getProperty(Consumer.PROP_FILE, "crowdmanager_endpoint");
      CrowdManagerWSService service = new CrowdManagerWSService();
      crowdManager = (CrowdManagerWS) service.getCrowdManagerWSPort();
      ((BindingProvider)crowdManager).getRequestContext().put(BindingProvider.
          ENDPOINT_ADDRESS_PROPERTY, crowdManagerEndpointURL);
    }
    return crowdManager;
  }
}
