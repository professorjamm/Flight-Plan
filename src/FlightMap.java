public class FlightMap
{
    private final LinkedList<City> cityList;
    private int duplicateIndex = 0;

    public FlightMap()
    {
        cityList = new LinkedList<>();
    }

    public int addCity(City city)
    {
        if(containsCity(city))
            return duplicateIndex;
        cityList.add(city);
        return cityList.size()-1;
    }

    public boolean containsCity(City city)
    {
        for(int i=0; i< cityList.size();i++)
        {
            if(cityList.get(i).getName().equals(city.getName()))
            {
                duplicateIndex = i;
                return true;
            }
        }
        return false;
    }

    //i was originally going to do startCity and endCity as the parameters, but need to know cost and time
    //and the directFlight object already holds information about the endCity
    public void addDirectFlight(City startCity, DirectFlight directFlight)
    {
        if(containsCity(directFlight.getDestination()))
        {
            cityList.get(duplicateIndex).addDirectFlight(directFlight);
        }
        LinkedList<DirectFlight> directFlightList = getDirectFlightList(startCity);
        for(int i=0;i<directFlightList.size();i++)
        {
            System.out.println(directFlightList.get(i).getDestination().getName() + " " + directFlightList.get(i).getCost() + " " + directFlightList.get(i).getTime());
        }
    }

    //returns a linked list of all the direct flights from a given city
    public LinkedList<DirectFlight> getDirectFlightList(City city)
    {
        return city.getDirectFlights();
    }

    public LinkedList<City> getCityList()
    {
        return cityList;
    }

    public LinkedList<FlightPlan> mostCostEfficientPlan(City start, City end)
    {
        return null;
    }
    public LinkedList<FlightPlan> mostTimeEfficientPlan(City startCity, City endCity)
    {
        return null;
    }

    public void printFlightMap()
    {
//        for (int i=0; i<cityList.size();i++)
//        {
//            System.out.println(cityList.get(i).getName());
//            LinkedList<DirectFlight> directFlightList = getDirectFlightList(cityList.get(i));
//            for (int j=0; j<directFlightList.size();j++)
//            {
//                System.out.print(" -> " + directFlightList.get(j).getDestination().getName() + " (Cost: " + directFlightList.get(j).getCost() + " Time: " + directFlightList.get(j).getTime() + ")");
//            }
//            if (i == cityList.size()-1)
//            {
//                System.out.println();
//            }
//        }
    }

    public void printCityList()
    {
        for (int i=0; i<cityList.size();i++)
        {
            System.out.println(cityList.get(i).getName());
        }
    }

}
