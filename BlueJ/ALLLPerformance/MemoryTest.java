import java.util.*;
import objectexplorer.ObjectGraphMeasurer;

public class MemoryTest
{
    public static void test()
    {
        LinkedList<Object> ll = new LinkedList<Object>();
        ArrayList<Object> al = new ArrayList<Object>(5000000);
        
        for(int i = 0; i < 5000000; i++)
        {
            al.add(new Object());
            ll.add(new Object());
        }
        
        System.out.println("ArrayList : " + ObjectGraphMeasurer.measure(al));
        System.out.println("LinkedList : " + ObjectGraphMeasurer.measure(ll));
    }
}
