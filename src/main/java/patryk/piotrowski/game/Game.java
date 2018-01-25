package patryk.piotrowski.game;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import patryk.piotrowski.entity.GameState;
import patryk.piotrowski.entity.Sprite;

public class Game {

    private GameStage gameStage;
    private GameObjects gameObjects;
    private GameRules gameRules;

    private GameState gameState = GameState.STOPPED;

    public Game(Stage stage) {
        gameStage = new GameStage( stage);
    }

    public void start(){
        initGameObjects();
        initEventListeners();
        initGameRules();
        gameStage.drawFrame(gameObjects);
        gameStage.show();
    }

    private void  startGameLoop(){
        gameState = GameState.STARTED;
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                gameRules.updateGameObjects();
                gameStage.drawFrame(gameObjects, currentNanoTime);
                if(gameState.equals(GameState.STOPPED)){
                    stop();
                }
            }
        }.start();
    }

    private void stopGameLoop(){
        gameState = GameState.STOPPED;
    }

    private void  initGameObjects(){
        gameObjects = new GameObjects();
    }

    private void initGameRules(){
        gameRules = new GameRules(gameObjects);
    }

    private void initEventListeners(){
        Scene gameScene = gameStage.getGameScene();
        gameScene.setOnMouseClicked(event -> {
            for(Sprite sprite : gameObjects.getSprites()){
                sprite.onMouseClickedAction(event);
            }
            gameStage.drawFrame(gameObjects);
        });
        gameScene.setOnKeyReleased(event -> {
            // akcja dla klawisza enter
            // włącza i wyłącza przebieg symulacji
            if(event.getCode().equals(KeyCode.ENTER)){
                if( gameState.equals(GameState.STOPPED)){
                    startGameLoop();
                } else{
                    stopGameLoop();
                }
            }
        });
    }





}
