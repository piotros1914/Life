package patryk.piotrowski.game;

import javafx.scene.input.MouseEvent;
import patryk.piotrowski.entity.Creature;
import patryk.piotrowski.entity.Creatures;
import patryk.piotrowski.entity.GameObjectsState;
import patryk.piotrowski.entity.Sprite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by piotr on 21.01.2018.
 */
public class GameObjects {


    private GameObjectsState gameObjectsState;

    private Creatures creatures;

    private List<Sprite> sprites;

    public GameObjects() {
        gameObjectsState = GameObjectsState.NONREADY;
        initCreatures();
        sprites = new ArrayList<Sprite>();
        sprites.addAll(creatures);

    }

    private void initCreatures(){
        creatures = new Creatures(GameOptions.numberInXAxis, GameOptions.numberInYAxis, GameOptions.size, GameOptions.gap);
    }

    public Creatures getCreatures() {
        return creatures;
    }

    public List<Sprite> getSprites() {
        return sprites;
    }

    public GameObjectsState getGameObjectsState() {
        return gameObjectsState;
    }

    public void setGameObjectsState(GameObjectsState gameObjectsState) {
        this.gameObjectsState = gameObjectsState;
    }
}
