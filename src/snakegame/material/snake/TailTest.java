package snakegame.material.snake;

import static org.junit.Assert.assertEquals;

import javax.swing.ImageIcon;

import org.junit.Test;

import snakegame.fachwert.Position;

/*
 * Testklasse zum Testen der Methoden der Klasse Head
 */
public class TailTest
{

    /*
     * Testet die Methode getLength
     */
    @Test
    public void testeGetLength()
    {
        Position pos = new Position(5, 5);
        ImageIcon img = new ImageIcon();
        int length = 2;
        Tail tail = new Tail(pos, img);

        assertEquals(tail.getLength(), length);
    }

    /*
     * Testet die Methode growenable
     */
    @Test
    public void testeGrowenable()
    {
        Position pos = new Position(5, 5);
        ImageIcon img = new ImageIcon();
        Tail tail = new Tail(pos, img);
        int expectedLength = 5;
        int howMuchGrow = 3;
        tail.growenable(howMuchGrow);
        for (int i = howMuchGrow; i > 0; i--)
        {
            tail.update();
        }

        int newLength = tail.getLength();
        assertEquals(expectedLength, newLength);

    }

}
