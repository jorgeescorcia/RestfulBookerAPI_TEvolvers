package co.com.tevolvers.task.put;

import co.com.tevolvers.interactions.PutActualizarReserva;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class ConsumeServicioPut {
    public Performable apiPut(String baseUrl, String bodyRequest, String request, String typeContent) {
        return Task.where("{0} call the service at execute PUT",
                PutActualizarReserva.params(baseUrl, bodyRequest, request, typeContent));
    }
}
