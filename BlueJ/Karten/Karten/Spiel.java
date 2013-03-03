import java.io.*;
import java.util.*;


public class Spiel
{

    public static void main(String[] args)
    {
        int anzKarten = 8;
        int anzSpieler = 1;
        SpielLogik logik;

        while(true)
        {
            System.out.println("\n------------------------------------");
            System.out.println("Starte Spiel Keep or Throw ...");
            System.out.println("------------------------------------\n");

            anzKarten = getValidIntInput("Anzahl der Karten :");
            anzSpieler = getValidIntInput("Anzahl der Spieler :");
            
            System.out.println("\n------------------------------------");

            logik = new SpielLogik(anzKarten);
            logik.start(anzSpieler);
        }        
    }

    private static int getValidIntInput(String s)
    {
        Boolean isInt = false;
        int returnInt = 0;
        
        while(!isInt)
        {
            System.out.println(s);
            String in = readln();

            try
            {
                returnInt = Integer.parseInt(in);
                isInt = true;
            }
            catch(NumberFormatException ex)
            {
                System.out.println("Keine gültige Zahl !");
            }
        }
        
        return returnInt;
    }

    private static String readln()
    {

        //http://www.abbeyworkshop.com/howto/java/readLine/

        String curLine = "";

        InputStreamReader converter = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(converter);

        try
        {
            curLine = in.readLine();
        }catch(IOException e)
        {
            System.out.println("FEHLER");
        }

        return curLine;
    }

}
