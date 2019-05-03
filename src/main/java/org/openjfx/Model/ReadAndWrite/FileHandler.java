package org.openjfx.Model.ReadAndWrite;

import javafx.collections.ObservableList;
import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;

public abstract class FileHandler {

    public void addFromFile(File file) throws IOException {

    };

    //Hvis noen av disse metodene blir kalt på, der de ikke blir overriden, kastes en exception.
    //Vi skulle egentlig lage en ordentlig exception, men det rakk vi ikke.

    public ObservableList getData(){
        return null;
    }
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

    public void saveFile(File file, ObservableList data, String tableClassType){

    }

}
