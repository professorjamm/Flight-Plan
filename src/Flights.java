import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Flights
{
    public Flights(String filename)
    {
        FlightMap flightMap = new FlightMap();

        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(filename));
            int totalFlights = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < totalFlights; i++)
            {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");

                City startCity = new City(parts[0]);
                City endCity = new City(parts[1]);
                int cost = Integer.parseInt(parts[2]);
                int time = Integer.parseInt(parts[3]);

                int startIndex = flightMap.addCity(startCity);
                System.out.println(parts[0] + " : " + startIndex);
                int endIndex = flightMap.addCity(endCity);
                System.out.println(parts[1] + " : " + endIndex);
                DirectFlight directFlight = new DirectFlight(flightMap.getCityList().get(endIndex), cost, time);
                flightMap.addDirectFlight(flightMap.getCityList().get(startIndex), directFlight);
                System.out.println("Added flight from " + parts[0] + " to " + parts[1] + " with cost " + cost + " and time " + time);
                System.out.println();
            }
            System.out.println("Finished reading file\n\n");
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

        flightMap.printCityList();
    }

    // getters and setters
    // ...
}
