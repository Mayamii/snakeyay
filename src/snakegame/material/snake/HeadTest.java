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
        Position positionHeadAfterMove = new Position(6, 5);
        Head head1 = new Head(positionHead);
        assertTrue(positionHeadAfterMove == head1.move());
    }

    @Test
    public void testeMoveDirectionLeft()
    {
        Direction direction = Direction.LEFT;
        Position positionHead = new Position(5, 5);
        Head head1 = new Head(positionHead);
        assertTrue(Head.move();

    }

    @Test
    public void testeMoveDirectionUp()
    {
        Direction direction = Direction.RIGHT;
        Position positionHead = new Position(5, 5);
        Head head1 = new Head(positionHead);
        assertEquals(6, positionHead.move()
            .direction());
    }

    @Test
    public void testeMoveDirectionDown()
    {
        Direction direction = Direction.RIGHT;
        Position positionHead = new Position(5, 5);
        Head head1 = new Head(positionHead);
        assertEquals(6, positionHead.move()
            .direction());
    }

    @Test
    public void testeMoveDirectionValueNotInCase()
    {
        Direction direction = Direction.RIGHT;
        Position positionHead = new Position(5, 5);
        Head head1 = new Head(positionHead);
        assertEquals(6, positionHead.move()
            .direction());
    }

}
