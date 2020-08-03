package snakegame;

import java.awt.Color;

import javax.swing.JFrame;

/*
 * Hauptklasse für das SnakeSpiel
 */
public class MainSnake
{
    public static void main(String[] args)
    {

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
