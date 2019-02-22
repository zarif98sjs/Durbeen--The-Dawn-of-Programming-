package sample;

import javafx.animation.TranslateTransition;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;

public class SoundButton extends fButton {

    private MediaPlayer mediaPlayer;

    SoundButton(String txt, String relativePath)
    {
        super(txt);
        mediaPlayer = new MediaPlayer(new Media(new File(relativePath).toURI().toString()));
    }

    public TranslateTransition playSound()
    {
        TranslateTransition transition = new TranslateTransition(Duration.ZERO);
        System.out.println("Playing Sounds");
        transition.setOnFinished(event -> mediaPlayer.play());
        return transition;
    }

    public void playSound(double seconds)
    {
        System.out.println("Playing sounds for " + seconds + " seconds");
        mediaPlayer.play();
        mediaPlayer.setStopTime(Duration.seconds(seconds));
    }

    public void setVolumePercentage(double volume)
    {
        volume /= 100.0;
        mediaPlayer.setVolume(volume);
    }

    public void changeVolumePercentage(double dvolume)
    {
        mediaPlayer.setVolume(mediaPlayer.getVolume() + dvolume/100.0);
    }

    public void stopAllSounds()
    {
        mediaPlayer.stop();
    }

    public void pauseAllSounds()
    {
        mediaPlayer.pause();
    }

    public void newPath(String q){
        mediaPlayer = new MediaPlayer(new Media(new File(q).toURI().toString()));
    }
}
