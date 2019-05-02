package org.openjfx.Model.DataClasses;

import javafx.beans.property.SimpleStringProperty;

import java.io.*;

public class Clients implements Serializable {
    transient private SimpleStringProperty  dateCreated,
                                            firstName,
                                            lastName,
                                            address,
                                            insuranceNumber,
                                            damageReports,
                                            insurances,
                                            unpaid;


    public Clients() {
        initProperties();
    }

    public Clients(String dateCreated, String firstName, String lastName, String insuranceNumber, String address, String damageReports, String insurances, String unpaid){
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.insuranceNumber = new SimpleStringProperty(insuranceNumber);
        this.dateCreated = new SimpleStringProperty(dateCreated);
        this.address = new SimpleStringProperty(address);
        this.damageReports = new SimpleStringProperty(damageReports);
        this.insurances = new SimpleStringProperty(insurances);
        this.unpaid = new SimpleStringProperty(unpaid);
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeUTF(dateCreated.getValueSafe());
        s.writeUTF(firstName.getValueSafe());
        s.writeUTF(lastName.getValueSafe());
        s.writeUTF(address.getValueSafe());
        s.writeUTF(insuranceNumber.getValueSafe());
        s.writeUTF(damageReports.getValueSafe());
        s.writeUTF(insurances.getValueSafe());
        s.writeUTF(unpaid.getValueSafe());
    }

    private void readObject(ObjectInputStream s) throws IOException{
        initProperties();
        dateCreated.set(s.readUTF());
        firstName.set(s.readUTF());
        lastName.set(s.readUTF());
        address.set(s.readUTF());
        insuranceNumber.set(s.readUTF());
        damageReports.set(s.readUTF());
        insurances.set(s.readUTF());
        unpaid.set(s.readUTF());
    }

    private void initProperties(){
        this.dateCreated = new SimpleStringProperty();
        this.firstName = new SimpleStringProperty();
        this.lastName = new SimpleStringProperty();
        this.address = new SimpleStringProperty();
        this.insuranceNumber = new SimpleStringProperty();
        this.damageReports = new SimpleStringProperty();
        this.insurances = new SimpleStringProperty();
        this.unpaid = new SimpleStringProperty();
    }


    //Getters and setters

    public String getDateCreated() {
        return dateCreated.get();
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated.set(dateCreated);
    }

    public String getInsuranceNumber() {
        return insuranceNumber.get();
    }

    public SimpleStringProperty insuranceNumberProperty() {
        return insuranceNumber;
    }

    public void setInsuranceNumber(String insuranceNumber) {
        this.insuranceNumber.set(insuranceNumber);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public SimpleStringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getDamageReports() {
        return damageReports.get();
    }

    public void setDamageReports(String damageReports) {
        this.damageReports.set(damageReports);
    }

    public String getInsurances() {
        return insurances.get();
    }

    public void setInsurances(String insurances) {
        this.insurances.set(insurances);
    }

    public String getUnpaid() {
        return unpaid.get();
    }

    public void setUnpaid(String unpaid) {
        this.unpaid.set(unpaid);
    }
}
