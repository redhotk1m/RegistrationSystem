package org.openjfx;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

public class FXMLController {

    @FXML
    private TableView<Person> KunderTable;

    @FXML
    public TableColumn<Person, String> fornavn;

    @FXML
    private TableColumn<Person, SimpleStringProperty> etternavn;

    @FXML
    private Label label;



    private ObservableList<Person> data = FXCollections.observableArrayList(
            new Person("Kim Roger Moi", "Thorsen"),
            new Person("Even Vik", "Olsen"), new Person("Thea Aksnes", "Janvin"),
            new Person("Athisayan", "Suresh"),new Person("Jasothran", "Husker Ikke")
    );

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }



    public void initialize() {
        // TODO

        KunderTable.setItems(data);
        KunderTable.setEditable(true);

        fornavn.setCellValueFactory(
                new PropertyValueFactory<Person, String>("firstName")
        );

    }
}
