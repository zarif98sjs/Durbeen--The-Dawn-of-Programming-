package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML private VBox vb;

    TextField[] tf= new TextField[20];

    fButton[] btn=new fButton[20];

    public void init_text_button()
    {
        for(int i=1;i<=12;i++)
        {
            //tf[i] = new TextField("");
            tf[i].setMaxSize(45,40);
            btn[i].setMinSize(226,41);
            vb.getChildren().removeAll(btn[i]);
        }
    }

    public void init_motion_button_color()
    {
        for(int i=1;i<=12;i++)
        {
            String ButtonCSS = "-fx-background-color: #6699ff;" + "-fx-text-fill:snow;" +
                    "-fx-padding: 6 6 6 6;" + "-fx-border-color: darkblue;" +
                    "fx-border-radius: 4;"+ "-fx-font-weight: bold;"+
                    "-fx-alignment: center-left";

            btn[i].setStyle(ButtonCSS);
        }
    }

    public void init_looks_button_color()
    {
        for(int i=1;i<=12;i++)
        {
            String ButtonCSS = "-fx-background-color:  #9900cc;" + "-fx-text-fill:snow;" +
                    "-fx-padding: 6 6 6 6;" + "-fx-border-color: #4d0099;" +
                    "fx-border-radius: 4;"+ "-fx-font-weight: bold;"+
                    "-fx-alignment: center-left";

            btn[i].setStyle(ButtonCSS);
        }
    }

    public void init_motion()
    {
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

        for(int i=1;i<=12;i++)
            vb.getChildren().addAll(btn[i]);

        enableClone();
    }

    public void init_looks()
    {
        init_text_button();
        init_looks_button_color();

        btn[1].setText("Say");
        btn[2].setText("Think");
        btn[3].setText("Show");
        btn[4].setText("Hide");
        btn[5].setText("Switch");
        btn[6].setText("Next");
        btn[7].setText("Change Color");
        btn[8].setText("Set Color");
        btn[9].setText("Change Size");
        btn[10].setText("Set Size");

        for(int i=1;i<=12;i++)
            vb.getChildren().addAll(btn[i]);

        enableClone();
    }

    //I started working from here

    public void initControllerButton()
    {
        init_text_button();
        tf[1].setMaxSize(45,40);
        tf[1].setStyle("-fx-border-color: #56F099");
        btn[1] = new fButton("Wait",tf[1]);

        vb.getChildren().add(btn[1]);
        enableClone();
    }

    @FXML private AnchorPane codeAnchor;
    @FXML private CodeBox codeBox;
    @FXML private SpriteView spriteView;
    @FXML private Pane paneForImage;


    private Button someButton = new Button( "Hello");

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for(int i=1;i<=12;i++)
            tf[i]=new TextField();

        for(int i=1;i<=12;i++)
            btn[i] = new fButton("",tf[i]);


        File file = new File("src/img/pic1.png");
        Image image = new Image(file.toURI().toString());
        spriteView = new SpriteView(image);

        codeBox = new CodeBox("Box For Code", spriteView, "src/sample/LoTS.mp3");

        paneForImage.getChildren().add(spriteView);

        codeAnchor.getChildren().add(codeBox);

        codeBox.getChildren().add(someButton);
        someButton.setOnAction(event -> {
            try {
                codeBox.codeExecute();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }

    void enableClone()
    {
        for(Node comButton:vb.getChildren())
        {
            //System.out.println(((fButton)comButton).getText());
            ((fButton) comButton).setOnDragDetected(event -> {
                try{
                    //Node savedGraphic = btn1.getGraphic();
                    codeBox.getChildren().add(((fButton)comButton).clone());
                    //((TextInputControl)btn1.getGraphic()).setText("0");
                } catch (CloneNotSupportedException e){
                    System.out.println("Clone Not Supported! Never will this line be printed.");
                }
            });
        }
    }
}
