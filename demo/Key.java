import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

import javalib.worldimages.OutlineMode;
import javalib.worldimages.OverlayImage;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.TextImage;
import javalib.worldimages.WorldImage;
import tester.Tester;

// represents a instrumental key
public class Key {

  boolean on = false;

  String name;

  int number;

  String filePathC;
  String filePathI;

  Key(String name, String right, String wrong, int num) {
    this.name = name;
    this.filePathC = right;
    this.filePathI = wrong;
    this.number = num;
  }

  Key(boolean clicked, String name, String right, String wrong, int num) {
    this(name, right, wrong, num);
    on = clicked;
  }

  void playCorrect() {

    try {
      File musicPath = new File(filePathC);
      AudioInputStream audio = AudioSystem.getAudioInputStream(musicPath);
      Clip clip = AudioSystem.getClip();
      clip.open(audio);
      clip.start();

      if (clip.isActive()) {
        clip.close();
      }
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  WorldImage drawKeys() {
    WorldImage textImage = new TextImage(number + "", Color.MAGENTA);
    return new OverlayImage(new RectangleImage(17, 150, OutlineMode.OUTLINE, Color.CYAN),
        new OverlayImage(textImage, new RectangleImage(17, 150, OutlineMode.SOLID, Color.WHITE)));
  }

  void playIncorrect() {

    try {
      File musicPath = new File(filePathI);
      AudioInputStream audio = AudioSystem.getAudioInputStream(musicPath);
      Clip clip = AudioSystem.getClip();
      clip.open(audio);
      clip.start();

      if (clip.isActive()) {
        clip.close();
      }
    }
    catch (Exception ex) {
      ex.printStackTrace();
    }
  }

  public boolean rightAnwer(Integer integer) {
    // TODO Auto-generated method stub
    return this.number == integer;
  }
}
