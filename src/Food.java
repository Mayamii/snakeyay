import java.util.Random;

public class Food
{
    private Position _pos;
    private int _xPos;
    private int _yPos;
    private Random _random;
    //    private int[] _enemyXPos = new int[34];
    //
    //    private int[] _enemyYPos = new int[25];

    public Food()
    {
        _random = new Random();
        _xPos = _random.nextInt(34);
        _yPos = _random.nextInt(23);
        _pos = new Position(_xPos, _yPos);
    }

    public int getFoodX()
    {
        return _pos.getX();
    }

    public int getFoodY()
    {
        return _pos.getY();
    }
}
