package org.openjfx;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static javafx.collections.FXCollections.observableArrayList;

public class mCSVReader {

    private String absolutePath = new File("").getAbsolutePath();
    private String CSVFile = absolutePath + "/src/main/resources/org/openjfx/test2.csv";
    private ObservableList<mdPerson> data = observableArrayList();

    public void addFromFile() {

        if (data.size()>0) {
            data.clear();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(CSVFile))) {

            String line;
            while ((line = br.readLine()) != null) {

                //Setter hva som skal separere strengene i filen
                String cvsSplitBy = ";";
                String [] array = line.split(cvsSplitBy); //Komma som separator

                data.add(new mdPerson(array[0], array[1], Integer.parseInt(array[2]))); //ParseInt eller toString? (Kan vi bare ha alt string, og parse til int om vi trenger å regne med ?
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        /*
        for (int k = 0; k < data.size(); k++){
            System.out.println("Fornavn: " + data.get(k).firstNameProperty() + "\nEtternavn: " + data.get(k).lastNameProperty());
        }
        */
    }

    //Getter and setter

    public ObservableList<mdPerson> getData() {
        return data;
    }

    public void setData(ObservableList<mdPerson> data) {
        this.data = data;
    }



}

