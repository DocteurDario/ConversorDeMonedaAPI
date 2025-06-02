package model;

public class Apis {

    private String requesURL;
    private String claveApi;
    private String busquedaApi;
    private String detalle;

    public Apis() {
    }

    public Apis(String requesURL) {
        this.requesURL = requesURL;
    }

    public Apis(String requesURL, String claveApi, String busquedaApi, String detalle) {
        this.requesURL = requesURL;
        this.claveApi = claveApi;
        this.busquedaApi = busquedaApi;
        this.detalle = detalle;
    }

    public String getRequesURL() {
        return requesURL;
    }

    public void setRequesURL(String requesURL) {
        this.requesURL = requesURL;
    }

    public String getClaveApi() {
        return claveApi;
    }

    public void setClaveApi(String claveApi) {
        this.claveApi = claveApi;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getBusquedaApi() {
        return busquedaApi;
    }

    public void setBusquedaApi(String busquedaApi) {
        this.busquedaApi = busquedaApi;
    }

    @Override
    public String toString() {
        return "requesURL: " + requesURL + "\n" +
                "claveApi: " + claveApi + "\n" +
                "busquedaApi: " + busquedaApi + "\n" +
                "detalle: " + detalle;
    }

}
