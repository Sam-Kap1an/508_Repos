import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ClientApp {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 8888;

    public static void main(String[] args) {
        //test socket connection
        try (Socket socket = new Socket(SERVER_IP, SERVER_PORT);
             ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream())) {

            System.out.println("Connected to the server");

            // Continuously read mouse position from server
            while (true) {
                int mouse_x = (int) inputStream.readObject();
                int mouse_y = (int) inputStream.readObject();

                System.out.println("Mouse x: " + mouse_x + ", Mouse y: " + mouse_y);
            }

        //catch error if connection failed
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}