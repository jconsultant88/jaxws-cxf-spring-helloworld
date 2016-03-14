package net.bluetechnolgies.services.impl; /**
 * Created by vemulav on 09/03/2016.
 */

import net.bluetechnolgies.services.helloworld.HelloWorldService;
import net.bluetechnolgies.services.helloworld.Person;

public class HelloWorldServiceImpl implements HelloWorldService {

	@Override
	public String hello(Person person) {
		return "Hello " + person.getFirstName() + " " + person.getLastName();
	}
}
