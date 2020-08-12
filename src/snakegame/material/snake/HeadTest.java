package snakegame.material.snake;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import snakegame.fachwert.Position;
import snakegame.fachwert.enums.Direction;

public class HeadTest
{

    @Test
    public void testeHeadKonstruktor()
    {

    }

    @Test
    public void testeMoveDirectionRight()
    {

        Direction direction = Direction.RIGHT;
        Position positionHead = new Position(5, 5);
        Head head1 = new Head(positionHead);
        head1.setDirection(direction);

        head1.move();

        Position newPosition = head1.getPosition();
        assertEquals(newPosition.getX(), 6);
        assertEquals(newPosition.getY(), 5);

    }

    @Test
    /*
     * @TO DO Test läuft schief, obwohl die Werte stimmen. Ist die Methode falsch?
     */
    public void testeMoveDirectionLeft()
    {

        Direction direction = Direction.LEFT;
        Position positionHead = new Position(5, 5);
        Head head1 = new Head(positionHead);
        head1.setDirection(direction);

        head1.move();

        Position newPosition = head1.getPosition();
        assertEquals(newPosition.getX(), 4);
        assertEquals(newPosition.getY(), 5);

    }

    @Test
    public void testeMoveDirectionUp()
    {

        Direction direction = Direction.UP;
        Position positionHead = new Position(5, 5);
        Head head1 = new Head(positionHead);
        head1.setDirection(direction);

        head1.move();

        Position newPosition = head1.getPosition();
        assertEquals(newPosition.getX(), 5);
        assertEquals(newPosition.getY(), 4);

    }

    @Test
    public void testeMoveDirectionDown()
    {

        Direction direction = Direction.DOWN;
        Position positionHead = new Position(5, 5);
        Head head1 = new Head(positionHead);
        head1.setDirection(direction);

        head1.move();

        Position newPosition = head1.getPosition();
        assertEquals(newPosition.getX(), 5);
        assertEquals(newPosition.getY(), 6);

    }

}
