import java.util.HashMap;

import javax.swing.ImageIcon;

public class ImageStore
{
    private static HashMap<String, ImageIcon> _images;

    //das macht dass die Klasse nicht erzeugt werden muss und trotzdem den (static) Konstruktor aufruft und die Variabeln initialisiert
    static
    {
        _images = new HashMap<>();
        _images.put("rightMouth", new ImageIcon("rightmouth.png"));
        _images.put("leftMouth", new ImageIcon("leftmouth.png"));
        _images.put("upMouth", new ImageIcon("upmouth.png"));
        _images.put("downMouth", new ImageIcon("downmouth.png"));
        _images.put("snake", new ImageIcon("snakeimage.png"));
        _images.put("food", new ImageIcon("enemy.png"));
        _images.put("title", new ImageIcon("snaketitle.png"));
    }

    public static ImageIcon getImage(String key)
    {
        return _images.get(key);
    }
}
