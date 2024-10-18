package CodeAlphaProject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Class to represent a destination
class Destination {
    String name;
    String date;

    public Destination(String name, String date) {
        this.name = name;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Destination: " + name + ", Date: " + date;
    }
}

// Class to handle the travel itinerary
class Itinerary {
    List<Destination> destinations;

    public Itinerary() {
        this.destinations = new ArrayList<>();
    }

    public void addDestination(Destination destination) {
        destinations.add(destination);
    }

    public void displayItinerary() {
        System.out.println("Your Travel Itinerary:");
        for (Destination dest : destinations) {
            System.out.println(dest);
        }
    }
}

// Class to get weather information (mocked)
class WeatherService {
    public String getWeather(String destination) {
        return "Sunny, 25°C";
    }
}
class MapService {
    public String getMapLink(String destination) {

        return "Map link for " + destination;
    }
}


class BudgetCalculator {
    public double calculateBudget(int numberOfDestinations, double dailyBudget) {
        return numberOfDestinations * dailyBudget;
    }
}


public class TravelItineraryPlanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Itinerary itinerary = new Itinerary();
        WeatherService weatherService = new WeatherService();
        MapService mapService = new MapService();
        BudgetCalculator budgetCalculator = new BudgetCalculator();

        System.out.print("Enter the number of destinations: ");
        int numberOfDestinations = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numberOfDestinations; i++) {
            System.out.print("Enter destination name: ");
            String name = scanner.nextLine();
            System.out.print("Enter date (YYYY-MM-DD): ");
            String date = scanner.nextLine();
            itinerary.addDestination(new Destination(name, date));
        }

        itinerary.displayItinerary();


        for (Destination dest : itinerary.destinations) {
            System.out.println(dest.name + " - Weather: " + weatherService.getWeather(dest.name));
            System.out.println(mapService.getMapLink(dest.name));
        }

        System.out.print("Enter daily budget: ");
        double dailyBudget = scanner.nextDouble();
        double totalBudget = budgetCalculator.calculateBudget(numberOfDestinations, dailyBudget);
        System.out.println("Estimated Total Budget: $" + totalBudget);

        scanner.close();
    }
}

