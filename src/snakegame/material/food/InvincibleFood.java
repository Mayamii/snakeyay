package snakegame.material.food;

import snakegame.fachwert.enums.Effect;
import snakegame.fachwert.enums.PictureName;
import snakegame.service.ImageStore;

/*
 * Unbesiegbar Essen, welches ein Subtyp der Klasse Food ist.
 * Der Effekt Invincible wirkt auf die Schlange, wenn sie das Invincible Essen frisst.
 */
public class InvincibleFood extends Food
{
    public InvincibleFood()
    {
        super(ImageStore.getImage(PictureName.INVINCIBLEFOOD));
        _effect = Effect.INVINCIBLE;
    }
}
