package at.ac.tuwien.dsg.scucrowd.consumer;

import javax.xml.ws.BindingProvider;

import at.ac.tuwien.dsg.scucrowd.middleware.jaxws.MiddlewareWS;
import at.ac.tuwien.dsg.scucrowd.middleware.jaxws.MiddlewareWSService;

public class APIClient {

  private static MiddlewareWS middleware;
  private static String MIDDLEWARE_ENDPOINT = "http://localhost:8080/Middleware";
  
  public static MiddlewareWS middleware() {
    if (middleware==null) {
      MiddlewareWSService service = new MiddlewareWSService();
      middleware = (MiddlewareWS) service.getMiddlewareWSPort();
      ((BindingProvider)middleware).getRequestContext().put(BindingProvider.
          ENDPOINT_ADDRESS_PROPERTY, MIDDLEWARE_ENDPOINT);
    }
    return middleware;
  }
}
