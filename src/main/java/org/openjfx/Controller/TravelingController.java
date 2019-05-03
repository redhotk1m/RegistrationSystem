package org.openjfx.Controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.openjfx.Exceptions.EmptyTableException;
import org.openjfx.Model.DataClasses.TravelInsurance;
import org.openjfx.Model.checkArguments;

public class TravelingController {
    private ObservableList travelingInsuranceData;

    @FXML
    private Button travelingButton;

    @FXML
    private Label areaLabel, premiumLabel, dateLabel, priceLabel, conditionLabel, insuredLabel;

    @FXML
    private TextField area, premium, date, price, conditions, insured;

    checkArguments check = new checkArguments();

    public TravelingController(ObservableList clientData){
        this.travelingInsuranceData = clientData;
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
            checkString(area.getText());
            checkNumber(premium.getText());
            checkDate(date.getText());
            checkNumber(price.getText());
            checkString(conditions.getText());
            checkNumber(insured.getText());
        } catch (EmptyTableException e) {
            e.showErrorGUI("Some fields are wrong");
            return false;
        }
        return true;
    }

    @FXML
    private void addToTraveling() {
        if (checkAllFields()) {
            travelingInsuranceData.add(new TravelInsurance(area.getText(), premium.getText(), date.getText(), price.getText(),
                    conditions.getText(), insured.getText()));
            Stage stage = (Stage) travelingButton.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    private void checkArea(){
        try {
            checkString(area.getText());
        } catch (EmptyTableException e) {
            areaLabel.setText("Kun bokstaver er tilatt");
            return;
        }
        areaLabel.setText("");
    }

    @FXML
    private void checkPremium(){
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
    private void checkInsured() {
        try {
            checkNumber(insured.getText());
        } catch (EmptyTableException e) {
            insuredLabel.setText("Kun tall er tilatt");
            return;
        }
        insuredLabel.setText("");
    }
}
