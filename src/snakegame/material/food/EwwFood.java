package snakegame.material.food;

import snakegame.fachwert.enums.Effect;
import snakegame.fachwert.enums.PictureName;
import snakegame.service.ImageStore;

/*
 * Eww Essen, welches ein Subtyp der Klasse Food ist.
 * Der Effekt EWW wirkt auf die Schlange, wenn sie das EWW Essen frisst.
 */
public class EwwFood extends Food
{
    public EwwFood()
    {
        super(ImageStore.getImage(PictureName.EWWFOOD));
        _effect = Effect.EWW;
    }
}
