package org.openjfx.Model.DataClasses;

public class PrimaryHouseInsurance extends HouseInsurance {


    public PrimaryHouseInsurance(){

    }

    public PrimaryHouseInsurance(String address, String premium, String date, String price, String conditions,
                                 String constructionYear, String residentialType, String materials, String standard,String SquareMeters,
                                 String buildingInsuranceAmount, String contentInsuranceAmount){
        super(address, premium, date, price, conditions,constructionYear,residentialType,materials,standard,SquareMeters,
                buildingInsuranceAmount,contentInsuranceAmount);
    }

}
