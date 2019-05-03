package org.openjfx.Model.ReadAndWrite;

import javafx.collections.ObservableList;
import org.openjfx.Model.DataClasses.*;
import org.openjfx.Model.ErrorMessage;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;



public class CSVWriter extends FileHandler{

    FileWriter fileWriter;
    @Override
    public void saveFile(File file, ObservableList data, String tableClassType) {
        //Lagrer filen, ettersom hvilken klasse som skal lagres
        try {
            //Skriver de to første linjene, klassetype og hvor mange objekter filen skal inneholde
            fileWriter =  new FileWriter(file);
            fileWriter.write(tableClassType + ";");
            fileWriter.write(data.size() +";" + "\n");
            switch (tableClassType){
                case "Clients":
                    saveClient(data); //Lagrer client, setter alle feltene som trengs
                    break;
                case "DamageReport":
                    saveDamageReport(data); //Samme som client, bare andre felt
                    break;
                case "BoatInsurance":
                    saveBoatInsurance(data);
                    break;
                case "PrimaryHouseInsurance":
                    savePrimaryHouseInsurance(data);
                    break;
                case "SecondaryHouseInsurance":
                    saveSecondaryHouseInsurance(data);
                    break;
                case "TravelInsurance":
                    saveTravelInsurance(data);
                    break;
                default:
                    //Error popup som sier ifra at det er noe galt
                    new ErrorMessage("Error saving the file");
            }
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveClient(ObservableList data) {
        ObservableList<Clients> a = data;
        for (Clients datum : a) {
            try {
                fileWriter.write(datum.getDateCreated() + ";");
                fileWriter.write(datum.getFirstName() + ";");
                fileWriter.write(datum.getLastName() + ";");
                fileWriter.write(datum.getAddress() + ";");
                fileWriter.write(datum.getInsuranceNumber() + ";");
                fileWriter.write(datum.getInsurances() + ";");
                fileWriter.write(datum.getDamageReports() + ";");
                fileWriter.write(datum.getUnpaid() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    private void saveDamageReport(ObservableList data) {
        ObservableList<DamageReport> a = data;
        for (DamageReport datum : a) {
            try {
                fileWriter.write(datum.getDateOfDamage() + ";");
                fileWriter.write(datum.getReportNumber() + ";");
                fileWriter.write(datum.getTypeOfDamage() + ";");
                fileWriter.write(datum.getDamageDescription() + ";");
                fileWriter.write(datum.getWitnessContactInfo() + ";");
                fileWriter.write(datum.getAssessmentAmount() + ";");
                fileWriter.write(datum.getPaidCompensation() + "\n");
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
                fileWriter.write(datum.getInsurancePremium() + ";");
                fileWriter.write(datum.getInsurancePrice() + ";");
                fileWriter.write(datum.getInsuranceConditions() + ";");
                fileWriter.write(datum.getLicenseNumber() + ";");
                fileWriter.write(datum.getTypeModel() + ";");
                fileWriter.write(datum.getLength() + ";");
                fileWriter.write(datum.getYearModel() + ";");
                fileWriter.write(datum.getMotorType() + ";");
                fileWriter.write(datum.getMotorStrength() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveSecondaryHouseInsurance(ObservableList data) {
        ObservableList<SecondaryHouseInsurance> a = data;
        for (SecondaryHouseInsurance datum : a) {
            try {
                fileWriter.write(datum.getAddress() + ";");
                fileWriter.write(datum.getInsurancePrice() + ";");
                fileWriter.write(datum.getDateCreated() + ";");
                fileWriter.write(datum.getInsurancePrice() + ";");
                fileWriter.write(datum.getInsuranceConditions() + ";");
                fileWriter.write(datum.getConstructionYear() + ";");
                fileWriter.write(datum.getResidentialType() + ";");
                fileWriter.write(datum.getMaterials() + ";");
                fileWriter.write(datum.getStandard() + ";");
                fileWriter.write(datum.getSquareMeters() + ";");
                fileWriter.write(datum.getBuildingInsuranceAmount() + ";");
                fileWriter.write(datum.getContentInsuranceAmount() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void savePrimaryHouseInsurance(ObservableList data) {
        ObservableList<PrimaryHouseInsurance> a = data;
        for (PrimaryHouseInsurance datum : a) {
            try {
                fileWriter.write(datum.getAddress() + ";");
                fileWriter.write(datum.getInsurancePrice() + ";");
                fileWriter.write(datum.getDateCreated() + ";");
                fileWriter.write(datum.getInsurancePrice() + ";");
                fileWriter.write(datum.getInsuranceConditions() + ";");
                fileWriter.write(datum.getConstructionYear() + ";");
                fileWriter.write(datum.getResidentialType() + ";");
                fileWriter.write(datum.getMaterials() + ";");
                fileWriter.write(datum.getStandard() + ";");
                fileWriter.write(datum.getSquareMeters() + ";");
                fileWriter.write(datum.getBuildingInsuranceAmount() + ";");
                fileWriter.write(datum.getContentInsuranceAmount() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private void saveTravelInsurance(ObservableList data) {
        ObservableList<TravelInsurance> a = data;
        for (TravelInsurance datum : a) {
            try {
                fileWriter.write(datum.getInsuranceArea() + ";");
                fileWriter.write(datum.getInsurancePremium() + ";");
                fileWriter.write(datum.getDateCreated() + ";");
                fileWriter.write(datum.getInsurancePrice() + ";");
                fileWriter.write(datum.getInsuranceConditions() + ";");
                fileWriter.write(datum.getInsuredFor() + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }







}
