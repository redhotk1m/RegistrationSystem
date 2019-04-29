package org.openjfx;

import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;

import java.io.File;
import java.io.IOException;

import static javafx.collections.FXCollections.observableArrayList;

public class readDataThread extends Task<Integer> {

    FileHandler fileHandler;
    String typeOfObject;
    int amountOfRows, amountOfColumns;
    ObservableList dataObjects = observableArrayList();

    readDataThread(File file){
        if (file.getName().endsWith(".jobj")){
            //DO THIS
        }else if (file.getName().endsWith(".csv")){
            try {
                fileHandler = new mCSVReader(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            this.typeOfObject = fileHandler.getTypeOfObject();
            this.amountOfRows = fileHandler.getAmountOfRows();
            this.amountOfColumns = fileHandler.getAmountOfColumns();
        }
    }

    @Override
    protected Integer call() {
        System.out.println("Starter call!");

        ObjectCreator objectCreator = new ObjectCreator();
        for (int i = 0; i < amountOfRows; i++){
            String objectValues [] = new String[0];
            try {
                objectValues = fileHandler.getNextLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            objectCreator.createObject(typeOfObject, amountOfColumns, objectValues);
            dataObjects.add(objectCreator.getObject());
            updateProgress(i, amountOfRows);
        }
        return amountOfRows;
    }


    @Override
    protected void updateProgress(long l, long l1) {
        super.updateProgress(l, l1);
    }

    public ObservableList getDataObjects() {
        return dataObjects;
    }

    public void setDataObjects(ObservableList dataObjects) {
        this.dataObjects = dataObjects;
    }
}
