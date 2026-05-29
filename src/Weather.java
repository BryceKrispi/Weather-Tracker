//-----------------------------------------------------------------
// Class to hold and return data derived from the WeatherAPI class
//-----------------------------------------------------------------
package src;

public class Weather {

    private double temp; // Degrees in celsius (°C)
    private double precipitation = 0.0; // Measurement in centimeters (cm)
    private String precipitationType = "none"; // If precipitation is 0, default to "none"
    private String cityName = ""; // If precipitation is 0, default to "none"
    private final double MIN_TEMP = 0; // The minumum temperature in celsius (°C) to be "safe"
    private final double MAX_TEMP = 40; // The maximum temperature in celsius (°C) to be "safe"
    private final double MAX_PRECIPITATION = 10; // The maximum precipitation in centimeters (cm) to be "safe"

    //--------------------
    // Constructor method
    //--------------------
    public Weather(double precipitation, String precipitationType, double temp, String cityName){
        this.precipitation = precipitation;
        this.precipitationType = precipitationType;
        this.temp = temp;
        this.cityName = cityName;
    }

    //------------------------------------------------
    // Accessor methods to reurn instance data values
    //------------------------------------------------
    public double getTemp(){
        return temp;
    }

    public double getPrecipitation(){
        return precipitation;
    }

    public String getPrecipitationType(){
        return precipitationType;
    }

    //-------------------------------------
    // Returns if it is safe to go outside
    //-------------------------------------
    public boolean isSafe(){
        return ((temp <= MAX_TEMP && temp >= MIN_TEMP) &&
                precipitation <= MAX_PRECIPITATION &&
                !precipitationType.equals("thunder"));
       
    }

    //-------------------
    // toString() method
    //-------------------
    @Override
    public String toString(){
        if (precipitationType.equals("none")) {
            if (isSafe() == false){
                // Not safe
                return "There is currently no precipitation. " + 
                    "The temperature is " + temp + " °C." + " Do not go outside!";
            } else {
                // Safe
                return "There is currently no precipitation. " + 
                    "The temperature is " + temp + " °C." + " It is safe to go outside.";
            }
        } else if (precipitationType.equals("thunder")) {
            return "The temperature is " + temp + " °C." + " It is thundering. " + " Do not go outside!";
        } else {
            if (isSafe() == false){
                // Not safe
            return "There are " + precipitation + " cm of " + precipitationType + 
                    ", the temperature is " + temp + " °C." + " Do not go outside!";
            } else {
                // Safe
                return "There are " + precipitation + " cm of " + precipitationType + 
                    ", the temperature is " + temp + " °C." + " It is safe to go outside.";
            }
        }
    }
}
