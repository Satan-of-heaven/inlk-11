
public class MeinSpiel implements Spiel
{
    private int konto;
    private int trefferzahl;
    private int gesetzteZahl;
    private int einsatz;

    public MeinSpiel()
    {
        konto = 100;
    }

    public void einsatzZahlen(int betrag)
    {
        if((konto - betrag) >= 0)
        {
            einsatz = betrag;
            konto -= betrag;
        }
    }

    public int getErmittelteZahl()
    {
        return trefferzahl;
    }

    public int getKontostand()
    {
        return konto;
    }

    public void gewinnAuszahlen()
    {
        if(gesetzteZahl == trefferzahl)
            konto += einsatz * gesetzteZahl;
    }

    public void zahlErmitteln()
    {
        trefferzahl = new java.util.Random().nextInt(11) + 1;
    }

    public void zahlSetzen(int zahl)
    {
        gesetzteZahl = zahl;
    }
}
