package org.openjfx.Model.DataClasses;

public class PrimaryHouseInsurance extends HouseInsurance {


    public PrimaryHouseInsurance(){

    }

    public PrimaryHouseInsurance(String insurancePremium, String dateCreated, String insurancePrice,
                                 String insuranceConditions, String address, String constructionYear,
                                 String residentialType, String materials, String standard,
                                 String squareMeters, String buildingInsuranceAmount, String contentInsuranceAmount){
        super(insurancePremium, dateCreated, insurancePrice, insuranceConditions, address, constructionYear,
                residentialType, materials, standard, squareMeters,
                buildingInsuranceAmount ,contentInsuranceAmount);
    }

}
