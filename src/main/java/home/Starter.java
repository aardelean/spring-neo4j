package home;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@SpringBootApplication
@Import({ DBConfiguration.class})
@ComponentScan("home.contact")
@PropertySource("classpath:/application.properties")
public class Starter {
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public EmbeddedServletContainerFactory embeddedServletContainerFactory(){
        UndertowEmbeddedServletContainerFactory result = new UndertowEmbeddedServletContainerFactory();
        return result;
    }

    public static void main(String[] args) throws Exception {
       SpringApplication.run(Starter.class);
    }
}
