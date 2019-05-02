package org.openjfx;

import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.openjfx.Model.*;
import org.openjfx.Model.DataClasses.BoatInsurance;
import org.openjfx.Model.DataClasses.Clients;
import org.openjfx.Model.DataClasses.SecondaryHouseInsurance;
import org.openjfx.Model.DataClasses.Skademelding;
import org.openjfx.Model.ReadAndWrite.CSVWriter;
import org.openjfx.Model.ReadAndWrite.FileHandler;
import org.openjfx.Model.ReadAndWrite.JOBJWriter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.function.Predicate;

public class FXMLController {
    @FXML
    private Tab clientTab, boatTab, houseHoldTab, homeTab, travelingTab, skadeTab;

    @FXML
    private TableView KunderTable, SkadeMldTable, BoatTable, houseHoldTable;

    @FXML
    private TableColumn<Clients, String> clientDateCreated, fornavn, etternavn, adress, forsikringsNR, skademeldinger,
                                            insurances, unpaid;

    @FXML
    ProgressIndicator progressBar;

    @FXML
    private TextField testFelt;

    @FXML
    private AnchorPane mainFrame;


    @FXML
    private TableColumn<Skademelding, String> smDato, skadeNr, skadeType, skadeBeskrivelse, vitneKontaktInfo,
                                                takseringsBeløp, erstatningsBeløp;

    @FXML
    private TableColumn<BoatInsurance, String> boatDate, boatOwner, boatInsurancePrice, boatInsuranceAmount,
                                                boatInsuranceConditions, typeModel, regNr, length, yearModel, motorType,
                                                motorStrength;
    @FXML
    private TableView<SecondaryHouseInsurance> Householdtable;

    @FXML
    private TableColumn<SecondaryHouseInsurance, String> houseAdress, houseInsurancePrice, houseDate, houseInsuranceAmount,
                                                    houseInsuranceConditions, houseConstructionYear, houseResidentalType,
                                                    houseMaterials, houseStandard, houseSqMeters,
                                                    houseBuildingInsuranceAmount, HouseHousingInsuranceAmount;
    @FXML
    private TextField searchField;

    FileHandler reader;
    ObservableList data,clientData,boatData,damageReportData;

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
            return "BoatInsurance";
        }
        if(skadeTab.isSelected()) {
            return "Skademelding";
        }
        return null;
    }

    @FXML
    private void loadFile(){
        File file = new FileChooser().showOpenDialog(mainFrame.getScene().getWindow());
        ReadDataTask readDataTask = new ReadDataTask(file);
        progressBar.progressProperty().bind(readDataTask.progressProperty());
        if (file == null){
            return;
        }
        try {
            new Thread(() ->{
                progressBar.setVisible(true);
                readDataTask.call();
                data = (readDataTask.getDataObjects()); //TODO Switch case, for hver dataTable sånn at de kan bli accessed
                if (data.get(0).getClass().getName().endsWith("Clients"))
                    clientData = data;
                if (data.get(0).getClass().getName().endsWith("BoatInsurance"))
                    boatData = data;
                TableView tableView = setCorrectTable(readDataTask.getDataObjects().get(0).getClass().getName());
                tableView.setItems(data);
                tableView.setEditable(true);
                progressBar.setVisible(false);
            }).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private TableView setCorrectTable(String typeOfObject) {
        if (typeOfObject.endsWith("Clients")){
            return KunderTable;
        } else if (typeOfObject.endsWith("Skademelding")){
            return SkadeMldTable;
        } else if (typeOfObject.endsWith("BoatInsurance")) {
            return BoatTable;
        }
       return null;
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
                new PropertyValueFactory<>("regNr")
        );

        typeModel.setCellValueFactory(
                new PropertyValueFactory<>("typeModel")
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

        houseMaterials.setCellValueFactory(
                new PropertyValueFactory<>("materials")
        );

        houseStandard.setCellValueFactory(
                new PropertyValueFactory<>("standard")
        );

        houseSqMeters.setCellValueFactory(
                new PropertyValueFactory<>("sqMeters")
        );

        houseBuildingInsuranceAmount.setCellValueFactory(
                new PropertyValueFactory<>("buildingInsuranceAmount")
        );

        HouseHousingInsuranceAmount.setCellValueFactory(
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
        setExtentionFilters(fileChooser);
        File saveDestination = fileChooser.showSaveDialog(mainFrame.getScene().getWindow());
        TableView currentTableview = chooseTable();
        new Thread(() -> {
            //TODO Ny thread inne i en annen klasse?
            FileHandler fileHandler = null;
            if (saveDestination.getName().endsWith(".csv")){
                fileHandler = new CSVWriter();
            } else if (saveDestination.getName().endsWith(".jobj")){
                fileHandler = new JOBJWriter();
            }
            fileHandler.saveFile(saveDestination, currentTableview.getItems(), getChosenTable()); //TODO Ikke currentTableview.getItems() men observableListen som tilhører viewet. (ikke sortedlist)
        }).start();
    }

    private void setExtentionFilters(FileChooser fileChooser){
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter(".csv", "*.csv");
        FileChooser.ExtensionFilter extensionFilter1 = new FileChooser.ExtensionFilter(".jobj","*.jobj");
        fileChooser.getExtensionFilters().addAll(extensionFilter, extensionFilter1);
    }

    @FXML
    private void deleteButton(ActionEvent event){
        TableView tableView = chooseTable();
        ArrayList objectToRemove = new ArrayList(tableView.getSelectionModel().getSelectedItems());
        if (tableView == KunderTable)
            clientData.removeAll(objectToRemove);
        if (tableView == BoatTable)
            boatData.removeAll(objectToRemove);
        //tableView.getItems().removeAll(a);
    }

    @FXML
    private void testButton(ActionEvent event) throws IOException {
        //TODO Popup med verdier, fyll dem, trykk på knappen, verdiene sendes inn i metoden her, valideres, også lages hele objektet.
        Clients clients = new Clients();
        clients.setDateCreated("1");
        clients.setFirstName("2");
        clients.setLastName("3");
        clients.setAdress("4");
        clients.setForsikringsNR("5");
        clients.setForsikringer("6");
        clients.setSkademeldinger("7");
        clients.setUbetalt("8");
        //data.add(clients);
    }

    @FXML
    private void onEdit(TableColumn.CellEditEvent editEvent){
        getKunderTable().getSelectionModel().getSelectedItem();
        Clients Clients = getKunderTable().getSelectionModel().getSelectedItem();
        //Clients.setFirstName(editEvent.getNewValue());
        String Column = editEvent.getTableColumn().getText();
        String Value = editEvent.getNewValue().toString();
        switch (Column){
            case "Opprettet":
                Clients.setDateCreated(Value);
                break;
            case "Fornavn":
                Clients.setFirstName(Value);
                break;
            case "Etternavn":
                Clients.setLastName(Value);
                break;
        }
    }

    public void initialize() {
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


    private void clientSearch() {
        FilteredList<Clients> filteredClients;
        filteredClients = new FilteredList<>(clientData, b -> true);
        searchField.textProperty().addListener((observableValue, oldValue, newValue) ->
                filteredClients.setPredicate((Clients clients) -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }

                    String lowerCaseClient = newValue.toLowerCase();

                    if (clients.getDateCreated().contains(newValue)) {
                        return true;
                    }

                    else if (clients.getFirstName().contains(lowerCaseClient)) {
                        return true;
                    }

                    else if (clients.getLastName().contains(lowerCaseClient)) {
                        return true;
                    }
                    else if (clients.getAdress().contains(newValue)) {
                        return true;
                    }

                    else if (clients.getForsikringsNR().contains(newValue)) {
                        return true;
                    }

                    else if (clients.getForsikringer().contains(newValue)) {
                        return true;
                    }

                    else if (clients.getSkademeldinger().contains(newValue)) {
                        return true;
                    }

                    else if (clients.getUbetalt().contains(newValue)) {
                        return true;
                    }

                    return false;
                })
        );
        KunderTable.setItems(filteredClients);
    }


    private void boatSearch() {
        FilteredList<BoatInsurance> filteredBoat;
        filteredBoat = new FilteredList<>(boatData, b -> true);
        searchField.textProperty().addListener((observableValue, oldValue, newValue) ->
                filteredBoat.setPredicate((BoatInsurance boat) -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }

                    String lowerCaseBoat = newValue.toLowerCase();

                    if (boat.getDateCreated().contains(newValue)) {
                        return true;
                    }

                    else if (boat.getOwner().contains(lowerCaseBoat)) {
                        return true;
                    }

                    else if (boat.getInsurancePrice().contains(newValue)) {
                        return true;
                    }

                    else if (boat.getInsuranceAmount().contains(newValue)) {
                        return true;
                    }

                    else if (boat.getInsuranceConditions().contains(lowerCaseBoat)) {
                        return true;
                    }

                    else if (boat.getRegNr().contains(newValue)) {
                        return true;
                    }

                    else if (boat.getTypeModel().contains(lowerCaseBoat)) {
                        return true;
                    }

                    else if (boat.getLength().contains(newValue)) {
                        return true;
                    }

                    else if (boat.getYear().contains(newValue)) {
                        return true;
                    }

                    else if (boat.getMotorType().contains(lowerCaseBoat)) {
                        return true;
                    }

                    else if (boat.getMotorStrength().contains(newValue)) {
                        return true;
                    }

                    return false;
                })
        );
        BoatTable.setItems(filteredBoat);
    }


    private void damageRepSearch() {
        FilteredList<Skademelding> filteredDamageRep;
        filteredDamageRep = new FilteredList<>(data, b -> true);
        searchField.textProperty().addListener((observableValue, oldValue, newValue) ->
                filteredDamageRep.setPredicate((Skademelding damageRep) -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }

                    String lowerCaseDamageRep = newValue.toLowerCase();

                    if (damageRep.getSMDato().contains(newValue)) {
                        return true;
                    }

                    else if (damageRep.getSkadeNR().contains(newValue)) {
                        return true;
                    }

                    else if (damageRep.getSkadeType().contains(lowerCaseDamageRep)) {
                        return true;
                    }

                    else if (damageRep.getSkadeBeskrivelse().contains(lowerCaseDamageRep)) {
                        return true;
                    }

                    else if (damageRep.getVitneKontaktInfo().contains(lowerCaseDamageRep)) {
                        return true;
                    }

                    else if (damageRep.getTakseringsBeloep().contains(newValue)) {
                        return true;
                    }

                    else if (damageRep.getErstatningsBeloep().contains(newValue)) {
                        return true;
                    }

                    return false;
                })
        );
        SkadeMldTable.setItems(filteredDamageRep);
    }

    @FXML
    private void tableSearch() {
        if (data == null || data.isEmpty()) {
            return;
        }

        if (chooseTable().equals(KunderTable)) {
          clientSearch();
        }

        if(chooseTable().equals(SkadeMldTable)) {
            damageRepSearch();
        }

        if (chooseTable().equals(BoatTable)) {
            boatSearch();
        }
    }

    //Setter and getter

    public TableView<BoatInsurance> getBoatTable(){
        return BoatTable;
    }

    public TableView<Clients> getKunderTable() {
        return KunderTable;
    }

    public void setKunderTable(TableView<Clients> kunderTable) {
        KunderTable = kunderTable;
    }

    public TableColumn<Clients, String> getFornavn() {
        return fornavn;
    }

    public void setFornavn(TableColumn<Clients, String> fornavn) {
        this.fornavn = fornavn;
    }

    public TableColumn<Clients, String> getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(TableColumn<Clients, String> etternavn) {
        this.etternavn = etternavn;
    }

    public TextField getTestFelt() {
        return testFelt;
    }

    public void setTestFelt(TextField testFelt) {
        this.testFelt = testFelt;
    }

    public TableColumn<Clients, String> getForsikringsNR() {
        return forsikringsNR;
    }

    public void setForsikringsNR(TableColumn<Clients, String> forsikringsNR) {
        this.forsikringsNR = forsikringsNR;
    }

    public ObservableList getData() {
        return data;
    }

    public void setData(ObservableList data) {
        this.data = data;
    }

    public TextField getSearchField() {
        return searchField;
    }
}
