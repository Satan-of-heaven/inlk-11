
/**
 * Ein ChatBot der in der Konsole chattet.
 * 
 * @author     Ich
 * @version    0.1a
 */
public class ChatBot
{
    private Eingabeleser eingabe;
    private Beantworter antworter;

    /**
     * Erzeuge einen neuen ChatBot.
     */
    public ChatBot()
    {
        eingabe = new Eingabeleser();
        antworter = new Beantworter("antworten.txt");
    }

    private void begruessung()
    {
        System.out.println("Hallo");
    }

    private void verabschiedung()
    {
        System.out.println("! Hallo");
    }

    /**
	* Startet den ChatBot
	*/
    public void start()
    {
        begruessung();

        while(true)
        {
            String in = eingabe.gibEingabe().toLowerCase();

            

            if(in.equals("ende") || in.equals("stop"))
            {
                verabschiedung();
                break;
            }else
            {
                System.out.println(antworter.gibAntwort(in));
            }
        }

    }
}
