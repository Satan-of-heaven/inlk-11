
public final class Math
{
    public static final double PI = 3.141592654;

    private Math(){}

    public static double getKreisflaeche(double r)
    {
        return (PI * r * r);
    }

    public static double getKreisumfang(double r)
    {
        return (2 * PI * r);
    }
}
