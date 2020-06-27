package snakegame.material;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.ImageIcon;

import snakegame.fachwert.Position;

public abstract class AbstractPaintable implements Paintable
{
    protected static final int GRIDSIZE = 25;
    protected static final int OFFSETY = 75;
    protected static final int OFFSETX = 25;
    protected Position _position;
    protected ImageIcon _image;

    protected AbstractPaintable(Position pos, ImageIcon ima)
    {
        _position = pos;
        _image = ima;
    }

    public void paint(Graphics g, Component frame)
    {
        _image.paintIcon(frame, g, getPosition().getX() * GRIDSIZE + OFFSETX,
                getPosition().getY() * GRIDSIZE + OFFSETY);
    }

    public int getX()
    {
        return getPosition().getX();
    }

    public int getY()
    {
        return getPosition().getY();
    }

    abstract public void update();

    public Position getPosition()
    {
        return _position;
    }

}
