package org.openjfx.Model;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.openjfx.FXMLController;
import org.openjfx.MainApp;

import java.io.IOException;

public class ErrorMessage {



    public ErrorMessage(String exception) throws IOException {
        MainApp.primaryScene.getRoot().setDisable(true);
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setOnCloseRequest(windowEvent -> windowEvent.consume());
        stage.setAlwaysOnTop(true);
        stage.initStyle(StageStyle.UNDECORATED);
        Button button = new Button(exception);
        VBox vBox = new VBox(button);
        StackPane root = new StackPane();

        root.getChildren().add(vBox);
        Scene scene = new Scene(root, 300, 200);

        stage.setScene(scene);
        stage.show();
        button.setOnAction(event -> {
            //System.exit(0);
            stage.close();
            MainApp.primaryScene.getRoot().setDisable(false);
        });
    }




}
