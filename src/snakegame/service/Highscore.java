package snakegame.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import snakegame.fachwert.enums.GameState;
import snakegame.material.ScoreEntry;

/*
 * Klasse zum Erstellen von Highscores
 *
 */
public class Highscore
{
    private final String _filename = "./Highscore.txt";
    private ArrayList<ScoreEntry> _scores = new ArrayList<>();
    GameState _oldGameState;

    /*
     * Liest den aktuellen Highscore aus einer Liste aus
     */
    public Highscore()
    {
        readScoreFromFile();
    }

    /*
     * F�gt einen neuen Eintrag zum Highscore hinzu
     * @param name Name des Spielers
     * @param score erreichte Punktzahl des Spielers
     *
     */
    public void addNewEntry(String name, int score)
    {
        if (checkName(name))
        {
            _scores.add(new ScoreEntry(name, score));
        }
        else
        {
            _scores.add(new ScoreEntry("anonym", score));
        }
        Collections.sort(_scores);
        writeScoretoFile();
    }

    /*
     * Pr�ft ob der Name des Spielers eine g�ltige Eingabe ist
     * @return gibt einen boolean zur�ck, ob der eingegebene Name g�ltig ist
     */
    private boolean checkName(String name)
    {
        if (name == null)
        {
            return false;
        }

        return (name.matches("^[a-zA-Z]{1,8}$"));

    }

    /*
     * Schreibt einen Punktestand zu der Highscore Datei hinzu
     */
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

    /*
     * liest einen Punktestand aus der Datei aus
     */
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

    /*
     * Setzt den Spielstatus
     * @param gamestate n�chster Spielstatus
     */
    public void setGameState(GameState gamestate)
    {
        _oldGameState = gamestate;
    }

    /*
     * @return gibt den Spielstatus zur�ck
     */
    public GameState getGameState()
    {
        return _oldGameState;
    }

    /*
     * @param i Platzierung auf der Highscore Liste
     * @return gibt den Punktestandeintrag ScoreEntry an der Stelle i zur�ck
     */
    public ScoreEntry getScore(int i)
    {
        return _scores.get(i);
    }
}
