package sample;

import javafx.animation.SequentialTransition;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

public class CodeBox extends VBox implements Serializable {

    MotionButton motionButton;
    SoundButton soundButton;
    ObservableList<Node> observableList;
    SpriteView spriteView;
    boolean mainBlock = true;
    String mediaPath;

    SequentialTransition transition = new SequentialTransition();

    public void setSpritePath(String spritePath) {
        this.spritePath = spritePath;
    }

    String spritePath;

    CodeBox(String abc, SpriteView spriteView, String mediaPath) {
        motionButton = new MotionButton(abc, spriteView);
        soundButton = new SoundButton(abc, mediaPath);
        observableList = this.getChildrenUnmodifiable();
        try {
            this.setWidth(((Pane) this.getParent()).getWidth());
        } catch (Exception e) {
            System.out.println("Ïn codeBox constructor, exception caught: " + e);
        }
        this.spriteView = spriteView;
        this.mediaPath = mediaPath;
        //this.setMinHeight(500);
        setSpacing(3);
    }

    CodeBox(MotionButton conMotionButton, SoundButton conSoundButton) {
        motionButton = conMotionButton;
        soundButton = conSoundButton;
        observableList = this.getChildrenUnmodifiable();
        spriteView = motionButton.spriteView;
        setSpacing(3);
    }

    CodeBox() {
    }

    CodeBox underBlock(ObservableList q) {
        CodeBox a = new CodeBox(this.motionButton, this.soundButton);
        a.observableList = q;
        a.mainBlock = false;
        return a;
    }

    void refresh() {
        observableList = this.getChildrenUnmodifiable();
        for (Node p : observableList) {
            System.out.println(p);
        }
    }
//    void add(Node )

    SequentialTransition codeExecute() throws InterruptedException {
        //if (mainBlock)
        observableList = this.getChildrenUnmodifiable();
        transition = new SequentialTransition(spriteView);
        transition.setCycleCount(1);
        transition.setAutoReverse(false);
        /*for (Node b : observableList)
            System.out.println(b);*/
        //synchronized (this) {
          //  new Thread(() -> {
                for (Node blockNode : observableList) {
                    System.out.println("From thread second: " + blockNode);
            //        Platform.runLater(() -> {
                        System.out.println(blockNode.getClass());
                        if (blockNode.getClass().toString().contains("CodeBox")) {
                            fButton control = (fButton) (((CodeBox) blockNode).getChildren().get(0));
                            String text = control.getText();
                            String com = "", cond = "";
                            double value = 0;
                            try {
                                com = ((TextField) control.getGraphic()).getText();
                                com = NumeralInBangla.toBanglaString(com);
                                cond = Main.js.eval(com).get(0).value();
                                value = Double.parseDouble(cond);
                            } catch (Exception e) {
                                System.out.println("Exception caUgHt: " + e);
                            }
                            switch (text) {
                                case "বার করো":
                                    System.out.println(value + " বার করো");
                                    int blocknode_size = ((CodeBox) blockNode).getChildren().size() - 2;
                                    double finalValue = value;
              //                      new Thread(() -> {
                                        for (int i = 0; i < finalValue; ++i) {
                //                            Platform.runLater(() -> {
                                                try {
                                                    transition.getChildren().add(((CodeBox) blockNode).codeExecute());
                                                } catch (Exception e) {
                                                    System.out.println("Exception caught from repeat block: " + e);
                                                }
                                            /*try {
                                                wait();
                                            } catch (Exception e){
                                                System.out.println("Exception caught while waiting: " + e + "with i=" + i);
                                            }*/
                  //                          });
                                            /*try {
                                                Thread.sleep(blocknode_size * 1100); //Made 1100 for "SECURITY" purposes
                                            } catch (InterruptedException e) {
                                                e.printStackTrace();
                                            }*/

                                        }

                    //                }).start();
                                    break;
                                case "যদি":
                                    System.out.println("যদি " + com + " " + cond + " " + value);
                                    if ((!cond.equalsIgnoreCase("false")) && (!cond.equals("0"))) {
                                        try {
                                            transition.getChildren().add(((CodeBox) blockNode).codeExecute());
                                        } catch (Exception e) {
                                            System.out.println("Exception caught from if block: " + e);
                                        }
                                    }
                                    break;
                                case "যতক্ষণ":
                                    String whileCommand = com;
                                    System.out.println("Entered while block");
                                    while(true){
                                        Main.js.eval("System.out.println(\"From JShell: \" + t)");
                                        System.out.println("WhileCommand: " + whileCommand);
                                        cond = Main.js.eval(whileCommand).get(0).value();
                                        if(cond.contains("false") || cond.equals("0"))
                                            break;
                                        System.out.println("Did not break with cond = " + cond);
                                        try{
                                            transition.getChildren().add(((CodeBox) blockNode).codeExecute());
                                        } catch (Exception e){
                                            System.out.println("Exception caught from while block: " + e);
                                        }
                                    }
                                    break;
                                case "যদি এই রঙ":
                                    com = ((ChoiceBox<String>) (control.getGraphic())).getValue().toString();
                                    System.out.println("Parsed color string: " + com);
                                    if (spriteView.ei_color_er_upor_aase_kina(com)) {
                                        try {
                                            transition.getChildren().add(((CodeBox) blockNode).codeExecute());
                                        } catch (Exception e) {
                                            System.out.println("Exception caught from repeat block: " + e);
                                        }
                                    }
                                    break;
                                case "যদি এই রঙ না হয়":
                                    com = ((ChoiceBox<String>) (control.getGraphic())).getValue().toString();
                                    System.out.println("Parsed color string: " + com);
                                    if (!spriteView.ei_color_er_upor_aase_kina(com)) {
                                        try {
                                            transition.getChildren().add(((CodeBox) blockNode).codeExecute());
                                        } catch (Exception e) {
                                            System.out.println("Exception caught from repeat block: " + e);
                                        }
                                    }
                                    break;
                            }
                        }
                        //continue
                        else {
                            fButton block;
                            block = (fButton) blockNode;
                            String style = block.getStyle();
                            String text = block.getText();
                            String com;
                            double value = 0;
                            try {
                                com = ((TextField) block.getGraphic()).getText();
                                com = NumeralInBangla.toBanglaString(com);
                                if (style.contains("56255B")) {
                                    System.out.println(Main.js.eval(text + com + ";").get(0).value());
                                    System.out.println(text + com);
                                    //return;
                                }
                                else
                                    value = Double.parseDouble(Main.js.eval(com).get(0).value());
                            } catch (Exception e) {
                                System.out.println("Exception caUght: " + e + " in " + text);
                            }
                            System.out.println(text);
                            switch (text) {
                                case "ঘর আগাও":
                                    transition.getChildren().add(motionButton.moveForward(value));
                                    System.out.println("AGACHCHE");
                            /*try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }*/

                                    break;
                                case "ডানে ঘোরো":
                                    transition.getChildren().add(motionButton.rotateIfTrueClockwise(true, value));
                                    System.out.println("DAANE GHOORE");
                            /*try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }*/
                                    break;
                                case "বামে ঘোরো":
                                    transition.getChildren().add(motionButton.rotateIfTrueClockwise(false, value));
                                    System.out.println("BAAME GHOORE");
                            /*try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }*/
                                    break;
                                /*case "Set X":
                                    motionButton.setX(value);
                                    break;
                                case "Set Y":
                                    motionButton.setY(value);
                                    break;*/
                                case "ভুজ ঠিক করো":
                                    transition.getChildren().add(motionButton.glideToPosition(2, value, spriteView.getBoundsInLocal().getMinY()));
                                    break;
                                case "কোটি ঠিক করো":
                                    transition.getChildren().add(motionButton.glideToPosition(2, spriteView.getBoundsInLocal().getMinX(), value));
                                    break;
                                case "মাউসের দিকে ঘোরো":
                                    transition.getChildren().add(motionButton.pointToMousePointer());
                                    break;
                                case "বাজাতে থাকো":
                                    transition.getChildren().add(soundButton.playSound());
                                    break;
                                case "সেকেন্ড ধরে বাজাও":
                                    soundButton.playSound(value);
                                    break;
                                case "ভলিউম কমাও":
                                    soundButton.changeVolumePercentage(-value);
                                    break;
                                case "ভলিউম বাড়াও":
                                    soundButton.changeVolumePercentage(value);
                                    break;
                                case "বিরত রাখো":
                                    soundButton.pauseAllSounds();
                                    break;
                                case "বন্ধ করো":
                                    soundButton.stopAllSounds();
                                    break;
                                case "শেষ":
                                    System.out.println("Printed from end block");
                                    break;
                                    //return;
                                case "অপেক্ষা করো":
                                    transition.getChildren().add(MotionButton.fillerTransition(value));
                                    break;
                                    /*try {
                                        TimeUnit.SECONDS.sleep((long) value);
                                    } catch (Exception e) {
                                        System.out.println("Sleep exception: " + e);
                                    }*/
                            /*case "যখন তুমি এই বোতামের উপর ক্লিক করো":
                                Controller.spriteClickInitiator(this, spriteView);*/
                            }
                        }
                  //  });

                    transition.getChildren().add(MotionButton.fillerTransition(0.3));

                    try {
                        //Thread.sleep(1000);
                        //wait();
                        System.out.println("Waiting : " + Thread.currentThread().getName());
                    } /*catch (InterruptedException e) {
                        e.printStackTrace();
                    } */catch (Exception e) {
                        System.out.println("Exception of wait : " + e);
                    }
                    //wait();
                    //notifyAll();
                //}
          //  }).start();
        }
                return transition;
    }

    private void writeObject(java.io.ObjectOutputStream out)
            throws IOException {
        PrintWriter pw = new PrintWriter(out, true);
        //pw.println("NewCodeBox");
        //pw.println(spritePath);
        //pw.println(mediaPath);
        for (Node p : getChildren()) {
            if (p.getClass().toString().contains("fButton"))
                out.writeObject(p);
            else if (p.getClass().toString().contains("CodeBox"))
                out.writeObject(p);
        }
        //pw.println("CodeBoxWritten");
    }

    private void readObject(java.io.ObjectInputStream in)
            throws IOException, ClassNotFoundException {
        /*Scanner scanner = new Scanner(in);
        String a = "";
        String b = (scanner.hasNextLine()) ? scanner.nextLine() : "";
        spriteView = new SpriteView(new Image((new File(b)).toURI().toURL().toString()));
        motionButton = new MotionButton(a, spriteView);
        String c = (scanner.hasNextLine()) ? scanner.nextLine() : "";
        soundButton = new SoundButton(a, c);
        //String d = (scanner.hasNextLine()) ? scanner.nextLine() : "";*/
        fButton button = new fButton("s^s");
        CodeBox c = new CodeBox();
        try {
            while (true) {
                Node ob = (Node) in.readObject();
                if (ob.getClass().toString().contains("Button")) {
                    button = (fButton) ob;
                    System.out.println("Giving check : " + button.getText());
                    if (button.getText().equals("শেষ")) {
                        getChildren().add(button);
                        break;
                    }
                /*else if(button.getText().contains("ক্লিক করো")) {
                    //System.out.println("The condition should have parsed");
                    Controller.spriteClickInitiator(this);
                }*/
                }
                else if (ob.getClass().toString().contains("CodeBox")) {
                    c = (CodeBox) ob;
                    System.out.println("CodeBox found");
                }
                getChildren().add(ob);
            }
        } catch (Exception e) {
            System.out.println("Exception while reading the codebox : " + e);
        }
        spriteView = Controller.getSpriteView();
        motionButton = new MotionButton("and", spriteView);
        soundButton = new SoundButton("and", "src\\sample\\LoTS.mp3");
        setSpacing(3);
    }

    public SpriteView getSpriteView() {
        return spriteView;
    }
}