public class Auto
{
    private int unfaelle;
    private int neuWert;
    private int km;
    private int alter;
    private String marke;
    
    public Auto()
    {
        setUnfaelle(0);
        setNeuWert(1);
        setKM(0);
        setAlter(1);
        setMarke("Auto");
        
    }
    
    public Auto(int unfaelle, int neuWert, int km, int alter, String marke)
    {
        setUnfaelle(unfaelle);
		setNeuWert(neuWert);
		setKM(km);
		setAlter(alter);
		setMarke(marke);
    }
    
    public int getUnfaelle()
    {
        return unfaelle;
    }
    public void setUnfaelle(int value)
    {
        if(value > 0)
        {
            unfaelle = value;
        }
    }
    
    public int getNeuWert()
    {
        return neuWert;
    }
    public void setNeuWert(int value)
    {
        if(value > 0)
        {
            neuWert = value;
        }
    }
    
    public int getKM()
    {
        return km;
    }
    public void setKM(int value)
    {
        if(value > 0)
        {
            km = value;
        }
    }
    
    public int getAlter()
    {
        return alter;
    }
    public void setAlter(int value)
    {
        if(value > 0)
        {
            alter = value;
        }
    }
    
    public String getMarke()
    {
        return marke;
    }
    public void setMarke(String value)
    {
        marke = value;
    }

    public int getWert()
    {
        int wert = neuWert;
        wert *= Math.pow(unfaelle,-0.9) * Math.pow(km , -0.05) * Math.pow(alter, -0.4);     
        return wert;
    }
    
    public int getWertVerlust(){
        return (neuWert - getWert());
    }
}