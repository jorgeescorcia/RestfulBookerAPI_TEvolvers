package co.com.tevolvers.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.annotations.Subject;

import static co.com.tevolvers.utils.Constantes.STATUS;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class GetReservaQuestion implements Question<Boolean> {
    private int statusOK;

    public GetReservaQuestion(int statusOK) {
        this.statusOK = statusOK;
    }

    @Override
    @Subject("{0} valida el codigo de estado exitoso #statusOK ")
    public Boolean answeredBy(Actor actor) {
        actor.should(seeThatResponse(STATUS, response -> response.statusCode(statusOK)));
        return true;
    }

    public static GetReservaQuestion successful(int statusOK) {
        return new GetReservaQuestion(statusOK);
    }
}
