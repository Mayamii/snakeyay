package snakegame.ui;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import snakegame.fachwert.Position;
import snakegame.fachwert.enums.AudioName;
import snakegame.fachwert.enums.Direction;
import snakegame.fachwert.enums.GameState;
import snakegame.fachwert.enums.MenuText;
import snakegame.fachwert.enums.PictureName;
import snakegame.fachwert.enums.SnakeState;
import snakegame.material.snake.Snake;
import snakegame.service.AudioStore;
import snakegame.service.Highscore;
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

    GameState _gameState;

    private Timer _timer;
    private int _delay = 100;

    private GameMenu _hauptmenu;
    private GameMenu _pausemenu;
    private HighscoreMenu _highscoremenu;

    private boolean _askForName;

    private Highscore _highscore;

    public Gameplay()
    {
        _gameState = GameState.MENU;
        _startposition = new Position(4, 4);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        createMenus();

        _snake = new Snake(_startposition);
        _sebastian = new ObjectManager(_snake);
        // _food = new Food();
        _askForName = true;
        _highscore = new Highscore();
        _highscoremenu = new HighscoreMenu(_highscore);

        _timer = new Timer(_delay, this);
        AudioStore.playMusic(AudioName.GOURMETRACE);
        _timer.start();

    }

    private void createMenus()
    {
        _hauptmenu = new GameMenu(new Position(248, 100), new Position(30, 30));
        _pausemenu = new GameMenu(new Position(248, 100), new Position(30, 30));

        // Die Schriftzüge sollen mitten in dem grünen Rechteck angezeigt werden
        _hauptmenu.add(new MenuItem(MenuText.STARTGAME, new Position(70, 20)));
        _hauptmenu.add(new MenuItem(MenuText.HIGHSCORE, new Position(71, 40)));
        _hauptmenu.add(
                new ToggleMenuItem(MenuText.SOUND, new Position(72, 60), true));
        _hauptmenu.add(
                new ToggleMenuItem(MenuText.MUSIC, new Position(72, 80), true));
        _hauptmenu.add(new MenuItem(MenuText.CLOSE, new Position(72, 100)));

        //Dies sind die Schriftz�ge des Pausenmen�s
        _pausemenu.add(new MenuItem(MenuText.RESUME, new Position(70, 20)));
        _pausemenu.add(new MenuItem(MenuText.HIGHSCORE, new Position(71, 40)));
        _pausemenu.add(
                new ToggleMenuItem(MenuText.SOUND, new Position(72, 60), true));
        _pausemenu.add(
                new ToggleMenuItem(MenuText.MUSIC, new Position(72, 80), true));
        _pausemenu.add(new MenuItem(MenuText.CLOSE, new Position(72, 100)));

    }

    public void paint(Graphics g)
    {
        // draw title image border
        alwaysPaintTHIS(g);

        if (_gameState == GameState.PLAYING)
        {
            paintSnakeAndCookies(g);
        }

        //Menu zeichnen
        if (_gameState == GameState.MENU)
        {
            _hauptmenu.paint(g, this);
        }

        if (_gameState == GameState.PAUSE)
        {
            _pausemenu.paint(g, this);
        }

        if (_gameState == GameState.GAMEOVER)
        {
            paintSnakeAndCookies(g);

            g.setColor(Color.white);
            g.setFont(new Font("arial", Font.BOLD, 50));
            g.drawString("Game Over", 300, 300);

            g.setFont(new Font("arial", Font.BOLD, 20));
            g.drawString("Press Space to restart", 350, 340);
        }
        if (_gameState == GameState.HIGHSCORE)
        {

            _highscoremenu.paint(g, this);
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
        if (_gameState == GameState.PLAYING)
        {
            _snake.update();
            _sebastian.update();
            updateDelay();
        }

        if (_snake.getState() == SnakeState.DEAD)
        {
            _gameState = GameState.GAMEOVER;
            if (_askForName)
            {
                String eingabe = JOptionPane.showInputDialog(null,
                        "Whats your name?", "Name?", JOptionPane.PLAIN_MESSAGE);
                _askForName = false;
                _highscore.addNewEntry(eingabe, _sebastian.getScore());
            }
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
        _gameState = GameState.PLAYING;
        _askForName = true;
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (_gameState == GameState.MENU)
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
                executeMenuSelectionFor(_hauptmenu);
            }

            repaint();
        }
        else if (_gameState == GameState.PAUSE)
        {
            if (e.getKeyCode() == KeyEvent.VK_P)
            {
                resumeGame();
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
                executeMenuSelectionFor(_pausemenu);
            }
        }
        else if (_gameState == GameState.GAMEOVER)
        {
            if (e.getKeyCode() == KeyEvent.VK_SPACE)
            {
                newGame();
                repaint();
            }
        }
        else if (_gameState == GameState.PLAYING)
        {
            if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            {
                _snake.setDirection(Direction.RIGHT);
            }
            if (e.getKeyCode() == KeyEvent.VK_LEFT)
            {
                _snake.setDirection(Direction.LEFT);
            }

            if (e.getKeyCode() == KeyEvent.VK_UP)
            {
                _snake.setDirection(Direction.UP);
            }

            if (e.getKeyCode() == KeyEvent.VK_DOWN)
            {
                _snake.setDirection(Direction.DOWN);
            }

            if (e.getKeyCode() == KeyEvent.VK_P)
            {
                pauseGame();
            }
        }
        else if (_gameState == GameState.HIGHSCORE)
        {
            if (e.getKeyCode() == KeyEvent.VK_ENTER)
            {
                _gameState = _highscore.getGameState();
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE)
        {
            closeGame();
        }
    }

    private void pauseGame()
    {
        _gameState = GameState.PAUSE;
    }

    private void executeMenuSelectionFor(GameMenu menu)
    {
        MenuItem menuItem = menu.getSelectedItem();

        switch (menuItem.getText())
        {
        case STARTGAME:
            newGame();
            break;
        case HIGHSCORE:
            showHighscore();
            break;
        case SOUND:
            AudioStore.toggleSoundeffects();
            toggleSoundMenuItems();
            break;
        case MUSIC:
            AudioStore.toggleMusic();
            toggleMusicMenuItems();
            break;
        case CLOSE:
            closeGame();
            break;
        case RESUME:
            resumeGame();
        default:
            break;
        }
    }

    private void showHighscore()
    {
        _highscore.setGameState(_gameState);
        _gameState = GameState.HIGHSCORE;

    }

    private void resumeGame()
    {
        _gameState = GameState.PLAYING;

    }

    private void toggleMusicMenuItems()
    {
        ((ToggleMenuItem) _hauptmenu.getMenuItemBy(MenuText.MUSIC)).toggle();
        ((ToggleMenuItem) _pausemenu.getMenuItemBy(MenuText.MUSIC)).toggle();
    }

    private void toggleSoundMenuItems()
    {
        ((ToggleMenuItem) _hauptmenu.getMenuItemBy(MenuText.SOUND)).toggle();
        ((ToggleMenuItem) _pausemenu.getMenuItemBy(MenuText.SOUND)).toggle();
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
