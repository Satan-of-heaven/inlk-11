

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class WarteschlangeTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class WarteschlangeTest
{
    private Warteschlange w;

    /**
     * Default constructor for test class WarteschlangeTest
     */
    public WarteschlangeTest()
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
        w = new Warteschlange();
        w.erstellen("Aufgabe 1");
        w.erstellen("Aufgabe 2");
        w.erstellen("Aufgabe 3");
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
    public void ErstellenTest()
    {
        int vor = w.getAufgabenZahl();
        w.erstellen("Aufgabe 4");
        assertEquals(w.getAufgabenZahl(), ++vor);
    }

    @Test
    public void LoeschenTest()
    {
        int vor = w.getAufgabenZahl();
        w.loesche();
        assertEquals(w.getAufgabenZahl(), vor--);
    }

    @Test
    public void AuflistungTest()
    {
        System.out.println("Erste Aufgabe :\n");
        w.printErste();
        System.out.println("\nAlle Aufgaben :\n");
        w.printListe();
    }
}




