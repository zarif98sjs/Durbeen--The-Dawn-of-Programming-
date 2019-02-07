package sample;

import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.*;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import sun.security.util.Password;

//import javax.xml.soap.Text;
import java.sql.SQLOutput;

public class Controller{

    @FXML
    private Label mymsg;

    public void likhbo(ActionEvent event)
    {
        mymsg.setText("SCENE E HOISEEEEEEE");
        System.out.println("HOISEEEEEEEEEEEEE");
    }

    @FXML
    private Rectangle sprite;
    @FXML
    private Circle head;
    @FXML
    private TextField t1;
    @FXML
    private Button b1;
    @FXML
    private Button b2;
    @FXML
    private Button b3;
    @FXML
    private Text text1;


    public void shamne_ja()
    {
        if(b1.getText().equals("Move"))
        {

            System.out.println(sprite.getX()+" & "+sprite.getY());

/*        head.centerXProperty().bind(sprite.xProperty());
        head.centerYProperty().bind(sprite.yProperty());*/

/*        sprite.xProperty().bind(head.centerXProperty());
        sprite.yProperty().bind(head.centerYProperty());*/

            String s = t1.getText();
            int v = Integer.parseInt(s);

            TranslateTransition t1;
            t1 = new TranslateTransition();
            ParallelTransition p = new ParallelTransition();
            t1.setDuration(Duration.millis(1000));
            t1.setNode(sprite);
            t1.setByX(v*10);
            t1.setCycleCount(1);
            t1.setAutoReverse(false);
            p.getChildren().add(t1);

            t1 = new TranslateTransition();
            t1.setDuration(Duration.millis(1000));
            t1.setNode(text1);
            t1.setByX(v*10);
            t1.setCycleCount(1);
            t1.setAutoReverse(false);
            p.getChildren().add(t1);
            p.play();
            //t1.play();

/*            t1.setOnFinished(event -> {
                sprite.setX(sprite.getX() + sprite.getTranslateX());
                sprite.setY(sprite.getY() + sprite.getTranslateY());
                sprite.setTranslateX(0);
                sprite.setTranslateY(0);
            });
 */

            System.out.println(sprite.getX()+" & "+sprite.getY());

     /*   TranslateTransition t2 = new TranslateTransition();
        t2.setDuration(Duration.millis(1000));
        t2.setNode(head);
        t2.setByX(v*10);
        t2.setCycleCount(1);
        t2.setAutoReverse(false);
        t2.play();
     */

        }

        if(b1.getText().equals("Say"))
        {
            text1.xProperty().bind(sprite.xProperty());
            text1.yProperty().bind(sprite.yProperty());
            text1.setText(t1.getText());
        }

    }

    @FXML
    private TextField t2;

    public void daane_ghur()
    {

        if(b2.getText().equals("Rotate"))
        {
            //head.centerXProperty().bind(sprite.xProperty());

            String s = t2.getText();
            int v = Integer.parseInt(s);

            RotateTransition r1;
            ParallelTransition p = new ParallelTransition();
            r1= new RotateTransition();
            r1.setDuration(Duration.millis(1000));
            r1.setNode(sprite);
            r1.setByAngle(v);
            r1.setCycleCount(1);
            r1.setAutoReverse(false);
            p.getChildren().add(r1);

/*            r1= new RotateTransition();
            r1.setDuration(Duration.millis(1000));
            r1.setNode(text1);
            r1.setByAngle(v);
            r1.setCycleCount(1);
            r1.setAutoReverse(false);
            p.getChildren().add(r1);*/

            p.play();
            //sprite.setRotate(-sprite.getRotate());

            //r1.play();

/*            r1.setOnFinished(event -> {
                sprite.setX(sprite.getX() + sprite.getRotate()*sprite.getX());
                sprite.setY(sprite.getY() + sprite.getRotate()*sprite.getY());
                sprite.setTranslateX(0);
                sprite.setTranslateY(0);
            });*/

/*        RotateTransition r2 = new RotateTransition();
        r2.setDuration(Duration.millis(1000));
        r2.setNode(head);
        r2.setByAngle(v);
        r2.setCycleCount(1);
        r2.setAutoReverse(false);
        r2.play();*/
        }
    }

    @FXML
    private TextField t3;
    @FXML
    private TextField t4;

    public void go_to()
    {
        String s1=t3.getText();
        String s2=t4.getText();

        int v1=Integer.parseInt(s1);
        int v2=Integer.parseInt(s2);

        sprite.setX(v1);
        sprite.setY(v2);
    }

    public void lc_motion()//lc = lekha change
    {
        b1.setText("Move");
        b2.setText("Rotate");
        t1.setText("");
        t2.setText("");
    }

    public void lc_looks()//lc = lekha change
    {
        b1.setText("Say");
        b2.setText("Think");
        t1.setText("");
        t2.setText("");
    }

}
