package org.openjfx;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;



public class checkArguments {

    public checkArguments() {
    }


    public boolean stringTest(String s) {
        checkIfNull(s);
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                return false;
            }
        }
        return true;
    }


    public boolean streetTest(String s) {
        checkIfNull(s);
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c) && !Character.isWhitespace(c) && !Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }


    public boolean dateTest(String s) {
        checkIfNull(s);
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        format.setLenient(false);

        try {
            format.parse(s);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }


    public boolean numberTest(String s){
        checkIfNull(s);
        if(s.matches("[0-9]*$"))
            return true;
        return false;
    }

    public void checkIfNull(String s){
        if (s == null || s.length() < 1){
            //throw new NullPointerException("Strengen eksisterer ikke");
            //TODO Fiks dette, sånn at objekter uten felter ikke blir laget, eller feilmelding gis
        }
    }
}
