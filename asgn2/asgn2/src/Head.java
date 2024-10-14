import java.awt.*; 
public class Head implements Runnable {

    private int head_x;
    private int head_y;
    private int mouse_x;
    private int mouse_y;
    PointerInfo pi = MouseInfo.getPointerInfo(); 


    public Head() {
        this.head_x = 400;
        this.head_y = 300;
        this.mouse_x = 0;
        this.mouse_y = 0;
    }

    @Override
    public void run() {
        System.out.println("head is running!");
        while (true) { 

            Point p = pi.getLocation(); 
            this.mouse_x = (int) p.getX();
            this.mouse_y = (int) p.getY();
            System.out.println(this.mouse_x + ", " + this.mouse_y);
        }
    }

    


}