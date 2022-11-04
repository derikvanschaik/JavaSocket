// this server constantly waits for connections
public class ForeverServer {
    private Server s;

    public ForeverServer() {
        this.s = new Server();
    }
    public void run(){
        while(true){
            this.s.run();
        }
    }

    public static void main(String[] args) {
        ForeverServer s = new ForeverServer();
        s.run();
    }
}
