package snakegame.material;

public class ScoreEntry implements Comparable<ScoreEntry>
{
    private String _name;
    private int _score;

    public ScoreEntry(String name, int score)
    {
        _name = name;
        _score = score;
    }

    @Override
    public int compareTo(ScoreEntry o)
    {
        if (o._score > _score)
        {
            return -1;
        }
        else if (o._score < _score)
        {
            return 1;
        }
        else
        {
            return 0;
        }
    }

    @Override
    public String toString()
    {
        return _name + ";" + _score;

    }
}
