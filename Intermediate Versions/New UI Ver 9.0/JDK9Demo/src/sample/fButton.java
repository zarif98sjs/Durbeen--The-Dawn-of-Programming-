package sample;

//import javafx.scene.Node;-

import javafx.fxml.FXML;
import javafx.geometry.NodeOrientation;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Scanner;
import java.util.StringTokenizer;

public class fButton extends Button implements Cloneable, Serializable {
    @FXML
    private double orgSceneX, orgSceneY, orgTranslateX, orgTranslateY;

    @Override
    protected fButton clone() throws CloneNotSupportedException {
        fButton a;
        try {
            a = new fButton(this.getText(), new TextField(((TextField) (this.getGraphic())).getText()));
            ((TextField)this.getGraphic()).setText("");
            this.getGraphic().setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            ((TextField)a.getGraphic()).setMaxSize(45,40);
        } catch (java.lang.NullPointerException e){
            a = new fButton(this.getText(), false);
        } catch (java.lang.ClassCastException e){
            ChoiceBox<String> choiceBox = new ChoiceBox<>();
            try {
                choiceBox.setItems(((ChoiceBox<String>) this.getGraphic()).getItems());
            } catch (Exception p){
                System.out.println("Exception caught: " + p);
            }
            a = new fButton(this.getText(), choiceBox);
            System.out.println("It came here");
        } catch (Exception e){
            System.out.println("Cloning exception: " + e);
            a = new fButton(this.getText(), this.getGraphic());
        }
        a.setScaleX(this.getScaleX());
        a.setScaleY(this.getScaleY());
        a.setStyle(this.getStyle());
        a.setWidth(this.getWidth());
        a.setNodeOrientation(this.getNodeOrientation());
        System.out.println("Cloned");
        return a;
    }

    fButton()
    {
        this.setLayoutX(10);
        this.setLayoutY(10);
        this.setMinSize(228-65, 45);
        this.setText("fButton");
        this.setOnMousePressed(event -> onMousePressed(event));
        this.setOnMouseDragged(event -> onMouseDragged(event));
        this.setOnMouseDragExited(event -> System.out.println("Mouse Drag Exited"));
        this.setOnMouseDragOver(event -> System.out.println("Mouse Drag Over"));
        this.setOnMouseClicked(event -> onMouseDragEntered((Pane) this.getParent()));
    }

    fButton(String name)
    {
        super(name);
        this.setLayoutX(10);
        this.setLayoutY(10);
        this.setMinSize(228-65, 45);
        this.setOnMousePressed(event -> onMousePressed(event));
        this.setOnMouseDragged(event -> onMouseDragged(event));
        this.setOnMouseDragExited(event -> System.out.println("Mouse Drag Exited"));
        this.setOnMouseDragOver(event -> System.out.println("Mouse Drag Over"));
        this.setOnMouseClicked(event -> onMouseDragEntered((Pane) this.getParent()));
    }

    fButton(String name, Node graphic)
    {
        super(name,graphic);
        this.setLayoutX(10);
        this.setLayoutY(10);
        this.setMinSize(228-65, 45);
        /*this.setOnMousePressed(event -> onMousePressed(event));
        this.setOnMouseDragged(event -> onMouseDragged(event));
        this.setOnMouseDragExited(event -> System.out.println("Mouse Drag Exited"));
        this.setOnMouseDragOver(event -> System.out.println("Mouse Drag Over"));
        this.setOnMouseClicked(event -> onMouseDragEntered((Pane) this.getParent()));*/
    }

    fButton(String name, boolean clone)
    {
        super(name);
        this.setLayoutX(10);
        this.setLayoutY(10);
        this.setMinSize(228-65, 45);
        if(clone) {
            this.setOnMousePressed(event -> onMousePressed(event));
            this.setOnMouseDragged(event -> onMouseDragged(event));
            this.setOnMouseDragExited(event -> System.out.println("Mouse Drag Exited"));
            this.setOnMouseDragOver(event -> System.out.println("Mouse Drag Over"));
            this.setOnMouseClicked(event -> onMouseDragEntered((Pane) this.getParent()));
        }
    }




    public void onMousePressed(MouseEvent me)
    {
        orgSceneX = me.getSceneX();
        orgSceneY = me.getSceneY();

        System.out.println("Mouse is at " + orgSceneX + "," + orgSceneY );

        orgTranslateX = this.getTranslateX();
        orgTranslateY = this.getTranslateY();
    }

    public void onMouseDragged(MouseEvent me)
    {
        double offsetX = me.getSceneX() - orgSceneX;
        double offsetY = me.getSceneY() - orgSceneY;
        double newTranslateX = orgTranslateX + offsetX;
        double newTranslateY = orgTranslateY + offsetY;

        ((Button)(me.getSource())).setTranslateX(newTranslateX);
        ((Button)(me.getSource())).setTranslateY(newTranslateY);

        System.out.println("Source is at " + this.getTranslateX() + "," + this.getTranslateY());
        System.out.println(" In Parent at " + this.getBoundsInParent());
        System.out.println(" In Local  at " + this.getBoundsInLocal());
    }

    public void mouse_koi_ase(MouseEvent me)
    {
        orgSceneX = me.getSceneX();
        orgSceneY = me.getSceneY();

        System.out.println("Mouse is at " + orgSceneX + "," + orgSceneY );
    }

    @FXML
    private void onMouseDragEntered(Pane parent)
    {
        for(int i=1;i<6;++i)
            System.out.println("Mouse Drag entered");
        try {
            fButton b1_child = this.clone();
            b1_child.setOnMouseClicked(event -> onMouseDragEntered(parent));
            //parent.getChildren().add(b1_child);
            //Commented on 14.01.2019 20:57
            //((Pane)parent.getParent()).getChildren().add(b1_child);
        } catch (Exception e){
            ;
        }
    }

    private void readObject(java.io.ObjectInputStream in)
            throws IOException, ClassNotFoundException{
        Scanner scanner = new Scanner(in);
        String abc = (scanner.hasNextLine()) ? scanner.nextLine() : "";
        String a = (scanner.hasNextLine()) ? scanner.nextLine() : "";
        String q = (scanner.hasNextLine()) ? scanner.nextLine() : "";
        String t = (scanner.hasNextLine()) ? scanner.nextLine() : "";
        System.out.println(abc);
        setText(abc);
        TextField tf = new TextField(a);
        tf.setMaxSize(45,40);
        tf.setMinSize(45, 40);
        if(a.contains("choicebox101")){
            ChoiceBox<String> stringChoiceBox = new ChoiceBox<>();
            Character ch;

            for(ch = 'A'; ch <= 'Z'; ++ch){
                stringChoiceBox.getItems().add(ch.toString());
            }

            stringChoiceBox.setValue(String.valueOf(a.charAt(12)));

            setGraphic(stringChoiceBox);
        }
        else if(!a.equalsIgnoreCase("nullified"))
            setGraphic(tf);
        if(q.equalsIgnoreCase("r2l"))
            setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
        else
            setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        tf.setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        setStyle(t);
        setMinSize(226, 41);
        setMaxSize(226, 41);
    }

    private void writeObject(java.io.ObjectOutputStream out)
            throws IOException{
        PrintWriter pw = new PrintWriter(out, true);
        pw.println(getText());
        Node p = getGraphic();
        if(p == null)
            pw.println("nullified");
        else if(p.getClass().toString().contains("TextField"))
            pw.println(((TextField) p).getText());
        else if(p.getClass().toString().contains("ChoiceBox")){
            pw.print("choicebox101"+((ChoiceBox<String>) p).getValue());
        }
        else
            pw.println("nullified");
        pw.flush();
        if(getNodeOrientation() == NodeOrientation.RIGHT_TO_LEFT)
            pw.println("r2l");
        else
            pw.println("l2r");
        pw.flush();
        pw.println(getStyle());
    }

    /*private void readObject(java.io.ObjectInputStream in)
            throws IOException, ClassNotFoundException{
        Scanner scanner = new Scanner(in);
        String abc = scanner.nextLine();
        System.out.println(abc);
        setText(abc);
    }

    private void writeObject(java.io.ObjectOutputStream out)
            throws IOException{
        PrintWriter pw = new PrintWriter(out);
        pw.println(getText());
        pw.flush();
    }*/
}
