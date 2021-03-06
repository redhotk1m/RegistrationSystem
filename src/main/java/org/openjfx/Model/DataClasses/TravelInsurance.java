package org.openjfx.Model.DataClasses;

import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TravelInsurance extends Insurances implements Serializable {
    private transient SimpleStringProperty  insuranceArea,
                                            insuredFor;

    public TravelInsurance(String insurancePrice, String dateCreated, String insuranceAmount,
                           String insuranceConditions, String insuranceArea, String insuredFor){
        super(insurancePrice, dateCreated, insuranceAmount, insuranceConditions);
        this.insuranceArea = new SimpleStringProperty(insuranceArea);
        this.insuredFor = new SimpleStringProperty(insuredFor);
    }

    public TravelInsurance(){
        initTravelingInsurance();
    }

    private void initTravelingInsurance(){
        insuranceArea = new SimpleStringProperty();
        insuredFor = new SimpleStringProperty();
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        //Skriver objektet til .jobj (til stream)
        s.writeUTF(insuranceArea.getValueSafe());
        s.writeUTF(insuredFor.getValueSafe());
    }

    private void readObject(ObjectInputStream s) throws IOException {
        //Leser inn objektet fra stream (.jobj)
        initTravelingInsurance();//Brukes fordi konstruktøren ikke blir kalt
        insuranceArea.set(s.readUTF());
        insuredFor.set(s.readUTF());
    }

    public String getInsuranceArea() {
        return insuranceArea.get();
    }

    public SimpleStringProperty insuranceAreaProperty() {
        return insuranceArea;
    }

    public void setInsuranceArea(String insuranceArea) {
        this.insuranceArea.set(insuranceArea);
    }

    public String getInsuredFor() {
        return insuredFor.get();
    }

    public SimpleStringProperty insuredForProperty() {
        return insuredFor;
    }

    public void setInsuredFor(String insuredFor) {
        this.insuredFor.set(insuredFor);
    }
}
