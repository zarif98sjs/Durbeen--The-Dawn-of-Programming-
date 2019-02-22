package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    SagaOfStyle sagaOfStyle;
    private Window primary_Stage;
    private boolean color_show = false;

    @FXML
    private VBox vb;
    @FXML
    private Pane mainPane;

    TextField[] tf = new TextField[20];

    fButton[] btn = new fButton[20];


    public void init_motion() {
        sagaOfStyle.init_motion();
        enableClone();
    }

    public void init_looks() {
        sagaOfStyle.init_looks();
        enableClone();
    }

    //I started working from here

    public void initControllerButton() {
        sagaOfStyle.initControllerButton();
        enableClone();
    }

    public void init_change_sprite() {
        sagaOfStyle.init_text_button();

        fButton b1 = new fButton("ছবি বদলাও", false);
        fButton b2 = new fButton("পটভুমি পাল্টাও", false );
        fButton b3 = new fButton("পটভূমির রঙ", false );

        FileChooser abcd = new FileChooser();
        abcd.setTitle("Finding the file");
        abcd.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.bmp","*.png","*.jpeg","*.jpg"));

        b1.setOnMouseClicked(event -> {
            File f1 = abcd.showOpenDialog(primary_Stage);
            spriteView.setImage(new Image(f1.toURI().toString()));
        });

        b2.setOnMouseClicked(event -> {
            /*String style = paneForImage.getStyle();
            File f1 = abcd.showOpenDialog(primary_Stage);
            String qw = style + "-fx-background-image: " + "url(" + f1.toURI().toString() + ");";
            System.out.println(qw);
            paneForImage.setStyle(qw);*/
            File f1 = abcd.showOpenDialog(primary_Stage);
            back_image.setImage(new Image(f1.toURI().toString()));
            back_image.setFitWidth(600);
            back_image.setFitHeight(405);
            back_image.setPreserveRatio(false);
        });

        b3.setOnMouseClicked(event->{
                if(color_show==false)
                    color_show=true;
                else
                    color_show=false;
        });

        String buttonCSS = "-fx-background-color:  #339933;" + "-fx-text-fill:snow;" +
                "-fx-padding: 6 6 6 6;" + "-fx-border-color: #4d0099;" +
                "fx-border-radius: 4;" + "-fx-font-weight: bold;" +
                "-fx-alignment: center-left";

        b1.setStyle(buttonCSS);
        b2.setStyle(buttonCSS);
        b3.setStyle(buttonCSS);
        b1.setMinSize(226,41);
        b2.setMinSize(226,41);
        b3.setMinSize(226,41);

        vb.getChildren().addAll(b1, b2, b3);
        sagaOfStyle.addExButton(b1, b2, b3);
    }

    private void keyPressInitiator(CodeBox codeBox) {
        /*ChoiceBox<String> choiceBox = (ChoiceBox<String>) (button.getGraphic());
        button.setGraphic(choiceBox);*/
        for(Node w:codeBox.getChildren())
            System.out.println(w);
        mainPane.setOnKeyPressed(event -> {
            /*String text;
            try {
                text = ((ChoiceBox<String>) ((fButton) codeBox.getChildren().get(0)).getGraphic()).getValue();
            } catch (Exception e) {
                System.out.println("Exception for key pressing: " + e);
                return;
            }
            if (event.getText().equalsIgnoreCase(text))
                try {
                    codeBox.codeExecute();
                } catch (InterruptedException e) {
                    System.out.println("Key press interrupted");
                }
            System.out.println("Goru: " + event.getText() + " " + text);*/
            SagaOfKeyPressing.letUsPerformTheSaga(event.getText());
        });
    }

    public void spriteClickInitiator(CodeBox codeBox) {
        spriteView.setOnMouseClicked(event -> {
            try {
                codeBox.codeExecute();
            } catch (InterruptedException e) {
                System.out.println("Execution interrupted");
            }
            System.out.println("Success!!!");
        });
    }

    public void init_sound() {
        sagaOfStyle.init_sound();

        enableClone();
    }

    public void initConditionButton() {
        sagaOfStyle.initConditionButton();
        enableClone();
    }

    public void initVariable() {
        sagaOfStyle.initVariable();
        enableClone();
    }


    CodeBox controlCode[][] = new CodeBox[12][12];
    int controlID = 0;
    int highestIndent = 0, currentIndent = 0, currentEvent = 0;

    void initControlCode() {
        for (int i = 0; i < 12; ++i) {
            for (int j = 0; j < 12; ++j)
                if(i!=0 || j!=0)
                    controlCode[i][j] = new CodeBox(codeBox.motionButton, codeBox.soundButton);
        }
    }

    @FXML
    private AnchorPane codeAnchor;
    @FXML
    private CodeBox codeBox;
    @FXML
    private SpriteView spriteView;
    @FXML
    private Pane paneForImage;
    @FXML
    private VBox codeAnchorBox;
    @FXML
    private ImageView yes;
    @FXML
    private ImageView no;
    @FXML
    private ImageView back_image;
    @FXML
    private Label color_label;


    private Button someButton = new Button("Hello");

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        color_label.setStyle("-fx-background-color: black;-fx-text-fill: white");
        back_image.setOnMouseClicked(me->{

            try {
                Color c = back_image.getImage().getPixelReader().getColor((int) me.getX(), (int) me.getY());

                //System.out.println(color.getRed() + "," +color.getBlue() + "," + color.getGreen());
                String hex = String.format( "#%02X%02X%02X",
                        (int)( c.getRed() * 255 ),
                        (int)( c.getGreen() * 255 ),
                        (int)( c.getBlue() * 255 ) );
                System.out.println(hex);
                String text = "Color : Red = " + c.getRed()*100 + "% , blue = " + c.getBlue()*100
                        + "% , green = " + c.getGreen()*100 + "%";
                color_label.setText(text);
            }catch (Exception e)
            {
                System.out.println("No image file in the background");
                color_label.setText("No Image in the background");

            }

        });

        for (int i = 1; i <= 12; i++)
            tf[i] = new TextField();

        for (int i = 1; i <= 12; i++)
            btn[i] = new fButton("", tf[i]);


        File file = new File("src/img/pic1.png");
        Image image = new Image(file.toURI().toString());
        spriteView = new SpriteView(image);

        file = new File("src/img/yes.png");
        image = new Image(file.toURI().toString());
        yes.setImage(image);

        /*file = new File("src/img/no.jpg");
        image = new Image(file.toURI().toString());
        no.setImage(image);*/

        sagaOfStyle = new SagaOfStyle(tf, btn, vb);

        codeBox = new CodeBox("Box For Code", spriteView, "src/sample/LoTS.mp3");
        controlCode[currentEvent][controlID] = codeBox;
        initControlCode();

        paneForImage.getChildren().add(spriteView);

        codeAnchorBox.getChildren().add(codeBox);

        //codeBox.getChildren().add(someButton);
        someButton.setOnAction(event -> {
            try {
                codeBox.codeExecute();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }

    void enableClone() {
        for (Node comButton : vb.getChildren()) {
            //System.out.println(((fButton)comButton).getText());
            ((fButton) comButton).setOnAction(event -> {
                try {
                    //Node savedGraphic = btn1.getGraphic();
                    if (comButton.getStyle().contains("FF8000")) {
                        System.out.println("Controller Button From enableClone()");
                        if (controlCode[currentEvent][0].getChildren().isEmpty()) {
                            controlCode[currentEvent][0].getChildren().add(((fButton) comButton).clone());
                        } else {
                            System.out.println("++curentEvent ; val : " + currentEvent);
                            ++currentEvent;
                            codeAnchorBox.getChildren().add(new fButton("Hello, new Event!!!"));
                            codeAnchorBox.getChildren().add(controlCode[currentEvent][0]);
                            controlCode[currentEvent][0].getChildren().add(((fButton) comButton).clone());
                        }
                        if (((fButton) comButton).getText().contains("বিড়ালের"))
                            spriteClickInitiator(controlCode[currentEvent][0]);
                        else if (((fButton) comButton).getText().contains("বোতাম")) {
                            keyPressInitiator(controlCode[currentEvent][0]);
                            //Added on 20:19, 31 Jan 2019
                            SagaOfKeyPressing.whyTroubleMakingASaga(controlCode[currentEvent][0],comButton);
                            System.out.println("Key Pressed Output");
                        }
                    } else if (controlCode[currentEvent][0].getChildren().isEmpty())
                        AlertBox.display("No Event Found", "Please add an Event");
                    else if (comButton.getStyle().contains("1971cc")) {
                        //CodeBox codeBox1 = new CodeBox(codeBox.motionButton, codeBox.soundButton);
                        if (((fButton) comButton).getText().contains("শেষ")) {
                            controlCode[currentEvent][controlID].getChildren().add(((fButton) comButton).clone());
                            controlID = currentIndent;
                            if (controlID < 0) controlID = 0;
                        } else {
                            currentIndent = controlID;
                            controlID = highestIndent + 1;
                            if (controlID > highestIndent)
                                highestIndent = controlID;
                            controlCode[currentEvent][controlID].getChildren().add(((fButton) comButton).clone());
                            controlCode[currentEvent][currentIndent].getChildren().add(controlCode[currentEvent][controlID]);
                        }
                    } else {
                            /*if(comButton.getStyle().contains("1971cc")){
                                controlCode[controlID].getChildren().add(((fButton) comButton).clone());
                                codeBox.getChildren().add(controlCode[controlID]);
                            }
                            else*/
                        controlCode[currentEvent][controlID].getChildren().add(((fButton) comButton).clone());
                    }
                    //((TextInputControl)btn1.getGraphic()).setText("0");
                } catch (CloneNotSupportedException e) {
                    System.out.println("Clone Not Supported! Never will this line be printed.");
                }
            });
        }
    }

    /*@FXML private void startExecution()
    {
        for(Node node: codeAnchorBox.getChildren()){
            if(node.getClass().toString().contains("CodeBox")){
                try {
                    ((CodeBox) node).codeExecute();
                } catch (Exception e){
                    System.out.println("While starting execution: " + e);
                }
            }
        }
    }*/

    public void deleteLast() {
        controlCode[currentEvent][controlID].getChildren().remove(controlCode[currentEvent][controlID].getChildren().size() - 1);
    }

    /*public void deleteAll() {
        codeBox = new CodeBox()

    }
        ;
    }*/
    public void write() throws Exception {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("src/codeBoxWritten.txt")));
        objectOutputStream.writeObject(codeBox);
        System.out.println("Object written");
    }

    public void getCodeBox() throws Exception {
        CodeBox c = new CodeBox();
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/codeBoxWritten.txt"));
        c = (CodeBox) objectInputStream.readObject();
        for (Node p : c.getChildren()) {
            System.out.println(p);
        }
    }

    @FXML private void printButton() throws Exception{
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("src/codesBoxWritten.txt")));
        for(fButton q:btn){
            objectOutputStream.writeObject(q);
        }
        System.out.println("Should have been written");
    }

    @FXML private void getButton() throws Exception{
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/codesBoxWritten.txt"));
        fButton button = new fButton("ss");
        Object rdf = new Object();
        button = (fButton) objectInputStream.readObject();
        try {
            while(true) {
                button = (fButton) objectInputStream.readObject();
                System.out.println(button);
                weirdBox.getChildren().add(button);
            }
        } catch (Exception e){
            System.out.println("Button reading exception: " + e);
            //e.printStackTrace();
        }
        System.out.println(rdf);
        //System.out.println(button.getText());
    }
    @FXML private VBox weirdBox;
}
