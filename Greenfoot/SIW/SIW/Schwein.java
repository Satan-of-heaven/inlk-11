import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;

/**
 * Write a description of class Schwein here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Schwein extends Lebewesen
{
    private int step;
    private int speed;
    private Boolean canAct;
    private Boolean isDeletable;
    private Boolean isExploded;
    /**
     * Act - do whatever the Schwein wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public Schwein()
    {
        step = 0;
        speed = 50;
        canAct=true;
        isDeletable = false;
        isExploded = false;
    }
    
    public Boolean getIsExploded()
    {
        return isExploded;
    }

    public Boolean getIsDeletable()
    {
        return isDeletable;
    }

    public void setCanAct(Boolean value)
    {
        canAct = value;
    }

    public void act() 
    {
        if(canAct){
            if(step == 1000)
            {
                explode();
            }

            /*--------------------*/
//             if(Greenfoot.mouseClicked(getWorld()))
//             {
//                 setLocation(Greenfoot.getRandomNumber(getWorld().getWidth()), Greenfoot.getRandomNumber(getWorld().getHeight()));
//                 speed += 4;
//                 Greenfoot.setSpeed(speed);
//                 wclicked++;
//             }
            /*--------------------*/

            if(Greenfoot.mouseClicked(this))
            {
                //Greenfoot.stop();

                if(step < 200)
                {
                    explode();
                }else if(step > 200 && step < 400)
                {
                    setImage("traurig.png");
                    setRotation(0);
                    isDeletable = true;
                }else if(step > 400 && step < 700)
                {
                    setImage("ok.png");
                    setRotation(0);
                    isDeletable = true;
                }else
                {
                    setImage("happy.png");
                    setRotation(0);
                    isDeletable = true;
                }
            }

            if(atWorldEdge())
            {
                setLocation(Greenfoot.getRandomNumber(getWorld().getWidth()), Greenfoot.getRandomNumber(getWorld().getHeight()));
            }

            int rnd = Greenfoot.getRandomNumber(20);

            switch(rnd)
            {
                case 0:
                turn(- Greenfoot.getRandomNumber(30));
                break;
                case 1:
                turn(Greenfoot.getRandomNumber(30));
                break;
            }

            move();
            step++;
        }
    }

    private void explode()
    {
        setImage("boom.png");
        //Greenfoot.stop();
        setRotation(0);
        isExploded = true;
        isDeletable = true;
    }
}
