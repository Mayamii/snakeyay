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

/*
 * Klasse f�r die Game Men�s
 */
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

    /*
     * F�gt ein neues Element zu der MenuItem Liste hinzu
     * @param newItem neues MenuItem, was hinzugef�gt werden soll
     */
    public void add(MenuItem newItem)
    {
        if (_menuItems.isEmpty())
        {
            newItem.setSelected(true);
        }
        _menuItems.add(newItem);
    }

    /*
     * Zeichnet das Menu
     * @param g Graphics
     * @param c Component 
     */
    public void paint(Graphics g, Component c)
    {
        _image.paintIcon(c, g, _linksOben.getX(), _linksOben.getY());

        //Das Spielfeld startet bei 25 und endet bei 850 --> 25+200 f�r den linken Rand und 850-200 f�r die rechte Begrenzung

        for (MenuItem menuItem : _menuItems)
        {
            menuItem.paint(g);
        }
    }

    /*
     * @return liefert das ausgew�hlte Item des Menus zur�ck
     */
    public MenuItem getSelectedItem()
    {
        for (MenuItem menuItem : _menuItems)
        {
            if (menuItem.getSelected())
            {
                return menuItem;
            }
        }
        //wird niemals auftreten, weil wir immer mindestens ein Item hinzuf�gen
        return null;
    }

    /*
     * W�hlt das n�chste MenuItem aus
     */
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

    /*
     * W�hlt das vorherige MenuItem aus
     */
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

    /*
     * Gibt das MenuItem Item mit dem eingegeben Namen aus
     * @param text Name des MenuItems
     */
    public MenuItem getMenuItemBy(MenuText text)
    {
        for (MenuItem menuItem : _menuItems)
        {
            if (menuItem.getText() == text) return menuItem;
        }
        return null;
    }

}
