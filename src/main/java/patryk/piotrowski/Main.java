package patryk.piotrowski;

import javafx.application.Application;
import javafx.stage.Stage;
import patryk.piotrowski.game.Game;


public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

   /* @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/view/main.fxml"));
        Scene scene = new Scene(root, 900, 600);
        stage.setTitle("Life!");
        stage.setScene(scene);
        stage.show();
    }*/

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Drawing Operations Test");

        Game game = new Game(primaryStage);
        game.start();

    }




}

