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

    public GameMenu(Position linksOben, Position rechtsUnten)
    {
        _linksOben = linksOben;
        _rechtsUnten = rechtsUnten;
        _color = Color.GREEN;

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
        g.setColor(Color.green);
        //Das Spielfeld startet bei 25 und endet bei 850 --> 25+200 für den linken Rand und 850-200 für die rechte Begrenzung
        g.drawRect(225, 75, 450, 575);
        g.fillRect(225, 75, 450, 575);
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
        //wird niemals auftreten, weil wir immer mindestens ein Item hinzugefügen
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
