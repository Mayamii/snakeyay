package snakegame.ui;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.ImageIcon;

import snakegame.fachwert.Position;
import snakegame.fachwert.enums.PictureName;
import snakegame.service.Highscore;
import snakegame.service.ImageStore;

/*
 * Klasse zur Erzeugung des Highscore Menüs
 */
public class HighscoreMenu
{
    Highscore _highscore;
    ImageIcon _image;

    public HighscoreMenu(Highscore highscore)
    {
        _highscore = highscore;
        _image = ImageStore.getImage(PictureName.HIGHSCORE);
    }

    /*
     * Zeichnet die Highscore Anzeige
     * @param g Graphics
     * @param c Component
     */
    public void paint(Graphics g, Component c)
    {
        _image.paintIcon(c, g, new Position(248, 85).getX(),
                new Position(248, 85).getY());
        for (int i = 0; i < 5; i++)
        {
            _highscore.getScore(i)
                .paint(g, 310, 270 + (i * 75), i + 1);

        }
    }

}
