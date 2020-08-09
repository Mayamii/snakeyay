package snakegame.fachwert.enums;

public enum MenuText
{
    STARTGAME("Start Game"), SOUND("Sound"), MUSIC("Music"), RESUME(
            "Resume"), CLOSE("Close"), HIGHSCORE("Highscore");

    private String _text;

    MenuText(String text)
    {
        _text = text;
    }

    public String getText()
    {
        return _text;
    }
}
