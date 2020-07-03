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
        //TO DO Werte Checken --> Positon wird nicht genutzt
        // width: multiple of 34 (34*23=782)
        //heigth; multiple of 23 (23*25 = 575)
        g.drawRect(64, 75, 782, 575);
        g.fillRect(64, 75, 782, 575);
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
