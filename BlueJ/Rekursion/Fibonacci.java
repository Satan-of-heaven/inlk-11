public class Fibonacci
{
    public static int fibRek(int n)
    {
        if(n == 0)
        {
            return 0;
        }else if(n == 1)
        {
            return 1;
        }else
        {
           return (fibRek(n - 1) + fibRek(n - 2));
        }
    }
    
    public static int fibIter(int n)
    {
        int fib1 = 0, fib2 = 1, erg = 1;
        
        for(int i = 0; i < n - 1; i++)
        {
            erg = fib1 + fib2;
            fib1 = fib2;
            fib2 = erg;
        }
        
        return erg;
    }
}
