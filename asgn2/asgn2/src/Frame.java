import java.awt.GridLayout;
import javax.swing.JFrame;

public class Frame extends JFrame{
    public Frame() {
        setLayout(new GridLayout(1, 1));
		Drawing d = new Drawing();
		add(d);
    }
}
