package snakegame.material.food;

import snakegame.fachwert.enums.Effect;
import snakegame.fachwert.enums.PictureName;
import snakegame.service.ImageStore;

public class SuperFood extends Food
{
    public SuperFood()
    {
        super(ImageStore.getImage(PictureName.SUPERFOOD));
        _effect = Effect.SUPER;
    }
}
