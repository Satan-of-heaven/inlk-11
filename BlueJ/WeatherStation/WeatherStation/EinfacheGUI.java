import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class EinfacheGUI extends JFrame implements ActionListener
{
    private WeatherStation ws;
    private JLabel tempLabel;
    private JTextField cityNameTextField;
    private JButton updateButton;

    public EinfacheGUI()
    {
        super("Wetterinfo");

        ws = new WeatherStation();

        // Verhalten beim Schlie?en
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Layoutmanager
        setLayout(new GridLayout());
        // Komponenten erzeugen
        initComponents();

        // Wetter abfragen und GUI updaten
        ws.setProxy(false);
        update();

        // Fenster anordnen und zeigen
        pack();
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new EinfacheGUI();
    }

    private void initComponents()
    {
        tempLabel = new JLabel();
        add(tempLabel);

        cityNameTextField = new JTextField();
        cityNameTextField.setFont(new java.awt.Font("Arial", 0, 18));
        getContentPane().add(cityNameTextField);

        updateButton = new JButton("Update");
        updateButton.addActionListener(this);
        add(updateButton);
    }

    private void update()
    {
        if(!cityNameTextField.getText().equals(""))
        {
            if(!ws.setCityName(cityNameTextField.getText()))
            {
                ws.setCityCode(cityNameTextField.getText());
            }
        }
        ws.update();
        tempLabel.setText(Integer.toString(ws.getTemperature()) + "°C");

        cityNameTextField.setText("");
        cityNameTextField.requestFocus();
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == updateButton)
        {
            update();
        }
    }
}
