package sample;

import javafx.animation.RotateTransition;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

import javafx.animation.ParallelTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.awt.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

/*    @FXML
    private VBox dyn;*/
    @FXML
    private HBox h1;
    @FXML
    private HBox h2;
    @FXML
    private HBox h3;
    @FXML
    private HBox h4;
    @FXML
    private HBox h5;
    @FXML
    private HBox h6;
    @FXML
    private HBox h7;
    @FXML
    private HBox h8;
    @FXML
    private HBox h9;
    @FXML
    private HBox h10;
    @FXML
    private HBox h11;
    @FXML
    private HBox h12;


    Button btn1 = new Button();
    Button btn2 = new Button();
    Button btn3 = new Button();
    Button btn4 = new Button();
    Button btn5 = new Button();
    Button btn6 = new Button();
    Button btn7 = new Button();
    Button btn8 = new Button();
    Button btn9 = new Button();
    Button btn10 = new Button();
    Button btn11 = new Button();
    Button btn12 = new Button();

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


    @FXML
    private ImageView image;
    @FXML
    private Text text1;

    public void init_motion()
    {
        //dyn.getChildren().removeAll(h1,h2,h3,h4);

        h1.getChildren().removeAll(btn1,t1);
        h2.getChildren().removeAll(btn2,t2);
        h3.getChildren().removeAll(btn3,t3);
        h4.getChildren().removeAll(btn4,t4);
        h5.getChildren().removeAll(btn5,t5);
        h6.getChildren().removeAll(btn6,t6);
        h7.getChildren().removeAll(btn7,t7);
        h8.getChildren().removeAll(btn8,t8);
        h9.getChildren().removeAll(btn9,t9);
        h10.getChildren().removeAll(btn10,t10);
        h11.getChildren().removeAll(btn11,t11);
        h12.getChildren().removeAll(btn12,t12);

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


        btn1.setMinSize(228-65,45);
        btn2.setMinSize(228-65,45);
        btn3.setMinSize(228-65,45);
        btn4.setMinSize(228-65,45);
        btn5.setMinSize(228-65,45);
        btn6.setMinSize(228-65,45);
        btn7.setMinSize(228-65,45);
        btn8.setMinSize(228-65,45);
        btn9.setMinSize(228-65,45);
        btn10.setMinSize(228-65,45);
        btn11.setMinSize(228-65,45);
        btn12.setMinSize(228-65,45);


        t1.setMinSize(65,45);
        t2.setMinSize(65,45);
        t3.setMinSize(65,45);
        t4.setMinSize(65,45);
        t5.setMinSize(65,45);
        t6.setMinSize(65,45);
        t7.setMinSize(65,45);
        t8.setMinSize(65,45);
        t9.setMinSize(65,45);
        t10.setMinSize(65,45);
        t11.setMinSize(65,45);
        t12.setMinSize(65,45);


        h1.getChildren().addAll(btn1,t1);
        h2.getChildren().addAll(btn2,t2);
        h3.getChildren().addAll(btn3,t3);
        h4.getChildren().addAll(btn4,t4);
        h5.getChildren().addAll(btn5,t5);
        h6.getChildren().addAll(btn6,t6);
        h7.getChildren().addAll(btn7,t7);
        h8.getChildren().addAll(btn8,t8);
        h9.getChildren().addAll(btn9,t9);
        h10.getChildren().addAll(btn10,t10);
        h11.getChildren().addAll(btn11,t11);
        h12.getChildren().addAll(btn12,t12);

        //dyn.getChildren().addAll(h1,h2,h3,h4);

    }

    public void init_looks()
    {
        h1.getChildren().removeAll(btn1,t1);
        h2.getChildren().removeAll(btn2,t2);
        h3.getChildren().removeAll(btn3,t3);
        h4.getChildren().removeAll(btn4,t4);
        h5.getChildren().removeAll(btn5,t5);
        h6.getChildren().removeAll(btn6,t6);
        h7.getChildren().removeAll(btn7,t7);
        h8.getChildren().removeAll(btn8,t8);
        h9.getChildren().removeAll(btn9,t9);
        h10.getChildren().removeAll(btn10,t10);
        h11.getChildren().removeAll(btn11,t11);
        h12.getChildren().removeAll(btn12,t12);

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
/*        btn11.setText("");
        btn12.setText("");*/

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
/*        t11.setText("");
        t12.setText("");*/

        btn1.setMinSize(228-65,45);
        btn2.setMinSize(228-65,45);
        btn3.setMinSize(228-65,45);
        btn4.setMinSize(228-65,45);
        btn5.setMinSize(228-65,45);
        btn6.setMinSize(228-65,45);
        btn7.setMinSize(228-65,45);
        btn8.setMinSize(228-65,45);
        btn9.setMinSize(228-65,45);
        btn10.setMinSize(228-65,45);
/*        btn11.setMinSize(228-65,45);
        btn12.setMinSize(228-65,45);*/

        t1.setMinSize(65,45);
        t2.setMinSize(65,45);
        t3.setMinSize(65,45);
        t4.setMinSize(65,45);
        t5.setMinSize(65,45);
        t6.setMinSize(65,45);
        t7.setMinSize(65,45);
        t8.setMinSize(65,45);
        t9.setMinSize(65,45);
        t10.setMinSize(65,45);
/*        t11.setMinSize(65,45);
        t12.setMinSize(65,45);*/

        h1.getChildren().addAll(btn1,t1);
        h2.getChildren().addAll(btn2,t2);
        h3.getChildren().addAll(btn3,t3);
        h4.getChildren().addAll(btn4,t4);
        h5.getChildren().addAll(btn5,t5);
        h6.getChildren().addAll(btn6,t6);
        h7.getChildren().addAll(btn7,t7);
        h8.getChildren().addAll(btn8,t8);
        h9.getChildren().addAll(btn9,t9);
        h10.getChildren().addAll(btn10,t10);/*
        h11.getChildren().addAll(btn11,t11);
        h12.getChildren().addAll(btn12,t12);*/

        //dyn.getChildren().addAll(h1,h2,h3,h4);

    }

    public void init_sound()
    {
        h1.getChildren().removeAll(btn1,t1);
        h2.getChildren().removeAll(btn2,t2);
        h3.getChildren().removeAll(btn3,t3);
        h4.getChildren().removeAll(btn4,t4);
        h5.getChildren().removeAll(btn5,t5);
        h6.getChildren().removeAll(btn6,t6);
        h7.getChildren().removeAll(btn7,t7);
        h8.getChildren().removeAll(btn8,t8);
        h9.getChildren().removeAll(btn9,t9);
        h10.getChildren().removeAll(btn10,t10);
        h11.getChildren().removeAll(btn11,t11);
        h12.getChildren().removeAll(btn12,t12);

        btn1.setText("Play Sound");
        btn2.setText("Play Sound (sec)");
        btn3.setText("Play Drum");
        btn4.setText("Change Volume");
        btn5.setText("Set Volume");
 /*       btn6.setText("Next");
        btn7.setText("Change Color");
        btn8.setText("Set Color");
        btn9.setText("Change Size");
        btn10.setText("Set Size");
        btn11.setText("");
        btn12.setText("");*/

        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
/*        t6.setText("");
        t7.setText("");
        t8.setText("");
        t9.setText("");
        t10.setText("");
        t11.setText("");
        t12.setText("");*/

        btn1.setMinSize(228-65,45);
        btn2.setMinSize(228-65,45);
        btn3.setMinSize(228-65,45);
        btn4.setMinSize(228-65,45);
        btn5.setMinSize(228-65,45);
/*        btn6.setMinSize(228-65,45);
        btn7.setMinSize(228-65,45);
        btn8.setMinSize(228-65,45);
        btn9.setMinSize(228-65,45);
        btn10.setMinSize(228-65,45);
        btn11.setMinSize(228-65,45);
        btn12.setMinSize(228-65,45);*/

        t1.setMinSize(65,45);
        t2.setMinSize(65,45);
        t3.setMinSize(65,45);
        t4.setMinSize(65,45);
        t5.setMinSize(65,45);
/*        t6.setMinSize(65,45);
        t7.setMinSize(65,45);
        t8.setMinSize(65,45);
        t9.setMinSize(65,45);
        t10.setMinSize(65,45);
        t11.setMinSize(65,45);
        t12.setMinSize(65,45);*/

        h1.getChildren().addAll(btn1,t1);
        h2.getChildren().addAll(btn2,t2);
        h3.getChildren().addAll(btn3,t3);
        h4.getChildren().addAll(btn4,t4);
        h5.getChildren().addAll(btn5,t5);
/*        h6.getChildren().addAll(btn6,t6);
        h7.getChildren().addAll(btn7,t7);
        h8.getChildren().addAll(btn8,t8);
        h9.getChildren().addAll(btn9,t9);
        h10.getChildren().addAll(btn10,t10);
        h11.getChildren().addAll(btn11,t11);
        h12.getChildren().addAll(btn12,t12);*/

        //dyn.getChildren().addAll(h1,h2,h3,h4);

    }

    public void shamne_jao()
    {
        System.out.println("SHAMNE GESEEEE");

        String s = t1.getText();
        int v = Integer.parseInt(s);

        TranslateTransition t1;
        t1 = new TranslateTransition();
        ParallelTransition p = new ParallelTransition();
        t1.setDuration(Duration.millis(1000));
        t1.setNode(image);
        t1.setByX(v*10);
        t1.setCycleCount(1);
        t1.setAutoReverse(false);
        p.getChildren().add(t1);

        t1 = new TranslateTransition();
        t1.setDuration(Duration.millis(1000));
        t1.setNode(text1);
        t1.setByX(100);
        t1.setCycleCount(1);
        t1.setAutoReverse(false);
        p.getChildren().add(t1);

        p.play();

    }

    public void daane_ghuro(int yes)
    {
        System.out.println("DAANE GHURSEEE");

        String s = t2.getText();
        int v = Integer.parseInt(s);

        RotateTransition r1;
        ParallelTransition p = new ParallelTransition();
        r1= new RotateTransition();
        r1.setDuration(Duration.millis(1000));
        r1.setNode(image);
        if(yes==1)
            r1.setByAngle(v);
        else
            r1.setByAngle(-v);
        r1.setCycleCount(1);
        r1.setAutoReverse(false);
        p.getChildren().add(r1);
        p.play();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        text1.xProperty().bind(image.xProperty());
        text1.yProperty().bind(image.yProperty());

        btn1.setOnAction(e ->{

            if(btn1.getText().equals("Move"))
            {
                if(t1.getText().equals(""))
                    AlertBox.display("Alert","Please Give The Value");
                else
                    shamne_jao();
            }

            else if(btn1.getText().equals("Say"))
            {
                text1.setText("PIKA PIKA");
            }

            else if(btn1.getText().equals("Play Sound"))
            {
                String musicFile = "pika.mp3";

                Media sound = new Media(new File(musicFile).toURI().toString());
                MediaPlayer mediaPlayer = new MediaPlayer(sound);
                mediaPlayer.play();

            }

        });

        btn2.setOnAction(e ->{

            if(btn2.getText().equals("Turn Clockwise"))
            {
                if(t2.getText().equals(""))
                    AlertBox.display("Alert","Please Give The Value");
                else
                    daane_ghuro(1);
            }

            if(btn2.getText().equals("Think"))
            {
                text1.setText("PIKA PIKA THINKING");
            }

            if(btn2.getText().equals("Show"))
            {

            }

        });

        btn3.setOnAction(e ->{

            if(btn3.getText().equals("Turn AntiClockwise"))
            {
                if(t2.getText().equals(""))
                    AlertBox.display("Alert","Please Give The Value");
                else
                    daane_ghuro(0);
            }

            if(btn3.getText().equals("Think"))
            {
                text1.setText("PIKA PIKA THINKING");
            }

            if(btn3.getText().equals("Show"))
            {

            }

        });
    }
}
