import javax.swing.JOptionPane;

public class Einsatz
{
    public void durchführen()
    {
        try
        {
         new Bombe().entschärfen();
        }
        catch(EntschärfungsException ex)
        {
            JOptionPane.showMessageDialog(null, "Bombe nicht entschäft", "Bumm", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
