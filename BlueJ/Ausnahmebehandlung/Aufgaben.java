import java.io.*;

public class Aufgaben
{

    public static void divNull(int z1, int z2)
    {
        try
        {
            System.out.println(z1 / z2);
        }
        catch(ArithmeticException ex)
        {
            System.out.println("Division durch 0 !");
        }
    }

    public static void createFile(String fileName)
    {
        try
        {
            File f = new File(fileName);
            f.createNewFile();
        }
        catch(IOException ex)
        {
            System.out.println("Fehler :\n" + ex.toString());
        }
    }

    public static void writeFile(String fileName, String s)
    {
        FileWriter fw = null;

        try
        {
            fw = new FileWriter( fileName );
            fw.write( s);
        }
        catch ( IOException e ) {
            System.out.println( "Konnte Datei nicht schreiben" );
        }
        finally {
            try { fw.close(); } catch ( IOException e ) {System.out.println( "Konnte Datei nicht schließen" );}
        }
    }

    public static void read1Line(String fileName)
    {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            System.out.println(br.readLine());
            
        } catch (IOException ex) {
            System.out.println( "Konnte Datei nicht lesen" );
        }

    }

}
