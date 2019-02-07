package sample;

import javafx.scene.control.ChoiceBox;

public class ControllerButton extends fButton {

    private CodeBox codeBox;

    private static String controllerButtonStyle = "-fx-background-color: #FF8000;" + "-fx-text-fill:snow;" +
            "-fx-padding: 6 6 6 6;" + "-fx-border-color: darkblue;" +
            "fx-border-radius: 4;"+ "-fx-font-weight: bold;"+
            "-fx-alignment: center-left";

    public ControllerButton(CodeBox codeBox1) {
        codeBox = codeBox1;
    }

    public static fButton spriteClickedButton() {
        fButton button = new fButton("যখন তুমি বিড়ালের উপর ক্লিক করো", false);
        button.setStyle(controllerButtonStyle);
        return button;
    }


    public static fButton thisClickedButton() {
        fButton button = new fButton("যখন তুমি এই বোতামের উপর ক্লিক করো", false);
        button.setStyle(controllerButtonStyle);
        return button;
    }

    public static fButton keyPressedButton() {
        ChoiceBox<String> stringChoiceBox = new ChoiceBox<>();
        Character ch;

        for(ch = 'A'; ch <= 'Z'; ++ch){
            stringChoiceBox.getItems().add(ch.toString());
        }

        fButton button = new fButton("যখন তুমি এই বোতাম চাপো", stringChoiceBox);
        button.setStyle(controllerButtonStyle);
        //button.setGraphic(stringChoiceBox);

        return button;
    }

}
