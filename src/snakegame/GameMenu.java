package snakegame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import snakegame.fachwert.Position;

/*
 * Diese Klasse modelliert das GameMenu 
 * Es gibt mehrere Spiel Modi, die mithilfe dieser Klasse aktiviert werden können
 */
public class GameMenu
{
    // Die Hintergrundfarbe des GameMenu 
    private Color _color;
    // Die linke obere Ecke des GameMenu
    private Position _linksOben;
    // Die rechte untere Ecke des GameMenu
    private Position _rechtsUnten;
    // Der x-Offset
    private static final int OFFSETX = 25;
    // Der y-Offset
    private static final int OFFSETY = 75;
    // Die Höhe des Feldes
    private static final int FIELDHEIGHT = 23;

    /*
     * Liste der erzeugten MenuItems
     */
    List<MenuItem> _menuItems = new ArrayList<MenuItem>();

    /*
     * Zeichnet das GameMenu an die gewüsnschte Stelle 
     * @param linksOben obere linke Ecke des Menus
     * @param rechtsUnten untere rechte Ecke des Menus
     * @param hintergrundfarbe Hintergrundfarbe des Menus
     */
    public GameMenu(Position linksOben, Position rechtsUnten,
            Color hintergrundfarbe)
    {
        _linksOben = linksOben;
        _rechtsUnten = rechtsUnten;
        _color = hintergrundfarbe;

    }

    /*
     * Fügt ein neues Menu zu der Liste hinzu
     * Markiert dieses als ausgewähltes Element
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
     */
    public void paint(Graphics g)
    {
        g.setColor(_color);
        //Das Spielfeld startet bei 25 und endet bei 850 --> 25+200 fï¿½r den linken Rand und 850-200 fï¿½r die rechte Begrenzung
        g.drawRect(225, 75, 450, 574);
        g.fillRect(225, 75, 450, 574);
        for (MenuItem menuItem : _menuItems)
        {
            menuItem.paint(g);
        }
    }

    /*
     * Gibt das aktuell ausgewählte MenuItem zurück
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
        //wird niemals auftreten, weil wir immer mindestens ein Item hinzugefï¿½gen
        return null;
    }

    /*
     * Wählt das nächste MenuItem aus
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
     * Wählt das vorherige MenuItem aus
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

}
