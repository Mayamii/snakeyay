package snakegame.material.food;

import snakegame.fachwert.enums.Effect;
import snakegame.fachwert.enums.PictureName;
import snakegame.service.ImageStore;

public class EwwFood extends BadFood
{
    public EwwFood()
    {
        super(ImageStore.getImage(PictureName.EWWFOOD));
        _effect = Effect.EWW;
    }
}
