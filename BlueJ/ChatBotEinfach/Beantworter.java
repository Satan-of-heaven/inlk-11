import java.util.*;

public class Beantworter
{
    public static String gibAntwort(String in)
    {
        String[] antworten = new String[] {"Antwort1","Antwort2","Antwort3","Antwort4"};

        Random rnd = new Random();

        return antworten[rnd.nextInt(Arrays.asList(antworten).size())];
    }
}
