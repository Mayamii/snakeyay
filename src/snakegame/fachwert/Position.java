package snakegame.fachwert;

import java.util.Random;

/*
 * Fachwert-Klasse für die Position.
 */
public final class Position
{
    //x-Position
    private final int _xpos;
    //y-Position
    private final int _ypos;
    //Random
    private static Random _random = new Random();
    //festgelegte Feldgröße angepasst an die aktuell verwendete Grafiken
    private static final int FIELDWIDTH = 34;
    private static final int FIELDHEIGHT = 23;

    /*
     * 
     * @param x x-Wert
     * @param y y-Wert
     */
    public Position(int x, int y)
    {
        _xpos = x;
        _ypos = y;
    }

    /* 
     * Liefert die x-Positon
     * @return gibt die x-Position zurück
     */
    public int getX()
    {
        return _xpos;
    }

    /* 
     * Liefert die y-Positon
     * @return gibt die y-Position zurück
     */
    public int getY()
    {
        return _ypos;
    }

    /* 
     * Änderung der Position bei einer Bewegung nach rechts
     */
    public Position moveRight()
    {
        int xpos = _xpos + 1;
        if (xpos > FIELDWIDTH - 1)
        {
            xpos = 0;
        }
        return new Position(xpos, _ypos);

    }

    /*
     * Änderung der Position bei einer Bewegung nach links
     */
    public Position moveLeft()
    {
        int xpos = _xpos - 1;
        if (xpos < 0)
        {
            xpos = FIELDWIDTH - 1;
        }
        return new Position(xpos, _ypos);
    }

    /*
     * Änderung der Position bei einer Bewegung nach oben
     */
    public Position moveUp()
    {
        int ypos = _ypos - 1;
        if (ypos < 0)
        {
            ypos = FIELDHEIGHT - 1;
        }
        return new Position(_xpos, ypos);
    }

    /*
     * Änderung der Position bei einer Bewegung nach unten
     */
    public Position moveDown()
    {
        int ypos = _ypos + 1;
        if (ypos > FIELDHEIGHT - 1)
        {
            ypos = 0;
        }
        return new Position(_xpos, ypos);
    }

    /*
     * Erzeugt eine zufällige Position
     */
    public static Position randomPos()
    {
        return new Position(_random.nextInt(FIELDWIDTH),
                _random.nextInt(FIELDHEIGHT));
    }
}
