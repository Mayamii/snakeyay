import java.util.HashMap;

import javax.swing.ImageIcon;

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
        _images.put(PictureName.FOOD, new ImageIcon("enemy.png"));
        _images.put(PictureName.TITLE, new ImageIcon("snaketitle.png"));
    }

    public static ImageIcon getImage(PictureName key)
    {
        return _images.get(key);
    }
}
