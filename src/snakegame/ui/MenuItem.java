package snakegame.ui;

import java.awt.Color;
import java.awt.Graphics;

import snakegame.fachwert.Position;
import snakegame.fachwert.enums.MenuText;

public class MenuItem
{
    protected static final int GRIDSIZE = 5;
    protected static final int OFFSETY = 75;
    protected static final int OFFSETX = -40;

    protected MenuText _menuText;
    protected boolean _selected;
    protected Position _menuPosition;

    public MenuItem(MenuText text, Position position)
    {
        _menuText = text;
        _menuPosition = position;
        _selected = false;
    }

    public void paint(Graphics g)
    {
        g.setColor(Color.WHITE);
        //hier kann man das Layout der Schrift des Menus
        g.setFont(Util.MENUFONT);
        if (_selected)
        {
            g.setColor(Color.RED);
        }
        g.drawString(_menuText.getText(),
                _menuPosition.getX() * GRIDSIZE + OFFSETX,
                _menuPosition.getY() * GRIDSIZE + OFFSETY);

    }

    public MenuText getText()
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
