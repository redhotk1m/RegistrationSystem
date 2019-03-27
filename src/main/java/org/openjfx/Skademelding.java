package org.openjfx;

import java.util.Date;

public class Skademelding {

    private Date SMDato;
    private int SkadeNR;
    private String SkadeType; //????
    private String SkadeBeskrivelse;
    private String VitneKontaktInfo; // Egen klasse?
    private double TakseringsBeloep;
    private double ErstatningsBeloep;


    public Skademelding(Date SMDato, int skadeNR, String skadeType, String skadeBeskrivelse, String vitneKontaktInfo,
                        double takseringsBeloep, double erstatningsBeloep) {
        this.SMDato = SMDato;
        SkadeNR = skadeNR;
        SkadeType = skadeType;
        SkadeBeskrivelse = skadeBeskrivelse;
        VitneKontaktInfo = vitneKontaktInfo;
        TakseringsBeloep = takseringsBeloep;
        ErstatningsBeloep = erstatningsBeloep;
    }

    // Gettere og settere

    public Date getSMDato() {
        return SMDato;
    }

    public void setSMDato(Date SMDato) {
        this.SMDato = SMDato;
    }

    public int getSkadeNR() {
        return SkadeNR;
    }

    public void setSkadeNR(int skadeNR) {
        SkadeNR = skadeNR;
    }

    public String getSkadeType() {
        return SkadeType;
    }

    public void setSkadeType(String skadeType) {
        SkadeType = skadeType;
    }

    public String getSkadeBeskrivelse() {
        return SkadeBeskrivelse;
    }

    public void setSkadeBeskrivelse(String skadeBeskrivelse) {
        SkadeBeskrivelse = skadeBeskrivelse;
    }

    public String getVitneKontaktInfo() {
        return VitneKontaktInfo;
    }

    public void setVitneKontaktInfo(String vitneKontaktInfo) {
        VitneKontaktInfo = vitneKontaktInfo;
    }

    public double getTakseringsBeloep() {
        return TakseringsBeloep;
    }

    public void setTakseringsBeloep(double takseringsBeloep) {
        TakseringsBeloep = takseringsBeloep;
    }

    public double getErstatningsBeloep() {
        return ErstatningsBeloep;
    }

    public void setErstatningsBeloep(double erstatningsBeloep) {
        ErstatningsBeloep = erstatningsBeloep;
    }
}
