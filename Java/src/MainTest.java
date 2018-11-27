import java.util.LinkedList;
import java.util.List;

public class MainTest {

    public static void main(String[] args){
        double[] a = {2.0,5.0};
        double[] b = {3.0,5.0};
        double[] c = {4.0,5.0};
        double[] d = {5.0,5.0};



        Vehicle vehicle1 = new Vehicle(a,1);
        Vehicle vehicle2 = new Vehicle(b,1);
        Vehicle vehicle3 = new Vehicle(c,1);
        Vehicle vehicle4 = new Vehicle(d,1);



        Vehicle[] carArray = new Vehicle[]{vehicle1,vehicle2,vehicle3,vehicle4} ;

        for(Vehicle j : carArray){
            j.setSafeDistance(3.0);
        }

        Road road = new Road(10);
        road.addVehicleToList(vehicle1);
        road.addVehicleToList(vehicle2);
        road.addVehicleToList(vehicle3);
        road.addVehicleToList(vehicle4);

        //System.out.println(road.getVehicleInFront(vehicle3).getPosition()[0]);

        //System.out.println(vehicle1.speed);
        for(int i =0; i<150;i++){
            for(Vehicle j : carArray){
                j.TestMove();
                j.calcNextVehicleDistance();
                j.updateSpeed();
            }
        }
        for(Vehicle j : carArray){
            System.out.println("speed: "+j.speed+" nextVehicleDistance: "+j.nextVehicleDistance+" safeDistance: "+j.safeDistance+" position: "+j.getPosition()[0]+","+j.getPosition()[1]);
        }

    }
}
