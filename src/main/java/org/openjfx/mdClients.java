package org.openjfx;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class mdClients implements Serializable {
    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;
    private SimpleIntegerProperty forsikringsNR;
    //private SimpleStringProperty address;



    mdClients(String firstName, String lastName, int forsikringsNR){
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.forsikringsNR = new SimpleIntegerProperty(forsikringsNR);
    }


    //Getters and setters


    public int getForsikringsNR() {
        return forsikringsNR.get();
    }

    public SimpleIntegerProperty forsikringsNRProperty() {
        return forsikringsNR;
    }

    public void setForsikringsNR(int forsikringsNR) {
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
}
