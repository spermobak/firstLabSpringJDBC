package firstLabJDBC.config;

import firstLabJDBC.service.MessageService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
@ComponentScan("firstLabJDBC")
public class AppConfig {


    @Bean
    MessageService messageService(){return new MessageService();}


    @Bean
    Scanner scanner(){return new Scanner(System.in);}

}
