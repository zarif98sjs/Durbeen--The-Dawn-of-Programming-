package sample;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {
    @FXML private Image image;// = new Image("File:///D:/GoT_img.png");
    @FXML private ImageView imageView;// = new ImageView(image);
    @FXML private HBox hb1, hb2, hb3;
    @FXML private VBox vb1, vb2, vb3;
    @FXML private Button bt1, bt2, bt3, bt4, bt5;
    @FXML private fButton b1 = new fButton();
    @FXML private TextField tx1, tx2, tx3, tx4, tx5;

    public Controller() {
    }

    @FXML private void func()
    {
        System.out.println("Hello, world");
    }

    @FXML private Button but_motion, but_look, but_sound, but_pen, but_data, but_event, but_control, but_sensing, but_operators, but_blocks;

    @FXML private VBox init_box;

    //@FXML private Button new_button
    // ;

    private boolean flaginitializeMethods = true;

    public void setButtonProperties(Button bt1) {
        bt1.applyCss();
        bt1.setLayoutX(10);
        bt1.setLayoutY(10);
        bt1.setPrefHeight(60.0);
        bt1.setPrefWidth(113.0);
    }

    public void setTextFieldProperties(TextField bt1){
        bt1.applyCss();
        bt1.setLayoutX(10);
        bt1.setLayoutY(10);
        bt1.setPrefHeight(60.0);
        bt1.setPrefWidth(113.0);
    }

    public void initializeMethods() {
        if(flaginitializeMethods){
            System.out.println("Hello, world");
            bt1 = new Button("Move");
            bt2 = new Button("Rotate");
            tx1 = new TextField();
            tx2 = new TextField();
            hb1 = new HBox();
            hb2 = new HBox();
            setButtonProperties(bt1);
            setButtonProperties(bt2);
            setTextFieldProperties(tx1);
            setTextFieldProperties(tx2);
            hb1.getChildren().addAll(bt1, tx1);
            hb2.getChildren().addAll(bt2, tx2);
            init_box.getChildren().addAll(hb1, hb2);
        }
        flaginitializeMethods = false;
    }

    @FXML private void hel()
    {
        System.out.println("Hello, world");
    }


    @FXML private AnchorPane anchor;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        anchor.getChildren().add(b1);
        //b1.setOnMouseClicked(event -> onMouseDragEntered());
    }
/*
    @FXML private void onMouseDragEntered()
    {
        for(int i=1;i<6;++i)
            System.out.println("Mouse Drag entered");
        try {
            fButton b1_child = b1.clone();
            b1_child.setOnMouseClicked(event -> onMouseDragEntered());
            anchor.getChildren().add(b1_child);
        } catch (Exception e){
            ;
        }
    }*/
}
