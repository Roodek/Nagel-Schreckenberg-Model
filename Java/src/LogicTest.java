import dataTypes.Crossroad;
import dataTypes.Road;
import dataTypes.Vehicle;

public class LogicTest {
    public static void main(String[] args) {
        double[] crossroadPos = new double[]{1,1};
        double[] vehiclePos = new double[]{1,1};

        Road road = new Road(10);
        Road road1 = new Road(11);
        Road road2 = new Road(12);
        Vehicle vehicle = new Vehicle(vehiclePos,12,10);
        road.addVehicleToList(vehicle);
        Crossroad crossroad = new Crossroad(crossroadPos);
        crossroad.addRoadToList(road);
        crossroad.addRoadToList(road1);
        crossroad.addRoadToList(road2);


        vehicle.changeRoadAtCrossroad(crossroad);


    }
}
