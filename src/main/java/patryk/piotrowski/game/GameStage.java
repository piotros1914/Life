package patryk.piotrowski.game;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import patryk.piotrowski.entity.Creature;
import patryk.piotrowski.entity.GameObjectsState;

public class GameStage  {

    private Stage stage;
    private Scene gameScene;
    private StackPane pane;
    private Canvas canvas;
    private GraphicsContext gc;

    public GameStage(Stage stage) {
        this.stage = stage;
        canvas = new Canvas();
        canvas.setWidth(GameOptions.getWidth());
        canvas.setHeight(GameOptions.getHeight());

        pane = new StackPane();
        pane.setStyle("-fx-background-color: white;");
        pane.getChildren().add(canvas);

        gc = canvas.getGraphicsContext2D();

        gameScene = new Scene(pane);
        stage.setScene(gameScene);
        stage.setResizable(false);

    }

    public void show(){
        stage.show();
    }

    private long lastFrameTime = System.nanoTime();

    public void drawFrame(GameObjects gameObjects, long currentNanoTime){
        long deltaTime = currentNanoTime - lastFrameTime;
        if( deltaTime > GameOptions.frameTime){
            lastFrameTime = currentNanoTime;
            gameObjects.setGameObjectsState(GameObjectsState.NONREADY);
            drawFrame(gameObjects);
        }
    }

    public void drawFrame (GameObjects gameObjects){
        clear();
        Creature[][] creatures = gameObjects.getCreatures().getCreatures2DArray();
        for (int i = 0; i < GameOptions.numberInYAxis; i++){
            for (int j = 0; j < GameOptions.numberInXAxis; j++) {
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

    public Scene getGameScene() {
        return gameScene;
    }
}