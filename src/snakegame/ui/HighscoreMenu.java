package snakegame.ui;

import java.awt.Graphics;

import snakegame.service.Highscore;

public class HighscoreMenu
{
    Highscore _highscore;

    public HighscoreMenu(Highscore highscore)
    {
        _highscore = highscore;
    }

    public void paint(Graphics g)
    {

        for (int i = 0; i < 5; i++)
        {
            _highscore.getScore(i)
                .paint(g, 310, 250 + (i * 75), i + 1);

        }
    }

}
