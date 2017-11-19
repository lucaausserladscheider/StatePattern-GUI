package Main;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Klasse Main die das Programm ausführt
 */
public class Main extends Application {

    /**
     * überschreibt die start Methode der geerbten Klasse Application
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource( "../View/sample.fxml" ));
        primaryStage.setTitle("State Pattern GUI");
        primaryStage.setScene(new Scene(root, 500, 500));
        primaryStage.show();

    }

    /**
     * main methode die launch ausführt
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }
}
