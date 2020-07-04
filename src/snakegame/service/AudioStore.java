package snakegame.service;

import java.io.File;
import java.util.HashMap;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

import snakegame.fachwert.enums.AudioName;

public class AudioStore
{
    private static HashMap<AudioName, File> _audios;
    private static boolean _sound;
    private static boolean _music;

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
        Clip clip = null;
        try
        {
            clip = AudioSystem.getClip();
        }
        catch (LineUnavailableException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        clip.stop();
        playAudio(AudioName.GOURMETRACE);

    }

    public static void playAudio(AudioName sound)
    {
        if (sound == AudioName.EAT && !_sound)
        {
            return;
        }
        if (sound == AudioName.GOURMETRACE && !_music)
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
            if (sound == AudioName.EAT)
            {

            }
            if (sound == AudioName.GOURMETRACE)
            {
                clip.loop(-1);
                ;
            }
            clip.start();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
