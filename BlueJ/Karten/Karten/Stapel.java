
public class Stapel
{
    private Karte erste;    

    public Stapel()
    {
        
    }
    
    public Karte getErste()
    {
        return erste;
    }
    
    public void addKarte(Karte k)
    {
        k.setNaechste(erste);
        erste = k;
    }
    
    public void removeKarte()
    {
        if(erste != null)
        {
            Karte k = erste;
            erste = erste.getNaechste();
            k.setNaechste(null);
        }
    }
    
    public int zaehlen()
    {
        int z = 0;
        
        Karte k = erste;
        while(k != null)
        {
            z++;
            k = k.getNaechste();
        }
        
        
        return z;
    }
}
