package org.openjfx.Model.DataClasses;

import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Insurances implements Serializable {

    private transient SimpleStringProperty  insurancePremium,
                                            dateCreated,
                                            insurancePrice,
                                            insuranceConditions;


    public Insurances() {
        initInsuranceProperties();
    }

    public Insurances(String insurancePremium, String dateCreated, String insurancePrice, String insuranceConditions) {
        this.insurancePremium = new SimpleStringProperty(insurancePremium);
        this.dateCreated = new SimpleStringProperty(dateCreated);
        this.insurancePrice = new SimpleStringProperty(insurancePrice);
        this.insuranceConditions = new SimpleStringProperty(insuranceConditions);
    }

    private void writeObject(ObjectOutputStream s) throws IOException{
        s.writeUTF(insurancePremium.getValueSafe());
        s.writeUTF(dateCreated.getValueSafe());
        s.writeUTF(insurancePrice.getValueSafe());
        s.writeUTF(insuranceConditions.getValueSafe());
    }

    private void readObject(ObjectInputStream s) throws IOException{
        initInsuranceProperties();
        insurancePremium.set(s.readUTF());
        dateCreated.set(s.readUTF());
        insurancePrice.set(s.readUTF());
        insuranceConditions.set(s.readUTF());
    }

    public void initInsuranceProperties(){
        this.insurancePremium = new SimpleStringProperty();
        this.dateCreated = new SimpleStringProperty();
        this.insurancePrice = new SimpleStringProperty();
        this.insuranceConditions = new SimpleStringProperty();
    }


    //getters and setters ?

    public String getInsurancePremium() {
        return insurancePrice.get();
    }

    public SimpleStringProperty insurancePremiumProperty() {
        return insurancePrice;
    }

    public void setInsurancePremium(String insurancePremium) {
        this.insurancePrice.set(insurancePremium);
    }

    public String getDateCreated() {
        return dateCreated.get();
    }

    public SimpleStringProperty dateCreatedProperty() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated.set(dateCreated);
    }

    public String getInsurancePrice() {
        return insurancePrice.get();
    }

    public SimpleStringProperty insurancePriceProperty() {
        return insurancePrice;
    }

    public void setInsurancePrice(String insurancePrice) {
        this.insurancePrice.set(insurancePrice);
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
