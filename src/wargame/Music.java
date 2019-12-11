/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wargame;
import java.io.*;
import javax.sound.sampled.*;
import javax.swing.*;
/**
 *
 * @author alekspashinin
 */
public class Music extends JFrame{
    
   public Music() {     
      try {        
          File soundFile = new File("Music/ymca.wav"); //you could also get the sound file with an URL
          AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);              
         Clip clip = AudioSystem.getClip();
         clip.open(audioIn);
         FloatControl vc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
         vc.setValue(0);     ////SOUND VOLUME  
         clip.start();
      } 
      catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
      }
   }
}

