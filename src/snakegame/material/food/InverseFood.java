package snakegame.material.food;

import snakegame.fachwert.enums.Effect;
import snakegame.fachwert.enums.PictureName;
import snakegame.service.ImageStore;

/*
 * Inverses Essen, welches ein Subtyp der Klasse Food ist.
 * Der Effekt Inverse wirkt auf die Schlange, wenn sie das Inverse Essen frisst.
 */
public class InverseFood extends Food
{

    public InverseFood()
    {
        super(ImageStore.getImage(PictureName.INVERSEFOOD));
        _effect = Effect.INVERSE;
    }
}
