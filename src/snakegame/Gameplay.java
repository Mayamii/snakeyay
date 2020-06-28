package snakegame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import snakegame.fachwert.Position;
import snakegame.fachwert.enums.Direction;
import snakegame.fachwert.enums.PictureName;
import snakegame.material.food.Food;
import snakegame.material.snake.Snake;
import snakegame.service.CollisionManager;
import snakegame.service.ImageStore;

public class Gameplay extends JPanel implements KeyListener, ActionListener
{

    /**
     * Default serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private Snake _snake;

    private CollisionManager _sebastian;
    boolean _gameover = false;
    private Timer _timer;
    private int _delay = 100;

    private Position _startposition;

    public Gameplay()
    {
        _startposition = new Position(4, 4);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        _snake = new Snake(_startposition);
        _sebastian = new CollisionManager(_snake);
        // _food = new Food();

        _timer = new Timer(_delay, this);

        _timer.start();
    }

    public void paint(Graphics g)
    {

        // draw title image border
        g.setColor(Color.white);
        g.drawRect(24, 10, 851, 55);

        ImageStore.getImage(PictureName.TITLE)
            .paintIcon(this, g, 25, 11);

        g.setColor(Color.white);
        g.drawRect(24, 72, 851, 577);
        g.setColor(Color.black);
        g.fillRect(25, 75, 850, 575);

        //draw scores
        g.setColor(Color.white);
        g.setFont(new Font("arial", Font.PLAIN, 14));
        g.drawString("Scores: " + _snake.getScore(), 780, 30);

        //length of snake
        g.setColor(Color.white);
        g.setFont(new Font("arial", Font.PLAIN, 14));
        g.drawString("Length: " + _snake.getLength(), 780, 50);

        _snake.paint(g, this);

        for (int i = 0; i < _sebastian.getLengthList(); i++)
        {
            _sebastian.returnFood(i)
                .paint(g, this);
        }
        if (_gameover)
        {

            g.setColor(Color.white);
            g.setFont(new Font("arial", Font.BOLD, 50));
            g.drawString("Game Over", 300, 300);

            g.setFont(new Font("arial", Font.BOLD, 20));
            g.drawString("Press Space to restart", 350, 340);

        }

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        _timer.start();

        update();
        repaint();

    }

    private void checkState()
    {

    }

    private void update()
    {
        _snake.update();
        _sebastian.update();
        if (_sebastian.getfoundFood())
        {
            Food food = _sebastian.returnSavedFood();
            _snake.eats(food);
            _sebastian.removeFoodfromList(food);
            _sebastian.addRandomFood(_sebastian.returnSavedFood());
            _sebastian.setfoundFood(false);

        }
        repaint();
        _gameover = _snake.isDead();
        //gameover

        for (int b = 1; b < _snake.getLength() - 1; b++)
        {
            if (_sebastian.bitesOwnBody())
            {
                _snake.setMove(false);
                _gameover = true;
            }
        }

    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {

        if (e.getKeyCode() == KeyEvent.VK_SPACE && _gameover)
        {
            _gameover = false;
            _snake = new Snake(_startposition);
            _sebastian = new CollisionManager(_snake);
            repaint();

        }
        if (!_gameover)
        {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                _snake.setMove(true);
                _snake.setDirection(Direction.RIGHT);
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                _snake.setMove(true);
                _snake.setDirection(Direction.LEFT);
            }

            if (e.getKeyCode() == KeyEvent.VK_UP)
            {
                _snake.setMove(true);
                _snake.setDirection(Direction.UP);
            }

            if (e.getKeyCode() == KeyEvent.VK_DOWN)
            {
                _snake.setMove(true);
                _snake.setDirection(Direction.DOWN);
            }

        }
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            Container p = this.getTopLevelAncestor();
            p.dispatchEvent(
                    new WindowEvent((JFrame) p, WindowEvent.WINDOW_CLOSING));
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        // TODO Auto-generated method stub

    }

}
