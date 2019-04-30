package org.openjfx;

import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.InvalidObjectException;
import java.security.InvalidParameterException;

public abstract class FileHandler {

    public void addFromFile(File file) throws IOException {

    };

    public ObservableList getData(){
        return null;
    }
//TODO fikse hva vi thrower, feil.
    public String getTypeOfObject() {
        throw new InvalidParameterException("");
    }

    public void setTypeOfObject(String typeOfObject) {
        throw new InvalidParameterException("");
    }

    public int getAmountOfRows() {
        throw new InvalidParameterException("");
    }

    public void setAmountOfRows(int amountOfRows) {
        throw new InvalidParameterException("");
    }

    public int getAmountOfColumns() {
        throw new InvalidParameterException("");
    }

    public void setAmountOfColumns(int amountOfColumns) {
        throw new InvalidParameterException("");
    }

    public String[] getNextLine() throws IOException {
        throw new InvalidParameterException("");
    }

    public void saveFile(File file, ObservableList<mdClients> data, String tableClassType){

    }

}
