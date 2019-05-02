package org.openjfx.Controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.openjfx.EmptyTableException;
import org.openjfx.Model.DataClasses.PrimaryHouseInsurance;
import org.openjfx.Model.checkArguments;

public class PrimaryHouseController {

    private ObservableList primaryHouseData;

    @FXML
    private Button addPrimaryButton;

    @FXML
    private TextField address, premium, date, price, conditions, year, residentialType, materials, standard, sqMeters,
                        insured, content;

    @FXML
    private Label addressLabel, premiumLabel, dateLabel, priceLabel, conditionLabel, constructionLabel,
                    residentialLabel, materialLabel, standardLabel, sqMeterLabel, insuredLabel, contentLabel;

    checkArguments check = new checkArguments();

    public PrimaryHouseController (ObservableList primaryHouseData) {
        this.primaryHouseData = primaryHouseData;
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
            checkNumber(year.getText());
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
    private void createPrimary() {
        if (checkAllFields()) {
            primaryHouseData.add(new PrimaryHouseInsurance(address.getText(), premium.getText(), date.getText(),
                    price.getText(), conditions.getText(), year.getText(),
                    residentialType.getText(), materials.getText(), standard.getText(), sqMeters.getText(),
                    insured.getText(), content.getText()));
            Stage stage = (Stage) addPrimaryButton.getScene().getWindow();
            stage.close();
        }
    }


}
