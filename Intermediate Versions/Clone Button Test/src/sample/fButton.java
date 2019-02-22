package sample;

//import javafx.scene.Node;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.lang.Cloneable;

public class fButton extends Button implements Cloneable{
    @FXML
    private double orgSceneX, orgSceneY, orgTranslateX, orgTranslateY;

    @Override
    protected fButton clone() throws CloneNotSupportedException {
        fButton a = new fButton();
        a.setScaleX(this.getScaleX());
        a.setScaleY(this.getScaleY());
        a.setStyle(this.getStyle());
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

    @FXML private void onMouseDragEntered(Pane parent)
    {
        for(int i=1;i<6;++i)
            System.out.println("Mouse Drag entered");
        try {
            fButton b1_child = this.clone();
            b1_child.setOnMouseClicked(event -> onMouseDragEntered(parent));
            //parent.getChildren().add(b1_child);
            parent.getChildren().add(b1_child);
        } catch (Exception e){
            ;
        }
    }
}
