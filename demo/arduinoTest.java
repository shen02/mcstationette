import javalib.funworld.World;
import javalib.funworld.WorldScene;
import javalib.worldcanvas.WorldSceneBase;

import java.awt.Color;
import java.util.ArrayList;

import javalib.worldimages.CircleImage;
import javalib.worldimages.EmptyImage;
import javalib.worldimages.OutlineMode;
import javalib.worldimages.OverlayImage;
import javalib.worldimages.Posn;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.TextImage;
import javalib.worldimages.WorldEnd;
import javalib.worldimages.WorldImage;
import tester.Tester;

class Stationette extends World implements INumbers {

  boolean on;
  int index = 0;
  ArrayList<String> questions = new ArrayList<String>();
  ArrayList<Integer> answers = new ArrayList<Integer>();
  LED led;
  LED status;
  ArrayList<Key> keys = new ArrayList<Key>();
  WorldImage light;

  Button ledControl = new Button(false, 15);

  Stationette(int index, ArrayList<String> questions) {
    this.index = index;
    this.questions = questions;
    led = new LED(false);
    status = new LED(false);
    light = led.drawLed();
    if (index > 0 && index > questions.size() && questions.size() > 40) {
      worldEnds();
    }
    addKeys();
    makeSong(songs[5]);
  }

  Stationette(int index, ArrayList<String> questions, LED led, Button ledControl) {
    this(index, questions);
    this.led = led;
    this.ledControl = ledControl;
    WorldImage a = led.drawLed();
    light = a;
  }

  Stationette(boolean on, int index, ArrayList<String> questions, LED led, Button buttons) {
    this(index, questions, led, buttons);
    this.on = on;
  }

  public WorldScene makeScene() {
    WorldScene scene = new WorldScene(500, 500);

    if (on && index < questions.size() && index < answers.size()) {
      WorldImage textImage = new TextImage(questions.get(index), 30, Color.PINK);
      status = new LED(true, Color.RED);

      for (int i = 0; i < keys.size(); i++) {
        scene.placeImageXY(keys.get(i).drawKeys(), 400, 400);
      }

      return scene.placeImageXY(moniter, 250, 140).placeImageXY(moniterOutline, 250, 140)
          .placeImageXY(lcd, 250, 120).placeImageXY(textImage, 250, 120)
          .placeImageXY(ledbase, 150, 65).placeImageXY(light, 150, 65)
          .placeImageXY(status.drawLed(), 170, 65).placeImageXY(moniter, 250, 375)
          .placeImageXY(moniterOutline, 250, 375).placeImageXY(ledControl.drawButton(), 155, 310)
          .placeImageXY(new Button(true, 10).drawButton(), 355, 65)
          .placeImageXY(keys.get(0).drawKeys(), 215, 375)
          .placeImageXY(keys.get(1).drawKeys(), 230, 375)
          .placeImageXY(keys.get(2).drawKeys(), 245, 375)
          .placeImageXY(keys.get(3).drawKeys(), 260, 375)
          .placeImageXY(keys.get(4).drawKeys(), 275, 375)
          .placeImageXY(keys.get(5).drawKeys(), 290, 375)
          .placeImageXY(keys.get(6).drawKeys(), 305, 375)
          .placeImageXY(keys.get(7).drawKeys(), 320, 375)
          .placeImageXY(keys.get(8).drawKeys(), 335, 375)
          .placeImageXY(keys.get(9).drawKeys(), 350, 375)
          .placeImageXY(new Button(false, 30, 60).drawButton(), 155, 380)
          .placeImageXY(new TextImage("0 to", Color.MAGENTA), 155, 370)
          .placeImageXY(new TextImage("Send", Color.magenta), 155, 390);
    }
    else if (!on && index < questions.size() && index < answers.size()) {
      WorldImage textImage = new TextImage("- Journey Awaits -", 15, Color.PINK);

      return scene.placeImageXY(moniter, 250, 140).placeImageXY(moniterOutline, 250, 140)
          .placeImageXY(lcd, 250, 120).placeImageXY(ledbase, 150, 65).placeImageXY(light, 150, 65)
          .placeImageXY(moniter, 250, 375).placeImageXY(moniterOutline, 250, 375)
          .placeImageXY(status.drawLed(), 170, 65).placeImageXY(ledControl.drawButton(), 155, 310)
          .placeImageXY(textImage, 250, 120)
          .placeImageXY(new Button(false, 10).drawButton(), 355, 65)
          .placeImageXY(new RectangleImage(150, 150, OutlineMode.OUTLINE, Color.white), 282, 377)
          .placeImageXY(new Button(false, 30, 60).drawButton(), 155, 380)
          .placeImageXY(new TextImage("0 to", Color.MAGENTA), 155, 370)
          .placeImageXY(new TextImage("Send", Color.magenta), 155, 390);
    }
    else {
      return this.makeAFinalScene();
    }
  }

  @Override
  public World onTick() {
    return new Stationette(on, this.index + 1, this.questions, this.led, ledControl);
  }

  @Override
  public World onMouseClicked(Posn pos) {
    // fix this
    if (pos.x > 135 && pos.x < 170 && pos.y > 295 && pos.y < 325) {
      ledControl = new Button(!ledControl.clicked, ledControl.radius);
      return new Stationette(on, index, questions, new LED(!led.on), ledControl);
    }
    else if (pos.x > 345 && pos.x < 365 && pos.y > 55 && pos.y < 75) {
      if(!on) {
        new Key("","music/START.WAV", "", 0).playCorrect();
      }else {
        new Key("","music/END.WAV", "", 0).playCorrect();
      }
      return new Stationette(!on, index, questions, led, ledControl);
    }
    else if (pos.x > 207 && pos.x < 223 && pos.y > 300 && pos.y < 450) {
      if (keys.get(0).rightAnwer(answers.get(index))) {
        keys.get(0).playCorrect();
        return new Stationette(on, index + 1, questions, led, ledControl);
      }
      else {
        keys.get(0).playIncorrect();
        return this;
      }
    }
    else if (pos.x > 223 && pos.x < 237 && pos.y > 300 && pos.y < 450) {
      if (keys.get(1).rightAnwer(answers.get(index))) {
        keys.get(1).playCorrect();
        return new Stationette(on, index + 1, questions, led, ledControl);
      }
      else {
        keys.get(1).playIncorrect();
        return this;
      }
    }
    else if (pos.x > 237 && pos.x < 252 && pos.y > 300 && pos.y < 450) {
      if (keys.get(2).rightAnwer(answers.get(index))) {
        keys.get(2).playCorrect();
        return new Stationette(on, index + 1, questions, led, ledControl);
      }
      else {
        keys.get(2).playIncorrect();
        return this;
      }
    }
    else if (pos.x > 252 && pos.x < 267 && pos.y > 300 && pos.y < 450) {
      if (keys.get(3).rightAnwer(answers.get(index))) {
        keys.get(3).playCorrect();
        return new Stationette(on, index + 1, questions, led, ledControl);
      }
      else {
        keys.get(3).playIncorrect();
        return this;
      }
    }
    else if (pos.x > 267 && pos.x < 282 && pos.y > 300 && pos.y < 450) {
      if (keys.get(4).rightAnwer(answers.get(index))) {
        keys.get(4).playCorrect();
        return new Stationette(on, index + 1, questions, led, ledControl);
      }
      else {
        keys.get(4).playIncorrect();
        return this;
      }
    }
    else if (pos.x > 282 && pos.x < 297 && pos.y > 300 && pos.y < 450) {
      if (keys.get(5).rightAnwer(answers.get(index))) {
        keys.get(5).playCorrect();
        return new Stationette(on, index + 1, questions, led, ledControl);
      }
      else {
        keys.get(5).playIncorrect();
        return this;
      }
    }
    else if (pos.x > 297 && pos.x < 312 && pos.y > 300 && pos.y < 450) {
      if (keys.get(6).rightAnwer(answers.get(index))) {
        keys.get(6).playCorrect();
        return new Stationette(on, index + 1, questions, led, ledControl);
      }
      else {
        keys.get(6).playIncorrect();
        return this;
      }
    }
    else if (pos.x > 312 && pos.x < 327 && pos.y > 300 && pos.y < 450) {
      if (keys.get(7).rightAnwer(answers.get(index))) {
        keys.get(7).playCorrect();
        return new Stationette(on, index + 1, questions, led, ledControl);
      }
      else {
        keys.get(7).playIncorrect();
        return this;
      }
    }
    else if (pos.x > 327 && pos.x < 342 && pos.y > 300 && pos.y < 450) {
      if (keys.get(8).rightAnwer(answers.get(index))) {
        keys.get(8).playCorrect();
        return new Stationette(on, index + 1, questions, led, ledControl);
      }
      else {
        keys.get(8).playIncorrect();
        return this;
      }
    }
    else if (pos.x > 342 && pos.x < 357 && pos.y > 300 && pos.y < 450) {
      if (keys.get(9).rightAnwer(answers.get(index))) {
        keys.get(9).playCorrect();
        return new Stationette(on, index + 1, questions, led, ledControl);
      }
      else {
        keys.get(9).playIncorrect();
        return this;
      }
    }
    else if (pos.x > 125 && pos.x < 185 && pos.y > 320 && pos.y < 440) {
      if (answers.get(index) == 0) {
        return new Stationette(on, index + 1, questions, led, ledControl);
      }
      else {
        this.worldEnds();
        return this;
      }
    }
    else {
      return this;
    }
  }

  WorldScene makeAFinalScene() {
    WorldScene scene = new WorldScene(500, 500);
    WorldImage textImage = new TextImage("- Mission Success -", 15, Color.PINK);
    status = new LED(false);
    new Key("","music/END.WAV", "", 0).playCorrect();

    return scene.placeImageXY(moniter, 250, 140).placeImageXY(moniterOutline, 250, 140)
        .placeImageXY(lcd, 250, 120).placeImageXY(ledbase, 150, 65).placeImageXY(light, 150, 65)
        .placeImageXY(moniter, 250, 375).placeImageXY(moniterOutline, 250, 375)
        .placeImageXY(status.drawLed(), 170, 65).placeImageXY(ledControl.drawButton(), 155, 310)
        .placeImageXY(textImage, 250, 120).placeImageXY(new Button(false, 10).drawButton(), 355, 65)
        .placeImageXY(new RectangleImage(150, 150, OutlineMode.OUTLINE, Color.white), 282, 377)
        .placeImageXY(new Button(false, 30, 60).drawButton(), 155, 380)
        .placeImageXY(new TextImage("0 to", Color.MAGENTA), 155, 370)
        .placeImageXY(new TextImage("Send", Color.magenta), 155, 390)
        .placeImageXY(status.drawLed(), 170, 65);
  }

  // add musical keys
  void addKeys() {
    this.keys.add(c);
    this.keys.add(d);
    this.keys.add(e);
    this.keys.add(f);
    this.keys.add(g);
    this.keys.add(a);
    this.keys.add(b);
    this.keys.add(c2);
    this.keys.add(sf);
    this.keys.add(bB);
  }

  int[][] transcribe(int n) {
    if (n == 0) {
      return zero;
    }
    else if (n == 1) {
      return one;
    }
    else if (n == 2) {
      return two;
    }
    else if (n == 3) {
      return three;
    }
    else if (n == 4) {
      return four;
    }
    else if (n == 5) {
      return five;
    }
    else if (n == 6) {
      return six;
    }
    else if (n == 7) {
      return seven;
    }
    else if (n == 8) {
      return eight;
    }
    else if (n == 9) {
      return nine;
    }
    else {
      return ten;
    }
  }

  void makeSong(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      questions.add(generateQuestion(transcribe(arr[i])));
    }
  }

  String generateQuestion(int[][] arr) {

    int randNum = (int) (Math.random() * 5);

    int[] sum = { 1, 2, 3, 4 };

    for (int i = 0; i < sum.length; i++) {
      sum[i] = arr[randNum][i];
    }

    this.answers.add(sum[3]);
    String result;

    if (sum[0] == 0) {
      result = sum[1] + " - " + sum[2] + " = ?";
    }
    else if (sum[0] == 1) {
      result = sum[1] + " + " + sum[2] + " = ?";
    }
    else {
      result = "error";
    }
    return result;
  }
}
