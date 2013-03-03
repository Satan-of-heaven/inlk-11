import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MusicGui extends JFrame implements MusicPlayerListener
{
    private JButton btn_play;
    private JButton btn_stop;
    private JButton btn_open;
    private JTextField txt_file;
    private JLabel lbl_progress;

    private MusicPlayer mp;

    public MusicGui()
    {
        mp = new MusicPlayer();
        
        mp.addListener(this);

        setLayout(new FlowLayout());

        btn_play = new JButton("Play");
        btn_stop = new JButton("Stop");
        btn_open = new JButton("Öffnen");
        txt_file = new JTextField(25);
        lbl_progress = new JLabel("0%");

        btn_open.addActionListener(new Btn_open_Clicked());
        btn_play.addActionListener(new Btn_play_Clicked());
        btn_stop.addActionListener(new Btn_stop_Clicked());

        add(txt_file);
        add(btn_open);
        add(btn_play);
        add(btn_stop);
        add(lbl_progress);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
    public static void main(String[] args)
    {
        new MusicGui();
    }

    public void positionChanged(int newPosition)
    {
        lbl_progress.setText(String.valueOf(newPosition) + "%");
    }

    private class Btn_open_Clicked implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            mp.open(txt_file.getText());
        }
    }

    private class Btn_play_Clicked implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            mp.play();
        }
    }

    private class Btn_stop_Clicked implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            mp.stop();
        }
    }
}
