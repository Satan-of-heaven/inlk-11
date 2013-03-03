import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JSeparator;


@SuppressWarnings({ "serial", "unused" })
public class WeatherGui extends JFrame {
	
	private WeatherStation ws;
	private DefaultListModel<String> listModel;

	private JPanel contentPane;
	private JButton btn_Aktualisieren;
	@SuppressWarnings("rawtypes")
	private JList list;
	private JMenuBar mb_main;
	private JMenu mn_Stadt;
	private JMenu mn_Proxy;
	private JCheckBoxMenuItem chckbxmntmBenutzen;
	private JLabel lbl_Imagelabel;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntm_Aktualisieren;
	private JSeparator separator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WeatherGui frame = new WeatherGui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}

	/**
	 * Create the frame.
	 */
	public WeatherGui() {
		ws = new WeatherStation();
		listModel = new DefaultListModel<String>();
		
		initialize();
	}
	
	private void initialize() {
		setTitle("Wetter Station");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		this.mb_main = new JMenuBar();
		setJMenuBar(this.mb_main);
		
		this.mn_Stadt = new JMenu("Stadt");
		this.mb_main.add(this.mn_Stadt);
		
		this.mntm_Aktualisieren = new JMenuItem("Aktualisieren");
		this.mntm_Aktualisieren.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_MASK));
		this.mntm_Aktualisieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ws.update();
				updateWeather(ws.getCityName());
			}
		});
		this.mn_Stadt.add(this.mntm_Aktualisieren);
		
		this.separator = new JSeparator();
		this.mn_Stadt.add(this.separator);
		
		this.mn_Proxy = new JMenu("Proxy");
		this.mb_main.add(this.mn_Proxy);
		
		this.chckbxmntmBenutzen = new JCheckBoxMenuItem("Benutzen");
		this.chckbxmntmBenutzen.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				ws.setProxy(arg0.getStateChange() == ItemEvent.SELECTED);
				ws.update();
				updateWeather(ws.getCityName());
			}
		});
		this.chckbxmntmBenutzen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		this.mn_Proxy.add(this.chckbxmntmBenutzen);
		
		this.mntmNewMenuItem = new JMenuItem("Einstellungen");
		this.mntmNewMenuItem.setVisible(false);
		this.mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.ALT_MASK));
		this.mn_Proxy.add(this.mntmNewMenuItem);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(this.contentPane);
		this.contentPane.setLayout(new BorderLayout(0, 0));
		
		this.btn_Aktualisieren = new JButton("Aktualisieren");
		this.btn_Aktualisieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ws.update();
				updateWeather(ws.getCityName());
			}
		});
		this.contentPane.add(this.btn_Aktualisieren, BorderLayout.SOUTH);
		
		this.list = new JList();
		this.list.setModel(listModel);
		this.contentPane.add(this.list, BorderLayout.CENTER);
		
		this.lbl_Imagelabel = new JLabel("");
		this.contentPane.add(this.lbl_Imagelabel, BorderLayout.WEST);
		
		for (String s : ws.getCityNames()) {
			final JMenuItem menuItem = new JMenuItem();
			menuItem.setText(s);
			
			menuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ws.setCityName(menuItem.getText());
					ws.update();
					updateWeather(ws.getCityName());
				}
			});
			
			mn_Stadt.add(menuItem);
		}
	}
	
		private void updateWeather(String city)
		{
			this.setTitle("Wetter Station - " + city);
			listModel.clear();

	        listModel.addElement("Stadt : " + ws.getCityName());
	        listModel.addElement("Code : " + ws.getCityCode());
	        listModel.addElement("Temperatur : " + ws.getTemperature() + "°C");
	        listModel.addElement("Feuchtigkeit : " + ws.getHumidity() + "%");
	        listModel.addElement("Sonnenaufgang : " + ws.getSunrise());
	        listModel.addElement("Sonnenuntergang : " + ws.getSunset()); 
	        
	        this.setIconImage(ws.getIcon().getImage());
	        
		}
	}
