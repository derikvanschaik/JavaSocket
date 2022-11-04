import java.util.Scanner;
// this runs the client socket class with provided user input

public class ClientInput {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = in.nextLine();
        System.out.println();

        System.out.println(
                "Welcome to the chat application (with yourself).\n" +
                "Type a sentence and press enter to send, or type 'quit' + enter at anytime to close the application.");

        Client c = new Client(name);

        // input loop
        String input = "";
        while( !(input = in.nextLine()).equals("quit")){
            c.sendMessage(input);
        }
        // client has disconnected
        c.disconnect();
    }
}
