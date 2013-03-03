import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WeatherGui extends JFrame
{
    private WeatherStation ws;

    private DefaultListModel listModel;

    private Panel pnl_right;
    private JComboBox cbx_cities;
    private JList lbx_info;
    private JButton btn_update;
    private JLabel lbl_online;
    private JCheckBox chx_proxy;

    public WeatherGui()
    {
        ws= new WeatherStation();
        listModel = new DefaultListModel();

        setSize(500,500);
        setLayout(new BorderLayout(5,5));       

        pnl_right = new Panel();
        cbx_cities = new JComboBox(ws.getCityNames());
        lbx_info = new JList(listModel);
        btn_update = new JButton("Aktualisieren");
        lbl_online = new JLabel();
        chx_proxy = new JCheckBox("Proxy benutzen", false);

        pnl_right.setLayout(new BoxLayout(pnl_right, BoxLayout.Y_AXIS));
        cbx_cities.setSelectedItem(ws.getCityName());

        chx_proxy.addItemListener(new Chx_proxy_SelectionChanged());
        cbx_cities.addItemListener(new Cbx_cities_SelectedItemChanged());
        btn_update.addActionListener(new Btn_update_Clicked());
        btn_update.doClick();

        pnl_right.add(lbl_online);
        pnl_right.add(cbx_cities);
        pnl_right.add(Box.createVerticalStrut(5));
        pnl_right.add(btn_update);
        pnl_right.add(Box.createVerticalStrut(5));
        pnl_right.add(chx_proxy);

        add(pnl_right, BorderLayout.EAST);
        add(lbx_info, BorderLayout.WEST);

        setTitle("Wetter - " + ws.getCityName());
        setIconImage(ws.getIcon().getImage());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

    }

    private void updateLbx()
    {
        listModel.clear();

        listModel.addElement("Stadt : " + ws.getCityName());
        listModel.addElement("Code : " + ws.getCityCode());
        listModel.addElement("Temperatur : " + ws.getTemperature() + "°C");
        listModel.addElement("Feuchtigkeit : " + ws.getHumidity() + "%");
        listModel.addElement("Sonnenaufgang : " + ws.getSunrise());
        listModel.addElement("Sonnenuntergang : " + ws.getSunset()); 
    }

    class Btn_update_Clicked implements ActionListener { 
        public void actionPerformed(ActionEvent e) { 
            if(ws.isOnline())
            {
                lbl_online.setForeground(Color.GREEN);
                lbl_online.setText("ONLINE");

                ws.update();
                updateLbx();
            }
            else
            {
                lbl_online.setForeground(Color.RED);
                lbl_online.setText("OFFLINE");
            }
        } 
    }

    class Cbx_cities_SelectedItemChanged implements ItemListener{
        public void itemStateChanged(ItemEvent e) {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                ws.setCityName(String.valueOf(e.getItem()));
                setTitle("Wetter - " + ws.getCityName());
                setIconImage(ws.getIcon().getImage());
                btn_update.doClick();
            }
        }

    }

    class Chx_proxy_SelectionChanged implements ItemListener{
        public void itemStateChanged(ItemEvent e) {         
            ws.setProxy(((JCheckBox) e.getItemSelectable()).isSelected());
        }
    }
}
