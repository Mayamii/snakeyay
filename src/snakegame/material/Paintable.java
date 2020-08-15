package snakegame.material;

import java.awt.Component;
import java.awt.Graphics;

/*
 * Interface Paintable
 * Liefert die Methoden, die in den Klassen, die
 * das Interface implementieren verwenden, benutzt werden
 */
public interface Paintable
{
    /*
     * Paint-Methode
     * @param g Graphics
     * @param frame Component
     */
    public void paint(Graphics g, Component frame);

    /*
     * update Methode
     */
    public void update();

    /*
     * GetX-Methode
     */
    public int getX();

    /*
     * GetY-Methode
     */
    public int getY();

}
