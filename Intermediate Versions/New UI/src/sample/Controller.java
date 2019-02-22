package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;



public class Controller implements Initializable {


    @FXML private HBox h1;
    @FXML private HBox h2;
    @FXML private HBox h3;
    @FXML private HBox h4;
    @FXML private HBox h5;
    @FXML private HBox h6;
    @FXML private HBox h7;
    @FXML private HBox h8;
    @FXML private HBox h9;
    @FXML private HBox h10;
    @FXML private HBox h11;
    @FXML private HBox h12;

    TextField t1= new TextField();
    TextField t2= new TextField();
    TextField t3= new TextField();
    TextField t4= new TextField();
    TextField t5= new TextField();
    TextField t6= new TextField();
    TextField t7= new TextField();
    TextField t8= new TextField();
    TextField t9= new TextField();
    TextField t10= new TextField();
    TextField t11= new TextField();
    TextField t12= new TextField();

    Button btn1 = new Button("",t1);
    Button btn2 = new Button("",t2);
    Button btn3 = new Button("",t3);
    Button btn4 = new Button("",t4);
    Button btn5 = new Button("",t5);
    Button btn6 = new Button("",t6);
    Button btn7 = new Button("",t7);
    Button btn8 = new Button("",t8);
    Button btn9 = new Button("",t9);
    Button btn10 = new Button("",t10);
    Button btn11 = new Button("",t11);
    Button btn12 = new Button("",t12);


    public void init_text_button()
    {
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
        t7.setText("");
        t8.setText("");
        t9.setText("");
        t10.setText("");
        t11.setText("");
        t12.setText("");

/*
        t1.setMinSize(45,40);
        t2.setMinSize(45,40);
        t3.setMinSize(45,40);
        t4.setMinSize(45,40);
        t5.setMinSize(45,40);
        t6.setMinSize(45,40);
        t7.setMinSize(45,40);
        t8.setMinSize(45,40);
        t9.setMinSize(45,40);
        t10.setMinSize(45,40);
        t11.setMinSize(45,40);
        t12.setMinSize(45,40);
*/

        t1.setMaxSize(45,40);
        t2.setMaxSize(45,40);
        t3.setMaxSize(45,40);
        t4.setMaxSize(45,40);
        t5.setMaxSize(45,40);
        t6.setMaxSize(45,40);
        t7.setMaxSize(45,40);
        t8.setMaxSize(45,40);
        t9.setMaxSize(45,40);
        t10.setMaxSize(45,40);
        t11.setMaxSize(45,40);
        t12.setMaxSize(45,40);

        btn1.setMinSize(226,41);
        btn2.setMinSize(226,41);
        btn3.setMinSize(226,41);
        btn4.setMinSize(226,41);
        btn5.setMinSize(226,41);
        btn6.setMinSize(226,41);
        btn7.setMinSize(226,41);
        btn8.setMinSize(226,41);
        btn9.setMinSize(226,41);
        btn10.setMinSize(226,41);
        btn11.setMinSize(226,41);
        btn12.setMinSize(226,41);

        h1.getChildren().removeAll(btn1);
        h2.getChildren().removeAll(btn2);
        h3.getChildren().removeAll(btn3);
        h4.getChildren().removeAll(btn4);
        h5.getChildren().removeAll(btn5);
        h6.getChildren().removeAll(btn6);
        h7.getChildren().removeAll(btn7);
        h8.getChildren().removeAll(btn8);
        h9.getChildren().removeAll(btn9);
        h10.getChildren().removeAll(btn10);
        h11.getChildren().removeAll(btn11);
        h12.getChildren().removeAll(btn12);
    }

    public void init_motion_button_color()
    {
        btn1.setStyle("-fx-background-color: #6699ff;" + "-fx-text-fill:snow;" +
                "-fx-padding: 6 6 6 6;" + "-fx-border-color: darkblue;" +
                "fx-border-radius: 4;"+ "-fx-font-weight: bold;"+
                "-fx-alignment: center-left");
        btn2.setStyle("-fx-background-color: #6699ff;" + "-fx-text-fill:snow;" +
                "-fx-padding: 6 6 6 6;" + "-fx-border-color: darkblue;" +
                "fx-border-radius: 4;"+ "-fx-font-weight: bold;"+
                "-fx-alignment: center-left");
        btn3.setStyle("-fx-background-color: #6699ff;" + "-fx-text-fill:snow;" +
                "-fx-padding: 6 6 6 6;" + "-fx-border-color: darkblue;" +
                "fx-border-radius: 4;"+ "-fx-font-weight: bold;" +
                "-fx-alignment: center-left");
        btn4.setStyle("-fx-background-color: #6699ff;" + "-fx-text-fill:snow;" +
                "-fx-padding: 6 6 6 6;" + "-fx-border-color: darkblue;" +
                "fx-border-radius: 4;"+ "-fx-font-weight: bold;"+
                "-fx-alignment: center-left");
        btn5.setStyle("-fx-background-color: #6699ff;" + "-fx-text-fill:snow;" +
                "-fx-padding: 6 6 6 6;" + "-fx-border-color: darkblue;" +
                "fx-border-radius: 4;"+ "-fx-font-weight: bold;"+
                "-fx-alignment: center-left");
        btn6.setStyle("-fx-background-color: #6699ff;" + "-fx-text-fill:snow;" +
                "-fx-padding: 6 6 6 6;" + "-fx-border-color: darkblue;" +
                "fx-border-radius: 4;"+ "-fx-font-weight: bold;"+
                "-fx-alignment: center-left");
        btn7.setStyle("-fx-background-color: #6699ff;" + "-fx-text-fill:snow;" +
                "-fx-padding: 6 6 6 6;" + "-fx-border-color: darkblue;" +
                "fx-border-radius: 4;"+ "-fx-font-weight: bold;"+
                "-fx-alignment: center-left");
        btn8.setStyle("-fx-background-color: #6699ff;" + "-fx-text-fill:snow;" +
                "-fx-padding: 6 6 6 6;" + "-fx-border-color: darkblue;" +
                "fx-border-radius: 4;"+ "-fx-font-weight: bold;"+
                "-fx-alignment: center-left");
        btn9.setStyle("-fx-background-color: #6699ff;" + "-fx-text-fill:snow;" +
                "-fx-padding: 6 6 6 6;" + "-fx-border-color: darkblue;" +
                "fx-border-radius: 4;"+ "-fx-font-weight: bold;"+
                "-fx-alignment: center-left");
        btn10.setStyle("-fx-background-color: #6699ff;" + "-fx-text-fill:snow;" +
                "-fx-padding: 6 6 6 6;" + "-fx-border-color: darkblue;" +
                "fx-border-radius: 4;"+ "-fx-font-weight: bold;"+
                "-fx-alignment: center-left");
        btn11.setStyle("-fx-background-color: #6699ff;" + "-fx-text-fill:snow;" +
                "-fx-padding: 6 6 6 6;" + "-fx-border-color: darkblue;" +
                "fx-border-radius: 4;"+ "-fx-font-weight: bold;"+
                "-fx-alignment: center-left");
        btn12.setStyle("-fx-background-color: #6699ff;" + "-fx-text-fill:snow;" +
                "-fx-padding: 6 6 6 6;" + "-fx-border-color: darkblue;" +
                "fx-border-radius: 4;"+ "-fx-font-weight: bold;"+
                "-fx-alignment: center-left");


    }

    public void init_looks_button_color()
    {
        btn1.setStyle("-fx-background-color:  #9900cc;" + "-fx-text-fill:snow;" +
                "-fx-padding: 6 6 6 6;" + "-fx-border-color: #4d0099;" +
                "fx-border-radius: 4;"+ "-fx-font-weight: bold;"+
                "-fx-alignment: center-left");
        btn2.setStyle("-fx-background-color:  #9900cc;" + "-fx-text-fill:snow;" +
                "-fx-padding: 6 6 6 6;" + "-fx-border-color: #4d0099;" +
                "fx-border-radius: 4;"+ "-fx-font-weight: bold;"+
                "-fx-alignment: center-left");
        btn3.setStyle("-fx-background-color:  #9900cc;" + "-fx-text-fill:snow;" +
                "-fx-padding: 6 6 6 6;" + "-fx-border-color: #4d0099;" +
                "fx-border-radius: 4;"+ "-fx-font-weight: bold;"+
                "-fx-alignment: center-left");
        btn4.setStyle("-fx-background-color:  #9900cc;" + "-fx-text-fill:snow;" +
                "-fx-padding: 6 6 6 6;" + "-fx-border-color: #4d0099;" +
                "fx-border-radius: 4;"+ "-fx-font-weight: bold;"+
                "-fx-alignment: center-left");
        btn5.setStyle("-fx-background-color:  #9900cc;" + "-fx-text-fill:snow;" +
                "-fx-padding: 6 6 6 6;" + "-fx-border-color: #4d0099;" +
                "fx-border-radius: 4;"+ "-fx-font-weight: bold;"+
                "-fx-alignment: center-left");
        btn6.setStyle("-fx-background-color:  #9900cc;" + "-fx-text-fill:snow;" +
                "-fx-padding: 6 6 6 6;" + "-fx-border-color: #4d0099;" +
                "fx-border-radius: 4;"+ "-fx-font-weight: bold;"+
                "-fx-alignment: center-left");
        btn7.setStyle("-fx-background-color:  #9900cc;" + "-fx-text-fill:snow;" +
                "-fx-padding: 6 6 6 6;" + "-fx-border-color: #4d0099;" +
                "fx-border-radius: 4;"+ "-fx-font-weight: bold;"+
                "-fx-alignment: center-left");
        btn8.setStyle("-fx-background-color:  #9900cc;" + "-fx-text-fill:snow;" +
                "-fx-padding: 6 6 6 6;" + "-fx-border-color: #4d0099;" +
                "fx-border-radius: 4;"+ "-fx-font-weight: bold;"+
                "-fx-alignment: center-left");
        btn9.setStyle("-fx-background-color:  #9900cc;" + "-fx-text-fill:snow;" +
                "-fx-padding: 6 6 6 6;" + "-fx-border-color: #4d0099;" +
                "fx-border-radius: 4;"+ "-fx-font-weight: bold;"+
                "-fx-alignment: center-left");
        btn10.setStyle("-fx-background-color:  #9900cc;" + "-fx-text-fill:snow;" +
                "-fx-padding: 6 6 6 6;" + "-fx-border-color: #4d0099;" +
                "fx-border-radius: 4;"+ "-fx-font-weight: bold;"+
                "-fx-alignment: center-left");
        btn11.setStyle("-fx-background-color:  #9900cc;" + "-fx-text-fill:snow;" +
                "-fx-padding: 6 6 6 6;" + "-fx-border-color: #4d0099;" +
                "fx-border-radius: 4;"+ "-fx-font-weight: bold;"+
                "-fx-alignment: center-left");
        btn12.setStyle("-fx-background-color:  #9900cc;" + "-fx-text-fill:snow;" +
                "-fx-padding: 6 6 6 6;" + "-fx-border-color: #4d0099;" +
                "fx-border-radius: 4;"+ "-fx-font-weight: bold;"+
                "-fx-alignment: center-left");


    }

    public void init_motion()
    {
        init_text_button();
        init_motion_button_color();

        btn1.setText("Move");
        btn2.setText("Turn Clockwise");
        btn3.setText("Turn AntiClockwise");
        btn4.setText("Point in Direction");
        btn5.setText("Point Towards");
        btn6.setText("Go To");
        btn7.setText("Go To");
        btn8.setText("Glide");
        btn9.setText("Change x");
        btn10.setText("Set x");
        btn11.setText("Change y");
        btn12.setText("Set y");

        h1.getChildren().addAll(btn1);
        h2.getChildren().addAll(btn2);
        h3.getChildren().addAll(btn3);
        h4.getChildren().addAll(btn4);
        h5.getChildren().addAll(btn5);
        h6.getChildren().addAll(btn6);
        h7.getChildren().addAll(btn7);
        h8.getChildren().addAll(btn8);
        h9.getChildren().addAll(btn9);
        h10.getChildren().addAll(btn10);
        h11.getChildren().addAll(btn11);
        h12.getChildren().addAll(btn12);
    }

    public void init_looks()
    {
        init_text_button();
        init_looks_button_color();

        btn1.setText("Say");
        btn2.setText("Think");
        btn3.setText("Show");
        btn4.setText("Hide");
        btn5.setText("Switch");
        btn6.setText("Next");
        btn7.setText("Change Color");
        btn8.setText("Set Color");
        btn9.setText("Change Size");
        btn10.setText("Set Size");

        h1.getChildren().addAll(btn1);
        h2.getChildren().addAll(btn2);
        h3.getChildren().addAll(btn3);
        h4.getChildren().addAll(btn4);
        h5.getChildren().addAll(btn5);
        h6.getChildren().addAll(btn6);
        h7.getChildren().addAll(btn7);
        h8.getChildren().addAll(btn8);
        h9.getChildren().addAll(btn9);
        h10.getChildren().addAll(btn10);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {



    }
}
