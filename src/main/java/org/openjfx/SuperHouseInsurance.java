package org.openjfx;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class SuperHouseInsurance extends Insurances{
    private SimpleStringProperty adress;
    private SimpleIntegerProperty constructionYear;
    private SimpleStringProperty residentialType;
    private SimpleStringProperty materials;
    private SimpleStringProperty standard; // - hva er det??
    private SimpleDoubleProperty SqMeters;
    private SimpleDoubleProperty buildingInsuranceAmount;
    private SimpleDoubleProperty housingInsuranceAmount;

    SuperHouseInsurance(int insurancePrice, Date dateCreated, int insuranceAmount, String insuranceConditions,
                        String adress, int constructionYear, String residentialType, String materials, String standard,
                        double SqMeters, double buildingInsuranceAmount, double housingInsuranceAmount) {
        super(insurancePrice, dateCreated, insuranceAmount, insuranceConditions);
        this.adress = new SimpleStringProperty(adress);
        this.constructionYear = new SimpleIntegerProperty(constructionYear);
        this.residentialType = new SimpleStringProperty(residentialType);
        this.materials = new SimpleStringProperty(materials);
        this.standard = new SimpleStringProperty(standard);
        this.SqMeters = new SimpleDoubleProperty(SqMeters);
        this.buildingInsuranceAmount = new SimpleDoubleProperty(buildingInsuranceAmount);
        this.housingInsuranceAmount = new SimpleDoubleProperty(housingInsuranceAmount);
    }

    public String getAdress() {
        return adress.get();
    }

    public SimpleStringProperty adressProperty() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress.set(adress);
    }

    public int getConstructionYear() {
        return constructionYear.get();
    }

    public SimpleIntegerProperty constructionYearProperty() {
        return constructionYear;
    }

    public void setConstructionYear(int constructionYear) {
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

    public double getSqMeters() {
        return SqMeters.get();
    }

    public SimpleDoubleProperty sqMetersProperty() {
        return SqMeters;
    }

    public void setSqMeters(double sqMeters) {
        this.SqMeters.set(sqMeters);
    }

    public double getBuildingInsuranceAmount() {
        return buildingInsuranceAmount.get();
    }

    public SimpleDoubleProperty buildingInsuranceAmountProperty() {
        return buildingInsuranceAmount;
    }

    public void setBuildingInsuranceAmount(double buildingInsuranceAmount) {
        this.buildingInsuranceAmount.set(buildingInsuranceAmount);
    }

    public double getHousingInsuranceAmount() {
        return housingInsuranceAmount.get();
    }

    public SimpleDoubleProperty housingInsuranceAmountProperty() {
        return housingInsuranceAmount;
    }

    public void setHousingInsuranceAmount(double housingInsuranceAmount) {
        this.housingInsuranceAmount.set(housingInsuranceAmount);
    }
}
