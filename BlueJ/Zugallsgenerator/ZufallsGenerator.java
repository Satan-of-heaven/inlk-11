
public class ZufallsGenerator
{
    private long seed;
    
    private final long c = 0x5DEECE66DL;
    private final long m = 1L << 48;

    
    public ZufallsGenerator(long seed)
    {
        this.seed = seed;
    }
    
    public long getZufallsZahl()
    {
        return (seed = (seed * c) & (m - 1));
    }
    
    public long getZufallsZahl(int n)
    {
        return getZufallsZahl() % n;
    }
}
