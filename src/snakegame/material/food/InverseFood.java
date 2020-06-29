package snakegame.material.food;

import snakegame.fachwert.enums.Effect;
import snakegame.fachwert.enums.PictureName;
import snakegame.service.ImageStore;

public class InverseFood extends BadFood
{

    public InverseFood()
    {
        super(ImageStore.getImage(PictureName.INVERSEFOOD));
        _effect = Effect.INVERSE;
    }
}
