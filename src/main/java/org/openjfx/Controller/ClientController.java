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
    private Label dateLabel, fornavnLabel, lastNameLabel, adressLabel, insuranceNrLabel, insurancesLabel,
                    damageReportLabel, unpaidCompLabel;

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
            checkDate(dateCreated.getText());
            checkString(firstName.getText());
            checkString(lastName.getText());
            checkIntegerAndString(adress.getText());
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
    private void createClient() {
        if (checkAllFields()) {
            clientData.add(new Clients(dateCreated.getText(), firstName.getText(), lastName.getText(), adress.getText(),
                    insuranceNumber.getText(), damageReport.getText(), insurances.getText(), unpaid.getText()));
            Stage stage = (Stage) createClientButton.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    private void checkDateCreated() {
        try {
            checkDate(dateCreated.getText());
        } catch (EmptyTableException e) {
            dateLabel.setText("Ikke riktig datoformat");
            return;
        }
        dateLabel.setText("");
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

    @FXML
    private void checkLastName() {
        try {
            checkString(lastName.getText());
        } catch (EmptyTableException e) {
            lastNameLabel.setText("Kun bokstaver er tilatt");
            return;
        }
        lastNameLabel.setText("");
    }

    @FXML
    private void checkAdress() {
        try {
            checkIntegerAndString(adress.getText());
        } catch (EmptyTableException e) {
            adressLabel.setText("Kun bokstaver og tall er tilatt");
            return;
        }
        adressLabel.setText("");
    }

    @FXML
    private void checkInsuranceNumb() {
        try {
            checkNumber(insuranceNumber.getText());
        } catch (EmptyTableException e) {
            insuranceNrLabel.setText("Kun tall er tilatt");
            return;
        }
        insuranceNrLabel.setText("");
    }

    @FXML
    private void checkInsurances() {
        try {
            checkString(insurances.getText());
        } catch (EmptyTableException e) {
            insurancesLabel.setText("Kun bokstaver er tilatt");
            return;
        }
        insurancesLabel.setText("");
    }

    @FXML
    private void checkDamageReports() {
        try {
            checkString(damageReport.getText());
        } catch (EmptyTableException e) {
            damageReportLabel.setText("Kun bokstaver er tilatt");
            return;
        }
        damageReportLabel.setText("");
    }

    @FXML
    private void checkUnpaidComp() {
        try {
            checkNumber(unpaid.getText());
        } catch (EmptyTableException e) {
            unpaidCompLabel.setText("Kun tall er tilatt");
            return;
        }
        unpaidCompLabel.setText("");
    }


}
