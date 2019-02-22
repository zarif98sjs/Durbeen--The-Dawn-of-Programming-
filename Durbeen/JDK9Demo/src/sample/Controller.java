package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.stage.*;
import javafx.util.Pair;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

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
        //enableClone();
    }

    //I started working from here

    public void initControllerButton() {
        sagaOfStyle.initControllerButton();
        enableClone();
    }

    static private fButton b1, b2, b3;

    public void init_change_sprite() {
        sagaOfStyle.init_text_button();

        b1 = new fButton("ছবি বদলাও", false);
        b2 = new fButton("পটভুমি পাল্টাও", false);
        b3 = new fButton("পটভূমির রঙ", false);

        FileChooser abcd = new FileChooser();
        abcd.setTitle("Finding the file");
        abcd.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.bmp", "*.png", "*.jpeg", "*.jpg"));

        b1.setOnMouseClicked(event -> {
            File f1 = abcd.showOpenDialog(primary_Stage);
            spritePath = f1.getAbsolutePath();
            spriteView.setImage(new Image(f1.toURI().toString()));
            spriteView.resize();
        });

        b2.setOnMouseClicked(event -> {
            File f1 = abcd.showOpenDialog(primary_Stage);
            backPath = f1.getAbsolutePath();
            back_image.setImage(new Image(f1.toURI().toString()));
            back_image.setPreserveRatio(false);
        });

        b3.setOnMouseClicked(event -> {
            if (color_show == false)
                color_show = true;
            else
                color_show = false;
            try {
                System.out.println("Point A Color : " + spriteView.kon_color(SpriteView.ax, SpriteView.ay));
                System.out.println("Point B Color : " + spriteView.kon_color(SpriteView.bx, SpriteView.by));
                System.out.println("Point C Color : " + spriteView.kon_color(SpriteView.cx, SpriteView.cy));
                System.out.println("Point D Color : " + spriteView.kon_color(SpriteView.dx, SpriteView.dy));
            } catch (Exception e) {
                System.out.println("NO IMG");
            }
            //sprite_label.setText("X: "+event.getX()+" , "+event.getSceneX());
        });

        String buttonCSS = "-fx-background-color:  #339933;" + "-fx-text-fill:snow;" +
                "-fx-padding: 6 6 6 6;" + "-fx-border-color: #4d0099;" +
                "fx-border-radius: 4;" + "-fx-font-weight: bold;" +
                "-fx-alignment: center-left";

        b1.setStyle(buttonCSS);
        b2.setStyle(buttonCSS);
        b3.setStyle(buttonCSS);

        b1.setMinSize(226, 41);
        b2.setMinSize(226, 41);
        b3.setMinSize(226, 41);

        vb.getChildren().setAll(b1, b2);
        sagaOfStyle.addExButton(b1, b2, b3);
    }

    private void keyPressInitiator(CodeBox codeBox) {
        /*ChoiceBox<String> choiceBox = (ChoiceBox<String>) (button.getGraphic());
        button.setGraphic(choiceBox);*/
        for (Node w : codeBox.getChildren())
            System.out.println(w);
        mainPane.setOnKeyPressed(event -> {
            SagaOfKeyPressing.letUsPerformTheSaga(event.getText());
        });
    }

    private static void keyPressInitiator(CodeBox codeBox, Pane mainPane) {
        /*ChoiceBox<String> choiceBox = (ChoiceBox<String>) (button.getGraphic());
        button.setGraphic(choiceBox);*/
        for (Node w : codeBox.getChildren())
            System.out.println(w);
        mainPane.setOnKeyPressed(event -> {
            SagaOfKeyPressing.letUsPerformTheSaga(event.getText());
        });
    }

    public static void spriteClickInitiator(CodeBox codeBox) {
        System.out.println("It came into SpriteClickInitiator");
        codeBox.spriteView.setOnMouseClicked(event -> {
            try {
                codeBox.codeExecute().play();
            } catch (InterruptedException e) {
                System.out.println("Execution interrupted");
            }
            System.out.println("Success!!!");
        });
    }

    public void openPaint() throws Exception {
        Stage primaryStage = new Stage(StageStyle.DECORATED);
        primaryStage.initModality(Modality.APPLICATION_MODAL);
        Parent root = FXMLLoader.load(getClass().getResource("paint.fxml"));
        primaryStage.setTitle("রঙ তুলি");
        Scene scene = new Scene(root, 1200, 650);
        scene.getStylesheets().add(getClass().getResource("paintstyle.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
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

    public void show_help() throws Exception {
        Runtime.getRuntime().exec("notepad README.txt");
    }


    CodeBox controlCode[][] = new CodeBox[12][12];
    int controlID = 0;
    int highestIndent = 0, currentIndent = 0, currentEvent = 0;

    void initControlCode() {
        for (int i = 0; i < 12; ++i) {
            for (int j = 0; j < 12; ++j)
                if (i != 0 || j != 0)
                    controlCode[i][j] = new CodeBox(codeBox.motionButton, codeBox.soundButton);
        }
    }

    @FXML
    private AnchorPane codeAnchor;
    @FXML
    private CodeBox codeBox;
    @FXML
    private static SpriteView spriteView;
    @FXML
    private Pane paneForImage;
    @FXML
    private CodeAnchorBox codeAnchorBox;
    @FXML
    private ImageView yes;
    @FXML
    private ImageView no;
    @FXML
    private ImageView back_image;
    @FXML
    private Label color_label;
    @FXML
    private Label sprite_label;
    private static ImageView backImageView;

    private Button someButton = new Button("Hello");

    static String spritePath = "src\\img\\catsp.png";
    static String mediaPath = "src\\sample\\LoTS.mp3";
    static String backPath = null;

    @FXML
    javafx.scene.shape.Circle circle1, circle2, circle3, circle4, circle5, circle6, circle7, circle8, circle9;

    private void setCircleHover() {

        Circle[] circles = {circle1, circle2, circle3, circle4, circle5, circle6, circle7, circle8, circle9};
        for (Circle round : circles) {
            round.setOnMouseEntered(e -> round.setOpacity(0.5));
            round.setOnMouseExited(e -> round.setOpacity(1));
        }
    }

    @FXML
    Pane backImagePane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        setCircleHover();

        File file = new File(spritePath);
        Image image = new Image(file.toURI().toString());
        spriteView = new SpriteView(image, sprite_label, back_image);
        spriteView.find_sprite_position();


        color_label.setStyle("-fx-background-color: black;-fx-text-fill: white");
        sprite_label.setStyle("-fx-background-color: brown;-fx-text-fill: white");
        //sprite_label.setText("X: "+spriteView.getLayoutX()+" , "+spriteView.getLayoutY());
        paneForImage.setOnMouseClicked(me -> {
            //System.out.println("Mouse clicked on backImagePane");
            try {
                System.out.println("Color is : " + spriteView.kon_color(me.getX(), me.getY()));
                color_label.setText(spriteView.kon_color(me.getX(), me.getY()));
            } catch (Exception e) {
                //System.out.println("No image file in the background");
                color_label.setText("পটভূমি ফাঁকা");
                //e.printStackTrace();
            }
        });

        for (int i = 1; i <= 15; i++)
            tf[i] = new TextField();

        for (int i = 1; i <= 12; i++)
            btn[i] = new fButton("", tf[i]);


        /*file = new File("src/img/no.jpg");
        image = new Image(file.toURI().toString());
        no.setImage(image);*/

        MAINPANE = mainPane;

        sagaOfStyle = new SagaOfStyle(tf, btn, vb);
        codeAnchorBox = new CodeAnchorBox(40);

        codeBox = new CodeBox("Box For Code", spriteView, mediaPath);
        controlCode[currentEvent][controlID] = codeBox;
        codeBox.setSpritePath(file.getAbsolutePath());
        initControlCode();

        paneForImage.getChildren().add(spriteView);

        codeAnchorBox.getChildren().add(codeBox);
        codeAnchor.getChildren().add(codeAnchorBox);

        //codeBox.getChildren().add(someButton);
        someButton.setOnAction(event -> {
            try {
                codeBox.codeExecute();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        backImageView = back_image;
        staticAnchor = codeAnchorBox;

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
                            //codeAnchorBox.getChildren().add(new fButton("Hello, new Event!!!"));
                            codeAnchorBox.getChildren().add(controlCode[currentEvent][0]);
                            controlCode[currentEvent][0].getChildren().add(((fButton) comButton).clone());
                        }
                        if (((fButton) comButton).getText().contains("বিড়ালের"))
                            spriteClickInitiator(controlCode[currentEvent][0]);
                        else if (((fButton) comButton).getText().contains("বোতাম")) {
                            keyPressInitiator(controlCode[currentEvent][0]);
                            //Added on 20:19, 31 Jan 2019
                            SagaOfKeyPressing.whyTroubleMakingASaga(controlCode[currentEvent][0], comButton);
                            System.out.println("Key Pressed Output");
                        }
                    } else if (controlCode[currentEvent][0].getChildren().isEmpty())
                        AlertBox.display("ঘটনা যোগ করা হয় নি", "ঘটনা যোগ করো");
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

    private static CodeAnchorBox staticAnchor;

    public void deleteLast() {
        controlCode[currentEvent][controlID].getChildren().remove(controlCode[currentEvent][controlID].getChildren().size() - 1);
    }

    PrintWriter writer;

    /*public void deleteAll() {
        codeBox = new CodeBox()

    }
        ;
    }*/

    public void write() throws Exception {
        String string = "", fileName = "";
        Pair<String, String> stringPair = NameInput.getString(string, fileName);
        string = stringPair.getKey();
        System.out.println("S: " + string);
        fileName = stringPair.getValue();
        System.out.println("F: " + fileName);
        File file = new File("src/" + string + ".txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
        objectOutputStream.writeObject(codeAnchorBox);
        /*NHOStream nhoStream = new NHOStream(new FileOutputStream(new File("src/BoxWritten.txt")));
        nhoStream.writeObject(codeAnchorBox);*/
        String fString = string;
        String fName = fileName;
        writer = new PrintWriter(Main.socket.getOutputStream(), true);
        new Thread(() -> {
            System.out.println("Object written");
            writer.println("WRITE_IT");
            writer.println(fString);
            writer.println(fName);
            writer.println(file.getPath());
            writer.println(spritePath);
            writer.println(backPath);
        }).start();
    }

    public void getCodesBox() throws Exception {
        String r = OneStringUI.getString();
        Controller.getCodeBox(r);
    }

    public static void getCodeBox(String r) throws Exception {
        //String r;// = OneStringUI.getString();
        //r = "trial2";
        PrintWriter writer = new PrintWriter(Main.socket.getOutputStream(), true);
        writer.println("GET_THE_CODE");
        writer.println(r);
        Scanner scanner = new Scanner(Main.socket.getInputStream());
        while (scanner.hasNextLine() == false) ;
        File file;
        String abc = scanner.nextLine();
        System.out.println("abc: " + abc + "\n& " + scanner.hasNextLine());
        String sPath = "", bPath = "";
        //if (scanner.hasNextLine()) {
        //  System.out.println("waiting");
        sPath = scanner.nextLine();
        bPath = scanner.nextLine();
        System.out.println("Received file name: " + abc);
        try {
            file = new File(abc);
            try {
                backPath = bPath;
                spritePath = sPath;
                backImageView.setImage(new Image(new File(bPath).toURI().toString()));
                backImageView.setPreserveRatio(false);
                spriteView.setImage(new Image(new File(sPath).toURI().toString()));
            } catch (Exception e) {
                System.out.println("No fatal exception: " + e);
            }

        } catch (Exception e) {
            System.out.println("File Not Found");
            e.printStackTrace();
            return;
        }
        CodeAnchorBox c = new CodeAnchorBox();
        ObjectInputStream objectInputStream;
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
        } catch (Exception e) {
            AlertBox.display("ফাইল পাওয়া যায় নি", "বন্ধ করো");
            return;
        }
        //NHIStream objectInputStream = new NHIStream(new FileInputStream("src/BoxWritten.txt"));
        //c = (CodeBox) objectInputStream.readObject();
        try {
            c = (CodeAnchorBox) objectInputStream.readObject();
            for (Node qq : c.getChildren()) {
                //CodeBox q = (CodeBox) qq;
                System.out.println("From write : qq");
                if (qq instanceof CodeBox) {
                    CodeBox q = (CodeBox) qq;
                    for (Node p : q.getChildren()) {
                        System.out.println("gadha " + p);
                        if (p.getClass().toString().contains("CodeBox")) ;
                        else if (((fButton) p).getText().contains("বিড়ালের"))
                            Controller.spriteClickInitiator(q);
                        else if (((fButton) p).getText().contains("বোতাম")) {
                            Controller.keyPressInitiator(q, Controller.getMainPane());
                            SagaOfKeyPressing.whyTroubleMakingASaga(q, p);
                        }
                    }
                }
                else if(qq instanceof CodeAnchorBox){
                    for(Node op : ((CodeAnchorBox) qq).getChildren()){
                        CodeBox q = (CodeBox) op;
                        for (Node p : q.getChildren()) {
                            System.out.println("gadhara " + p + "");
                            if (p.getClass().toString().contains("CodeBox")) ;
                            else if (((fButton) p).getText().contains("বিড়ালের"))
                                Controller.spriteClickInitiator(q);
                            else if (((fButton) p).getText().contains("বোতাম")) {
                                Controller.keyPressInitiator(q, Controller.getMainPane());
                                SagaOfKeyPressing.whyTroubleMakingASaga(q, p);
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("File Transfer Over with exception: " + e);
            //e.printStackTrace();
        }
        System.out.println("গরু");
        staticAnchor.getChildren().setAll(c);
        for (Node p : staticAnchor.getChildren()) {
            System.out.println(p);
        }
    }

    @FXML
    private void printButton() throws Exception {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File("src/codesBoxWritten.txt")));
        for (fButton q : btn) {
            objectOutputStream.writeObject(q);
        }
        System.out.println("Should have been written");
    }

    @FXML
    private void getButton() throws Exception {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("src/codesBoxWritten.txt"));
        fButton button = new fButton("ss");
        Object rdf = new Object();
        button = (fButton) objectInputStream.readObject();
        try {
            while (true) {
                button = (fButton) objectInputStream.readObject();
                System.out.println(button);
                weirdBox.getChildren().add(button);
            }
        } catch (Exception e) {
            System.out.println("Button reading exception: " + e);
            //e.printStackTrace();
        }
        System.out.println(rdf);
        //System.out.println(button.getText());
    }

    @FXML
    private VBox weirdBox;

    public static SpriteView getSpriteView() {
        return spriteView;
    }


    private static Pane MAINPANE; // = mainPane;

    public static Pane getMainPane() {
        return MAINPANE;
    }

    @FXML
    private void loadAgain() throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Front.fxml"));
        codeAnchorBox = new CodeAnchorBox();
        staticAnchor = codeAnchorBox;
        SagaOfKeyPressing.clearSaga();
        Main.window.setTitle("JDK 9.0.4 Demo");
        Scene scene = new Scene(root, 1200, 650);
        scene.getStylesheets().add(getClass().getResource("frontstyle.css").toExternalForm());
        Main.window.setScene(scene);
        //primaryStage.show();
    }
}