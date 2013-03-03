import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Fly extends Actor
{
    private int bonus;

    public Fly(int bonus)
    {
        this.bonus = bonus;
        getImage().drawString(String.valueOf(bonus), 0, 10);
    }
    public Fly()
    {
        this(5);
    }
    
    public int getBonus()
    {
        return bonus;
    }
}
