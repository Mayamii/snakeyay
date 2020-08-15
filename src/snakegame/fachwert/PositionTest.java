package snakegame.fachwert;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*
 * Testklasse f�r die Position-Klasse
 */
public class PositionTest
{

    /*
     * Testet die Methode moveUp
     */
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

    /*
     * Testet die Methode moveDown
     */
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

    /*
     * Testet die Methode moveRight
     */
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

    /*
     * Testet die Methode moveLeft
     */
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
