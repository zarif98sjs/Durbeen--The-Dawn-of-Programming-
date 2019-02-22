package sample;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private ServerSocket serverSocket;

    Server(int port)
    {
        try {
            serverSocket = new ServerSocket(port);
            while(true){
                Socket socket = serverSocket.accept();
                serveNew(socket);
            }
        } catch (Exception e){
            System.out.println("In server constructor: exception caught: " + e);
            e.printStackTrace();
        }
    }

    void serve(Socket socket){
        NetworkUtil nc = new NetworkUtil(socket);
        new Thread(() -> {
            while(true)
                nc.read();
        }).start();
        /*new Thread(() -> {
            while(true)
                nc.write();
        }).start();*/
    }

    void serveNew(Socket socket) throws Exception{
        KeepingRecord record = new KeepingRecord(socket);
        new Thread(()->{
            while(true)
                record.read();
        }).start();
    }

    public static void main(String[] args) throws Exception {
	    // write your code here
        PieceOfCode a = new PieceOfCode();// = new PieceOfCode("5","l","j", "s", null);

        Server server = new Server(6987);
    }
}
