package dataTypes;


import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class Vehicle {

    private double[] pos;

    private double speed;
    private double slowDownProbability = 0;
    private double laneChangeProbability = 0;
    private double nextVehicleDistance ;

    double speedlimit;
    private double safeDistance;
    private Vehicle vehicleInFront;
    private Road road;

    private Color color = Color.rgb((int)(Math.random() * 255), (int)(Math.random() * 255),(int)(Math.random() * 255));

    public Vehicle(double[] pos, double speed){
        this.pos = pos;
        this.speed = speed;
    }

    public void updateSpeed(){
        updateSafeDistance();
        if(this.nextVehicleDistance == 0 && this.speed < this.speedlimit ){
            this.accelerate();
            return;
        }
        if(this.nextVehicleDistance == 0 && this.speed == this.speedlimit) {
            return;
        }
        if(this.nextVehicleDistance >= this.safeDistance && this.speed < this.speedlimit)//&& this.speed < this.speedlimit )
            this.speed = this.accelerate();
        else if(this.nextVehicleDistance < this.safeDistance){
            this.speed = this.slowDown();
        }


    }


    public void setSafeDistance(double safeDistance) {
        this.safeDistance = safeDistance;
    }

    private void updateSafeDistance(){
        this.safeDistance = this.speed;
    }
    private double accelerate(){
        return Math.min(this.speedlimit, this.speed+=1);
    }
    private double slowDown(){
        return Math.max(0,this.speed-=1);
    }

    public double[] getPos() {
        return pos;
    }

    public void calcNextVehicleDistance(){
        if(this.vehicleInFront == null){
            this.nextVehicleDistance = 0;
        }else{
            this.nextVehicleDistance = Road.getDistanceBetweenPoints(this.getPosition(),vehicleInFront.getPosition());
        }
    }

    public void TestMove(){
        double[] newPos = {this.pos[0]+this.speed,this.pos[1]};
        this.setPosition(newPos);
    }
    public void TestMoveStop(){
        double[] newPos = {this.pos[0]+this.speed,this.pos[1]};
        this.setPosition(newPos);
    }

    private void setPosition(double[] pos){
        this.pos = pos;
    }
    double[] getPosition() { return this.pos; }

    public void setNextVehicleDistance(double nextVehicleDistance) {
        this.nextVehicleDistance = nextVehicleDistance;
    }

    public void setLaneChangeProbability(double laneChangeProbability) {
        this.laneChangeProbability = laneChangeProbability;
    }

    public void setSlowDownProbability(double slowDownProbability) {
        this.slowDownProbability = slowDownProbability;
    }
    public void setVehicleInFront(Vehicle vehicle){
        this.vehicleInFront = vehicle;
        this.nextVehicleDistance = Road.getDistanceBetweenPoints(this.getPosition(),vehicle.getPosition());
    }

    public double getLaneChangeProbability() {
        return laneChangeProbability;
    }

    public double getSlowDownProbability() {
        return slowDownProbability;
    }

    public void setRoad(Road road) {
        this.road = road;
    }
    public Road getRoad() {
        return this.road;
    }

    public Color getColor() {
        return color;
    }

    public double getSpeed() {
        return speed;
    }
}
