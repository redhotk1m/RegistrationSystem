package org.openjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;

public class FXMLController {

    @FXML
    private TableView<mdClients> KunderTable;

    @FXML
    private TableColumn<mdClients, String> clientDateCreated, fornavn, etternavn, adress, forsikringsNR, skademeldinger,
                                            insurances, unpaid;

    @FXML
    private TextField testFelt;

    @FXML
    private AnchorPane mainFrame;

    @FXML
    private TableView<mdSkademelding> SkadeMldTable;

    @FXML
    private TableColumn<mdSkademelding, String> smDato, skadeNr, skadeType, skadeBeskrivelse, vitneKontaktInfo,
                                                takseringsBeløp, erstatningsBeløp;
    @FXML
    private TableView<BoatInsurance> BoatTable;

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

    @FXML
    private void loadClients (ActionEvent event) throws IOException {
        mCSVReader reader = loadFile();
        KunderTable.setItems(reader.getData());
        KunderTable.setEditable(true);
    }

    @FXML
    private void loadBoat(ActionEvent event) throws IOException {
        mCSVReader reader = loadFile();
        BoatTable.setItems(reader.getData());
        BoatTable.setEditable(true);

        /*fornavn.setCellFactory(TextFieldTableCell.forTableColumn());
        etternavn.setCellFactory(TextFieldTableCell.forTableColumn());
        forsikringsNR.setCellFactory(TextFieldTableCell.forTableColumn());
        */

        testFelt.setVisible(true);
        testFelt.setDisable(false);
    }

    @FXML
    private void loadSkademld(ActionEvent event) throws IOException {
        // TODO få dette til å funke
        mCSVReader reader = loadFile();
        SkadeMldTable.setItems(reader.getData());
        SkadeMldTable.setEditable(true);

    }

    private void loadFile() throws IOException {
        FileHandler reader;
        File file = new FileChooser().showOpenDialog(mainFrame.getScene().getWindow());
        if (file.getName().contains(".csv")){//TODO Bruk annen måte, fordi filen kan hete kim.csv.exe, da skal det ikke funke
            reader = new mCSVReader();
            reader.addFromFile(file);
        }else if (file.getName().contains(".jobj")){
            //TODO Lage jobj reader/writer
        }else {
            //TODO Throw invalid FileType exception
        }
        System.out.println("hei");
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

    /*private void assignHouseholdColumns() {
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


    }*/

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
        mCSVWriter mCSVWriter = new mCSVWriter();
        mCSVWriter.saveFile(KunderTable.getItems());
    }

    @FXML
    private void deleteButton(ActionEvent event){
        KunderTable.getSelectionModel().getSelectedItem();
    }

    @FXML
    private void testButton(ActionEvent event){
        System.out.println("trykker");
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open stuff");
        File file = fileChooser.showOpenDialog(mainFrame.getScene().getWindow());

        if (file != null){
            System.out.println(file.getName());
        }
    }

    @FXML
    private void onEdit(TableColumn.CellEditEvent<mdClients,String> editEvent){
        //mdClients mdClients = getKunderTable().getSelectionModel().getSelectedItem(); KANSKJE ikke helt? Sjekk om alt lagres, og hvor, lagres det i klassen, bare CSV, hva skjer?
        //mdClients.setFirstName(editEvent.getNewValue());
        editEvent.getTableColumn().getText();
    }

    public void initialize() {
        // TODO
        assignAllColumns();
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
}
