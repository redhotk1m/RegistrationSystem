package org.openjfx.Model;



import org.openjfx.Model.DataClasses.*;

import java.security.InvalidParameterException;

public class ObjectCreator {
    Object object;
    checkArguments inputCheck = new checkArguments();

    ObjectCreator(){

    }


    private void createClient(String[] valuesOfObject){
            Clients clients = new Clients();
            if(inputCheck.dateTest(valuesOfObject[0]))
                clients.setDateCreated(valuesOfObject[0]);

            if(inputCheck.stringTest(valuesOfObject[1]))
                clients.setFirstName(valuesOfObject[1]);

            if(inputCheck.stringTest(valuesOfObject[2]))
                clients.setLastName(valuesOfObject[2]);

            if(inputCheck.streetTest(valuesOfObject[3]))
                clients.setAdress(valuesOfObject[3]);

            if(inputCheck.numberTest(valuesOfObject[4]))
                clients.setForsikringsNR(valuesOfObject[4]);

            if(inputCheck.numberTest(valuesOfObject[5]))
                clients.setForsikringer(valuesOfObject[5]);

            if(inputCheck.numberTest(valuesOfObject[6]))
                clients.setSkademeldinger(valuesOfObject[6]);

            if(inputCheck.numberTest(valuesOfObject[7]))
                clients.setUbetalt(valuesOfObject[7]);

            setObject(clients);
    }

    public void createObject(String typeOfObject, String[] valuesOfObject){
        switch (typeOfObject){
            case "Clients":
                createClient(valuesOfObject);
                break;
            case "BoatInsurance":
                createBoatInsurance(valuesOfObject);
                break;
            case "Skademelding":
                createSkademelding(valuesOfObject);
                break;
            case "HouseholdInsurance":
                createHouseInsurance(valuesOfObject);
                break;
            case "PrimaryHouseInsurance":
                System.out.println("gjør noe her");
                break;

            default:
                throw new InvalidParameterException("Feil ved innlasting");
        }
    }

    private void createSkademelding(String[] valuesOfObject) {
        Skademelding skademelding = new Skademelding();
        skademelding.setSMDato(valuesOfObject[0]);
        skademelding.setSkadeNR(valuesOfObject[1]);
        skademelding.setSkadeType(valuesOfObject[2]);
        skademelding.setSkadeBeskrivelse(valuesOfObject[3]);
        skademelding.setVitneKontaktInfo(valuesOfObject[4]);
        skademelding.setTakseringsBeloep(valuesOfObject[5]);
        skademelding.setErstatningsBeloep(valuesOfObject[6]);

        setObject(skademelding);
    }


    private void createBoatInsurance(String[] valuesOfObject) {
        BoatInsurance boatInsurance = new BoatInsurance();
        boatInsurance.setDateCreated(valuesOfObject[0]);
        boatInsurance.setOwner(valuesOfObject[1]);
        boatInsurance.setInsurancePrice(valuesOfObject[2]);
        boatInsurance.setInsuranceAmount(valuesOfObject[3]);
        boatInsurance.setInsuranceConditions(valuesOfObject[4]);
        boatInsurance.setRegNr(valuesOfObject[5]);
        boatInsurance.setTypeModel(valuesOfObject[6]);
        boatInsurance.setLength(valuesOfObject[7]);
        boatInsurance.setYear(valuesOfObject[8]);
        boatInsurance.setMotorType(valuesOfObject[9]);
        boatInsurance.setMotorStrength(valuesOfObject[10]);

        setObject(boatInsurance);
    }




    private void createHouseInsurance(String[] valuesOfObject) {
        SecondaryHouseInsurance houseInsurance = new SecondaryHouseInsurance();
        houseInsurance.setAdress(valuesOfObject[0]);
        houseInsurance.setInsurancePrice(valuesOfObject[1]);
        houseInsurance.setDateCreated(valuesOfObject[2]);
        houseInsurance.setInsuranceAmount(valuesOfObject[3]);
        houseInsurance.setInsuranceConditions(valuesOfObject[4]);
        houseInsurance.setConstructionYear(valuesOfObject[5]);
        houseInsurance.setResidentialType(valuesOfObject[6]);
        houseInsurance.setMaterials(valuesOfObject[7]);
        houseInsurance.setStandard(valuesOfObject[8]);
        houseInsurance.setSqMeters(valuesOfObject[9]);
        houseInsurance.setBuildingInsuranceAmount(valuesOfObject[10]);
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
