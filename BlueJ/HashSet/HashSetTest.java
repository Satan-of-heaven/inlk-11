import java.util.*;

public class HashSetTest
{
    HashSet<String> hs;

    public HashSetTest()
    {
        hs = new HashSet<String>();
        
        hs.add("test"); //true
        hs.add("test1"); //true
        hs.add("test2"); //true
        hs.add("test"); //false : existiert schon
        
        hs.add("test3");
        hs.add("test4");
        hs.add("test5");
        hs.add("test6");
    }
    
    public void print()
    {
        
        
        Iterator<String> i = hs.iterator();
        
        while(i.hasNext())
        {
            System.out.println(i.next());
        }
        
        for(String s : hs)
        {
            System.out.println(s);
        }
    }
    
    public void loeschen()
    {
        Iterator<String> i = hs.iterator();
        
        while(i.hasNext())
        {
            if(i.next().equals("test"))
                i.remove();
        }
        
        print();
    }
}
