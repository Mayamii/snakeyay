import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Gameplay extends JPanel implements KeyListener, ActionListener
{
    private static final int GRIDSIZE = 25;
    private static final int OFFSETY = 75;
    private static final int OFFSETX = 25;

    private Snake _snake;

    private int _score = 0;
    boolean _gameover = false;
    private ImageIcon _rightMouth;
    private ImageIcon _leftMouth;
    private ImageIcon _upMouth;
    private ImageIcon _downMouth;
    private Timer _timer;
    private int _delay = 100;

    private ImageIcon _snekImage;

    private int[] _enemyXPos = new int[34];

    private int[] _enemyYPos = new int[25];

    private ImageIcon _enemyImage;
    private Random _random = new Random();
    private int _xPos = _random.nextInt(34);
    private int _yPos = _random.nextInt(23);

    private ImageIcon _titleImage;

    public Gameplay()
    {
        loadGraphics();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        _snake = new Snake();
        for (int i = 0; i < 34; i++)
        {
            _enemyXPos[i] = 25 + (25 * i);
        }
        for (int i = 0; i <

                (625 / 25); i++)
        {
            _enemyYPos[i] = (25 * i) + 75;
        }
        _timer = new Timer(_delay, this);
        _timer.start();

    }

    private void loadGraphics()
    {
        _rightMouth = new ImageIcon("rightmouth.png");
        _leftMouth = new ImageIcon("leftmouth.png");
        _upMouth = new ImageIcon("upmouth.png");
        _downMouth = new ImageIcon("downmouth.png");
        _snekImage = new ImageIcon("snakeimage.png");
        _enemyImage = new ImageIcon("enemy.png");
        _titleImage = new ImageIcon("snaketitle.png");

    }

    public void paint(Graphics g)
    {

        // draw title image border
        g.setColor(Color.white);
        g.drawRect(24, 10, 851, 55);

        _titleImage.paintIcon(this, g, 25, 11);

        g.setColor(Color.white);
        g.drawRect(24, 72, 851, 577);
        g.setColor(Color.black);
        g.fillRect(25, 75, 850, 575);

        //draw scores
        g.setColor(Color.white);
        g.setFont(new Font("arial", Font.PLAIN, 14));
        g.drawString("Scores: " + _score, 780, 30);

        //length of snake
        g.setColor(Color.white);
        g.setFont(new Font("arial", Font.PLAIN, 14));
        g.drawString("Length: " + _snake.getLength(), 780, 50);

        paintSnake(g);

        if (foundFood())
        {
            _snake.eats();
            _score++;
            _xPos = _random.nextInt(34);
            _yPos = _random.nextInt(23);
        }
        _enemyImage.paintIcon(this, g, _enemyXPos[_xPos], _enemyYPos[_yPos]);

        //gameover
        for (int b = 1; b < _snake.getLength() - 1; b++)
        {
            if (bitesOwnBody(b))
            {
                gameIsOver(g);
            }
        }
        g.dispose();
    }

    private void gameIsOver(Graphics g)
    {
        _snake.setMove(false);
        _gameover = true;

        g.setColor(Color.white);
        g.setFont(new Font("arial", Font.BOLD, 50));
        g.drawString("Game Over", 300, 300);

        g.setFont(new Font("arial", Font.BOLD, 20));
        g.drawString("Press Space to restart", 350, 340);
    }

    private boolean bitesOwnBody(int b)
    {
        return _snake.getBodyX(b) == _snake.getHeadX()
                && _snake.getBodyY(b) == _snake.getHeadY();
    }

    private boolean foundFood()
    {
        return _xPos == _snake.getHeadX() && _yPos == _snake.getHeadY();
    }

    private void paintSnake(Graphics g)
    {
        ImageIcon mouth = _rightMouth;
        //Diese ifKlammer braucht man nicht, da es per Default auf rightmouth.png gesetzt ist, um Nullpointer zu verhindern
        //        if (_snek.giveDirection() == Direction.RIGHT)
        //        {
        //            mouth = _rightMouth;
        //
        //        }
        if (_snake.getDirection() == Direction.LEFT)
        {
            mouth = _leftMouth;
        }
        if (_snake.getDirection() == Direction.UP)
        {
            mouth = _upMouth;
        }
        if (_snake.getDirection() == Direction.DOWN)
        {
            mouth = _downMouth;
        }
        mouth.paintIcon(this, g, _snake.getHeadX() * GRIDSIZE + OFFSETX,
                _snake.getHeadY() * GRIDSIZE + OFFSETY);
        for (int a = 0; a < _snake.getLength() - 1; a++)
        {
            _snekImage.paintIcon(this, g,
                    _snake.getBodyX(a) * GRIDSIZE + OFFSETX,
                    _snake.getBodyY(a) * GRIDSIZE + OFFSETY);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        _timer.start();
        _snake.move();
        repaint();

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
            _score = 0;
            _snake = new Snake();
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
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        // TODO Auto-generated method stub

    }

}
