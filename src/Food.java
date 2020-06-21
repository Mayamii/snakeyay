public class Food
{
    private Position _pos;

    public Food()
    {
        _pos = Position.randomPos();
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
