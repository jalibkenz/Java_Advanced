package in.kenz.springioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMobile {
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("ioc.xml");
		Mobile m= (Mobile) applicationContext.getBean("m");
		m.activate();
	}

}
