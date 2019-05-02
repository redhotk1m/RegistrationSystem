package org.openjfx.Model.DataClasses;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class Skademelding implements Serializable {

    private transient SimpleStringProperty  SMDato,
                                            SkadeNR,
                                            SkadeType,
                                            SkadeBeskrivelse,
                                            VitneKontaktInfo,
                                            TakseringsBeloep,
                                            ErstatningsBeloep;

    public Skademelding() {
        initProperties();
    }

    private void initProperties(){
        this.SMDato = new SimpleStringProperty();
        this.SkadeNR = new SimpleStringProperty();
        this.SkadeType = new SimpleStringProperty();
        this.SkadeBeskrivelse = new SimpleStringProperty();
        this.VitneKontaktInfo = new SimpleStringProperty();
        this.TakseringsBeloep = new SimpleStringProperty();
        this.ErstatningsBeloep = new SimpleStringProperty();
    }

    private void writeObject(ObjectOutputStream s) throws IOException {
        s.writeUTF(SMDato.getValueSafe());
        s.writeUTF(SkadeNR.getValueSafe());
        s.writeUTF(SkadeType.getValueSafe());
        s.writeUTF(SkadeBeskrivelse.getValueSafe());
        s.writeUTF(VitneKontaktInfo.getValueSafe());
        s.writeUTF(TakseringsBeloep.getValueSafe());
        s.writeUTF(ErstatningsBeloep.getValueSafe());
    }

    private void readObject(ObjectInputStream s) throws IOException{
        initProperties();
        SMDato.set(s.readUTF());
        SkadeNR.set(s.readUTF());
        SkadeType.set(s.readUTF());
        SkadeBeskrivelse.set(s.readUTF());
        VitneKontaktInfo.set(s.readUTF());
        TakseringsBeloep.set(s.readUTF());
        ErstatningsBeloep.set(s.readUTF());
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
