import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Welt here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Welt extends World
{

    /**
     * Constructor for objects of class Welt.
     * 
     */
    public Welt()
    {    
        super(21, 21, 30);
        addObject(new Kopf(), 10, 10);
        addPunkt();
        
        for(int i = 0; i < getWidth(); i++)
        {
            addObject(new Grenze(), i, 0);
            addObject(new Grenze(), i, getHeight() -1);
        }
        for(int i = 1; i < getHeight() -1; i++)
        {
            addObject(new Grenze(), 0, i);
            addObject(new Grenze(), getWidth() -1, i);
        }
    }
    
    public void addPunkt()
    {
        if(getObjects(Punkt.class).size() == 0)
        {
            int x, y;
            
            int rnd = Greenfoot.getRandomNumber(getWidth() - 1);
            if(rnd == 0)
            {
                x= 1;
            }else{
                x = rnd;
            }
            rnd = Greenfoot.getRandomNumber(getHeight() - 1);
            if(rnd == 0)
            {
                y= 1;
            }else{
                y = rnd;
            }
            
            addObject(new Punkt(), x, y);
        }
    }
}
