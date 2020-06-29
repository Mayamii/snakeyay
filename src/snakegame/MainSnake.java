package snakegame;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JRadioButton;

import snakegame.menu.mainMenu;

public class MainSnake
{
    public static void main(String[] args)
    {
    	mainMenu menu = new mainMenu();
		menu.setBounds(100, 100, 600, 600);
		menu.setTitle("Game Menu");
		menu.setVisible(true);
		menu.setSize(500, 400);    
		menu.setLayout(null);       
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		JRadioButton lab = new JRadioButton();
		lab.setBounds(50, 50, 150, 50);    
		menu.add(lab);   
		lab.setText("Labyrinth Mode");
		lab.setVisible(true);
		
		JRadioButton highscore = new JRadioButton();
		highscore.setBounds(50, 100, 150, 50);    
		menu.add(highscore);   
		highscore.setText("Highscore");
		highscore.setVisible(true);
		
		JRadioButton cookie = new JRadioButton();
		cookie.setBounds(50, 150, 150, 50);    
		menu.add(cookie);   
		cookie.setText("Cookie Mode");
		cookie.setVisible(true);
		
		JButton start = new JButton();
		start.setBounds(50, 225, 150, 50);
		menu.add(start);
		start.setText("Start Game");
		start.setVisible(true);
		
		JButton stop = new JButton();
		stop.setBounds(250, 225, 150, 50);
		menu.add(stop);
		stop.setText("Exit Game");
		stop.setVisible(true);
		
		ButtonGroup gameconfig = new ButtonGroup();  
		gameconfig.add(lab);
		gameconfig.add(highscore);
		gameconfig.add(cookie);
	
    	
    	
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
