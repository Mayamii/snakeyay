package snakegame.material.food;

import javax.swing.ImageIcon;

import snakegame.fachwert.Position;
import snakegame.fachwert.enums.Effect;
import snakegame.material.AbstractPaintable;

public abstract class Food extends AbstractPaintable
{

    protected Effect _effect;

    protected Food(ImageIcon image)
    {
        super(Position.randomPos(), image);
    }

    @Override
    public void update()
    {
        // TODO Auto-generated method stub

    }

    public Effect getEffect()
    {
        // TODO Auto-generated method stub
        return _effect;
    }
}
