package mapRenderer;

import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import mapRenderer.utils.StreetQuantity;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ChartsView extends Stage {
    private NumberAxis xAxis = new NumberAxis();
    private NumberAxis yAxis = new NumberAxis();
    private LineChart<Number, Number> chart = new LineChart<>(xAxis, yAxis);
    private ComboBox<Street> streetsBox = new ComboBox<>();
    private VBox content = new VBox(10, new Label("Ulica"), streetsBox, chart);
    private MainWindow mainWindow;
    private XYChart.Series<Number, Number> series = new XYChart.Series<>();

    public ChartsView(MainWindow mainWindow, List<Street> streets){
        super();
        this.mainWindow = mainWindow;
        build(streets);
        setEvents();
        series.setName("Liczba samochodów na drodze");
    }

    private void setEvents() {
        streetsBox.setOnAction(e -> {
            if(streetsBox.getValue() != null){
                ObservableList<StreetQuantity> list = mainWindow.getStreetData(streetsBox.getValue());
                series.getData().clear();
                series.setName("Liczba samochodów na drodze");
                list.addListener((ListChangeListener<StreetQuantity>) change -> {
                    while(change.next()){}
                    redraw(change.getAddedSubList());
                });
            }
        });
    }

    private void redraw(List<? extends StreetQuantity> list) {
        Platform.runLater(() -> {
            series.getData().addAll(
                    list.stream()
                            .map(sq -> new XYChart.Data<>(sq.getTime(), sq.getQuantity()))
                            .collect(Collectors.toCollection(LinkedList::new))
            );
            XYChart.Data<Number, Number> data = series.getData().get(series.getData().size() - 1);
            if(data != null) {
                series.setName("Liczba samochodów na drodze: " + data.getYValue());
            }
        });
    }

    private void build(List<Street> streets) {
        Scene scene = new Scene(content);
        setScene(scene);
        setAlwaysOnTop(true);
        streetsBox.getItems().setAll(streets);
        chart.getData().add(series);
    }
}
