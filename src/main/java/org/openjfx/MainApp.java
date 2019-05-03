package org.openjfx;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class MainApp extends Application {

    public static Stage primaryStage;
    public static Scene primaryScene;

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("scene.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        stage.setTitle("Easy Insurance");
        stage.setScene(scene);
        stage.show();
        //Disse to brukes for å disable hovedScenet vårt ved eventuell feilmelding (ErrorMessage, EmptyTableException).
        primaryStage = stage;
        primaryScene = scene;
    }
    public static void main(String[] args) {
        launch(args);
    }

    public static void setPrimaryStage(Stage primaryStage) {
        MainApp.primaryStage = primaryStage;
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    public static Scene getPrimaryScene() {
        return primaryScene;
    }
}
