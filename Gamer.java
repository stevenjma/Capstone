import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;

/**
 * Write a description of class Gamer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gamer
{
    /** description of instance variable x (add comment for each instance variable) */
    Ellipse2D.Double circle;
    Point2D.Double start;
    Point2D.Double end;
    
    Color color;
    private int x;
    private int y;
    
    private boolean [][] blackSquares;

    /**
     * Default constructor for objects of class Gamer
     */
    public Gamer(int ballX, int ballY)
    {
        setBall(ballX,ballY);
        color = Color.RED;
        blackSquares = new boolean[5][5];
    }

    public void draw(Graphics2D g2)
    {
        g2.setColor(color);
        g2.draw(circle);
        g2.fill(circle);
        g2.setColor(Color.BLACK);
        for (int i = 0; i < blackSquares.length; i++){
            for (int j = 0; j < blackSquares[0].length; j++){
                if (blackSquares[i][j])
                {
                    Rectangle r = new Rectangle(180, 180, (180 * i), (180 * j));
                    g2.draw(r);
                }
            }
        }
    }
    
    public void setBall(int X, int Y)
    {
        x = X;
        y = Y;
        circle = new Ellipse2D.Double(x, y, 50, 50);
    }
    
    public void moveBall(int xChange, int yChange)
    {
        x += xChange;
        y += yChange;
        circle = new Ellipse2D.Double(x, y, 50, 50);
    }

    public void setSquares(int level)
    {
        if (level > 3) {
            System.out.println("Good job, you beat the game!");
        }
        else
        {
            setEverything(level);
        }
    }
    
    public void setEverything(int level)
    {
        if (level == 1)
        {
            for (int i = 0; i < blackSquares.length; i++)
            {
                for (int j = 0; j < blackSquares[0].length; j++)
                {
                    if (i == 0 && j == 0){
                        blackSquares[i][j] = true;
                    }
                    else{blackSquares[i][j] = false;
                    }
                }
            }
        }
        else if (level == 2)
        {
        }
        else
        {
        }
    }
}
