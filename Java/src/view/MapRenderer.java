package view;

import dataTypes.Road;
import dataTypes.Vehicle;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.LinkedList;

public class MapRenderer extends Pane {
    private LinkedList<Line> lines = new LinkedList<>();
    private LinkedList<Road> roads = new LinkedList<>();
    private LinkedList<Vehicle> vehicles = new LinkedList<>();
    private View view = new View(this);
    public MapRenderer() {
        super();
    }

    public void showStage(){
        view.show();
    }

    public void addRoad(Road road, double startX, double startY, double endX, double endY) {
        roads.add(road);
        Line line = new Line();
        line.setStrokeWidth(5);
        line.setStartX(startX);
        line.setStartY(startY);
        line.setEndX(endX);
        line.setEndY(endY);
        line.setStroke(Color.rgb(100,100,100));
        lines.add(line);
        refresh();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void refresh() {
        getChildren().setAll(lines);
        drawVehicles();
    }

    private void drawVehicles() {
        vehicles.forEach(v -> getChildren().add(circleFromVehicle(v)));
    }

    private Circle circleFromVehicle(Vehicle v) {
        Circle circle = new Circle();
        circle.setFill(v.getColor());
        circle.setRadius(4);
        circle.setStroke(Color.TRANSPARENT);
        circle.setCenterY(v.getRoad().getY());
        circle.setCenterX(v.getPos()[0] + v.getRoad().getX());
        Text text = new Text(v.getSpeed() + "");
        text.setLayoutX(v.getPos()[0] + v.getRoad().getX());
        text.setFont(new Font(10));
        text.setLayoutY(v.getRoad().getY() - 10);
        getChildren().add(text);
        return circle;
    }
}
