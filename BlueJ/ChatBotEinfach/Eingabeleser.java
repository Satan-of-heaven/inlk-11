import java.util.Scanner;

/**
 * Ein Eingabeleser liest eingetippten Text von der Konsole.
 * 
 * @author     Michael Klling und David J. Barnes, modified by Thomas Karp
 * @version    0.2
 */
public class Eingabeleser
{
    private Scanner scanner;
	private String prompt;

    /**
     * Erzeuge einen neuen Eingabeleser, der Text von der Konsole
     * einliest.
     */
    public Eingabeleser()
    {
		this("> ");
    }
	
	/**
	* Erzeugt einen Eingabeleser mit Prompt
	* @param prompt Prompt, der vor jeder Benutzereingabe angezeigt wird.
	*/
	public Eingabeleser(String prompt)
	{
		scanner = new Scanner(System.in);
		this.prompt = prompt;
	}

    /**
     * Lies eine Zeile von der Konsole und liefere sie als String.
     *
     * @return  Eine Zeichenkette, die vom Benutzer eingetippt wurde.
     */
    public String gibEingabe() 
    {
        System.out.print(prompt);   // Eingabebereitschaft anzeigen
        String eingabezeile = scanner.nextLine();

        return eingabezeile;
    }

}
