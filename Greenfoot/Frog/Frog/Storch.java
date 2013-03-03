import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Storch extends Actor
{
    private double wahrsch;
    
    public Storch(double wahrscheinlichkeit)
    {
         wahrsch = wahrscheinlichkeit;
         getImage().drawString(String.valueOf(wahrsch * 100) + "%", 0, 15);
    }
    public Storch(){this(1.0);}
    
    
    public double getWahrscheinlichkeit()
    {
        return wahrsch;
    }
}
