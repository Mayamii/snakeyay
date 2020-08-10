package snakegame.startup;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;

import snakegame.ui.Gameplay;

public class MainSnake
{
    public static void main(String[] args)
    {
        try
        {
            GraphicsEnvironment ge = GraphicsEnvironment
                .getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT,
                    new File("./8-bit Arcade In.ttf")));
        }
        catch (IOException | FontFormatException e)
        {
            //Handle exception
        }
        JFrame frame = new JFrame();
        Gameplay _gameplay = new Gameplay();
        frame.setLocationRelativeTo(null);
        frame.setUndecorated(true);
        frame.setBounds(10, 10, 905, 700);
        frame.setBackground(Color.LIGHT_GRAY);
        frame.setResizable(false);
        frame.getContentPane()
            .add(_gameplay);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
