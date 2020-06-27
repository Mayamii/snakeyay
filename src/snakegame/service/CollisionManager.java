package snakegame.service;
import java.util.ArrayList;

import snakegame.material.food.Food;
import snakegame.material.snake.Snake;

public class CollisionManager
{
    private Snake _snake;
    ArrayList<Food> _foodlist;

    //später noch andere foods und Labyrinth

    public CollisionManager(Snake sneek, Food fuud)
    {
        _snake = sneek;
        _foodlist = new ArrayList<>();
        _foodlist.add(fuud);
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

    public void checkFoodCollision()
    {
        for (Food food : _foodlist)
        {
            if (food.getX() == _snake.getHeadX()
                    && food.getY() == _snake.getHeadY())
            {
                _foodlist.remove(food);
                _snake.eats(food);
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
        if (bitesOwnBody() || hitsLabyrinth())
        {
            _snake.dies();
        }
        checkFoodCollision();

    }

}
