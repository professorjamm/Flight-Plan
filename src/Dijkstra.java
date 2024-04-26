public class Dijkstra {
}

/*
class DijkstraAlgorithm {
    FlightMap flightMap;

    DijkstraAlgorithm(FlightMap flightMap) {
        this.flightMap = flightMap;
    }

    LinkedList<City> findShortestPath(City startCity, City endCity) {
        // Create a map to store the shortest distance from startCity to each city
        Map<City, Double> shortestDistances = new HashMap<>();
        // Initialize the distance to startCity as 0 and to all other cities as infinity
        for (City city : flightMap.getCities()) {
            shortestDistances.put(city, Double.POSITIVE_INFINITY);
        }
        shortestDistances.put(startCity, 0.0);

        // Create a map to store the previous city on the shortest path from startCity to each city
        Map<City, City> previousCities = new HashMap<>();

        // Create a priority queue to store the cities to be visited,
        // ordered by the shortest known distance from startCity
        PriorityQueue<City> queue = new PriorityQueue<>(Comparator.comparing(city -> shortestDistances.get(city)));
        queue.add(startCity);

        while (!queue.isEmpty()) {
            // Get the city in the queue with the shortest known distance from startCity
            City currentCity = queue.poll();

            // For each direct flight from currentCity
            for (DirectFlight directFlight : currentCity.getDirectFlights()) {
                City destination = directFlight.getDestination();
                double distance = directFlight.getDistance();

                // Calculate the total distance to the destination city via currentCity
                double totalDistance = shortestDistances.get(currentCity) + distance;

                // If the total distance is less than the current known shortest distance to the destination city
                if (totalDistance < shortestDistances.get(destination)) {
                    // Update the shortest distance
                    shortestDistances.put(destination, totalDistance);
                    // Update the previous city
                    previousCities.put(destination, currentCity);
                    // Add the destination city to the queue
                    queue.add(destination);
                }
            }
        }

        // Build the shortest path from startCity to endCity
        LinkedList<City> shortestPath = new LinkedList<>();
        City city = endCity;
        while (city != null) {
            shortestPath.addFirst(city);
            city = previousCities.get(city);
        }

        return shortestPath;
    }
}
 */