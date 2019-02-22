package sample;

import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class PieceOfCode implements Serializable {

    String fileName;
    String fileDescription;
    String filePath;
    String spritePath;
    String backPath;

    public PieceOfCode(String fileName, String fileDescription, String filePath, String spritePath, String backPath) {
        this.fileName = fileName;
        this.fileDescription = fileDescription;
        this.filePath = filePath;
        this.spritePath = spritePath;
        this.backPath = backPath;
        pieceOfCodes.add(this);
    }

    static Vector<PieceOfCode> pieceOfCodes = new Vector<>();

    public static void addPiece(String fileName, String fileDescription, String filePath, String spritePath, String backPath) {
        PieceOfCode piece = (new PieceOfCode(fileName, fileDescription, filePath, spritePath, backPath));
        File file = new File("src/new.txt");
        try {
            FileOutputStream stream = new FileOutputStream(file, true);
            PrintWriter writer = new PrintWriter(stream, true);
            writer.println(fileName);
            writer.println(fileDescription);
            writer.println(filePath);
            writer.println(spritePath);
            writer.println(backPath);
            writer.flush();
        } catch (Exception e) {
            System.out.println("Exception cAuGhT + " + e);
        }
    }

    public static void addPiece(String fileName, String fileDescription, String filePath, String spritePath, String backPath, boolean b) {
        new PieceOfCode(fileName, fileDescription, filePath, spritePath, backPath);
    }

    public static void printPieces() {
        for (PieceOfCode p : pieceOfCodes)
            System.out.println(p);
    }

    public boolean isThisName(String word) {
        return fileName.equals(word);
    }

    public static String getPathByName(String name) {
        for (PieceOfCode piece : pieceOfCodes) {
            System.out.println(name + " & " + piece.fileName);
            if (piece.isThisName(name)) {
                System.out.println(piece.filePath);
                return piece.filePath;
            }
        }
        return "Does not eXIst";
    }

    public static String getSpritePath(String name) {
        for (PieceOfCode piece : pieceOfCodes) {
            System.out.println(name + " & " + piece.spritePath);
            if (piece.isThisName(name)) {
                System.out.println(piece.spritePath);
                return piece.spritePath;
            }
        }
        return "Does not eXIst";
    }

    public static String getBackPath(String name) {
        for (PieceOfCode piece : pieceOfCodes) {
            System.out.println(name + " & " + piece.backPath);
            if (piece.isThisName(name)) {
                System.out.println(piece.backPath);
                return piece.backPath;
            }
        }
        return "Does not eXIst";
    }

    static {
        System.out.println("Entered the static block");
        try {
            Scanner stream = new Scanner(new FileInputStream("src\\new.txt"));
            PieceOfCode code;
            String a, b, c, d, e;
            try {
                while (stream.hasNextLine()) {
                    a = stream.nextLine();
                    b = stream.nextLine();
                    c = stream.nextLine();
                    d = stream.nextLine();
                    e = stream.nextLine();
                    PieceOfCode.addPiece(a,b,c,d,e,true);
                }
            } catch (Exception ex) {
                System.out.println("Transfer might be over! " + ex);
                ex.printStackTrace();
            }

            for(PieceOfCode piece : pieceOfCodes){
                System.out.println(piece);
            }

        } catch (Exception e) {
            System.out.println("Exception caught in static block: " + e);
        }
    }

    @Override
    public String toString() {
        return "PieceOfCode{" +
                "fileName='" + fileName + '\'' +
                ", fileDescription='" + fileDescription + '\'' +
                ", filePath='" + filePath + '\'' +
                ", spritePath='" + spritePath + '\'' +
                ", backPath='" + backPath + '\'' +
                '}';
    }

    /*private void readObject(java.io.ObjectInputStream in)
            throws IOException, ClassNotFoundException {
        String a,b,c;
        Scanner scanner = new Scanner(in);
        a = scanner.nextLine();
        b = scanner.nextLine();
        c = scanner.nextLine();
        pieceOfCodes.add(new PieceOfCode(a,b,c));
    }

    private void writeObject(java.io.ObjectOutputStream out)
            throws IOException {
        PrintWriter writer = new PrintWriter(out, true);
        writer.println(fileName);
        writer.println(fileDescription);
        writer.println(filePath);
        writer.flush();
    }*/
    PieceOfCode(){}
}

