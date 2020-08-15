package snakegame.material.snake;

import java.awt.Component;
import java.awt.Graphics;

import snakegame.fachwert.Position;
import snakegame.fachwert.enums.Direction;
import snakegame.fachwert.enums.Effect;
import snakegame.fachwert.enums.PictureName;
import snakegame.fachwert.enums.SnakeState;
import snakegame.material.Paintable;
import snakegame.material.food.Food;
import snakegame.service.ImageStore;

/*
 * Die Klasse Snake enthält alle Methoden und Variablen,
 * die die Schlange und ihren Status, Kopf- und Schwanz, Punktzahl betreffen.
 */
public class Snake implements Paintable
{
    private Head _head;
    private Tail _tail;
    private int _score;
    private SnakeState _state;
    private int _effectDuration;

    /*
     * Erstellt eine Schlange an der Position pos
     * @param pos Positionen der Schlange
     */
    public Snake(Position pos)
    {
        _head = new Head(pos);
        _tail = new Tail(pos, ImageStore.getImage(PictureName.SNAKEBODY));
        _score = 0;
        _state = SnakeState.ALIVE;
        _effectDuration = 0;
    }

    /*
     * @return die Länge der Schlange
     */
    public int getLength()
    {
        return _tail.getLength() + 1;
    }

    /*
     * Eats definiert das Verhalten der Schlange wenn sie Essen 
     * mit unterschiedlichen Effekten frisst.
     * Die Punktzahl sowie die Länge werden verändert.
     * Bei manchem Funtkionen wird ebenfalls der Zustand geändert.
     * Manche Effekte sind zeitlich begrenzt und die Dauer wird festgelegt.
     */
    public void eats(Food food)
    {
        Effect effect = food.getEffect();
        if (_effectDuration == 0)
        {
            switch (effect)
            {
            case NORMAL:
                _score++;
                _tail.growenable(1);
                break;
            case INVERSE:
                _score++;
                _tail.growenable(1);
                _state = SnakeState.INVERTED;
                _effectDuration = 30;
                break;
            case SUPER:
                _score += 3;
                break;
            case INVINCIBLE:
                _score += 3;
                _tail.growenable(1);
                _state = SnakeState.INVINCIBLE;
                _effectDuration = 50;
                break;
            case SLOW:
                _score++;
                _tail.growenable(1);
                _state = SnakeState.SLOW;
                _effectDuration = 20;
                break;
            case FAST:
                _score++;
                _tail.growenable(3);
                _state = SnakeState.FAST;
                _effectDuration = 60;

                break;
            case EWW:
                subtractingScore(3);
                _tail.growenable(3);
                break;
            }
        }
        else
        {
            switch (effect)
            {
            case NORMAL:
                _score++;
                _tail.growenable(1);
                break;
            case INVERSE:
                _score++;
                _tail.growenable(1);
                break;
            case SUPER:
                _score += 3;
                break;
            case INVINCIBLE:
                _score += 3;
                _tail.growenable(1);
                break;
            case SLOW:
                _score++;
                _tail.growenable(1);
                break;
            case FAST:
                _score++;
                _tail.growenable(3);
                break;
            case EWW:
                subtractingScore(3);
                _tail.growenable(3);

                break;
            }
        }
    }

    /*
     * Zieht Punkte von der Punktzahl ab
     */
    private void subtractingScore(int i)
    {
        if (_score > i)
        {
            _score -= i;
        }
        else
        {
            _score = 0;
        }
    }

    /*
     * @return liefert die x-Position des Kopfes der Schlange
     */
    public int getHeadX()
    {
        return _head.getX();
    }

    /*
     * @return liefert die y-Position des Kopfes der Schlange
     */
    public int getHeadY()
    {
        return _head.getY();
    }

    /*
     * Zeichnet Tail und Head der Schlange
     */
    @Override
    public void paint(Graphics g, Component frame)
    {
        _head.paint(g, frame);
        _tail.paint(g, frame);
    }

    /*
     * @return liefert den Status der Schlange
     */
    public SnakeState getSnakeState()
    {
        return _state;
    }

    @Override
    /*
     * Update
     */
    public void update()
    {
        _head.setGod(_state == SnakeState.INVINCIBLE);
        _tail.setGod(_state == SnakeState.INVINCIBLE);

        _tail.setNextPosition(_head.getPosition());

        _tail.update();
        _head.update();

        if (_effectDuration > 0)
        {
            _effectDuration--;
        }
        else
        {
            _state = SnakeState.ALIVE;
        }
    }

    /*
     * @return den Punktestand
     */
    public int getScore()
    {
        return _score;
    }

    /*
     * @return liefert die x-Position des Kopfes der Schlange
     */
    @Override
    public int getX()
    {
        return getHeadX();
    }

    /*
     * @return liefert die y-Position des Kopfes der Schlange
     */
    @Override
    public int getY()
    {
        return getHeadY();
    }

    /*
     * Legt die Richtung der Schlange fest.
     * Falls der Spielzustand inverted ist, wird an der 
     * Richtung die Methode inverse aufgerufen und kehrt die 
     * Richtung um
     */
    public void setDirection(Direction dir)
    {
        if (_state == SnakeState.INVERTED)
        {
            dir = dir.inverse();
        }
        _head.setDirection(dir);
    }

    /*
     * @return liefert die x-Positon des Schwanzes
     */
    public int getBodyX(int bodyindex)
    {
        return _tail.getBodyX(bodyindex);
    }

    /*
     * @return liefert die y-Positon des Schwanzes
     */
    public int getBodyY(int bodyindex)
    {
        return _tail.getBodyY(bodyindex);
    }

    /*
     * Die Schlange stirbt und der Zustand wird auf DEAD gesetzt.
     */
    public void dies()
    {
        _state = SnakeState.DEAD;

    }

    /*
     * Der Zustand der Schlange wird gesetzt
     * @param state der Zustand der Schlange
     */
    public void setState(SnakeState state)
    {
        _state = state;
    }

    /*
     * Der Zustand der Schlange wird zurückgegeben
     * @return Zustand der Schlange
     */
    public SnakeState getState()
    {
        return _state;
    }

    /*
     * Die Dauer des Effects wird zurückgegeben
     * @return die Dauer des Effekts
     */
    public int getEffectDuration()
    {
        return _effectDuration;
    }

}
