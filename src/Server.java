import java.net.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private ServerSocket sock;
    private List<String> messages;

    public Server() {
        try {
            this.sock = new ServerSocket(6013);
            this.messages = new ArrayList<>();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    public void run(){
        try {
            Socket client = sock.accept();
            BufferedReader in = new BufferedReader( new InputStreamReader(client.getInputStream()) );
            String line = "";
            while ( (line = in.readLine()) != null){
                // capture messages for testing
                messages.add(line);
                // output to shell
                System.out.println(line);
            }
            client.close();

        } catch (IOException e) {
            System.err.println(e);
        }
    }
    public List<String> getMessages(){
        return messages;
    }
    public void disconnect(){
        try {
            sock.close();
        } catch (IOException e) {
            System.err.print(e);
        }
    }
}