package org.openjfx;

import javafx.beans.property.SimpleIntegerProperty;
import java.util.Date;

public class Insurances {
    private SimpleIntegerProperty insurancePrice;
    private Date dateCreated;
    private SimpleIntegerProperty insuranceAmount;
    //forsikringsbetingelser ?

    Insurances(int insurancePrice, Date dateCreated, int insuranceAmount) {
        this.insurancePrice = new SimpleIntegerProperty(insurancePrice);
        this.dateCreated = dateCreated;
        this.insuranceAmount = new SimpleIntegerProperty(insuranceAmount);
    }

    //getters and setters ?

}
