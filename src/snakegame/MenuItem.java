package snakegame;

import java.awt.Color;
import java.awt.Graphics;

import snakegame.fachwert.Position;

public class MenuItem {

	private String _menuText;
	private boolean _selected;
	private Position _menuPosition;
	
	public MenuItem(String menuText, Position position)
	{
		_menuText = menuText;
		_menuPosition = position;
		_selected = false;
	}

	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		if (_selected)
		{
			g.setColor(Color.RED);
		}
		g.drawString(_menuText, _menuPosition.getX(), _menuPosition.getY());
		
	}
	
	public String getText() {
		return _menuText;
	}
	
	public void setSelected(boolean b) {
		_selected = b;
	}
	
	public boolean getSelected() {
		return _selected;
	}
}

