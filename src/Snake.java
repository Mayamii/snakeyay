import java.awt.Component;
import java.awt.Graphics;

public class Snake implements Paintable
{
    private boolean _moving;
    private Head _head;
    private Tail _tail;

    public Snake(Position pos)
    {
        _head = new Head(pos);
        _tail = new Tail(pos, ImageStore.getImage("snake"));

        _moving = false;
    }

    public int getLength()
    {
        return _tail.getLength() + 1;
    }

    public void move()
    {
    }

    public void eats()
    {
        _tail.growenable();
    }

    public int getHeadX()
    {
        return _head.getX();
    }

    public int getHeadY()
    {
        return _head.getY();
    }

    public void setMove(boolean enabled)
    {
        _moving = enabled;
    }

    @Override
    public void paint(Graphics g, Component frame)
    {
        _head.paint(g, frame);
        _tail.paint(g, frame);
    }

    @Override
    public void update()
    {
        _tail.setNextPosition(_head._position);
        _tail.update();
        _head.update();
    }

    @Override
    public int getX()
    {
        return 0;
    }

    @Override
    public int getY()
    {
        return 0;
    }

    public void setDirection(Direction dir)
    {
        _head.setDirection(dir);

    }

    public int getBodyX(int bodymassindex)
    {

        return _tail.getBodyX(bodymassindex);
    }

    public int getBodyY(int bodymassindex)
    {

        return _tail.getBodyY(bodymassindex);
    }

}
