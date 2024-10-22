
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

    public class Drawing extends JPanel implements ActionListener{
        //init head and local mouse storage
        public Head head;
        int mouse_x = 0;
        int mouse_y = 0;
        
        //init drawing
        public Drawing() {
            setBackground(Color.GRAY);
            Timer timer = new Timer(1000/30, this);
            timer.start();
            this.head = new Head();

        }
        
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawHead(g, this.mouse_x, this.mouse_y);
            this.mouse_x = MousePointer.getMouseX();
            this.mouse_y = MousePointer.getMouseY();
            repaint();
        }
        
        private void drawHead(Graphics g, int x, int y) {
            //call draw head in head class
            this.head.drawHead(g, x, y);
        }
        
        
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(800, 600);
        }

        
        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    }
