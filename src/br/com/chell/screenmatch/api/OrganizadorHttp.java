package br.com.chell.screenmatch.api;

import br.com.chell.screenmatch.exception.ErroAnoInvalidoException;
import br.com.chell.screenmatch.models.Titulo;
import br.com.chell.screenmatch.models.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
        HttpRequest request = HttpRequest.newBuilder()                                 
                .uri(URI.create("https://www.omdbapi.com/?t=" + filmeLink + "&apikey=" + apiKey))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy
                        (FieldNamingPolicy.UPPER_CAMEL_CASE)
                .create();
        TituloOmdb meuTituloOmdb = gson.fromJson(json, TituloOmdb.class);
        System.out.println(meuTituloOmdb);

        try {
            Titulo meuTitulo = new Titulo(meuTituloOmdb);
            System.out.println(meuTitulo);
        } catch (NumberFormatException e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        } catch (ErroAnoInvalidoException e) {
            System.out.println("Ocorreu um erro: " + e.getMensagem());
        }

    }
}

//
