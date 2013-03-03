import java.util.*;
import java.text.Collator;

public class Sortierer
{
    private LinkedList<String> namenString;
    private LinkedList<Schueler> schueler;

    public Sortierer()
    {
        namenString = new LinkedList<String>();
        namenString.add("Steffen");
        namenString.add("Christian");
        namenString.add("Ian");
        namenString.add("Christoph");
        namenString.add("Jonas");
        namenString.add("Anton");
        namenString.add("Tim");
        namenString.add("Andre");
        namenString.add("Joshua");

        schueler = new LinkedList<Schueler>();
        schueler.add(new Schueler("Laaaaaanger", "Naaaaameeee", 35));
        schueler.add(new Schueler("Steffen", "Schoen", 17));
        schueler.add(new Schueler("AB", "ABSchueler", 16));
        schueler.add(new Schueler("A", "ASchueler", 16));    
        schueler.add(new Schueler("Test", "Schueler", 14));
        schueler.add(new Schueler("Z", "ZSchueler", 27));
        schueler.add(new Schueler("Kurz", "N", 18));
    }

    private void printList()
    {
        for(Schueler s : schueler)
        {
            System.out.println(s.toString());
        }
    }

    //Basic Aufgabe

    public void sortBasic()
    {
        Collections.sort(namenString);

        for(String s : namenString)
        {
            System.out.println(s);
        }
    }

    //
    //Advanced Aufgabe

    public void sortAdvanced()
    {
        sortPro(SortierModus.Alter);
    }

    //
    //Pro Aufgabe

    public enum SortierModus
    {
        Vorname,
        Nachname,
        Laenge,
        Alter
    }

    public void sortPro(SortierModus modus)
    {

        switch(modus)
        {
            case Vorname:
            Collections.sort(schueler, new Comparator<Schueler> () {
                    public int compare(Schueler a, Schueler b) {
                        Collator c = Collator.getInstance();
                        return (c.compare(a.getVorname(), b.getVorname()));
                    } 
                });
            break;
            case Nachname:
            Collections.sort(schueler, new Comparator<Schueler> () {
                    public int compare(Schueler a, Schueler b) {
                        Collator c = Collator.getInstance();
                        return (c.compare(a.getNachname(), b.getNachname()));
                    } 
                });
            break;
            case Laenge:
            Collections.sort(schueler, new Comparator<Schueler> () {
                    public int compare(Schueler a, Schueler b) {
                        return ((a.getVorname()+a.getNachname()).length() - (b.getVorname()+b.getNachname()).length());
                    } 
                });
            break;
            case Alter:
            Collections.sort(schueler, new Comparator<Schueler> () {
                    public int compare(Schueler a, Schueler b) {
                        return (a.getAlter() - b.getAlter());
                    } 
                });
            break;
        }

        printList();
    }
}
