package co.com.tevolvers.stepsdefinition;


import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static co.com.tevolvers.utils.Constantes.*;



@Slf4j
public class BaseUrl {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{string} obtiene la baseurl de la api")
    public void getTheBaseurlFromTheApi(String actor) {
        log.info(String.format(
                FORMAT_THREE,
                actor,
                CALL_SERVICE,
                BASE_URL.replace(TYPE_ENVIRONMENT, ENV_QA))
        );
    }
}
