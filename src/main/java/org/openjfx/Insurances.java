package org.openjfx;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class Insurances {
    private SimpleIntegerProperty insurancePrice;
    private Date dateCreated;
    private SimpleIntegerProperty insuranceAmount;
    private SimpleStringProperty insuranceConditions;

    Insurances(int insurancePrice, Date dateCreated, int insuranceAmount, String insuranceConditions) {
        this.insurancePrice = new SimpleIntegerProperty(insurancePrice);
        this.dateCreated = dateCreated;
        this.insuranceAmount = new SimpleIntegerProperty(insuranceAmount);
        this.insuranceConditions = new SimpleStringProperty(insuranceConditions);
    }

    //getters and setters ?


    public int getInsurancePrice() {
        return insurancePrice.get();
    }

    public SimpleIntegerProperty insurancePriceProperty() {
        return insurancePrice;
    }

    public void setInsurancePrice(int insurancePrice) {
        this.insurancePrice.set(insurancePrice);
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getInsuranceAmount() {
        return insuranceAmount.get();
    }

    public SimpleIntegerProperty insuranceAmountProperty() {
        return insuranceAmount;
    }

    public void setInsuranceAmount(int insuranceAmount) {
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
