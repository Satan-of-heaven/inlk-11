import java.util.*;
import java.io.*;

public class SpielLogik
{
    private LinkedList<Karte> satz;
    private Karte aktuelleKarte;
    private int gezogeneKarten;
    private int geloeschteKarten;

    public SpielLogik()
    {
        satz = new LinkedList<Karte>();
    }

    /* public void testSatzfuellen()
    {
        for(int i = 0; i < 9; i++)
        {
            satz.add(new Karte());
        }
    } */

    /* public void zeigeAktuelleKarte()
    {
        if(aktuelleKarte != null)
            System.out.println(" Akt. Karte : " + aktuelleKarte.getWort()+ " (" + aktuelleKarte.getWert() + ")");
    } */

    private void karteZiehen()
    {
        if(gezogeneKarten <= 10)
        {
            aktuelleKarte = new Karte();
            gezogeneKarten++;
        }
    }

    private void karteAnlegen(int index)
    {
        satz.add(index, aktuelleKarte);
    }

    private void loescheKarte(int index)
    {
        if(satz.size() >= 1 && index >= 0 && index < satz.size() && geloeschteKarten <= 3)
        {
            satz.remove(index);
            geloeschteKarten++;
        }
    }

    private void infoAusgeben()
    {
        int pkt = 0;
        
        for(Karte k: satz)
        {
            System.out.println(k.getWort()+ " (" + k.getWert() + ")");
            pkt += k.getWert();
        }

        //System.out.println("Gez. Karten : " + String.valueOf(gezogeneKarten));
        //System.out.println("Gel. Karten : " + String.valueOf(geloeschteKarten));
        System.out.println("Punkte : " + String.valueOf(pkt));
        
    }

    private void satzAusgeben()
    {
        for(Karte k: satz)
        {
            System.out.println(k.getWort());
        }
    }

    public void start(int spieler)
    {
        LinkedList<Integer> pkt = new LinkedList<Integer>();
        LinkedList<LinkedList<Karte>> saetze = new LinkedList<LinkedList<Karte>>();
        
        System.out.println("Starte Spiel für " + String.valueOf(spieler));
        
        for(int i = 1; i < spieler +1; i++)
        {
            System.out.println("Spieler " + String.valueOf(i) + " :");
            
            start();
            
            pkt.add(getPunkte());
            saetze.add(satz);
            
            satz = new LinkedList<Karte>();
            geloeschteKarten = 0;
            gezogeneKarten = 0;
        }
        
        System.out.println("Auswertung :");
        
        for(int i = 0; i < spieler; i++)
        {
            System.out.println("Spieler " + String.valueOf(i + 1));
            System.out.println("Punkte :" + String.valueOf(pkt.get(i)));
            System.out.println("Satz :");
            
            for(Karte k: saetze.get(i))
            {
                System.out.println(k.getWort() + " (" + k.getWert() + ")");
            }
            
        }
    }
    
    private int getPunkte()
    {
        int pkt = 0;
        
        for(Karte k: satz)
        {
            pkt += k.getWert();
        }
        
        return pkt;
    }
    
    public void start()
    {

        System.out.println("Wörter anlegen");
        for(int i = 1; i < 11; i++) //10 Wörter ziehen
        {
            System.out.println("Satz :");

            if(satz.size() == 0)
            {
                System.out.println("Leer");
            }
            else
            {
                satzAusgeben();
            }

            karteZiehen();
            System.out.println("Wort " + i + "/10" + " : " + aktuelleKarte.getWort() + " (" + aktuelleKarte.getWert() + ")");

            if(satz.size() == 0)
            {
                karteAnlegen(0);    
                continue;
            }
            System.out.println("Position zum anlegen :");
            int in = Integer.parseInt(readln());

            while(!(in < satz.size() && in >= 0))
            {
                System.out.println("Position zum anlegen :");
                in = Integer.parseInt(readln());
            }

            karteAnlegen(in);
        }

        System.out.println("Wörter löschen");// 3 Wörter löschen

        System.out.println("Satz :");
        satzAusgeben();

        for(int i = 1; i < 4; i++)
        {
            System.out.println(i + ". Wort löschen an Position :");
            int pos = Integer.parseInt(readln());

            while(!(pos < satz.size() && pos >= 0))
            {
                System.out.println("Wort löschen an Position :");
                pos = Integer.parseInt(readln());
            }

            loescheKarte(pos);
        }

        System.out.println("Auswertung :");
        infoAusgeben();
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
