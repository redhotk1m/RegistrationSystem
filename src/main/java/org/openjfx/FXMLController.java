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
import org.openjfx.Controller.*;
import org.openjfx.Model.*;
import org.openjfx.Model.DataClasses.*;
import org.openjfx.Model.ReadAndWrite.CSVWriter;
import org.openjfx.Model.ReadAndWrite.FileHandler;
import org.openjfx.Model.ReadAndWrite.JOBJWriter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static javafx.collections.FXCollections.observableArrayList;

public class FXMLController {
    @FXML
    ProgressIndicator progressBar;

    @FXML
    private TextField testFelt;

    @FXML
    private AnchorPane mainFrame;

    @FXML
    private Tab clientTab, boatTab, primaryHouseTab, secondaryHouseTab, travelTab, skadeTab;

    @FXML
    private TableView clientTable, damageReportTable, BoatTable, primaryHouseTable, secondaryHouseTable, travelTable;

    @FXML
    private TableColumn<Clients, String> clientDateCreated, firstName, lastName, address, insuranceNumber, damageReports,
            insurances, unpaid;
    @FXML
    private TableColumn<BoatInsurance, String> boatDate, boatOwner, boatInsurancePrice, boatInsuranceAmount,
            boatInsuranceConditions, typeModel, licenseNumber, length, yearModel, motorType,
            motorStrength;
    @FXML
    private TableColumn<PrimaryHouseInsurance, String> primaryHouseAddress, primaryHousePremium, primaryHouseDate,
            primaryHousePrice, primaryHouseConditions, primaryHouseConstructionYear, primaryHouseResidentialType,
            primaryHouseMaterials, primaryHouseStandard, primaryHouseSquareMeters, primaryHouseInsuredFor,
            primaryHouseContentInsuredFor;
    @FXML
    private TableColumn<SecondaryHouseInsurance, String> secondaryHouseAddress, secondaryHousePremium,
            secondaryHouseDate, secondaryHousePrice, secondaryHouseConditions, secondaryHouseConstructionYear,
            secondaryHouseResidentialType, secondaryHouseMaterials, secondaryHouseStandard,
            secondaryHouseSquareMeters, secondaryHouseInsuredFor, secondaryHouseContentInsuredFor;
    @FXML
    private TableColumn<TravelInsurance, String> travelInsuranceArea, travelInsurancePremium, travelInsuranceDate,
            travelInsurancePrice, travelInsuranceConditions, travelInsuranceInsuredFor;
    @FXML
    private TableColumn<DamageReport, String> dateOfDamage, damageReportNumber, typeOfDamage, damageDescription,
            witnessContactInfo, assessmentAmount, paidCompensation;

    @FXML
    private TextField searchField;

    ObservableList data =  observableArrayList();
    ObservableList boatData = observableArrayList();
    ObservableList clientData = observableArrayList();
    ObservableList primaryHouseData = observableArrayList();
    ObservableList secondaryHouseData = observableArrayList();
    ObservableList travelInsuranceData = observableArrayList();
    ObservableList damageReportData = observableArrayList();

    @FXML
    private TableView chooseTable() {
        if (clientTab.isSelected())
            return clientTable;
        if(boatTab.isSelected())
            return BoatTable;
        if (primaryHouseTab.isSelected())
            return primaryHouseTable;
        if (secondaryHouseTab.isSelected())
            return secondaryHouseTable;
        if (travelTab.isSelected())
            return travelTable;
        if(skadeTab.isSelected())
            return damageReportTable;
        return null;
    }

    private String getChosenTable(){
        if (clientTab.isSelected()) {
            return "Clients";
        }
        if (boatTab.isSelected()) {
            return "BoatInsurance";
        }
        if (primaryHouseTab.isSelected()){
            return "PrimaryHouseInsurance";
        }
        if (secondaryHouseTab.isSelected()){
            return "SecondaryHouseInsurance";
        }
        if (travelTab.isSelected()){
            return "TravelInsurance";
        }
        if (skadeTab.isSelected()) {
            return "DamageReport";
        }
        return null; //TODO Throw noSuchTabSelected?
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
                try {
                    readDataTask.call();
                } catch (EmptyTableException e) {
                    e.showErrorGUI("Error loading the file, the file is corrupt");
                    progressBar.setVisible(false);
                    return;
                } catch (IOException e) {
                    e.printStackTrace();
                }
                data = (readDataTask.getDataObjects()); //TODO Switch case, for hver dataTable sånn at de kan bli accessed
                if (data.get(0).getClass().getName().endsWith("Clients"))
                    clientData = data;
                if (data.get(0).getClass().getName().endsWith("BoatInsurance"))
                    boatData = data;
                if (data.get(0).getClass().getName().endsWith("PrimaryHouseInsurance"))
                    primaryHouseData = data;
                if (data.get(0).getClass().getName().endsWith("SecondaryHouseInsurance"))
                    secondaryHouseData = data;
                if (data.get(0).getClass().getName().endsWith("TravelInsurance"))
                    travelInsuranceData = data;
                if (data.get(0).getClass().getName().endsWith("DamageReport"))
                    damageReportData = data;
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
            return clientTable;
        } else if (typeOfObject.endsWith("BoatInsurance")) {
            return BoatTable;
        } else if (typeOfObject.endsWith("PrimaryHouseInsurance")){
            return primaryHouseTable;
        } else if (typeOfObject.endsWith("SecondaryHouseInsurance")){
            return secondaryHouseTable;
        } else if (typeOfObject.endsWith("TravelInsurance")){
            return travelTable;
        } else if (typeOfObject.endsWith("DamageReport")){
            return damageReportTable;
        }
       throw new NullPointerException("No valid stuffs"); //TODO Fikse her
    }

    private void assignKunderColumns() {
        clientDateCreated.setCellValueFactory(new PropertyValueFactory<>("dateCreated"));
        firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        insuranceNumber.setCellValueFactory(new PropertyValueFactory<>("insuranceNumber"));
        damageReports.setCellValueFactory(new PropertyValueFactory<>("damageReports"));
        insurances.setCellValueFactory(new PropertyValueFactory<>("insurances"));
        unpaid.setCellValueFactory(new PropertyValueFactory<>("unpaid"));
    }

    private void assignBoatInsuranceColumns() {
        boatOwner.setCellValueFactory(new PropertyValueFactory<>("owner"));
        boatInsurancePrice.setCellValueFactory(new PropertyValueFactory<>("insurancePremium"));
        boatDate.setCellValueFactory(new PropertyValueFactory<>("dateCreated"));
        boatInsuranceAmount.setCellValueFactory(new PropertyValueFactory<>("insurancePrice"));
        boatInsuranceConditions.setCellValueFactory(new PropertyValueFactory<>("insuranceConditions"));
        licenseNumber.setCellValueFactory(new PropertyValueFactory<>("licenseNumber"));
        typeModel.setCellValueFactory(new PropertyValueFactory<>("typeModel"));
        length.setCellValueFactory(new PropertyValueFactory<>("length"));
        yearModel.setCellValueFactory(new PropertyValueFactory<>("yearModel"));
        motorType.setCellValueFactory(new PropertyValueFactory<>("motorType"));
        motorStrength.setCellValueFactory(new PropertyValueFactory<>("motorStrength"));
    }

    private void assignPrimaryHouseColumns() {
        primaryHouseAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        primaryHousePremium.setCellValueFactory(new PropertyValueFactory<>("insurancePremium"));
        primaryHouseDate.setCellValueFactory(new PropertyValueFactory<>("dateCreated"));
        primaryHousePrice.setCellValueFactory(new PropertyValueFactory<>("insurancePrice"));
        primaryHouseConditions.setCellValueFactory(new PropertyValueFactory<>("insuranceConditions"));
        primaryHouseConstructionYear.setCellValueFactory(new PropertyValueFactory<>("constructionYear")); //@@@@@@@@@@@@@@@@@@@@@@@);
        primaryHouseResidentialType.setCellValueFactory(new PropertyValueFactory<>("residentialType"));
        primaryHouseMaterials.setCellValueFactory(new PropertyValueFactory<>("materials"));
        primaryHouseStandard.setCellValueFactory(new PropertyValueFactory<>("standard"));
        primaryHouseSquareMeters.setCellValueFactory(new PropertyValueFactory<>("squareMeters"));
        primaryHouseInsuredFor.setCellValueFactory(new PropertyValueFactory<>("buildingInsuranceAmount"));
        primaryHouseContentInsuredFor.setCellValueFactory(new PropertyValueFactory<>("contentInsuranceAmount"));
    }

    private void assignSkademldColumns() {
        dateOfDamage.setCellValueFactory(new PropertyValueFactory<>("dateOfDamage"));
        damageReportNumber.setCellValueFactory(new PropertyValueFactory<>("reportNumber"));
        typeOfDamage.setCellValueFactory(new PropertyValueFactory<>("typeOfDamage"));
        damageDescription.setCellValueFactory(new PropertyValueFactory<>("damageDescription"));
        witnessContactInfo.setCellValueFactory(new PropertyValueFactory<>("witnessContactInfo"));
        assessmentAmount.setCellValueFactory(new PropertyValueFactory<>("assessmentAmount"));
        paidCompensation.setCellValueFactory(new PropertyValueFactory<>("paidCompensation"));
    }

    private void assignAllColumns(){
        assignKunderColumns();
        assignBoatInsuranceColumns();
        assignPrimaryHouseColumns();
        assignSecondaryHouseColumns();
        assignTravelInsuranceColumns();
        assignSkademldColumns();
    }

    private void assignSecondaryHouseColumns() {
        secondaryHouseAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        secondaryHousePremium.setCellValueFactory(new PropertyValueFactory<>("insurancePremium"));
        secondaryHouseDate.setCellValueFactory(new PropertyValueFactory<>("dateCreated"));
        secondaryHousePrice.setCellValueFactory(new PropertyValueFactory<>("insurancePrice"));
        secondaryHouseConditions.setCellValueFactory(new PropertyValueFactory<>("insuranceConditions"));
        secondaryHouseConstructionYear.setCellValueFactory(new PropertyValueFactory<>("constructionYear")); //@@@@@@@@@@@@@@@@@@@@@@@);
        secondaryHouseResidentialType.setCellValueFactory(new PropertyValueFactory<>("residentialType"));
        secondaryHouseMaterials.setCellValueFactory(new PropertyValueFactory<>("materials"));
        secondaryHouseStandard.setCellValueFactory(new PropertyValueFactory<>("standard"));
        secondaryHouseSquareMeters.setCellValueFactory(new PropertyValueFactory<>("squareMeters"));
        secondaryHouseInsuredFor.setCellValueFactory(new PropertyValueFactory<>("buildingInsuranceAmount"));
        secondaryHouseContentInsuredFor.setCellValueFactory(new PropertyValueFactory<>("contentInsuranceAmount"));
    }

    private void assignTravelInsuranceColumns() {
        travelInsuranceArea.setCellValueFactory(new PropertyValueFactory<>("insuranceArea"));
        travelInsurancePremium.setCellValueFactory(new PropertyValueFactory<>("insurancePremium"));
        travelInsuranceDate.setCellValueFactory(new PropertyValueFactory<>("dateCreated"));
        travelInsurancePrice.setCellValueFactory(new PropertyValueFactory<>("insurancePrice"));
        travelInsuranceConditions.setCellValueFactory(new PropertyValueFactory<>("insuranceConditions"));
        travelInsuranceInsuredFor.setCellValueFactory(new PropertyValueFactory<>("insuredFor"));
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
        if (tableView == clientTable)
            clientData.removeAll(objectToRemove);
        if (tableView == BoatTable)
            boatData.removeAll(objectToRemove);
        if (tableView == primaryHouseTable)
            primaryHouseData.removeAll(objectToRemove);
        if (tableView == secondaryHouseTable)
            secondaryHouseData.removeAll(objectToRemove); //TODO Denne kan forenkles LETT!
        if (tableView == travelTable)
            travelInsuranceData.removeAll(objectToRemove);
        if (tableView == damageReportTable)
            damageReportData.removeAll(objectToRemove);
    }

    @FXML
    private void testButton(ActionEvent event) throws IOException {
        //TODO Popup med verdier, fyll dem, trykk på knappen, verdiene sendes inn i metoden her, valideres, også lages hele objektet.
        /*Clients clients = new Clients();
        clients.setDateCreated("1");
        clients.setFirstName("2");
        clients.setLastName("3");
        clients.setAddress("4");
        clients.setInsuranceNumber("5");
        clients.setForsikringer("6");
        clients.setSkademeldinger("7");
        clients.setUbetalt("8");*/
        //data.add(clients);
    }

    @FXML
    private void onEdit(TableColumn.CellEditEvent editEvent){
        getClientTable().getSelectionModel().getSelectedItem();
        Clients Clients = getClientTable().getSelectionModel().getSelectedItem();
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
        setItemsAllTableViews();
    }

    private void setItemsAllTableViews(){
        clientTable.setItems(clientData);
        BoatTable.setItems(boatData);
        primaryHouseTable.setItems(primaryHouseData);
        secondaryHouseTable.setItems(secondaryHouseData);
        travelTable.setItems(travelInsuranceData);
        damageReportTable.setItems(damageReportData);
    }

    @FXML
    private void insert() throws IOException {
        FXMLLoader loader = null;
        Stage stage = new Stage();

        if (chooseTable().equals(clientTable)){
            loader = new FXMLLoader(getClass().getResource("addKunde.fxml"));
            loader.setController(new ClientController(clientData));
            clientTable.setItems(clientData);
            clientTable.setEditable(true);
        }

        if (chooseTable().equals(BoatTable)){
            loader = new FXMLLoader(getClass().getResource("addBoat.fxml"));
            loader.setController(new BoatController(boatData));
            BoatTable.setItems(boatData);
            BoatTable.setEditable(true);
        }

        if (chooseTable().equals(primaryHouseTable)){
            loader = new FXMLLoader(getClass().getResource("addPrimaryHouse.fxml"));
            loader.setController(new PrimaryHouseController(primaryHouseData));
            primaryHouseTable.setItems(primaryHouseData);
            primaryHouseTable.setEditable(true);
        }

        if (chooseTable().equals(secondaryHouseTable)) {
            loader = new FXMLLoader(getClass().getResource("addSecondaryHouse.fxml"));
            loader.setController(new SecondaryHouseController(secondaryHouseData));
            secondaryHouseTable.setItems(secondaryHouseData);
            secondaryHouseTable.setEditable(true);
        }

        if (chooseTable().equals(travelTable)) {
            loader = new FXMLLoader(getClass().getResource("addTraveling.fxml"));
            loader.setController(new TravelingController(travelInsuranceData));
            travelTable.setItems(travelInsuranceData);
            travelTable.setEditable(true);
        }

        if (chooseTable().equals(damageReportTable)) {
            loader = new FXMLLoader(getClass().getResource("addDamageReport.fxml"));
            loader.setController(new DamageReportController(damageReportData));
            damageReportTable.setItems(damageReportData);
            damageReportTable.setEditable(true);
        }

        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.show();
    }

    private void setEditableColumns(){
        setEditableClient();
        setEditableBoat();
        setEditablePrimaryHouse();
        setEditableSecondaryHouse();
        setEditableTravel();
        setEditableDamageReport();
    }


    private void setEditableDamageReport(){
        dateOfDamage.setCellFactory(TextFieldTableCell.forTableColumn());
        damageReportNumber.setCellFactory(TextFieldTableCell.forTableColumn());
        typeOfDamage.setCellFactory(TextFieldTableCell.forTableColumn());
        damageDescription.setCellFactory(TextFieldTableCell.forTableColumn());
        witnessContactInfo.setCellFactory(TextFieldTableCell.forTableColumn());
        assessmentAmount.setCellFactory(TextFieldTableCell.forTableColumn());
        paidCompensation.setCellFactory(TextFieldTableCell.forTableColumn());
    }
    private void setEditableBoat(){
        boatDate.setCellFactory(TextFieldTableCell.forTableColumn());
        boatOwner.setCellFactory(TextFieldTableCell.forTableColumn());
        boatInsurancePrice.setCellFactory(TextFieldTableCell.forTableColumn());
        boatInsuranceAmount.setCellFactory(TextFieldTableCell.forTableColumn());
        boatInsuranceConditions.setCellFactory(TextFieldTableCell.forTableColumn());
        licenseNumber.setCellFactory(TextFieldTableCell.forTableColumn());
        typeModel.setCellFactory(TextFieldTableCell.forTableColumn());
        length.setCellFactory(TextFieldTableCell.forTableColumn());
        yearModel.setCellFactory(TextFieldTableCell.forTableColumn());
        motorType.setCellFactory(TextFieldTableCell.forTableColumn());
        motorStrength.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    private void setEditablePrimaryHouse() {
        primaryHouseAddress.setCellFactory(TextFieldTableCell.forTableColumn());
        primaryHousePremium.setCellFactory(TextFieldTableCell.forTableColumn());
        primaryHouseDate.setCellFactory(TextFieldTableCell.forTableColumn());
        primaryHousePrice.setCellFactory(TextFieldTableCell.forTableColumn());
        primaryHouseConditions.setCellFactory(TextFieldTableCell.forTableColumn());
        primaryHouseConstructionYear.setCellFactory(TextFieldTableCell.forTableColumn());
        primaryHouseResidentialType.setCellFactory(TextFieldTableCell.forTableColumn());
        primaryHouseMaterials.setCellFactory(TextFieldTableCell.forTableColumn());
        primaryHouseStandard.setCellFactory(TextFieldTableCell.forTableColumn());
        primaryHouseSquareMeters.setCellFactory(TextFieldTableCell.forTableColumn());
        primaryHouseInsuredFor.setCellFactory(TextFieldTableCell.forTableColumn());
        primaryHouseContentInsuredFor.setCellFactory(TextFieldTableCell.forTableColumn());
    }



   private void setEditableTravel() {
       travelInsuranceArea.setCellFactory(TextFieldTableCell.forTableColumn());
       travelInsurancePremium.setCellFactory(TextFieldTableCell.forTableColumn());
       travelInsuranceDate.setCellFactory(TextFieldTableCell.forTableColumn());
       travelInsurancePrice.setCellFactory(TextFieldTableCell.forTableColumn());
       travelInsuranceConditions.setCellFactory(TextFieldTableCell.forTableColumn());
       travelInsuranceInsuredFor.setCellFactory(TextFieldTableCell.forTableColumn());
   }


    private void setEditableSecondaryHouse() {
        secondaryHouseAddress.setCellFactory(TextFieldTableCell.forTableColumn());
        secondaryHousePremium.setCellFactory(TextFieldTableCell.forTableColumn());
        secondaryHouseDate.setCellFactory(TextFieldTableCell.forTableColumn());
        secondaryHousePrice.setCellFactory(TextFieldTableCell.forTableColumn());
        secondaryHouseConditions.setCellFactory(TextFieldTableCell.forTableColumn());
        secondaryHouseConstructionYear.setCellFactory(TextFieldTableCell.forTableColumn());
        secondaryHouseResidentialType.setCellFactory(TextFieldTableCell.forTableColumn());
        secondaryHouseMaterials.setCellFactory(TextFieldTableCell.forTableColumn());
        secondaryHouseStandard.setCellFactory(TextFieldTableCell.forTableColumn());
        secondaryHouseSquareMeters.setCellFactory(TextFieldTableCell.forTableColumn());
        secondaryHouseInsuredFor.setCellFactory(TextFieldTableCell.forTableColumn());
        secondaryHouseContentInsuredFor.setCellFactory(TextFieldTableCell.forTableColumn());
    }

    private void setEditableClient(){
        clientDateCreated.setCellFactory(TextFieldTableCell.forTableColumn());
        firstName.setCellFactory(TextFieldTableCell.forTableColumn());
        lastName.setCellFactory(TextFieldTableCell.forTableColumn());
        insuranceNumber.setCellFactory(TextFieldTableCell.forTableColumn());
        address.setCellFactory(TextFieldTableCell.forTableColumn());
        damageReports.setCellFactory(TextFieldTableCell.forTableColumn());
        insurances.setCellFactory(TextFieldTableCell.forTableColumn());
        unpaid.setCellFactory(TextFieldTableCell.forTableColumn());
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
                    else if (clients.getAddress().contains(newValue)) {
                        return true;
                    }

                    else if (clients.getInsuranceNumber().contains(newValue)) {
                        return true;
                    }

                    else if (clients.getInsurances().contains(newValue)) {
                        return true;
                    }

                    else if (clients.getDamageReports().contains(newValue)) {
                        return true;
                    }

                    else if (clients.getUnpaid().contains(newValue)) {
                        return true;
                    }

                    return false;
                })
        );
        System.out.println(filteredClients.size());
        clientTable.setItems(filteredClients);
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

                    else if (boat.getInsurancePremium().contains(newValue)) {
                        return true;
                    }

                    else if (boat.getInsuranceConditions().contains(lowerCaseBoat)) {
                        return true;
                    }

                    else if (boat.getLicenseNumber().contains(newValue)) {
                        return true;
                    }

                    else if (boat.getTypeModel().contains(lowerCaseBoat)) {
                        return true;
                    }

                    else if (boat.getLength().contains(newValue)) {
                        return true;
                    }

                    else if (boat.getYearModel().contains(newValue)) {
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
        FilteredList<DamageReport> filteredDamageRep;
        filteredDamageRep = new FilteredList<>(data, b -> true);
        searchField.textProperty().addListener((observableValue, oldValue, newValue) ->
                filteredDamageRep.setPredicate((DamageReport damageRep) -> {
                    if (newValue == null || newValue.isEmpty()) {
                        return true;
                    }

                    String lowerCaseDamageRep = newValue.toLowerCase();

                    if (damageRep.getDateOfDamage().contains(newValue)) {
                        return true;
                    }

                    else if (damageRep.getReportNumber().contains(newValue)) {
                        return true;
                    }

                    else if (damageRep.getTypeOfDamage().contains(lowerCaseDamageRep)) {
                        return true;
                    }

                    else if (damageRep.getDamageDescription().contains(lowerCaseDamageRep)) {
                        return true;
                    }

                    else if (damageRep.getWitnessContactInfo().contains(lowerCaseDamageRep)) {
                        return true;
                    }

                    else if (damageRep.getAssessmentAmount().contains(newValue)) {
                        return true;
                    }

                    else if (damageRep.getPaidCompensation().contains(newValue)) {
                        return true;
                    }

                    return false;
                })
        );
        damageReportTable.setItems(filteredDamageRep);
    }

    @FXML
    private void tableSearch() {

        if (chooseTable().equals(clientTable) && clientData != null && !clientData.isEmpty()) {
          clientSearch();
        }

        if(chooseTable().equals(damageReportTable)) {
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

    public TableView<Clients> getClientTable() {
        return clientTable;
    }

    public void setClientTable(TableView<Clients> clientTable) {
        this.clientTable = clientTable;
    }

    public TableColumn<Clients, String> getFirstName() {
        return firstName;
    }

    public void setFirstName(TableColumn<Clients, String> firstName) {
        this.firstName = firstName;
    }

    public TableColumn<Clients, String> getLastName() {
        return lastName;
    }

    public void setLastName(TableColumn<Clients, String> lastName) {
        this.lastName = lastName;
    }

    public TextField getTestFelt() {
        return testFelt;
    }

    public void setTestFelt(TextField testFelt) {
        this.testFelt = testFelt;
    }

    public TableColumn<Clients, String> getInsuranceNumber() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(TableColumn<Clients, String> insuranceNumber) {
        this.insuranceNumber = insuranceNumber;
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
