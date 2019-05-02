package org.openjfx.Controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.openjfx.EmptyTableException;
import org.openjfx.Model.DataClasses.Clients;
import org.openjfx.Model.checkArguments;

public class ClientController {

    private ObservableList clientData;

    @FXML
    private Button createClientButton;

    @FXML
    private Label fornavnLabel;

    checkArguments a = new checkArguments();

    public ClientController(ObservableList clientData){
        this.clientData = clientData;
    }

    private void checkString(String string) throws EmptyTableException{
        a.stringTest(string);
    }

    private void checkDate(String string) throws EmptyTableException{
        a.dateTest(string);
    }

    private void checkAdress(String string) throws EmptyTableException{
        a.streetTest(string);
    }

    private void checkNumber(String string) throws EmptyTableException{
        a.numberTest(string);
    }

    @FXML
    private boolean checkAllFields(){
        try {
            checkDate(dateCreated.getText());
            checkString(firstName.getText());
            checkString(lastName.getText());
            checkAdress(adress.getText());
            checkNumber(insuranceNumber.getText());
            checkString(damageReport.getText());
            checkString(insurances.getText());
            checkNumber(unpaid.getText());
        } catch (EmptyTableException e) {
            e.showErrorGUI("Some fields are wrong");
            return false;
        }
        return true;
    }

    @FXML
    TextField
            dateCreated,
            firstName,
            lastName,
            adress,
            insuranceNumber,
            insurances,
            damageReport,
            unpaid;

    @FXML
    private void createClient() {
        if (checkAllFields()) {
            clientData.add(new Clients(dateCreated.getText(), firstName.getText(), lastName.getText(), adress.getText(), insuranceNumber.getText(), damageReport.getText(), insurances.getText(), unpaid.getText()));
            Stage stage = (Stage) createClientButton.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    private void checkFirstName(){
        try {
            checkString(firstName.getText());
        } catch (EmptyTableException e) {
            fornavnLabel.setText("Kun bokstaver er tilatt");
            return;
        }
        fornavnLabel.setText("");
    }




}
