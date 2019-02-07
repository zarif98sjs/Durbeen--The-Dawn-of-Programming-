package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.SQLOutput;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        root.setId("token");
        Scene scene = new Scene(root,1100,700);
        scene.getStylesheets().add(getClass().getResource("stylecss.css").toExternalForm());
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
        System.out.println("asdasf");
    }


    public static void main(String[] args) {
        launch(args);
    }
}
