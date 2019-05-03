package org.openjfx.Controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.openjfx.Exceptions.EmptyTableException;
import org.openjfx.Model.DataClasses.Clients;
import org.openjfx.Model.checkArguments;

public class ClientController {

    private ObservableList clientData;

    @FXML
    private Button createClientButton;

    @FXML
    private Label dateLabel, firstNameLabel, lastNameLabel, addressLabel, insuranceNrLabel, insurancesLabel,
                    damageReportLabel, unpaidCompLabel;

    @FXML
    private TextField dateCreated, firstName, lastName, address, insuranceNumber, insurances, damageReport, unpaid;

    checkArguments check = new checkArguments();

    public ClientController(ObservableList clientData){
        this.clientData = clientData;
    }

    private void checkString(String string) throws EmptyTableException{
        check.stringTest(string);
    }

    private void checkDate(String string) throws EmptyTableException{
        check.dateTest(string);
    }

    private void checkIntegerAndString(String string) throws EmptyTableException{
        check.streetTest(string);
    }

    private void checkNumber(String string) throws EmptyTableException{
        check.numberTest(string);
    }

    @FXML
    private boolean checkAllFields(){
        try {
            //Sjekker at alle feltene er riktige, før objektet kan lages
            checkDate(dateCreated.getText());
            checkString(firstName.getText());
            checkString(lastName.getText());
            checkIntegerAndString(address.getText());
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
    private void createClient() {
        if (checkAllFields()) {
            clientData.add(new Clients(dateCreated.getText(), firstName.getText(), lastName.getText(),
                    address.getText(), insuranceNumber.getText(), damageReport.getText(), insurances.getText(),
                    unpaid.getText()));
            Stage stage = (Stage) createClientButton.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    private void checkDateCreated() {
        try {
            checkDate(dateCreated.getText());
        } catch (EmptyTableException e) {
            dateLabel.setText("You need to use the right date format");
            return;
        }
        dateLabel.setText("");
    }

    @FXML
    private void checkFirstName(){
        try {
            checkString(firstName.getText());
        } catch (EmptyTableException e) {
            firstNameLabel.setText("Only letters are allowed");
            return;
        }
        firstNameLabel.setText("");
    }

    @FXML
    private void checkLastName() {
        try {
            checkString(lastName.getText());
        } catch (EmptyTableException e) {
            lastNameLabel.setText("Only letters are allowed");
            return;
        }
        lastNameLabel.setText("");
    }

    @FXML
    private void checkAddress() {
        try {
            checkIntegerAndString(address.getText());
        } catch (EmptyTableException e) {
            addressLabel.setText("Only letters and/or numbers are allowed");
            return;
        }
        addressLabel.setText("");
    }

    @FXML
    private void checkInsuranceNumb() {
        try {
            checkNumber(insuranceNumber.getText());
        } catch (EmptyTableException e) {
            insuranceNrLabel.setText("Only numbers are allowed");
            return;
        }
        insuranceNrLabel.setText("");
    }

    @FXML
    private void checkInsurances() {
        try {
            checkString(insurances.getText());
        } catch (EmptyTableException e) {
            insurancesLabel.setText("Only letters are allowed");
            return;
        }
        insurancesLabel.setText("");
    }

    @FXML
    private void checkDamageReports() {
        try {
            checkString(damageReport.getText());
        } catch (EmptyTableException e) {
            damageReportLabel.setText("Only letters are allowed");
            return;
        }
        damageReportLabel.setText("");
    }

    @FXML
    private void checkUnpaidComp() {
        try {
            checkNumber(unpaid.getText());
        } catch (EmptyTableException e) {
            unpaidCompLabel.setText("Only numbers are allowed");
            return;
        }
        unpaidCompLabel.setText("");
    }


}
