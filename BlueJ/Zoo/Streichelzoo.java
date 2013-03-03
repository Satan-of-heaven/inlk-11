import java.util.*;

public class Streichelzoo
{
    private HashSet<Streicheltier> tiere;
    
    public Streichelzoo()
    {
        tiere = new HashSet<Streicheltier>();
    }
    
    public void grundbestandErzeugen()
    {
        tiere.add(new Hund());
        tiere.add(new Hund());
        tiere.add(new Hamster());
        tiere.add(new Wellensittich());
        tiere.add(new Wellensittich());
        tiere.add(new Wellensittich());
        tiere.add(new Wellensittich());
    }
    
    public int getGesamtWert()
    {
        int wert = 0;
        
        for(Streicheltier t: tiere)
        {
            wert += t.getWert();
        }
        
        return wert;
    }
}
