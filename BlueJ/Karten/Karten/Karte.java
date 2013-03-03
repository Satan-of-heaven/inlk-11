
public class Karte
{
    private int wert;
    private Karte naechste;
   
    public Karte()
    {
        wert = new java.util.Random().nextInt(8) + 1;
    }
    
    public Karte(int wert)
    {
        this.wert = wert;
    }
    
    public int getWert()
    {
        return wert;
    }
    
    public void setNaechste(Karte v)
    {
        naechste = v;
    }
    
    public Karte getNaechste()
    {
        return naechste;
    }
}
