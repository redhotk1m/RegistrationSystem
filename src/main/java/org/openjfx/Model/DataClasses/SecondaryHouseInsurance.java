package org.openjfx.Model.DataClasses;

public class SecondaryHouseInsurance extends HouseInsurance {



    public SecondaryHouseInsurance() {
        initSecondaryHouseInsurance();
    }

    public SecondaryHouseInsurance(String insurancePrice, String dateCreated, String insuranceAmount,
                                   String insuranceConditions, String address, String constructionYear,
                                   String residentialType, String materials, String standard, String SqMeters,
                                   String buildingInsuranceAmount, String contentInsuranceAmount){
        super(insurancePrice, dateCreated, insuranceAmount, insuranceConditions, address,constructionYear,
                residentialType,materials, standard, SqMeters,buildingInsuranceAmount,contentInsuranceAmount);
    }

    private void initSecondaryHouseInsurance(){

    }








}

