import java.util.LinkedList;

import javax.swing.ImageIcon;

public class Tail extends AbstractPaintable implements Paintable
{

    private LinkedList<Position> _body;

    protected Tail(Position pos, ImageIcon ima)
    {
        super(pos, ima);
        _body = new LinkedList<>();
        _body.add(new Position(3, 4));
        _body.add(new Position(2, 4));
    }

    @Override
    public void update()
    {

    }

}
