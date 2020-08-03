package snakegame.fachwert.enums;

/*
 * Fachwert Enum Klasse für die verschiedenen (Bewegungs-)Richtungen 
 */
public enum Direction
{
    RIGHT, LEFT, UP, DOWN,;

    /*
     * Aktiviert die jeweils entgegengesetze Richtung 
     */
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
