
public class Adler extends Vogel implements Essbar
{

    public Boolean getSchmecktGut()
    {
        return true;
    }

    public void fressen ()
    {
        System.out.println("hack hack...");
    }

    public void laufen ()
    {
        System.out.println("trippeldi trapp will wieder fliegen");
    }

    public void fliegen ()
    {
        System.out.println("Gleitend und majestätisch schwebe ich dahin...");
    }
}

