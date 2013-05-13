import java.util.*;

public class Test
{
    public static void testHashSet()
    {
        HashSet<Object> hs = new HashSet<Object>(5000000);
       
        long curr = System.currentTimeMillis();
       
        Object o = new Object();
        hs.add(o);
        
       for(int i = 1; i < 5000000; i++)
       {
           hs.add(new Object());
        }
        
        long t = System.currentTimeMillis() - curr;
        System.out.println("Hinzufügen HS : " + t + "ms" );
        
        curr = System.currentTimeMillis();
        
        for(Object ohs : hs)
        {
            if(ohs == o)
                break;
        }
        
        t = System.currentTimeMillis() - curr;
        System.out.println("Get HS : " + t + "ms" );
        
         curr = System.currentTimeMillis();
        
        for(Object ohs : hs)
        {
            if(ohs == o)
            {
                hs.remove(ohs);
                break;
            }
        }
        
        t = System.currentTimeMillis() - curr;
        System.out.println("Löschen HS : " + t + "ms" );
        
        curr = System.currentTimeMillis();
        
        for(int i = 0; i < 100; i++)
        {
            hs.add(new Object());
        }
        
        
        t = System.currentTimeMillis() - curr;
        System.out.println("Add AL : " + t + "ms\n" );
    }

   public static void testArrayList()
   {
       ArrayList<Object> al = new ArrayList<Object>(5000000);
       
        long curr = System.currentTimeMillis();
       
       for(int i = 0; i < 5000000; i++)
       {
           al.add(new Object());
        }
        
        long t = System.currentTimeMillis() - curr;
        System.out.println("Hinzufügen AL : " + t + "ms" );
        
        curr = System.currentTimeMillis();
        
        al.get(534913);
        
        t = System.currentTimeMillis() - curr;
        System.out.println("Get AL : " + t + "ms" );
        
         curr = System.currentTimeMillis();
        
        al.remove(534913);
        
        t = System.currentTimeMillis() - curr;
        System.out.println("Löschen AL : " + t + "ms" );
        
         curr = System.currentTimeMillis();
        
        al.set(534913, new Object());
        
        t = System.currentTimeMillis() - curr;
        System.out.println("Set AL : " + t + "ms" );
        
        curr = System.currentTimeMillis();
        
        for(int i = 0; i < 100; i++)
        {
            al.add(new Object());
        }
        
        
        t = System.currentTimeMillis() - curr;
        System.out.println("Add AL : " + t + "ms\n" );
    }
    
    public static void testLinkedList()
   {
       LinkedList<Object> ll = new LinkedList<Object>();
       
        long curr = System.currentTimeMillis();
       
       for(int i = 0; i < 5000000; i++)
       {
           ll.add(new Object());
        }
        
        long t = System.currentTimeMillis() - curr;
        System.out.println("Hinzufügen LL : " + t + "ms" );
        
        curr = System.currentTimeMillis();
        
        ll.get(534913);
        
        t = System.currentTimeMillis() - curr;
        System.out.println("Get LL : " + t + "ms" );
        
         curr = System.currentTimeMillis();
        
        ll.remove(534913);
        
        t = System.currentTimeMillis() - curr;
        System.out.println("Löschen LL : " + t + "ms" );
        
         curr = System.currentTimeMillis();
        
        ll.set(534913, new Object());
        
        t = System.currentTimeMillis() - curr;
        System.out.println("Set LL : " + t + "ms" );
        
        curr = System.currentTimeMillis();
        
        for(int i = 0; i < 100; i++)
        {
            ll.add(new Object());
        }
        
        t = System.currentTimeMillis() - curr;
        System.out.println("Add LL : " + t + "ms\n" );
    }
}
