//------------------------------------------------------------------
// Class to hold and return data retrieved from the OpenWeather API
//------------------------------------------------------------------
package src;

public class Weather {

    double precipitation = 0.0; // Measurement in centimeters (cm)
    String precipitationType = "none"; // If precipitation is 0, default to "none"
    double temp; // Degrees in celsius (°C)

    // Constructor
    public Weather(double precipitation, String precipitationType, double temp){
        this.precipitation = precipitation;
        this.precipitationType = precipitationType;
        this.temp = temp;
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

    // Returns if it is safe to go outside
    public boolean isSafe(){
        if (temp <= 0 || temp >= 40 || precipitation >= 10){
            return false;
        } else {
            return true;
        }
    }

    // toString method
    public String toString(){
        if (isSafe() == false){
            // Not safe
        return "There are " + precipitation + "cm of " + precipitationType + 
                ", the temperature is " + temp + " °C." + " Do not go outside!";
        } else {
            // Safe
            return "There are " + precipitation + "cm of " + precipitationType + 
                ", the temperature is " + temp + " °C." + " It is safe to go outside.";
        }
    }
}