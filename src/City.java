//class for the city objects which just stores the cities name and a list of direct flights from that city
public class City
{
    private String name;
    private final LinkedList<DirectFlight> directFlights;

    public City(String name)
    {
        this.name = name;
        this.directFlights = new LinkedList<>();
    }

    //city name getter/setter
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    //directFlights getter
    public LinkedList<DirectFlight> getDirectFlights()
    {
        return directFlights;
    }

    // Method to add a direct flight to this city's list of direct flights
    public void addDirectFlight(DirectFlight directFlight)
    {
        directFlights.add(directFlight);
    }
}
