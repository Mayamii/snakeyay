package snakegame.fachwert.enums;

public enum Direction
{
    RIGHT, LEFT, UP, DOWN,;

    public Direction inverse()
    {
        if (this == RIGHT)
        {
            return LEFT;
        }
        else if (this == LEFT)
        {
            return RIGHT;
        }
        else if (this == UP)
        {
            return DOWN;
        }
        else
        {
            return UP;
        }
    }

}
