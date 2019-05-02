package org.openjfx.Model.DataClasses;

import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class BoatInsurance extends Insurances implements Serializable {
    private transient SimpleStringProperty  owner,
                                            licenseNumber,
                                            typeModel,
                                            length,
                                            yearModel,
                                            motorType,
                                            motorStrength;

    public BoatInsurance(){
        initProperties();
    }

    public BoatInsurance (String dateCreated, String insurancePremium, String insurancePrice, String insuranceConditions,
                          String owner, String licenseNumber, String typeModel, String length, String yearModel, String motorType,
                          String motorStrength) {
        super(dateCreated, insurancePremium, insurancePrice, insuranceConditions);
        this.owner = new SimpleStringProperty(owner);
        this.licenseNumber = new SimpleStringProperty(licenseNumber);
        this.typeModel = new SimpleStringProperty(typeModel);
        this.length = new SimpleStringProperty(length);
        this.yearModel = new SimpleStringProperty(yearModel);
        this.motorType = new SimpleStringProperty(motorType);
        this.motorStrength = new SimpleStringProperty(motorStrength);
    }

    public void initProperties(){
        this.owner = new SimpleStringProperty();
        this.licenseNumber = new SimpleStringProperty();
        this.typeModel = new SimpleStringProperty();
        this.length = new SimpleStringProperty();
        this.yearModel = new SimpleStringProperty();
        this.motorType = new SimpleStringProperty();
        this.motorStrength = new SimpleStringProperty();
    }

    private void writeObject(ObjectOutputStream s) throws IOException{
        s.writeUTF(owner.getValueSafe());
        s.writeUTF(licenseNumber.getValueSafe());
        s.writeUTF(typeModel.getValueSafe());
        s.writeUTF(length.getValueSafe());
        s.writeUTF(yearModel.getValueSafe());
        s.writeUTF(motorType.getValueSafe());
        s.writeUTF(motorStrength.getValueSafe());
    }

    private void readObject(ObjectInputStream s) throws IOException{
        initProperties();
        owner.set(s.readUTF());
        licenseNumber.set(s.readUTF());
        typeModel.set(s.readUTF());
        length.set(s.readUTF());
        yearModel.set(s.readUTF());
        motorType.set(s.readUTF());
        motorStrength.set(s.readUTF());
    }


    public String getOwner() {
        return owner.get();
    }

    public SimpleStringProperty ownerProperty() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner.set(owner);
    }

    public String getLicenseNumber() {
        return licenseNumber.get();
    }

    public SimpleStringProperty licenseNumberProperty() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber.set(licenseNumber);
    }

    public String getTypeModel() {
        return typeModel.get();
    }

    public SimpleStringProperty typeModelProperty() {
        return typeModel;
    }

    public void setTypeModel(String typeModel) {
        this.typeModel.set(typeModel);
    }

    public String getLength() {
        return length.get();
    }

    public SimpleStringProperty lengthProperty() {
        return length;
    }

    public void setLength(String length) {
        this.length.set(length);
    }

    public String getYearModel() {
        return yearModel.get();
    }

    public SimpleStringProperty yearModelProperty() {
        return yearModel;
    }

    public void setYearModel(String yearModel) {
        this.yearModel.set(yearModel);
    }

    public String getMotorType() {
        return motorType.get();
    }

    public SimpleStringProperty motorTypeProperty() {
        return motorType;
    }

    public void setMotorType(String motorType) {
        this.motorType.set(motorType);
    }

    public String getMotorStrength() {
        return motorStrength.get();
    }

    public SimpleStringProperty motorStrengthProperty() {
        return motorStrength;
    }

    public void setMotorStrength(String motorStrength) {
        this.motorStrength.set(motorStrength);
    }
}
