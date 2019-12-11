package wargame;

import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;
/**
 *
 * @author alekspashinin
 */
public class Sound extends JFrame{

    public Sound() {
        try {
            File soundFile = new File("Music/click.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        }
        catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
        }
    }
}