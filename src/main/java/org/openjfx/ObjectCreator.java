package org.openjfx;

import java.security.InvalidParameterException;

public class ObjectCreator {
    Object object;
    checkArguments inputCheck = new checkArguments();

    ObjectCreator(){

    }


    private void createClient(String[] valuesOfObject){
            mdClients clients = new mdClients();
        System.out.println(valuesOfObject[0]);
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

    public void createObject(String typeOfObject, int numberOfColumns, String[] valuesOfObject){
        switch (typeOfObject){
            case "Clients":
                createClient(valuesOfObject);
                break;
            case "Boatforsikring":
                //createBoatInsurance();
                break;
            case "Skademelding":
                createSkademelding(valuesOfObject);
                break;
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

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
