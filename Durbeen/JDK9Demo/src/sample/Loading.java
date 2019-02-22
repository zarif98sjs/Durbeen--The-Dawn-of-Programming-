package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

class Item extends HBox {

    String name;

    Item(int i, String b, String c) {
        //super(20);
        String a = i + "";
        Button b1 = new Button(a);
        Button b2 = new Button(b);
        Button b3 = new Button(c);
        b1.setMinWidth(100);b2.setMinWidth(300);b3.setMinWidth(585);
        b1.setMinHeight(40);b2.setMinHeight(40);b3.setMinHeight(40);
        b1.setStyle("-fx-text-fill: white;-fx-background-color: #00cc66;-fx-border-color: snow");
        b2.setStyle("-fx-text-fill: white;-fx-background-color: #00994d;-fx-border-color: snow");
        b3.setStyle("-fx-text-fill: white;-fx-background-color: #004d26;-fx-border-color: snow");
        name = b;
        getChildren().addAll(b1, b2, b3);
        setOnMouseClicked(event -> run());
        b1.setOnAction(event -> run());
        b2.setOnAction(event -> run());
        b3.setOnAction(event -> run());
    }

    String getName() {
        return name;
    }

    void run(){
        System.out.println("MOUSE CLICKED ON ITEM ! !! !!!");
        try {
            Controller.getCodeBox(name);
            Scene scene = new Scene(Loading.root,1200,650);
            Main.window.setScene(scene);
            Main.window.setTitle("Loaded scope");
        } catch (Exception e) {
            System.out.println("ExceptionOnMouseClicked: " + e);
        }
    }

    //setOnAction
}

public class Loading implements Initializable {


    static int iLoad = 0;

    @FXML
    private VBox loadBox;
    private static VBox loadingBox = new VBox();

    static Parent root;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            root = FXMLLoader.load(getClass().getResource("sample2.fxml"));
        } catch (Exception e) {
            root = new HBox();
        }
        loadingBox = loadBox;
        //loadingBox.setSpacing(10);
        System.out.println("QWERTY");
    }

    static void addItem(String a, String b) {
        ++iLoad;
        loadingBox.getChildren().add(new Item(iLoad, a, b));
        for (Node p : loadingBox.getChildren()) {
            System.out.println(p);
        }
    }

}