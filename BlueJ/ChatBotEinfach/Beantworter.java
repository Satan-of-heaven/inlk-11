import java.util.*;
import java.io.*;

/**
 * Ein Beantworter wertet Eingaben aus.
 * 
 * @author     Ich
 * @version    0.1a
 */
public class Beantworter
{
    public static HashMap<String, String[]> ant = new HashMap<String, String[]>();

    /**
     * Erzeugt einen Beantworter mit den Antworter aus einer Datei
     * @param datei Datei aus der die Antworten gelesen werden
     */
    public Beantworter(String datei)
    {
        dateiLaden(datei);
    }

    private void dateiLaden(String datei)
    {
        try{
            String ln;
            FileInputStream fs = new FileInputStream(datei);
            DataInputStream inp = new DataInputStream(fs);
            BufferedReader br = new BufferedReader(new InputStreamReader(inp));

            while ((ln = br.readLine()) != null)   {
                String[] kvp = ln.split("=>");
                
                String[] antMgl = kvp[1].split(";");
                
                ant.put(kvp[0].trim(), antMgl);
            }

            inp.close();
        }catch (Exception e){
            System.err.println("Fehler: " + e.getMessage());
        }
    }

    /**
     * Erzeugt eine Antwort
     * @param in Auszuwertender Text
     * @return  Eine Antwort auf die Eingabe
     */
    public String gibAntwort(String in)
    {
        String[] inListe = in.split(" ");
        Random rnd = new Random();

        for(String s : inListe)
        {
            if(ant.containsKey(s))
            {
                return ant.get(s)[rnd.nextInt(Arrays.asList(ant.get(s)).size())];
            }
        }

        return ("Was " + in + " !?");
    }
}
