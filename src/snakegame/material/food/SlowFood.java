package snakegame.material.food;

import snakegame.fachwert.enums.Effect;
import snakegame.fachwert.enums.PictureName;
import snakegame.service.ImageStore;

/*
 * Langsames Essen, welches ein Subtyp der Klasse Food ist.
 * Der Effekt Slow wirkt auf die Schlange, wenn sie das Slow Essen frisst.
 */
public class SlowFood extends Food
{
    public SlowFood()
    {
        super(ImageStore.getImage(PictureName.SLOWFOOD));
        _effect = Effect.SLOW;
    }
}
