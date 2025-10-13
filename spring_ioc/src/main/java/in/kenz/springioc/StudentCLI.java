package in.kenz.springioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentCLI {

	public static void main(String[] args) {

		//constructor injection Spring IOC so setter methods need to be commented as not required
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
		Student s1 = (Student) applicationContext.getBean("s1");
		System.out.println(s1);
		Student s2 = (Student) applicationContext.getBean("s2");
		System.out.println(s2);

	}

}