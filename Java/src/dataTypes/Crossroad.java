package dataTypes;

import java.util.ArrayList;
import java.util.List;

public class Crossroad {

    private double[] pos = new double[2];
    private List<Road> roadList = new ArrayList<>();

    public Crossroad(double[] pos){
        this.pos = pos;
    }

    public void addRoadToList(Road road){
        roadList.add(road);
    }

    public void setPos(double[] pos) {
        this.pos = pos;
    }

    public double[] getPos() { return pos; }
}
