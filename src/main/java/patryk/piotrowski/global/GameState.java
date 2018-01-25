package patryk.piotrowski.global;

import patryk.piotrowski.enums.GameStateEnum;

public class GameState {

    private static GameStateEnum gameState = null;

    private GameState() {

    }

    public static void set(GameStateEnum gameStateEnum){
       gameState = gameStateEnum;
    }

    public static GameStateEnum get(){
       return gameState;
    }
}



