package co.com.tevolvers.stepsdefinition;

import co.com.tevolvers.questions.PostCrearReservaQuestion;
import co.com.tevolvers.task.post.Call;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import co.com.tevolvers.utils.Uri;

import static co.com.tevolvers.utils.Constantes.*;
import static co.com.tevolvers.utils.Constantes.ENV_QA;
import static io.restassured.http.ContentType.JSON;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.apache.http.HttpStatus.SC_CREATED;
import static org.apache.http.HttpStatus.SC_OK;


public class PostCrearReservaStepsdefinition {


    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Cuando("configura la solicitud a consumir")
    public void configura_la_solicitud_a_consumir() {
        OnStage.theActorCalled(ACTOR).attemptsTo(
                Call.service().
                        apiPost(
                                BASE_URL.replace(TYPE_ENVIRONMENT, ENV_QA),

                               "{\n" +
                                        "    \"firstname\" : \"Jim\",\n" +
                                        "    \"lastname\" : \"Brown\",\n" +
                                        "    \"totalprice\" : 111,\n" +
                                        "    \"depositpaid\" : true,\n" +
                                        "    \"bookingdates\" : {\n" +
                                        "        \"checkin\" : \"2018-01-01\",\n" +
                                        "        \"checkout\" : \"2019-01-01\"\n" +
                                        "    },\n" +
                                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                                        "}",


                                Uri.CREATE_RESERVA.getUri(),
                                String.valueOf(JSON))

        );

    }
    @Entonces("valida los datos consultados")
    public void valida_los_datos_consultados() {
        theActorInTheSpotlight().should(seeThat(PostCrearReservaQuestion.registerSuccess(SC_OK)));
    }
}
