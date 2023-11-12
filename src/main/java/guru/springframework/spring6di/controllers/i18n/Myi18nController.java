package guru.springframework.spring6di.controllers.i18n;

import guru.springframework.spring6di.services.GreetingService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class Myi18nController {

    private final GreetingService greetingService;

    public Myi18nController(@Qualifier("i18NService") GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    public String sayHello() {
        System.out.println("I'm in the controller");
        return greetingService.sayGreeting();
    }

}
