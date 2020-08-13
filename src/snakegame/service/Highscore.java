package snakegame.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import snakegame.fachwert.enums.GameState;
import snakegame.material.ScoreEntry;

public class Highscore
{
    private final String _filename = "./Highscore.txt";
    private ArrayList<ScoreEntry> _scores = new ArrayList<>();
    GameState _oldGameState;

    public Highscore()
    {
        readScoreFromFile();
    }

    public void addNewEntry(String name, int score)
    {
        if (checkName(name))
        {
            _scores.add(new ScoreEntry(name, score));
        }
        else
        {
            _scores.add(new ScoreEntry("IDIOT", score));
        }
        Collections.sort(_scores);
        writeScoretoFile();
    }

    private boolean checkName(String name)
    {
        return (name.matches("^[a-zA-Z]{1,8}$"));

    }

    void writeScoretoFile()
    {
        try (FileWriter writer = new FileWriter(_filename, false))
        {
            for (int i = 0; i < 5; i++)
            {
                writer.write(_scores.get(i) + "\n");
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    void readScoreFromFile()
    {
        try (FileReader reader = new FileReader(_filename))
        {
            BufferedReader br = new BufferedReader(reader);

            String line;
            while ((line = br.readLine()) != null)
            {
                String[] eingabe = line.split(";");

                _scores.add(new ScoreEntry(eingabe[0],
                        Integer.parseInt(eingabe[1])));
            }
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
