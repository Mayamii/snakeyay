package snakegame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import snakegame.fachwert.Position;

public class GameMenu
{

    private Color _color;
    private Position _linksOben;
    private Position _rechtsUnten;
    List<MenuItem> _menuItems = new ArrayList<MenuItem>();

    public GameMenu(Position linksOben, Position rechtsUnten,
            Color hintergrundfarbe)
    {
        _linksOben = linksOben;
        _rechtsUnten = rechtsUnten;
        _color = hintergrundfarbe;

    }

    public void add(MenuItem newItem)
    {
        if (_menuItems.isEmpty())
        {
            newItem.setSelected(true);
        }
        _menuItems.add(newItem);

    }

    public void paint(Graphics g)
    {
        g.setColor(_color);
        //Das Spielfeld startet bei 25 und endet bei 850 --> 25+200 f�r den linken Rand und 850-200 f�r die rechte Begrenzung
        g.drawRect(_linksOben.getX() * 20 + 25, _linksOben.getY() * 5 + 25,
                (_rechtsUnten.getX() - _linksOben.getX()) * 40 + 50,
                (_rechtsUnten.getY() - _linksOben.getY()) * 50 + 75);
        g.fillRect(_linksOben.getX() * 20 + 25, _linksOben.getY() * 5 + 25,
                (_rechtsUnten.getX() - _linksOben.getX()) * 40 + 50,
                (_rechtsUnten.getY() - _linksOben.getY()) * 50 + 75);
        for (MenuItem menuItem : _menuItems)
        {
            menuItem.paint(g);
        }
    }

    public MenuItem getSelectedItem()
    {
        for (MenuItem menuItem : _menuItems)
        {
            if (menuItem.getSelected())
            {
                return menuItem;
            }
        }
        //wird niemals auftreten, weil wir immer mindestens ein Item hinzugef�gen
        return null;
    }

    public void selectNext()
    {
        MenuItem aktuellesMenuItem;
        aktuellesMenuItem = getSelectedItem();
        int index = _menuItems.indexOf(aktuellesMenuItem);
        index = (index + 1) % _menuItems.size();
        MenuItem naechstesMenuItem;
        naechstesMenuItem = _menuItems.get(index);
        naechstesMenuItem.setSelected(true);
        aktuellesMenuItem.setSelected(false);
    }

    public void selectPrevious()
    {
        MenuItem aktuellesMenuItem;
        aktuellesMenuItem = getSelectedItem();
        int index = _menuItems.indexOf(aktuellesMenuItem);
        index = (index + _menuItems.size() - 1) % _menuItems.size();
        MenuItem vorherigesMenuItem;
        vorherigesMenuItem = _menuItems.get(index);
        vorherigesMenuItem.setSelected(true);
        aktuellesMenuItem.setSelected(false);

    }

}
