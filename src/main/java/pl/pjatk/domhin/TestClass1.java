package pl.pjatk.domhin;

import org.springframework.stereotype.Component;

@Component
public class TestClass1 {

    private String name;

    public TestClass1(){
        System.out.println("Hello from Test class 1");
    }

    public void sayName(){
        System.out.println("say Name Test Class 1: " + name);
    }

    public void setName(String name) {
        this.name = name;
    }
}
