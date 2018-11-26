


public class Vehicle {

    double[] pos = new double[2];

    double speed;
    double slowDownProbability = 0;
    double laneChangeProbability = 0;
    double nextVehicleDistance ;

    double speedlimit;
    double safeDistance;

    public Vehicle(double[] pos, double speed){
        this.pos = pos;
        this.speed = speed;

    }

    public void updateSpeed(){
        if(this.nextVehicleDistance >= this.safeDistance)
            this.speed = accelerate();
        else{
            this.speed = slowDown();
        }

    }

    public double accelerate(){
        return Math.min(this.speedlimit, this.speed+=1);
    }
    public double slowDown(){
        return Math.max(0,this.speed-=1);
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

    public double getLaneChangeProbability() {
        return laneChangeProbability;
    }

    public double getSlowDownProbability() {
        return slowDownProbability;
    }
}
