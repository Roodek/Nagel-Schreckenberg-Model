package dataTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Crossroad {

    private double[] pos = new double[2];
    private List<Road> roadList = new ArrayList<>();

    public Crossroad(double[] pos){
        this.pos = pos;
    }
    public Crossroad(){}

    public void addRoadToList(Road road){
        roadList.add(road);
    }

    public Road getRoadFromList(int indexOfRoad){
        return roadList.get(indexOfRoad);
    }
    public Road getRandomRoadFromList(List<Road> roadList){
        Random gen = new Random();
        int randomRoad = gen.nextInt(roadList.size());
        return roadList.get(randomRoad);
    }
    public void setPos(double[] pos) {
        this.pos = pos;
    }
    public List<Road> getRoadList(){
        return this.roadList;
    }
    public double[] getPos() { return pos; }
}
