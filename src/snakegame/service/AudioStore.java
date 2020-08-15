package snakegame.service;

import java.io.File;
import java.util.HashMap;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import snakegame.fachwert.enums.AudioName;

/*
 * Klasse AudioStore für die Audiodateien des Spiels
 */
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

    /*
     * @param key AudioName
     * @return gibt den Sound zurück
     */
    public static File getSound(AudioName key)
    {
        return _audios.get(key);
    }

    /*
     * Schalter, der die SoundEffekte an- und ausschaltet
     */
    public static void toggleSoundeffects()
    {
        _sound = !_sound;
    }

    /*
     * Schalter, der die Musik an- und ausschaltet
     */
    public static void toggleMusic()
    {
        _music = !_music;
        if (_clip != null)
        {
            _clip.stop();
        }
        playMusic(AudioName.GOURMETRACE);

    }

    /*
     * Spielt die Sounds des Spiels ab
     */
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

    /*
     * Spielt die Musik des Spiels ab
     */
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
