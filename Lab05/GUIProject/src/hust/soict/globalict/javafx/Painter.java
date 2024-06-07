package hust.soict.globalict.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class Painter extends Application{
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass()
                .getResource("src/hust/soict/globalict/javafx/Painter.fxml"));
        Scene scene =new Scene(root);
        stage.setTitle("Painter");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args){
        launch(args);
    }
}