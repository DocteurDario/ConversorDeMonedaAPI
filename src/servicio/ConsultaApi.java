package servicio;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

public class ConsultaApi {

    public static String consultaHttpClient(String direccion) throws IOException, InterruptedException {

        String json = "";

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        json = response.body();

        Gson gson = new Gson();

        return json; // Retorna el JSON como String
    }
}






