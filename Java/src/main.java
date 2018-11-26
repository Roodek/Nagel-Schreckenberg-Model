import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import javafx.util.Duration;
import java.util.Random;


public class main extends Application {

    Button button1;
    Button button2;
    Circle circle;
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Hey i'm a window");
        button1 = new Button();
        button2 = new Button();
        circle = new Circle();
        Pane layout = new Pane();
        circle.setRadius(5.0);


        circle.setCenterX(150.0);
        circle.setCenterY(200.0);



        layout.getChildren().add(button1);
        layout.getChildren().add(button2);
        layout.getChildren().add(circle);


        double s =  500;
        double v = 1200;
        double t = s/v;

        button1.setText("time="+t);
        button2.setText("speed="+s/t);
        button1.setLayoutX(200);
        button1.setLayoutY(50);
        button2.setLayoutX(300);
        button2.setLayoutY(50);

        Duration duration = Duration.seconds(4.0);
        TranslateTransition transition = new TranslateTransition(duration, circle);

        transition.setByX(s);
        transition.setByY(0);
        transition.setAutoReverse(true);
        transition.setCycleCount(Timeline.INDEFINITE);
        transition.play();

        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
