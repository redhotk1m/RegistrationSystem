package org.openjfx.Controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.openjfx.EmptyTableException;
import org.openjfx.Model.DataClasses.PrimaryHouseInsurance;
import org.openjfx.Model.DataClasses.SecondaryHouseInsurance;
import org.openjfx.Model.checkArguments;

public class SecondaryHouseController {
    private ObservableList secondaryHouseData;

    @FXML
    private Button addSecondaryButton;

    @FXML
    private TextField address, premium, date, price, conditions, constructionYear, residentialType, materials, standard, sqMeters,
            insured, content;

    @FXML
    private Label addressLabel, premiumLabel, dateLabel, priceLabel, conditionLabel, constructionLabel,
            residentialLabel, materialLabel, standardLabel, sqMeterLabel, insuredLabel, contentLabel;

    checkArguments check = new checkArguments();

    public SecondaryHouseController (ObservableList secondaryHouseData) {
        this.secondaryHouseData = secondaryHouseData;
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
        try {

            checkIntegerAndString(address.getText());
            checkNumber(premium.getText());
            checkDate(date.getText());
            checkNumber(price.getText());
            checkString(conditions.getText());
            checkNumber(constructionYear.getText());
            checkString(residentialType.getText());
            checkString(materials.getText());
            checkString(standard.getText());
            checkNumber(sqMeters.getText());
            checkNumber(insured.getText());
            checkNumber(content.getText());

        } catch (EmptyTableException e) {
            e.showErrorGUI("Some fields are wrong");
            return false;
        }
        return true;
    }

    @FXML
    private void addToSecondary() {
        if (checkAllFields()) {
            secondaryHouseData.add(new SecondaryHouseInsurance(address.getText(), premium.getText(), date.getText(),
                    price.getText(), conditions.getText(), constructionYear.getText(),
                    residentialType.getText(), materials.getText(), standard.getText(), sqMeters.getText(),
                    insured.getText(), content.getText()));
            Stage stage = (Stage) addSecondaryButton.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    private void checkAddress() {
        try {
            checkIntegerAndString(address.getText());
        } catch (EmptyTableException e) {
            addressLabel.setText("Kun tall og/eller bokstaver er tilatt");
            return;
        }
        addressLabel.setText("");
    }

    @FXML
    private void checkPremium() {
        try {
            checkNumber(premium.getText());
        } catch (EmptyTableException e) {
            premiumLabel.setText("Kun tall er tilatt");
            return;
        }
        premiumLabel.setText("");
    }

    @FXML
    private void checkDateCreated() {
        try {
            checkDate(date.getText());
        } catch (EmptyTableException e) {
            dateLabel.setText("Ikke riktig datoformat");
            return;
        }
        dateLabel.setText("");
    }

    @FXML
    private void checkPrice() {
        try {
            checkNumber(price.getText());
        } catch (EmptyTableException e) {
            priceLabel.setText("Kun tall er tilatt");
            return;
        }
        priceLabel.setText("");
    }

    @FXML
    private void checkConditions() {
        try {
            checkString(conditions.getText());
        } catch (EmptyTableException e) {
            conditionLabel.setText("Kun bokstaver er tilatt");
            return;
        }
        conditionLabel.setText("");
    }

    @FXML
    private void checkYear() {
        try {
            checkNumber(constructionYear.getText());
        } catch (EmptyTableException e) {
            constructionLabel.setText("Kun tall er tilatt");
            return;
        }
        constructionYear.setText("");
    }

    @FXML
    private void checkResidentialType() {
        try {
            checkString(residentialType.getText());
        } catch (EmptyTableException e) {
            residentialLabel.setText("Kun bokstaver er tilatt");
            return;
        }
        residentialLabel.setText("");
    }

    @FXML
    private void checkMaterials() {
        try {
            checkString(materials.getText());
        } catch (EmptyTableException e) {
            materialLabel.setText("Kun bokstaver er tilatt");
            return;
        }
        materialLabel.setText("");
    }

    @FXML
    private void checkStandard() {
        try {
            checkString(standard.getText());
        } catch (EmptyTableException e) {
            standardLabel.setText("Kun bokstaver er tilatt");
            return;
        }
        standardLabel.setText("");
    }

    @FXML
    private void checkSqMeters() {
        try {
            checkNumber(sqMeters.getText());
        } catch (EmptyTableException e) {
            sqMeterLabel.setText("Kun tall er tilatt");
            return;
        }
        sqMeterLabel.setText("");
    }

    @FXML
    private void checkInsured() {
        try {
            checkNumber(insured.getText());
        } catch (EmptyTableException e) {
            insuredLabel.setText("Kun tall er tilatt");
            return;
        }
        insuredLabel.setText("");
    }

    @FXML
    private void checkContent() {
        try {
            checkNumber(content.getText());
        } catch (EmptyTableException e) {
            contentLabel.setText("Kun tall er tilatt");
            return;
        }
        contentLabel.setText("");
    }
}
