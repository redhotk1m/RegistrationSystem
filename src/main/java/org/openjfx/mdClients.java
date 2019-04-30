package org.openjfx;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.*;

public class mdClients implements Serializable {
    transient private SimpleStringProperty dateCreated;
    transient private SimpleStringProperty firstName;
    transient private SimpleStringProperty lastName;
    transient private SimpleStringProperty adress;
    transient private SimpleStringProperty forsikringsNR;
    transient private SimpleStringProperty skademeldinger;
    transient private SimpleStringProperty forsikringer;
    transient private SimpleStringProperty ubetalt;

    public mdClients() {
        initProperties();
    }

    mdClients(String firstName, String lastName, String forsikringsNR){
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.forsikringsNR = new SimpleStringProperty(forsikringsNR);
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.defaultWriteObject();
        s.writeUTF(dateCreated.getValueSafe());
        s.writeUTF(firstName.getValueSafe());
        s.writeUTF(lastName.getValueSafe());
        s.writeUTF(adress.getValueSafe());
        s.writeUTF(forsikringsNR.getValueSafe());
        s.writeUTF(skademeldinger.getValueSafe());
        s.writeUTF(forsikringer.getValueSafe());
        s.writeUTF(ubetalt.getValueSafe());
    }

    private void readObject(ObjectInputStream s) throws IOException{
        initProperties();
        dateCreated.set(s.readUTF());
        firstName.set(s.readUTF());
        lastName.set(s.readUTF());
        adress.set(s.readUTF());
        forsikringsNR.set(s.readUTF());
        skademeldinger.set(s.readUTF());
        forsikringer.set(s.readUTF());
        ubetalt.set(s.readUTF());
    }

    private void initProperties(){
        this.dateCreated = new SimpleStringProperty();
        this.firstName = new SimpleStringProperty();
        this.lastName = new SimpleStringProperty();
        this.adress = new SimpleStringProperty();
        this.forsikringsNR = new SimpleStringProperty();
        this.skademeldinger = new SimpleStringProperty();
        this.forsikringer = new SimpleStringProperty();
        this.ubetalt = new SimpleStringProperty();
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
