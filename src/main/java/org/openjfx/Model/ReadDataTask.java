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
    public Integer call() throws EmptyTableException{
        //Sjekker hvilken filtype det er, og lager riktig filHandler
        if (file.getName().endsWith(".jobj")){
            try {
                fileHandler = new JOBJReader(file);
                setDataObjects(fileHandler.getData()); //Lagrer listen som hentes opp av JOBJReaderen
            } catch (IOException | ClassNotFoundException e) {
                throw new EmptyTableException("Error loading this file, the file is corrupt");
            }
        }else if (file.getName().endsWith(".csv")){
            fileHandler = new CSVReader(file);
            this.typeOfObject = fileHandler.getTypeOfObject(); //Lagrer typen av objekt som lastes inn
            this.amountOfRows = fileHandler.getAmountOfRows(); //Lagrer hvor mange objekter som lastes inn
            createAllObjectsFromCSV(); //Lager alle objektene
        }
        return amountOfRows; //Returnerer antall rader, ikke brukt fordi vi har brukt task litt feil
        //Og i det vi skjønte det, hadde vi for liten tid til å endre på det.
    }

    private void createAllObjectsFromCSV() throws EmptyTableException {
        ObjectCreator objectCreator = new ObjectCreator(); //Lager en objectCreator (som lager riktig objekt etter type)
        for (int i = 0; i < amountOfRows; i++) { //Lager alle objektene, en etter en, til alle er laget
            String objectValues[] = new String[0];
            try {
                objectValues = fileHandler.getNextLine(); //Henter neste linje i CSV filen
            } catch (IOException e) {
                e.printStackTrace();
            }

            objectCreator.createObject(typeOfObject, objectValues); //Lager objektet, etter type
            dataObjects.add(objectCreator.getObject()); //Setter objektet inn i listen
            updateProgress(i, amountOfRows-1); //Oppdaterer hvor langt vi har kommet (ProgressIndicator)
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
