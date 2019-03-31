package org.openjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLController {

    @FXML
    private TableView<mdPerson> KunderTable;

    @FXML
    public TableColumn<mdPerson, String> fornavn;

    @FXML
    private TableColumn<mdPerson, String> etternavn;

    @FXML
    public TextField testFelt;

    @FXML
    public TableColumn<mdPerson, Integer> forsikringsNR;




    @FXML
    private void loadFile(ActionEvent event) {
        mCSVReader mCSVReader = new mCSVReader();
        mCSVReader.addFromFile();

        KunderTable.setItems(mCSVReader.getData());
        KunderTable.setEditable(true);

        testFelt.setVisible(true);
        testFelt.setDisable(false);

    }

    private void assignAllColumns(){

        fornavn.setCellValueFactory(
                new PropertyValueFactory<mdPerson, String>("firstName")
        );

        etternavn.setCellValueFactory(
                new PropertyValueFactory<mdPerson, String>("lastName")
        );

        forsikringsNR.setCellValueFactory(
                new PropertyValueFactory<mdPerson, Integer>("forsikringsNR")
        );

    }

    @FXML
    private void saveFile(){
        mCSVWriter mCSVWriter = new mCSVWriter();
        mCSVWriter.saveFile(KunderTable.getItems());
    }

    @FXML
    private void deleteButton(ActionEvent event){
        KunderTable.getSelectionModel().getSelectedItem().setFirstName("tulling");
    }

    @FXML
    private void testButton(ActionEvent event){
        //System.out.println(KunderTable.getSelectionModel().getSelectedItem().getFirstName());
    }



    public void initialize() {
        // TODO
        assignAllColumns();

    }


    //Setter and getter

    public TableView<mdPerson> getKunderTable() {
        return KunderTable;
    }

    public void setKunderTable(TableView<mdPerson> kunderTable) {
        KunderTable = kunderTable;
    }

    public TableColumn<mdPerson, String> getFornavn() {
        return fornavn;
    }

    public void setFornavn(TableColumn<mdPerson, String> fornavn) {
        this.fornavn = fornavn;
    }

    public TableColumn<mdPerson, String> getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(TableColumn<mdPerson, String> etternavn) {
        this.etternavn = etternavn;
    }

    public TextField getTestFelt() {
        return testFelt;
    }

    public void setTestFelt(TextField testFelt) {
        this.testFelt = testFelt;
    }

    public TableColumn<mdPerson, Integer> getForsikringsNR() {
        return forsikringsNR;
    }

    public void setForsikringsNR(TableColumn<mdPerson, Integer> forsikringsNR) {
        this.forsikringsNR = forsikringsNR;
    }
}
