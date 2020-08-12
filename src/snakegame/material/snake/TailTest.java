package snakegame.material.snake;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import javax.swing.ImageIcon;

import org.junit.Test;

import snakegame.fachwert.Position;

public class TailTest
{

    @Test
    public void testeGetLength()
    {
        Position pos = new Position(5, 5);
        ImageIcon img = new ImageIcon();
        int length = 2;
        Tail tail = new Tail(pos, img);

        assertEquals(tail.getLength(), length);
    }

    @Test
    /*
     * @todo: Test Growenable funktioniert noch nicht
     */

    public void testeGrowenable()
    {
        Position pos = new Position(5, 5);
        ImageIcon img = new ImageIcon();
        Tail tail = new Tail(pos, img);
        int expectedLength = 5;
        int howMuchGrow = 5;

        tail.growenable(howMuchGrow);

        int newLength = tail.getLength();
        assertEquals(expectedLength, newLength);

    }

    @Test
    public void testeGrows()
    {
        Position pos = new Position(5, 5);
        ImageIcon img = new ImageIcon();
        Tail tail = new Tail(pos, img); 
        
        tail.grows();
        
        assertEquals();

}
