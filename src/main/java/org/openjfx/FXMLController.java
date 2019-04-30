package org.openjfx;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Objects;

public class FXMLController {
    @FXML
    private Tab clientTab, boatTab, houseHoldTab, homeTab, travelingTab, skadeTab;

    @FXML
    private TableView KunderTable, SkadeMldTable, BoatTable;

    @FXML
    private TableColumn<mdClients, String> clientDateCreated, fornavn, etternavn, adress, forsikringsNR, skademeldinger,
                                            insurances, unpaid;

    @FXML
    ProgressIndicator progressBar;

    @FXML
    private TextField testFelt;

    @FXML
    private AnchorPane mainFrame;


    @FXML
    private TableColumn<mdSkademelding, String> smDato, skadeNr, skadeType, skadeBeskrivelse, vitneKontaktInfo,
                                                takseringsBeløp, erstatningsBeløp;

    @FXML
    private TableColumn<BoatInsurance, String> boatDate, boatOwner, boatInsurancePrice, boatInsuranceAmount,
                                                boatInsuranceConditions, typeModel, regNr, length, yearModel, motorType,
                                                motorStrength;
    @FXML
    private TableView<HouseholdInsurance> Householdtable;

    @FXML
    private TableColumn<HouseholdInsurance, String> houseAdress, houseInsurancePrice, houseDate, houseInsuranceAmount,
                                                    houseInsuranceConditions, houseConstructionYear, houseResidentalType,
                                                    houseMaterials, houseStandard, houseSqMeters,
                                                    houseBuildingInsuranceAmount, HouseHousingInsuranceAmount;

    FileHandler reader;
    ObservableList data;

    @FXML
    private TableView chooseTable() {
        if (clientTab.isSelected()) {
            return KunderTable;
        }
        if(boatTab.isSelected()) {
            return BoatTable;
        }
        if(skadeTab.isSelected()) {
            return SkadeMldTable;
        }
        return null;
    }

    private String getChosenTable(){
        if (clientTab.isSelected()) {
            return "Clients";
        }
        if(boatTab.isSelected()) {
            return "Båtfaen";
        }
        if(skadeTab.isSelected()) {
            return "Skademelding";
        }
        return null;
    }

    @FXML
    private void loadFile() throws IOException {
        //TableView tableView = chooseTable();
        //Innlesing av filen her, tar lang tid, innlastingen av all dataen er på en ny thread. Kanskje hive den på ny thread? Ikke nødvendig
        File file = new FileChooser().showOpenDialog(mainFrame.getScene().getWindow());
        readDataThread readDataThread = new readDataThread(file);
        TableView tableView = setCorrectTable(readDataThread.typeOfObject);

        //chooseTable(readDataThread.typeOfObject);
        try {
            //readDataThread.call();
            progressBar.progressProperty().bind(readDataThread.progressProperty());
            new Thread(readDataThread).start();
            tableView.setItems(readDataThread.getDataObjects());
            tableView.setEditable(true); //TODO Fjernes, fordi den skal settes til editable i initialize
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*if (file.getName().endsWith(".csv")){
            new Thread (() -> {
                reader = new mCSVReader();
                CreateObjectThread a = new CreateObjectThread();
                progressBar.progressProperty().bind(a.progressProperty());
                try {
                    reader.addFromFile(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                this.setData(reader.getData());
                tableView.setItems(data);
                tableView.setEditable(true);
            }).start();
        }else if (file.getName().endsWith(".jobj")){
            //TODO Lage jobj reader/writer
            reader = new mJOBJReader();
        }else {
            //TODO Throw invalid FileType exception
        }*/

    }

    private TableView setCorrectTable(String typeOfObject) {
        switch (typeOfObject){
            case "Clients":
                return KunderTable;
            case "Skademelding":
                return SkadeMldTable;
            default:
                return null;
        }
    }

    private void noe(){

    }
    private void assignKunderColumns() {
        clientDateCreated.setCellValueFactory(
                new PropertyValueFactory<>("dateCreated")
        );
        fornavn.setCellValueFactory(
                new PropertyValueFactory<>("firstName")
        );

        etternavn.setCellValueFactory(
                new PropertyValueFactory<>("lastName")
        );

        adress.setCellValueFactory(
                new PropertyValueFactory<>("adress")
        );

        forsikringsNR.setCellValueFactory(
                new PropertyValueFactory<>("forsikringsNR")
        );

        skademeldinger.setCellValueFactory(
                new PropertyValueFactory<>("skademeldinger")
        );

        insurances.setCellValueFactory(
                new PropertyValueFactory<>("forsikringer")
        );

        unpaid.setCellValueFactory(
                new PropertyValueFactory<>("ubetalt")
        );
    }

    private void assignBoatInsuranceColumns() {
        boatOwner.setCellValueFactory(
                new PropertyValueFactory<>("Owner")
        );

        boatInsurancePrice.setCellValueFactory(
                new PropertyValueFactory<>("insurancePrice")
        );

        boatDate.setCellValueFactory(
                new PropertyValueFactory<>("dateCreated")
        );

        boatInsuranceAmount.setCellValueFactory(
                new PropertyValueFactory<>("insuranceAmount")
        );

        boatInsuranceConditions.setCellValueFactory(
                new PropertyValueFactory<>("insuranceConditions")
        );

        regNr.setCellValueFactory(
                new PropertyValueFactory<>("RegNr")
        );

        typeModel.setCellValueFactory(
                new PropertyValueFactory<>("TypeModel")
        );

        length.setCellValueFactory(
                new PropertyValueFactory<>("length")
        );

        yearModel.setCellValueFactory(
                new PropertyValueFactory<>("year")
        );

        motorType.setCellValueFactory(
                new PropertyValueFactory<>("motorType")
        );

        motorStrength.setCellValueFactory(
                new PropertyValueFactory<>("motorStrength")
        );
    }

    private void assignHouseholdColumns() {
        houseAdress.setCellValueFactory(
                new PropertyValueFactory<>("adress")
        );

        houseInsurancePrice.setCellValueFactory(
                new PropertyValueFactory<>("insurancePrice")
        );

        houseDate.setCellValueFactory(
                new PropertyValueFactory<>("dateCreated")
        );

        houseInsuranceAmount.setCellValueFactory(
                new PropertyValueFactory<>("insuranceAmount")
        );

        houseInsuranceConditions.setCellValueFactory(
                new PropertyValueFactory<>("insuranceConditions")
        );

        houseResidentalType.setCellValueFactory(
                new PropertyValueFactory<>("residentalType")
        );


    }

    private void assignSkademldColumns() {
        smDato.setCellValueFactory(
                new PropertyValueFactory<>("SMDato")
        );

        skadeNr.setCellValueFactory(
                new PropertyValueFactory<>("SkadeNR")
        );

        skadeType.setCellValueFactory(
                new PropertyValueFactory<>("SkadeType")
        );

        skadeBeskrivelse.setCellValueFactory(
                new PropertyValueFactory<>("SkadeBeskrivelse")
        );

        vitneKontaktInfo.setCellValueFactory(
                new PropertyValueFactory<>("VitneKontaktInfo")
        );

        takseringsBeløp.setCellValueFactory(
                new PropertyValueFactory<>("TakseringsBeloep")
        );

        erstatningsBeløp.setCellValueFactory(
                new PropertyValueFactory<>("ErstatningsBeloep")
        );

    }

    private void assignAllColumns(){
        assignKunderColumns();
        assignBoatInsuranceColumns();
        //assignHouseholdColumns();
        assignSkademldColumns();
    }

    @FXML
    private void saveFile(){
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter(".csv", "*.csv");
        FileChooser.ExtensionFilter extensionFilter1 = new FileChooser.ExtensionFilter(".jobj","*.jobj");
        fileChooser.getExtensionFilters().addAll(extensionFilter, extensionFilter1);
        File destination = fileChooser.showSaveDialog(mainFrame.getScene().getWindow());
        if (destination.getName().endsWith(".csv")){
            FileHandler fileHandler = new mCSVWriter();
            System.out.println(KunderTable.getItems());
            fileHandler.saveFile(destination, KunderTable.getItems(), getChosenTable());
            System.out.println("CSV");
        }else if (destination.getName().endsWith(".jobj")){
            System.out.println("JOBJ");
        }
    }

    @FXML
    private void deleteButton(ActionEvent event){
        TableView tableView = chooseTable();

        System.out.println(tableView.getId());
        tableView.getItems().removeAll(tableView.getSelectionModel().getSelectedItems());

    }

    @FXML
    private void testButton(ActionEvent event){
        //TODO Popup med verdier, fyll dem, trykk på knappen, verdiene sendes inn i metoden her, valideres, også lages hele objektet.
        mdClients clients = new mdClients();
        clients.setDateCreated("1");
        clients.setFirstName("2");
        clients.setLastName("3");
        clients.setAdress("4");
        clients.setForsikringsNR("5");
        clients.setForsikringer("6");
        clients.setSkademeldinger("7");
        clients.setUbetalt("8");
        data.add(clients);
    }

    @FXML
    private void onEdit(TableColumn.CellEditEvent editEvent){
        mdClients mdClients = getKunderTable().getSelectionModel().getSelectedItem();
        //mdClients.setFirstName(editEvent.getNewValue());
        String Column = editEvent.getTableColumn().getText();
        String Value = editEvent.getNewValue().toString();
        switch (Column){
            case "Opprettet":
                mdClients.setDateCreated(Value);
                break;
            case "Fornavn":
                mdClients.setFirstName(Value);
                break;
            case "Etternavn":
                mdClients.setLastName(Value);
                break;
        }
    }

    public void initialize() {
        // TODO
        assignAllColumns();
        setEditableColumns();
    }

    private void setEditableColumns(){
        clientDateCreated.setCellFactory(TextFieldTableCell.forTableColumn());
        fornavn.setCellFactory(TextFieldTableCell.forTableColumn());
        etternavn.setCellFactory(TextFieldTableCell.forTableColumn());
        forsikringsNR.setCellFactory(TextFieldTableCell.forTableColumn());
        adress.setCellFactory(TextFieldTableCell.forTableColumn());
        skademeldinger.setCellFactory(TextFieldTableCell.forTableColumn());
        insurances.setCellFactory(TextFieldTableCell.forTableColumn());
        unpaid.setCellFactory(TextFieldTableCell.forTableColumn());


        smDato.setCellFactory(TextFieldTableCell.forTableColumn());
        skadeNr.setCellFactory(TextFieldTableCell.forTableColumn());
        skadeType.setCellFactory(TextFieldTableCell.forTableColumn());
        skadeBeskrivelse.setCellFactory(TextFieldTableCell.forTableColumn());
        vitneKontaktInfo.setCellFactory(TextFieldTableCell.forTableColumn());
        takseringsBeløp.setCellFactory(TextFieldTableCell.forTableColumn());
        erstatningsBeløp.setCellFactory(TextFieldTableCell.forTableColumn());

        //TODO Fyll ut denne lille satanen
    }


    //Setter and getter

    public TableView<mdClients> getKunderTable() {
        return KunderTable;
    }

    public void setKunderTable(TableView<mdClients> kunderTable) {
        KunderTable = kunderTable;
    }

    public TableColumn<mdClients, String> getFornavn() {
        return fornavn;
    }

    public void setFornavn(TableColumn<mdClients, String> fornavn) {
        this.fornavn = fornavn;
    }

    public TableColumn<mdClients, String> getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(TableColumn<mdClients, String> etternavn) {
        this.etternavn = etternavn;
    }

    public TextField getTestFelt() {
        return testFelt;
    }

    public void setTestFelt(TextField testFelt) {
        this.testFelt = testFelt;
    }

    public TableColumn<mdClients, String> getForsikringsNR() {
        return forsikringsNR;
    }

    public void setForsikringsNR(TableColumn<mdClients, String> forsikringsNR) {
        this.forsikringsNR = forsikringsNR;
    }

    public ObservableList getData() {
        return data;
    }

    public void setData(ObservableList data) {
        this.data = data;
    }
}
