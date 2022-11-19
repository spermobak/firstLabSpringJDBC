package firstLab.config;

import firstLab.appMenu.AppMenu;
import firstLab.dao.PersonDao;
import firstLab.service.LanguageService;
import firstLab.service.MessageService;
import firstLab.service.PersonService;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


import java.util.Scanner;

@Configuration
@ComponentScan("firstLab")
public class AppConfig {

    @Bean
    PersonDao personDao(){return new PersonDao();}

    @Bean
    LanguageService languageService(){return new LanguageService(messageService());}

    @Bean
    MessageService messageService(){return new MessageService();}

    @Bean
    PersonService personService(){return new PersonService(personDao());}

    @Bean
    Scanner scanner(){return new Scanner(System.in);}

    @Bean
    AppMenu appMenu(){return new AppMenu(personService(),languageService(),messageService(),scanner());}

}
