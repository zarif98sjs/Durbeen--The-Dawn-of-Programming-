/*
    Created By: Sheikh Azizul Hakim
    Last Modified: 03 Jan 18:56
    Problems in identifying mouse pointer
 */


package sample;

import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.util.Duration;

import java.awt.*;
import java.io.Serializable;

import static java.lang.Math.PI;


public class MotionButton extends fButton  {

    SpriteView spriteView;

    MotionButton(String title, SpriteView sprite)
    {
        super(title);
        spriteView = sprite;
        this.setStyle("-fx-background-color: blue");
    }

    public void moveForward(double v)
    {
        System.out.println("Went Forward From MotionButton");

        System.out.println("From M Button: ");
        System.out.println(spriteView.getId());

        TranslateTransition t1 = new TranslateTransition(Duration.millis(10),spriteView);

        double angle = spriteView.getOrientAngle();

        t1.setByX(v * Math.cos(angle));
        System.out.println("X changed by " + v * Math.cos(angle) + "\nThe angle is " + angle);
        t1.setByY(v * Math.sin(angle));
        System.out.println("Y changed by " + v * Math.sin(angle));

        t1.setCycleCount(1);
        t1.setAutoReverse(false);
        t1.setOnFinished(event -> spriteView.find_sprite_position());

        t1.play();

    }

    public void rotateIfTrueClockwise(boolean yes, double v)
    {
        System.out.println("Rotated from MB");

        RotateTransition r1 = new RotateTransition(Duration.millis(1000.0),spriteView);

        if(yes == true) {
            r1.setByAngle(v);
            spriteView.rotateDegree(v);
        }
        else{
            r1.setByAngle(-v);
            spriteView.rotateDegree(-v);
        }


        r1.setCycleCount(1);
        r1.setAutoReverse(false);
        r1.setDuration(Duration.millis(800));
        r1.setOnFinished(event -> spriteView.find_sprite_position());
        r1.play();
    }

    public void setX(double x){
        System.out.println("Moved x to " + x);
        spriteView.setTranslateX(x);
    }

    public void setY(double y ) {
        spriteView.setTranslateY(y);
    }

    public void goToRandomPosition(){
        double random;

        random = Math.random() * ((Pane) spriteView.getParent()).getPrefHeight();
        this.setY(random);

        random = Math.random() * ((Pane) spriteView.getParent()).getPrefWidth();
        this.setX(random);

    }

    public void goToSpecifiedCoordinate(double x, double y ){
        this.setX(x);
        this.setY(y);
    }

    public void incrementByX(double dx){
        spriteView.setTranslateX(spriteView.getTranslateX() + dx);
        //System.out.println(spriteView.getLayoutX() + " and " + spriteView.getX());
    }

    public void incrementByY(double dy){
        spriteView.setTranslateX(spriteView.getTranslateY() + dy);
    }

    public void glideToPosition(double time, double x, double y)
    {
        PathTransition pathTransition = new PathTransition(Duration.seconds(time), new Line(spriteView.getTranslateX(), spriteView.getTranslateY(),x,y), spriteView);

        pathTransition.setAutoReverse(false);
        pathTransition.setCycleCount(1);

        pathTransition.play();
    }
    public void goToMousePointer()
    {
        Point point = MouseInfo.getPointerInfo().getLocation();
        this.goToSpecifiedCoordinate(point.x,point.y);
        System.out.println(point.x + " & " + point.y);
    }

    public void pointToMousePointer()
    {
        Point point = MouseInfo.getPointerInfo().getLocation();
        this.rotateIfTrueClockwise(false, (180.0/PI)* Math.atan2((point.y-spriteView.getTranslateY()),(point.x-spriteView.getTranslateX())));
    }

}
