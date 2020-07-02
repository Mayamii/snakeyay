package snakegame.material.food;

import snakegame.fachwert.enums.Effect;
import snakegame.fachwert.enums.PictureName;
import snakegame.service.ImageStore;

public class InvincibleFood extends Food
{
    public InvincibleFood()
    {
        super(ImageStore.getImage(PictureName.INVINCIBLEFOOD));
        _effect = Effect.INVINCIBLE;
    }
}
