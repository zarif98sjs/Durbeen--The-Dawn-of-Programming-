package sample;

public class ColorDetect {


    public static boolean withinRange(double num, double standard, double range){
        return (num-standard)<range || (standard-num)<range;
    }
}
