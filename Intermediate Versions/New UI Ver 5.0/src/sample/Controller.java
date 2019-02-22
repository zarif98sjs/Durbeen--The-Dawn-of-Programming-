package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    @FXML
    private VBox vb;
    @FXML
    private Pane mainPane;

    TextField[] tf= new TextField[20];

    fButton[] btn=new fButton[20];

    public void init_text_button()
    {
        for(int i=1;i<=12;i++)
        {
            //tf[i] = new TextField("");
            tf[i].setMinSize(45,40);
            tf[i].setMaxSize(45,40);
            btn[i].setMinSize(226,41);
            btn[i].setGraphic(tf[i]);
            btn[i].setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
            vb.getChildren().removeAll(btn[i]);
        }
    }

    public void init_motion_button_color()
    {
        String ButtonCSS = "-fx-background-color: #6699ff;" + "-fx-text-fill:snow;" +
                "-fx-padding: 6 6 6 6;" + "-fx-border-color: darkblue;" +
                "fx-border-radius: 4;"+ "-fx-font-weight: bold;"+
                "-fx-alignment: center-left";

        for(int i=1;i<=12;i++)
        {
            btn[i].setStyle(ButtonCSS);
        }
    }

    public void init_looks_button_color()
    {
        String ButtonCSS = "-fx-background-color:  #9900cc;" + "-fx-text-fill:snow;" +
            "-fx-padding: 6 6 6 6;" + "-fx-border-color: #4d0099;" +
            "fx-border-radius: 4;"+ "-fx-font-weight: bold;"+
            "-fx-alignment: center-left";

        for(int i=1;i<=12;i++)
        {
            btn[i].setStyle(ButtonCSS);
        }
    }

    public void init_condition_button_color()
    {
        String ButtonCSS = "-fx-background-color:  #1971cc;" + "-fx-text-fill:snow;" +
                "-fx-padding: 6 6 6 6;" + "-fx-border-color: #4d0099;" +
                "fx-border-radius: 4;"+ "-fx-font-weight: bold;"+
                "-fx-alignment: center-left";

        for(int i=1;i<=12;i++)
        {
            btn[i].setStyle(ButtonCSS);
        }
    }

    public void init_variable_button_color()
    {
        String ButtonCSS = "-fx-background-color:  #56255B;" + "-fx-text-fill:snow;" +
                "-fx-padding: 6 6 6 6;" + "-fx-border-color: #4d0099;" +
                "fx-border-radius: 4;"+ "-fx-font-weight: bold;"+
                "-fx-alignment: center-left";

        for(int i=1;i<=12;i++)
        {
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

        btn[1] = ControllerButton.spriteClickedButton();
        //spriteClickInitiator();
        btn[2] = ControllerButton.keyPressedButton();
        //keyPressInitiator(btn[2]);
        vb.getChildren().addAll(btn[1], btn[2]);
        enableClone();
    }

    private void keyPressInitiator(fButton button) {
        ChoiceBox<String> choiceBox = (ChoiceBox<String>) (button.getGraphic());
        button.setGraphic(choiceBox);

        mainPane.setOnKeyPressed(event -> {
            String text;
            try{
                text = ((ChoiceBox<String>) ((fButton)codeBox.getChildren().get(0)).getGraphic()).getValue();
            } catch (Exception e){
                System.out.println("Exception for key pressing: " + e);
                return;
            }
            if(event.getText().equalsIgnoreCase(text))
                try{
                    codeBox.codeExecute();
                } catch (InterruptedException e){
                    System.out.println("Key press interrupted");
                }
            System.out.println("Goru: " + event.getText() + " " + text);
        });
    }

    public void spriteClickInitiator() {
        spriteView.setOnMouseClicked(event -> {
            try {
                codeBox.codeExecute();
            } catch(InterruptedException e){
                System.out.println("Execution interrupted");
            }
            System.out.println("Success!!!");
        });
    }

    public void init_sound()
    {
        init_text_button();
        init_looks_button_color();

        btn[1].setText("বাজাতে থাকো");
        btn[2].setText("সেকেন্ড ধরে বাজাও");
        btn[3].setText("ভলিউম বাড়াও");
        btn[4].setText("ভলিউম কমাও");
        btn[5].setText("বিরত রাখো");
        btn[6].setText("বন্ধ করো");

        btn[1].setGraphic(null);
        btn[5].setGraphic(null);
        btn[6].setGraphic(null);

        for(int i=1;i<7;i++)
            vb.getChildren().addAll(btn[i]);

        enableClone();
    }

    public void initConditionButton(){
        init_text_button();
        init_condition_button_color();

        btn[1].setText("যদি");
        btn[2].setText("নতুবা");
        btn[3].setText("নতুবা যদি");
        btn[4].setText("যতক্ষণ");
        btn[5].setText("শেষ");
        btn[6].setText("বার করো");

        for(int i=1; i<=5; ++i){
            btn[i].setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            ((TextField) btn[i].getGraphic()).setMinWidth(100);
            vb.getChildren().add(btn[i]);
        }
        btn[5].setGraphic(null);
        btn[6].setNodeOrientation(NodeOrientation.LEFT_TO_RIGHT);
        vb.getChildren().add(btn[6]);
        enableClone();
    }

    public void initVariable(){
        init_text_button();
        init_variable_button_color();

        for(int i=1; i<=10; ++i){
            btn[i].setText((char)('z'-10+i) + " = ");
            btn[i].setNodeOrientation(NodeOrientation.RIGHT_TO_LEFT);
            ((TextField) btn[i].getGraphic()).setMinWidth(100);
            vb.getChildren().add(btn[i]);
        }
        enableClone();
    }


    CodeBox controlCode[] = new CodeBox[5];
    int controlID = 0;

    void initControlCode(){
        for(int i=1; i<5; ++i){
            controlCode[i] = new CodeBox(codeBox.motionButton, codeBox.soundButton);
        }
    };

    @FXML
    private AnchorPane codeAnchor;
    @FXML
    private CodeBox codeBox;
    @FXML
    private SpriteView spriteView;
    @FXML
    private Pane paneForImage;
    @FXML
    private ImageView yes;
    @FXML
    private ImageView no;


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

        file = new File("src/img/yes.png");
        image = new Image(file.toURI().toString());
        yes.setImage(image);

        /*file = new File("src/img/no.jpg");
        image = new Image(file.toURI().toString());
        no.setImage(image);*/

        codeBox = new CodeBox("Box For Code", spriteView, "src/sample/LoTS.mp3");
        controlCode[controlID] = codeBox;
        initControlCode();

        paneForImage.getChildren().add(spriteView);

        codeAnchor.getChildren().add(codeBox);

        //codeBox.getChildren().add(someButton);
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
            ((fButton) comButton).setOnAction(event -> {
                try{
                    //Node savedGraphic = btn1.getGraphic();
                    if(comButton.getStyle().contains("FF8000")){
                        System.out.println("Controller Button From enableClone()");
                        if(controlCode[0].getChildren().isEmpty())
                            controlCode[0].getChildren().add(((fButton)comButton).clone());
                        if(((fButton) comButton).getText().contains("বিড়ালের"))
                            spriteClickInitiator();
                        else if(((fButton) comButton).getText().contains("বোতাম")) {
                            keyPressInitiator(btn[2]);
                            System.out.println("Key Pressed Output");
                        }
                    }
                    else if(controlCode[0].getChildren().isEmpty())
                            AlertBox.display("No Event Found", "Please add an Event");
                    else if(comButton.getStyle().contains("1971cc")){
                        //CodeBox codeBox1 = new CodeBox(codeBox.motionButton, codeBox.soundButton);
                        if(((fButton) comButton).getText().contains("শেষ")){
                            controlCode[controlID].getChildren().add(((fButton) comButton).clone());
                            controlID--;
                            if(controlID<0) controlID=0;
                        }
                        else {
                            controlID++;
                            controlCode[controlID].getChildren().add(((fButton) comButton).clone());
                            controlCode[controlID-1].getChildren().add(controlCode[controlID]);
                        }
                    }
                    else {
                            /*if(comButton.getStyle().contains("1971cc")){
                                controlCode[controlID].getChildren().add(((fButton) comButton).clone());
                                codeBox.getChildren().add(controlCode[controlID]);
                            }
                            else*/
                            controlCode[controlID].getChildren().add(((fButton) comButton).clone());
                    }
                    //((TextInputControl)btn1.getGraphic()).setText("0");
                } catch (CloneNotSupportedException e){
                    System.out.println("Clone Not Supported! Never will this line be printed.");
                }
            });
        }
    }

    public void deleteLast(){
        controlCode[controlID].getChildren().remove(controlCode[controlID].getChildren().size()-1);
    }

    /*public void deleteAll() {
        codeBox = new CodeBox()

    }
        ;
    }*/
}
