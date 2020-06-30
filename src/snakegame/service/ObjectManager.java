package snakegame.service;

import java.util.ArrayList;

import snakegame.fachwert.enums.State;
import snakegame.material.food.EwwFood;
import snakegame.material.food.FastFood;
import snakegame.material.food.Food;
import snakegame.material.food.InverseFood;
import snakegame.material.food.InvincibleFood;
import snakegame.material.food.NormalFood;
import snakegame.material.food.SlowFood;
import snakegame.material.food.SuperFood;
import snakegame.material.snake.Snake;

public class ObjectManager
{
    private Snake _snake;
    ArrayList<Food> _foodlist;

    //später noch andere foods und Labyrinth

    public ObjectManager(Snake sneek)
    {
        _snake = sneek;
        _foodlist = new ArrayList<>();
        addRandomBadFood();
        addRandomGoodFood();
    }

    private int randomInt()
    {
        return (int) (100.0 * Math.random());
    }

    public void addRandomFood(Food food)
    {
        switch (food.getEffect())
        {
        case NORMAL:
        case SUPER:
        case SLOW:
        case INVINCIBLE:

            addRandomGoodFood();
            break;

        case EWW:
        case FAST:
        case INVERSE:
            addRandomBadFood();
            break;

        }

    }

    private void addRandomGoodFood()
    {

        int i = randomInt();
        //prozente für Foodwahrscheinlichkeit
        // alle foods zusammen müssen 100 ergeben!!!
        int normalfood = 60;
        int superfood = 10;
        int invinciblefood = 5;
        int slowfood = 25;

        //hier werden die food ints in prozente umgewandelt
        superfood = superfood + normalfood;
        invinciblefood = invinciblefood + superfood;
        slowfood = slowfood + invinciblefood;

        if (i <= normalfood)
        {
            addFoodtoList(new NormalFood());

        }
        else if (normalfood < i && i <= superfood)
        {
            addFoodtoList(new SuperFood());
        }
        else if (superfood < i && i <= invinciblefood)
        {
            addFoodtoList(new InvincibleFood());
        }
        else if (invinciblefood < i && i <= slowfood)
        {
            addFoodtoList(new SlowFood());
        }

    }

    private void addRandomBadFood()
    {
        int i = randomInt();
        //prozente für Foodwahrscheinlichkeit
        // alle foods zusammen müssen 100 ergeben!!!
        int ewwfood = 40;
        int fastfood = 40;
        int inversefood = 20;

        //hier werden die food ints in prozente umgewandelt
        fastfood = fastfood + ewwfood;
        inversefood = inversefood + fastfood;

        if (i <= ewwfood)
        {
            addFoodtoList(new EwwFood());

        }
        else if (ewwfood < i && i <= fastfood)
        {
            addFoodtoList(new FastFood());
        }
        else if (fastfood < i && i <= inversefood)
        {
            addFoodtoList(new InverseFood());
        }

    }

    public int getLengthList()
    {
        return _foodlist.size();
    }

    public void giveFood(Food fuud)
    {
        _foodlist.add(fuud);
    }

    public boolean bitesOwnBody()
    {

        for (int i = 0; i < _snake.getLength() - 1; i++)
        {
            if (_snake.getBodyX(i) == _snake.getHeadX()
                    && _snake.getBodyY(i) == _snake.getHeadY())
            {
                return true;
            }
        }

        return false;
    }

    public Food returnFood(int i)
    {
        return _foodlist.get(i);
    }

    public void addFoodtoList(Food food)
    {
        _foodlist.add(food);
    }

    public void removeFoodfromList(Food food)
    {
        _foodlist.remove(food);
    }

    public void checkFoodCollision()
    {
        for (Food food : _foodlist)
        {
            if (food.getX() == _snake.getHeadX()
                    && food.getY() == _snake.getHeadY())
            {
                _snake.eats(food);
                removeFoodfromList(food);
                addRandomFood(food);

                return;
            }
        }
    }

    public boolean hitsLabyrinth()
    {
        return false;
    }

    public void update()
    {
        if ((bitesOwnBody() || hitsLabyrinth())
                && _snake.getState() != State.INVINCIBLE)
        {
            _snake.dies();
        }
        checkFoodCollision();

    }

}
