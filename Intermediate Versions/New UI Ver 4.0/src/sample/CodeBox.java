package sample;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.concurrent.TimeUnit;

public class CodeBox extends VBox {

    MotionButton motionButton;
    SoundButton soundButton;
    ObservableList<Node> observableList;

    CodeBox(String abc, SpriteView spriteView, String mediaPath)
    {
        motionButton = new MotionButton(abc, spriteView);
        soundButton = new SoundButton(abc, mediaPath);
        observableList = this.getChildrenUnmodifiable();
        try{
            this.setWidth(((Pane)this.getParent()).getWidth());
        } catch (Exception e){
            System.out.println("Ïn codebox constructor, exception caught: " + e);
        }
    }

    CodeBox(MotionButton conMotionButton, SoundButton conSoundButton)
    {
        motionButton = conMotionButton;
        soundButton = conSoundButton;
        observableList = this.getChildrenUnmodifiable();
    }

    void refresh()
    {
        observableList = this.getChildrenUnmodifiable();
        for(Node p : observableList){
            System.out.println(p);
        }
    }
//    void add(Node )

    void codeExecute() throws InterruptedException {
        observableList = this.getChildrenUnmodifiable();

        new Thread(()->{

            for(Node blockNode : observableList)
            {
                if(blockNode.getClass().toString().contains("fButton") == false)
                    continue;

                Platform.runLater(()->{
                    fButton block = (fButton) blockNode;
                    String style = block.getStyle();
                    String text = block.getText();
                    double value = Double.parseDouble(((TextField) block.getGraphic()).getText());
                    switch (text)
                    {
                        case "ঘর আগাও":
                            motionButton.moveForward(value);
                            System.out.println("AGACHCHE");
                            /*try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }*/
                            break;
                        case "ডানে ঘোরো":
                            motionButton.rotateIfTrueClockwise(true,value);
                            System.out.println("DAANE GHOORE");
                            /*try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }*/
                            break;
                        case "বামে ঘোরো":
                            motionButton.rotateIfTrueClockwise(false,value);
                            System.out.println("BAAME GHOORE");
                            /*try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }*/
                            break;
                        case "Wait":
                            try {
                                TimeUnit.SECONDS.sleep((long) value);
                            } catch (Exception e){
                                System.out.println("Sleep exception: " + e);
                            }
                    }

                });

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
