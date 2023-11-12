package guru.springframework.spring6di.controllers;

import guru.springframework.spring6di.services.faux.EnvironmentService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class EnvironmentController {

    private final EnvironmentService environmentService;


    public EnvironmentController(EnvironmentService environmentService) {
        this.environmentService = environmentService;
    }

    public String callData() {
        return "You are in " + environmentService.getEnv() + " environment";
    }
}
