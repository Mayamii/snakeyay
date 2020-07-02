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

    static
    {
        _audios = new HashMap<>();
        _audios.put(AudioName.GOURMETRACE, new File("gourmet.mp3"));
        _audios.put(AudioName.EAT, new File("smb_warning.wav"));

    }

    public static File getSound(AudioName key)
    {
        return _audios.get(key);
    }

    public static void playAudio(File sound)
    {
        try
        {
            File soundEffect = sound;
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
}
