import java.awt.Component;
import java.awt.Graphics;

public class Head extends AbstractPaintable
{

    private Direction _direction;

    protected Head(Position pos)
    {
        super(pos, ImageStore.getImage(PictureName.HEADRIGHT));
        _direction = Direction.RIGHT;
    }

    public void paint(Graphics g, Component frame)
    {
        _image = ImageStore.getImage(PictureName.HEADRIGHT);
        //Diese ifKlammer braucht man nicht, da es per Default auf rightmouth.png gesetzt ist, um Nullpointer zu verhindern
        //        if (_snek.giveDirection() == Direction.RIGHT)
        //        {
        //            mouth = _rightMouth;
        //
        //        }
        if (_direction == Direction.LEFT)
        {
            _image = ImageStore.getImage(PictureName.HEADLEFT);
        }
        if (_direction == Direction.UP)
        {
            _image = ImageStore.getImage(PictureName.HEADUP);
        }
        if (_direction == Direction.DOWN)
        {
            _image = ImageStore.getImage(PictureName.HEADDOWN);
        }
        super.paint(g, frame);
    }

    public void move()
    {

        switch (_direction)
        {
        case RIGHT:
            _position = _position.moveRight();
            break;
        case LEFT:
            _position = _position.moveLeft();
            break;
        case UP:
            _position = _position.moveUp();
            break;
        case DOWN:
            _position = _position.moveDown();
            break;
        }
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

    @Override
    public void update()
    {
        move();
    }

}
