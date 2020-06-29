package snakegame.material.food;

import snakegame.fachwert.enums.Effect;
import snakegame.fachwert.enums.PictureName;
import snakegame.service.ImageStore;

public class NormalFood extends GoodFood
{
    public NormalFood()
    {
        super(ImageStore.getImage(PictureName.NORMALFOOD));
        _effect = Effect.NORMAL;
    }

}
