import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.platform.commons.annotation.Testable;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Testable
public class AppTest {
        // Tester file
    @Test
    public void testConnectionMessage(){
        Server s = new Server();
        Client c = new Client("Tester");
        c.disconnect();
        s.run();
        s.disconnect();
        assertEquals("Tester has connected", s.getMessages().get(0));
    }

    @Test
    public void testDisconnectMessage(){
        Server s = new Server();
        Client c = new Client("Tester");
        c.disconnect();
        s.run();
        s.disconnect();
        List<String> messages =  s.getMessages();
        assertEquals("Tester has disconnected", messages.get(messages.size() - 1));
    }
    @Test
    public void testSendingACustomMessageFormat(){
        Server s = new Server();

        String clientName = "Tester";
        Client c = new Client(clientName);

        String message = "Hello World.";
        c.sendMessage(message);

        c.disconnect();
        s.run();
        s.disconnect();

        List<String> messages =  s.getMessages();

        assertEquals(String.format("%s >> %s", clientName, message), messages.get(1));
    }

}
