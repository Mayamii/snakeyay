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
import snakegame.fachwert.enums.GameState;
import snakegame.fachwert.enums.PictureName;
import snakegame.fachwert.enums.SnakeState;
import snakegame.material.snake.Snake;
import snakegame.service.ImageStore;
import snakegame.service.ObjectManager;

public class Gameplay extends JPanel implements KeyListener, ActionListener
{

    /**
     * Default serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    private Snake _snake;

    private ObjectManager _sebastian;
    GameState _state;
    private Timer _timer;
    private int _delay = 100;

    private Position _startposition;

    private boolean _menu;
    private int _index;
    private MenuItem _start;
    private MenuItem _highscore;
    private MenuItem _sound;
    private MenuItem _music;
    private MenuItem _close;
    private GameMenu _hauptmenu;

    public Gameplay()
    {
        _state = GameState.MENU;
        _startposition = new Position(4, 4);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        _menu = true;
        _hauptmenu = new GameMenu(new Position(5, 5), new Position(20, 20));
        _start = new MenuItem("Start Game", new Position(9, 7));
        _highscore = new MenuItem("Highscore", new Position(12, 10));
        _sound = new MenuItem("Sound", new Position(12, 13));
        _music = new MenuItem("Music", new Position(12, 16));
        _close = new MenuItem("Close", new Position(12, 19));
        _hauptmenu.add(new MenuItem("Resume", new Position(12, 22)));
        _hauptmenu.add(_start);
        _hauptmenu.add(_highscore);
        _hauptmenu.add(_sound);
        _hauptmenu.add(_music);
        _hauptmenu.add(_close);

        _snake = new Snake(_startposition);
        _sebastian = new ObjectManager(_snake);
        // _food = new Food();

        _timer = new Timer(_delay, this);
        //  AudioStore.playAudio(AudioName.GOURMETRACE);
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

      


        //Menu zeichnen
        if (_menu)
        {
            _hauptmenu.paint(g);
        }

          if (_state == GameState.GAMEOVER)

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

    private void update()
    {
        _snake.update();
        _sebastian.update();
        updateDelay();

        repaint();
        if (_snake.getState() == SnakeState.DEAD)
        {
            _state = GameState.GAMEOVER;
        }
        //gameover

    }

    private void updateDelay()
    {
        if (_snake.getState() == SnakeState.SLOW)
        {
            _delay = 170;
        }
        else if (_snake.getState() == SnakeState.FAST
                || _snake.getState() == SnakeState.INVINCIBLE)
        {
            _delay = 50;
        }
        else
        {
            _delay = 100;
        }
        _timer.setDelay(_delay);

    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_M)
        {
            _menu = !_menu;
            _index = 0;
        }

        if (_menu)
        {
            if (e.getKeyCode() == KeyEvent.VK_DOWN)
            {
                _hauptmenu.selectNext();
            }

            if (e.getKeyCode() == KeyEvent.VK_UP)
            {
                _hauptmenu.selectPrevious();
            }

            if (e.getKeyCode() == KeyEvent.VK_ENTER)
            {
                MenuItem menuItem = _hauptmenu.getSelectedItem();

                switch (menuItem.getText())
                {
                case "Start Game":
                    break;
                case "Highscore":
                    break;
                case "Sound":
                    break;
                case "Music":
                    break;
                case "Close":
                    closeGame();
                    break;

                default:
                    break;
                }
            }

            repaint();
        }

        if (_state == GameState.GAMEOVER)
        {
            if (e.getKeyCode() == KeyEvent.VK_SPACE)
            {
                _snake = new Snake(_startposition);
                _sebastian = new ObjectManager(_snake);
                _state = GameState.PLAYING;
                repaint();

            }
        }

        if (_state == GameState.PLAYING)
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
            closeGame();
        }

        if (_state == GameState.MENU)
        {
            _state = GameState.PLAYING;
        }
    }

    private void closeGame()
    {
        Container p = this.getTopLevelAncestor();
        p.dispatchEvent(
                new WindowEvent((JFrame) p, WindowEvent.WINDOW_CLOSING));
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        // TODO Auto-generated method stub

    }

}
