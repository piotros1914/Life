package patryk.piotrowski.entity;

import java.util.ArrayList;

public class Creatures extends ArrayList<Creature>{


    private Creature[][] creatures2DArray;

    public Creatures(int numberInXAxis, int numberInYAxis, int size, int gap) {
        initCreatures( numberInXAxis, numberInYAxis, size, gap);
    }

    private  void initCreatures(int numberInXAxis , int numberInYAxis, int size, int gap) {
        creatures2DArray = new Creature[numberInYAxis][numberInXAxis];

        int positionY = 0;
        for (int i = 0; i < numberInYAxis; i++){
            int positionX = 0;
            for (int j = 0; j < numberInXAxis; j++) {
                creatures2DArray[i][j] = new Creature(positionX, positionY, size, size);
                add(creatures2DArray[i][j]);
                positionX = positionX + size + gap;
            }
            positionY = positionY + size + gap;
        }
    }

    public Creature[][] getCreatures2DArray() {
        return creatures2DArray;
    }

    public void saveState(){
        for(Creature creature : this){
            creature.setWasAlived(creature.isAlive());
        }
    }

}
