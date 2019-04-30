package org.openjfx;


import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

import java.io.*;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;

import static javafx.collections.FXCollections.observableArrayList;

public class mCSVReader extends FileHandler {

    private String absolutePath = new File("").getAbsolutePath();
    private String CSVFileFolder = absolutePath + "/src/main/resources/org/openjfx/";
    private ObservableList data = observableArrayList();
    private String line;
    private TableView tableView;
    private String typeOfObject;
    private int amountOfRows;
    //BufferedReader br = new BufferedReader(new FileReader(FILECHOOSER))
    BufferedReader br;
    ArrayList<String> allValues = new ArrayList<>();
    checkArguments inputCheck = new checkArguments();

    mCSVReader(File file) throws IOException {
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            //TODO lage fileNotFound GUI
            e.printStackTrace();
        }
        String[] infoAboutFileSize = getNextLine();
        this.typeOfObject = infoAboutFileSize[0];
        this.amountOfRows = Integer.parseInt(infoAboutFileSize[1]);
    }


    @Override
    public String[] getNextLine() throws IOException {
        return br.readLine().split(";");
    }

    /*public void addFromFile(File file) throws IOException {
        //TODO Håndter feilmelding når ingen fil er valgt
        br = new BufferedReader(new FileReader(file));
        if (data.size()>0) {
            //data.clear();
        }
        String fileType = br.readLine();
        createArray();
        switch (fileType){
            case "Clients":
                createClient();
                break;
            case "Boatforsikring":
                createBoatInsurance();
                break;
            case "Skademelding":
                createSkademelding();
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

    }*/


    /*private void testCreate(){
        /*
        testCreate er task klassen
        mcvsReader = new mcvsReader();
        mcvsReader.getClassType; returnerer hvilken klasse vi skal lage av
        mcvsReader.getAntallRader; returnerer hvor mange rader det er i filen
        mcvsReader.getAntallKolonner; returnerer hvor mange kolonner det er i filen
        deretter kommer forloopen, som returnerer progress, og når alt er ferdig legges data inn i tableview

        for (int j = 0; j<antallRaderICSV; j++){ //Eller while br.nextline != null, hvis vi ikke bør ha kolonner/rader lagret i CSV
            for (int i = 0; i<antallKolonnerICSV; i++){ //TODO Kommer til å lage ett objekt, kan returnere hvor mange
                //TODO den har laget ved å følge med på J, progressbar. rader og kolonner kan vi finne i starten av CSVen
                mdSkademelding skademelding = new mdSkademelding();
                skadeMld.setSMDato(allValues.get(i));
                skadeMld.setSkadeNR(allValues.get(i + 1));
                skadeMld.setSkadeType(allValues.get(i + 2));
                skadeMld.setSkadeBeskrivelse(allValues.get(i + 3));
                skadeMld.setVitneKontaktInfo(allValues.get(i + 4));
                skadeMld.setTakseringsBeloep(allValues.get(i + 5));
                skadeMld.setErstatningsBeloep(allValues.get(i + 6));
                data.add(skadeMld);
            }
        }
    }*/
    private void createSkademelding() {
        for (int i = 0; i<allValues.size(); i+=7) {//TODO Returnere mdskademelding.getFieldsize?
            //TODO Når vi lagrer til CSV fil, kanskje skrive hvor mange kolonner og rader der er, så vi vet det på forhånd?
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
    }

    private void createBoatInsurance() {
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
    }

    private void createClient(){
        for (int i = 0; i<allValues.size(); i+=8) {
            mdClients clients = new mdClients();

            if(inputCheck.dateTest(allValues.get(i)))
                clients.setDateCreated(allValues.get(i));

            if(inputCheck.stringTest(allValues.get(i + 1)))
                clients.setFirstName(allValues.get(i + 1));

            if(inputCheck.stringTest(allValues.get(i + 2)))
                clients.setLastName(allValues.get(i + 2));

            if(inputCheck.streetTest(allValues.get(i + 3)))
                clients.setAdress(allValues.get(i + 3));

            if(inputCheck.numberTest(allValues.get(i + 4)))
                clients.setForsikringsNR(allValues.get(i + 4));

            if(inputCheck.numberTest(allValues.get(i + 5)))
                clients.setForsikringer(allValues.get(i + 5));

            if(inputCheck.numberTest(allValues.get(i + 6)))
                clients.setSkademeldinger(allValues.get(i + 6));

            if(inputCheck.numberTest(allValues.get(i+7)))
                clients.setUbetalt(allValues.get(i + 7));
            data.add(clients);
        }
    }

    private void createArray() throws IOException {
        while ((line = br.readLine()) != null){
            String [] values = line.split(";");
            allValues.addAll(Arrays.asList(values)); //Legger til antall linjer som ett objekt inneholder
        }
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


    @Override
    public ObservableList getData() {
        return data;
    }

    public void setData(ObservableList<mdClients> data) {
        this.data = data;
    }


    public TableView getTableView() {
        return tableView;
    }

    public void setTableView(TableView tableView) {
        this.tableView = tableView;
    }
}

