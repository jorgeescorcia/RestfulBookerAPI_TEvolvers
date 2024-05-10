package co.com.tevolvers.stepsdefinition;

import co.com.tevolvers.questions.PutActualizarReservaQuestion;
import co.com.tevolvers.task.put.Call;
import co.com.tevolvers.utils.Uri;
import io.cucumber.java.Before;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static co.com.tevolvers.utils.Constantes.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.apache.hc.core5.http.HttpStatus.SC_OK;

public class PutActualizarReservaStepdefinition {
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Cuando("configura la peticion a obtener")
    public void configuraLaPeticionAObtener() {
        OnStage.theActorCalled(ACTOR).attemptsTo(
                Call.service()

                        .apiPut(
                                BASE_URL.replace(TYPE_ENVIRONMENT, ENV_QA),
                                "{\n" +
                                        "    \"firstname\" : \"James\",\n" +
                                        "    \"lastname\" : \"Brown\",\n" +
                                        "    \"totalprice\" : 111,\n" +
                                        "    \"depositpaid\" : true,\n" +
                                        "    \"bookingdates\" : {\n" +
                                        "        \"checkin\" : \"2018-01-01\",\n" +
                                        "        \"checkout\" : \"2019-01-01\"\n" +
                                        "    },\n" +
                                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                                        "}",
                                Uri.UPDATE_RESERVA.getUri(),

                                String.valueOf(ContentType.JSON)
                        )


        );
    }

    @Entonces("valida que los datos consultados fueron actualizados")
    public void validaQueLosDatosConsultadosFueronActualizados() {
        theActorInTheSpotlight().should(seeThat(PutActualizarReservaQuestion.updateSuccess(SC_OK)));
    }
}
