package org.openjfx;

import java.security.InvalidParameterException;

public class ObjectCreator {
    Object object;
    checkArguments inputCheck = new checkArguments();

    ObjectCreator(){

    }


    private void createClient(String[] valuesOfObject){
            mdClients clients = new mdClients();
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
                createHouseholdInsurance(valuesOfObject);
                break;
            case "SuperHouseInsurance":
                createSuperHouseInsurance(valuesOfObject);


            default:
                throw new InvalidParameterException("Feil ved innlasting");
        }
    }

    private void createSkademelding(String[] valuesOfObject) {
        mdSkademelding mdSkademelding = new mdSkademelding();
        mdSkademelding.setSMDato(valuesOfObject[0]);
        mdSkademelding.setSkadeNR(valuesOfObject[1]);
        mdSkademelding.setSkadeType(valuesOfObject[2]);
        mdSkademelding.setSkadeBeskrivelse(valuesOfObject[3]);
        mdSkademelding.setVitneKontaktInfo(valuesOfObject[4]);
        mdSkademelding.setTakseringsBeloep(valuesOfObject[5]);
        mdSkademelding.setErstatningsBeloep(valuesOfObject[6]);

        setObject(mdSkademelding);
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




    private void createHouseholdInsurance(String[] valuesOfObject) {
        HouseholdInsurance householdInsurance = new HouseholdInsurance();
        householdInsurance.setAdress(valuesOfObject[0]);
        householdInsurance.setInsurancePrice(valuesOfObject[1]);
        householdInsurance.setDateCreated(valuesOfObject[2]);
        householdInsurance.setInsuranceAmount(valuesOfObject[3]);
        householdInsurance.setInsuranceConditions(valuesOfObject[4]);
        householdInsurance.setConstructionYear(valuesOfObject[5]);
        householdInsurance.setResidentialType(valuesOfObject[6]);
        householdInsurance.setMaterials(valuesOfObject[7]);
        householdInsurance.setStandard(valuesOfObject[8]);
        householdInsurance.setSqMeters(valuesOfObject[9]);
        householdInsurance.setBuildingInsuranceAmount(valuesOfObject[10]);
        householdInsurance.setContentInsuranceAmount(valuesOfObject[11]);



        setObject(householdInsurance);
    }


    private void createSuperHouseInsurance(String[] valuesOfObject) {
        SuperHouseInsurance superHouseInsurance = new SuperHouseInsurance();
        superHouseInsurance.setAdress(valuesOfObject[0]);
        superHouseInsurance.setInsurancePrice(valuesOfObject[1]);
        superHouseInsurance.setDateCreated(valuesOfObject[2]);
        superHouseInsurance.setInsuranceAmount(valuesOfObject[3]);
        superHouseInsurance.setInsuranceConditions(valuesOfObject[4]);
        superHouseInsurance.setConstructionYear(valuesOfObject[5]);
        superHouseInsurance.setResidentialType(valuesOfObject[6]);
        superHouseInsurance.setMaterials(valuesOfObject[7]);
        superHouseInsurance.setStandard(valuesOfObject[8]);
        superHouseInsurance.setSqMeters(valuesOfObject[9]);
        superHouseInsurance.setBuildingInsuranceAmount(valuesOfObject[10]);
        superHouseInsurance.setContentInsuranceAmount(valuesOfObject[11]);



        setObject(superHouseInsurance);
    }







    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
