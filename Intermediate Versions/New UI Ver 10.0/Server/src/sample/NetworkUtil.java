package sample;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class NetworkUtil {
    private Socket socket;
    private BufferedReader bufferedReader;
    private PrintWriter printWriter;
    private Scanner scanner;
    private boolean isWritten = false;

    public NetworkUtil(String s, int port) {
        try {
            this.socket = new Socket(s, port);
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream());
            scanner = new Scanner(bufferedReader);
        } catch (Exception e) {
            System.out.println("In NetworkUtil : " + e.toString());
        }
    }

    public NetworkUtil(Socket s) {
        try {
            this.socket = s;
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(socket.getOutputStream());
            scanner = new Scanner(bufferedReader);
        } catch (Exception e) {
            System.out.println("In NetworkUtility : " + e.toString());
        }
    }

    public void read() {
        //Object o = null;
        //boolean isWritten = false;
        //System.out.println("It came\n");
        File file = new File("src\\res.txt");
        FileWriter fileWriter;
        try {
            fileWriter = new FileWriter(file);
        } catch (Exception e) {
            System.out.println("File could not be fetched " + e);
            return;
        }
        if (isWritten == false) {
            try {
                //o = ois.readUnshared(); // preferrable over readObject
                String p = "";
                while (scanner.hasNextLine()) {
                    p = scanner.nextLine();
                    System.out.println(p);
                    if (p.contains("WRITE")) {
                        this.write();
                        System.out.println("Went to write");
                        return;
                    }
                    fileWriter.write(p);
                    fileWriter.write('\n');
                    fileWriter.flush();
                }
            } catch (Exception e) {
                System.out.println("Reading Error in network : " + e.toString());
            }
        }
        isWritten = true;
        closeConnection();
        //return o;
    }

    public void write() {
        try {
            //oos.writeUnshared(o); // preferrable over writeObject
            System.out.println("It came to write");
            File file = new File("src\\res.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            Scanner scanner = new Scanner(bufferedReader);
            String a = new String();
            while (scanner.hasNextLine()) {
                a = scanner.nextLine();
                printWriter.println(a);
                printWriter.flush();
                System.out.println("WRITE " + a);
            }
            //file.delete();
        } catch (Exception e) {
            System.out.println("Writing  Error in network : " + e.toString());
        }
        closeConnection();
    }

    public void closeConnection() {
        try {
            bufferedReader.close();
            printWriter.close();
        } catch (Exception e) {
            System.out.println("Closing Error in network : " + e.toString());
        }
    }
}

