import greenfoot.*;  // imports Actor, World, Greenfoot, GreenfootImage

import java.util.List;
import java.util.ArrayList;


/**
 * 
 * @author Michael Kolling, changed by Thomas Karp
 * @version 1.0.2
 */
public class Wombat extends Actor
{
    private static final int NORTH = 0;
    private static final int EAST = 1;
    private static final int SOUTH = 2;    
    private static final int WEST = 3;

    private int direction; // direction, the wombat looks to
    private int leavesEaten; // number of leaves already eaten
    private int straightSteps; // number of straight steps gone
    
    private GreenfootImage wombatRight;
    private GreenfootImage wombatLeft;
    
    /**
     * Create a simple Wombat that looks in eastern direction with no leaves eaten
     */
    public Wombat()
    {
        wombatRight  = getImage();
        wombatLeft = new GreenfootImage(getImage());
        wombatLeft.mirrorHorizontally();
        
        setDirection(EAST);
        leavesEaten = 0;
        straightSteps = 0;
    }

    /**
     * Check whether there is a leaf in the same cell as we are.
     */
    public boolean foundLeaf()
    {
        Actor leaf = getOneObjectAtOffset(0, 0, Leaf.class);
        if(leaf != null) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * Eat a leaf.
     */
    public void eatLeaf()
    {
        Actor leaf = getOneObjectAtOffset(0, 0, Leaf.class);
        if(leaf != null) {
            // eat the leaf...
            getWorld().removeObject(leaf);
            leavesEaten = leavesEaten + 1; 
        }
    }
    
    /**
     * Move one cell forward in the current direction, if possible. If not do nothing
     */
    public void move()
    {
        if (!canMove()) {
            return;
        }
        switch(direction) {
            case SOUTH :
                setLocation(getX(), getY() + 1);
                break;
            case EAST :
                setLocation(getX() + 1, getY());
                break;
            case NORTH :
                setLocation(getX(), getY() - 1);
                break;
            case WEST :
                setLocation(getX() - 1, getY());
                break;
        }
    }

    /**
     * Test if we can move forward. Return true if we can, false otherwise.
     */
    public boolean canMove()
    {
        World myWorld = getWorld();
        int x = getX();
        int y = getY();
        switch(direction) {
            case SOUTH :
                y++;
                break;
            case EAST :
                x++;
                break;
            case NORTH :
                y--;
                break;
            case WEST :
                x--;
                break;
        }
        // test for outside border
        if (x >= myWorld.getWidth() || y >= myWorld.getHeight()) {
            return false;
        }
        else if (x < 0 || y < 0) {
            return false;
        }
        // test for rocks
        List rocks = myWorld.getObjectsAt(x, y, Rock.class);
        if(rocks.isEmpty()) {
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Turns towards the left.
     */
    public void turnLeft()
    {
        switch(direction) {
            case SOUTH :
                setDirection(EAST);
                break;
            case EAST :
                setDirection(NORTH);
                break;
            case NORTH :
                setDirection(WEST);
                break;
            case WEST :
                setDirection(SOUTH);
                break;
        }
    }

    /**
     * Turns towards the right.
     */
    public void turnRight()
    {
        switch(direction) {
            case SOUTH :
                setDirection(WEST);
                break;
            case EAST :
                setDirection(SOUTH);
                break;
            case NORTH :
                setDirection(EAST);
                break;
            case WEST :
                setDirection(NORTH);
                break;
        }
    }
    
    /**
     * Sets the direction we're facing.
     */
    public void setDirection(int direction)
    {
        this.direction = direction;
        switch(direction) {
            case SOUTH :
                setImage(wombatRight);
                setRotation(90);
                break;
            case EAST :
                setImage(wombatRight);
                setRotation(0);
                break;
            case NORTH :
                setImage(wombatLeft);
                setRotation(90);
                break;
            case WEST :
                setImage(wombatLeft);
                setRotation(0);
                break;
            default :
                break;
        }
    }

    /**
     * Tell how many leaves we have eaten.
     */
    public int getLeavesEaten()
    {
        return leavesEaten;
    }
    
    /** 
     * Do, what a wombat does
     */
    public void act()
    {
        if ((straightSteps >= 2) || !canMove())
        {
            setDirection(Greenfoot.getRandomNumber(4));
            straightSteps = 0;
        }
        else
        {
            move();
            straightSteps++;
        }
        while(foundLeaf())
        {
            eatLeaf();
        }
    }
}