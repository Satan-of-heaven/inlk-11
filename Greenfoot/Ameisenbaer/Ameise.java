import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ameise here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ameise extends Actor
{
    /**
     * Act - do whatever the Ameise wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Ameisenbaer.getZaehler() > 3)
        {
            Greenfoot.playSound("scream.wav");
            setRotation(Greenfoot.getRandomNumber(5) * 90);
            move(1);
        }
    }    
}
