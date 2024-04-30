import java.util.LinkedList;
import java.util.Stack;
import java.util.Arrays;

public class ShortestPathAlgo
{
    private final FlightMap flightMap;
    private Stack<LinkedList<City>> path;
    private Stack<Double> timeStack, costStack;
    private int flightPathNum;


    public ShortestPathAlgo(FlightMap flightMap)
    {
        flightPathNum = 0;
        this.flightMap = flightMap;
    }

    public void findShortestPath(City startCity, City endCity, boolean findCost)
    {
        timeStack = new Stack<>();
        costStack = new Stack<>();

        flightPathNum++;
        path = new Stack<>();
        double totalCost = 0;
        double totalTime = 0;

        City start = flightMap.getCityList().get(flightMap.indexOf(startCity.getName()));
        City end = flightMap.getCityList().get(flightMap.indexOf(endCity.getName()));
        boolean[] visited = new boolean[flightMap.getCityList().size()];
        Arrays.fill(visited, false);

        LinkedList<City> currentPath = new LinkedList<>();
        currentPath.add(start);

        String stringTimeOrCost = "Cost";
        if(!findCost)
            stringTimeOrCost = "Time";
        System.out.println("Flight "+flightPathNum+": "+ start.getName()+", "+end.getName()+" ("+stringTimeOrCost+")");
        printAllPaths(currentPath,visited,start,end, totalTime, totalCost);

        if(path.isEmpty()){
            System.out.println("ERROR: NO PATH FOUND");
            return;
        }
        sortPaths(findCost);
    }

    public void printAllPaths(LinkedList<City> currentPath, boolean[] marked, City current, City last, double totalTime, double totalCost)
    {
        LinkedList<City> adjacentCities = new LinkedList<>();
        marked[flightMap.indexOf(current.getName())] = true;
        for(int i=0; i< flightMap.getCityList().get(flightMap.indexOf(current.getName())).getDirectFlights().size(); i++)
        {
            adjacentCities.add(flightMap.getCityList().get(flightMap.indexOf(current.getName())).getDirectFlights().get(i).getDestination());
        }
        for(int i=0; i<adjacentCities.size(); i++) //going thru list of all adjacent cities
        {
            if(adjacentCities.get(i).getName().equals(last.getName())) //current node == last node
            {
                currentPath.add(last);
                totalTime+=flightMap.getCityList().get(flightMap.indexOf(current.getName())).getDirectFlights().get(i).getTime();
                totalCost+=flightMap.getCityList().get(flightMap.indexOf(current.getName())).getDirectFlights().get(i).getCost();
                path.push(new LinkedList<>(currentPath));
                timeStack.push(totalTime);
                costStack.push(totalCost);
                currentPath.removeLast();//removing last
                totalTime-=flightMap.getCityList().get(flightMap.indexOf(current.getName())).getDirectFlights().get(i).getTime();
                totalCost-=flightMap.getCityList().get(flightMap.indexOf(current.getName())).getDirectFlights().get(i).getCost();
            }
            else if(!marked[flightMap.indexOf(adjacentCities.get(i).getName())])
            {
                currentPath.add(flightMap.getCityList().get(flightMap.indexOf(adjacentCities.get(i).getName())));
                totalTime+=flightMap.getCityList().get(flightMap.indexOf(current.getName())).getDirectFlights().get(i).getTime();
                totalCost+=flightMap.getCityList().get(flightMap.indexOf(current.getName())).getDirectFlights().get(i).getCost();
                marked[flightMap.indexOf(adjacentCities.get(i).getName())] = true;
                printAllPaths(currentPath, marked, flightMap.getCityList().get(flightMap.indexOf(adjacentCities.get(i).getName())), last, totalTime, totalCost);
                marked[flightMap.indexOf(adjacentCities.get(i).getName())] = false;
                currentPath.removeLast();//removing last
                totalTime-=flightMap.getCityList().get(flightMap.indexOf(current.getName())).getDirectFlights().get(i).getTime();
                totalCost-=flightMap.getCityList().get(flightMap.indexOf(current.getName())).getDirectFlights().get(i).getCost();
            }
        }
    }

    public void sortPaths(boolean findCost)
    {
        if(findCost)
            sortStack(costStack,path,timeStack);
        else
            sortStack(timeStack,path,costStack);
        int totalPath = 1;
        while(!path.isEmpty())
        {
            LinkedList<City> temp = path.pop();
            System.out.print("PATH "+ totalPath +": ");
            totalPath++;
            for(int j=0; j<temp.size(); j++)
            {
                if(j==temp.size()-1) {
                    System.out.println(temp.get(j).getName()+". Time: "+timeStack.pop()+" Cost: "+costStack.pop());
                }
                else
                    System.out.print(temp.get(j).getName()+ " -> ");
            }
            if(totalPath ==4)
                break;
        }
    }

    public void sortStack(Stack<Double> stack, Stack<LinkedList<City>> cityStack, Stack<Double> otherStack) {
        if (!stack.isEmpty()) {
            // Remove the top item
            Double top = stack.pop();
            LinkedList<City> cityTop = cityStack.pop();
            Double otherTop = otherStack.pop();

            // Sort the remaining stack
            sortStack(stack, cityStack, otherStack);

            // Insert the top item back in sorted order
            sortedInsert(stack, top, cityStack, cityTop, otherStack, otherTop);
        }
    }

    private void sortedInsert(Stack<Double> stack, Double item, Stack<LinkedList<City>> cityStack, LinkedList<City> cityItem, Stack<Double> otherStack, double otherItem) {
        // Base case: Either stack is empty or newly inserted
        // item is greater than top (more than all existing)
        if (stack.isEmpty() || item < stack.peek()) {
            stack.push(item);
            cityStack.push(cityItem);
            otherStack.push(otherItem);
            return;
        }

        // If top is greater, remove the top item and recur
        Double temp = stack.pop();
        LinkedList<City> cityTemp = cityStack.pop();
        Double otherTemp = otherStack.pop();

        sortedInsert(stack, item, cityStack, cityItem, otherStack, otherItem);

        // Put back the top item removed earlier
        stack.push(temp);
        cityStack.push(cityTemp);
        otherStack.push(otherTemp);
    }
}