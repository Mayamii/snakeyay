package snakegame.ui;

import java.awt.Component;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import snakegame.fachwert.Position;
import snakegame.fachwert.enums.MenuText;
import snakegame.fachwert.enums.PictureName;
import snakegame.service.ImageStore;

public class GameMenu
{

    private ImageIcon _image;
    private Position _linksOben;
    List<MenuItem> _menuItems = new ArrayList<MenuItem>();

    public GameMenu(Position linksOben, Position rechtsUnten)
    {
        _linksOben = linksOben;
        _image = ImageStore.getImage(PictureName.MENU);

    }

    public void add(MenuItem newItem)
    {
        if (_menuItems.isEmpty())
        {
            newItem.setSelected(true);
        }
        _menuItems.add(newItem);
    }

    public void paint(Graphics g, Component c)
    {
        _image.paintIcon(c, g, _linksOben.getX(), _linksOben.getY());

        //Das Spielfeld startet bei 25 und endet bei 850 --> 25+200 f�r den linken Rand und 850-200 f�r die rechte Begrenzung

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

    public MenuItem getMenuItemBy(MenuText text)
    {
        for (MenuItem menuItem : _menuItems)
        {
            if (menuItem.getText() == text) return menuItem;
        }
        return null;
    }

}
