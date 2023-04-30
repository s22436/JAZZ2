package pl.pjatk.domhin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

@SpringBootApplication
public class DomhinApplication {

	public static void main(String[] args) {
		SpringApplication.run(DomhinApplication.class, args);

		// Taking values from XML
		// ApplicationContext appContext = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		//TestClass1 testClass1 = (TestClass1) appContext.getBean("testClass1");
		//testClass1.sayName();



		// Taking data from @Configuration
//		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
//		ctx.register(ConfigurationTest.class);
//		ctx.refresh();
//
//		 POJOTest mb1 = ctx.getBean(POJOTest.class);

//		 System.out.println(ctx.getBean("defaultValue", List.class));

		// MyBean mb2 = ctx.getBean(MyBean.class);

//		ctx.close();

	}

}
