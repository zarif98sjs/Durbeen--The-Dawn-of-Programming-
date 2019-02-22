package sample;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

public class KeepingRecord {

    private Socket socket;
    private BufferedReader bufferedReader;
    private PrintWriter printWriter;
    private Scanner scanner;
    private boolean isWritten = false;

    public KeepingRecord(Socket socket) throws Exception {
        this.socket = socket;
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        printWriter = new PrintWriter(socket.getOutputStream());
        scanner = new Scanner(bufferedReader);
        isWritten = false;
    }

    public void read() {
        try {
            while (scanner.hasNextLine() == false)
                ;
            String command = scanner.nextLine();
            String a, b, c, d, ex;
            if (command.equals("GET_THE_CODE"))
                write();
            else if (command.equals("LOAD_ALL"))
                loadAll();
            if (!command.equals("WRITE_IT"))
                return;
            a = scanner.nextLine();
            b = scanner.nextLine();
            c = scanner.nextLine();
            d = scanner.nextLine();
            ex = scanner.nextLine();

            PieceOfCode.addPiece(a, b, c, d, ex);

            PieceOfCode.printPieces();
        } catch (Exception e) {
            System.out.println("In Keeping record read: " + e);
            e.printStackTrace();
        }
    }

    private void write() {
        try {
            while (scanner.hasNextLine() == false)
                ;
            System.out.println("Entered write");
            String name = scanner.nextLine();
            System.out.println("Entered name: " + name);
            String path = PieceOfCode.getPathByName(name);
            String sp = PieceOfCode.getSpritePath(name);
            String back = PieceOfCode.getBackPath(name);
            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            writer.println(path);
            writer.println(sp);
            writer.println(back);
            System.out.println(path + " " + sp + " " + back);
            writer.flush();
        } catch (Exception e) {
            System.out.println("In Keeping record write: " + e);
            e.printStackTrace();
        }
    }

    private void loadAll() {
        try {
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            for (PieceOfCode c : PieceOfCode.pieceOfCodes) {
                writer.println(c.fileName);
                writer.println(c.fileDescription);
            }
            writer.println("TRANSMISSION_OVER");
        } catch (Exception e) {
            System.out.println("Exception in loadAll " + e);
        }

    }

}
