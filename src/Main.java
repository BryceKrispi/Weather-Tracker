/* ------------------------------
Use this to run: 
javac -cp .:json.jar src/*.java
java -cp .:json.jar src.Main
------------------------------ */

package src;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.print("Enter a city (or say DONE to quit): ");
            String city = scanner.nextLine();
            if (city.toLowerCase().equals("done")) {
                break;
            }

            WeatherAPI api = new WeatherAPI();

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
