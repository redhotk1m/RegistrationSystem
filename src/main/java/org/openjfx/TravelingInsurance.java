package org.openjfx;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class TravelingInsurance extends Insurances {
    private SimpleStringProperty insuranceArea;
    private SimpleDoubleProperty sumOfInsurance;

    TravelingInsurance(int insurancePrice, Date dateCreated, int insuranceAmount, String insuranceConditions,
                       String insuranceArea, double sumOfInsurance) {
        super(insurancePrice, dateCreated, insuranceAmount, insuranceConditions);
        this.insuranceArea = new SimpleStringProperty(insuranceArea);
        this.sumOfInsurance = new SimpleDoubleProperty(sumOfInsurance);
    }
}
