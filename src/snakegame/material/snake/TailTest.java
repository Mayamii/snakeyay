package snakegame.material.snake;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import javax.swing.ImageIcon;

import org.junit.Test;

import snakegame.fachwert.Position;

public class TailTest
{

    @Test
    public void testeTailKonstruktor()
    {

    }

    @Test
    public void testeGetLength()
    {
        LinkedList<Position> body;
        body = new LinkedList<>();

        body.getLength();
    }

    @Test
    public void testeSetGod()
    {
        Position pos = new Position(5, 5);
        ImageIcon img = new ImageIcon();
        Tail tail = new Tail(pos, img);
        boolean godmode = true;
        boolean val;

        tail.setGod(godmode);

        assertEquals(, true);

    }

    @Test
    public void testeGrowenable()
    {

    }

    @Test
    public void testeGrows()
    {

    }

}
