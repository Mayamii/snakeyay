package snakegame.fachwert.enums;

/*
 * Fachwert Enum Klasse für den Menü-Text
 */
public enum MenuText
{
    STARTGAME("Start Game"), SOUND("Sound"), MUSIC("Music"), RESUME(
            "Resume"), CLOSE("Close"), HIGHSCORE("Highscore");

    private String _text;

    /*
     * @param text String einer der Menü-Punkte
     */
    MenuText(String text)
    {
        _text = text;
    }

    /*
     * @return liefert den Text String zurück
     */
    public String getText()
    {
        return _text;
    }
}
