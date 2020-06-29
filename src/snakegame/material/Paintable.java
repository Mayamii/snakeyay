package snakegame.material;
import java.awt.Component;
import java.awt.Graphics;

public interface Paintable
{
    public void paint(Graphics g, Component frame);

    public void update();

    public int getX();

    public int getY();

}
