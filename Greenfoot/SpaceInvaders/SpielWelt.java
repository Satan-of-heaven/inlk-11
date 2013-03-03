import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;

public class SpielWelt extends World
{
    private int pkt;
    private int leben;

    public SpielWelt()
    {    
        super(13, 15, 50);
        pkt = 0;
        leben = 3;
        draw();
        createActors();
    }

    public void removeLeben()
    {
        leben--;
        draw();
    }

    public void addPunkte(int value)
    {
        pkt += value;
        draw();
    }

    private void draw()
    {
        setBackground("space1.jpg");
        getBackground().setFont(new Font("Arial", Font.BOLD, 18 ));
        getBackground().setColor(Color.RED);
        getBackground().drawString(String.valueOf(pkt) + " Punkte", 20, 20);

        int pos = (getWidth() * 50) - 50;
        for(int i = leben; i > 0; i--)
        {
            getBackground().drawImage(new GreenfootImage("dotnet.png"), pos, 0);
            pos -= 50;
        }
    }

    private void createActors()
    {
        addObject(new Spieler(), ((int)getWidth() / 2), getHeight());

        for(int x = 3; x <= 9; x++)
        {
            for(int y = 1; y <= 3; y++)
            {
                addObject(new Gegner(), x, y);
            }
        }
    }

    public void verloren()
    {        
        removeObjects(getObjects(Actor.class));

        setBackground("space1.jpg");
        getBackground().setFont(new Font("Arial", Font.BOLD, 18 ));
        getBackground().setColor(Color.RED);
        getBackground().drawString("VERLOREN", 280, 375);
        getBackground().drawString(String.valueOf(pkt) + " Punkte !", 280, 395);

        Greenfoot.stop();
    }

    public void gewonnen()
    {
        pkt *= leben;

        removeObjects(getObjects(Actor.class));

        setBackground("space1.jpg");
        getBackground().setFont(new Font("Arial", Font.BOLD, 18 ));
        getBackground().setColor(Color.RED);
        getBackground().drawString("GEWONNEN", 280, 375);
        getBackground().drawString(String.valueOf(pkt) + " Punkte !", 280, 395);

        Greenfoot.stop();
    }

    private int dir = +1;
    public void act()
    {
        if(leben == 0)
        {
            verloren();
        }
        else if(getObjects(Gegner.class).size() == 0)
        {
            gewonnen();
        }

        for(int i = 0; i <= getObjects(Gegner.class).size() - 1; i++)
        {
            Actor a = (Actor)getObjects(Gegner.class).get(i);

            if(a.getX() == getWidth() -1)
            {
                dir = -1;
            }
            else if(a.getX() == 0)
            {
                dir = +1;
            }
        }

        for(int i = 0; i <= getObjects(Gegner.class).size() - 1; i++)
        {
            Actor a = (Actor)getObjects(Gegner.class).get(i);
            if(a.getX() == 0 || a.getX() == getWidth()-1)
            {
                for(int j = 0; j <= getObjects(Gegner.class).size() - 1; j++)
                {
                    Actor b = (Actor)getObjects(Gegner.class).get(j);
                    b.setLocation(b.getX(), b.getY() + 1);
                }
                break;
            }
        }

        for(int i = 0; i <= getObjects(Gegner.class).size() - 1; i++)
        {
            Actor a = (Actor)getObjects(Gegner.class).get(i);
            a.setLocation(a.getX() + dir, a.getY());
        }
    }
}
