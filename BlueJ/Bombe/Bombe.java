import java.util.Random;
import javax.swing.JOptionPane;

public class Bombe {
    public void entsch�rfen() throws Entsch�rfungsException
    {
        // Manchmal geht halt was schief ...
        if(new Random().nextInt(5) == 0)
        {
            throw new Entsch�rfungsException();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Bombe entsch�ft", "Entwarnung", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
