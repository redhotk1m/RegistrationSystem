package org.openjfx;

import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public abstract class FileHandler {

    public void addFromFile(File file) throws IOException {

    };

    public ObservableList getData(){
        return null;
    }
}
