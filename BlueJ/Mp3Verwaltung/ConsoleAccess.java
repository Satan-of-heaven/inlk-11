import java.util.*;
import java.io.*;
import java.lang.reflect.*;

public class ConsoleAccess extends SongDataAccess
{
    private static Map<String, String> cmds;

    
    public static void main(String[] args)
    {
        initCommandDict();

        System.out.println("Mp3Verwaltung gestartet !\n");

        Method m;
        ConsoleAccess invo = new ConsoleAccess();
        
        while(true)
        {
            System.out.println("-------------------------------------------");
            System.out.println("Kommando :");
            String in = readln();

            System.out.println("-------------------------------------------");

            
            //Kommando[:Param1;Param2;ParamN]
            
            if(in.contains(":"))
            {
                String[] cmdparam = in.split(":");

                try
                {
                    //Invoke private method with String parameter
                    m = invo.getClass().getDeclaredMethod(cmds.get(cmdparam[0]), String.class);
                    m.setAccessible(true); //make private method accessible
                    m.invoke(invo, cmdparam[1]);
                }
                catch(Exception ex)
                {
                    System.out.println("Exception !\n" + ex.getMessage());
                }
            }
            else
            {
                try
                {
                    //Invoke private method
                    m = invo.getClass().getDeclaredMethod(cmds.get(in));
                    m.setAccessible(true); //make private method accessible
                    m.invoke(invo);
                }
                catch(Exception ex)
                {
                    System.out.println("Exception !\n" + ex.getMessage());
                }
            }
        }

    }

    private static void initCommandDict()
    {
        cmds = new HashMap<String, String>();

        cmds.put("?", "cmdHelp"); //Help
        cmds.put("ls", "cmdShowAll"); //ListSongs
        cmds.put("add", "cmdAddSong"); //Add
        cmds.put("rm", "cmdRemoveSong"); //Remove
        cmds.put("c", "cmdCountSongs"); //Count
        cmds.put("s", "cmdSearchSongs"); //Search
        cmds.put("save", "cmdSave"); //Serialize
        cmds.put("open", "cmdOpen"); //Deserialize
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

    private void printList(LinkedList<Song> l)
    {
        System.out.println("Songs :");

        if(l.size() == 0)
        {
            System.out.println("Keine Einträge !");
        }
        else
        {
            for(Song s: l)
            {
                String cd = "Keine Kopie";
                
                if(s.istKopieVonCD())
                    cd = "Kopie vorhanden";
                
                System.out.println(s.getName() + ", " + s.getInterpret() +", " + cd + " (" + String.valueOf(s.getDauer()) + " Sek.)");
            }
        }
    }

    private void cmdHelp()
    {
        System.out.println("Kommandos :");
        for(Map.Entry<String, String> e : cmds.entrySet()){
            System.out.println(e.getKey());
        }
    }

    private void cmdShowAll()
    {
        printList(getSongs());
    }

    private void cmdAddSong(String param)
    {
        Song s = null;
        try
        {
            String[] params = param.split(";");

            s = new Song(params[0], params[1], Boolean.valueOf(params[2]) ,Integer.parseInt(params[3]));
        }
        catch(Exception ex)
        {
            System.out.println("Falsche Parameter !");
            return;
        }
        
        try
        {
            addSong(s);
            
            
            System.out.println("Song hinzugefügt :");
            String cd = "Keine Kopie";  
                if(s.istKopieVonCD())
                    cd = "Kopie vorhanden";
            System.out.println(s.getName() + ", " + s.getInterpret() +", " + cd + " (" + String.valueOf(s.getDauer()) + " Sek.)");
        }
        catch(IllegalArgumentException ex)
        {
            System.out.println("Song bereits eingetragen !");
        }
    }
    
    private void cmdRemoveSong(String param)
    {
        try
        {
            int index = Integer.parseInt(param);
            //Int param
            try
            {
                removeSong(index);
                System.out.println("Song an Stelle " + String.valueOf(index) + " gelöscht !");
            }
            catch(IllegalArgumentException e)
            {
                System.out.println("Song existiert nicht !");
            }
        }
        catch(Exception ex)
        {
            //String param
            try
            {
                removeSong(param);
                System.out.println("Song \"" + param + "\" gelöscht !");
            }
            catch(IllegalArgumentException e)
            {
                System.out.println("Song existiert nicht !");
            }
        }
    }
    
    private void cmdCountSongs()
    {
        System.out.println(String.valueOf(countSongs()));
    }
    
    private void cmdSearchSongs(String param)
    {
        printList(searchSongs(param));
    }
    
    private void cmdSave(String param)
    {
        if(serialize(param))
        {
            System.out.println("Songs in Datei " + param + " gespeichert !");
        }
        else
        {
            System.out.println("Fehler beim Speichern !");
        }
    }
    
    private void cmdOpen(String param)
    {
        deserialize(param);
        System.out.println("Songs aus Datei " + param + " geöffnet !");
    }
}
