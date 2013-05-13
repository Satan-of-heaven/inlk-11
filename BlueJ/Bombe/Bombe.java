import java.util.Random;
import javax.swing.JOptionPane;

public class Bombe {
    public void entschärfen() throws EntschärfungsException
    {
        // Manchmal geht halt was schief ...
        if(new Random().nextInt(5) == 0)
        {
            throw new EntschärfungsException();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Bombe entschäft", "Entwarnung", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
