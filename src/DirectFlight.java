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

    //cost getter/setter
    public double getCost()
    {
        return cost;
    }
    public void setCost(double cost)
    {
        this.cost = cost;
    }

    //time getter/setter
    public double getTime()
    {
        return time;
    }
    public void setTime(double time)
    {
        this.time = time;
    }
}
