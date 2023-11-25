package marco.bamoe9;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.StatelessKieSession;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {

        KieServices kieServices = KieServices.Factory.get();
        KieContainer kContainer = kieServices.getKieClasspathContainer();
        System.out.println("###>>> kieServices: "+kieServices+", kContainer: "+kContainer);
        System.out.println("###>>> kContainer.getKieBaseNames: "+kContainer.getKieBaseNames());

        StatelessKieSession kSession = kContainer.newStatelessKieSession("MySession");
        System.out.println("\"###>>> kSession: "+kSession);

        return "Hello from RESTEasy Reactive";
    }
}