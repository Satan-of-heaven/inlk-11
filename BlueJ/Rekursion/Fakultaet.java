import java.math.BigInteger;

public class Fakultaet
{
    public static BigInteger fakultaetBig(BigInteger n)
    {
        if(n.equals(1))
        {
            return (new BigInteger("1"));
        }else{
            return( n.multiply(fakultaetBig( n.subtract (new BigInteger("1")) )));
        }
    }

    public static int fakultaet(int n)
    {
        if(n == 1)
        {
            return 1;
        }else{
            return( n * (fakultaet(n-1)));
        }
    }
    
    public static int fakuIter(int n)
    {
        int erg = 1;
        for(int i = 1; i <= n; i++)
        {
            erg *= i;
        }
        
        return erg;
    }
    
    public static BigInteger fakuIterBigInt(int n)
    {
        BigInteger erg = BigInteger.ONE;
        for(int i = 1; i <= n; i++)
        {
            erg = erg.multiply(BigInteger.valueOf(i));
        }
        
        return erg;
    }
    
    public static void printFakuBigInt(int n)
    {
        System.out.println(fakuIterBigInt(n));
    }
}
