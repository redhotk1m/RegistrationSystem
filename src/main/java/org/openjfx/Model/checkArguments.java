package org.openjfx.Model;

import org.openjfx.EmptyTableException;

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
                throw new EmptyTableException("Noe galt med string");
            }
        }
    }


    public void streetTest(String s) throws EmptyTableException {
        checkIfNull(s);
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (!Character.isLetter(c) && !Character.isWhitespace(c) && !Character.isDigit(c)) {
                throw new EmptyTableException("Noe galt med Street");
            }
        }
    }


    public void dateTest(String s) throws EmptyTableException {
        checkIfNull(s);
        DateFormat format = new SimpleDateFormat("dd.MM.yy");


        try {
            format.parse(s);

        } catch (ParseException e) {
            throw new EmptyTableException("Noe galt med dato");
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
            System.out.println("FEILMELDING");
            //throw new NullPointerException("Strengen eksisterer ikke");
            //Thrower ikke fordi den aldri får nullpointer?
            //TODO Fiks dette, sånn at objekter uten felter ikke blir laget, eller feilmelding gis
        }
    }
}
