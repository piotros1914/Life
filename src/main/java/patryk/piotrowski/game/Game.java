package patryk.piotrowski.game;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import patryk.piotrowski.enums.GameStateEnum;
import patryk.piotrowski.entity.Sprite;
import patryk.piotrowski.global.GameState;

public class Game {

    private Stage stage;

    private GameView gameView;
    private GameObjects gameObjects;
    private GameRules gameRules;
    private GameMenu gameMenu;

    public Game(Stage stage) {
        this.stage = stage;
    }

    public void start(){
        initGameObjects();
        initView();
        initGameRules();
        initEventListeners();
        initGameState();
    }
    private void  initGameObjects(){
        gameObjects = new GameObjects();
    }

    private void initView(){
        initGameMenu();
        initGameView();
        BorderPane borderPane = new BorderPane();
        borderPane.setTop(gameMenu.getMenuBar());
        borderPane.setCenter(gameView.getPane());

        Scene gameScene = new Scene(borderPane);

        stage.setScene(gameScene);
        stage.setResizable(false);
        stage.show();

        gameView.update(gameObjects);
    }

    private void initGameView(){
        gameView = new GameView();
    }

    private void initGameMenu(){
        gameMenu = new GameMenu();
    }

    private void initGameRules(){
        gameRules = new GameRules(gameObjects);
    }

    private void initEventListeners(){
        gameView.getPane().setOnMouseClicked(event -> {
            for(Sprite sprite : gameObjects.getSprites()){
                boolean isClicked = sprite.onMouseClickedAction(event);
                if(isClicked){
                    break;
                }
            }
            gameView.update(gameObjects);
        });

        gameView.getPane().setOnKeyReleased(event -> {
            // akcja dla klawisza enter
            // włącza i wyłącza przebieg symulacji
            if(event.getCode().equals(KeyCode.ENTER)){
                if( GameState.get().equals(GameStateEnum.STOPPED)){
                    startGameLoop();
                } else{
                    stopGameLoop();
                }
            }
        });

        gameMenu.getStartMenuItem().setOnAction(event -> {
            if( GameState.get().equals(GameStateEnum.STOPPED)){
                startGameLoop();
            }
        });

        gameMenu.getStopMenuItem().setOnAction(event -> {
            if( GameState.get().equals(GameStateEnum.STARTED)){
                stopGameLoop();
            }
        });
    }

    private void initGameState() {
        GameState.set(GameStateEnum.STOPPED);
    }

    private void  startGameLoop(){
        GameState.set(GameStateEnum.STARTED);
        new AnimationTimer() {
            public void handle(long currentNanoTime) {
                gameRules.updateGameObjects();
                gameView.update(gameObjects, currentNanoTime);
                if(GameState.get().equals(GameStateEnum.STOPPED)){
                    stop();
                }
            }
        }.start();
    }

    private void stopGameLoop(){
        GameState.set(GameStateEnum.STOPPED);
    }
}
