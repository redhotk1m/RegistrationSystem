package org.openjfx;


import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static javafx.collections.FXCollections.observableArrayList;

public class mCSVReader implements FileManagement{

    private String absolutePath = new File("").getAbsolutePath();
    private String CSVFileFolder = absolutePath + "/src/main/resources/org/openjfx/";
    private String ClientsCSV = CSVFileFolder + "Clients.csv";
    private String SkademeldingCSV = CSVFileFolder + "Skademelding.csv";
    private ObservableList data = observableArrayList();
    private String line;
    //BufferedReader br = new BufferedReader(new FileReader(FILECHOOSER))
    BufferedReader br;
    ArrayList<String> allValues = new ArrayList<>();

    @Override
    public void loadFile(Stage stage) {

    }

    public void addFromFile(File file) throws IOException {
        br = new BufferedReader(new FileReader(ClientsCSV)); //TODO filechooser for å velge fil, ved å ha addFromFile(File file) hvor file blir hentet med FileChooser
        if (data.size()>0) {
            data.clear();
        }
        String fileType = br.readLine();
        createArray();
        switch (fileType){
            case "Clients":
                System.out.println(allValues.size());
                for (int i = 0; i<allValues.size(); i+=3) {
                    data.add(new mdClients(allValues.get(i), allValues.get(i + 1), allValues.get(i + 2)));
                }
                break;
            case "Skademelding":
                for (int i = 0; i<allValues.size(); i+=7) {//TODO Returnere mdskademelding.getFieldsize?
                    data.add(new mdSkademelding(allValues.get(i), allValues.get(i + 1), allValues.get(i + 2),
                            allValues.get(i + 3) ,allValues.get(i +4), allValues.get(i + 5), allValues.get(i + 6)));
                }
            break;
                default:
                    throw new InvalidParameterException("Feil ved innlasting");
            }
            /*
            //TODO Hvis første linje = Client, Insurance, etc, lagre dem i ObservableList<mdClients> / ObservableList<Insurances> etc
            while ((line = br.readLine()) != null) { //Så lenge neste linje i CSV filen ikke er tom, ...
                //Setter hva som skal separere strengene i filen
                String cvsSplitBy = ";"; //Semikolon som separator
                String[] values = line.split(cvsSplitBy); //Lager et array med teksten i CSV filen, seprarert med ; som elementer
                for (int i = 0; i < values.length; i++){
                    test.add(values[i]);
                }

                //data.add(new mdClients(array[0], array[1], array[2])); //Legger inn verdiene inn i ObservableList

                //ParseInt eller toString? (Kan vi bare ha alt string, og parse til int om vi trenger å regne med ?
            }
            for (int i = 0; i<test.size()/3; i++) {
                data.add(new mdClients(test.get(i), test.get(i + 1), test.get(i + 2)));
            }

        } catch (IOException e) {
            //TODO Legge inn feilmelding på GUI ved feil innlasting
            e.printStackTrace();
        }
*/

        /*
        for (int k = 0; k < data.size(); k++){
            System.out.println("Fornavn: " + data.get(k).firstNameProperty() + "\nEtternavn: " + data.get(k).lastNameProperty());
        }
        */
    }

    private void createArray() throws IOException {
        String csvSplitBy = ";";
        while ((line = br.readLine()) != null){
            String [] values = line.split(csvSplitBy);
            allValues.addAll(Arrays.asList(values));
        }

    }

    //Getter and setter

    public ObservableList<mdClients> getData() {
        return data;
    }

    public void setData(ObservableList<mdClients> data) {
        this.data = data;
    }

}

