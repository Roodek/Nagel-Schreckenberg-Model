import java.util.ArrayList;
import java.util.List;

public class Crossroad {

    double[] pos = new double[2];
    List<Road> roadList = new ArrayList<Road>();

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
