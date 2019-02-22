package sample;

import javafx.scene.Node;
import javafx.scene.control.ChoiceBox;

public class SagaOfKeyPressing {
    private CodeBox codeBox;
    private ChoiceBox<String> choiceBox;
    static int id=0;

    public SagaOfKeyPressing(CodeBox codeBox, ChoiceBox<String> choiceBox) {
        this.codeBox = codeBox;
        this.choiceBox = choiceBox;
        sagaOfKeyPressings[id] = this;
        id = id + 1;
    }

    static void whyTroubleMakingASaga(CodeBox codeBox, Node node){
        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        try{
            choiceBox = (ChoiceBox<String>) ((fButton)node).getGraphic();
        } catch(Exception e){
            System.out.println("Ah! Some trouble happened making a saga: " + e);
        }
        SagaOfKeyPressing s = new SagaOfKeyPressing(codeBox, choiceBox);
        System.out.println(s);
    }
    ;

    static SagaOfKeyPressing[] sagaOfKeyPressings = new SagaOfKeyPressing[50];

    public static void letUsPerformTheSaga(String key)
    {
        String text = new String();
        for(SagaOfKeyPressing saga:sagaOfKeyPressings){
            /*System.out.println(saga);
            System.out.println(saga.choiceBox);
            System.out.println(saga.choiceBox.getValue());*/
            //text = saga.choiceBox.getValue();
            try {
                text = ((ChoiceBox<String>) ((fButton) saga.codeBox.getChildren().get(0)).getGraphic()).getValue();
            } catch(Exception e){
                System.out.println("Unknown exception");
            }
            if(key.equalsIgnoreCase(text)) {
                try {
                    saga.codeBox.codeExecute().play();
                    break;
                } catch (Exception e) {
                    System.out.println("While actioning the saga of key pressing: " + e);
                }
            }
            System.out.println("Key was " + key + " and text was " + text);
        }
    }

    public static void clearSaga(){
        sagaOfKeyPressings = new SagaOfKeyPressing[102];
    }
}
