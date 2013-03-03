public class Wellensittich extends Vogel implements Streicheltier, Essbar
{
    public Boolean getSchmecktGut()
    {
        return false;
    }

    public int getWert()
    {
        return 30;
    }

    public void fressen ()
    {
        System.out.println("pick, pick, pick, pick");
    }

    public void laufen ()
    {
        System.out.println("tipp, tapp. Will wieder fliegen.");
    }

    public void fliegen ()
    {
        System.out.println("Flatter, flatter, flatter, will wieder sitzen ...");
    }
}

