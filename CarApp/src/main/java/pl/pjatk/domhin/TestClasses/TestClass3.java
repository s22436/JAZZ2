package pl.pjatk.domhin.TestClasses;


import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class TestClass3 {

    public TestClass3(ApplicationContext applicationContext){
        TestClass1 testClass1 = applicationContext.getBean("testClass1", TestClass1.class);
        TestClass2 testClass2 = applicationContext.getBean("testClass2", TestClass2.class);

        testClass1.sayName();
        testClass2.saySurname();

    }
}
