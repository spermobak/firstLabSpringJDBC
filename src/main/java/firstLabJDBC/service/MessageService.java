package firstLabJDBC.service;

import org.springframework.stereotype.Service;

import java.util.ResourceBundle;

@Service("messageService")
public class MessageService {

    public void printInterfaceMessage(ResourceBundle message, String key){
        System.out.println(message.getString(key));
    }

    public void printResultRequestMessage(Object o){
        System.out.println(o);
    }
}
