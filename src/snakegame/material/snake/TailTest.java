package snakegame.material.snake;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Test;

import snakegame.fachwert.Position;
import snakegame.fachwert.enums.Direction;

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
        boolean godmode = true;
        return setGod(godmode);
        
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
