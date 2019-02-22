package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Pair;

import java.io.Serializable;

public class OneStringUI implements Serializable {

    public static String getString(){
        Stage stage = new Stage(StageStyle.DECORATED);

        stage.setTitle("File Loader");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setMinWidth(200);
        stage.setMinHeight(150);

        String q = "";

        Label label = new Label("Give the file's name to load");
        TextField tf = new TextField(q);
        Button button = new Button("Click here to go");

        button.setOnAction(event -> {
            stage.close();
        });

        VBox vBox = new VBox(12, label, tf, button);
        vBox.setAlignment(Pos.CENTER);

        vBox.setStyle("-fx-background-color: linear-gradient(to right top, #051937, #004d7a, #008793, #00bf72, #a8eb12)");

        stage.setScene(new Scene(vBox, 200, 150));
        stage.showAndWait();

        q = tf.getText();

        System.out.println("q " + q);

        return q;
    }
}
