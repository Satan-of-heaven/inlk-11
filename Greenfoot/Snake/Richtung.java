
public enum Richtung  
{
    Oben,
    Unten,
    Links,
    Rechts;

    public static Richtung getEnum(int value) {
        switch (value) {
            case 0:   return Oben;
            case 1:   return Unten;
            case 2: return Links;
            case 3: return Rechts;
            default:  return null;
        }
    }
}
