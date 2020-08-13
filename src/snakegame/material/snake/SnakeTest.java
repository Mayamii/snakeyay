package snakegame.material.snake;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import snakegame.fachwert.Position;
import snakegame.fachwert.enums.SnakeState;
import snakegame.material.food.EwwFood;
import snakegame.material.food.FastFood;
import snakegame.material.food.InverseFood;
import snakegame.material.food.InvincibleFood;
import snakegame.material.food.NormalFood;
import snakegame.material.food.SlowFood;
import snakegame.material.food.SuperFood;

public class SnakeTest
{
    @Test
    public void testeEats()
    {
        // NORMAL SUPER EWW
        Position position = new Position(1, 1);
        Snake snake = new Snake(position);
        NormalFood normalfood = new NormalFood();
        InverseFood inversefood = new InverseFood();
        SuperFood superfood = new SuperFood();
        InvincibleFood invinciblefood = new InvincibleFood();
        SlowFood slowfood = new SlowFood();
        FastFood fastfood = new FastFood();
        EwwFood ewwfood = new EwwFood();

        assertEquals(0, snake.getScore());

        assertEquals(snake.getState(), SnakeState.ALIVE);
        snake.eats(normalfood);
        assertEquals(1, snake.getScore());
        assertEquals(0, snake.getEffectDuration());
        assertEquals(snake.getState(), SnakeState.ALIVE);

        for (int i = snake.getEffectDuration(); i >= 0; i--)
        {
            assertEquals(i, snake.getEffectDuration());
            snake.update();

        }
        assertEquals(snake.getState(), SnakeState.ALIVE);
        snake.eats(superfood);
        assertEquals(4, snake.getScore());
        assertEquals(0, snake.getEffectDuration());
        assertEquals(snake.getState(), SnakeState.ALIVE);

        for (int i = snake.getEffectDuration(); i >= 0; i--)
        {
            assertEquals(i, snake.getEffectDuration());
            snake.update();

        }
        assertEquals(snake.getState(), SnakeState.ALIVE);
        snake.eats(inversefood);
        assertEquals(5, snake.getScore());
        assertEquals(30, snake.getEffectDuration());
        assertEquals(snake.getState(), SnakeState.INVERTED);

        for (int i = snake.getEffectDuration(); i >= 0; i--)
        {
            assertEquals(i, snake.getEffectDuration());
            snake.update();

        }
        assertEquals(snake.getState(), SnakeState.ALIVE);
        snake.eats(ewwfood);
        assertEquals(2, snake.getScore());
        assertEquals(0, snake.getEffectDuration());

        for (int i = snake.getEffectDuration(); i >= 0; i--)
        {
            assertEquals(i, snake.getEffectDuration());
            snake.update();

        }
        assertEquals(snake.getState(), SnakeState.ALIVE);
        snake.eats(invinciblefood);
        assertEquals(5, snake.getScore());
        assertEquals(50, snake.getEffectDuration());
        assertEquals(snake.getState(), SnakeState.INVINCIBLE);

        for (int i = snake.getEffectDuration(); i >= 0; i--)
        {
            assertEquals(i, snake.getEffectDuration());
            snake.update();

        }
        assertEquals(snake.getState(), SnakeState.ALIVE);
        snake.eats(slowfood);
        assertEquals(6, snake.getScore());
        assertEquals(20, snake.getEffectDuration());
        assertEquals(snake.getState(), SnakeState.SLOW);

        for (int i = snake.getEffectDuration(); i >= 0; i--)
        {
            assertEquals(i, snake.getEffectDuration());
            snake.update();

        }
        assertEquals(snake.getState(), SnakeState.ALIVE);
        snake.eats(fastfood);
        assertEquals(7, snake.getScore());
        assertEquals(60, snake.getEffectDuration());
        assertEquals(snake.getState(), SnakeState.FAST);

    }

}
