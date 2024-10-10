package br.com.conversor;


import com.google.gson.Gson;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {
    private String url;

    public ApiService(String url) {
        this.url = url;
    }

    public Conversor pegarApi() {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            Gson gson = new Gson();

            return gson.fromJson(json, Conversor.class);
        } catch (Exception e) {
            System.out.println("Erro na ApiService: " + e.getMessage());
            return null;
        }
    }
}
