import java.awt.Color;
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
    //hier ist coolkommentar

    private int[] _snekXLen = new int[750];
    private int[] _snekYLen = new int[750];

    boolean _left = false;
    boolean _right = false;
    boolean _up = false;
    boolean _down = false;

    private void setFalse()
    {
        _left = false;
        _right = false;
        _up = false;
        _down = false;
    }

    private ImageIcon _rightMouth;
    private ImageIcon _leftMouth;
    private ImageIcon _upMouth;
    private ImageIcon _downMouth;

    private int _lengthOfSnek = 3;

    private Timer _timer;
    private int _delay = 100;

    private ImageIcon _snekImage;

    private int[] _enemyXPos = new int[34];

    private int[] _enemyYPos = new int[25];

    private ImageIcon _enemyImage;
    private Random _random = new Random();
    private int _xPos = _random.nextInt(34);
    private int _yPos = _random.nextInt(23);

    private int _moves = 0;

    private ImageIcon _titleImage;

    public Gameplay()
    {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
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

    public void paint(Graphics g)
    {
        // wird nur ganz am Anfang ausgelöst, wenn die Schlage sich noch nicht bewegt
        if (_moves == 0)
        {
            _snekXLen[2] = 50;
            _snekXLen[1] = 75;
            _snekXLen[0] = 100;

            _snekYLen[2] = 100;
            _snekYLen[1] = 100;
            _snekYLen[0] = 100;
        }
        // draw title image border
        g.setColor(Color.white);
        g.drawRect(24, 10, 851, 55);

        _titleImage = new ImageIcon("snaketitle.png");
        _titleImage.paintIcon(this, g, 25, 11);

        g.setColor(Color.white);
        g.drawRect(24, 72, 851, 577);
        g.setColor(Color.black);
        g.fillRect(25, 75, 850, 575);

        _rightMouth = new ImageIcon("rightmouth.png");
        _rightMouth.paintIcon(this, g, _snekXLen[0], _snekYLen[0]);

        // diese Schleife malt die Schlange. Position 0 ist hierbei das Gesicht und alles danach ist der Körper
        for (int a = 0; a < _lengthOfSnek; a++)
        {
            if (a == 0 && _right)
            {
                _rightMouth = new ImageIcon("rightmouth.png");
                _rightMouth.paintIcon(this, g, _snekXLen[a], _snekYLen[a]);
            }

            if (a == 0 && _left)
            {
                _leftMouth = new ImageIcon("leftmouth.png");
                _leftMouth.paintIcon(this, g, _snekXLen[a], _snekYLen[a]);
            }
            if (a == 0 && _up)
            {
                _upMouth = new ImageIcon("upmouth.png");
                _upMouth.paintIcon(this, g, _snekXLen[a], _snekYLen[a]);
            }
            if (a == 0 && _down)
            {
                _downMouth = new ImageIcon("downmouth.png");
                _downMouth.paintIcon(this, g, _snekXLen[a], _snekYLen[a]);
            }

            if (a != 0)
            {
                _snekImage = new ImageIcon("snakeimage.png");
                _snekImage.paintIcon(this, g, _snekXLen[a], _snekYLen[a]);

            }
        }

        _enemyImage = new ImageIcon("enemy.png");
        if (_enemyXPos[_xPos] == _snekXLen[0]
                && _enemyYPos[_yPos] == _snekYLen[0])
        {
            _lengthOfSnek++;
            _xPos = _random.nextInt(34);
            _yPos = _random.nextInt(23);
        }
        _enemyImage.paintIcon(this, g, _enemyXPos[_xPos], _enemyYPos[_yPos]);

        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        _timer.start();
        if (_right)
        {
            _moves = 1;
            for (int r = _lengthOfSnek - 1; r >= 0; r--)
            {
                _snekYLen[r + 1] = _snekYLen[r];
            }
            for (int r = _lengthOfSnek; r >= 0; r--)
            {
                if (r == 0)
                {
                    _snekXLen[r] = _snekXLen[r] + 25;
                }
                else
                {
                    _snekXLen[r] = _snekXLen[r - 1];
                }
                if (_snekXLen[r] > 850)
                {
                    _snekXLen[r] = 25;

                }
            }
            repaint();
        }
        if (_left)
        {
            _moves = 1;
            for (int r = _lengthOfSnek - 1; r >= 0; r--)
            {
                _snekYLen[r + 1] = _snekYLen[r];
            }
            for (int r = _lengthOfSnek; r >= 0; r--)
            {
                if (r == 0)
                {
                    _snekXLen[r] = _snekXLen[r] - 25;
                }
                else
                {
                    _snekXLen[r] = _snekXLen[r - 1];
                }
                if (_snekXLen[r] < 25)
                {
                    _snekXLen[r] = 850;

                }
            }
            repaint();
        }
        if (_down)
        {
            _moves = 1;
            for (int r = _lengthOfSnek - 1; r >= 0; r--)
            {
                _snekXLen[r + 1] = _snekXLen[r];
            }
            for (int r = _lengthOfSnek; r >= 0; r--)
            {
                if (r == 0)
                {
                    _snekYLen[r] = _snekYLen[r] + 25;
                }
                else
                {
                    _snekYLen[r] = _snekYLen[r - 1];
                }
                if (_snekYLen[r] > 625)
                {
                    _snekYLen[r] = 75;

                }
            }
            repaint();
        }
        if (_up)
        {
            _moves = 1;
            for (int r = _lengthOfSnek - 1; r >= 0; r--)
            {
                _snekXLen[r + 1] = _snekXLen[r];
            }
            for (int r = _lengthOfSnek; r >= 0; r--)
            {
                if (r == 0)
                {
                    _snekYLen[r] = _snekYLen[r] - 25;
                }
                else
                {
                    _snekYLen[r] = _snekYLen[r - 1];
                }
                if (_snekYLen[r] < 75)
                {
                    _snekYLen[r] = 625;

                }
                repaint();
            }

        }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            _moves++;
            if (!_left)
            {
                setFalse();
                _right = true;

            }
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            _moves++;
            if (!_right)
            {
                setFalse();
                _left = true;
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_UP)
        {
            _moves++;
            if (!_down)
            {
                setFalse();
                _up = true;
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            _moves++;
            if (!_up)
            {
                setFalse();
                _down = true;
            }

        }

    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        // TODO Auto-generated method stub

    }

}
