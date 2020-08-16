package snakegame.material.food;

import snakegame.fachwert.enums.Effect;
import snakegame.fachwert.enums.PictureName;
import snakegame.service.ImageStore;

/*
 * Schnelles Essen, welches ein Subtyp der Klasse Food ist.
 * Der Effekt Schnell wirkt auf die Schlange, wenn sie das Schnelle Essen frisst.
 */
public class FastFood extends Food
{
    public FastFood()
    {
        super(ImageStore.getImage(PictureName.FASTFOOD));
        _effect = Effect.FAST;
    }
}
