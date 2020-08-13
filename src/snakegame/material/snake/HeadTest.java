package snakegame.material.snake;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import snakegame.fachwert.Position;
import snakegame.fachwert.enums.Direction;
import snakegame.fachwert.enums.PictureName;
import snakegame.service.ImageStore;

public class HeadTest
{

    @Test
    public void testeHeadKonstruktor()
    {
        Position position = new Position(1, 1);
        Head head = new Head(position);

        assertFalse(head.getGod());
        assertEquals(Direction.RIGHT, head.getDirection());
        assertEquals(1, head.getPosition()
            .getX());
        assertEquals(1, head.getPosition()
            .getY());
        assertEquals(head.getImage(),
                ImageStore.getImage(PictureName.HEADRIGHT));

    }

    @Test
    public void testeSetGod()
    {
        Position pos = new Position(5, 5);
        Head head = new Head(pos);
        boolean godmode = true;

        head.setGod(godmode);
        assertEquals(head.getGod(), godmode);
    }

    @Test
    public void testeMove()
    {

        Direction direction = Direction.RIGHT;
        Position positionHead = new Position(5, 5);
        Head head1 = new Head(positionHead);
        head1.setDirection(direction);

        head1.move();

        Position newPosition = head1.getPosition();
        assertEquals(newPosition.getX(), 6);
        assertEquals(newPosition.getY(), 5);

        direction = Direction.UP;
        head1.setDirection(direction);
        head1.move();
        newPosition = head1.getPosition();
        assertEquals(newPosition.getX(), 6);
        assertEquals(newPosition.getY(), 4);

        direction = Direction.LEFT;
        head1.setDirection(direction);
        head1.move();
        newPosition = head1.getPosition();
        assertEquals(newPosition.getX(), 5);
        assertEquals(newPosition.getY(), 4);

        direction = Direction.DOWN;
        head1.setDirection(direction);
        head1.move();
        newPosition = head1.getPosition();
        assertEquals(newPosition.getX(), 5);
        assertEquals(newPosition.getY(), 5);

    }

    @Test
    public void testeGetDirection()
    {

        Position positionHead = new Position(5, 5);
        Head head = new Head(positionHead);
        assertEquals(head.getDirection(), Direction.RIGHT);
        head.setDirection(Direction.DOWN);

        assertEquals(Direction.DOWN, head.getDirection());
        head.move();
        head.setDirection(Direction.UP);
        assertEquals(Direction.DOWN, head.getDirection());
        head.move();

        head.setDirection(Direction.LEFT);
        assertEquals(Direction.LEFT, head.getDirection());
        head.move();

        head.setDirection(Direction.RIGHT);
        assertEquals(Direction.LEFT, head.getDirection());
        head.move();

        head.setDirection(Direction.UP);
        assertEquals(Direction.UP, head.getDirection());
        head.move();

        head.setDirection(Direction.DOWN);
        assertEquals(Direction.UP, head.getDirection());
        head.move();

        head.setDirection(Direction.RIGHT);
        assertEquals(Direction.RIGHT, head.getDirection());
        head.move();

        head.setDirection(Direction.LEFT);
        assertEquals(Direction.RIGHT, head.getDirection());

    }

}
