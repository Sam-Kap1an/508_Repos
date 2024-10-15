import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;


public class MousePointer implements MouseMotionListener {

    private static int mouse_x = 0;
    private static int mouse_y = 0;


    @Override
    public void mouseDragged(MouseEvent e) {}

    @Override
    public void mouseMoved(MouseEvent e) {
        MousePointer.mouse_x = (e.getX());
        MousePointer.mouse_y = (e.getY());
    }


    public static int getMouseX(){
        return mouse_x;
    }

    public static int getMouseY(){
        return mouse_y;
    }
}
