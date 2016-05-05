import javax.swing.*;
import java.awt.BorderLayout;

/**
 * Write a description of class GamerViewer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GamerViewer extends JFrame
{
    public GamerViewer()
    {
        setLayout(new BorderLayout());
        setSize(1000, 1000);
        setTitle("Ball Game");
        GamerPanel panel = new GamerPanel();
        add(panel, BorderLayout.CENTER);
    }
    public static void main (String [] args)
    {
        GamerViewer viewer = new GamerViewer();
        viewer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewer.setVisible(true);
    }

}
