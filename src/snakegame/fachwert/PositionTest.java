package snakegame.fachwert;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PositionTest
{
    @Test
    public void testemoveUp()
    {
        Position position = new Position(5, 5);
        position = position.moveUp();
        assertEquals(position.getX(), 5);
        assertEquals(position.getY(), 4);

        position = new Position(0, 0);
        position = position.moveUp();
        assertEquals(0, position.getX());
        assertEquals(22, position.getY());
    }

    @Test
    public void testemoveDown()
    {
        Position position = new Position(5, 5);
        position = position.moveDown();
        assertEquals(5, position.getX());
        assertEquals(6, position.getY());

        position = new Position(0, 22);
        position = position.moveDown();
        assertEquals(0, position.getX());
        assertEquals(0, position.getY());
    }

    @Test
    public void testemoveRight()
    {
        Position position = new Position(5, 5);
        position = position.moveRight();
        assertEquals(6, position.getX());
        assertEquals(5, position.getY());

        position = new Position(33, 0);
        position = position.moveRight();
        assertEquals(0, position.getX());
        assertEquals(0, position.getY());
    }

    @Test
    public void testemoveLeft()
    {
        Position position = new Position(5, 5);
        position = position.moveLeft();
        assertEquals(4, position.getX());
        assertEquals(5, position.getY());

        position = new Position(0, 0);
        position = position.moveLeft();
        assertEquals(33, position.getX());
        assertEquals(0, position.getY());
    }

}
