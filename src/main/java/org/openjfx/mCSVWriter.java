package org.openjfx;

import javafx.collections.ObservableList;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static javafx.collections.FXCollections.observableArrayList;

public class mCSVWriter extends FileHandler{

    @Override
    public void saveFile(File file, ObservableList<mdClients> data, String tableClassType) {
        try {
            FileWriter fileWriter =  new FileWriter(file);
            String typeOfObject = tableClassType;
            fileWriter.write(tableClassType + ";");
            fileWriter.write(data.size() +";" + "\n");
            for (mdClients datum : data) {
                fileWriter.write(datum.getDateCreated() + ";");
                fileWriter.write(datum.getFirstName() + ";");
                fileWriter.write(datum.getLastName() + ";");
                fileWriter.write(datum.getAdress() + ";");
                fileWriter.write(datum.getForsikringsNR() + ";");
                fileWriter.write(datum.getForsikringer() + ";");
                fileWriter.write(datum.getSkademeldinger() + ";");
                fileWriter.write(datum.getUbetalt() + "\n");
            }
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
