package snakegame.material.food;

import snakegame.fachwert.enums.Effect;
import snakegame.fachwert.enums.PictureName;
import snakegame.service.ImageStore;

/*
 * Normales Essen, welches ein Subtyp der Klasse Food ist.
 * Der Effekt Normal wirkt auf die Schlange, wenn sie das normale Essen frisst.
 */
public class NormalFood extends Food
{
    public NormalFood()
    {
        super(ImageStore.getImage(PictureName.NORMALFOOD));
        _effect = Effect.NORMAL;
    }

}
