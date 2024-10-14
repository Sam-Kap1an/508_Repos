
import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.awt.event.MouseEvent;
    import java.awt.event.MouseMotionListener;
import javax.swing.*;

    public class Drawing extends JPanel implements ActionListener,MouseMotionListener {
        private Head head;
        int mouse_x = 0;
        int mouse_y = 0;
        
        public Drawing() {
            addMouseMotionListener(this);
            setBackground(Color.GRAY);
            Timer timer = new Timer(1000/30, this);
            timer.start();
            this.head = new Head();
        }
        
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawHead(g, this.mouse_x, this.mouse_y);
            
        
        }

        // private void drawDir(Graphics g) {
        //     int x = App.getInstance().getDirX();
        //     int y = App.getInstance().getDirY();
        // //     if (x == 400)
        // //         g.setColor(new Color(172, 248, 199));
        // //     else if (App.getInstance().getWhoAmI() == App.SERVER && x <= 400 ||
        // //             App.getInstance().getWhoAmI() == PongBrain.CLIENT && x >= 400)
        // //         g.setColor(Color.DARK_GRAY);
        // //     else
        // //         g.setColor(Color.WHITE);
        //     g.fillRect (400, 400, 10, 10);
        // }
        private void drawHead(Graphics g, int x, int y) {
            this.head.drawHead(g, x, y);

    
        }
        
        
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(800, 600);
        }
        
        @Override
        public void mouseMoved(MouseEvent e) {
            // nhead = new Head();

            this.mouse_x = (e.getX());
            this.mouse_y = (e.getY());


            repaint();
        }
        
        @Override
        public void mouseDragged(MouseEvent e) {
        
        }
        
        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    }
