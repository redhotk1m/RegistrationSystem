package org.openjfx.Model.DataClasses;

public class PrimaryHouseInsurance extends HouseInsurance {



    public PrimaryHouseInsurance() {
        initPrimaryHouseInsurance();
    }

    public PrimaryHouseInsurance(String address, String constructionYear, String residentialType, String materials, String SqMeters, String buildingInsuranceAmount, String contentInsuranceAmount){
        super(address,constructionYear,residentialType,materials,SqMeters,buildingInsuranceAmount,contentInsuranceAmount);
    }

    private void initPrimaryHouseInsurance(){

    }

}
