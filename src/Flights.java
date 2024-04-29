import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Flights
{
    public Flights(String dataFile, String flightPlanFile)
    {
        FlightMap flightMap = new FlightMap();
        String littleBox = "----------------------------------------------------------------------------";

        Scanner scanner = null;
        try {
            scanner = new Scanner(new File(dataFile));
            int totalFlights = Integer.parseInt(scanner.nextLine());
            System.out.println("\n"+littleBox);
            for (int i = 0; i < totalFlights; i++)
            {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");

                City startCity = new City(parts[0]);
                City endCity = new City(parts[1]);
                int cost = Integer.parseInt(parts[2]);
                int time = Integer.parseInt(parts[3]);

                int startIndex = flightMap.addCity(startCity);
                //System.out.println(parts[0] + " : " + startIndex);
                int endIndex = flightMap.addCity(endCity);
                //System.out.println(parts[1] + " : " + endIndex);

                DirectFlight directFlight = new DirectFlight(flightMap.getCityList().get(endIndex), cost, time);
                flightMap.addDirectFlight(flightMap.getCityList().get(startIndex), directFlight);
                directFlight = new DirectFlight(flightMap.getCityList().get(startIndex), cost, time);
                flightMap.addDirectFlight(flightMap.getCityList().get(endIndex), directFlight);
            }
            //System.out.println("Finished reading file\n\n");
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

        flightMap.printFlightMap();
        System.out.println(littleBox);

        try {
            scanner = new Scanner(new File(flightPlanFile));
            int totalFlights = Integer.parseInt(scanner.nextLine());
            ShortestPathAlgo shortestPathAlgo = new ShortestPathAlgo(flightMap);
            for (int i = 0; i < totalFlights; i++)
            {
                String line = scanner.nextLine();
                String[] parts = line.split("\\|");

                City startCity = new City(parts[0]);
                City endCity = new City(parts[1]);
                char timeOrCost = parts[2].charAt(0);
                System.out.println();
                shortestPathAlgo.findShortestPath(startCity,endCity,timeOrCost == 'C');
                System.out.println();
            }
            //System.out.println("Finished reading file\n\n");
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }
}