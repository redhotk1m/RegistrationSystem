package org.openjfx.Model.DataClasses;

import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DamageReport implements Serializable {

    private transient SimpleStringProperty  dateOfDamage,
                                            reportNumber,
                                            typeOfDamage,
                                            damageDescription,
                                            witnessContactInfo,
                                            assessmentAmount,
                                            paidCompensation;

    public DamageReport() {
        initProperties();
    }

    private void initProperties(){
        this.dateOfDamage = new SimpleStringProperty();
        this.reportNumber = new SimpleStringProperty();
        this.typeOfDamage = new SimpleStringProperty();
        this.damageDescription = new SimpleStringProperty();
        this.witnessContactInfo = new SimpleStringProperty();
        this.assessmentAmount = new SimpleStringProperty();
        this.paidCompensation = new SimpleStringProperty();
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.writeUTF(dateOfDamage.getValueSafe());
        s.writeUTF(reportNumber.getValueSafe());
        s.writeUTF(typeOfDamage.getValueSafe());
        s.writeUTF(damageDescription.getValueSafe());
        s.writeUTF(witnessContactInfo.getValueSafe());
        s.writeUTF(assessmentAmount.getValueSafe());
        s.writeUTF(paidCompensation.getValueSafe());
    }

    private void readObject(ObjectInputStream s) throws IOException{
        initProperties();
        dateOfDamage.set(s.readUTF());
        reportNumber.set(s.readUTF());
        typeOfDamage.set(s.readUTF());
        damageDescription.set(s.readUTF());
        witnessContactInfo.set(s.readUTF());
        assessmentAmount.set(s.readUTF());
        paidCompensation.set(s.readUTF());
    }


    // Gettere og settere

    public String getDateOfDamage() {
        return dateOfDamage.get();
    }

    public void setDateOfDamage(String dateOfDamage) {
        this.dateOfDamage.set(dateOfDamage);
    }

    public String getReportNumber() {
        return reportNumber.get();
    }

    public void setReportNumber(String reportNumber) {
        this.reportNumber.set(reportNumber);
    }

    public String getTypeOfDamage() {
        return typeOfDamage.get();
    }

    public void setTypeOfDamage(String typeOfDamage) {
        this.typeOfDamage.set(typeOfDamage);
    }

    public String getDamageDescription() {
        return damageDescription.get();
    }

    public void setDamageDescription(String damageDescription) {
        this.damageDescription.set(damageDescription);
    }

    public String getWitnessContactInfo() {
        return witnessContactInfo.get();
    }

    public void setWitnessContactInfo(String witnessContactInfo) { this.witnessContactInfo.set(witnessContactInfo);
    }

    public String getAssessmentAmount() {
        return assessmentAmount.get();
    }

    public void setAssessmentAmount(String assessmentAmount) {
        this.assessmentAmount.set(assessmentAmount);
    }

    public String getPaidCompensation() {
        return paidCompensation.get();
    }

    public void setPaidCompensation(String paidCompensation) { this.paidCompensation.set(paidCompensation);
    }
}
