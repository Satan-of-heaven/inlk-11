

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class StapelTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class StapelTest
{
    /**
     * Default constructor for test class StapelTest
     */
    public StapelTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testAddKarte()
    {
        Stapel s = new Stapel();
        Karte k = new Karte(4);
        
        s.addKarte(k);
        
        assertEquals(k, s.getErste());
    }

    @Test
    public void testGetErste()
    {
        Stapel s = new Stapel();
        Karte k = new Karte();
        s.addKarte(k);
        assertEquals(k, s.getErste());
    }

    @Test
    public void testRemoveKarte()
    {
        Stapel s = new Stapel();
        Karte k = new Karte();
        s.addKarte(k);
        s.removeKarte();
        
        assertEquals(0, s.zaehlen());
    }

    @Test
    public void testZaehlen()
    {
        Stapel s = new Stapel();
        s.addKarte(new Karte());
        s.addKarte(new Karte());
        assertEquals(2, s.zaehlen());
    }

    @Test
    public void testRemoveKarteLeer()
    {
        Stapel s = new Stapel();
        
        try
        {
            s.removeKarte();
            
            assertTrue(true);
        }catch(Exception e)
        {
            assertTrue(false);
        }
    }
}





