package org.openjfx;

import java.util.Date;

public class HouseInsurance extends SuperHouseInsurance {


    HouseInsurance(int insurancePrice, Date dateCreated, int insuranceAmount, String insuranceConditions, String adress,
                   int constructionYear, String residentalType, String materials, String standard, double SqMeters,
                   double buildingInsuranceAmount, double housingInsuranceAmount) {
        super(insurancePrice, dateCreated, insuranceAmount, insuranceConditions, adress, constructionYear,
                residentalType, materials, standard, SqMeters, buildingInsuranceAmount, housingInsuranceAmount);
    }
}

