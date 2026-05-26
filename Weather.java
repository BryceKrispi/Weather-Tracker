//------------------------------------------------------------------
// Class to hold and return data retrieved from the OpenWeather API
//------------------------------------------------------------------
public class Weather {

    double precipitation = 0.0; // Measurement in centimeters (cm)
    String precipitationType = "none"; // If precipitation is 0, default to "none"
    double temp; // Degrees in celsius (°C)
    boolean safe = false; // Determines if it is safe to leave home

    // Constructor
    public Weather(double precipitation, String precipitationType, double temp, boolean safe){
        this.precipitation = precipitation;
        this.precipitationType = precipitationType;
        this.temp = temp;
        this.safe = safe;
    }

    //------------------------------------------------
    // Accessor methods to reurn instance data values
    //------------------------------------------------
    public double getPrecipitation(){
        return precipitation;
    }

    public String getPrecipitationType(){
        return precipitationType;
    }

    public double getTemp(){
        return temp;
    }

    public boolean getSafe(){
        return safe;
    }
}