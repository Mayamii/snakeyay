package snakegame.fachwert.enums;

/*
 * Fachwert Enum Klasse für die Bewegungsrichtung der Schlange = Direction
 */
public enum Direction
{
    RIGHT, LEFT, UP, DOWN,;

    /*
     * Methode zur Umkehr der Richtung. 
     * Gibt die entgegengesetzte Richtung zurück
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
