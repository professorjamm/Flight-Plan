public class DirectFlight
{
    private City destination;
    private double cost;
    private double time;

    public DirectFlight(City destination, double cost, double time)
    {
        this.destination = destination;
        this.cost = cost;
        this.time = time;
    }

    //city getter/setter
    public City getDestination()
    {
        return destination;
    }
    public void setDestination(City destination)
    {
        this.destination = destination;
    }

    //don't need setters since it won't change

    //cost getter
    public double getCost()
    {
        return cost;
    }

    //time getter/setter
    public double getTime()
    {
        return time;
    }

    public String endCityName()
    {
        return destination.getName();
    }
}
