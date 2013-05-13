import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Taschenrechner extends JFrame
{
    private JTextField txt_z1;
    private JTextField txt_z2;
    private JTextField txt_result;
    private JButton btn_add;
    private JButton btn_divide;

    public Taschenrechner()
    {
        txt_z1 = new JTextField(5);
        txt_z2 = new JTextField(5);
        txt_result = new JTextField(5);
        btn_add = new JButton("Plus");
        btn_divide = new JButton("Geteilt durch");

        btn_add.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    try
                    {
                        int z1 = Integer.parseInt(txt_z1.getText());
                        int z2 = Integer.parseInt(txt_z2.getText());

                        txt_result.setText(String.valueOf(z1 + z2));
                    }
                    catch(NumberFormatException ex)
                    {
                        JOptionPane.showMessageDialog(null, "Keine Zahl !");
                    }
                }
            });

        btn_divide.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    try
                    {
                        int z1 = Integer.parseInt(txt_z1.getText());
                        int z2 = Integer.parseInt(txt_z2.getText());

                        try{
                            txt_result.setText(String.valueOf(z1 / z2));
                        }
                        catch(ArithmeticException ex)
                        {
                            JOptionPane.showMessageDialog(null, "Division durch 0 !");
                        }
                    }
                    catch(NumberFormatException ex)
                    {
                        JOptionPane.showMessageDialog(null, "Keine Zahl !");
                    }
                }
            });

        setLayout(new FlowLayout());

        add(txt_z1);
        add(txt_z2);
        add(txt_result);
        add(btn_add);
        add(btn_divide);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args)
    {
        new Taschenrechner();
    }
}
