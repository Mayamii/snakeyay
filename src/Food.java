import java.util.Random;

public class Food
{
    private Position _pos;
    private int _xPos;
    private int _yPos;
    private Random _random;

    public Food()
    {
        _xPos = _random.nextInt(34);
        _yPos = _random.nextInt(23);
        _pos = new Position(_xPos, _yPos);
    }

    public int getXPos()
    {
        return _xPos;
    }

    public int getYPos()
    {
        return _yPos;
    }
}
