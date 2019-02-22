package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jdk.jshell.JShell;

import java.net.Socket;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        root = FXMLLoader.load(getClass().getResource("Front.fxml"));
        primaryStage.setTitle("JDK 9.0.4 Demo");
        Scene scene = new Scene(root, 1200, 650);
        window = primaryStage;
        scene.getStylesheets().add(getClass().getResource("frontstyle.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    static JShell js;
    static Socket socket;
    static Stage window;
    static Parent root;

    public static void main(String[] args) throws Exception {
        //new Thread(() -> {
        varInit();
        System.out.println(js.eval("5+6").get(0).value());
        //});
        socket = new Socket("localhost", 6987);
        launch(args);
    }

    static void varInit() {
        js = JShell.create();
        js.eval("double q=0, r=0, s=0, t=0, u=0, v=0, w=0, x=0, y=0, z=0;");
    }

}
