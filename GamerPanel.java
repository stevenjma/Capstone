import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GamerPanel extends JPanel
{  
    private Gamer game;
    private boolean levelBeaten;
    private int level;
    
    public GamerPanel()
    {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(900, 900));
        
        game = new Gamer(310, 640);
        levelBeaten = false;
        level = 1;
        game.setSquares(level);
        
        setFocusable(true);
        addKeyListener(new KeyStrokeListener());
    }
    
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g2);
        game.draw(g2);
    }
    
    public void moveBall(int x, int y)
    {
        game.moveBall(x, y);
        repaint();
    }
    
    
    class KeyStrokeListener implements KeyListener
    {
        public void keyPressed(KeyEvent event) 
        {
            String key = KeyStroke.getKeyStrokeForEvent(event).toString().replace("pressed ", ""); 
            if (key.equals("DOWN"))
            {
                moveBall(0, 2);            
            }
            else if (key.equals("UP"))
            {
                moveBall(0, -2);            
            }
            else if (key.equals("LEFT"))
            {
                moveBall(-2, 0);            
            }
            else if (key.equals("RIGHT"))
            {
                moveBall(2, 0);            
            }
            else if (key.equals("ENTER"))
            {
                if (levelBeaten)
                {
                    game.setSquares(level);
                    level++;
                    levelBeaten = false;
                }
            }
            repaint();
        }

        public void keyTyped(KeyEvent event) {}

        public void keyReleased(KeyEvent event) {}
    }
}