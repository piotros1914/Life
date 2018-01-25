package patryk.piotrowski.game;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import patryk.piotrowski.entity.Creature;
import patryk.piotrowski.enums.GameObjectsStateEnum;
import patryk.piotrowski.global.GameProperties;

public class GameView {

    private StackPane pane;
    private Canvas canvas;
    private GraphicsContext gc;

    public GameView() {
        canvas = new Canvas();
        canvas.setWidth(GameProperties.getWidth());
        canvas.setHeight(GameProperties.getHeight());

        gc = canvas.getGraphicsContext2D();

        pane = new StackPane();
        pane.setStyle("-fx-background-color: white;");
        pane.getChildren().add(canvas);
    }

    private long lastFrameTime = System.nanoTime();




    public void update(GameObjects gameObjects, long currentNanoTime){
        long deltaTime = currentNanoTime - lastFrameTime;
        if( deltaTime > GameProperties.frameTime){
            lastFrameTime = currentNanoTime;
            gameObjects.setGameObjectsState(GameObjectsStateEnum.NONREADY);
            update(gameObjects);
        }
    }

    public void update (GameObjects gameObjects){
        clear();
        Creature[][] creatures = gameObjects.getCreatures().getCreatures2DArray();
        for (int i = 0; i < GameProperties.numberInYAxis; i++){
            for (int j = 0; j < GameProperties.numberInXAxis; j++) {
                drawImage(creatures[i][j]);
            }
        }
    }

    private void drawImage(Creature creature){
        gc.drawImage(creature.getImage(),
                creature.getPx(),
                creature.getPy(),
                creature.getPw(),
                creature.getPh(),
                creature.getX(),
                creature.getY(),
                creature.getWidth(),
                creature.getHeight()
        );
    }

//    private void drawShape(Creature creature){
//        Rectangle rect = creature.getRectangle();
//        gc.setFill(creature.getColor());
//        gc.fillRect(rect.getX(),
//                rect.getY(),
//                rect.getWidth(),
//                rect.getHeight()
//        );
//    }

    private void clear(){
        gc.clearRect(0, 0, pane.getWidth(), pane.getHeight());
   }

    public StackPane getPane() {
        return pane;
    }

    public void setPane(StackPane pane) {
        this.pane = pane;
    }
}