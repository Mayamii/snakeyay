package snakegame;

import java.awt.Color;
import java.awt.Graphics;

import snakegame.fachwert.Position;

public class MenuItem
{

    private String _menuText;
    private boolean _selected;
    private Position _menuPosition;
    protected static final int GRIDSIZE = 25;
    protected static final int OFFSETY = 75;
    protected static final int OFFSETX = 25;

    public MenuItem(String menuText, Position position)
    {
        _menuText = menuText;
        _menuPosition = position;
        _selected = false;
    }

    public void paint(Graphics g)
    {
        g.setColor(Color.WHITE);
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
