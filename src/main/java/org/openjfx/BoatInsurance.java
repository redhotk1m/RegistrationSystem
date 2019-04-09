package org.openjfx;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class BoatInsurance extends Insurances {
    private SimpleStringProperty Owner;
    private SimpleStringProperty RegNr;
    private SimpleStringProperty TypeModel;
    private SimpleDoubleProperty length;
    private SimpleIntegerProperty year;
    private SimpleStringProperty motorType;
    private SimpleDoubleProperty motorStrength;

    BoatInsurance(int insurancePrice, Date dateCreated, int insuranceAmount, String insuranceConditions, String Owner,
                  String RegNr, String TypeModel, double length, int year, String motorType, double motorStrength) {
        super(insurancePrice, dateCreated, insuranceAmount, insuranceConditions);
        this.Owner = new SimpleStringProperty(Owner);
        this.RegNr = new SimpleStringProperty(RegNr);
        this.TypeModel = new SimpleStringProperty(TypeModel);
        this.length = new SimpleDoubleProperty(length);
        this.year = new SimpleIntegerProperty(year);
        this.motorType = new SimpleStringProperty(motorType);
        this.motorStrength = new SimpleDoubleProperty(motorStrength);
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

    public double getLength() {
        return length.get();
    }

    public SimpleDoubleProperty lengthProperty() {
        return length;
    }

    public void setLength(double length) {
        this.length.set(length);
    }

    public int getYear() {
        return year.get();
    }

    public SimpleIntegerProperty yearProperty() {
        return year;
    }

    public void setYear(int year) {
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

    public double getMotorStrength() {
        return motorStrength.get();
    }

    public SimpleDoubleProperty motorStrengthProperty() {
        return motorStrength;
    }

    public void setMotorStrength(double motorStrength) {
        this.motorStrength.set(motorStrength);
    }
}
