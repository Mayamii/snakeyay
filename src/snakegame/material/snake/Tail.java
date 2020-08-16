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

/*
 * Tail-Klasse der Schlange
 */
public class Tail extends AbstractPaintable implements Paintable
{

    private LinkedList<Position> _body;
    private Position _nextPosition;
    private Position _lastPiece;
    private int _growLength;
    private boolean _godmode;

    /*
     * Erstellt eine Schlange an der Position pos mit dem ImageIcon ima
     * @param pos Positionen der Schlange
     */
    protected Tail(Position pos, ImageIcon ima)
    {
        super(pos, ima);
        _body = new LinkedList<>();
        _body.add(new Position(pos.getX() - 1, pos.getY()));
        _body.add(new Position(pos.getX() - 2, pos.getY()));
        _growLength = 0;
        _godmode = false;
    }

    /*
     * Setzt den Gottmodus auf den eingegebenen Boolean
     * @param godmode setzt den Gottmodus
     */
    public void setGod(boolean godmode)
    {
        _godmode = godmode;
    }

    /*
     * Liefert die Länge der Schlange
     * @return die Länge der Schlange
     */
    public int getLength()
    {
        return _body.size();
    }

    /*
     * Bewegt die Schlange um einen Kasten auf die nächste Position
     * Die letzte hintere Position wird dabei "entfernt" und vorne eine neue hinzugefügt
     */
    public void move()
    {
        _body.addFirst(_nextPosition);
        _body.removeLast();

    }

    /*
     * update
     */
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

    /*
     * Wachstum der Schlange am hinteren
     * Ende der Schlange
     */
    public void grows()
    {
        _body.addLast(_lastPiece);

    }

    /*
     * Erhöhen der Länge um den Integer i
     * @param i Wert, um den die Länge erhöht werden soll
     */
    public void growenable(int i)
    {

        _growLength += i;
    }

    /*
     * @param position nächste Position
     */
    public void setNextPosition(Position position)
    {
        _nextPosition = position;
    }

    /*
     * @param bodymassindex Mächtigkeit der Schlange
     * @return liefert die x-Position des Tails, 
     * für eine bestimmte Mächtigkeit bzw. Länge der Schlange
     */
    public int getBodyX(int bodymassindex)
    {
        return _body.get(bodymassindex)
            .getX();
    }

    /*
     * @param bodymassindex Mächtigkeit der Schlange
     * @return liefert die y-Position des Tails, 
     * für eine bestimmte Mächtigkeit bzw. Länge der Schlange
     */
    public int getBodyY(int bodymassindex)
    {
        return _body.get(bodymassindex)
            .getY();
    }

    /*
     * Paint-Methode
     */
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