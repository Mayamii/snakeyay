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

public class Snake implements Paintable
{
    private boolean _moving;
    private Head _head;
    private Tail _tail;
    private boolean _dead = false;
    private int _score;
    private SnakeState _state;
    private int _updateCounter;

    public Snake(Position pos)
    {
        _head = new Head(pos);
        _tail = new Tail(pos, ImageStore.getImage(PictureName.SNAKEBODY));
        _moving = false;
        _score = 0;
        _state = SnakeState.ALIVE;
        _updateCounter = 0;
    }

    public int getLength()
    {
        return _tail.getLength() + 1;
    }

    public void eats(Food food)
    {
        Effect effect = food.getEffect();
        if (_updateCounter == 0)
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
                _updateCounter = 30;
                break;
            case SUPER:
                _score += 3;

                break;
            case INVINCIBLE:
                _score += 3;
                _tail.growenable(1);
                _state = SnakeState.INVINCIBLE;
                _updateCounter = 50;
                break;
            case SLOW:
                _score++;
                _tail.growenable(1);
                _state = SnakeState.SLOW;
                _updateCounter = 20;

                break;
            case FAST:
                _score++;
                _tail.growenable(3);
                _state = SnakeState.FAST;
                _updateCounter = 60;

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

    public int getHeadX()
    {
        return _head.getX();
    }

    public int getHeadY()
    {
        return _head.getY();
    }

    public void setMove(boolean enabled)
    {
        _moving = enabled;
    }

    @Override
    public void paint(Graphics g, Component frame)
    {
        _head.paint(g, frame);
        _tail.paint(g, frame);
    }

    public SnakeState getSnakeState()
    {
        return _state;
    }

    @Override
    public void update()
    {
        _head.setGod(_state == SnakeState.INVINCIBLE);
        _tail.setGod(_state == SnakeState.INVINCIBLE);
        if (_moving)
        {
            _tail.setNextPosition(_head.getPosition());

            _tail.update();
            _head.update();
        }
        if (_updateCounter > 0)
        {
            _updateCounter--;
        }
        else
        {
            _state = SnakeState.ALIVE;
        }
    }

    public int getScore()
    {
        return _score;
    }

    @Override
    public int getX()
    {
        return getHeadX();
    }

    @Override
    public int getY()
    {
        return getHeadY();
    }

    public void setDirection(Direction dir)
    {
        if (_state == SnakeState.INVERTED)
        {
            dir = dir.inverse();
        }
        _head.setDirection(dir);

    }

    public int getBodyX(int bodymassindex)
    {

        return _tail.getBodyX(bodymassindex);
    }

    public int getBodyY(int bodymassindex)
    {

        return _tail.getBodyY(bodymassindex);
    }

    public void dies()
    {
        _state = SnakeState.DEAD;
        _moving = false;
    }

    public int getScore()
    {
        return _score;
    }

    public void setState(SnakeState state)
    {
        _state = state;
    }

    public SnakeState getState()
    {
        return _state;
    }

}
