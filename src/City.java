import java.util.LinkedList;

//class for the city objects which just stores the cities name and a list of direct flights from that city
public class City
{
    private final String name;

    //list of all edges (direct flights) connected to node/vertex (city)
    private final LinkedList<DirectFlight> directFlights;

    //constructor
    public City(String name)
    {
        this.name = name;
        this.directFlights = new LinkedList<>();
    }

    //city name getter
    public String getName()
    {
        return name;
    }

    //directFlights getter
    public LinkedList<DirectFlight> getDirectFlights()
    {
        return directFlights;
    }

    //method to add a direct flight to this city's list of direct flights
    public void addDirectFlight(DirectFlight directFlight)
    {
        directFlights.add(directFlight);
    }
}