package snakegame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import snakegame.fachwert.Position;

public class MenuItem
{
    protected static final int GRIDSIZE = 5;
    protected static final int OFFSETY = 75;
    protected static final int OFFSETX = 25;

    protected String _menuText;
    protected boolean _selected;
    protected Position _menuPosition;

    public MenuItem(String menuText, Position position)
    {
        _menuText = menuText;
        _menuPosition = position;
        _selected = false;
    }

    public void paint(Graphics g)
    {
        g.setColor(Color.WHITE);
        //hier kann man das Layout der Schrift des Menus
        g.setFont(new Font("arial", Font.BOLD, 30));
        if (_selected)
        {
            g.setColor(Color.RED);
        }
        g.drawString(_menuText, _menuPosition.getX() * GRIDSIZE + OFFSETX,
                _menuPosition.getY() * GRIDSIZE + OFFSETY);

    }

    public String getText()
    {
        return _menuText;
    }

    public void setSelected(boolean b)
    {
        _selected = b;
    }

    public boolean getSelected()
    {
        return _selected;
    }

}
