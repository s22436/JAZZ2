package pl.pjatk.domhin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//@SpringBootApplication
public class DomhinApplication {

	public static void main(String[] args) {
		SpringApplication.run(DomhinApplication.class, args);
//		ApplicationContext appContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//		TestClass1 testClass1 = (TestClass1) appContext.getBean("testClass1");
//		testClass1.sayName();
	}

}
