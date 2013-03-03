import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
import java.util.List;

/**
 * Der Weltall, unendliche Weiten...
 * 
 * @author (Thomas Karp) 
 * @version (8.1.2012)
 */
public class PigWorld  extends World
{
    private Boolean paused;
    private int clicked;
    private int speed;
    /**
     * Erzeuge eine schweinische Welt.
     * 
     */
    public PigWorld()
    {    
        // Create a new world with 600x450 cells with a cell size of 1x1 pixels.
        super(600, 450, 1); 

        speed = 50;
        Greenfoot.setSpeed(speed);
        clicked = 0;
        paused= false;
        this.addObject(new Schwein(), 0, 0);

    }

    public void act()
    {
        //5x Welt klicken = verlieren
        if(clicked == 5)
        {
            Greenfoot.stop();
        }
        if(Greenfoot.mouseClicked(this))
        {
            for(int i = 0 ; i < this.numberOfObjects(); i++)
            {
                ((Schwein)this.getObjects(null).get(i)).setLocation(Greenfoot.getRandomNumber(this.getWidth()), Greenfoot.getRandomNumber(this.getHeight()));
            }

            speed += 3;
            clicked++;

            Greenfoot.setSpeed(speed);
        }

        //Schweine löschen wenn geklickt
        for(int i = 0 ; i < this.numberOfObjects(); i++)
        {
            if(((Schwein)this.getObjects(null).get(i)).getIsDeletable())
            {

                if(!((Schwein)this.getObjects(null).get(i)).getIsExploded())
                {
                    //Wenn nicht explodiert : 2 neue Schwein
                    this.addObject(new Schwein(), 0, 0);
                    this.addObject(new Schwein(), 0, 0);
                }
                
                this.removeObject((Actor)this.getObjects(null).get(i));

                
            }

        }


        if(Greenfoot.isKeyDown("p"))
        {
            if(!paused)
            {
                this.setBackground(new GreenfootImage(" PAUSE ", 210, Color.black, Color.white));
                //((Schwein)this.getObjects(null).get(0)).setCanAct(false);
                for(int i = 0 ; i < this.numberOfObjects(); i++)
                {
                    ((Schwein)this.getObjects(null).get(i)).setCanAct(false);
                }
                paused = true;
            }else if(paused)
            {
                this.setBackground("weltraum.jpg");
                //((Schwein)this.getObjects(null).get(0)).setCanAct(true);

                for(int i = 0 ; i < this.numberOfObjects(); i++)
                {
                    ((Schwein)this.getObjects(null).get(i)).setCanAct(true);
                    ((Schwein)this.getObjects(null).get(0)).setLocation(Greenfoot.getRandomNumber(this.getWidth()), Greenfoot.getRandomNumber(this.getHeight()));
                }
                paused = false;
            }
        }
    }
}
