package org.openjfx.Model;



import javafx.application.Platform;
import org.openjfx.Exceptions.EmptyTableException;
import org.openjfx.Model.DataClasses.*;

import java.io.IOException;
import java.security.InvalidParameterException;

public class ObjectCreator {
    Object object;
    checkArguments inputCheck = new checkArguments();

    ObjectCreator(){

    }
    checkArguments checker = new checkArguments();


    public void createObject(String typeOfObject, String[] valuesOfObject) throws EmptyTableException {
        switch (typeOfObject){
            case "Clients":
                createClient(valuesOfObject);
                break;
            case "BoatInsurance":
                createBoatInsurance(valuesOfObject);
                break;
            case "DamageReport":
                createDamageReport(valuesOfObject);
                break;
            case "PrimaryHouseInsurance":
                createPrimaryHouseInsurance(valuesOfObject);
                break;
            case "SecondaryHouseInsurance":
                createHouseInsurance(valuesOfObject);
                break;
            case "TravelInsurance":
                createTravelInsurance(valuesOfObject);
                break;
            default:
                throw new EmptyTableException("Error loading the file, the file is corrupt");
        }
    }


    private void createClient(String[] valuesOfObject) throws EmptyTableException {
        Clients clients = new Clients();

        checker.dateTest(valuesOfObject[0]);
        clients.setDateCreated(valuesOfObject[0]);

        checker.stringTest(valuesOfObject[1]);
        clients.setFirstName(valuesOfObject[1]);

        checker.stringTest(valuesOfObject[2]);
        clients.setLastName(valuesOfObject[2]);

        checker.streetTest(valuesOfObject[3]);
        clients.setAddress(valuesOfObject[3]);

        checker.numberTest(valuesOfObject[4]);
        clients.setInsuranceNumber(valuesOfObject[4]);

        checker.stringTest(valuesOfObject[5]);
        clients.setInsurances(valuesOfObject[5]);

        checker.stringTest(valuesOfObject[6]);
        clients.setDamageReports(valuesOfObject[6]);

        checker.numberTest(valuesOfObject[7]);
        clients.setUnpaid(valuesOfObject[7]);

        setObject(clients);
    }


    private void createPrimaryHouseInsurance(String[] valuesOfObject) throws EmptyTableException {
        PrimaryHouseInsurance houseInsurance = new PrimaryHouseInsurance();
        checker.streetTest(valuesOfObject[0]);
        houseInsurance.setAddress(valuesOfObject[0]);

        checker.numberTest(valuesOfObject[1]);
        houseInsurance.setInsurancePremium(valuesOfObject[1]);

        checker.dateTest(valuesOfObject[2]);
        houseInsurance.setDateCreated(valuesOfObject[2]);

        checker.numberTest(valuesOfObject[3]);
        houseInsurance.setInsurancePrice(valuesOfObject[3]);

        checker.stringTest(valuesOfObject[4]);
        houseInsurance.setInsuranceConditions(valuesOfObject[4]);

        checker.numberTest(valuesOfObject[5]);
        houseInsurance.setConstructionYear(valuesOfObject[5]);

        checker.stringTest(valuesOfObject[6]);
        houseInsurance.setResidentialType(valuesOfObject[6]);

        checker.stringTest(valuesOfObject[7]);
        houseInsurance.setMaterials(valuesOfObject[7]);

        checker.stringTest(valuesOfObject[8]);
        houseInsurance.setStandard(valuesOfObject[8]);

        checker.numberTest(valuesOfObject[9]);
        houseInsurance.setSquareMeters(valuesOfObject[9]);

        checker.numberTest(valuesOfObject[10]);
        houseInsurance.setBuildingInsuranceAmount(valuesOfObject[10]);

        checker.numberTest(valuesOfObject[11]);
        houseInsurance.setContentInsuranceAmount(valuesOfObject[11]);

        setObject(houseInsurance);
    }

    private void createDamageReport(String[] valuesOfObject) throws EmptyTableException {
        DamageReport damageReport = new DamageReport();
        checker.dateTest(valuesOfObject[0]);
        damageReport.setDateOfDamage(valuesOfObject[0]);

        checker.numberTest(valuesOfObject[1]);
        damageReport.setReportNumber(valuesOfObject[1]);

        checker.stringTest(valuesOfObject[2]);
        damageReport.setTypeOfDamage(valuesOfObject[2]);

        checker.stringTest(valuesOfObject[3]);
        damageReport.setDamageDescription(valuesOfObject[3]);

        checker.stringTest(valuesOfObject[4]);
        damageReport.setWitnessContactInfo(valuesOfObject[4]);

        checker.numberTest(valuesOfObject[5]);
        damageReport.setAssessmentAmount(valuesOfObject[5]);

        checker.numberTest(valuesOfObject[6]);
        damageReport.setPaidCompensation(valuesOfObject[6]);

        setObject(damageReport);
    }

    private void createTravelInsurance(String[] valuesOfObject) throws EmptyTableException {
        TravelInsurance travelInsurance = new TravelInsurance();

        checker.stringTest(valuesOfObject[0]);
        travelInsurance.setInsuranceArea(valuesOfObject[0]);

        checker.numberTest(valuesOfObject[1]);
        travelInsurance.setInsurancePremium(valuesOfObject[1]);

        checker.dateTest(valuesOfObject[2]);
        travelInsurance.setDateCreated(valuesOfObject[2]);

        checker.numberTest(valuesOfObject[3]);
        travelInsurance.setInsurancePrice(valuesOfObject[3]);

        checker.stringTest(valuesOfObject[4]);
        travelInsurance.setInsuranceConditions(valuesOfObject[4]);

        checker.numberTest(valuesOfObject[5]);
        travelInsurance.setInsuredFor(valuesOfObject[5]);

        setObject(travelInsurance);


    }

        private void createBoatInsurance(String[] valuesOfObject) throws EmptyTableException {
        BoatInsurance boatInsurance = new BoatInsurance();
        checker.dateTest(valuesOfObject[0]);
        boatInsurance.setDateCreated(valuesOfObject[0]);

        checker.stringTest(valuesOfObject[1]);
        boatInsurance.setOwner(valuesOfObject[1]);

        checker.numberTest(valuesOfObject[2]);
        boatInsurance.setInsurancePremium(valuesOfObject[2]);

        checker.numberTest(valuesOfObject[3]);
        boatInsurance.setInsurancePrice(valuesOfObject[3]);

        checker.stringTest(valuesOfObject[4]);
        boatInsurance.setInsuranceConditions(valuesOfObject[4]);

        checker.numberTest(valuesOfObject[5]);
        boatInsurance.setLicenseNumber(valuesOfObject[5]);

        checker.stringTest(valuesOfObject[6]);
        boatInsurance.setTypeModel(valuesOfObject[6]);

        checker.numberTest(valuesOfObject[7]);
        boatInsurance.setLength(valuesOfObject[7]);

        checker.numberTest(valuesOfObject[8]);
        boatInsurance.setYearModel(valuesOfObject[8]);

        checker.stringTest(valuesOfObject[9]);
        boatInsurance.setMotorType(valuesOfObject[9]);

        checker.numberTest(valuesOfObject[10]);
        boatInsurance.setMotorStrength(valuesOfObject[10]);

        setObject(boatInsurance);
    }




    private void createHouseInsurance(String[] valuesOfObject) throws EmptyTableException {
        SecondaryHouseInsurance houseInsurance = new SecondaryHouseInsurance();

        checker.streetTest(valuesOfObject[0]);
        houseInsurance.setAddress(valuesOfObject[0]);

        checker.numberTest(valuesOfObject[1]);
        houseInsurance.setInsurancePremium(valuesOfObject[1]);

        checker.dateTest(valuesOfObject[2]);
        houseInsurance.setDateCreated(valuesOfObject[2]);

        checker.numberTest(valuesOfObject[3]);
        houseInsurance.setInsurancePrice(valuesOfObject[3]);

        checker.stringTest(valuesOfObject[4]);
        houseInsurance.setInsuranceConditions(valuesOfObject[4]);

        checker.numberTest(valuesOfObject[5]);
        houseInsurance.setConstructionYear(valuesOfObject[5]);

        checker.stringTest(valuesOfObject[6]);
        houseInsurance.setResidentialType(valuesOfObject[6]);

        checker.stringTest(valuesOfObject[7]);
        houseInsurance.setMaterials(valuesOfObject[7]);

        checker.stringTest(valuesOfObject[8]);
        houseInsurance.setStandard(valuesOfObject[8]);

        checker.numberTest(valuesOfObject[9]);
        houseInsurance.setSquareMeters(valuesOfObject[9]);

        checker.numberTest(valuesOfObject[10]);
        houseInsurance.setBuildingInsuranceAmount(valuesOfObject[10]);

        checker.numberTest(valuesOfObject[11]);
        houseInsurance.setContentInsuranceAmount(valuesOfObject[11]);

        setObject(houseInsurance);
    }



    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
