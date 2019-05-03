package org.openjfx.Model;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import org.openjfx.Exceptions.EmptyTableException;
import org.openjfx.Model.ReadAndWrite.CSVReader;
import org.openjfx.Model.ReadAndWrite.FileHandler;
import org.openjfx.Model.ReadAndWrite.JOBJReader;

import java.io.File;
import java.io.IOException;

import static javafx.collections.FXCollections.observableArrayList;

public class ReadDataTask extends Task<Integer> {

    FileHandler fileHandler;
    String typeOfObject;
    int amountOfRows;
    ObservableList dataObjects = observableArrayList();
    File file;

    public ReadDataTask(File file){
        this.file = file;
    }


    @Override
    public Integer call() throws EmptyTableException {
        if (file.getName().endsWith(".jobj")){
            fileHandler = new JOBJReader(file);
            setDataObjects(fileHandler.getData());
        }else if (file.getName().endsWith(".csv")){
            fileHandler = new CSVReader(file);
            this.typeOfObject = fileHandler.getTypeOfObject();
            this.amountOfRows = fileHandler.getAmountOfRows();
            createAllObjectsFromCSV();
        }
        return amountOfRows;
    }

    private void createAllObjectsFromCSV() throws EmptyTableException {
        ObjectCreator objectCreator = new ObjectCreator();
        for (int i = 0; i < amountOfRows; i++) {
            String objectValues[] = new String[0];
            try {
                objectValues = fileHandler.getNextLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            objectCreator.createObject(typeOfObject, objectValues);
            dataObjects.add(objectCreator.getObject());
            updateProgress(i, amountOfRows-1);
        }
    }

    public ObservableList getDataObjects() {
        return dataObjects;
    }

    public void setDataObjects(ObservableList dataObjects) {
        this.dataObjects = dataObjects;
    }

    public String getDataObjectType(){
        return dataObjects.get(0).getClass().getName();
    }
}
