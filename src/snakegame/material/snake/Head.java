package snakegame.material.snake;

import java.awt.Component;
import java.awt.Graphics;

import snakegame.fachwert.Position;
import snakegame.fachwert.enums.Direction;
import snakegame.fachwert.enums.PictureName;
import snakegame.material.AbstractPaintable;
import snakegame.service.ImageStore;

public class Head extends AbstractPaintable
{
    private Direction _direction;
    private boolean _godmode;
    private boolean _dirty;

    protected Head(Position pos)
    {
        super(pos, ImageStore.getImage(PictureName.HEADRIGHT));
        _direction = Direction.RIGHT;
        _godmode = false;
    }

    public void setGod(boolean godmode)
    {
        _godmode = godmode;
    }

    public void paint(Graphics g, Component frame)
    {

        _image = _godmode ? ImageStore.getImage(PictureName.WOWRIGHT)
                : ImageStore.getImage(PictureName.HEADRIGHT);

        if (_direction == Direction.LEFT)
        {
            _image = _godmode ? ImageStore.getImage(PictureName.WOWLEFT)
                    : ImageStore.getImage(PictureName.HEADLEFT);
        }
        if (_direction == Direction.UP)
        {
            _image = _godmode ? ImageStore.getImage(PictureName.WOWUP)
                    : ImageStore.getImage(PictureName.HEADUP);
        }
        if (_direction == Direction.DOWN)
        {
            _image = _godmode ? ImageStore.getImage(PictureName.WOWDOWN)
                    : ImageStore.getImage(PictureName.HEADDOWN);
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
        _dirty = false;
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
        if (dir == _direction || _dirty) return;

        if (!isUturn(dir))
        {
            _direction = dir;
            _dirty = true;
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

    public boolean getGod()
    {
        return _godmode;

    }

}
