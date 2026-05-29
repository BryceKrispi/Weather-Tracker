//-----------------------------------------
// Class to pull data from the Weather API
//-----------------------------------------
package src;

//---------------------------
// Modules needed to run API
//---------------------------
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;

public class WeatherAPI {
    //------------------------------------------------------------
    // Our own unique API key that allows us to call from the API
    //------------------------------------------------------------
    private static final String API_KEY = "82c342f2f31244d2a7910638262705"; 
    
    //-----------------------------------------------------------------
    // The URL of the API (given so computer knows where to call from)
    //-----------------------------------------------------------------
    private static final String BASE_URL = "http://api.weatherapi.com/v1";
    

    public Weather getWeather(String city) throws Exception {

        //-------------------------------------------
        // Uses URL and API key to build request URL
        //-------------------------------------------
        String url = BASE_URL + "/current.json?key=" + API_KEY + "&q=" + city.replace(" ", "%20");
       
        //------------------------------------------------------------------------------------
        // Creates a client object that allows for communication between the code and the API
        //------------------------------------------------------------------------------------
        HttpClient client = HttpClient.newHttpClient();

        //-------------------------------------------------------------
        // Creates an object that allows user to take request from API
        //-------------------------------------------------------------
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .GET()
            .build();

        //-----------------------------------------------------------------------------
        // Creates a response object that takes what API returns after request is sent
        //-----------------------------------------------------------------------------
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        //--------------------------------------------
        // Takes the response and parses it into JSON
        //--------------------------------------------
        JSONObject json = new JSONObject(response.body());
        JSONObject current = json.getJSONObject("current");

        //----------------
        // Extract values
        //----------------
        double temp = current.getDouble("temp_c");
        double precipitation = current.getDouble("precip_mm") / 10;

        String cityName = json.getJSONObject("location").getString("name");
        System.out.println("Showing weather for: " + cityName);

        String conditionText = current.getJSONObject("condition").getString("text").toLowerCase();

        //-----------------------------------------------------------------
        // Based on value extracted from API, determine precipitation type
        //-----------------------------------------------------------------
        String precipitationType = "none";
        if (conditionText.contains("rain"))       precipitationType = "rain";
        else if (conditionText.contains("snow"))  precipitationType = "snow";
        else if (conditionText.contains("thunder"))  precipitationType = "thunder";
        else if (conditionText.contains("sleet")) precipitationType = "sleet";

        //------------------------------------------
        // Using API values, build a weather object
        //------------------------------------------
        return new Weather(precipitation, precipitationType, temp, cityName);
    }
}
