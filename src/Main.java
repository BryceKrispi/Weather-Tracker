/* -----------------------------------------------------------------------------
Use this to run (as Java doesn't naturally recognize external org.json library) 
javac -cp .:json.jar src/*.java
java -cp .:json.jar src.Main
----------------------------------------------------------------------------- */

package src;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        //---------------------------------------------
        // Instantiates a scanner object to read input
        //---------------------------------------------
        Scanner scanner = new Scanner(System.in);
        
        //--------------------------------------------
        // Accept inputs until the user enters "DONE"
        //--------------------------------------------
        while (true) {
            System.out.print("Enter a city (or say DONE to quit): ");
            String city = scanner.nextLine();
            if (city.toLowerCase().equals("done")) {
                break;
            }

            //--------------------------
            // Creates a new API object
            //--------------------------
            WeatherAPI api = new WeatherAPI();

            //--------------------------------------------------------
            // Throws an exception if the user inputs an invalid city
            //--------------------------------------------------------
            try {
                Weather weather = api.getWeather(city);
                System.out.println(weather);
            } catch (Exception e) {
                System.out.println("City not found, please try again.");
            }
        }
        scanner.close();
    }
}
