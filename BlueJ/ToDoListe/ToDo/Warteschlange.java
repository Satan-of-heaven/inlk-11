public class Warteschlange
{
    private Aufgabe erste;
    private int aufgabenAnz;

    public Warteschlange() {}

    public void erstellen (String beschr)
    {
        if(erste != null)
        {
            erste.erstelle(beschr);
        }else{
            erste = new Aufgabe(beschr);
        }
        aufgabenAnz++;
    }
    
    public int getAufgabenZahl()
    {
        return aufgabenAnz;
    }
    
    public Aufgabe getErstes()
    {
        return erste;
    }
    
    public void loesche()
    {
        Aufgabe a = erste.getNaechste();
        erste.setNaechste(null);
        erste = a;
        a = null;
    }
    
    public void printListe()
    {
        erste.printBeschreibung();
    }
    
    public void printErste()
    {
        System.out.println(erste.getBeschreibung());
    }
}
