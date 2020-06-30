package snakegame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import snakegame.fachwert.Position;

public class GameMenu {

	private Color _color;
	private Position _linksOben;
	private Position _rechtsUnten;
	List<MenuItem> _menuItems = new ArrayList<MenuItem>();
	
	public GameMenu(Position linksOben, Position rechtsUnten)
	{
		_linksOben = linksOben;
		_rechtsUnten = rechtsUnten;
		_color = Color.GREEN;
		
	}

	public void add(MenuItem newItem) {
		_menuItems.add(newItem);
		
	}

	public void paint(Graphics g) {
        g.setColor(Color.green);
        //TO DO Werte Checken
        g.drawRect(64, 72, 751, 577);
        g.fillRect(64, 72, 751, 577);
		for (MenuItem menuItem : _menuItems) {
			menuItem.paint(g);
		}
		
	}
}
