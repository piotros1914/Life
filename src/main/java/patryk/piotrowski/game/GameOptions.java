package patryk.piotrowski.game;

public  class GameOptions {

   public static final int size = 25;
   public static final int numberInXAxis = 50;
   public static final int numberInYAxis = 25;
   public static final int gap = 2;

   /*
   * Czas wyświetlania jednej klatki symulacji
   * Jednostka czasu jest nanosekunda
   */
   public static final long frameTime = 1000000000;

   public static int getWidth(){
        return ((numberInXAxis  + gap) * size) + 50;
    }
   public static int getHeight(){
        return (numberInYAxis  + gap) * size;
    }
}
