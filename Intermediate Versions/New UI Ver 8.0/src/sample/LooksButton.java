package sample;

public class LooksButton extends fButton {

    SpriteView spriteView;

    LooksButton(String title, SpriteView sprite)
    {
        super(title);
        spriteView = sprite;
    }

    public void setWidth(double val)
    {
        spriteView.setFitWidth(val);
    }
}
