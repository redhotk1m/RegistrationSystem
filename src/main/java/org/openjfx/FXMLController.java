package org.openjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLController {

    @FXML
    private TableView<mdClients> KunderTable;

    @FXML
    public TableColumn<mdClients, String> fornavn;

    @FXML
    private TableColumn<mdClients, String> etternavn;

    @FXML
    public TextField testFelt;

    @FXML
    public TableColumn<mdClients, Integer> forsikringsNR;




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
                new PropertyValueFactory<mdClients, String>("firstName")
        );

        etternavn.setCellValueFactory(
                new PropertyValueFactory<mdClients, String>("lastName")
        );

        forsikringsNR.setCellValueFactory(
                new PropertyValueFactory<mdClients, Integer>("forsikringsNR")
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

    public TableColumn<mdClients, Integer> getForsikringsNR() {
        return forsikringsNR;
    }

    public void setForsikringsNR(TableColumn<mdClients, Integer> forsikringsNR) {
        this.forsikringsNR = forsikringsNR;
    }
}
