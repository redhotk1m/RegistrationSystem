package org.openjfx;

import javafx.beans.property.SimpleStringProperty;

public class BoatInsurance extends Insurances {
    private SimpleStringProperty Owner;
    private SimpleStringProperty RegNr;
    private SimpleStringProperty TypeModel;
    private SimpleStringProperty length;
    private SimpleStringProperty year;
    private SimpleStringProperty motorType;
    private SimpleStringProperty motorStrength;

    public BoatInsurance() {
        this.Owner = new SimpleStringProperty();
        this.RegNr = new SimpleStringProperty();
        this.TypeModel = new SimpleStringProperty();
        this.length = new SimpleStringProperty();
        this.year = new SimpleStringProperty();
        this.motorType = new SimpleStringProperty();
        this.motorStrength = new SimpleStringProperty();
    }

    BoatInsurance(String insurancePrice, String dateCreated, String insuranceAmount, String insuranceConditions,
                  String Owner, String RegNr, String TypeModel, String length, String year, String motorType,
                  String motorStrength) {
        super(insurancePrice, dateCreated, insuranceAmount, insuranceConditions);
        this.Owner = new SimpleStringProperty(Owner);
        this.RegNr = new SimpleStringProperty(RegNr);
        this.TypeModel = new SimpleStringProperty(TypeModel);
        this.length = new SimpleStringProperty(length);
        this.year = new SimpleStringProperty(year);
        this.motorType = new SimpleStringProperty(motorType);
        this.motorStrength = new SimpleStringProperty(motorStrength);
    }

    public String getOwner() {
        return Owner.get();
    }

    public SimpleStringProperty ownerProperty() {
        return Owner;
    }

    public void setOwner(String owner) {
        this.Owner.set(owner);
    }

    public String getRegNr() {
        return RegNr.get();
    }

    public SimpleStringProperty regNrProperty() {
        return RegNr;
    }

    public void setRegNr(String regNr) {
        this.RegNr.set(regNr);
    }

    public String getTypeModel() {
        return TypeModel.get();
    }

    public SimpleStringProperty typeModelProperty() {
        return TypeModel;
    }

    public void setTypeModel(String typeModel) {
        this.TypeModel.set(typeModel);
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

    public String getYear() {
        return year.get();
    }

    public SimpleStringProperty yearProperty() {
        return year;
    }

    public void setYear (String year) {
        this.year.set(year);
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
