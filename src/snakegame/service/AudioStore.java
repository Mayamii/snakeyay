package snakegame.service;

import java.io.File;
import java.util.HashMap;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import snakegame.fachwert.enums.AudioName;

public class AudioStore
{
    private static HashMap<AudioName, File> _audios;
    private static boolean _sound;
    private static boolean _music;
    private static Clip _clip;

    static
    {
        _audios = new HashMap<>();
        _audios.put(AudioName.GOURMETRACE, new File("gourmet.wav"));
        _audios.put(AudioName.EAT, new File("smb_warning.wav"));
        _sound = true;
        _music = true;
    }

    public static File getSound(AudioName key)
    {
        return _audios.get(key);
    }

    public static void toggleSoundeffects()
    {
        _sound = !_sound;

    }

    public static void toggleMusic()
    {
        _music = !_music;
        if (_clip != null)
        {
            _clip.stop();
        }
        playMusic(AudioName.GOURMETRACE);

    }

    public static void playAudio(AudioName sound)
    {
        if (!_sound)
        {
            return;
        }

        try
        {
            File soundEffect = getSound(sound);
            AudioInputStream audioInputStream = AudioSystem
                .getAudioInputStream(soundEffect.getAbsoluteFile());
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    public static void playMusic(AudioName sound)
    {

        if (!_music)
        {
            return;
        }
        try

        {
            File soundEffect = getSound(sound);
            AudioInputStream audioInputStream = AudioSystem
                .getAudioInputStream(soundEffect.getAbsoluteFile());
            _clip = AudioSystem.getClip();
            _clip.open(audioInputStream);
            _clip.loop(-1);
            _clip.start();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
