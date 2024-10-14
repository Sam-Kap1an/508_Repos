
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;
    import java.awt.event.MouseEvent;
    import java.awt.event.MouseMotionListener;
    import javax.swing.*;

    public class Drawing extends JPanel implements ActionListener,MouseMotionListener {
        
        public Drawing() {
            addMouseMotionListener(this);
            setBackground(Color.GRAY));
            Timer timer = new Timer(1000/30, this);
            timer.start();
        }
        
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawHead(g);
        
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
        private void drawHead(Graphics g) {

            g.setColor(new Color(232, 220 ,202));
            g.fillOval(350, 250, 100, 100);
        }
        
        
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(800, 600);
        }
        
        @Override
        public void mouseMoved(MouseEvent e) {
            // nhead = new Head();

            System.out.println(e.getX());
            System.out.println(e.getY());
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
