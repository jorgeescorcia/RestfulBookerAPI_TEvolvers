package co.com.tevolvers.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static co.com.tevolvers.utils.Constantes.RESPONSE_REQUEST;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

public class PutActualizarReservaQuestion implements Question<Boolean> {

    private int statusOK;

    public PutActualizarReservaQuestion(int statusOK) {
        this.statusOK = statusOK;
    }


    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(seeThatResponse(
                RESPONSE_REQUEST,
                response -> response.statusCode(statusOK)
                        .header("Cookie", "token=abc123")
                        .body("firstname", equalTo("James"))
                        .body("lastname", equalTo("Brown"))
                        .body("totalprice", equalTo(111))
                        .body("depositpaid", equalTo(true))
                        .body("bookingdates.checkin", equalTo("2018-01-01"))
                        .body("bookingdates.checkout", equalTo("2019-01-01"))
                        .body("additionalneeds", equalTo("Breakfast"))
                )
        );
        return true;
    }
    public static PutActualizarReservaQuestion updateSuccess(int statusOK) {
        return new PutActualizarReservaQuestion(statusOK);
    }
}
