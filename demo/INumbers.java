import java.awt.Color;

import javalib.worldimages.CircleImage;
import javalib.worldimages.OutlineMode;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.WorldImage;

interface INumbers {
  // sequence[] = {op, first, second, result};
  // op == 0 = subtract, 1 = add
  int[][] zero = { { 0, 9, 9, 0 }, { 0, 8, 8, 0 }, { 0, 7, 7, 0 }, { 1, 0, 0, 0 }, { 0, 5, 5, 0 },
      { 0, 4, 4, 0 }, { 0, 3, 3, 0 }, { 0, 6, 6, 0 }, { 0, 0, 0, 0 }, { 1, 0, 0, 0 } };

  int[][] one = { { 0, 9, 8, 1 }, { 0, 8, 7, 1 }, { 0, 6, 5, 1 }, { 0, 5, 4, 1 }, { 0, 4, 3, 1 },
      { 0, 3, 2, 1 }, { 0, 2, 1, 1 }, { 0, 1, 0, 1 }, { 1, 1, 0, 1 }, { 0, 10, 9, 1 } };

  int[][] two = { { 0, 9, 7, 2 }, { 0, 8, 6, 2 }, { 0, 7, 5, 2 }, { 0, 6, 4, 2 }, { 0, 5, 3, 2 },
      { 0, 4, 2, 2 }, { 1, 1, 1, 2 }, { 0, 2, 0, 2 }, { 1, 0, 2, 2 } };

  int[][] three = { { 0, 8, 5, 3 }, { 0, 9, 6, 3 }, { 0, 7, 4, 3 }, { 0, 6, 3, 3 }, { 0, 5, 2, 3 },
      { 1, 1, 2, 3 }, { 1, 2, 1, 3 }, { 1, 3, 0, 3 }, { 0, 3, 0, 3 } };

  int[][] four = { { 0, 8, 4, 4 }, { 0, 9, 5, 4 }, { 0, 7, 3, 4 }, { 0, 6, 2, 4 }, { 0, 5, 1, 4 },
      { 1, 2, 2, 4 }, { 1, 3, 1, 4 }, { 1, 4, 0, 4 }, { 0, 4, 0, 4 } };

  // needs to change
  int[][] five = { { 0, 8, 3, 5 }, { 0, 9, 4, 5 }, { 0, 7, 2, 5 }, { 0, 6, 1, 5 }, { 0, 5, 0, 5 },
      { 1, 2, 3, 5 }, { 0, 10, 5, 5 }, { 1, 5, 0, 5 }, { 1, 1, 4, 5 } };

  int[][] six = { { 0, 8, 2, 6 }, { 0, 9, 3, 6 }, { 0, 7, 1, 6 }, { 0, 6, 0, 6 }, { 1, 5, 1, 6 },
      { 1, 4, 2, 6 }, { 1, 3, 3, 6 }, { 0, 10, 4, 6 }, { 1, 6, 0, 6 } };

  int[][] seven = { { 0, 8, 1, 7 }, { 0, 9, 2, 7 }, { 0, 7, 0, 7 }, { 1, 6, 1, 7 }, { 1, 5, 2, 7 },
      { 1, 4, 3, 7 }, { 0, 10, 3, 7 }, { 1, 7, 0, 7 }, { 0, 7, 0, 7 } };

  int[][] eight = { { 0, 8, 0, 8 }, { 0, 9, 1, 8 }, { 1, 7, 1, 8 }, { 1, 6, 2, 8 }, { 1, 5, 3, 8 },
      { 1, 4, 4, 8 }, { 0, 10, 2, 8 }, { 1, 8, 0, 8 }, { 0, 8, 0, 8 } };

  int[][] nine = { { 1, 8, 1, 9 }, { 0, 10, 1, 9 }, { 1, 7, 2, 9 }, { 1, 6, 3, 9 }, { 1, 5, 4, 9 },
      { 1, 2, 7, 9 }, { 1, 3, 6, 9 }, { 1, 9, 0, 9 }, { 0, 9, 0, 9 } };

  int[][] ten = { { 1, 8, 2, 10 }, { 1, 9, 1, 10 }, { 1, 7, 3, 10 }, { 1, 6, 4, 10 },
      { 1, 5, 5, 10 }, { 1, 4, 6, 10 }, { 1, 0, 10, 10 }, { 0, 10, 0, 10 }, { 1, 10, 0, 10 } };
  // songs
  int[] lamb = { 3, 2, 1, 2, 3, 3, 3, 0, 2, 2, 2, 0, 3, 3, 3, 0, 3, 2, 1, 2, 3, 3, 3, 1, 2, 2, 3, 2,
      1 };

  int[] london = { 5, 6, 5, 4, 3, 4, 5, 0, 2, 3, 4, 0, 3, 4, 5, 0, 5, 6, 5, 4, 3, 4, 5, 0, 2, 0, 5,
      0, 3, 1, 0, 0 };

  int[] birthday = { 1, 1, 2, 1, 4, 3, 0, 1, 1, 2, 1, 5, 4, 0, 1, 1, 8, 6, 4, 3, 2, 10, 10, 6, 4, 5,
      4 };

  int[] sleigh1 = { 9, 9, 9, 0, 9, 9, 9, 0, 9, 6, 2, 3, 9, 0, 0, 0, 5, 5, 5, 5, 5, 9, 9, 9, 9, 9, 3,
      3, 9, 3, 0, 6, 0, 9, 9, 9, 0, 9, 9, 9, 0, 9, 6, 2, 3, 9, 0, 0, 0, 5, 5, 5, 5, 5, 9, 9, 9, 6,
      6, 5, 3, 2, 0, 0, 0 };

  int[] sleigh2 = { 1, 6, 5, 4, 1, 0, 0, 0, 1, 6, 5, 4, 2, 0, 0, 0, 2, 10, 6, 5, 3, 0, 0, 0, 8, 8,
      10, 5, 6, 0, 0, 0, 1, 6, 5, 4, 1, 0, 0, 0, 1, 6, 5, 4, 2, 0, 0, 0, 2, 10, 6, 5, 8, 8, 8, 8, 8,
      10, 6, 5, 4, 0, 0, 0 };

  int[] cage = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
      0, 0, 0, 0 };

  int[] suzanna = { 1, 2, 3, 5, 5, 6, 5, 3, 1, 2, 3, 3, 2, 1, 2, 0, 0, 0, 3, 5, 5, 6, 5, 3, 1, 2, 3,
      3, 2, 2, 1, 0, 0, 0, 4, 0, 4, 0, 6, 6, 0, 6, 5, 5, 3, 1, 2, 0, 0, 0, 3, 5, 5, 6, 5, 3, 1, 2,
      3, 3, 2, 2, 1 };

  int[][] songs = {suzanna, cage, sleigh1, sleigh2, birthday, london, lamb};
  
  Key c = new Key("C", "music/40.WAV", "music/C.WAV", 1);
  Key d = new Key("D", "music/42.WAV", "music/D.WAV", 2);
  Key e = new Key("E", "music/44.WAV", "music/E.WAV", 3);
  Key f = new Key("F", "music/45.WAV", "music/F.WAV", 4);
  Key g = new Key("G", "music/47.WAV", "music/G.WAV", 5);
  Key a = new Key("A", "music/49.WAV", "music/A.WAV", 6);
  Key b = new Key("A", "music/49.WAV", "music/B.WAV", 7);
  Key c2 = new Key("A", "music/49.WAV", "music/C2.WAV", 8);
  Key sf = new Key("#F", "music/46.WAV", "music/#F.WAV", 9);
  Key bB = new Key("bB", "music/49.WAV", "music/bB.WAV", 10);
  // 9 = #F
  // 10 = bB 
  
  WorldImage moniterOutline = new RectangleImage(250, 200, OutlineMode.OUTLINE, Color.GREEN);
  WorldImage moniter = new RectangleImage(250, 200, OutlineMode.SOLID, Color.BLACK);
  WorldImage lcd = new RectangleImage(200, 50, OutlineMode.SOLID, Color.BLUE);
  WorldImage ledbase = new CircleImage(10, OutlineMode.SOLID, Color.DARK_GRAY); 
  
  
}