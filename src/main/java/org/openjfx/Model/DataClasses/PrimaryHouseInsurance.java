package org.openjfx.Model.DataClasses;

public class PrimaryHouseInsurance extends HouseInsurance {



    public PrimaryHouseInsurance() {
    }

    public PrimaryHouseInsurance(String address, String premium, String date, String price, String conditions,
                                 String constructionYear, String residentialType, String materials, String SqMeters,
                                 String buildingInsuranceAmount, String contentInsuranceAmount){
        super(address, premium, date, price, conditions,constructionYear,residentialType,materials,SqMeters,
                buildingInsuranceAmount,contentInsuranceAmount);
    }

}
