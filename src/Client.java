import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client {
    private Socket sock;
    private PrintWriter userMessageSender;
    private String name;

    public Client(String name) {
        try {
            this.sock = new Socket("127.0.0.1",6013);
            this.userMessageSender = new
                    PrintWriter(sock.getOutputStream(), true);
            this.name = name;
            // send a message to server that the client has connected
            this.userMessageSender.println(name + " has connected");

        } catch (IOException e) {
            System.err.println(e);
        }
    }
    public void sendMessage(String message){
        this.userMessageSender.println(name + " >> " + message);
    }
    public void disconnect(){
        this.userMessageSender.println(name + " has disconnected");
        try {
            this.sock.close();
        } catch (IOException e) {
            System.err.print(e);
        }
    }

}
