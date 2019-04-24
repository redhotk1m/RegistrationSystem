package org.openjfx;


import javafx.collections.ObservableList;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static javafx.collections.FXCollections.observableArrayList;

public class mCSVReader implements FileManagement{

    private String absolutePath = new File("").getAbsolutePath();
    private String CSVFileFolder = absolutePath + "/src/main/resources/org/openjfx/";
    private String ClientsCSV = CSVFileFolder + "Clients.csv";
    private String BoatInsurance = CSVFileFolder + "BoatInsurance.csv";
    private ObservableList<mdClients> data = observableArrayList();

    @Override
    public void loadFile(Stage stage) {

    }

    public void addFromFile() {

        if (data.size()>0) {
            data.clear();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(ClientsCSV))) {

            String line;
            while ((line = br.readLine()) != null) { //Så lenge neste linje i CSV filen ikke er tom, ...

                //Setter hva som skal separere strengene i filen
                String cvsSplitBy = ";"; //Semikolon som separator
                String [] array = line.split(cvsSplitBy); //Lager et array med teksten i CSV filen, seprarert med ; som elementer

                data.add(new mdClients(array[0], array[1], array[2])); //Legger inn verdiene inn i ObservableList

                //ParseInt eller toString? (Kan vi bare ha alt string, og parse til int om vi trenger å regne med ?
            }
        } catch (IOException e) {
            //TODO Legge inn feilmelding på GUI ved feil innlasting
            e.printStackTrace();
        }


        /*
        for (int k = 0; k < data.size(); k++){
            System.out.println("Fornavn: " + data.get(k).firstNameProperty() + "\nEtternavn: " + data.get(k).lastNameProperty());
        }
        */
    }

    //Getter and setter

    public ObservableList<mdClients> getData() {
        return data;
    }

    public void setData(ObservableList<mdClients> data) {
        this.data = data;
    }

}

