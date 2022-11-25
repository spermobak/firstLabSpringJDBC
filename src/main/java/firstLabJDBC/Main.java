package firstLabJDBC;

import firstLabJDBC.appMenu.AppMenu;
import firstLabJDBC.config.AppConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        AppMenu menu = context.getBean("appMenu", AppMenu.class);

        menu.menu();

        context.close();
    }
}
