package org.openjfx.Controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.openjfx.EmptyTableException;
import org.openjfx.Model.DataClasses.DamageReport;
import org.openjfx.Model.checkArguments;

public class DamageReportController {
    private ObservableList damageReportData;

    @FXML
    private Button damageReportButton;

    @FXML
    private Label dateLabel, damageNumberLabel, damageTypeLabel, descriptionLabel, contactLabel, assessmentLabel,
                    compensationLabel;

    @FXML
    private TextField date, damageNumber, damageType, description, contact, assessment, compensation;

    checkArguments check = new checkArguments();

    public DamageReportController(ObservableList damageReportData){
        this.damageReportData = damageReportData;
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
            checkDate(date.getText());
            checkNumber(damageNumber.getText());
            checkString(damageType.getText());
            checkString(description.getText());
            checkString(contact.getText());
            checkNumber(assessment.getText());
            checkNumber(compensation.getText());

        } catch (EmptyTableException e) {
            e.showErrorGUI("Some fields are wrong");
            return false;
        }
        return true;
    }

    @FXML
    private void addToDamageReport() {
        if (checkAllFields()) {
            System.out.println(damageReportData.size());
            damageReportData.add(new DamageReport(date.getText(), damageNumber.getText(), damageType.getText(),
                    description.getText(), contact.getText(), assessment.getText(), compensation.getText()));
            Stage stage = (Stage) damageReportButton.getScene().getWindow();
            stage.close();
            System.out.println(damageReportData.size());
            System.out.println(contact.getText());
        }
    }

    @FXML
    private void checkDateOfDamage(){
        try {
            checkDate(date.getText());
        } catch (EmptyTableException e) {
            dateLabel.setText("Ikke riktig datoformat");
            return;
        }
        dateLabel.setText("");
    }

    @FXML
    private void checkDamageNumber(){
        try {
            checkNumber(damageNumber.getText());
        } catch (EmptyTableException e) {
            damageNumberLabel.setText("Kun tall er tilatt");
            return;
        }
        damageNumberLabel.setText("");
    }

    @FXML
    private void checkDamageType() {
        try {
            checkString(damageType.getText());
        } catch (EmptyTableException e) {
            damageTypeLabel.setText("Kun bokstaver er tilatt");
            return;
        }
        damageTypeLabel.setText("");
    }


    @FXML
    private void checkDescription() {
        try {
            checkString(description.getText());
        } catch (EmptyTableException e) {
            descriptionLabel.setText("Kun bokstaver er tilatt");
            return;
        }
        descriptionLabel.setText("");
    }

    @FXML
    private void checkContact() {
        try {
            checkString(contact.getText());
        } catch (EmptyTableException e) {
            contactLabel.setText("Kun bokstaver er tilatt");
            return;
        }
        contactLabel.setText("");
    }

    @FXML
    private void checkAssessment() {
        try {
            checkNumber(assessment.getText());
        } catch (EmptyTableException e) {
            assessmentLabel.setText("Kun tall er tilatt");
            return;
        }
        assessmentLabel.setText("");
    }

    @FXML
    private void checkCompensation() {
        try {
            checkNumber(compensation.getText());
        } catch (EmptyTableException e) {
            compensationLabel.setText("Kun tall er tilatt");
            return;
        }
        compensationLabel.setText("");
    }
}
