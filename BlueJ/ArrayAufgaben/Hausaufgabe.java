
/**
 * Write a description of class A here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hausaufgabe
{
    public static void a()
    {
        int werte[] = new int[100];

        //i
        for(int i = 0; i< 100; i++)
        {
            werte[i] = i * i;
        }
        
        
        //ii
        for(int i = 99; i >= 0; i--)
        {
            System.out.println(werte[i]);
        }
        
    }
    
    public static void bi()
    {
        int zahlen[] = Generator.getZufallszahlen();
        
        for(int i = 0; i < zahlen.length; i++)
        {
            System.out.println(zahlen[i]);
        }
    }
    
    public static void bii(Hund hunde[])
    {
        for(Hund h: hunde)
        {
            h.bellen();
        }
    }
}
