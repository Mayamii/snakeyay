import java.awt.Color;

import javax.swing.JFrame;

public class MainSnek
{
    public static void main(String[] args)
    {
        JFrame _obj = new JFrame();
        Gameplay _gameplay = new Gameplay();
        _obj.setBounds(10, 10, 905, 700);
        _obj.setBackground(Color.LIGHT_GRAY);
        _obj.setResizable(false);
        _obj.setVisible(true);
        _obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _obj.add(_gameplay);
    }
}
