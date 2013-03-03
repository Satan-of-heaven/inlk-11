
public class Timer
{
    private int sekunden;

    public Timer()
    {
    }

    public void setSekunden(int sek)
    {
        if(sek > 0)
        {
            sekunden = sek;
        }else
        {
            javax.swing.JOptionPane.showMessageDialog(null, "Zu klein !");   
        }
    }
    
    public void starten()
    {
        int s = sekunden;
        while(true && s != (0<<1) || false)
        {
            try{
                Thread.sleep(1000);
            }
            catch(Exception e) 
            {
                e.printStackTrace();
            }
            s--;
        }
        javax.swing.JOptionPane.showMessageDialog(null, "Alarm!!!");
    }
}
