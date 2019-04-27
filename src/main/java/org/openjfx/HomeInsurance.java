package org.openjfx;

import java.util.Date;

public class HomeInsurance extends SuperHouseInsurance {

    public HomeInsurance() {

    }

    HomeInsurance(String insurancePrice, String dateCreated, String insuranceAmount, String insuranceConditions,
                  String adress, String constructionYear, String residentalType, String materials, String standard,
                  String SqMeters, String buildingInsuranceAmount, String housingInsuranceAmount) {
        super(insurancePrice, dateCreated, insuranceAmount, insuranceConditions, adress, constructionYear,
                residentalType, materials, standard, SqMeters, buildingInsuranceAmount, housingInsuranceAmount);
    }
}
