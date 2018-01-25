package patryk.piotrowski.game;

import patryk.piotrowski.entity.Creatures;
import patryk.piotrowski.enums.GameObjectsStateEnum;
import patryk.piotrowski.entity.Sprite;
import patryk.piotrowski.global.GameProperties;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by piotr on 21.01.2018.
 */
public class GameObjects {


    private GameObjectsStateEnum gameObjectsState;

    private Creatures creatures;

    private List<Sprite> sprites;

    public GameObjects() {
        gameObjectsState = GameObjectsStateEnum.NONREADY;
        initCreatures();
        sprites = new ArrayList<Sprite>();
        sprites.addAll(creatures);

    }

    private void initCreatures(){
        creatures = new Creatures(GameProperties.numberInXAxis, GameProperties.numberInYAxis, GameProperties.size, GameProperties.gap);
    }

    public Creatures getCreatures() {
        return creatures;
    }

    public List<Sprite> getSprites() {
        return sprites;
    }

    public GameObjectsStateEnum getGameObjectsState() {
        return gameObjectsState;
    }

    public void setGameObjectsState(GameObjectsStateEnum gameObjectsState) {
        this.gameObjectsState = gameObjectsState;
    }
}
