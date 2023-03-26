package pl.pjatk.domhin;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ConfigurationTest {

    @Bean
    @ConditionalOnProperty(prefix = "should.create.important", name = "bean", havingValue = "true")
    public POJOTest exampleBean(){
        return new POJOTest();
    }

    @Bean
    public List<String> defaultData(){
        return List.of("Some", "Example", "Strings", "Times", "Five");
    }
}
