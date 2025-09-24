package br.com.chell.screenmatch.main;

import br.com.chell.screenmatch.api.OrganizadorApi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MainBusca {
    public static void main(String[] args) throws IOException, InterruptedException {

        OrganizadorApi filmeLink = new OrganizadorApi();
        OrganizadorApi api = new OrganizadorApi();

        filmeLink.pegaFilmeLink();
        //System.out.println(filmeLink.getFilmeLink()); debug

        api.pegaApi();
        //System.out.println(api.getApi()); debug

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()                                                  //ac4c9a6
                .uri(URI.create("https://www.omdbapi.com/?t=" + filmeLink.getFilmeLink() + "&apikey=" + api.getApi()))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }
}
