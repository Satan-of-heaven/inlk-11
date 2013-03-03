import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Spieler extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("left")){
            setLocation(getX() - 1, getWorld().getHeight());
        }else if(Greenfoot.isKeyDown("right"))
        {
            setLocation(getX() + 1, getWorld().getHeight());
        }else if(Greenfoot.isKeyDown("space")){
            shoot();
        }
    }
    
    private void shoot()
    {
        getWorld().addObject(new Lambda(), getX(), getWorld().getHeight() - 1);
    }
}
