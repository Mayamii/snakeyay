package snakegame.menu;

	import java.awt.*; 
	import javax.swing.*; 
	import java.awt.event.*;
	import java.util.Dictionary;


	public class mainMenu extends JFrame{
		JRadioButton lab;
		JRadioButton highscore;
		JRadioButton cookie;
		JButton start = new JButton("Start");
		JButton exit = new JButton("Exit");
		ButtonGroup gameconfig;
		JPanel radioButtons;
		JPanel startstop;
		public Boolean confirmed;
		public GameMode mode;
		
		public void mainMenu() {

			confirmed = false;
			lab = new JRadioButton();
			lab.setText("Labyrinth Mode");
			highscore = new JRadioButton();
			highscore.setText("show Highscore");
			cookie = new JRadioButton();
			cookie.setText("Cookie Mode");
			start = new JButton("Start");
			exit = new JButton("Exit");
			gameconfig = new ButtonGroup();  
			gameconfig.add(lab);
			gameconfig.add(highscore);
			gameconfig.add(cookie);
			
			startstop = new JPanel();
			startstop.add(start);
			startstop.add(exit);
			
			radioButtons = new JPanel();
			radioButtons.setBounds(10, 10, 200, 200);
			radioButtons.setLayout(new BoxLayout(radioButtons, BoxLayout.Y_AXIS));
			radioButtons.add(cookie);
			radioButtons.add(lab);
			radioButtons.add(highscore);
			
			
			Container c = new JPanel();
			c.setLayout(null);
			c.add(radioButtons, BorderLayout.NORTH);
			c.add(startstop, BorderLayout.SOUTH);
			//this.setContentPane(c);
			
			start.setBounds(200, 200, 50, 50);
			this.add(start);
			this.add(exit);
			
			start.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) 
	            {                
	                if (lab.isSelected()) {
	                	mode = GameMode.LABYRINTH;
	                }
	                else if (highscore.isSelected()) {
	                	mode = GameMode.HIGHSCORE;
	                }
	                else if (cookie.isSelected()) {
	                	mode = GameMode.COOKIE;
	                }
	                else {
	                	mode = GameMode.ERROR;
	                }
	                confirmed = true;
	                
	            }
			});
			
		}



}
