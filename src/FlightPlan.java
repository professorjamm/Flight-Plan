public class FlightPlan
{
    private LinkedList<City> path;
    private double totalCost;
    private double totalTime;

    public FlightPlan(LinkedList<City> path, double totalCost, double totalTime)
    {
        this.path = path;
        this.totalCost = totalCost;
        this.totalTime = totalTime;
    }

    // getters and setters
    // ...
}
