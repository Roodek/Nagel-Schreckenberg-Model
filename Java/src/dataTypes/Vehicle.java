package dataTypes;


import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.Random;

public class Vehicle {

    private double[] pos;

    private double speed;
    private double slowDownProbability = 0;
    private double laneChangeProbability = 0;
    private double nextVehicleDistance = 100;
    int scale;

    double speedlimit;
    private double safeDistance;
    private Vehicle vehicleInFront;
    private Road road;

    private Color color = Color.rgb((int)(Math.random() * 255), (int)(Math.random() * 255),(int)(Math.random() * 255));

    public Vehicle(double[] pos, double speed, int scale){
        this.pos = pos;
        this.speed = speed;
        this.scale = scale;
    }
    public Vehicle(){}

    public void updateSpeed(){
        updateSafeDistance();
        //if (this.nextVehicleDistance<5) this.speed=0;
        if (this.vehicleInFront == null)
        {
            if (this.speed > this.speedlimit || this.safeDistance > this.nextVehicleDistance) this.speed = this.slowDown();
            else this.speed = this.accelerate();
            return;
        }
        else if(this.nextVehicleDistance >= this.safeDistance && this.speed < this.speedlimit)//&& this.speed < this.speedlimit )
            this.speed = this.accelerate();
        else if(this.nextVehicleDistance < this.safeDistance){
            this.speed = this.slowDown();
        }


    }


    public void setSafeDistance(double safeDistance) {
        this.safeDistance = safeDistance;
    }

    private void updateSafeDistance(){
        double x=0;
        if(this.vehicleInFront != null) x=this.vehicleInFront.safeDistance/2.0;
        this.safeDistance = 10 - x + this.speed*this.speed/(2*(20/this.scale));
    }
    private double accelerate(){
        double acceleration = Math.max(0, 5.5/this.scale-(this.speed*this.speed*(0.00027/this.scale)));
        return Math.min(this.speedlimit, this.speed+=acceleration);
    }
    private double slowDown(){ return Math.max(0,this.speed-=5.5/this.scale); }

    public double[] getPos() {
        return pos;
    }

    public void calcNextVehicleDistance(){
        if(this.vehicleInFront == null){
            this.nextVehicleDistance = Road.getDistanceBetweenPoints(this.getPosition(),this.road.getEnd());
        }else{
            this.nextVehicleDistance = Road.getDistanceBetweenPoints(this.getPosition(),vehicleInFront.getPosition());
        }
    }

    public void TestMove(){
        double[] newPos = {this.pos[0]+this.speed/this.scale,this.pos[1]};
        this.setPosition(newPos);
    }
    public void changeRoadAtCrossroad(Crossroad crossroad){
        if(this.pos[0] == crossroad.getPos()[0] && this.pos[1] == crossroad.getPos()[1]){
            Crossroad crossroadWithoutEnterRoad = crossroad;
            this.road.popVehicleFromList(this);
            crossroadWithoutEnterRoad.getRoadList().remove(this.road);
            Road newRoad = crossroadWithoutEnterRoad.getRandomRoadFromList(crossroadWithoutEnterRoad.getRoadList());
            this.setRoad(newRoad);
        }
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
        road.addVehicleToList(this);
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
