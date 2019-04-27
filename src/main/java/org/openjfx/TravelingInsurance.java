package org.openjfx;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class TravelingInsurance extends Insurances {
    private SimpleStringProperty insuranceArea;
    private SimpleStringProperty sumOfInsurance;

    TravelingInsurance(String insurancePrice, String dateCreated, String insuranceAmount, String insuranceConditions,
                       String insuranceArea, String sumOfInsurance) {
        super(insurancePrice, dateCreated, insuranceAmount, insuranceConditions);
        this.insuranceArea = new SimpleStringProperty(insuranceArea);
        this.sumOfInsurance = new SimpleStringProperty(sumOfInsurance);
    }
}
