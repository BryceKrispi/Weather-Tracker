package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a city: ");
        String city = scanner.nextLine();

        WeatherAPI api = new WeatherAPI();
        Weather weather = api.getWeather(city);

        System.out.println(weather);
    }
}