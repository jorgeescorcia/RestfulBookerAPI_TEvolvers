package co.com.tevolvers.task.get;

import co.com.tevolvers.interactions.GetConsultaReserva;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class GetConsulta_Reserva {

    public Performable apiget(String baseUrl, String request, String typeContent) {
        return Task.where("{0} Llamada al servicio get",
                GetConsultaReserva.params(baseUrl, request, typeContent)
        );
    }
}
