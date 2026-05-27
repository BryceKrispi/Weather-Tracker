package src;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class WeatherAPI {
    private static final String API_KEY = "82c342f2f31244d2a7910638262705";
    private static final String BASE_URL = "http://api.weatherapi.com/v1";

    public Weather getWeather(String city) throws Exception {

        // Build and send request
        String url = BASE_URL + "/current.json?key=" + API_KEY + "&q=" + city.replace(" ", "%20");
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .GET()
            .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        // Parse JSON
        JSONObject json = new JSONObject(response.body());
        JSONObject current = json.getJSONObject("current");

        // Extract values
        double temp = current.getDouble("temp_c");
        double precipitation = current.getDouble("precip_mm") / 10;

        String conditionText = current.getJSONObject("condition").getString("text").toLowerCase();
        String precipitationType = "none";
        if (conditionText.contains("rain"))       precipitationType = "rain";
        else if (conditionText.contains("snow"))  precipitationType = "snow";
        else if (conditionText.contains("hail"))  precipitationType = "hail";
        else if (conditionText.contains("sleet")) precipitationType = "sleet";

        // Build and RETURN a Weather object
        return new Weather(precipitation, precipitationType, temp);
    }
}