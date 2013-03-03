import java.io.*;
import java.util.*;

public class SpielLogik
{
    private Stapel keepStapel;
    private Stapel kartenStapel;

    private Karte tmpKarte;
    private int anzKarten;

    public SpielLogik()
    {
        this(32);
    }

    public SpielLogik(int anz)
    {
        anzKarten = anz;
    }

    public void start(int spieler)
    {
        List<Integer> spielerPkt = new ArrayList<Integer>();
                
        System.out.println("Starte Spiel für " + String.valueOf(spieler) + " Spieler...");
        System.out.println("------------------------------------");
        
        for(int i = 1; i < spieler +1; i++)
        {
            System.out.println("Spieler " + String.valueOf(i) + " : ");
            System.out.println("------------------------------------");           
            init();       
            spielerPkt.add(startSpiel());
        }
        
        System.out.println("\n------------------------------------");
        System.out.println("------------SPIEL VORBEI------------");
        System.out.println("------------------------------------\n");
        
        for(int i = 0; i < spieler; i++)
        {
            System.out.println("Spieler " + String.valueOf(i + 1) + " : " + String.valueOf(spielerPkt.get(i)));
        }
        
        System.out.println("Gewinner : Spieler " + String.valueOf(spielerPkt.indexOf(Collections.max(spielerPkt)) + 1));
    }
    
    private void init()
    {
        keepStapel = new Stapel();

        kartenStapel = new Stapel();

        List<Karte> l = new ArrayList<Karte>();

        int anzProKarte = anzKarten / 8;

        for(int i = 1; i < 9; i++)
        {
            for(int j = 0; j < anzProKarte; j++)
            {
                l.add(new Karte(i));
            }
        }

        int size = l.size();

        for(int i = 0; i < size; i++)
        {
            int rnd = new Random().nextInt(l.size());
            kartenStapel.addKarte((Karte)l.get(rnd));
            l.remove(rnd);
        }
    }
    
    private int startSpiel()
    {
        int maxKarten = kartenStapel.zaehlen();

        //System.out.println("Spiel gestartet !\n------------------------------------");

        while(kartenStapel.zaehlen() > 0)
        {
            tmpKarte = ziehen();

            System.out.println("Karte " + (maxKarten - kartenStapel.zaehlen()) + "/" + maxKarten + "( " + tmpKarte.getWert() + " ) : ");

            String letzterWert = "Keine";
            if(keepStapel.getErste() != null)
                letzterWert = String.valueOf(keepStapel.getErste().getWert());

            System.out.println("Behalten ( Letzte Karte : " + letzterWert + " ) ? [1|0] :");
            String input = readln();

            while(!(input.equals("1") || input.equals("0")))
            {
                System.out.println("Ungültige Eingabe ! 1 = Behalten; 0 = Ablegen");
                input = readln();
            }

            if(input.equals("1"))
            {
                if(keepStapel.getErste() == null || keepStapel.getErste().getWert() < tmpKarte.getWert())
                {
                    behalten();
                }else
                {
                    System.out.println("Karte ist kleiner als Letzte ! Wird weggeworfen.");
                    ablegen();
                }
            }
            else if(input.equals("0"))
            {
                ablegen();
            }
            else
            {
                System.out.println("Ungültige Eingabe");
            }

            System.out.println("------------------------------------");
        }

        return auswerten();
    }

    private int auswerten()
    {
        System.out.println("-------------AUSWERTUNG-------------");
        System.out.println("------------------------------------");

        System.out.println("Anzahl der Karten : " + keepStapel.zaehlen());
        System.out.println("Stapel :");

        Karte k = keepStapel.getErste();
        while(k != null)
        {
            System.out.println(k.getWert());
            k = k.getNaechste();
        }

        System.out.println("------------------------------------");
        
        return keepStapel.zaehlen();
    }

    private Karte ziehen()
    {
        Karte k =  kartenStapel.getErste();
        kartenStapel.removeKarte();

        return k;
    }

    private void behalten()
    {
        if(tmpKarte != null)
        {
            keepStapel.addKarte(tmpKarte);
            System.out.println("Karte wurde behalten.");
        }
    }

    private void ablegen()
    {
        tmpKarte = null;
        System.out.println("Karte wurde abgelegt.");
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
