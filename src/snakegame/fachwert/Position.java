package snakegame.fachwert;
import java.util.Random;

public final class Position
{
    private final int _xpos;
    private final int _ypos;
    private static Random _random = new Random();

    private static final int FIELDWIDTH = 34;
    private static final int FIELDHEIGHT = 23;

    public Position(int x, int y)
    {
        _xpos = x;
        _ypos = y;
    }

    public int getX()
    {
        return _xpos;
    }

    public int getY()
    {
        return _ypos;
    }

    public Position moveRight()
    {
        int xpos = _xpos + 1;
        if (xpos > FIELDWIDTH - 1)
        {
            xpos = 0;
        }
        return new Position(xpos, _ypos);

    }

    public Position moveLeft()
    {
        int xpos = _xpos - 1;
        if (xpos < 0)
        {
            xpos = FIELDWIDTH - 1;
        }
        return new Position(xpos, _ypos);
    }

    public Position moveUp()
    {
        int ypos = _ypos - 1;
        if (ypos < 0)
        {
            ypos = FIELDHEIGHT - 1;
        }
        return new Position(_xpos, ypos);
    }

    public Position moveDown()
    {
        int ypos = _ypos + 1;
        if (ypos > FIELDHEIGHT - 1)
        {
            ypos = 0;
        }
        return new Position(_xpos, ypos);
    }

    public static Position randomPos()
    {
        return new Position(_random.nextInt(FIELDWIDTH),
                _random.nextInt(FIELDHEIGHT));
    }
}
