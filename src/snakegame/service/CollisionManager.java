package snakegame.service;

import java.util.ArrayList;

import snakegame.material.food.BadFood;
import snakegame.material.food.EwwFood;
import snakegame.material.food.FastFood;
import snakegame.material.food.Food;
import snakegame.material.food.GoodFood;
import snakegame.material.food.InverseFood;
import snakegame.material.food.InvincibleFood;
import snakegame.material.food.NormalFood;
import snakegame.material.food.SlowFood;
import snakegame.material.food.SuperFood;
import snakegame.material.snake.Snake;

public class CollisionManager
{
    private Snake _snake;
    ArrayList<Food> _foodlist;
    private int _foodPosition;
    private boolean _foundFood;
    private Food _food;

    //sp�ter noch andere foods und Labyrinth

    public CollisionManager(Snake sneek)
    {
        _snake = sneek;
        _foodlist = new ArrayList<>();
        addRandomFood();

        _foodPosition = 0;
        _foundFood = false;
    }

    private int randomInt()
    {
        return (int) (100.0 * Math.random());
    }

    public void addRandomFood(Food food)
    {
        if (food instanceof GoodFood)
        {
            int i = randomInt();
            //prozente f�r Foodwahrscheinlichkeit
            // alle foods zusammen m�ssen 100 ergeben!!!
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
        else if (food instanceof BadFood)
        {
            int i = randomInt();
            //prozente f�r Foodwahrscheinlichkeit
            // alle foods zusammen m�ssen 100 ergeben!!!
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

    }

    public void addRandomFood()
    {

        int i = randomInt();
        //prozente f�r Foodwahrscheinlichkeit
        // alle foods zusammen m�ssen 100 ergeben!!!
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

        i = randomInt();
        //prozente f�r Foodwahrscheinlichkeit
        // alle foods zusammen m�ssen 100 ergeben!!!
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

    public Food returnSavedFood()
    {
        return _food;
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
                _foodPosition = _foodlist.indexOf(food);
                _food = food;
                _foundFood = true;
                return;
            }
        }
    }

    public void setfoundFood(boolean b)
    {
        _foundFood = b;
    }

    public boolean getfoundFood()
    {
        return _foundFood;
    }

    public boolean hitsLabyrinth()
    {
        return false;
    }

    public void update()
    {
        if (bitesOwnBody() || hitsLabyrinth())
        {
            _snake.dies();
        }
        checkFoodCollision();

    }

    public int getFoodPosition()
    {
        return _foodPosition;
    }

}