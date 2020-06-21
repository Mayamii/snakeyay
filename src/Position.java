
public final class Position
{
    private final int _xpos;
    private final int _ypos;

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
        if (xpos > 33)
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
            xpos = 33;
        }
        return new Position(xpos, _ypos);
    }

    public Position moveUp()
    {
        int ypos = _ypos - 1;
        if (ypos < 0)
        {
            ypos = 19;
        }
        return new Position(_xpos, ypos);
    }

    public Position moveDown()
    {
        int ypos = _ypos + 1;
        if (ypos > 19)
        {
            ypos = 0;
        }
        return new Position(_xpos, ypos);
    }
}
