import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class WeatherStationGUI extends JFrame implements ActionListener
{
    private WeatherStation ws;
    private JLabel ortLabel;
    private JLabel tempLabel;
    private JLabel iconLabel;
    private JTextField cityNameTextField;
    private JComboBox cityNameComboBox;
    private JButton updateButton;
    private JButton exitButton;
    private JCheckBox onlineCheckBox;
    private JCheckBox useProxyCheckBox;

    public WeatherStationGUI()
    {
        super("Wetterinfo");

        ws = new WeatherStation();

        // Look & Feel
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e)
        {
            System.out.println("Error setting Look and feel: " + e);
        }
        // Verhalten beim Schlie?en
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Icon der Anwendung setzen
        // setIconImage(new ImageIcon("weather-few-clouds.png").getImage());
        setIconImage(new ImageIcon(getClass().getResource("weather-few-clouds.png")).getImage());
        // Layoutmanager
        setLayout(new GridLayout());
        // Komponenten erzeugen
        initComponents();

        //Default-Button festlegen
        getRootPane().setDefaultButton(updateButton);
        // Wetter abfragen und GUI updaten
        ws.setProxy(false);
        update();

        // Fenster anordnen und zeigen
        pack();
        setVisible(true);
        toFront();
    }

    public static void main(String[] args)
    {
        new WeatherStationGUI();
    }

    private void initComponents()
    {
        ortLabel = new JLabel();
        ortLabel.setFont(new java.awt.Font("Arial", 0, 18));
        ortLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(ortLabel);

        tempLabel = new JLabel();
        tempLabel.setFont(new java.awt.Font("Arial", 0, 18));
        tempLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(tempLabel);

        iconLabel = new JLabel();
        iconLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add(iconLabel);

        cityNameTextField = new JTextField();
        cityNameTextField.setFont(new java.awt.Font("Arial", 0, 18));
        getContentPane().add(cityNameTextField);

        String[] cities = ws.getCityNames();
        Arrays.sort(cities);
        cityNameComboBox = new JComboBox(cities);
        cityNameComboBox.addActionListener(this);
        add(cityNameComboBox);

        updateButton = new JButton("Update");
        updateButton.setIcon(new ImageIcon(getClass().getResource("refresh.png")));
        updateButton.addActionListener(this);
        add(updateButton);

        exitButton = new JButton("Exit");
        exitButton.setIcon(new ImageIcon(getClass().getResource("system-log-out.png")));
        exitButton.addActionListener(this);
        add(exitButton);

        onlineCheckBox = new JCheckBox("Online");
        onlineCheckBox.setSelected(true);
//        onlineCheckBox.setIcon(new ImageIcon(getClass().getResource("system-log-out.png")));
        onlineCheckBox.addActionListener(this);
        add(onlineCheckBox);

        useProxyCheckBox = new JCheckBox("Proxy");
        useProxyCheckBox.setSelected(false);
        useProxyCheckBox.addActionListener(this);
        add(useProxyCheckBox);
    }

    private void update()
    {
        if(!cityNameTextField.getText().equals(""))
        {
            if(!ws.setCityName(cityNameTextField.getText()))
            {
                ws.setCityCode(cityNameTextField.getText());
            }
            ws.setOnline(onlineCheckBox.isSelected());
        }
        ws.update();
        setTitle("WeatherInfo - " + ws.getCityName());
        ortLabel.setText(ws.getCityName());
        tempLabel.setText(Integer.toString(ws.getTemperature()) + "°C");

        iconLabel.setIcon(ws.getIcon());
        cityNameTextField.setText("");
        cityNameTextField.requestFocus();
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == cityNameComboBox)
        {
            cityNameTextField.setText((String) cityNameComboBox.getSelectedItem());
            update();
        }
        if(e.getSource() == updateButton)
        {
            update();
        }
        if(e.getSource() == exitButton)
        {
            System.exit(0);
        }
        if(e.getSource() == onlineCheckBox)
        {
            ws.setOnline(onlineCheckBox.isSelected());
        }
        if(e.getSource() == useProxyCheckBox)
        {
            ws.setProxy(useProxyCheckBox.isSelected());
        }
    }
}
