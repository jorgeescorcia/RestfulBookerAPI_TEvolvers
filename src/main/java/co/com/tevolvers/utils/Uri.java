package co.com.tevolvers.utils;


public enum Uri {
    LIST_RESERVA("/booking"),
    CREATE_RESERVA("/auth"),
    UPDATE_RESERVA("/booking/1");




    private String uri;

    Uri( String uri) {
        this.uri = uri;
    }


    public String getUri(){
        return uri;
    }
}
