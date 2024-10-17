import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.swing.*;

public class Frame extends JFrame implements ActionListener{


    static JMenuBar menub;
    static JMenu menu;
    static JMenuItem mstart, mstop;
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);



    public Frame() {

        menub = new JMenuBar();
        menu = new JMenu("Menu");

        mstart = new JMenuItem("Start");      
        mstop = new JMenuItem("Stop");
        mstart.addActionListener(this);
        mstop.addActionListener(this);

        menu.add(mstart);
        menu.add(mstop);

        menub.add(menu);

        this.setJMenuBar(menub);

        setLayout(new GridLayout(1, 1));
		Drawing d = new Drawing();
		add(d);
        pcs.addPropertyChangeListener(d.head);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String  cmd = e.getActionCommand();
        if(cmd.equals("Start")){
            pcs.firePropertyChange("moves", false, true);
            System.out.println("ping");
        }else{
            pcs.firePropertyChange("moves", true, false);
        }
    }

    public void addPCL(PropertyChangeListener pcl) {
        pcs.addPropertyChangeListener(pcl);
    }
}
