package org.openjfx;


import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.*;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;

import static javafx.collections.FXCollections.observableArrayList;

public class mCSVReader extends FileHandler {

    private String absolutePath = new File("").getAbsolutePath();
    private String CSVFileFolder = absolutePath + "/src/main/resources/org/openjfx/";
    private String ClientsCSV = CSVFileFolder + "Clients.csv";
    private String BåtCSV = CSVFileFolder + "boatInsurance.csv";
    private String SkademeldingCSV = CSVFileFolder + "Skademelding.csv";
    private ObservableList data = observableArrayList();
    private String line;
    //BufferedReader br = new BufferedReader(new FileReader(FILECHOOSER))
    BufferedReader br;
    ArrayList<String> allValues = new ArrayList<>();

    mCSVReader(TableView tableView){

    }

    @Override
    public void addFromFile(File file) throws IOException {
        //TODO Håndter feilmelding når ingen fil er valgt
        br = new BufferedReader(new FileReader(file));
        if (data.size()>0) {
            //data.clear();
        }
        String fileType = br.readLine();
        createArray();
        switch (fileType){
            case "Clients":
                System.out.println(allValues.size());
                for (int i = 0; i<allValues.size(); i+=8) {
                    mdClients clients = new mdClients();
                    clients.setDateCreated(allValues.get(i));
                    clients.setFirstName(allValues.get(i + 1));
                    clients.setLastName(allValues.get(i + 2));
                    clients.setAdress(allValues.get(i + 3));
                    clients.setForsikringsNR(allValues.get(i + 4));
                    clients.setForsikringer(allValues.get(i + 5));
                    clients.setSkademeldinger(allValues.get(i + 6));
                    clients.setUbetalt(allValues.get(i + 7));
                    data.add(clients);
                }
                break;

            case "Boatforsikring":
                for (int i = 0; i<allValues.size(); i+=11) {
                    BoatInsurance boat = new BoatInsurance();
                    boat.setDateCreated(allValues.get(i));
                    boat.setOwner(allValues.get(i + 1));
                    boat.setInsurancePrice(allValues.get(i + 2));
                    boat.setInsuranceAmount(allValues.get(i + 3));
                    boat.setInsuranceConditions(allValues.get(i + 4));
                    boat.setRegNr(allValues.get(i + 5));
                    boat.setTypeModel(allValues.get(i + 6));
                    boat.setLength(allValues.get(i + 7));
                    boat.setYear(allValues.get(i + 8));
                    boat.setMotorType(allValues.get(i + 9));
                    boat.setMotorStrength(allValues.get(i + 10));
                    data.add(boat);
                }
                break;

            case "Skademelding":
                for (int i = 0; i<allValues.size(); i+=7) {//TODO Returnere mdskademelding.getFieldsize?
                    mdSkademelding skadeMld = new mdSkademelding();
                    skadeMld.setSMDato(allValues.get(i));
                    skadeMld.setSkadeNR(allValues.get(i + 1));
                    skadeMld.setSkadeType(allValues.get(i + 2));
                    skadeMld.setSkadeBeskrivelse(allValues.get(i + 3));
                    skadeMld.setVitneKontaktInfo(allValues.get(i + 4));
                    skadeMld.setTakseringsBeloep(allValues.get(i + 5));
                    skadeMld.setErstatningsBeloep(allValues.get(i + 6));
                    data.add(skadeMld);
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

    public ObservableList getData() {
        return data;
    }

    public void setData(ObservableList<mdClients> data) {
        this.data = data;
    }

}

