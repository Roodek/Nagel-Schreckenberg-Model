import dataTypes.Road;
import dataTypes.Vehicle;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import view.MapRenderer;

import java.util.Arrays;

public class MainTest extends Application {

    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {

        MapRenderer renderer = new MapRenderer();

        double[] a = {2.0,50.0};
        double[] b = {3.0,50.0};
        double[] c = {6.0,50.0};
        double[] d = {10.0,50.0};



        Vehicle vehicle1 = new Vehicle(a,5);
        Vehicle vehicle2 = new Vehicle(b,1);
        Vehicle vehicle3 = new Vehicle(c,8);
        Vehicle vehicle4 = new Vehicle(d,6);



        Vehicle[] carArray = new Vehicle[]{vehicle1,vehicle2,vehicle3,vehicle4};


        Road road = new Road(10);
        road.addVehicleToList(vehicle1);
        road.addVehicleToList(vehicle2);
        road.addVehicleToList(vehicle3);
        road.addVehicleToList(vehicle4);
        road.setX(10);
        road.setY(50);

        vehicle1.setRoad(road);
        vehicle2.setRoad(road);
        vehicle3.setRoad(road);
        vehicle4.setRoad(road);
        renderer.addVehicle(vehicle1);
        renderer.addVehicle(vehicle2);
        renderer.addVehicle(vehicle3);
        renderer.addVehicle(vehicle4);

        renderer.addRoad(road, 10,50,400,50);
        renderer.showStage();

        //going test
        new Thread(() -> {
            for(int i =0; i<1500;i++){
                for(Vehicle j : carArray){
                    j.updateSpeed();
                    j.TestMove();
                    j.calcNextVehicleDistance();
                    System.out.print(Arrays.asList(carArray).indexOf(j) + ". speed: " + j.getSpeed() +"; ");
                }
                System.out.println();
                Platform.runLater(renderer::refresh);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        /*for(int i =0; i<1500;i++){
            for(Vehicle j : carArray){
                j.updateSpeed();
                j.TestMove();
                j.calcNextVehicleDistance();
                renderer.refresh();
            }
        }*/
        /*for(Vehicle j : carArray){
//            System.out.println("speed: "+j.speed+" nextVehicleDistance: "+j.nextVehicleDistance+" safeDistance: "+j.safeDistance+" position: "+j.getPosition()[0]+","+j.getPosition()[1]);
        }*/

//        System.out.println("next test");

        //dodaje samochód poruszający się wolno tak aby pozostałe samochody musiały dopasowac prędkość

        /*double[] e = {120.0,50.0};
        Vehicle slowCar = new Vehicle(e,7.0);
        road.addVehicleOnTop(slowCar);
        vehicle1.setVehicleInFront(slowCar);*/


        /*for(int i =0; i<31;i++){
            slowCar.TestMove();
            for(Vehicle j : carArray){
                j.updateSpeed();

                j.TestMove();
                j.calcNextVehicleDistance();
            }

        }*/
        /*for(Vehicle j : carArray){
//            System.out.println("speed: "+j.speed+" nextVehicleDistance: "+j.nextVehicleDistance+" safeDistance: "+j.safeDistance+" position: "+j.getPosition()[0]+","+j.getPosition()[1]);
        }*/
//        System.out.println("slowcar");
//        System.out.println("speed: "+slowCar.speed+" nextVehicleDistance: "+slowCar.nextVehicleDistance+" safeDistance: "+slowCar.safeDistance+" position: "+slowCar.getPosition()[0]+","+slowCar.getPosition()[1]);

    }
}
