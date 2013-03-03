import greenfoot.*;
import java.awt.Color;

public class Frog extends Actor
{
    private int leben;
    private int schritte;
    private int steuern;

    public Frog(int leben)
    {
        setSchritte(0);
        setLeben(leben);
        steuern = 0;
    }

    public Frog()
    {
        this(20);
    }

    public int getLeben()
    {
        return leben;
    }

    public int getSchritte()
    {
        return schritte;
    }

    public void setSchritte(int value)
    {
        schritte = value;
        drawInfo("frog.png");      
    }

    public void setLeben(int value)
    {
        leben = value;
        drawInfo("frog.png");
        if(leben <= 0)
        {
            Greenfoot.stop();
            drawInfo("skull.png");
        }
    }

    private void drawHealthBar()
    {
        //TODO: implement...
    }
    
    private void drawInfo(String img)
    {
        setImage(img);
        getImage().setColor(Color.RED);
        getImage().fillRect(0, 0, (getImage().getWidth() / 20) * leben , 5);
        
        
//         setImage(img);
//         getImage().drawString(String.valueOf(schritte), 0, 10);
//         getImage().drawString(String.valueOf(leben), getImage().getWidth() - 15, 10);
// 
        if(steuern > 0)
        {
            getImage().drawString(String.valueOf(steuern), 0, getImage().getHeight());
        }
    }

    public void act() 
    {

        if(steuern <= 0)
        {
            setSchritte(getSchritte() +1);
            setLeben(getLeben() - 1);
            move();
        }else{

            if(Greenfoot.isKeyDown("up"))
            {
                setSchritte(getSchritte() +1);
                setLeben(getLeben() - 1);
                drawInfo("rocket.png");
                setLocation(getX(), getY() - 1);
                steuern--;
            }else if(Greenfoot.isKeyDown("down")){               
                setSchritte(getSchritte() +1);
                setLeben(getLeben() - 1);
                drawInfo("rocket.png");
                setLocation(getX(), getY() + 1);
                steuern--;
            }else if(Greenfoot.isKeyDown("left")){
                setSchritte(getSchritte() +1);
                setLeben(getLeben() - 1);
                drawInfo("rocket.png");
                setLocation(getX() - 1, getY());
                steuern--;
            }else if(Greenfoot.isKeyDown("right")){
                setSchritte(getSchritte() +1);
                setLeben(getLeben() - 1);
                drawInfo("rocket.png");
                setLocation(getX() + 1, getY());
                steuern--;
            }

        }
        checkCollision();
    }

    private void checkCollision()
    {
        Actor act = getOneIntersectingObject(Fly.class);
        if(act != null)
        {
            setLeben(getLeben() + ((Fly)act).getBonus());
            getWorld().removeObject(act);
        }
        act = getOneIntersectingObject(Storch.class);
        if(act != null)
        {
            if(((Storch)act).getWahrscheinlichkeit() == 1.0)
            {
                setLeben(0);
            }else{
                if(Greenfoot.getRandomNumber(((int)((Storch)act).getWahrscheinlichkeit() * 10)) == 0)
                {
                    setLeben(0);
                }
            }
            getWorld().removeObject(act);
        }

        if(getOneIntersectingObject(Joker.class) != null)
        {
            steuern += 10;
            getWorld().removeObject(getOneIntersectingObject(Joker.class));
        }
    }
    // 
    //     private void stop()
    //     {
    // //         drawInfo("skull.png");
    //         Greenfoot.stop();
    //     }

    private void move()
    {
        setLocation((getX() + Greenfoot.getRandomNumber(3) - 1), (getY() + (Greenfoot.getRandomNumber(3) - 1)));
    }
}
