

public class Aufgabe implements Sortierbar
{
    private int wichtigkeit;
    private String beschreibung;
   
    public Aufgabe(int wert, String beschreibung)
    {
        this.wichtigkeit = wert;
        this.beschreibung = beschreibung;
    }
    
    public int getWert()
    {
        return wichtigkeit;
    }
    
    public String toString()
    {
        return (beschreibung + "(" + String.valueOf(wichtigkeit) + ")");
    }
}
