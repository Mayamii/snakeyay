package snakegame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import snakegame.fachwert.Position;

public class ToggleMenuItem extends MenuItem
{
    private boolean _isOn;

    public ToggleMenuItem(String text, Position pos, boolean on)
    {
        super(text, pos);
        _isOn = on;
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
        g.drawString(_menuText + ": " + _isOn,
                _menuPosition.getX() * GRIDSIZE + OFFSETX,
                _menuPosition.getY() * GRIDSIZE + OFFSETY);

    }

    public void toggle()
    {
        _isOn = !_isOn;
    }
}
