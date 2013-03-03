public class RekursionsTiefe
{
    public static void max(int aufrufe)
    {
        System.out.println(aufrufe);
        max(++aufrufe);
    }
    
//    public static void max2(int aufrufe)
//    {
//        try
//        {
//            max2(++aufrufe);
//        }catch(StackOverflowError e)
//        {
//            System.out.println(aufrufe);
//        }
//    }
}
