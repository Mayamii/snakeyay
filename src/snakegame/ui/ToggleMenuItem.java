package snakegame.ui;

import java.awt.Color;
import java.awt.Graphics;

import snakegame.fachwert.Position;
import snakegame.fachwert.enums.MenuText;

/*
 * Klasse zum Aktivieren und Deaktivieren von MenuItems
 * Beispielsweise Music und Sound, die an- oder ausgeschaltet sein k�nnen
 */
public class ToggleMenuItem extends MenuItem
{
    private boolean _isOn;

    /*
     * An- und Abschalten eines gew�hlten MenuItems
     * @param text MenuText, der ausgew�hlt wird
     * @param pos Position des Textes
     * @param on gibt an, ob Schalter aktiviert ist oder nicht
     */
    public ToggleMenuItem(MenuText text, Position pos, boolean on)
    {
        super(text, pos);
        _isOn = on;
    }

    /*
     * Zeichnet das gew�hlte MenuItem 
     * Wenn es ausgew�hlt ist, wird es rot angezeigt
     * @param g Graphics
     */
    public void paint(Graphics g)
    {
        g.setColor(Color.WHITE);
        //hier kann man das Layout der Schrift des Menus
        g.setFont(Util.MENUFONT);
        if (_selected)
        {
            g.setColor(Color.RED);
        }
        g.drawString(formatiereAusgabe(),
                _menuPosition.getX() * GRIDSIZE + OFFSETX,
                _menuPosition.getY() * GRIDSIZE + OFFSETY);

    }

    /*
     * An- und Auschhalten
     */
    public void toggle()
    {
        _isOn = !_isOn;
    }

    /*
     * @return gibt einen formatierten String zur�ck
     * Schreibt direkt in das Menu, ob das Item aktiviert ist oder deaktiviert 
     * (On oder off hinter den Namen des MenuItems)
     */
    private String formatiereAusgabe()
    {
        return String.format("%s  %s", _menuText.getText(),
                _isOn ? "ON" : "OFF");
    }
}
