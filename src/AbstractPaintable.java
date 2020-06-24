import java.awt.Component;
import java.awt.Graphics;

import javax.swing.ImageIcon;

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
        _image.paintIcon(frame, g, _position.getX() * GRIDSIZE + OFFSETX,
                _position.getY() * GRIDSIZE + OFFSETY);
    }

    public int getX()
    {
        return _position.getX();
    }

    public int getY()
    {
        return _position.getY();
    }

    abstract public void update();

}
