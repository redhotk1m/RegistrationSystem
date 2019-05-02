package org.openjfx.Controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import org.openjfx.FXMLController;
import org.openjfx.Model.DataClasses.Clients;

public class ClientController {

    private ObservableList clientData;

    ClientController(ObservableList clientData){
        this.clientData = clientData;
    }

    @FXML
    private TextField
            dateCreated,
            firstName,
            lastName,
            adress,
            insuranceNumber,
            insurances,
            damageReport,
            unpaid;

    @FXML
    private void createClient(){
        clientData.add(new Clients(dateCreated.getText(), firstName.getText(), lastName.getText(), adress.getText(), insuranceNumber.getText(), damageReport.getText(), insurances.getText(), unpaid.getText()));
    }
}
