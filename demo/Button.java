import java.awt.Color;

import javalib.worldimages.CircleImage;
import javalib.worldimages.OutlineMode;
import javalib.worldimages.OverlayImage;
import javalib.worldimages.RectangleImage;
import javalib.worldimages.WorldImage;

// represents a button
public class Button {

  boolean clicked;

  int x;

  int y;

  int radius = -1;

  Color color;

  Button(boolean clicked) {
    this.clicked = clicked;
    if (clicked) {
      color = Color.DARK_GRAY;
    }
    else {
      color = Color.LIGHT_GRAY;
    }
  }

  Button(boolean clicked, int x, int y) {
    this(clicked);
    this.x = x;
    this.y = y;
  }

  Button(boolean clicked, int radius) {
    this(clicked);
    this.radius = radius;
  }

  WorldImage drawButton() {
    if(this.radius != -1) {
      return new OverlayImage(new CircleImage(this.radius, OutlineMode.OUTLINE, Color.CYAN),
          new CircleImage(this.radius, OutlineMode.SOLID, this.color));
    } else {
      return new OverlayImage(new RectangleImage(this.x, this.y, OutlineMode.OUTLINE, Color.CYAN),
          new RectangleImage(this.x, this.y, OutlineMode.SOLID, this.color));
    }
  }
}
