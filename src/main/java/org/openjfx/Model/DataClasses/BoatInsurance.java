package org.openjfx.Model.DataClasses;

import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class BoatInsurance extends Insurances implements Serializable {
    private transient SimpleStringProperty  Owner,
                                            RegNr,
                                            TypeModel,
                                            length,
                                            year,
                                            motorType,
                                            motorStrength;

    public BoatInsurance(){
        initProperties();
    }

    public void initProperties(){
        this.Owner = new SimpleStringProperty();
        this.RegNr = new SimpleStringProperty();
        this.TypeModel = new SimpleStringProperty();
        this.length = new SimpleStringProperty();
        this.year = new SimpleStringProperty();
        this.motorType = new SimpleStringProperty();
        this.motorStrength = new SimpleStringProperty();
    }

    private void writeObject(ObjectOutputStream s) throws IOException{
        s.writeUTF(Owner.getValueSafe());
        s.writeUTF(RegNr.getValueSafe());
        s.writeUTF(TypeModel.getValueSafe());
        s.writeUTF(length.getValueSafe());
        s.writeUTF(year.getValueSafe());
        s.writeUTF(motorType.getValueSafe());
        s.writeUTF(motorStrength.getValueSafe());
    }

    private void readObject(ObjectInputStream s) throws IOException{
        initProperties();
        Owner.set(s.readUTF());
        RegNr.set(s.readUTF());
        TypeModel.set(s.readUTF());
        length.set(s.readUTF());
        year.set(s.readUTF());
        motorType.set(s.readUTF());
        motorStrength.set(s.readUTF());
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

    public void setYear(String year) {
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
