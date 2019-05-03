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
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            //TODO lage fileNotFound GUI
            e.printStackTrace();
        }
        String[] infoAboutFileSize = new String[0];
        try {
            infoAboutFileSize = getNextLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.typeOfObject = infoAboutFileSize[0];
        this.amountOfRows = Integer.parseInt(infoAboutFileSize[1]);
    }


    @Override
    public String[] getNextLine() throws IOException {
        return br.readLine().split(";");
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


    public TableView getTableView() {
        return tableView;
    }

    public void setTableView(TableView tableView) {
        this.tableView = tableView;
    }
}

