import java.io.*;

public class Song implements Serializable
{
    private String name;
    private String interpret;
    private boolean istKopieVonCD;
    private int dauer;
    
    /**
     * Erzeugt die Daten zu einem Song.
     * Beim Erzeugen muss der Name des Songs und des Interpreten angegeben werden.
     * Ausserdem muss angegeben werden, ob der Song auch auf CD vorhanden ist.
     * Die L�nge des Songs soll in Sekunden angegeben werden.
     */
    public Song(String name, String interpret, boolean istKopieVonCD, int dauer)
    {
        this.name = name;
        this.interpret = interpret;
        this.istKopieVonCD = istKopieVonCD;
        this.dauer = dauer;
    }

    /**
     * @return Dauer des Songs in Sekunden
     */
    public int getDauer()
    {
        return dauer;
    }

    /**
     * Die L�nge des Songs soll in Sekunden gespeichert werden.
     */
    public void setDauer(int dauer)
    {
        this.dauer = dauer;
    }

    /**
     * @return Name des Interpreten
     */
    public String getInterpret()
    {
        return interpret;
    }

    /**
     * Setzt den Namen des Interpreten fest.
     */
    public void setInterpret(String interpret)
    {
        this.interpret = interpret;
    }

    /**
     * @return Ist true, wenn der Song auch auf CD vorhanden ist.
     */
    public boolean istKopieVonCD()
    {
        return istKopieVonCD;
    }

    /**
     * Soll true sein, wenn der Song auch auf CD vorhanden ist.
     */
    public void setKopieVonCD(boolean istKopieVonCD)
    {
        this.istKopieVonCD = istKopieVonCD;
    }

    /**
     * @return Name des Songs.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Lege Namen des Songs fest.
     */
    public void setName(String name)
    {
        this.name = name;
    }

}
