package co.com.tevolvers.task.post;

import co.com.tevolvers.interactions.PostCrearReserva;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

public class PostConsumirCrearReserva {

    public Performable apiPost(String baseUrl, String bodyRequest, String request, String typeContent) {
        return Task.where("{0} Llamado al servicio POST",
                PostCrearReserva.params(baseUrl,bodyRequest,request,typeContent));
    }
}
