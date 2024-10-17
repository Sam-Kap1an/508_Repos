import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable, PropertyChangeListener {

    private static final int PORT = 8888;
    private boolean moves;

    private final ObjectOutputStream outputStream;
    private boolean isReady;


    public Server() throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        Socket clientSocket = serverSocket.accept();
        outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
        isReady = true;
    }

    @Override
    public void run() {
        System.out.println("Server is running");
        while (true) {
            try {
                Thread.sleep(1000 / 30);
                
                send();
            } catch (Exception e) {
                // throw new RuntimeException(e);
            }
        }
    }

    private void send() throws IOException {
        if (moves) {
            int mouse_x = MousePointer.getMouseX();
            int mouse_y = MousePointer.getMouseY();

            outputStream.writeObject(mouse_x);
            outputStream.writeObject(mouse_y);
            outputStream.flush();
        }
    }



    public boolean isReady() {
        return isReady;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        moves = (boolean)evt.getNewValue();
    }

}