package org.openjfx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.PortUnreachableException;

public class FXMLController {

    @FXML
    private TableView<Person> KunderTable;

    @FXML
    public TableColumn<Person, String> fornavn;

    @FXML
    private TableColumn<Person, String> etternavn;

    @FXML
    private Label label;

    @FXML
    public TextField testFelt;

    @FXML
    public TableColumn<Person, Integer> forsikringsNR;

    CSVReader CSVReader = new CSVReader();




    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
        CSVReader.metodeTest();

        KunderTable.setItems(CSVReader.getData());
        KunderTable.setEditable(true);

        fornavn.setCellValueFactory(
                new PropertyValueFactory<Person, String>("firstName")
        );

        etternavn.setCellValueFactory(
                new PropertyValueFactory<Person, String>("lastName")
        );

        forsikringsNR.setCellValueFactory(
                new PropertyValueFactory<Person, Integer>("forsikringsNR")
        );


        testFelt.setVisible(true);
        testFelt.setDisable(false);

    }

    @FXML
    private void deleteButton(ActionEvent event){
        KunderTable.getSelectionModel().getSelectedItem().setFirstName("tulling");
    }

    @FXML
    private void testButton(ActionEvent event){
        System.out.println(KunderTable.getSelectionModel().getSelectedItem().getFirstName());
    }



    public void initialize() {
        // TODO


    }
}
