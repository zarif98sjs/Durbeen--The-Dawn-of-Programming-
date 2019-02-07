package sample;

import javafx.geometry.NodeOrientation;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class SagaOfStyle {
    TextField[] tf;
    fButton[] btn;
    VBox vb;
    Button[] exButton = new Button[5];
    private int count=0;

    public SagaOfStyle(TextField[] tf, fButton[] btn, VBox vb) {
        this.tf = tf;
        this.btn = btn;
        this.vb = vb;
    }

    public void addExButton(Button ... w){
        for(Button q:w){
            exButton[count] = q;
            count++;
        }
    }

    public void init_text_button() {
        for (int i = 1; i <= 12; i++) {
            //tf[i] = new TextField("");
            tf[i].setMinSize(45, 40);
            tf[i].setMaxSize(45, 40);
            btn[i].setMinSize(226, 41);
            btn[i].setGraphic(tf[i]);
            btn[i].setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            tf[i].setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            vb.getChildren().removeAll(btn[i]);
        }
        for(Button p:exButton){
            vb.getChildren().remove(p);
        }
    }

    public void init_motion_button_color() {
        String ButtonCSS = "-fx-background-color: #6699ff;" + "-fx-text-fill:snow;" +
                "-fx-padding: 6 6 6 6;" + "-fx-border-color: darkblue;" +
                "fx-border-radius: 4;" + "-fx-font-weight: bold;" +
                "-fx-alignment: center-left";

        for (int i = 1; i <= 12; i++) {
            btn[i].setStyle(ButtonCSS);
        }
    }

    public void init_looks_button_color() {
        String ButtonCSS = "-fx-background-color:  #9900cc;" + "-fx-text-fill:snow;" +
                "-fx-padding: 6 6 6 6;" + "-fx-border-color: #4d0099;" +
                "fx-border-radius: 4;" + "-fx-font-weight: bold;" +
                "-fx-alignment: center-left";

        for (int i = 1; i <= 12; i++) {
            btn[i].setStyle(ButtonCSS);
        }
    }

    public void init_condition_button_color() {
        String ButtonCSS = "-fx-background-color:  #1971cc;" + "-fx-text-fill:snow;" +
                "-fx-padding: 6 6 6 6;" + "-fx-border-color: #4d0099;" +
                "fx-border-radius: 4;" + "-fx-font-weight: bold;" +
                "-fx-alignment: center-left";

        for (int i = 1; i <= 12; i++) {
            btn[i].setStyle(ButtonCSS);
        }
    }

    public void init_sound_button_color() {
        String ButtonCSS = "-fx-background-color:  #FFFF00;" + "-fx-text-fill:snow;" +
                "-fx-padding: 6 6 6 6;" + "-fx-border-color: #4d0099;" +
                "fx-border-radius: 4;" + "-fx-font-weight: bold;" +
                "-fx-alignment: center-left";

        for (int i = 1; i <= 12; i++) {
            btn[i].setStyle(ButtonCSS);
            //tf[i].setStyle("-fx-font")
        }
    }

    public void init_variable_button_color() {
        String ButtonCSS = "-fx-background-color:  #56255B;" + "-fx-text-fill:snow;" +
                "-fx-padding: 6 6 6 6;" + "-fx-border-color: #4d0099;" +
                "fx-border-radius: 4;" + "-fx-font-weight: bold;" +
                "-fx-alignment: center-left";

        for (int i = 1; i <= 12; i++) {
            btn[i].setStyle(ButtonCSS);
        }
    }

    public void init_motion() {
         init_text_button();
         init_motion_button_color();

        btn[1].setText("ঘর আগাও");
        btn[2].setText("ডানে ঘোরো");
        btn[3].setText("বামে ঘোরো");
        btn[4].setText("Point in Direction");
        btn[5].setText("Point Towards");
        btn[6].setText("Go To");
        btn[7].setText("Go To");
        btn[8].setText("Glide");
        btn[9].setText("Change x");
        btn[10].setText("Set x");
        btn[11].setText("Change y");
        btn[12].setText("Set y");

        for (int i = 1; i <= 12; i++)
            vb.getChildren().addAll(btn[i]);

         
    }

    public void init_looks() {
         init_text_button();
         init_looks_button_color();

        btn[1].setText("Set Height");
        btn[2].setText("Set Width");
        btn[3].setText("Show");
        btn[4].setText("Hide");
        btn[5].setText("Switch");
        btn[6].setText("Next");
        btn[7].setText("Change Color");
        btn[8].setText("Set Color");
        btn[9].setText("Change Size");
        btn[10].setText("Set Size");

        for (int i = 1; i <= 12; i++)
            vb.getChildren().addAll(btn[i]);

         
    }

    //I started working from here

    public void initControllerButton() {
         init_text_button();

        btn[1] = ControllerButton.spriteClickedButton();
        //spriteClickInitiator();
        btn[2] = ControllerButton.keyPressedButton();
        //keyPressInitiator(btn[2]);
        vb.getChildren().addAll(btn[1], btn[2]);
         
    }

    public void init_sound() {
         init_text_button();
         init_sound_button_color();

        btn[1].setText("বাজাতে থাকো");
        btn[2].setText("সেকেন্ড ধরে বাজাও");
        btn[3].setText("ভলিউম বাড়াও");
        btn[4].setText("ভলিউম কমাও");
        btn[5].setText("বিরত রাখো");
        btn[6].setText("বন্ধ করো");

        btn[1].setGraphic(null);
        btn[5].setGraphic(null);
        btn[6].setGraphic(null);

        for (int i = 1; i < 7; i++)
            vb.getChildren().addAll(btn[i]);

 }

    public void initConditionButton() {
         init_text_button();
         init_condition_button_color();

        btn[1].setText("যদি");
        btn[2].setText("নতুবা");
        btn[3].setText("নতুবা যদি");
        btn[4].setText("যতক্ষণ");
        btn[5].setText("শেষ");
        btn[6].setText("বার করো");

        for (int i = 1; i <= 5; ++i) {
            btn[i].setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            tf[i].setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            ((TextField) btn[i].getGraphic()).setMinWidth(100);
            vb.getChildren().add(btn[i]);
        }
        btn[5].setGraphic(null);
        btn[6].setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        vb.getChildren().add(btn[6]);
 }

    public void initVariable() {
         init_text_button();
         init_variable_button_color();

        for (int i = 1; i <= 10; ++i) {
            btn[i].setText((char) ('z' - 10 + i) + " = ");
            btn[i].setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            ((TextField) btn[i].getGraphic()).setMinWidth(100);
            vb.getChildren().add(btn[i]);
        }
 }
}
