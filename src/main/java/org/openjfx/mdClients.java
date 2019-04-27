package org.openjfx;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class mdClients implements Serializable {
    private SimpleStringProperty dateCreated;
    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;
    private SimpleStringProperty adress;
    private SimpleStringProperty forsikringsNR;
    private SimpleStringProperty skademeldinger;
    private SimpleStringProperty forsikringer;
    private SimpleStringProperty ubetalt;

    public mdClients() {
        this.dateCreated = new SimpleStringProperty();
        this.firstName = new SimpleStringProperty();
        this.lastName = new SimpleStringProperty();
        this.adress = new SimpleStringProperty();
        this.forsikringsNR = new SimpleStringProperty();
        this.skademeldinger = new SimpleStringProperty();
        this.forsikringer = new SimpleStringProperty();
        this.ubetalt = new SimpleStringProperty();

    }

    mdClients(String firstName, String lastName, String forsikringsNR){
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.forsikringsNR = new SimpleStringProperty(forsikringsNR);
    }


    //Getters and setters

    public String getDateCreated() {
        return dateCreated.get();
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated.set(dateCreated);
    }

    public String getForsikringsNR() {
        return forsikringsNR.get();
    }

    public SimpleStringProperty forsikringsNRProperty() {
        return forsikringsNR;
    }

    public void setForsikringsNR(String forsikringsNR) {
        this.forsikringsNR.set(forsikringsNR);
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

    public String getAdress() {
        return adress.get();
    }

    public void setAdress(String adress) {
        this.adress.set(adress);
    }

    public String getSkademeldinger() {
        return skademeldinger.get();
    }

    public void setSkademeldinger(String skademeldinger) {
        this.skademeldinger.set(skademeldinger);
    }

    public String getForsikringer() {
        return forsikringer.get();
    }

    public void setForsikringer(String forsikringer) {
        this.forsikringer.set(forsikringer);
    }

    public String getUbetalt() {
        return ubetalt.get();
    }

    public void setUbetalt(String ubetalt) {
        this.ubetalt.set(ubetalt);
    }
}
