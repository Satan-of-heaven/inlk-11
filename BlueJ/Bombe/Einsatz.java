import javax.swing.JOptionPane;

public class Einsatz
{
    public void durchf�hren()
    {
        try
        {
         new Bombe().entsch�rfen();
        }
        catch(Entsch�rfungsException ex)
        {
            JOptionPane.showMessageDialog(null, "Bombe nicht entsch�ft", "Bumm", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
