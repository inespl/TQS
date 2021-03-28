import com.google.gson.JsonObject;
import org.apache.http.client.utils.URIBuilder;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Formatter;
import java.util.Locale;

import com.google.gson.Gson;

public class AddressResolver {
    private TqsHttpBasic httpClient;

    public AddressResolver(TqsHttpBasic httpClient) {
        this.httpClient = httpClient;
    }

    public Address findAddressForLocation(double latitude, double longitude) throws URISyntaxException, IOException {

        URIBuilder uriBuilder = new URIBuilder("http://open.mapquestapi.com/geocoding/v1/reverse?key=uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ");
        uriBuilder.addParameter("location", (new Formatter()).format(Locale.US, "%.4f,%.3f", latitude, longitude).toString());
        uriBuilder.addParameter("includeRoadMetadata", "true");

        String url = uriBuilder.build().toString();

        String response = this.httpClient.get(url);

        // get parts from response till reaching the address
        Gson gson = new Gson();
        JsonObject obj = gson.fromJson(response, JsonObject.class);
        JsonObject results = obj.getAsJsonArray("results").get(0).getAsJsonObject();
        JsonObject address = results.getAsJsonArray("locations").get(0).getAsJsonObject();

        String street = address.get("street").toString().replaceAll("\"", "");
        String city = address.get("adminArea5").toString().replaceAll("\"", "");
        String state = address.get("adminArea3").toString().replaceAll("\"", "");
        String zip = address.get("postalCode").toString().replaceAll("\"", "");
        return new Address(street, city, state, zip, null);

    }
}
