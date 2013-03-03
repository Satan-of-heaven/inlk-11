import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Teil here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Teil extends Actor
{
    private Teil folgender; 
   
    public void setFolgender(Teil v)
    {
        folgender = v;
    }
    public boolean hasFolgender()
    {
        return (folgender != null);
    }

    public void bewege(int x, int y)
    {
        if(folgender != null)
        {
            folgender.bewege(getX(), getY());
        }
        
        setLocation(x, y);
    }
    
    public void erstelle()
    {
        if(folgender == null)
        {
            getWorld().addObject(folgender = new Teil(), 0, 0);
        }else{
            folgender.erstelle();
        }
    }
    
    public void act() 
    {
    }    
}
