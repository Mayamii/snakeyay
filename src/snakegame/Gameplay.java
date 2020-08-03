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
import snakegame.fachwert.enums.AudioName;
import snakegame.fachwert.enums.Direction;
import snakegame.fachwert.enums.GameState;
import snakegame.fachwert.enums.PictureName;
import snakegame.fachwert.enums.SnakeState;
import snakegame.material.snake.Snake;
import snakegame.service.AudioStore;
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
    private Position _startposition;

    GameState _currentState;
    GameState _lastState;

    private Timer _timer;
    private int _delay = 100;

    private GameMenu _hauptmenu;
    private GameMenu _pausemenu;

    public Gameplay()
    {
        _currentState = GameState.MENU;
        _startposition = new Position(4, 4);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        createMenus();

        _snake = new Snake(_startposition);
        _sebastian = new ObjectManager(_snake);
        // _food = new Food();

        _timer = new Timer(_delay, this);
        AudioStore.playMusic(AudioName.GOURMETRACE);
        _timer.start();

    }

    private void createMenus()
    {
        _hauptmenu = new GameMenu(new Position(10, 10), new Position(20, 20),
                Color.BLUE);
        _pausemenu = new GameMenu(new Position(10, 10), new Position(20, 20),
                Color.GREEN);

        ToggleMenuItem sound = new ToggleMenuItem("Sound", new Position(68, 50),
                true);
        ToggleMenuItem music = new ToggleMenuItem("Music", new Position(69, 70),
                true);

        // Die Schriftz�ge sollen mitten in dem gr�nen Rechteck angezeigt werden
        _hauptmenu.add(new MenuItem("Start Game", new Position(70, 30)));
        //        _hauptmenu.add(new MenuItem("Highscore ", new Position(71, 40)));
        _hauptmenu.add(sound);
        _hauptmenu.add(music);
        _hauptmenu.add(new MenuItem("Close", new Position(75, 90)));

        //Dies sind die Schriftz�ge des Pausenmen�s
        _pausemenu.add(new MenuItem("Resume", new Position(72, 30)));
        _pausemenu.add(sound);
        _pausemenu.add(music);
        _pausemenu.add(new MenuItem("Close", new Position(75, 90)));
    }

    public void paint(Graphics g)
    {
        // draw title image border
        alwaysPaintTHIS(g);

        if (_currentState == GameState.PLAYING)
        {
            paintSnakeAndCookies(g);
        }

        //Menu zeichnen
        if (_currentState == GameState.MENU)
        {
            _hauptmenu.paint(g);
        }

        if (_currentState == GameState.PAUSE)
        {
            _pausemenu.paint(g);
        }

        if (_currentState == GameState.GAMEOVER)
        {
            paintSnakeAndCookies(g);

            g.setColor(Color.white);
            g.setFont(new Font("arial", Font.BOLD, 50));
            g.drawString("Game Over", 300, 300);

            g.setFont(new Font("arial", Font.BOLD, 20));
            g.drawString("Press Space to restart", 350, 340);
        }

        g.dispose();
    }

    private void paintSnakeAndCookies(Graphics g)
    {
        _snake.paint(g, this);

        for (int i = 0; i < _sebastian.getLengthList(); i++)
        {
            _sebastian.returnFood(i)
                .paint(g, this);
        }
    }

    private void alwaysPaintTHIS(Graphics g)
    {
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
        if (_currentState == GameState.PLAYING)
        {
            _snake.update();
            _sebastian.update();
            updateDelay();
        }

        if (_snake.getState() == SnakeState.DEAD)
        {
            _currentState = GameState.GAMEOVER;
        }
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

    private void newGame()
    {
        _snake = new Snake(_startposition);
        _sebastian = new ObjectManager(_snake);
        _currentState = GameState.PLAYING;
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        _lastState = _currentState;

        System.out.println("State: " + _currentState + " Key:"
                + KeyEvent.getKeyText(e.getKeyCode()));
        if (_lastState == GameState.MENU)
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

                    newGame();
                    break;
                case "Highscore":
                    break;
                case "Sound":
                    AudioStore.toggleSoundeffects();
                    ((ToggleMenuItem) menuItem).toggle();
                    break;
                case "Music":
                    AudioStore.toggleMusic();
                    ((ToggleMenuItem) menuItem).toggle();
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

        if (_lastState == GameState.PAUSE)
        {

            if (e.getKeyCode() == KeyEvent.VK_P)
            {
                _currentState = GameState.PLAYING;
            }

            if (e.getKeyCode() == KeyEvent.VK_DOWN)
            {
                _pausemenu.selectNext();
            }

            if (e.getKeyCode() == KeyEvent.VK_UP)
            {
                _pausemenu.selectPrevious();
            }

            if (e.getKeyCode() == KeyEvent.VK_ENTER)
            {
                MenuItem menuItem = _pausemenu.getSelectedItem();

                switch (menuItem.getText())
                {
                case "Resume":
                    _currentState = GameState.PLAYING;
                    break;
                case "Sound":
                    AudioStore.toggleSoundeffects();
                    ((ToggleMenuItem) menuItem).toggle();
                    break;
                case "Music":
                    AudioStore.toggleMusic();
                    ((ToggleMenuItem) menuItem).toggle();
                    break;
                case "Close":
                    closeGame();
                    break;
                }
            }
        }

        if (_lastState == GameState.GAMEOVER)
        {
            if (e.getKeyCode() == KeyEvent.VK_SPACE)
            {
                newGame();
                repaint();
            }
        }

        if (_lastState == GameState.PLAYING)

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

            if (e.getKeyCode() == KeyEvent.VK_P)
            {
                _currentState = GameState.PAUSE;
            }

        }

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            closeGame();
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

    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }
}
