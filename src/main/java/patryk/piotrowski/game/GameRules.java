package patryk.piotrowski.game;

import patryk.piotrowski.entity.Creature;
import patryk.piotrowski.entity.Creatures;
import patryk.piotrowski.enums.GameObjectsStateEnum;
import patryk.piotrowski.global.GameProperties;

/**
 * Created by piotr on 21.01.2018.
 */
public class GameRules {

    private GameObjects gameObjects;

    public GameRules(GameObjects gameObjects){
        this.gameObjects = gameObjects;
    }

    public void updateGameObjects(){
        if(gameObjects.getGameObjectsState().equals(GameObjectsStateEnum.NONREADY)){
            System.out.println("updateGameObjects");
            Creatures creatures =  gameObjects.getCreatures();
            creatures.saveState();
            Creature[][] creatures2DArray = creatures.getCreatures2DArray();
            for(int i = 1; i < GameProperties.numberInYAxis-1; i++){
                for(int j = 1; j < GameProperties.numberInXAxis-1; j++){

                    int numberOfNeighbors = 0;
                    Creature creature = creatures2DArray[i][j];
                    for(int k = -1; k <= 1; k++){
                        for(int l = -1; l <= 1; l++){

                            if(creatures2DArray[i + k][j + l].wasLived()){
                                numberOfNeighbors++;
                            }

                        }
                    }
                    if(creature.wasLived()){
                        numberOfNeighbors--;
                    }

                    if(!creature.wasLived() && numberOfNeighbors == 3){
                        System.out.println("life");
                        System.out.println(numberOfNeighbors);
                        creature.changeLifeState();
                    } else if(creature.wasLived() && (numberOfNeighbors < 2 || 3 < numberOfNeighbors )){
                        System.out.println("dead");
                        System.out.println(numberOfNeighbors);
                        creature.changeLifeState();
                    }




                }
            }
            gameObjects.setGameObjectsState(GameObjectsStateEnum.READY);

        }

    }

}
