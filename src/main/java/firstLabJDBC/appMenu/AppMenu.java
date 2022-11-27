package firstLabJDBC.appMenu;

import firstLabJDBC.service.LanguageService;
import firstLabJDBC.service.MessageService;
import firstLabJDBC.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ResourceBundle;
import java.util.Scanner;


@Component
@RequiredArgsConstructor
public class AppMenu {
    private final PersonService personService;
    private final LanguageService languageService;
    private final MessageService messageService;
    private final Scanner scanner;


    public void menu() {

        ResourceBundle message = languageService.setDefaultInterfaceLanguage();
        boolean x = true;
        messageService.printInterfaceMessage(message, "welcomeMessage");

        while (x) {
            messageService.printInterfaceMessage(message, "commandList");
            switch (scanner.next()) {
                case "/findAll"-> {
                    if (personService.findAll().isEmpty()) {
                        messageService.printInterfaceMessage(message, "notFoundPersons");
                    }
                    messageService.printInterfaceMessage(message, "allPerson");
                    messageService.printResultRequestMessage(personService.findAll());
                }
                case "/findById" -> {
                    messageService.printInterfaceMessage(message, "findById");
                    int id = scanner.nextInt();

                    if (personService.findById(id).getName().isEmpty()) {
                        messageService.printInterfaceMessage(message, "notFoundPerson");
                    } else {
                        messageService.printInterfaceMessage(message, "personById");
                        messageService.printResultRequestMessage(personService.findById(id));
                    }
                }
                case "/findByName"-> {
                    messageService.printInterfaceMessage(message, "findByName");
                    var name = scanner.next();

                    if (personService.findByName(name).getName().isEmpty()) {
                        messageService.printInterfaceMessage(message, "notFoundPerson");
                    } else {
                        messageService.printInterfaceMessage(message, "personByName");
                        messageService.printResultRequestMessage(personService.findByName(name));
                    }
                }
                case "/changeLanguage"-> {
                    messageService.printInterfaceMessage(message, "changeLanguage");
                    languageService.printLanguageKey();
                    var lang = scanner.next();
                    message = languageService.setInterfaceLanguage(lang, message);
                }
                case "/endSession" -> {
                    messageService.printInterfaceMessage(message, "farewellMessage");
                    x = false;
                }
                case "commandList" -> messageService.printInterfaceMessage(message,"commandList");
                default -> messageService.printInterfaceMessage(message, "unknownSyntax");
            }
        }
    }
}
