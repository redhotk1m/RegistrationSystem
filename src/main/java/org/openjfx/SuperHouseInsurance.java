package org.openjfx;

import javafx.beans.property.SimpleStringProperty;

public class SuperHouseInsurance extends Insurances{
    private SimpleStringProperty adress;
    private SimpleStringProperty constructionYear;
    private SimpleStringProperty residentialType;
    private SimpleStringProperty materials;
    private SimpleStringProperty standard; // - hva er det??
    private SimpleStringProperty SqMeters;
    private SimpleStringProperty buildingInsuranceAmount;
    private SimpleStringProperty contentInsuranceAmount;

    public SuperHouseInsurance() {
        this.adress = new SimpleStringProperty();
        this.constructionYear = new SimpleStringProperty();
        this.residentialType = new SimpleStringProperty();
        this.materials = new SimpleStringProperty();
        this.standard = new SimpleStringProperty();
        this.SqMeters = new SimpleStringProperty();
        this.buildingInsuranceAmount = new SimpleStringProperty();
        this.contentInsuranceAmount = new SimpleStringProperty();
    }

    SuperHouseInsurance(String insurancePrice, String dateCreated, String insuranceAmount, String insuranceConditions,
                        String adress, String constructionYear, String residentialType, String materials, String standard,
                        String SqMeters, String buildingInsuranceAmount, String contentInsuranceAmount) {
        super(insurancePrice, dateCreated, insuranceAmount, insuranceConditions);
        this.adress = new SimpleStringProperty(adress);
        this.constructionYear = new SimpleStringProperty(constructionYear);
        this.residentialType = new SimpleStringProperty(residentialType);
        this.materials = new SimpleStringProperty(materials);
        this.standard = new SimpleStringProperty(standard);
        this.SqMeters = new SimpleStringProperty(SqMeters);
        this.buildingInsuranceAmount = new SimpleStringProperty(buildingInsuranceAmount);
        this.contentInsuranceAmount = new SimpleStringProperty(contentInsuranceAmount);
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

    public String getSqMeters() {
        return SqMeters.get();
    }

    public SimpleStringProperty sqMetersProperty() {
        return SqMeters;
    }

    public void setSqMeters(String sqMeters) {
        this.SqMeters.set(sqMeters);
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
