package snakegame.fachwert.enums;

/*
 * Fachwert Enum Klasse f�r den Men�-Text
 */
public enum MenuText
{
    STARTGAME("Start Game"), SOUND("Sound"), MUSIC("Music"), RESUME(
            "Resume"), CLOSE("Close"), HIGHSCORE("Highscore");

    private String _text;

    /*
     * @param text String einer der Men�-Punkte
     */
    MenuText(String text)
    {
        _text = text;
    }

    /*
     * @return liefert den Text String zur�ck
     */
    public String getText()
    {
        return _text;
    }
}
