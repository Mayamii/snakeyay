package snakegame.material;

import java.awt.Color;
import java.awt.Graphics;

import snakegame.ui.Util;

/*
 * Klasse ScoreEntry
 * Zum Registrieren, Speichern und Vergleichen von Punkten, die während des Spiels erreicht
 * werden
 */
public class ScoreEntry implements Comparable<ScoreEntry>
{
    private String _name;
    private int _score;

    /*
     * Punkteeintrag
     * @param name Name des Spielers
     * @param score erreichte Punktzahl des Spielers
     */
    public ScoreEntry(String name, int score)
    {
        _name = name;
        _score = score;
    }

    /*
     * Vergleich von Ergebnissen
     * @param o Punkteeintrag
     * @return Vergleich, ob der aktuelle Punktestand
     * größer, gleich oder kleiner als der zu vergleichende
     * Punkteeintrag ist
     */
    @Override
    public int compareTo(ScoreEntry o)
    {
        if (o._score > _score)
        {
            return 1;
        }
        else if (o._score < _score)
        {
            return -1;
        }
        else
        {
            return 0;
        }
    }

    /*
     * Wandelt den Punktestand und Namen in String um
     */
    @Override
    public String toString()
    {
        return _name + ";" + _score;

    }

    /*
     * @return liefert den formatierten String
     */
    public String getFormatString()
    {
        return _name + " " + _score;
    }

    /*
     * Zeichnet den Punktestand Eintrag
     * @param g Graphics
     * @param x X-Wert
     * @param y Y-Wert
     * @param rank optionaler Wert für den Rang
     */
    public void paint(Graphics g, int x, int y, int rank)
    {
        g.setColor(Color.WHITE);
        //hier kann man das Layout der Schrift ändern
        g.setFont(Util.MENUFONT);
        //wenn man noch rank dazu haben will das einfügen: rank + " " + 
        //(sah hässlich aus, daher rausgenommen)
        g.drawString(getFormatString(), x, y);

    }
}
