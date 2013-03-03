import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gegner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gegner extends Actor
{
    private int pkt;

    public Gegner()
    {
        setImage(Greenfoot.getRandomNumber(3) + ".png");
        pkt  = Greenfoot.getRandomNumber(1000);
    }
    
    public int getPunkte()
    {
        return pkt;
    }
    
    public void act() 
    {
        if(Greenfoot.getRandomNumber(51) == 0)
        {
            getWorld().addObject(new Wait(), getX(), getY() + 1);
        }
        
        
        Actor a = getOneIntersectingObject(Spieler.class);
        if(a != null)
        {
             ((SpielWelt)getWorld()).verloren();
        }
        
         if(getY() == getWorld().getHeight() - 1)
        {
            getWorld().removeObject(this);
        }
    }    
}
