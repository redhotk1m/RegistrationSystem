package org.openjfx;

import javafx.collections.ObservableList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



public class mCSVWriter extends FileHandler{

    FileWriter fileWriter;
    @Override
    public void saveFile(File file, ObservableList data, String tableClassType) {
        try {
            fileWriter =  new FileWriter(file);
            String typeOfObject = tableClassType;
            fileWriter.write(tableClassType + ";");
            fileWriter.write(data.size() +";" + "\n");
            switch (tableClassType){
                case "Clients":
                    saveClient(data);
                    break;
                case "Skademelding":
                    saveSkademelding(data);
                    break;
                case "BoatInsurance":
                    saveBoatInsurance(data);
                    break;
                case "HouseholdInsurance":
                    saveHouseholdInsurance(data);
                    break;
                case "ExtraHouse":
                    saveExtraHouse(data);
                    break;
                case "TravelingInsurance":
                    saveTravelInsurance(data);
                    break;

                default:
                    throw new NullPointerException("noe");
            }
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveClient(ObservableList data) {
        ObservableList<mdClients> a = data;
        for (mdClients datum : a) {
            try {
                fileWriter.write(datum.getDateCreated() + ";");
                fileWriter.write(datum.getFirstName() + ";");
                fileWriter.write(datum.getLastName() + ";");
                fileWriter.write(datum.getAdress() + ";");
                fileWriter.write(datum.getForsikringsNR() + ";");
                fileWriter.write(datum.getForsikringer() + ";");
                fileWriter.write(datum.getSkademeldinger() + ";");
                fileWriter.write(datum.getUbetalt() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveSkademelding(ObservableList data) {
        ObservableList<mdSkademelding> a = data;
        for (mdSkademelding datum : a) {
            try {
                fileWriter.write(datum.getSMDato() + ";");
                fileWriter.write(datum.getSkadeNR() + ";");
                fileWriter.write(datum.getSkadeType() + ";");
                fileWriter.write(datum.getSkadeBeskrivelse() + ";");
                fileWriter.write(datum.getVitneKontaktInfo() + ";");
                fileWriter.write(datum.getTakseringsBeloep() + ";");
                fileWriter.write(datum.getErstatningsBeloep() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveBoatInsurance(ObservableList data) {
        ObservableList<BoatInsurance> a = data;
        for (BoatInsurance datum : a) {
            try {
                fileWriter.write(datum.getDateCreated() + ";");
                fileWriter.write(datum.getOwner() + ";");
                fileWriter.write(datum.getInsurancePrice() + ";");
                fileWriter.write(datum.getInsuranceAmount() + ";");
                fileWriter.write(datum.getInsuranceConditions() + ";");
                fileWriter.write(datum.getRegNr() + ";");
                fileWriter.write(datum.getTypeModel() + ";");
                fileWriter.write(datum.getLength() + ";");
                fileWriter.write(datum.getYear() + ";");
                fileWriter.write(datum.getMotorType() + ";");
                fileWriter.write(datum.getMotorStrength() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }




    private void saveHouseholdInsurance(ObservableList data) {
        ObservableList<HouseholdInsurance> a = data;
        for (HouseholdInsurance datum : a) {
            try {
                fileWriter.write(datum.getAdress() + ";");
                fileWriter.write(datum.getInsurancePrice() + ";");
                fileWriter.write(datum.getDateCreated() + ";");
                fileWriter.write(datum.getInsuranceAmount() + ";");
                fileWriter.write(datum.getInsuranceConditions() + ";");
                fileWriter.write(datum.getConstructionYear() + ";");
                fileWriter.write(datum.getResidentialType() + ";");
                fileWriter.write(datum.getMaterials() + ";");
                fileWriter.write(datum.getStandard() + ";");
                fileWriter.write(datum.getSqMeters() + ";");
                fileWriter.write(datum.getBuildingInsuranceAmount() + ";");
                fileWriter.write(datum.getContentInsuranceAmount() + "\n");

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveExtraHouse(ObservableList data) {
        ObservableList<SuperHouseInsurance> a = data;
        for (SuperHouseInsurance datum : a) {
            try {
                fileWriter.write(datum.getAdress() + ";");
                fileWriter.write(datum.insurancePriceProperty() + ";");
                fileWriter.write(datum.getDateCreated() + ";");
                fileWriter.write(datum.getInsuranceAmount() + ";");
                fileWriter.write(datum.getInsuranceConditions() + ";");
                fileWriter.write(datum.getConstructionYear() + ";");
                fileWriter.write(datum.getResidentialType() + ";");
                fileWriter.write(datum.getMaterials() + ";");
                fileWriter.write(datum.getStandard() + ";");
                fileWriter.write(datum.getSqMeters() + ";");
                fileWriter.write(datum.getBuildingInsuranceAmount() + ";");
                fileWriter.write(datum.getContentInsuranceAmount() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void saveTravelInsurance(ObservableList data) {
        ObservableList<TravelingInsurance> a = data;
        for (TravelingInsurance datum : a) {
            try {
                fileWriter.write(datum.getDateCreated() + ";");
                fileWriter.write(datum.getInsuranceAmount() + ";");
                fileWriter.write(datum.getDateCreated() + ";");
                fileWriter.write(datum.getInsurancePrice() + ";");
                fileWriter.write(datum.getInsuranceConditions() + ";");
                fileWriter.write(datum.getInsuranceConditions() + "\n");


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }







}
