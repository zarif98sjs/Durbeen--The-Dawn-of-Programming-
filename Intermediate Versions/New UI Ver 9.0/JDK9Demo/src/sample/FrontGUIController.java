package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class FrontGUIController implements Initializable {
    @FXML ImageView frontimage;
    @FXML ImageView specimage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        FileInputStream input = null;
        try {
            input = new FileInputStream("src\\sample\\front3.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image = new Image(input);
        ImageView imageView = new ImageView(image);
        frontimage.setImage(image);
        frontimage.setFitHeight(450);
        frontimage.setFitWidth(850);

        FileInputStream input2 = null;
        try {
            input2 = new FileInputStream("spec.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Image image2 = new Image(input2);
        //ImageView imageView = new ImageView(image);
        specimage.setImage(image2);
        specimage.setFitHeight(500);
        specimage.setFitWidth(800);

    }
}
