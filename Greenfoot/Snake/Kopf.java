import greenfoot.*;
import java.util.*;

public class Kopf extends Actor
{
    private Richtung r;
    private Teil folgender;
    
    public Kopf()
    {
        r = Richtung.getEnum(Greenfoot.getRandomNumber(4));
    }
    
    public void act() 
    {
        
        
        if(getWorld().getObjects(Teil.class).size() == 1 && folgender == null)
        {
            
            folgender = ((Teil)getWorld().getObjects(Teil.class).get(0));
        }
        
        kollision();
        
        if(Greenfoot.isKeyDown("up") && r != Richtung.Unten){
            r = Richtung.Oben;
        }else if(Greenfoot.isKeyDown("down") && r != Richtung.Oben){
            r = Richtung.Unten;
        }else if(Greenfoot.isKeyDown("left") && r != Richtung.Rechts){
            r = Richtung.Links;
        }else if(Greenfoot.isKeyDown("right") && r != Richtung.Links){
            r = Richtung.Rechts;
        }
        
        teileBewegen();
        bewegen();
        
        
    }
    
    private void teileBewegen()
    {
        if(folgender != null)
        {
            folgender.bewege(getX(), getY());
        }
    }
    
    private void kollision()
    {
        Actor p = getOneIntersectingObject(Punkt.class);
        if(p != null)
        {
            if(folgender == null)
            {
                getWorld().addObject(folgender = new Teil(), 0,0);
            }else{
                folgender.erstelle();
            }
            getWorld().removeObject(p);
            ((Welt)getWorld()).addPunkt();
        }
        
        if(getOneIntersectingObject(Grenze.class) != null || getOneIntersectingObject(Teil.class) != null)
        {
            Greenfoot.stop();
        }
    }
    
    private void bewegen()
    {
        switch(r)
        {
            case Oben :
                setLocation(getX(), getY() - 1); 
                break;
            case Unten :
                setLocation(getX(), getY() + 1); 
                break;
            case Rechts :
                setLocation(getX() + 1, getY());
                break;
            case Links :
                setLocation(getX() -1, getY());
                break;
        }
    }
}
