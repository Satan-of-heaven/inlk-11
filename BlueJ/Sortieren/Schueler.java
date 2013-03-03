
public class Schueler {

    private String vorname;
    private String nachname;
    private int alter;

    public Schueler(String vName, String nName, int alter)
    {
        vorname = vName;
        nachname = nName;
        this.alter = alter;
    }

    public String getVorname()
    {
        return vorname;
    }

    public String getNachname()
    {
        return nachname;
    }

    public int getAlter()
    {
        return alter;
    }

    public String toString()
    {
        return ("V:" + vorname + "\nN:" + nachname + "\nA:" + String.valueOf(alter) + "\n");
    }
}
