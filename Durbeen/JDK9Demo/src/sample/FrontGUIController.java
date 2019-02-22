package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class FrontGUIController implements Initializable {
    @FXML ImageView frontimage;
    @FXML ImageView specimage;
    @FXML Pane frontPane;

    @FXML Circle circle1;
    @FXML Circle circle2;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        circle1.setOpacity(0);
        circle2.setOpacity(0);
        circle1.setCursor(Cursor.HAND);
        circle2.setCursor(Cursor.HAND);

        circle1.setOnMouseEntered(e->{
            circle1.setOpacity(0.4);
        });
        circle2.setOnMouseEntered(e->{
            circle2.setOpacity(0.4);
        });

        circle1.setOnMouseExited(e->{
            circle1.setOpacity(0);
        });
        circle2.setOnMouseExited(e->{
            circle2.setOpacity(0);
        });

        FileInputStream input = null;
        try {
            input = new FileInputStream("src\\sample\\front3.png");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
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

    @FXML private void goToCode() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample2.fxml"));
        Main.window.setTitle("JDK 9.0.4");
        Scene scene = new Scene(root,1200,650);
        //scene.getStylesheets().add(getClass().getResource("frontstyle.css").toExternalForm());
        Main.window.setScene(scene);
        //primaryStage.show();
    }

    @FXML private void goToLoad() throws Exception{
        Parent parent = FXMLLoader.load(getClass().getResource("loading.FXML"));
        Scene scene = new Scene(parent, 1200, 650);
        Main.window.setScene(scene);
        Main.window.setTitle("Project Library");
        PrintWriter writer = new PrintWriter(Main.socket.getOutputStream(), true);
        writer.println("LOAD_ALL");
        Scanner scanner = new Scanner(Main.socket.getInputStream());
        String a = "", b = "";
        while(scanner.hasNextLine()){
            a = scanner.nextLine();
            if(a.equalsIgnoreCase("TRANSMISSION_OVER"))
                break;
            b = scanner.nextLine();
            Loading.addItem(a,b);
            System.out.println("a: " + a + " & b: " + b);
        }
        System.out.println("Over");
    }
}
