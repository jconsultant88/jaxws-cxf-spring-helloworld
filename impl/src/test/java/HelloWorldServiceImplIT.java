import net.bluetechnolgies.services.impl.HelloWorldServiceImpl;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import net.bluetechnolgies.services.helloworld.HelloWorldService;
import net.bluetechnolgies.services.helloworld.Person;

/**
 * Created by vemulav on 14/03/2016.
 */
public class HelloWorldServiceImplIT {

	private final String END_POINT = "http://localhost:8080/bluetechnolgies/services/helloworld";

	@Test
	public void testClient() {
		startServer();

		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		//register WebService interface
		factory.setServiceClass(HelloWorldService.class);
		//set webservice publish address to factory.
		factory.setAddress(END_POINT);
		HelloWorldService helloWorldService = (HelloWorldService) factory.create();
		Person person = new Person();
		person.setFirstName("Roger");
		person.setLastName("Federer");

		assertEquals("Hello " + person.getFirstName() + " " + person.getLastName(),  helloWorldService.hello(person));
	}

	private void startServer() {
		HelloWorldService helloWorld = new HelloWorldServiceImpl();
		//create WebService service factory
		JaxWsServerFactoryBean factory = new JaxWsServerFactoryBean();
		//register WebService interface
		factory.setServiceClass(HelloWorldService.class);
		//publish the interface
		factory.setAddress(END_POINT);
		factory.setServiceBean(helloWorld);
		//create WebService instance
		factory.create();

	}
}
