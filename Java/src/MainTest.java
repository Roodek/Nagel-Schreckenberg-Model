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


        Road road = new Road(10);
        road.addVehicleToList(vehicle1);
        road.addVehicleToList(vehicle2);
        road.addVehicleToList(vehicle3);
        road.addVehicleToList(vehicle4);


        //going test
        for(int i =0; i<15;i++){
            for(Vehicle j : carArray){
                j.updateSpeed();

                j.TestMove();
                j.calcNextVehicleDistance();
            }
        }
        for(Vehicle j : carArray){
            System.out.println("speed: "+j.speed+" nextVehicleDistance: "+j.nextVehicleDistance+" safeDistance: "+j.safeDistance+" position: "+j.getPosition()[0]+","+j.getPosition()[1]);
        }

        System.out.println("next test");

        //dodaje samochód poruszający się wolno tak aby pozostałe samochody musiały dopasowac prędkość

        double[] e = {-120.0,5.0};
        Vehicle slowCar = new Vehicle(e,7.0);
        road.addVehicleOnTop(slowCar);
        vehicle1.setVehicleInFront(slowCar);


        for(int i =0; i<31;i++){
            slowCar.TestMove();
            for(Vehicle j : carArray){
                j.updateSpeed();

                j.TestMove();
                j.calcNextVehicleDistance();
            }

        }
        for(Vehicle j : carArray){
            System.out.println("speed: "+j.speed+" nextVehicleDistance: "+j.nextVehicleDistance+" safeDistance: "+j.safeDistance+" position: "+j.getPosition()[0]+","+j.getPosition()[1]);
        }
        System.out.println("slowcar");
        System.out.println("speed: "+slowCar.speed+" nextVehicleDistance: "+slowCar.nextVehicleDistance+" safeDistance: "+slowCar.safeDistance+" position: "+slowCar.getPosition()[0]+","+slowCar.getPosition()[1]);


    }
}
