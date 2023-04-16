package pl.pjatk.domhin.TestClasses;


import org.springframework.stereotype.Service;

@Service
public class TestClass2 {

    public TestClass2(){
        System.out.println("Hello from Test class 2");
    }

    public void saySurname(){
        System.out.println("saySurname Test Class 2");
    }
}
