package snakegame.material.snake;

import java.awt.Component;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import snakegame.fachwert.Position;
import snakegame.material.AbstractPaintable;
import snakegame.material.Paintable;

public class Tail extends AbstractPaintable implements Paintable
{

    private LinkedList<Position> _body;
    private boolean _growplease = false;
    private Position _nextPosition;
    private Position _lastPiece;
    private int _growLength;

    protected Tail(Position pos, ImageIcon ima)
    {
        super(pos, ima);
        _body = new LinkedList<>();
        _body.add(new Position(pos.getX() - 1, pos.getY()));
        _body.add(new Position(pos.getX() - 2, pos.getY()));
        _growLength = 0;
    }

    public int getLength()
    {
        return _body.size();
    }

    public void move()
    {
        _body.addFirst(_nextPosition);
        _body.removeLast();

    }

    public void update()
    {
        _lastPiece = _body.getLast();
        move();
        if (_growplease)
        {
            for (int i = _growLength; i <= 0; i--)
            {
                grows();
            }
            _growplease = false;
        }
    }

    public void grows()
    {
        _body.addLast(_lastPiece);

    }

    public void growenable(int i)
    {
        _growplease = true;
        _growLength = i;
    }

    public void setNextPosition(Position position)
    {
        _nextPosition = position;
    }

    public int getBodyX(int bodymassindex)
    {
        return _body.get(bodymassindex)
            .getX();

    }

    public int getBodyY(int bodymassindex)
    {
        return _body.get(bodymassindex)
            .getY();
    }

    @Override
    public void paint(Graphics g, Component frame)
    {
        for (int b = 0; b < getLength(); b++)
        {

            _image.paintIcon(frame, g, getBodyX(b) * GRIDSIZE + OFFSETX,
                    getBodyY(b) * GRIDSIZE + OFFSETY);
        }
    }
}
