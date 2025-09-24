package br.com.chell.screenmatch.api;

import br.com.chell.screenmatch.models.Titulo;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class OrganizadorHttp extends OrganizadorApi{

    private final String filmeLink;
    private final String apiKey;

    public OrganizadorHttp(String filmeLink, String apiKey){
        this.filmeLink = filmeLink;
        this.apiKey = apiKey;
    }

    public void exibiFichaApi() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()                                 //ac4c9a6
                .uri(URI.create("https://www.omdbapi.com/?t=" + filmeLink + "&apikey=" + apiKey))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        Gson gson = new Gson();
        Titulo meuTitulo = gson.fromJson(json, Titulo.class);
        System.out.println(response.body());
        System.out.println("Título: " + meuTitulo.getNome());
        System.out.println("Ano de lançamento: " + meuTitulo.getAnoLancamento());
    }
}

//