package snakegame.service;

import java.util.HashMap;

import javax.swing.ImageIcon;

import snakegame.fachwert.enums.PictureName;

public class ImageStore
{
    private static HashMap<PictureName, ImageIcon> _images;

    //das macht dass die Klasse nicht erzeugt werden muss und trotzdem den (static) Konstruktor aufruft und die Variabeln initialisiert
    static
    {
        _images = new HashMap<>();
        _images.put(PictureName.HEADRIGHT, new ImageIcon("rightmouth.png"));
        _images.put(PictureName.HEADLEFT, new ImageIcon("leftmouth.png"));
        _images.put(PictureName.HEADUP, new ImageIcon("upmouth.png"));
        _images.put(PictureName.HEADDOWN, new ImageIcon("downmouth.png"));
        _images.put(PictureName.SNAKEBODY, new ImageIcon("snakeimage.png"));
        _images.put(PictureName.NORMALFOOD, new ImageIcon("enemy.png"));
        _images.put(PictureName.TITLE, new ImageIcon("snaketitle.png"));
        _images.put(PictureName.INVINCIBLEFOOD,
                new ImageIcon("invinciblefood.png"));
        _images.put(PictureName.INVERSEFOOD, new ImageIcon("inversefood.png"));
        _images.put(PictureName.EWWFOOD, new ImageIcon("ewwfood.png"));
        _images.put(PictureName.FASTFOOD, new ImageIcon("fastfood.png"));
        _images.put(PictureName.SUPERFOOD, new ImageIcon("superfood.png"));
        _images.put(PictureName.SLOWFOOD, new ImageIcon("slowfood.png"));
    }

    public static ImageIcon getImage(PictureName key)
    {
        return _images.get(key);
    }
}
