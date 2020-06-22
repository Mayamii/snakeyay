import java.util.LinkedList;

public class Snake implements Paintable
{
    private LinkedList<Position> _body;
    private Direction _direction;
    private boolean _hasFood;
    private boolean _moving;
    private Head _head;
    private Tail _tail;

    public Snake(Position pos)
    {
        _direction = Direction.RIGHT;
        _head = new Position(pos.getX(), pos.getY());
        _body = new LinkedList<>();
        _body.add(new Position(pos.getX() - 1, pos.getY()));
        _body.add(new Position(pos.getX() - 2, pos.getY()));
        _hasFood = false;
        _moving = false;
    }

    public int getLength()
    {
        return _body.size() + 1;
    }

    public void move()
    {
        if (_moving)
        {
            Position _oldHead = _head;
            switch (_direction)
            {
            case RIGHT:
                _head = _head.moveRight();
                break;
            case LEFT:
                _head = _head.moveLeft();
                break;
            case UP:
                _head = _head.moveUp();
                break;
            case DOWN:
                _head = _head.moveDown();
                break;
            }
            _body.add(0, _oldHead);
            if (!_hasFood)
            {
                _body.remove(getLength() - 2);
            }
            _hasFood = false;
        }
    }

    public void eats()
    {
        _hasFood = true;
    }

    private boolean isUturn(Direction dir)
    {
        return (_direction == Direction.RIGHT && dir == Direction.LEFT
                || _direction == Direction.LEFT && dir == Direction.RIGHT
                || _direction == Direction.UP && dir == Direction.DOWN
                || _direction == Direction.DOWN && dir == Direction.UP);
    }

    public void setDirection(Direction dir)
    {
        if (!isUturn(dir))
        {
            _direction = dir;
        }

    }

    public Direction getDirection()
    {
        return _direction;
    }

    public int getHeadX()
    {
        return _head.getX();
    }

    public int getHeadY()
    {
        return _head.getY();
    }

    public int getBodyX(int index)
    {
        return _body.get(index)
            .getX();
    }

    public int getBodyY(int index)
    {
        return _body.get(index)
            .getY();
    }

    public void setMove(boolean enabled)
    {
        _moving = enabled;
    }

}
