package snakegame.material.food;

import snakegame.fachwert.enums.Effect;
import snakegame.fachwert.enums.PictureName;
import snakegame.service.ImageStore;

/*
 * Super Essen, welches ein Subtyp der Klasse Food ist.
 * Der Effekt Super wirkt auf die Schlange, wenn sie das Super Essen frisst.
 */
public class SuperFood extends Food
{
    public SuperFood()
    {
        super(ImageStore.getImage(PictureName.SUPERFOOD));
        _effect = Effect.SUPER;
    }
}
