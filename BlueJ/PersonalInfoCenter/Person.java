import java.util.*;  


public class Person {

    public enum BmiKlasse
    {
        Uebergewicht { public String toString(){return "Übergewicht";} },
        Normalgewicht { public String toString(){return "Normalgewicht";} },
        Untergewicht { public St ring toString(){return "Untergewicht";} },
        NichtBerechenbar { public String toString(){return "Nicht Berechenbar";} }
    }

    public enum SternzeichenTyp
    {
        Tierkreis,
        Chinesisch,
        Indianisch
    }

    private String name;
    private int tag;
    private int monat;
    private int jahr;
    private double gewicht;
    private int groesse;
    //private Boolean isWeiblich;

    public Person()
    {
        name = "";
        tag = 1;
        monat = 1;
        jahr = 42;
        gewicht = 75.0;
        groesse = 175;

        
    }

    public Person(String vollerName, int geburtsTag, int geburtsMonat, int geburtsJahr) {
        this();

        setName(vollerName);
        setTag(geburtsTag);
        setMonat(geburtsMonat);
        setJahr(geburtsJahr);
    }

    public Person(String name, int tag, int monat, int jahr, double gewicht, int groesse)
    {
        this();

        setName(name);
        setTag(tag);
        setMonat(monat);
        setJahr(jahr);
        setGewicht(gewicht);
        setGroesse(groesse);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String vollerName)
    {
        name = vollerName;
    }

    public int getTag()
    {
        return tag;
    }

    public void setTag(int val)
    {
        if(val > 0 && val <= 31)
        {
            tag = val;
        }

    }

    public int getMonat()
    {
        return monat;
    }

    public void setMonat(int val)
    {
        if(val > 0 && val <= 12)
        {
            monat = val;
        }

    }

    public int getJahr()
    {
        return jahr;
    }

    public void setJahr(int val)
    {
        jahr = val;
    }

    public double getGewicht()
    {
        return gewicht;
    }

    public void setGewicht(double val)
    {
        if(val > 0.0 && val < 1000.0)
        {
            gewicht = val;
        }
    }

    public int getGroesse()
    {
        return groesse;
    }

    public void setGroesse(int val)
    {
        if(val > 0 && val <= 272)
        {
            groesse = val;
        }
    }
    //     public Boolean IsWeiblich()
    //     {
    //         return isWeiblich;
    //     }
    //     
    //     public void setGeschlecht(Boolean isWeiblich)
    //     {
    //         this.isWeiblich = isWeiblich;
    //     }

    public double getBMI()
    {
        //return (gewicht / (Math.pow(groesse / 100, 2)));
        return (gewicht / (((double)groesse / 100) * ((double)groesse / 100)));
    }

    public BmiKlasse getBmiKlasse()
    {
        double bmi = getBMI();
        int alter = getAlter();

        double optBMImin = 0;
        double optBMImax = 0;

        
        if(alter >= 19 && alter <= 24)
        {
            optBMImin = 19.0;
            optBMImax = 24.0;          
        }else if(alter >= 25 && alter <= 34)
        {
            optBMImin = 20.0;
            optBMImax = 25.0; 
        }else if(alter >= 35 && alter <= 44)
        {
            optBMImin = 21.0;
            optBMImax = 26.0; 
        }else if(alter >= 45 && alter <=54)
        {
            optBMImin = 22.0;
            optBMImax = 27.0; 
        }else if(alter >= 55 && alter <= 65)
        {
            optBMImin = 23.0;
            optBMImax = 28.0; 
        }else if(alter > 65)
        {
            optBMImin = 24.0;
            optBMImax = 29.0; 
        }

        if(bmi >= optBMImin && bmi <= optBMImax)
        {
            return BmiKlasse.Normalgewicht;
        }else if(bmi > optBMImax)
        {
            return BmiKlasse.Uebergewicht;
        }else if(bmi < optBMImin)
        {
            return BmiKlasse.Untergewicht;
        }
        return BmiKlasse.NichtBerechenbar;
    }

    public int getAlter() {
        // Create a calendar object with the date of birth
        Calendar dateOfBirth = new GregorianCalendar(jahr, monat - 1, tag);
        // Create a calendar object with today's date
        Calendar today = Calendar.getInstance();
        // Get age based on year
        int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
        // Add the tentative age to the date of birth to get this year's birthday
        dateOfBirth.add(Calendar.YEAR, age);
        // If this year's birthday has not happened yet, subtract one from age
        if (today.before(dateOfBirth)) {
            age--;
        }
        return age;
    }

    public String getSternzeichen(SternzeichenTyp typ)
    {
        String s = "";

        //         switch(typ)
        //         {  
        //             case Tierkreis:
        //                 s = getTierkreiszeichen();
        //                 System.out.println("TKZ");
        //             case Chinesisch:
        //                 s =  getChinesischStz();
        //                 System.out.println("CSZ");
        //             case Indianisch :
        //                 s =  getIndianischStz();
        //                 System.out.println("ISZ");
        //         }

        if(typ == SternzeichenTyp.Tierkreis)
        {
            s = getTierkreiszeichen();   
        }else if(typ == SternzeichenTyp.Chinesisch)
        {
            s =  getChinesischStz();
        }else
        {
            s =  getIndianischStz();
        }

        return s;
    }

    private String getTierkreiszeichen()
    {
        Hashtable<Integer, String> tkz = new Hashtable<Integer, String>();
        tkz.put(1, "Widder");
        tkz.put(2, "Stier");
        tkz.put(3, "Zwilling");
        tkz.put(4, "Krebs");
        tkz.put(5, "Löwe");
        tkz.put(6, "Jungfrau");
        tkz.put(7, "Waage");
        tkz.put(8, "Skorpion");
        tkz.put(9, "Schütze");
        tkz.put(10, "Steinbock");
        tkz.put(11, "Wassermann");
        tkz.put(12, "Fische");
        
        return ((String)tkz.get(monat));
    }

    private String getChinesischStz()
    {
        String s = "Nicht feststellbar";

        Hashtable<Integer, String> csz = new Hashtable<Integer, String>();
        csz.put(1901, "Ratte");
        csz.put(1902, "Büffel");
        csz.put(1903, "Tiger");
        csz.put(1904, "Hase");
        csz.put(1905, "Drache");
        csz.put(1906, "Schlange");
        csz.put(1907, "Pferd");
        csz.put(1908, "Schaf");
        csz.put(1909, "Affe");
        csz.put(1910, "Hahn");
        csz.put(1911, "Hund");
        csz.put(1912, "Schwein");

        for(int i = 1901; i < 1913; i++)
        {
            if(((jahr - i) % 12) == 0)
            {
                s = (String)csz.get(i);
            }
        }

        return s;
    }

    private String getIndianischStz()
    {
        Hashtable<Integer, String> isz = new Hashtable<Integer, String>();
        isz.put(1, "Gans");
        isz.put(2, "Otter");
        isz.put(3, "Wolf");
        isz.put(4, "Roter Habicht");
        isz.put(5, "Biber");
        isz.put(6, "Hirsch");
        isz.put(7, "Specht");
        isz.put(8, "Lachs");
        isz.put(9, "Bär");
        isz.put(10, "Rabe");
        isz.put(11, "Schlange");
        isz.put(12, "Eule");

        return ((String)isz.get(monat));
    }

    public String getHoroskop()
    {
        Hashtable<String, String> horo = new Hashtable<String, String>();
        horo.put("Widder", "Das Liebesbarometer schlägt nach oben aus: Singles haben gute Chancen, bis zum Sommer unter die Haube gebracht zu werden. Unberechenbare Überraschungsblitze haben es auf den Widder abgesehen und können ihn ziemlich aus der Fassung bringen.");
        horo.put("Stier", "Glück in der Liebe und auf der ganzen Ebene steht dem Stier bevor - trotzdem nicht übermütig werden, vor dem Handeln nachdenken und realistisch bleiben. Ein Jahr, in dem ihm vieles von dem gelingt, was er wirklich will. Nur endlich aufs Gewicht zu achten, das nicht. ");
        horo.put("Zwilling", "Das Jahr steht unter dem Schutzherrn des Zwillings: Merkur bringt Erfolg. Durch seine zahlreichen Talente kann er in vielen Bereichen erfolgreich sein: Reporter, Postbote, Buchhändler oder Talkmaster - Hauptsache, es hat mit Kommunikation zu tun.");
        horo.put("Krebs", "Pflichtbewusst ist der Krebs zur Stelle, wenn seine Hilfe benötigt wird. Das führt dazu, dass seine Bedürfnisse zu oft hinten anstehen. In diesem Jahr sollte er das Verantwortungsgefühl zurückschrauben und sich der genießerischen Leichtigkeit zuwenden.");
        horo.put("Löwe", "Warum sollte man nur an Weihnachten Geschenke verteilen? Der Löwe ist das ganze Jahr über großzügig. Er gibt gerne, freut sich aber auch, wenn er bedacht wird. Der Juni wird deshalb zum besten Monat. Auf den Geldbeutel muss er dabei aber achten.");
        horo.put("Jungfrau", "Gesundheit ist das große Thema der Jungfrau. Sie sollte sich regelmäßig gründlich durchchecken lassen, um sich sicher zu fühlen. Es ist gut, sich selber auszukennen, daher wäre eine Fortbildung zu alternativen Heilmitteln ideal für sie.");
        horo.put("Waage", "Von allem wird etwas in den Topf 2012 geworfen, kräftig umgerührt und fertig ist eine fantastische Suppe für die Waage. Eine Überraschung kommt selten allein. Langweilig wird dieses Jahr ganz sicher nicht, manchmal aber etwas anstrengend.");
        horo.put("Skorpion", "Emotionaler Rückhalt ist für den Skorpion von großer Bedeutung, seine Seele braucht regelmäßige Streicheleinheiten - sein Ehrgeiz allein hält seine Energie nicht aufrecht. Freunde sind ihm wichtig, um auch andere Sichtweisen kennenzulernen.");
        horo.put("Schütze", "Er möchte immer etwas unternehmen, zu Hause rumzusitzen langweilt ihn endlos. Hat jemand eine gute Idee, ist der Schütze gerne bereit, sich mitziehen zu lassen: nichts wie raus und fort. Gleich zu Beginn des Jahres zeichnen sich gute Chancen ab.");
        horo.put("Steinbock", "Es gibt so viel zu tun, der Steinbock zögert nicht und packt es an. Dabei sollte er den Feierabend nicht vergessen und für einen schönen Ausgleich sorgen, das gibt ihm Schwung und anhaltende Energie für neue Projekte. Er liegt im Aufwärtstrend.");
        horo.put("Wassermann", "Mehr Toleranz müsste der Wassermann zeigen, was er selber will, sollte er doch auch anderen zugestehen. Im Team erreicht er viel mehr, er braucht weder den Alleinunterhalter noch den Fels in der Brandung zu spielen. Mit Kritik umgehen lernen.");
        horo.put("Fische", "Im Märchenland würde der Fisch sehr gerne leben. Das echte Leben ist leider oft unromantisch und hart. Da hilft nur, sich Auszeiten zu gönnen und daheim sein eigenes Wunderland schaffen. Aber mit einem Bein in der Wirklichkeit bleiben!");
        
        return (horo.get(getTierkreiszeichen()));
    }

    public void printInfo() {
        // Alle Infos über eine Person zusammenfassen
        System.out.println("*******************************************************");
        System.out.println("*            Info über " + name);
        System.out.println("*******************************************************");
        System.out.println(" " + name + " ist am " + tag + "." + monat + "." + jahr + " geboren");
        System.out.println(" und damit " + getAlter() + " Jahre alt.");
        System.out.println("*******************************************************");
        System.out.println("Gewicht : " + gewicht + " kg");
        System.out.println("Größe : " + groesse + " cm");
        System.out.println("*******************************************************");
        System.out.println("BMI : " + getBMI() + " (" + getBmiKlasse().toString() + ")");
        System.out.println("*******************************************************");
        System.out.println("Sternzeichen : " + getSternzeichen(SternzeichenTyp.Tierkreis) + "|" + getSternzeichen(SternzeichenTyp.Chinesisch) + "|" + getSternzeichen(SternzeichenTyp.Indianisch));
        System.out.println("*******************************************************");
        System.out.println("Horoskop :\n\r" + getHoroskop());
    }
}
