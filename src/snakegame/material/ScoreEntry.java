package snakegame.material;

import java.awt.Color;
import java.awt.Graphics;

import snakegame.ui.Util;

public class ScoreEntry implements Comparable<ScoreEntry>
{
    private String _name;
    private int _score;

    public ScoreEntry(String name, int score)
    {
        _name = name;
        _score = score;
    }

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

    @Override
    public String toString()
    {
        return _name + ";" + _score;

    }

    public String getFormatString()
    {
        return _name + " " + _score;
    }

    public void paint(Graphics g, int x, int y, int rank)
    {
        g.setColor(Color.WHITE);
        //hier kann man das Layout der Schrift des Menus
        g.setFont(Util.MENUFONT);

        g.drawString(rank + " " + getFormatString(), x, y);

    }
}
