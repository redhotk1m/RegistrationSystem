package org.openjfx;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;

import java.io.File;
import java.io.IOException;

import static javafx.collections.FXCollections.observableArrayList;

public class readDataThread extends Task<Integer> {

    FileHandler fileHandler;
    String typeOfObject;
    int amountOfRows;
    ObservableList dataObjects = observableArrayList();
    File file;

    readDataThread(File file){
        this.file = file;
    }


    @Override
    protected Integer call() {
        if (file.getName().endsWith(".jobj")){
            fileHandler = new mJOBJReader(file);
            setDataObjects(fileHandler.getData());
        }else if (file.getName().endsWith(".csv")){
            try {
                fileHandler = new mCSVReader(file);
                this.typeOfObject = fileHandler.getTypeOfObject();
                this.amountOfRows = fileHandler.getAmountOfRows();
                createAllObjects();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return amountOfRows;
    }

    private void createAllObjects(){
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
}
