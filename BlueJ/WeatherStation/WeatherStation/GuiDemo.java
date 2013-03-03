import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GuiDemo extends JFrame implements ActionListener
{
    private JLabel stadtLabel;
    private JLabel tempLabel;
    private JButton speyerButton;
    private JButton berlinButton;

    private WeatherStation ws;

    public GuiDemo()
    {
        ws = new WeatherStation();
        ws.update();

        setLayout(new FlowLayout());

        stadtLabel = new JLabel();
        stadtLabel.setText(ws.getCityName());
        add(stadtLabel);

        tempLabel = new JLabel();
        tempLabel.setText("Temperatur" + ws.getTemperature());
        add(tempLabel);

        speyerButton = new JButton("Speyer");
        speyerButton.addActionListener(this);
        add(speyerButton);

        berlinButton = new JButton("Berlin");
        berlinButton.addActionListener(this);
        add(berlinButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == speyerButton)
        {
            ws.setCityName("Speyer");
            ws.update();
            stadtLabel.setText("Speyer");
            tempLabel.setText("Temp: " + ws.getTemperature());
            pack();
        }
        if(e.getSource() == berlinButton)
        {
            ws.setCityName("Berlin");
            ws.update();
            stadtLabel.setText("Berlin");
            tempLabel.setText("Temp: " + ws.getTemperature());
            pack();
        }
    }
    
    public static void main(String[] args)
    {
        new GuiDemo();
    }
}
