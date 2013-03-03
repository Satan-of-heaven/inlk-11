import java.util.Random;

public class Karte
{
    private int wert;
    private String wort;
    
    /**
     * Erzeugt eine Karte mit zufälligem Inhalt.
     */
    public Karte()
    {
        String[] worte = {
            "ich", "ich", "ich", "ich", "ich",
            "du", "du", "du", "du", "du", 
            "mich", "dich","mich", "dich","mich", "dich",
            "wieder", "heute", "gestern", "wald",
            "Haus", "Blume", "PC", "Schule", "Tapete",
            "habe", "hast", "möchte", "möchtest",
            "gehe", "gehst", "laufe", "läufst",
            "spreche", "sprichst", "singe", "singst",
            "voll", "daneben", "wieder", "mal",
            "echt", "blau", "leer", "Cola", "Sofa",
            "und", "und", "und", "und", "und",
            "oder", "oder", "oder", "oder", "oder",
            "Fußball", "Bild", "hallo"
        };
        Random random = new Random();
        int index = random.nextInt(worte.length);
        wort = worte[index].toUpperCase();
        wert = random.nextInt(10) + 1;
    }
    /**
     * Konstruktor, der v.a. zum Testen benutzt werden kann.
     */
    public Karte(String wort, int wert)
    {
        this.wort = wort;
        this.wert = wert;
    }
    
    public String getWort()
    {
        return wort;
    }
    
    public int getWert()
    {
        return wert;
    }
}
