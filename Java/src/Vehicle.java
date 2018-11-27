


public class Vehicle {

    double[] pos = new double[2];

    double speed;
    double slowDownProbability = 0;
    double laneChangeProbability = 0;
    double nextVehicleDistance ;

    double speedlimit;
    double safeDistance;
    Vehicle vehicleInFront;

    public Vehicle(double[] pos, double speed){
        this.pos = pos;
        this.speed = speed;

    }

    public void updateSpeed(){
        if(this.nextVehicleDistance == 0 && this.speed < this.speedlimit ){
            this.accelerate();
            return;
        }
        if(this.nextVehicleDistance >= this.safeDistance && this.speed < this.speedlimit )
            this.speed = this.accelerate();
        else{
            this.speed = this.slowDown();
        }

    }


    public void setSafeDistance(double safeDistance) {
        this.safeDistance = safeDistance;
    }

    public double accelerate(){
        return Math.min(this.speedlimit, this.speed+=1);
    }
    public double slowDown(){
        return Math.max(0,this.speed-=1);
    }


    public void calcNextVehicleDistance(){
        if(this.vehicleInFront == null){
            this.nextVehicleDistance = 0;
        }else{
            this.nextVehicleDistance = Road.getDistanceBetweenPoints(this.getPosition(),vehicleInFront.getPosition());
        }
    }

    public void TestMove(){
        double[] newPos = {this.pos[0]-this.speed,this.pos[1]};
        this.setPosition(newPos);
    }

    public void setPosition(double[] pos){
        this.pos = pos;
    }
    public double[] getPosition() { return this.pos; }

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
}
