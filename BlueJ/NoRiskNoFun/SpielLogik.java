import java.util.*;
import java.io.*;

public class SpielLogik
{
    private boolean werte[];

    private boolean statistikModus;
    private LinkedList<Integer> v;

    public SpielLogik()
    {
        werte = new boolean[6];
        v = new LinkedList<Integer>();
    }

    private int wuerfeln()
    {
        return (new Random().nextInt(5) + 1);
    }

    public void startStatistik()
    {
        v.clear();
        
        System.out.println("Statistik gestartet.");
        System.out.println("Anzahl der Spiele :");

        int durchlaeufe = Integer.parseInt(readln());

        for(int i = 0; i < durchlaeufe; i++)
        {
            System.out.println("Durchlauf " + String.valueOf(i+1));
            
            
            werte = new boolean[6];
            boolean beendet = false;
            int anz = 0;

            while(!beendet)
            {
                anz++;
                int rnd = wuerfeln();

                if(!werte[rnd - 1])
                {
                    werte[rnd - 1] = true;
                }
                else
                {
                    beendet = true;
                }
            }
            
            v.add(anz);
        }
        
        
        System.out.println("-----");
        
        int z = 0;
        
        for(Integer i: v)
        {
            z += i;
            System.out.println(String.valueOf(i));
        }
        
        System.out.println("-----");
        System.out.println("Durchschnitt : " + String.valueOf(z / (durchlaeufe * 1.0)));
    }

    public void start()
    {
        System.out.println("Spiel gestartet.");

        boolean beendet = false;
        boolean verloren = false;

        while(!beendet)
        {
            int rnd = wuerfeln();
            System.out.println("Gewürfelt : " + rnd);

            if(!werte[rnd - 1])
            {
                System.out.println("Zahl nicht doppelt !");
                werte[rnd - 1] = true;
                printWerte();

                beendet = !getWeiterMachen();
            }
            else
            {
                System.out.println("Zahl doppelt !");
                printWerte();
                beendet = true;
                verloren = true;
            }
        }

        if(verloren)
        {
            System.out.println("Verloren !");
        }
        else
        {
            System.out.println("Gewonnen");
        }

    }

    private boolean getWeiterMachen()
    {
        System.out.println("Weiter machen ? [0|1]");

        String in = readln();

        while(!(in.equals("1") || in.equals("0")))
        {
            System.out.println("Falsche Eingabe !");
            in = readln();
        }

        return (in.equals("1"));
    }

    private void printWerte()
    {
        for(int i = 0; i < werte.length; i++)
        {
            System.out.println("Feld " + String.valueOf(i+1) + " : " + String.valueOf(werte[i]));
        }
    }

    private String readln()
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
