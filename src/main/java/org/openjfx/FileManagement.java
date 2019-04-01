package org.openjfx;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

public interface FileManagement {

    FileChooser fileChooser = new FileChooser();

    public void loadFile(Stage stage);

}
