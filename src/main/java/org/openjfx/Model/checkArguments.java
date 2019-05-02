package org.openjfx.Model;

import javafx.application.Platform;
import org.openjfx.EmptyTableException;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;



public class checkArguments {

    public checkArguments() {
    }

    public void stringTest(String s) throws EmptyTableException {
        checkIfNull(s);
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c) && !Character.isWhitespace(c)) {
                throw new EmptyTableException("Feil i StringTest");

            }
        }
    }


    public void streetTest(String s) throws  EmptyTableException {
        checkIfNull(s);
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c) && !Character.isWhitespace(c) && !Character.isDigit(c)) {
                throw new EmptyTableException("Gateadresse er feil");
            }
        }
    }


    public void dateTest(String s) throws EmptyTableException {
        checkIfNull(s);
        DateFormat format = new SimpleDateFormat("dd.MM.yy");
        try {
            format.parse(s);
        } catch (ParseException e) {
            throw new EmptyTableException("Date test");
        }
    }


    public void numberTest(String s) throws EmptyTableException{
        checkIfNull(s);
        if(!s.matches("[0-9]*$"))
            throw new EmptyTableException("Nummertest feilet");
    }

    public void checkIfNull(String s) throws EmptyTableException {
        if (s == null || s.length() < 1){
            throw new EmptyTableException("Field cannot be empty");
            //throw new NullPointerException("Strengen eksisterer ikke");
            //Thrower ikke fordi den aldri får nullpointer?
            //TODO Fiks dette, sånn at objekter uten felter ikke blir laget, eller feilmelding gis
        }
    }
}
