package org.openjfx;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class CSVReader {

    String CSVFile = "C:\\Users\\Eier\\Desktop\\hellofx-intelliJ\\hellofx\\src\\main\\resources\\org\\openjfx\\test2.csv";
    String line = "";
    String cvsSplitBy = ";";

    private ObservableList<Person> data = FXCollections.observableArrayList(
    );

    public void metodeTest() {
        int i = 0;
        StringBuffer stringBuffer = new StringBuffer();
        try (BufferedReader br = new BufferedReader(new FileReader(CSVFile))) {

            while ((line = br.readLine()) != null) {

                //Komma som separator
                String [] array = line.split(cvsSplitBy);
                data.add(new Person(array[0], array[1], Integer.parseInt(array[2]))); //ParseInt eller toString? (Kan vi bare ha alt string, og parse til int om vi trenger å regne med ?
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int k = 0; k < data.size(); k++){
            System.out.println("Fornavn: " + data.get(k).firstNameProperty() + "\nEtternavn: " + data.get(k).lastNameProperty());
        }
    }

    //Getter and setter

    public ObservableList<Person> getData() {
        return data;
    }

    public void setData(ObservableList<Person> data) {
        this.data = data;
    }



}

