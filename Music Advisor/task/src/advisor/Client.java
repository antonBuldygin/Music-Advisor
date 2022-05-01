package advisor;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Client {

    private static Client instance;

     private Client() {

    }

    public static Client getInstance() {
        if (instance == null) {
            instance = new Client();
        }
        return instance;
    }

    protected static JsonObject postToGetNewReleases(String uri)  {
        HttpClient client = HttpClient.newBuilder().build();

        HttpRequest request1 = HttpRequest.newBuilder()
                .header("Authorization", "Bearer " + Config.ACCESS_TOKEN)
                .uri(URI.create(uri))
                .GET()
                .build();

        HttpResponse<String> response1 = null;
        try {
            response1 = client.send(request1, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        JsonObject jo = JsonParser.parseString(response1.body()).getAsJsonObject();
        return jo;
    }

}
