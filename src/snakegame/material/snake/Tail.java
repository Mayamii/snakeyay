package snakegame.material.snake;

import java.awt.Component;
import java.awt.Graphics;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import snakegame.fachwert.Position;
import snakegame.fachwert.enums.PictureName;
import snakegame.material.AbstractPaintable;
import snakegame.material.Paintable;
import snakegame.service.ImageStore;

public class Tail extends AbstractPaintable implements Paintable
{

    private LinkedList<Position> _body;
    private Position _nextPosition;
    private Position _lastPiece;
    private int _growLength;
    private boolean _godmode;

    protected Tail(Position pos, ImageIcon ima)
    {
        super(pos, ima);
        _body = new LinkedList<>();
        _body.add(new Position(pos.getX() - 1, pos.getY()));
        _body.add(new Position(pos.getX() - 2, pos.getY()));
        _growLength = 0;
        _godmode = false;
    }

    public void setGod(boolean godmode)
    {
        _godmode = godmode;
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
        if (_growLength > 0)
        {

            grows();
            _growLength--;

        }
    }

    public void grows()
    {
        _body.addLast(_lastPiece);

    }

    public void growenable(int i)
    {

        _growLength += i;
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

            if (_godmode)
            {
                int counter = b % 8;

                switch (counter)
                {
                case 0:
                    ImageStore.getImage(PictureName.RED)
                        .paintIcon(frame, g, getBodyX(b) * GRIDSIZE + OFFSETX,
                                getBodyY(b) * GRIDSIZE + OFFSETY);
                    break;

                case 1:
                    ImageStore.getImage(PictureName.ORANGE)
                        .paintIcon(frame, g, getBodyX(b) * GRIDSIZE + OFFSETX,
                                getBodyY(b) * GRIDSIZE + OFFSETY);
                    break;
                case 2:
                    ImageStore.getImage(PictureName.YELLOW)
                        .paintIcon(frame, g, getBodyX(b) * GRIDSIZE + OFFSETX,
                                getBodyY(b) * GRIDSIZE + OFFSETY);
                    break;
                case 3:
                    _image.paintIcon(frame, g, getBodyX(b) * GRIDSIZE + OFFSETX,
                            getBodyY(b) * GRIDSIZE + OFFSETY);
                    break;
                case 4:
                    ImageStore.getImage(PictureName.BLUE)
                        .paintIcon(frame, g, getBodyX(b) * GRIDSIZE + OFFSETX,
                                getBodyY(b) * GRIDSIZE + OFFSETY);
                    break;
                case 5:
                    ImageStore.getImage(PictureName.INDIGO)
                        .paintIcon(frame, g, getBodyX(b) * GRIDSIZE + OFFSETX,
                                getBodyY(b) * GRIDSIZE + OFFSETY);
                    break;
                case 6:
                    ImageStore.getImage(PictureName.PURPLE)
                        .paintIcon(frame, g, getBodyX(b) * GRIDSIZE + OFFSETX,
                                getBodyY(b) * GRIDSIZE + OFFSETY);
                    break;
                case 7:
                    ImageStore.getImage(PictureName.PINK)
                        .paintIcon(frame, g, getBodyX(b) * GRIDSIZE + OFFSETX,
                                getBodyY(b) * GRIDSIZE + OFFSETY);
                    break;
                }
            }
            else
            {
                _image.paintIcon(frame, g, getBodyX(b) * GRIDSIZE + OFFSETX,
                        getBodyY(b) * GRIDSIZE + OFFSETY);
            }
        }
    }

}