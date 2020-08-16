package snakegame.service;

import java.util.ArrayList;

import snakegame.fachwert.enums.AudioName;
import snakegame.fachwert.enums.SnakeState;
import snakegame.material.food.EwwFood;
import snakegame.material.food.FastFood;
import snakegame.material.food.Food;
import snakegame.material.food.InverseFood;
import snakegame.material.food.InvincibleFood;
import snakegame.material.food.NormalFood;
import snakegame.material.food.SlowFood;
import snakegame.material.food.SuperFood;
import snakegame.material.snake.Snake;

/*
 * ObjectManager Klasse 
 */
public class ObjectManager
{
    private Snake _snake;
    ArrayList<Food> _foodlist;

    //sp�ter sind hier noch andere Foods und Labyrinth hinzuf�gbar

    public ObjectManager(Snake sneek)
    {
        _snake = sneek;
        _foodlist = new ArrayList<>();
        addRandomBadFood();
        addRandomGoodFood();
    }

    /*
     * @return gibt einen zuf�lligen Integer Wert aus
     */
    private int randomInt()
    {
        return (int) (100.0 * Math.random());
    }

    /*
     * F�gt Essen dem Spielfeld hinzu 
     * Je nach Effekt wird zwischen Gutem und Schlechtem Essen unterschieden
     * @param food Essen, was im Spielfeld angezeigt wird
     * 
     */
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

    /*
     * F�gt ein zuf�lliges gutes Essen hinzu
     */
    private void addRandomGoodFood()
    {

        int i = randomInt();
        //prozente f�r Foodwahrscheinlichkeit
        // alle foods zusammen m�ssen 100 ergeben!
        int normalfood = 50;
        int superfood = 10;
        int invinciblefood = 15;
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

    /*
     * F�gt ein zuf�lliges bad Food zu dem Spielfeld hinzu
     */
    private void addRandomBadFood()
    {
        int i = randomInt();
        //prozente f�r Foodwahrscheinlichkeit
        // alle foods zusammen m�ssen 100 ergeben!
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

    /*
     * @return gibt die L�nge der Essensliste (foodlist) zur�ck
     */
    public int getLengthList()
    {
        return _foodlist.size();
    }

    /*
     * F�gt ein Essen (Food) zur Essensliste (foodlist) hinzu
     */
    public void giveFood(Food fuud)
    {
        _foodlist.add(fuud);
    }

    /*
     * Pr�ft, ob die Schlange in ihren eigenen K�rper hineinbei�t
     * @return wahr, falls sie sich bei�t 
     */
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

    /*
     * Gibt ein Essen der Liste zur�ck
     * @param i Stelle der Liste
     * @return Essen aus der Essensliste an der Stelle i
     */
    public Food returnFood(int i)
    {
        return _foodlist.get(i);
    }

    /*
     * F�gt ein Food der Foodlist hinzu
     * @param food Das Essen, das der Liste hinzugef�gt wird
     */
    public void addFoodtoList(Food food)
    {
        _foodlist.add(food);
    }

    /*
     * Entfernt ein Food aus der Foodlist
     * @param food Das Essen, das von der Liste entfernt wird
     */
    public void removeFoodfromList(Food food)
    {
        _foodlist.remove(food);
    }

    /*
     * Wenn sich der Kopf der Schlange auf derselben Position wie das
     * Food befindet, wird das Food gegessen, das Essen aus der foodlist entfernt
     * und ein neues Food hinzugef�gt und ein Sound abgespielt (das Schmatzen der Schlange)
     */
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
                AudioStore.playAudio(AudioName.EAT);

                return;
            }
        }
    }

    /*
     * Methode f�r die Aktionen, die eintreten bzw. ausgef�hrt werden
     * Wenn die Schlange das Labyrinth ber�hrt 
     * Bisher noch kein Labyrinth erzeugt evtl. beim Ausbauen des Spiels verwenden
     * @return false, weil kein Labyrinth existiert, das getroffen werden kann
     */
    public boolean hitsLabyrinth()
    {
        return false;
    }

    /*
     * update
     */
    public void update()
    {
        if ((bitesOwnBody() || hitsLabyrinth())
                && _snake.getState() != SnakeState.INVINCIBLE)
        {
            _snake.dies();
        }
        checkFoodCollision();

    }

    /*
     * @return iefert den Punktestand (score) des Spiels
     */
    public int getScore()
    {
        return _snake.getScore();
    }

}
