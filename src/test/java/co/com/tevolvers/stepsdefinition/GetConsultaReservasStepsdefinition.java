package co.com.tevolvers.stepsdefinition;

import co.com.tevolvers.questions.GetReservaQuestion;
import co.com.tevolvers.task.get.Call;
import co.com.tevolvers.utils.Uri;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static co.com.tevolvers.utils.Constantes.*;
import static io.restassured.parsing.Parser.JSON;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.apache.http.HttpStatus.SC_OK;


public class GetConsultaReservasStepsdefinition {

    @Before
    public void setTheStage(){
        OnStage.setTheStage(new OnlineCast());
    }



    @Cuando("configura la peticion a consumir")
    public void configura_la_peticion_a_consumir() {
        OnStage.theActorCalled(ACTOR).attemptsTo(
                Call.getConsulta_reserva().apiget(
                        BASE_URL.replace(TYPE_ENVIRONMENT,ENV_QA),
                        Uri.LIST_RESERVA.getUri(),
                        String.valueOf(JSON))
        );

    }
    @Entonces("valida el estado de la peticion")
    public void valida_el_estado_de_la_peticion() {
        theActorInTheSpotlight().should(seeThat(GetReservaQuestion.successful(SC_OK)));


    }

}
