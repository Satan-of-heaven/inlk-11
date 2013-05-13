import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.util.*;

public class EditorGui extends JFrame
{
    private JButton btn_save;
    private JButton btn_open;
    private JTextArea txt_text;

    public EditorGui()
    {
        super("Editor, der funktioniert");

        setLayout(new FlowLayout());

        btn_open = new JButton("Öffnen");
        btn_save = new JButton("Speichern");
        txt_text = new JTextArea(10, 10);

        btn_open.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    open();
                }
            });

        btn_save.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    save();
                }
            });

        add(btn_open);
        add(btn_save);
        add(txt_text);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new EditorGui();
    }

    private void save()
    {
        JFileChooser fc = new JFileChooser();
        int counter = 3;
        boolean success = false;

        while(counter > 0 && !success)
        {
            if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();

                BufferedWriter writer = null;
                try
                {
                    writer = new BufferedWriter( new FileWriter(file.getAbsolutePath()));
                    writer.write(txt_text.getText());

                    success = true;
                }
                catch ( IOException ex)
                {
                    JOptionPane.showMessageDialog(this, ex.toString());
                    counter--;
                }
                finally
                {
                    try
                    {
                        if ( writer != null)
                            writer.close( );
                    }
                    catch ( IOException ex)
                    {
                        JOptionPane.showMessageDialog(this, ex.toString());
                    }
                }

            } else {
                break;
            }
        }
    }

    private void open()
    {
        JFileChooser fc = new JFileChooser();
        int counter = 3;
        boolean success = false;

        txt_text.setText("");

        while(counter > 0 && !success)
        {
            if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();

                StringBuilder text = new StringBuilder();
                Scanner scanner = null;
                try {
                    scanner = new Scanner(new FileInputStream(file.getAbsolutePath()));
                    while (scanner.hasNextLine()){
                        text.append(scanner.nextLine() + "\n");
                    }

                    txt_text.setText(text.toString());
                    success = true;
                }
                catch(IOException ex)
                {
                    JOptionPane.showMessageDialog(this, ex.toString());
                    counter--;
                }
                finally{
                    if(scanner != null)
                        scanner.close();
                }

            } else {
                break;
            }
        }
    }
}
