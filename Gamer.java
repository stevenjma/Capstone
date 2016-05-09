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
    Rectangle victorySquare;
    
    Color color;
    private int initialX;
    private int initialY;
    private int initialOtherX;
    private int initialOtherY;
    private int x;
    private int y;
    
    private Rectangle [][] blackSquares;

    /**
     * Default constructor for objects of class Gamer
     */
    public Gamer()
    {
        color = Color.RED;
        blackSquares = new Rectangle[10][10];
    }

    public void draw(Graphics2D g2)
    {
        g2.setColor(Color.BLACK);
        for (int i = 0; i < blackSquares.length; i++){
            for (int j = 0; j < blackSquares[0].length; j++){
                if (blackSquares[i][j] != null)
                {
                    g2.draw(blackSquares[i][j]);
                    g2.fill(blackSquares[i][j]);
                }
            }
        }
        g2.setColor(Color.GREEN);
        g2.draw(victorySquare);
        g2.fill(victorySquare);
        g2.setColor(color);
        g2.draw(circle);
        g2.fill(circle);
    }
    
    public void resetBall()
    {
        x = initialX;
        y = initialY;
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
            for (int i = 0; i < blackSquares.length; i++)
            {
                for (int j = 0; j < blackSquares[0].length; j++)
                {
                    blackSquares[i][j] = null;
                }
            }
            setEverything(level);
        }
    }
    
    public void setEverything(int level)
    {
        if (level == 1)
        {
            initialX = 310;
            initialY = 640;
            resetBall();
            initialOtherX = 690;
            initialOtherY = 310;
            for (int i = 0; i < blackSquares.length; i++)
            {
                for (int j = 0; j < blackSquares[0].length; j++)
                {
                    if (i < 3 || j < 3 || i > 6 || j > 6){
                        blackSquares[i][j] = new Rectangle((100 * i), (100 * j), 100, 100);
                    }
                }
            }
        }
        else if (level == 2)
        {
            initialX = 640;
            initialY = 640;
            resetBall();
            initialOtherX = 690;
            initialOtherY = 310;
            for (int i = 0; i < blackSquares.length; i++)
            {
                for (int j = 0; j < blackSquares[0].length; j++)
                {
                    if (i < 3 || j < 3 || i > 6 || j > 6){
                        blackSquares[i][j] = new Rectangle((100 * i), (100 * j), 100, 100);
                    }
                    if ((j == 5 || j == 4) && i > 3)
                    {   
                        blackSquares[i][j] = new Rectangle((100 * i), (100 * j), 100, 100);
                    }
                }
            }
        }
        else
        {
            initialX = 900;
            initialY = 900;
            resetBall();
            initialOtherX = 950;
            initialOtherY = 50;
            for (int i = 0; i < blackSquares.length; i++)
            {
                for (int j = 0; j < blackSquares[0].length; j++)
                {
                    if (i % 2 != 0 && j < 9)
                    {
                        blackSquares[i][j] = new Rectangle((100 * i), (100 * j), 100, 100);
                    }
                    else if (i%2 == 0 && j > 0)
                    {
                        blackSquares[i][j] = new Rectangle((100 * i), (100 * j), 100, 100);
                    }
                }
            }
        }
        victorySquare = new Rectangle(initialOtherX, initialOtherY, 5, 5);
    }
    
    public boolean checkCollision()
    {
        boolean collided = false;
        for (int i = 0; i < blackSquares.length; i++)
        {
            for (int j = 0; j < blackSquares[0].length; j++)
            {
                if (blackSquares[i][j] != null){
                    if (circle.intersects(blackSquares[i][j].getX(), blackSquares[i][j].getY(),blackSquares[i][j].getWidth(),blackSquares[i][j].getHeight())){
                        collided = true;
                    }
                }
            }
        } 
        return collided;
    }
    
    public boolean checkVictory()
    {
        if (circle.intersects(victorySquare))
        {
            return true;
        }
        return false;
    }
    
    public int getInitialX()
    {
        return initialX;
    }
    
    public int getInitialY()
    {
        return initialY;
    }
}
