package patryk.piotrowski.entity;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


public class Creature extends Sprite {


    private Rectangle rectangle;

    private Color liveColor;

    private Color deadColor;

    private boolean isAlive;

    private boolean wasAlived;

    public Creature(double positionX, double positionY, double width, double height)  {
        super();
        rectangle = new Rectangle(positionX, positionY, width, height);
        isAlive = false;
        liveColor = Color.AQUAMARINE;
        deadColor = Color.GRAY;
    }

    public Rectangle getRectangle(){
        return this.rectangle;
    }

    public double getX() {
        return rectangle.getX();
    }

    public double getY() {
        return rectangle.getY();
    }

    public double getWidth() {
        return rectangle.getWidth();
    }

    public double getHeight() {
        return rectangle.getHeight();
    }

    public boolean contains(double x, double y){
        return rectangle.contains(x, y);
    }

    public Image getImage(){
        if(isAlive){
            return CretureImage.getInstance().getImage();
        }
        else{
            return null;
        }
    }

    public double getPx(){
        return CretureImage.getInstance().px;
    }

    public double getPy(){
        return CretureImage.getInstance().py;
    }

    public double getPw(){
        return CretureImage.getInstance().pw;
    }

    public double getPh(){
        return CretureImage.getInstance().ph;
    }




    public Color getColor(){
        if(isAlive){
            return liveColor;
        }
        else{
            return deadColor;
        }
    }

    public void changeLifeState(){
        if(isAlive){
            isAlive = false;
        } else{
            isAlive = true;
        }
    }

    public boolean onMouseClickedAction(MouseEvent event){
        if( contains(event.getX(), event.getY())){
            changeLifeState();
            return true;
        }
        return false;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public boolean wasLived() {
        return wasAlived;
    }

    public void setWasAlived(boolean wasAlived) {
        this.wasAlived = wasAlived;
    }


    public static class CretureImage {

        private static final CretureImage instance = new CretureImage();

        private Image image;

        public static double px = 0.0;
        public static double py = 0.0;
        public static double pw = 350;
        public static double ph = 350;

        private CretureImage(){
            image = new Image(this.getClass().getResourceAsStream("/bacteria.png"));

        }

        public static CretureImage getInstance(){
            return instance;
        }

        public Image getImage() {
            return image;
        }
    }
}
