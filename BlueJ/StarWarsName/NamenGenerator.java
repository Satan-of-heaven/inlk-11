public class NamenGenerator
{
    public static void printStarWarsName(String vorname,  String nachname, String mutterName, String geburtsOrtName)
    {
        /*
       Your Star Wars First Name:

        1.  Take the first 3 letters of your last name.
        2.  Add to that, the first 2 letters of your first name.
        
        Your Star Wars Last Name:
        
        1.  Take the first 2 letters of your mother's maiden name.
        2.  Add the first 3 letters of the name of the town in which you were born.
        */
        
        
        String swVor = nachname.substring(0, 3) + vorname.substring(0, 2);
        String swNach = mutterName.substring(0, 2) + geburtsOrtName.substring(0, 3);
        
        System.out.println(swVor + " " + swNach);
    }
}
