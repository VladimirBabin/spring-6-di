package guru.springframework.spring6di.controllers.faux;

import guru.springframework.spring6di.controllers.EnvironmentController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles({"uat", "EN"})
@SpringBootTest
class EnvironmentControllerTestUAT {

    @Autowired
    EnvironmentController environmentController;

    @Test
    void callData() {
        System.out.println(environmentController.callData());
    }
}