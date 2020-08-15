package snakegame.material.food;

import javax.swing.ImageIcon;

import snakegame.fachwert.Position;
import snakegame.fachwert.enums.Effect;
import snakegame.material.AbstractPaintable;

/*
 * Die Klasse Food stellt das Essen dar, das die Schlange fressen kann.
 * Essen hat immer einen Effekt und ein spezielles Bild, welches das Essen
 * repräsentiert.
 * Es taucht an einer zufälligen Position auf.
 */
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

    /*
     * @return gibt den Effekt zurück.
     */
    public Effect getEffect()
    {
        // TODO Auto-generated method stub
        return _effect;
    }
}
