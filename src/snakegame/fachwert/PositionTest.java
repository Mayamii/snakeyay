package snakegame.fachwert;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PositionTest
{
    @Test
    public void testemoveUp()
    {
        Position position = new Position(5, 5);

        Position position1 = position.moveUp();

        assertEquals(position1.getY(), 4);

    }

    @Test
    public void testemoveDown()
    {
        Position position1 = new Position(5, 5);
        assertEquals(6, position1.moveDown()
            .getY());
    }

    @Test
    public void testemoveRight()
    {
        Position position1 = new Position(5, 5);
        assertEquals(6, position1.moveRight()
            .getX());
    }

    @Test
    public void testemoveLeft()
    {
        Position position1 = new Position(5, 5);
        assertEquals(4, position1.moveLeft()
            .getX());
    }

}
