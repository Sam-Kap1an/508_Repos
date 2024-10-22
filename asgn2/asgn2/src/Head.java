import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Head implements PropertyChangeListener {

    private int head_x;
    private int head_y;
    private int mouse_x;
    private int mouse_y;
    private int eye_width;
    private int eye_size;
    private int eye_distance;
    private int width;
    private int height;
    private boolean moves;


    public Head() {
        this.width = 75;
        this.height = 100;
        this.head_x = 400;
        this.head_y = 300;
        this.mouse_x = 0;
        this.mouse_y = 0;
        this.eye_width = 5;
        this.eye_size = 5;
        this.eye_distance = 15;
    }




    public void drawHead(Graphics g, int x, int y) {
        if(moves) {
            this.mouse_x = x;
            this.mouse_y = y;
        }

        double h = Math.hypot(this.head_x-this.mouse_x, this.head_y-this.mouse_y);
        double xPos = this.head_x-this.mouse_x;
        double yPos = this.head_y-this.mouse_y;
        xPos /= h;
        yPos /= h;
        xPos *= this.eye_width;
        yPos *= this.eye_width;

        g.setColor(new Color(232, 220 ,202));
        g.fillOval(this.head_x-(this.width/2), this.head_y-(this.height/2), this.width, this.height);

        g.setColor(new Color(0, 255,255));
        g.fillOval( this.head_x - eye_distance -5,  this.head_y -15, this.eye_size +10, this.eye_size+10);
        g.fillOval( this.head_x + eye_distance -5,  this.head_y -15, this.eye_size+10, this.eye_size+10);

        g.setColor(Color.BLACK);
        g.fillOval(this.head_x-(int) xPos - eye_distance, this.head_y-(int) yPos-10, this.eye_size, this.eye_size);
        g.fillOval(this.head_x-(int) xPos + eye_distance, this.head_y-(int) yPos-10, this.eye_size, this.eye_size);

        g.setColor(new Color(105, 105, 105)); 
        g.fillOval(this.head_x - 30, this.head_y + 10, 60, 40); 


    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        moves = (boolean)evt.getNewValue();
        System.out.println(moves);

    }



}