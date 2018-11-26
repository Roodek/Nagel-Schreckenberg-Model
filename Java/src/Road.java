import java.util.LinkedList;
import java.util.List;

public class Road {
    double speedLimit;
    List<Vehicle> vehiclesOnRoad;

    public Road(double speedLimit){
        this.speedLimit =speedLimit;
        vehiclesOnRoad = new LinkedList<>();
    }

    public double getClosestVehicle(Vehicle vehicle){

        double distanceBetweenVehicles = Double.POSITIVE_INFINITY;
        double distance;

        for(Vehicle i:vehiclesOnRoad){
            if (i == vehicle) { continue; }
            distance = getDistanceBetweenPoints(i.getPosition(),vehicle.getPosition());
            distanceBetweenVehicles = getSmallerNumber(distance,distanceBetweenVehicles);
        }
        return distanceBetweenVehicles;
    }

    public Vehicle getVehicleInFront(Vehicle vehicle){
        if(vehiclesOnRoad.indexOf(vehicle)>0) {
            return vehiclesOnRoad.get(vehiclesOnRoad.indexOf(vehicle)-1);
        }else{
            return vehicle;
        }
    }
    public void popVehicleFromList(Vehicle vehicle){
        vehiclesOnRoad.remove(vehicle);
    }

    public void addVehicleToList(Vehicle vehicle){
        if(vehiclesOnRoad.size() == 0){
            vehiclesOnRoad.add(vehicle);
        }else{
            vehiclesOnRoad.add(vehicle);
            vehicle.nextVehicleDistance = getDistanceBetweenPoints(getVehicleInFront(vehicle).getPosition(),vehicle.getPosition());
        }
    }
    public double getSmallerNumber(double a, double b){
        if(a<b){return a;}
        else return b;
    }

    public double GetDistanceFromNextVehicle(Vehicle vehicle){
        return getDistanceBetweenPoints(vehicle.getPosition(),getVehicleInFront(vehicle).getPosition());
    }

    public double getDistanceBetweenPoints(double[] a, double[] b){
        return Math.sqrt(Math.pow(a[0] - b[0],2) + Math.pow(a[1] - b[1],2));
    }
}
