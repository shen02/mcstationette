import java.awt.Color;
import java.util.ArrayList;

import javalib.worldimages.CircleImage;
import javalib.worldimages.OutlineMode;
import javalib.worldimages.WorldImage;

public class LED {
  
  boolean on;
  
  Color color;
  
  LED(boolean mode) {
    this.on = mode;
    if(on) {
      color = Color.WHITE;
    } else {
      color = Color.DARK_GRAY;
    }
  }
  
  LED(boolean mode, Color color) {
    this.on = mode;
    this.color = color;
  }
  
  WorldImage drawLed() {
    return new CircleImage(5, OutlineMode.SOLID, this.color);
  }
}
