package snakegame.material;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.ImageIcon;

import snakegame.fachwert.Position;

/*
 * Abstrakte Klasse AbstractPaintable
 * Liefert die benötigten Methoden
 */
public abstract class AbstractPaintable implements Paintable
{
    protected static final int GRIDSIZE = 25;
    protected static final int OFFSETY = 75;
    protected static final int OFFSETX = 25;
    protected Position _position;
    protected ImageIcon _image;

    /*
     * @param pos Position
     * @param ima ImageIcon
     */
    protected AbstractPaintable(Position pos, ImageIcon ima)
    {
        _position = pos;
        _image = ima;
    }

    /*
     * Paint-Methode
     * @param g Graphics
     * @param frame Component
     */
    public void paint(Graphics g, Component frame)
    {
        _image.paintIcon(frame, g, getX() * GRIDSIZE + OFFSETX,
                getY() * GRIDSIZE + OFFSETY);
    }

    /*
     * @return liefert x-Wert einer Position
     */
    public int getX()
    {
        return _position.getX();
    }

    /*
     * @return liefert y-Wert einer Position
     */
    public int getY()
    {
        return _position.getY();
    }

    /*
     * Update-Methode
     */
    abstract public void update();

    /*
     * @return liefert die Position
     */
    public Position getPosition()
    {
        return _position;
    }

    /*
     * @return liefert das ImageIcon
     */
    public ImageIcon getImage()
    {
        return _image;

    }
}
