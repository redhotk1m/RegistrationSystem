package org.openjfx.Model.DataClasses;

import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TravelingInsurance extends Insurances implements Serializable {
    private transient SimpleStringProperty  insuranceArea,
                                            sumOfInsurances;

    TravelingInsurance(String insuranceArea, String sumOfInsurance, String insurancePrice,
                       String dateCreated, String insuranceAmount, String insuranceConditions){
        super(insurancePrice,dateCreated,insuranceAmount,insuranceConditions);
        this.insuranceArea = new SimpleStringProperty(insuranceArea);
        this.sumOfInsurances = new SimpleStringProperty(sumOfInsurance);
    }

    TravelingInsurance(){
        initTravelingInsurance();
    }

    private void initTravelingInsurance(){
        insuranceArea = new SimpleStringProperty();
        sumOfInsurances = new SimpleStringProperty();
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.writeUTF(insuranceArea.getValueSafe());
        s.writeUTF(sumOfInsurances.getValueSafe());
    }

    private void readObject(ObjectInputStream s) throws IOException {
        initTravelingInsurance();
        insuranceArea.set(s.readUTF());
        sumOfInsurances.set(s.readUTF());
    }


}
