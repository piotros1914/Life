package patryk.piotrowski.game;


import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;

public class GameMenu {

    private MenuBar menuBar;

    private MenuItem startMenuItem;

    private MenuItem stopMenuItem;

    public GameMenu(){
        menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu());
    }

    private Menu fileMenu() {
        Menu fileMenu = new Menu("Gra");
        startMenuItem = new MenuItem("Start");
        stopMenuItem = new MenuItem("Stop");
        fileMenu.getItems().addAll(startMenuItem,
                stopMenuItem,
                new SeparatorMenuItem());
        return fileMenu;
    }

    public MenuBar getMenuBar() {
        return menuBar;
    }

    public void setMenuBar(MenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public MenuItem getStartMenuItem() {
        return startMenuItem;
    }

    public void setStartMenuItem(MenuItem startMenuItem) {
        this.startMenuItem = startMenuItem;
    }

    public MenuItem getStopMenuItem() {
        return stopMenuItem;
    }

    public void setStopMenuItem(MenuItem stopMenuItem) {
        this.stopMenuItem = stopMenuItem;
    }
}
