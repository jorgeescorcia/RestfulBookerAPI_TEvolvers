package co.com.tevolvers.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import static co.com.tevolvers.utils.Constantes.RESPONSE_REQUEST;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;


public class PostCrearReservaQuestion implements Question<Boolean> {

    private int statusOK;

    public PostCrearReservaQuestion(int statusOK) {
        this.statusOK = statusOK;
    }

    @Override
    @Subject("{0} valida el codigo de estado OK #statusDelete ")
    public Boolean answeredBy(Actor actor) {
        actor.should(seeThatResponse(RESPONSE_REQUEST,
                reponse -> reponse.statusCode(statusOK)
                        .body("firstname", equalTo("Jim"))
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
    public static PostCrearReservaQuestion registerSuccess(int statusOK) {
        return new PostCrearReservaQuestion(statusOK);
    }
}
