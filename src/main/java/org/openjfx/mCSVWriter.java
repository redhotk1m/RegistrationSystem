package org.openjfx;

import javafx.collections.ObservableList;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static javafx.collections.FXCollections.observableArrayList;

public class mCSVWriter {

    public void saveFile(File file, ObservableList<mdClients> data) {
        try {
            String absolutePath = new File("").getAbsolutePath();
            FileWriter fileWriter =  new FileWriter(file);
            for (mdClients datum : data) {
                fileWriter.write(datum.getFirstName() + ";");
                fileWriter.write(datum.getLastName() + ";");
                fileWriter.write(datum.getForsikringsNR() + "\n");
            }
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
