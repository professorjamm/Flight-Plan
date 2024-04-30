public class DirectFlight
{
    private final City destination;
    private final double cost;
    private final double time;

    public DirectFlight(City destination, double cost, double time)
    {
        this.destination = destination;
        this.cost = cost;
        this.time = time;
    }
    //don't need setters as everything is initialized and never changed when the text file is read in

    //city getter
    public City getDestination()
    {
        return destination;
    }

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
}