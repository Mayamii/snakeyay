package snakegame.material.food;

import snakegame.fachwert.enums.Effect;
import snakegame.fachwert.enums.PictureName;
import snakegame.service.ImageStore;

public class SlowFood extends Food
{
    public SlowFood()
    {
        super(ImageStore.getImage(PictureName.SLOWFOOD));
        _effect = Effect.SLOW;
    }
}
