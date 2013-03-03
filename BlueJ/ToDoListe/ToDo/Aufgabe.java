
public class Aufgabe
{
    private Aufgabe naechste;
    private String beschreibung;

    public Aufgabe(String beschr)
    {
       beschreibung = beschr;
    }
    
    public String getBeschreibung()
    {
        return beschreibung;
    }
    
    public Aufgabe getNaechste()
    {
        return naechste;
    }
    
    public void setNaechste(Aufgabe v)
    {
        naechste = v;
    }
    
    public void printBeschreibung()
    {
        System.out.println(beschreibung);
        if(naechste != null)
        {
            naechste.printBeschreibung();
        }
    }
    
    public void erstelle(String beschr)
    {
        if(naechste != null)
        {
            naechste.erstelle(beschr);
        }else{
            naechste = new Aufgabe(beschr);
        }
    }
}
