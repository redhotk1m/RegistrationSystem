package org.openjfx.Controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.openjfx.Exceptions.EmptyTableException;
import org.openjfx.Model.DataClasses.BoatInsurance;
import org.openjfx.Model.DataClasses.Clients;
import org.openjfx.Model.checkArguments;

public class BoatController {

    private ObservableList boatData;

    @FXML
    private Button createBoatButton;

    @FXML
    private TextField dateCreated, owner, insurancePremium, insurancePrice, insuranceConditions, licencePlate, typeModel,
                        feetLength, yearModel, motorType, motorStrength;

    @FXML
    private Label dateLabel, ownerLabel, insurancePremiumLabel, insurancePriceLabel, insuranceCondLabel, licenceNrLabel,
                    typeModelLabel, lengthLabel, yearLabel, motorTypeLabel, motorStrengthLabel;

    checkArguments check = new checkArguments();

    public BoatController(ObservableList boatData){
        this.boatData = boatData;
    }

    private void checkString(String string) throws EmptyTableException {
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
        //Sjekker at alle feltene er riktige, før objektet kan lages
        try {
            checkNumber(insurancePremium.getText());
            checkDate(dateCreated.getText());
            checkNumber(insurancePrice.getText());
            checkString(insuranceConditions.getText());
            checkString(owner.getText());
            checkIntegerAndString(licencePlate.getText());
            checkIntegerAndString(typeModel.getText());
            checkNumber(feetLength.getText());
            checkNumber(yearModel.getText());
            checkString(motorType.getText());
            checkNumber(motorStrength.getText());
        } catch (EmptyTableException e) {
            e.showErrorGUI("Some fields are wrong");
            return false;
        }
        return true;
    }

    @FXML

    private void createBoat() {
        if (checkAllFields()) {
            boatData.add(new BoatInsurance(insurancePremium.getText(), dateCreated.getText(),
                    insurancePrice.getText(), insuranceConditions.getText(),  owner.getText(), licencePlate.getText(),
                    typeModel.getText(), feetLength.getText(), yearModel.getText(), motorType.getText(),
                    motorStrength.getText()));
            Stage stage = (Stage) createBoatButton.getScene().getWindow();
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
    private void checkOwner() {
        try {
            checkString(owner.getText());
        } catch (EmptyTableException e) {
            ownerLabel.setText("Kun bokstaver er tilatt");
            return;
        }
        ownerLabel.setText("");
    }

    @FXML
    private void checkInsurancePremium() {
        try {
            checkNumber(insurancePremium.getText());
        } catch (EmptyTableException e) {
            insurancePremiumLabel.setText("Kun tall er tilatt");
            return;
        }
        insurancePremiumLabel.setText("");
    }

    @FXML
    private void checkInsurancePrice() {
        try {
            checkNumber(insurancePrice.getText());
        } catch (EmptyTableException e) {
            insurancePriceLabel.setText("Kun tall er tilatt");
            return;
        }
        insurancePriceLabel.setText("");
    }

    @FXML
    private void checkInsuranceConditions() {
        try {
            checkString(insuranceConditions.getText());
        } catch (EmptyTableException e) {
            insuranceCondLabel.setText("Kun bokstaver er tilatt");
            return;
        }
        insuranceCondLabel.setText("");
    }

    @FXML
    private void checkLicenceNumber() {
        try {
            checkIntegerAndString(licencePlate.getText());
        } catch (EmptyTableException e) {
            licenceNrLabel.setText("Kun bokstaver og/eller tall er tilatt");
            return;
        }
        licenceNrLabel.setText("");
    }

    @FXML
    private void checkTypeModel() {
        try {
            checkIntegerAndString(typeModel.getText());
        } catch (EmptyTableException e) {
            typeModelLabel.setText("Kun bokstaver og/eller tall er tilatt");
            return;
        }
        typeModelLabel.setText("");
    }

    @FXML
    private void checkLength() {
        try {
            checkNumber(feetLength.getText());
        } catch (EmptyTableException e) {
            lengthLabel.setText("Kun tall er tilatt");
            return;
        }
        lengthLabel.setText("");
    }

    @FXML
    private void checkYear() {
        try {
            checkNumber(yearModel.getText());
        } catch (EmptyTableException e) {
            yearLabel.setText("Kun tall er tilatt");
            return;
        }
        yearLabel.setText("");
    }

    @FXML
    private void checkMotorType() {
        try {
            checkString(motorType.getText());
        } catch (EmptyTableException e) {
            motorTypeLabel.setText("Kun bokstaver er tilatt");
            return;
        }
        motorTypeLabel.setText("");
    }

    @FXML
    private void checkMotorStrength() {
        try {
            checkNumber(motorStrength.getText());
        } catch (EmptyTableException e) {
            motorStrengthLabel.setText("Kun tall er tilatt");
            return;
        }
        motorStrengthLabel.setText("");
    }

}
