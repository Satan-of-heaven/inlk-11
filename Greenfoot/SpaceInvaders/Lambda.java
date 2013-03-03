import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Lambda here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lambda extends Actor
{
    public void act() 
    { 
           setLocation(getX(), getY() - 1);
           
           if(getY() == 0)
            {
                getWorld().removeObject(this);
            }
            
           if(getWorld() != null)
           {
            Actor a = getOneIntersectingObject(Gegner.class);
           if(a != null)
           {
               ((SpielWelt)getWorld()).addPunkte(((Gegner)a).getPunkte());
               getWorld().removeObject(a);
               getWorld().removeObject(this);
            }
        }
    }    
}
