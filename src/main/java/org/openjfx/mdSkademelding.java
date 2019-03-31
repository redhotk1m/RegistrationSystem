package org.openjfx;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Date;

public class mdSkademelding {

    private Date SMDato;
    private SimpleIntegerProperty SkadeNR;
    private SimpleStringProperty SkadeType; //????
    private SimpleStringProperty SkadeBeskrivelse;
    private SimpleStringProperty VitneKontaktInfo; // Egen klasse?
    private SimpleDoubleProperty TakseringsBeloep;
    private SimpleDoubleProperty ErstatningsBeloep;


    public mdSkademelding(Date SMDato, int skadeNR, String skadeType, String skadeBeskrivelse, String vitneKontaktInfo,
                          double takseringsBeloep, double erstatningsBeloep) {
        this.SMDato = SMDato;
        SkadeNR =  new SimpleIntegerProperty(skadeNR);
        SkadeType = new SimpleStringProperty(skadeType);
        SkadeBeskrivelse = new SimpleStringProperty(skadeBeskrivelse);
        VitneKontaktInfo = new SimpleStringProperty(vitneKontaktInfo);
        TakseringsBeloep = new SimpleDoubleProperty(takseringsBeloep);
        ErstatningsBeloep = new SimpleDoubleProperty(erstatningsBeloep);
    }

    // Gettere og settere

    public Date getSMDato() {
        return SMDato;
    }

    public void setSMDato(Date SMDato) {
        this.SMDato = SMDato;
    }

    public int getSkadeNR() {
        return SkadeNR.get();
    }

    public void setSkadeNR(int skadeNR) {
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

    public double getTakseringsBeloep() {
        return TakseringsBeloep.get();
    }

    public void setTakseringsBeloep(double takseringsBeloep) {
        this.TakseringsBeloep.set(takseringsBeloep);
    }

    public double getErstatningsBeloep() {
        return ErstatningsBeloep.get();
    }

    public void setErstatningsBeloep(double erstatningsBeloep) { this.ErstatningsBeloep.set(erstatningsBeloep);
    }
}
