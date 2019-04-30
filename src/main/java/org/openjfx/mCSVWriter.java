package org.openjfx;

import javafx.collections.ObservableList;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static javafx.collections.FXCollections.observableArrayList;

public class mCSVWriter extends FileHandler{

    FileWriter fileWriter;
    @Override
    public void saveFile(File file, ObservableList data, String tableClassType) {
        try {
            fileWriter =  new FileWriter(file);
            String typeOfObject = tableClassType;
            fileWriter.write(tableClassType + ";");
            fileWriter.write(data.size() +";" + "\n");
            switch (tableClassType){
                case "Clients":
                    saveClient(data);
                    break;
                default:
                    throw new NullPointerException("noe");
            }
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveClient(ObservableList data) {
        ObservableList<mdClients> a = data;
        for (mdClients datum : a) {
            try {
                fileWriter.write(datum.getDateCreated() + ";");
                fileWriter.write(datum.getFirstName() + ";");
                fileWriter.write(datum.getLastName() + ";");
                fileWriter.write(datum.getAdress() + ";");
                fileWriter.write(datum.getForsikringsNR() + ";");
                fileWriter.write(datum.getForsikringer() + ";");
                fileWriter.write(datum.getSkademeldinger() + ";");
                fileWriter.write(datum.getUbetalt() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
