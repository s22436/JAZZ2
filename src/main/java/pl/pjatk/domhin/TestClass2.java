package pl.pjatk.domhin;


import org.springframework.stereotype.Component;

@Component
public class TestClass2 {

    public TestClass2(){
        System.out.println("Hello from Test class 2");
    }

    public void saySurname(){
        System.out.println("saySurname Test Class 2");
    }
}
