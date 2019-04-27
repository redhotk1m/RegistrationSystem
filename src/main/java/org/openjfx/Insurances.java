package org.openjfx;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class Insurances {
    private SimpleStringProperty insurancePrice;
    private SimpleStringProperty dateCreated;
    private SimpleStringProperty insuranceAmount;
    private SimpleStringProperty insuranceConditions;


    public Insurances() {
        this.insurancePrice = new SimpleStringProperty();
        this.dateCreated = new SimpleStringProperty();
        this.insuranceAmount = new SimpleStringProperty();
        this.insuranceConditions = new SimpleStringProperty();
    }


    Insurances(String insurancePrice, String dateCreated, String insuranceAmount, String insuranceConditions) {
        this.insurancePrice = new SimpleStringProperty(insurancePrice);
        this.dateCreated = new SimpleStringProperty(dateCreated);
        this.insuranceAmount = new SimpleStringProperty(insuranceAmount);
        this.insuranceConditions = new SimpleStringProperty(insuranceConditions);
    }

    //getters and setters ?


    public String getInsurancePrice() {
        return insurancePrice.get();
    }

    public SimpleStringProperty insurancePriceProperty() {
        return insurancePrice;
    }

    public void setInsurancePrice(String insurancePrice) {
        this.insurancePrice.set(insurancePrice);
    }

    public String getDateCreated() {
        return dateCreated.get();
    }

    public void setDateCreated (String dateCreated) {
        this.dateCreated.set(dateCreated);
    }

    public String getInsuranceAmount() {
        return insuranceAmount.get();
    }

    public SimpleStringProperty insuranceAmountProperty() {
        return insuranceAmount;
    }

    public void setInsuranceAmount(String insuranceAmount) {
        this.insuranceAmount.set(insuranceAmount);
    }

    public String getInsuranceConditions() {
        return insuranceConditions.get();
    }

    public SimpleStringProperty insuranceConditionsProperty() {
        return insuranceConditions;
    }

    public void setInsuranceConditions(String insuranceConditions) {
        this.insuranceConditions.set(insuranceConditions);
    }
}
