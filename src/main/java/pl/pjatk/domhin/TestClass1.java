package pl.pjatk.domhin;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TestClass1 {

    private String name;

    public TestClass1(ApplicationContext context, @Value("${my.custom.property: Default Value}") String someValue){
        try{
            POJOTest mb1 = context.getBean(POJOTest.class);
        }catch (BeansException e){

        }

        System.out.println("Hello from Test class 1" + someValue);
    }

    public void sayName(){
        System.out.println("say Name Test Class 1: " + name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
