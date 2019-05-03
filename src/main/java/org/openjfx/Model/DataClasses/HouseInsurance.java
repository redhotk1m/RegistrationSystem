package org.openjfx.Model.DataClasses;

import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class HouseInsurance extends Insurances implements Serializable {

    private transient SimpleStringProperty  address,
                                            constructionYear,
                                            residentialType,
                                            materials,
                                            standard,
                                            squareMeters,
                                            buildingInsuranceAmount,
                                            contentInsuranceAmount;


    public HouseInsurance() {
        InitHouseInsurance();
    }

    public HouseInsurance(String insurancePremium, String dateCreated, String insurancePrice, String insuranceConditions, String address, String constructionYear, String residentialType, String materials, String standard,
                          String squareMeters, String buildingInsuranceAmount, String contentInsuranceAmount) {
        super(insurancePremium, dateCreated, insurancePrice, insuranceConditions);
        this.address = new SimpleStringProperty(address);
        this.constructionYear = new SimpleStringProperty(constructionYear);
        this.residentialType = new SimpleStringProperty(residentialType);
        this.materials = new SimpleStringProperty(materials);
        this.standard = new SimpleStringProperty(standard);
        this.squareMeters = new SimpleStringProperty(squareMeters);
        this.buildingInsuranceAmount = new SimpleStringProperty(buildingInsuranceAmount);
        this.contentInsuranceAmount = new SimpleStringProperty(contentInsuranceAmount);
    }

    private void InitHouseInsurance(){
        this.address = new SimpleStringProperty();
        this.constructionYear = new SimpleStringProperty();
        this.residentialType = new SimpleStringProperty();
        this.materials = new SimpleStringProperty();
        this.standard = new SimpleStringProperty();
        this.squareMeters = new SimpleStringProperty();
        this.buildingInsuranceAmount = new SimpleStringProperty();
        this.contentInsuranceAmount = new SimpleStringProperty();
    }

    private void writeObject(ObjectOutputStream s) throws IOException{
        s.defaultWriteObject();
        s.writeUTF(address.getValueSafe());
        s.writeUTF(constructionYear.getValueSafe());
        s.writeUTF(residentialType.getValueSafe());
        s.writeUTF(materials.getValueSafe());
        s.writeUTF(standard.getValueSafe());
        s.writeUTF(squareMeters.getValueSafe());
        s.writeUTF(buildingInsuranceAmount.getValueSafe());
        s.writeUTF(contentInsuranceAmount.getValueSafe());
    }
    private void readObject(ObjectInputStream s) throws IOException{
        InitHouseInsurance();
        address.set(s.readUTF());
        constructionYear.set(s.readUTF());
        residentialType.set(s.readUTF());
        materials.set(s.readUTF());
        standard.set(s.readUTF());
        squareMeters.set(s.readUTF());
        buildingInsuranceAmount.set(s.readUTF());
        contentInsuranceAmount.set(s.readUTF());
    }



    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getConstructionYear() {
        return constructionYear.get();
    }

    public SimpleStringProperty constructionYearProperty() {
        return constructionYear;
    }

    public void setConstructionYear(String constructionYear) {
        this.constructionYear.set(constructionYear);
    }

    public String getResidentialType() {
        return residentialType.get();
    }

    public SimpleStringProperty residentialTypeProperty() {
        return residentialType;
    }

    public void setResidentialType (String residentialType) {
        this.residentialType.set(residentialType);
    }

    public String getMaterials() {
        return materials.get();
    }

    public SimpleStringProperty materialsProperty() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials.set(materials);
    }

    public String getStandard() {
        return standard.get();
    }

    public SimpleStringProperty standardProperty() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard.set(standard);
    }

    public String getSquareMeters() {
        return squareMeters.get();
    }

    public SimpleStringProperty squareMetersProperty() {
        return squareMeters;
    }

    public void setSquareMeters(String squareMeters) {
        this.squareMeters.set(squareMeters);
    }

    public String getBuildingInsuranceAmount() {
        return buildingInsuranceAmount.get();
    }

    public SimpleStringProperty buildingInsuranceAmountProperty() {
        return buildingInsuranceAmount;
    }

    public void setBuildingInsuranceAmount(String buildingInsuranceAmount) {
        this.buildingInsuranceAmount.set(buildingInsuranceAmount);
    }

    public String getContentInsuranceAmount() {
        return contentInsuranceAmount.get();
    }

    public SimpleStringProperty housingInsuranceAmountProperty() {
        return contentInsuranceAmount;
    }

    public void setContentInsuranceAmount(String housingInsuranceAmount) {
        this.contentInsuranceAmount.set(housingInsuranceAmount);
    }
}
