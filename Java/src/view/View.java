package view;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class View extends Stage {
    private VBox mainBox = new VBox(10);
    private Scene scene = new Scene(mainBox);
    public View() {
        super();
        this.setScene(scene);
        scene.setFill(Color.WHITE);
        this.setMinWidth(1000);
        this.setMinHeight(500);
    }

    public View(MapRenderer mapRenderer) {
        this();
        mainBox.getChildren().setAll(mapRenderer);
    }
}
