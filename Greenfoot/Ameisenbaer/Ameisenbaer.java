import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Ameisenbaer extends Actor
{
    private static int zaehler = 0;
    
    public Ameisenbaer()
    {
        Ameisenbaer.zaehler++;
    }
    
    public static int getZaehler()
    {
        return Ameisenbaer.zaehler;
    }
    
    public void act() 
    {
        checkKollision();
        bewegen();
    }

    private void bewegen()
    {
        setRotation(Greenfoot.getRandomNumber(5) * 90);
        move(1);
    }

    private void checkKollision()
    {
        if(getOneIntersectingObject(Ameisenbaer.class) != null && Greenfoot.getRandomNumber(1 + Ameisenbaer.zaehler) == 0)
        {
            getWorld().addObject(new Ameisenbaer(), getX(), getY());
        }
    }
}
