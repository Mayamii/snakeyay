package snakegame.material.food;

import snakegame.fachwert.enums.Effect;
import snakegame.fachwert.enums.PictureName;
import snakegame.service.ImageStore;

public class FastFood extends BadFood
{
    public FastFood()
    {
        super(ImageStore.getImage(PictureName.FASTFOOD));
        _effect = Effect.FAST;
    }
}
