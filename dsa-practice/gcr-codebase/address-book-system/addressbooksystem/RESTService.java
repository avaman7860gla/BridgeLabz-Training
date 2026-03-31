import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// UC16: Rest Post
public class RESTService {

    private static final String URL_PATH = "http://localhost:3000/contacts";

    public static void send(Contact c) {
        try {
            HttpClient client = HttpClient.newHttpClient();

            String json = "{ \"firstName\":\"" + c.getFirstName() +
                          "\", \"city\":\"" + c.getCity() + "\" }";

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(URL_PATH))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(json))
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println("POST Response: " + response.statusCode());
            System.out.println("Response Body: " + response.body());

        } catch (Exception e) {
            System.out.println("REST Error " + e);
        }
    }
}
