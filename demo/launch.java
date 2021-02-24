import java.util.ArrayList;

class TheAbsolutelyWonderfulStationette {

  static Stationette world = new Stationette(0, new ArrayList<String>());

  public static void main(String[] args)  
  { 
    world.bigBang(500, 500); 
  }
}

