package org.openjfx.Model.ReadAndWrite;

import javafx.application.Platform;
import javafx.scene.control.TableView;
import org.openjfx.Model.ErrorMessage;

import java.io.*;
public class CSVReader extends FileHandler {

    private String line;
    private TableView tableView;
    private String typeOfObject;
    private int amountOfRows;
    BufferedReader br;

    public CSVReader(File file) {
        //Tar inn filen (hentet med fileChooser)
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //Lager et array med første linje i CSV filen (Vi bruker det til å identifisere hvor mange objekter den inneholder)
        //og hvilken klasse den inneholder (Client, TravelInsurance, etc).
        String[] infoAboutFileSize = new String[0];
        try {
            infoAboutFileSize = getNextLine(); //Henter første linje
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.typeOfObject = infoAboutFileSize[0]; //Lagrer datatypen (Client, TravelInsurance, etc)
        this.amountOfRows = Integer.parseInt(infoAboutFileSize[1]); //Lagrer hvor mange objekter som skal lages
    }


    @Override
    public String[] getNextLine() throws IOException {
        return br.readLine().split(";"); //Leser inn en linje, lager array men semikolon som splitter.
    }


    //Getter and setter

    @Override
    public String getTypeOfObject() {
        return typeOfObject;
    }
    @Override
    public void setTypeOfObject(String typeOfObject) {
        this.typeOfObject = typeOfObject;
    }
    @Override
    public int getAmountOfRows() {
        return amountOfRows;
    }
    @Override
    public void setAmountOfRows(int amountOfRows) {
        this.amountOfRows = amountOfRows;
    }

}

