



public class MainTest {

    public static void main(String[] args){
        double[] a = {2.0,5.0};
        double[] b = {3.0,5.0};
        double[] c = {4.0,5.0};
        double[] d = {5.0,5.0};


        Vehicle vehicle1 = new Vehicle(a,5);
        Vehicle vehicle2 = new Vehicle(b,5);
        Vehicle vehicle3 = new Vehicle(c,5);
        Vehicle vehicle4 = new Vehicle(d,5);

        Road road = new Road(10);
        road.addVehicleToList(vehicle1);
        road.addVehicleToList(vehicle2);
        road.addVehicleToList(vehicle3);
        road.addVehicleToList(vehicle4);

        System.out.println(road.getVehicleInFront(vehicle3).getPosition()[0]);

        System.out.println(vehicle4.nextVehicleDistance);

    }
}
