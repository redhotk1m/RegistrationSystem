package org.openjfx;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class mdSkademelding {

    private SimpleStringProperty SMDato;
    private SimpleStringProperty SkadeNR;
    private SimpleStringProperty SkadeType; //????
    private SimpleStringProperty SkadeBeskrivelse;
    private SimpleStringProperty VitneKontaktInfo; // Egen klasse?
    private SimpleStringProperty TakseringsBeloep;
    private SimpleStringProperty ErstatningsBeloep;


    public mdSkademelding(String SMDato, String skadeNR, String skadeType, String skadeBeskrivelse,
                          String vitneKontaktInfo, String takseringsBeloep, String erstatningsBeloep) {
        this.SMDato = new SimpleStringProperty(SMDato);
        SkadeNR =  new SimpleStringProperty(skadeNR);
        SkadeType = new SimpleStringProperty(skadeType);
        SkadeBeskrivelse = new SimpleStringProperty(skadeBeskrivelse);
        VitneKontaktInfo = new SimpleStringProperty(vitneKontaktInfo);
        TakseringsBeloep = new SimpleStringProperty(takseringsBeloep);
        ErstatningsBeloep = new SimpleStringProperty(erstatningsBeloep);
    }

    // Gettere og settere

    public String getSMDato() {
        return SMDato.get();
    }

    public void setSMDato(String SMDato) {
        this.SMDato.set(SMDato);
    }

    public String getSkadeNR() {
        return SkadeNR.get();
    }

    public void setSkadeNR(String skadeNR) {
        this.SkadeNR.set(skadeNR);
    }

    public String getSkadeType() {
        return SkadeType.get();
    }

    public void setSkadeType(String skadeType) {
        this.SkadeType.set(skadeType);
    }

    public String getSkadeBeskrivelse() {
        return SkadeBeskrivelse.get();
    }

    public void setSkadeBeskrivelse(String skadeBeskrivelse) {
        this.SkadeBeskrivelse.set(skadeBeskrivelse);
    }

    public String getVitneKontaktInfo() {
        return VitneKontaktInfo.get();
    }

    public void setVitneKontaktInfo(String vitneKontaktInfo) { this.VitneKontaktInfo.set(vitneKontaktInfo);
    }

    public String getTakseringsBeloep() {
        return TakseringsBeloep.get();
    }

    public void setTakseringsBeloep(String takseringsBeloep) {
        this.TakseringsBeloep.set(takseringsBeloep);
    }

    public String getErstatningsBeloep() {
        return ErstatningsBeloep.get();
    }

    public void setErstatningsBeloep(String erstatningsBeloep) { this.ErstatningsBeloep.set(erstatningsBeloep);
    }
}
