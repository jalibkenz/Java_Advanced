package in.kenz.springioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeCLI {

	public static void main(String[] args) {

		//setter injection Spring IOC
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
		Employee e1 = (Employee) applicationContext.getBean("e1");
		System.out.println(e1);
		Employee e2 = (Employee) applicationContext.getBean("e2");
		System.out.println(e2);

	}

}
