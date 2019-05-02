package org.openjfx.Model.DataClasses;

import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Insurances implements Serializable {

    private transient SimpleStringProperty insurancePrice;
    private transient SimpleStringProperty dateCreated;
    private transient SimpleStringProperty insuranceAmount;
    private transient SimpleStringProperty insuranceConditions;


    public Insurances() {
        initInsuranceProperties();
    }

    private void writeObject(ObjectOutputStream s) throws IOException{
        s.writeUTF(insurancePrice.getValueSafe());
        s.writeUTF(dateCreated.getValueSafe());
        s.writeUTF(insuranceAmount.getValueSafe());
        s.writeUTF(insuranceConditions.getValueSafe());
    }

    private void readObject(ObjectInputStream s) throws IOException{
        initInsuranceProperties();
        insurancePrice.set(s.readUTF());
        dateCreated.set(s.readUTF());
        insuranceAmount.set(s.readUTF());
        insuranceConditions.set(s.readUTF());
    }

    public void initInsuranceProperties(){
        this.insurancePrice = new SimpleStringProperty();
        this.dateCreated = new SimpleStringProperty();
        this.insuranceAmount = new SimpleStringProperty();
        this.insuranceConditions = new SimpleStringProperty();
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

    public SimpleStringProperty dateCreatedProperty() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
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
