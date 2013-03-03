import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Wait here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Wait extends Actor
{

    public void act() 
    {
        setLocation(getX(), getY() + 1);

        Actor a = getOneIntersectingObject(Spieler.class);
        if(a != null)
        {
            ((SpielWelt)getWorld()).removeLeben();
            getWorld().removeObject(this);
        }

        if(getWorld() != null)
        {
            if(getY() == getWorld().getHeight() - 1)
            {
                getWorld().removeObject(this);
            }
        }
    }    
}
