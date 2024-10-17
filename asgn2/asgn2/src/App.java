import java.io.IOException;
import javax.swing.JFrame;

public class App {
    public static void main(String[] args) throws IOException {
        Frame nFrame = new Frame();
		nFrame.setTitle("Head Movement Simulator");
		nFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		nFrame.setSize(800, 600);
		nFrame.setResizable(false);
		nFrame.setLocation(0, 0);
		nFrame.setVisible(true);


		MousePointer mousePointer = new MousePointer();
		nFrame.addMouseMotionListener(mousePointer);
        



		Server server = new Server();
        nFrame.addPCL(server);

		if (server.isReady()) {
			System.out.println("Server is ready");
			Thread serverThread = new Thread(server);
			serverThread.start();
		}


    }
}
