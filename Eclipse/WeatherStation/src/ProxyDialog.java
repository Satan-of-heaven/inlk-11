import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ProxyDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ProxyDialog dialog = new ProxyDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ProxyDialog() {
		initialize();
	}
	private void initialize() {
		setResizable(false);
		setTitle("Proxy Einstellungen");
		setBounds(100, 100, 450, 193);
		getContentPane().setLayout(new BorderLayout());
		this.contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(this.contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(4, 1, 0, 4));
		{
			final JLabel lbl_host = new JLabel("Host :");
			contentPanel.add(lbl_host);
		}
		{
			final JTextPane txt_host = new JTextPane();
			contentPanel.add(txt_host);
		}
		{
			final JLabel lbl_port = new JLabel("Port :");
			contentPanel.add(lbl_port);
		}
		{
			final JTextPane txt_port = new JTextPane();
			contentPanel.add(txt_port);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton ok_Button = new JButton("Anwenden");
				ok_Button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				ok_Button.setActionCommand("OK");
				buttonPane.add(ok_Button);
				getRootPane().setDefaultButton(ok_Button);
			}
			{
				JButton cancel_Button = new JButton("Abbrechen");
				cancel_Button.setActionCommand("Cancel");
				buttonPane.add(cancel_Button);
			}
		}
	}

}
