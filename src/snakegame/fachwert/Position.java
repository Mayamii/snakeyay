package snakegame.fachwert;

import java.util.Random;

/*
 * Fachwert-Klasse f�r die Position.
 * Eine Position besteht aus x und y Koordinaten.
 */

public final class Position
{
    private final int _xpos;
    private final int _ypos;
    private static Random _random = new Random();

    private static final int FIELDWIDTH = 34;
    private static final int FIELDHEIGHT = 23;

    /*
     * @param x eine Variable f�r die x-Position 
     * @param y eine Variable f�r die y-Position 
     * 
     */
    public Position(int x, int y)
    {
        _xpos = x;
        _ypos = y;
    }

    /*
     * @return x-Position
     */
    public int getX()
    {
        return _xpos;
    }

    /*
     * @return y-Position
     */
    public int getY()
    {
        return _ypos;
    }

    /*
     * Bewegung nach rechts. Ver�ndert die x-Position
     * @return die neue Position mit den neuen Werten
     * nach der Bewegung nach rechts
     * 
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
     * Bewegung nach links. Ver�ndert die x-Position
     * @return die neue Position mit den neuen Werten
     * nach der Bewegung nach links
     * 
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
     * Bewegung nach oben. Ver�ndert die y-Position
     * @return die neue Position mit den neuen Werten
     * nach der Bewegung nach oben
     * 
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
     * Bewegung nach unten. Ver�ndert die y-Position
     * @return die neue Position mit den neuen Werten
     * nach der Bewegung nach unten
     * 
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
     * Erzeugt eine zuf�llige Position
     * @return Position, die zuf�llig erzeugt wurde
     */
    public static Position randomPos()
    {
        return new Position(_random.nextInt(FIELDWIDTH),
                _random.nextInt(FIELDHEIGHT));
    }
}
